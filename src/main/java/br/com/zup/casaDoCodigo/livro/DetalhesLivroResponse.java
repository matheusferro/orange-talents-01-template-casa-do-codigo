package br.com.zup.casaDoCodigo.livro;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;

public class DetalhesLivroResponse {

    private String titulo;
    private String resumo;
    private String sumario;
    private BigDecimal preco;
    private Integer numPaginas;
    private String isbn;
    private String dataPublicacao;

    private DetalhesAutorSiteResponse autor;

    /**
     * Após ver a resolução do Alberto, o código foi refatorado.
     * Utiliza-se somente um parâmetro do tipo Livro,
     * foi criado uma variavel do tipo DetalhesAutorSiteResponse
     * onde é tratado os dados do autor.
     */
    public DetalhesLivroResponse(Livro livro) {
        this.titulo = livro.getTitulo();
        this.resumo = livro.getResumo();
        this.sumario = livro.getSumario();
        this.preco = livro.getPreco();
        this.numPaginas = livro.getNumPaginas();
        this.isbn = livro.getIsbn();
        this.dataPublicacao = livro.getDataPublicacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        autor = new DetalhesAutorSiteResponse(livro.getAutor());

    }

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public Integer getNumPaginas() {
        return numPaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getDataPublicacao() {
        return dataPublicacao;
    }

    public DetalhesAutorSiteResponse getAutor() {
        return autor;
    }
}
