package br.com.zup.casaDoCodigo.livro;

import br.com.zup.casaDoCodigo.autor.Autor;

/**
 * Classe para retornar nome e descrição de autor.
 */
public class DetalhesAutorSiteResponse{

    private String nome;
    private String descricao;

    public DetalhesAutorSiteResponse(Autor autor) {
        nome = autor.getNome();
        descricao = autor.getDescricao();
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }
}
