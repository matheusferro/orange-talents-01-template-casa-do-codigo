package br.com.zup.casaDoCodigo.autor;

import br.com.zup.casaDoCodigo.anotacao.UniqueValue;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class AutorForm {

    @NotBlank
    private String nome;

    @Email
    @NotBlank
    @UniqueValue(domainClass = Autor.class, fieldName = "email")
    private String email;

    @NotBlank
    @Length(max=400)
    private String descricao;

    /**
     * Construtor para evitar getters e setters.
     * @param nome
     * @param email
     * @param descricao (max = 400)
     */
    public AutorForm(@NotBlank String nome, @Email @NotBlank String email, @NotBlank @Length(max = 400) String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public Autor converterToAutor(){
        return new Autor(nome, email, descricao);
    }
}
