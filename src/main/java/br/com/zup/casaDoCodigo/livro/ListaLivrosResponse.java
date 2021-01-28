package br.com.zup.casaDoCodigo.livro;

import org.springframework.data.domain.Page;

public class ListaLivrosResponse {

    private Long id;
    private String titulo;

    public static Page<ListaLivrosResponse> convertToLivroResponse(Page<Livro> livrosCadastrados) {
        return livrosCadastrados.map(e -> new ListaLivrosResponse(e.getId(), e.getTitulo()));
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public ListaLivrosResponse(Long id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }
}
