package br.com.zup.casaDoCodigo.autor;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames={"email"},name = "UK_EMAIL")})
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    @Length(max=400)
    private String descricao;

    private LocalDateTime instante = LocalDateTime.now();

    @Deprecated
    public Autor(){}

    public Autor(@NotBlank String nome, @Email @NotBlank String email, @NotBlank @Length(max=400) String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDateTime getInstante() {
        return instante;
    }
}
