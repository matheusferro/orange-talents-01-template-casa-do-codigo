package br.com.zup.casaDoCodigo.categoria;

import br.com.zup.casaDoCodigo.anotacao.UniqueValue;

import javax.validation.constraints.NotBlank;

public class CategoriaForm {

    @NotBlank
    @UniqueValue(domainClass = Categoria.class, fieldName = "nome")
    private String nome;

    public String getNome() {
        return nome;
    }
}
