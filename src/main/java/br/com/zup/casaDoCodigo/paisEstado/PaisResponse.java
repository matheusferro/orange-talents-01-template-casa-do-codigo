package br.com.zup.casaDoCodigo.paisEstado;

public class PaisResponse {

    private String pais;

    public PaisResponse(Pais pais) {
        this.pais = pais.getNome();
    }

    public String getPais() {
        return pais;
    }
}
