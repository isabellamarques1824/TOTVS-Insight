package br.com.fiap.bean;

public class Alerta {
    // atributos
    private int idAlerta;
    private String tipoAlerta;
    private String mensagem;
    private String prioridade;
    private String status;

    // construtores
    public Alerta() {
    }

    public Alerta(int idAlerta, String tipoAlerta, String mensagem, String prioridade, String status) {
        this.idAlerta = idAlerta;
        this.tipoAlerta = tipoAlerta;
        this.mensagem = mensagem;
        this.prioridade = prioridade;
        this.status = status;
    }

    // métodos getters/setters
    public int getIdAlerta() {
        return idAlerta;
    }

    public void setIdAlerta(int idAlerta) {
        this.idAlerta = idAlerta;
    }

    public String getTipoAlerta() {
        return tipoAlerta;
    }

    public void setTipoAlerta(String tipoAlerta) {
        this.tipoAlerta = tipoAlerta;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // métodos da classe
    public void marcarComoVisualizado() {
        status = "VISUALIZADO";
    }

    public void resolverAlerta() {
        status = "RESOLVIDO";
    }
}