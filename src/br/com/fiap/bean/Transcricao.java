package br.com.fiap.bean;

public class Transcricao {
    // atributos
    private int idTranscricao;
    private Reuniao reuniao;
    private String textoOriginal;
    private String textoFiltrado;
    private String status;
    private double qualidade;

    // construtores
    public Transcricao() {
    }

    public Transcricao(int idTranscricao, Reuniao reuniao, String textoOriginal, String textoFiltrado, String status, double qualidade) {
        this.idTranscricao = idTranscricao;
        this.reuniao = reuniao;
        this.textoOriginal = textoOriginal;
        this.textoFiltrado = textoFiltrado;
        this.status = status;
        this.qualidade = qualidade;
    }

    // métodos getters/setters
    public int getIdTranscricao() {
        return idTranscricao;
    }

    public void setIdTranscricao(int idTranscricao) {
        this.idTranscricao = idTranscricao;
    }

    public Reuniao getReuniao() {
        return reuniao;
    }

    public void setReuniao(Reuniao reuniao) {
        this.reuniao = reuniao;
    }

    public String getTextoOriginal() {
        return textoOriginal;
    }

    public void setTextoOriginal(String textoOriginal) {
        this.textoOriginal = textoOriginal;
    }

    public String getTextoFiltrado() {
        return textoFiltrado;
    }

    public void setTextoFiltrado(String textoFiltrado) {
        this.textoFiltrado = textoFiltrado;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getQualidade() {
        return qualidade;
    }

    public void setQualidade(double qualidade) {
        if (qualidade >= 0 && qualidade <= 100) {
            this.qualidade = qualidade;
        }
    }

    // métodos da classe
    public void filtrarTexto() {
        if (textoOriginal != null) {
            textoFiltrado = textoOriginal;
            status = "FILTRADA";
            qualidade = 100;
        } else {
            textoFiltrado = "";
            status = "PENDENTE";
            qualidade = 0;
        }
    }

    public boolean validarQualidade() {
        if (qualidade >= 70) {
            return true;
        } else {
            return false;
        }
    }
}