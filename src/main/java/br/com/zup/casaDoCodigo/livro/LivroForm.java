package br.com.zup.casaDoCodigo.livro;

import br.com.zup.casaDoCodigo.anotacao.ExistsValue;
import br.com.zup.casaDoCodigo.anotacao.UniqueValue;
import br.com.zup.casaDoCodigo.autor.Autor;
import br.com.zup.casaDoCodigo.categoria.Categoria;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.util.Assert;

import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Classe responsável por receber os dados.
 */
public class LivroForm {

    @NotBlank
    @UniqueValue(domainClass = Livro.class, fieldName = "titulo")
    private String titulo;

    @NotBlank
    @Length(max=500)
    private String resumo;

    @NotBlank
    @Column(columnDefinition="TEXT")
    private String sumario;

    @NotNull
    @Min(20)
    private BigDecimal preco;

    @NotNull
    @Min(100)
    private Integer numPaginas;

    @NotBlank
    @UniqueValue(domainClass = Livro.class, fieldName = "isbn")
    private String isbn;

    @Future
    @JsonFormat(pattern="dd/MM/yyyy")
    private LocalDate dataPublicacao;

    /**
     * Repensando, seria mais interessante pegar o Autor e Categoria
     * por Id. Já que em um Front-end provavelmente estariamos usando
     * combobox, e seria passado para a API o id selecionado
     */
    @NotNull
    @ExistsValue(domainClass = Autor.class, fieldName = "id")
    private Long idAutor;

    @NotNull
        @ExistsValue(domainClass = Categoria.class, fieldName = "id")
    private Long idCategoria;

    /**
     * Utilizar o construtor para não encher a classe com getters e setters.
     *
     * Após o check-in (28/01/2020), foi conversado sobre mapear o json recebido
     * nos parâmetros do construtor, para que o Jackson consiga associar os parâmetros
     * do JSON recebido com o construtor.
     *
     * @param titulo
     * @param resumo
     * @param sumario
     * @param preco
     * @param numPaginas
     * @param isbn
     * @param idAutor
     * @param idCategoria
     */
    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public LivroForm(@NotBlank @JsonProperty("titulo") String titulo,
                     @NotBlank @Length(max = 500) @JsonProperty("resumo") String resumo,
                     @NotBlank @JsonProperty("sumario") String sumario,
                     @NotNull @Min(20) @JsonProperty("preco") BigDecimal preco,
                     @NotNull @Min(100) @JsonProperty("numPaginas") Integer numPaginas,
                     @NotBlank @JsonProperty("isbn") String isbn,
                     @NotNull @JsonProperty("idAutor") Long idAutor,
                     @NotNull @JsonProperty("idCategoria") Long idCategoria) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numPaginas = numPaginas;
        this.isbn = isbn;
        this.idAutor = idAutor;
        this.idCategoria = idCategoria;
    }

    public Livro converterToLivro(EntityManager entityManager) {
        @NotNull Categoria categoria = entityManager.find(Categoria.class, idCategoria);
        @NotNull Autor autor = entityManager.find(Autor.class, idAutor);

        Assert.state(categoria != null, "É necessário cadastrar o livro com uma categoria existente.");
        Assert.state(autor != null, "É necessário cadastrar o livro com um autor existente.");

        return new Livro(titulo, resumo, sumario, preco, numPaginas, isbn, dataPublicacao, categoria, autor);
    }
}
