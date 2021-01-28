package br.com.zup.casaDoCodigo.compra;

import br.com.zup.casaDoCodigo.anotacao.CPFouCNPJ;
import br.com.zup.casaDoCodigo.anotacao.ExistsValue;
import br.com.zup.casaDoCodigo.paisEstado.Pais;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CompraParcialRequest {

    @NotBlank
    private String nome;

    @NotBlank
    private String sobrenome;

    @Email
    @NotBlank
    private String email;

    @CPFouCNPJ
    private String documento;

    @NotBlank
    private String endereco;

    @NotBlank
    private String complemento;

    @NotBlank
    private String cidade;

    @NotNull
    @ExistsValue(domainClass = Pais.class, fieldName = "id")
    private Long idPais;

    private Long idEstado;

    @NotBlank
    private String telefone;

    @NotBlank
    private String cep;

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public String getDocumento() {
        return documento;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public Long getIdPais() {
        return idPais;
    }

    public Long getIdEstado() {
        return idEstado;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCep() {
        return cep;
    }

    @Override
    public String toString() {
        return "CompraParcialRequest{" +
                "nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", email='" + email + '\'' +
                ", documento='" + documento + '\'' +
                ", endereco='" + endereco + '\'' +
                ", complemento='" + complemento + '\'' +
                ", cidade='" + cidade + '\'' +
                ", idPais=" + idPais +
                ", idEstado=" + idEstado +
                ", telefone='" + telefone + '\'' +
                ", cep='" + cep + '\'' +
                '}';
    }
}
