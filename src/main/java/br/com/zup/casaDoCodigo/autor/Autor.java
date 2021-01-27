package br.com.zup.casaDoCodigo.autor;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames={"email"},name = "UK_EMAIL")})
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @NotNull
    private String nome;

    @Email
    @NotBlank
    @NotNull
    private String email;

    @NotBlank
    @Length(max=400)
    @NotNull
    private String descricao;

    @NotNull
    private LocalDateTime instante = LocalDateTime.now();

    @Deprecated
    public Autor(){}

    public Autor(@NotBlank String nome, @Email @NotBlank String email, @NotBlank @Length(max=400) String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", descricao='" + descricao + '\'' +
                ", instante=" + instante +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Autor autor = (Autor) o;
        return id.equals(autor.id) && nome.equals(autor.nome) && email.equals(autor.email) && descricao.equals(autor.descricao) && instante.equals(autor.instante);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, email, descricao, instante);
    }
}
