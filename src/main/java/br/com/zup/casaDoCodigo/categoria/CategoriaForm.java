package br.com.zup.casaDoCodigo.categoria;

import br.com.zup.casaDoCodigo.anotacao.UniqueValue;
import br.com.zup.casaDoCodigo.categoria.anotacao.NomeUniqueValue;

import javax.validation.constraints.NotBlank;

public class CategoriaForm {

    @NotBlank
    @UniqueValue(domainClass = Categoria.class, fieldName = "nome")
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Categoria converterToCategoria() {
        return new Categoria(nome);
    }
}
