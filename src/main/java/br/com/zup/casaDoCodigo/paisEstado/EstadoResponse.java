package br.com.zup.casaDoCodigo.paisEstado;

public class EstadoResponse {

    private String estado;

    private String pais;

    public EstadoResponse(Estado estado) {
        this.estado = estado.getNome();
        this.pais = estado.getPais().getNome();
    }

    public String getEstado() {
        return estado;
    }

    public String getPais() {
        return pais;
    }
}
