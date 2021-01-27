package br.com.zup.casaDoCodigo.livro;

import br.com.zup.casaDoCodigo.anotacao.ExistsValue;
import br.com.zup.casaDoCodigo.anotacao.UniqueValue;
import br.com.zup.casaDoCodigo.autor.Autor;
import br.com.zup.casaDoCodigo.categoria.Categoria;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class LivroForm {

    @NotBlank
    @NotNull
    @UniqueValue(domainClass = Livro.class, fieldName = "titulo")
    private String titulo;

    @NotBlank
    @NotNull
    @Length(max=500)
    private String resumo;

    @NotNull
    @Column(columnDefinition="TEXT")
    private String sumario;

    @NotNull
    @Min(20)
    private BigDecimal preco;

    @NotNull
    @Min(100)
    private Integer numPaginas;

    @NotBlank
    @NotNull
    @UniqueValue(domainClass = Livro.class, fieldName = "isbn")
    private String isbn;

    @Future
    @DateTimeFormat
    @JsonFormat(pattern="dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate dataPublicacao;

    @NotNull
    @NotBlank
    @ExistsValue(domainClass = Categoria.class, fieldName = "nome")
    private String nomeCategoria;

    @NotNull
    @NotBlank
    @Email
    @ExistsValue(domainClass = Autor.class, fieldName = "email")
    private String emailAutor;

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

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public String getEmailAutor() {
        return emailAutor;
    }

    public Livro converterToLivro(Categoria categoria, Autor autor) {
        return new Livro(titulo, resumo, sumario, preco, numPaginas, isbn, dataPublicacao, categoria, autor);
    }
}
