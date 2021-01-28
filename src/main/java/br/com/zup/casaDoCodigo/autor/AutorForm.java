package br.com.zup.casaDoCodigo.autor;

import br.com.zup.casaDoCodigo.anotacao.UniqueValue;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 * Classe responsável por receber os dados.
 */
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
     *
     * Após o check-in (28/01/2020), foi conversado sobre mapear o json recebido
     * nos parâmetros do construtor, para que o Jackson consiga associar os parâmetros
     * do JSON recebido com o construtor.
     *
     * @param nome
     * @param email
     * @param descricao (max = 400)
     */
    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public AutorForm(@NotBlank @JsonProperty("nome") String nome,
                     @Email @NotBlank @JsonProperty("email") String email,
                     @NotBlank @Length(max = 400) @JsonProperty("descricao") String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public Autor converterToAutor(){
        return new Autor(nome, email, descricao);
    }
}
