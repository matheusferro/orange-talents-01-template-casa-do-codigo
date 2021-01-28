package br.com.zup.casaDoCodigo.paisEstado;


import br.com.zup.casaDoCodigo.anotacao.ExistsValue;
import br.com.zup.casaDoCodigo.anotacao.UniqueValue;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class EstadoRequest {

    @NotBlank
    @UniqueValue(domainClass = Estado.class, fieldName = "nome")
    private String nome;

    @NotNull
    @ExistsValue(domainClass = Pais.class, fieldName = "id")
    private Long idPais;

    public Estado toModel(EntityManager entityManager) {
        Pais pais= entityManager.find(Pais.class, idPais);
        return new Estado(nome, pais);
    }

    public String getNome() {
        return nome;
    }

    public Long getIdPais() {
        return idPais;
    }
}
