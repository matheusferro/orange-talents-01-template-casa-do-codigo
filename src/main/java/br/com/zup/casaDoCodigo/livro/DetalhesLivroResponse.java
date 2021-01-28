package br.com.zup.casaDoCodigo.livro;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DetalhesLivroResponse {

    //private Long id;
    private String titulo;
    private String resumo;
    private String sumario;
    private BigDecimal preco;
    private Integer numPaginas;
    private String isbn;
    private String dataPublicacao;

    private String nomeAutor;
    private String descAutor;

    public DetalhesLivroResponse(String titulo,
                                 String resumo,
                                 String sumario,
                                 BigDecimal preco,
                                 Integer numPaginas,
                                 String isbn,
                                 LocalDate dataPublicacao,
                                 String nomeAutor,
                                 String descAutor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numPaginas = numPaginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.nomeAutor = nomeAutor;
        this.descAutor = descAutor;
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

    public String getNomeAutor() {
        return nomeAutor;
    }

    public String getDescAutor() {
        return descAutor;
    }
}
