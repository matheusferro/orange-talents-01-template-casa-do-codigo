package br.com.zup.casaDoCodigo.autor;

import br.com.zup.casaDoCodigo.anotacao.UniqueValue;
import br.com.zup.casaDoCodigo.autor.anotacao.EmailUniqueValue;
import br.com.zup.casaDoCodigo.categoria.Categoria;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Autor converterToAutor(){
        return new Autor(nome, email, descricao);
    }
}
