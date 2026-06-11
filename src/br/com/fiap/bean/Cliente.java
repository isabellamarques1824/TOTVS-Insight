package br.com.fiap.bean;

public class Cliente {
    // atributos
    private int idCliente;
    private String nomeCliente;
    private String segmento;
    private String porte;
    private String status;

    // construtores
    public Cliente() {
    }

    public Cliente(int idCliente, String nomeCliente, String segmento, String porte, String status) {
        this.idCliente = idCliente;
        this.nomeCliente = nomeCliente;
        this.segmento = segmento;
        this.porte = porte;
        this.status = status;
    }

    // métodos getters/setters
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getSegmento() {
        return segmento;
    }

    public void setSegmento(String segmento) {
        this.segmento = segmento;
    }

    public String getPorte() {
        return porte;
    }

    public void setPorte(String porte) {
        this.porte = porte;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // métodos da classe
    public void atualizarStatus() {
        if (status.equalsIgnoreCase("ATIVO")) {
            status = "EM_RISCO";
        } else {
            status = "ATIVO";
        }
    }

    public String exibirResumoCliente() {
        return "Cliente: " + nomeCliente +
                "\nSegmento: " + segmento +
                "\nPorte: " + porte +
                "\nStatus: " + status;
    }
}