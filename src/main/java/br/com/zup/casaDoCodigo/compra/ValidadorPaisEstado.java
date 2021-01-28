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

    public ValidadorPaisEstado(EntityManager entityManager) {
        this.em = entityManager;
    }

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
         *  VALIDAÇÃO É FEITA COM UMA QUERY SÓ.
         *
         *  CASO O PAIS NÃO TENHA ESTADO JÁ NOS RETORNARA NEHUM RESULTADO.
         *  CASO O PAIS TENHA ESTADO E NÃO FOI O SELECIONADO TAMBÉM RETORNARÁ NENHUM RESULTADO.
         */
        Query query = em.createQuery
                ("SELECT 1 FROM Estado e RIGHT JOIN e.pais p WHERE e.id = p.id and p.id = :pIdPais AND e.id = :pIdEstado");
        query.setParameter("pIdPais", request.getIdPais());
        query.setParameter("pIdEstado", request.getIdEstado());
        List<?> list = query.getResultList();
        if(list.size() < 1){
            errors.rejectValue("idEstado",null, "Selecione pais e estado corretamente.");
        }

    }
}
