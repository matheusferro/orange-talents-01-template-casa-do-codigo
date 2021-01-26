package br.com.zup.casaDoCodigo.excecao;

public class ErroDeValidacaoFieldDTO {

    private String campo;
    private String erro;

    public ErroDeValidacaoFieldDTO(String campo, String erro) {
        this.campo = campo;
        this.erro = erro;
    }
    public String getCampo() {
        return campo;
    }

    public String getErro() {
        return erro;
    }
}
