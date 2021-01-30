package br.com.zup.casaDoCodigo.compra;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Component
public class ValidadorPaisEstado implements Validator {

    @PersistenceContext
    private EntityManager em;

    @Override
    public boolean supports(Class<?> clazz) {
        return CompraParcialRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if(errors.hasErrors()) {
            return;
        }

        CompraParcialRequest request = (CompraParcialRequest) target;
        /**
         *  CORREÇÃO:
         *
         *  PRIMEIRO É CONSULTADO SE EXISTE ESTADOS RELACIONADO COM O PAIS,
         *  CASO POSSUA ESTADOS É VERIFICADO A RELAÇÃO ENTRE PAIS E ESTADO.
         *
         */
        Query query = em.createQuery
                ("SELECT 1 FROM Estado e JOIN e.pais p WHERE e.pais.id = p.id and p.id = :pIdPais ");
        query.setParameter("pIdPais", request.getIdPais());

        boolean paisPossuiEstados = query.getResultList().size() > 0;
        if(paisPossuiEstados){
            //verifica se o estado pertence ao pais
            query = em.createQuery("SELECT 1 FROM Estado e WHERE e.pais.id = :pIdPais AND e.id = :pIdEstado ");
            query.setParameter("pIdPais", request.getIdPais());
            query.setParameter("pIdEstado", request.getIdEstado());
            boolean estadoNaoPertenceAoPais = query.getResultList().size() < 1;
            if(estadoNaoPertenceAoPais){
                errors.rejectValue("idEstado",null, "Estado não pertence ao País.");
            }
        }else if(request.getIdEstado() != null){
            errors.rejectValue("idEstado",null, "Esse país não possui estado.");
        }

    }
}
