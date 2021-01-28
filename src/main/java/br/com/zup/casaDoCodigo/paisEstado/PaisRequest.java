package br.com.zup.casaDoCodigo.paisEstado;

import br.com.zup.casaDoCodigo.anotacao.UniqueValue;

import javax.validation.constraints.NotBlank;

public class PaisRequest {

    @NotBlank
    @UniqueValue(domainClass = Pais.class, fieldName = "nome")
    private String nome;

    public String getNome() {
        return nome;
    }
}
