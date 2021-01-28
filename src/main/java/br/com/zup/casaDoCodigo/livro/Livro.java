package br.com.zup.casaDoCodigo.livro;

import br.com.zup.casaDoCodigo.autor.Autor;
import br.com.zup.casaDoCodigo.categoria.Categoria;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"titulo"}, name = "UK_NOME"),
        @UniqueConstraint(columnNames = {"isbn"}, name = "UK_ISBN")
})
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @NotNull
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
    private String isbn;

    @Future
    private LocalDate dataPublicacao;

    @NotNull
    @ManyToOne
    private Categoria categoria;

    @NotNull
    @ManyToOne
    private Autor autor;

    @Deprecated
    public Livro(){}

    public Livro(@NotBlank @NotNull String titulo, @NotBlank @NotNull @Length(max = 500) String resumo, @NotNull String sumario, @NotNull @Min(20) BigDecimal preco, @NotNull @Min(100) Integer numPaginas, @NotBlank @NotNull String isbn, @Future LocalDate dataPublicacao, @NotNull Categoria categoria, @NotNull Autor autor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numPaginas = numPaginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.categoria = categoria;
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", resumo='" + resumo + '\'' +
                ", sumario='" + sumario + '\'' +
                ", preco=" + preco +
                ", numPaginas=" + numPaginas +
                ", isbn='" + isbn + '\'' +
                ", dataPublicacao=" + dataPublicacao +
                ", categoria=" + categoria.getNome() +
                ", autor=" + autor.getNome() +
                '}';
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }
}
