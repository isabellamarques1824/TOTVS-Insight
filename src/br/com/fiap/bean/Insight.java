package br.com.fiap.bean;

public class Insight {
    // atributos
    private int idInsight;
    private String descricao;
    private String evidenciadoEm;
    private String prioridade;
    private String recomendacao;

    // construtores
    public Insight() {
    }

    public Insight(int idInsight, String descricao, String evidenciadoEm, String prioridade, String recomendacao) {
        this.idInsight = idInsight;
        this.descricao = descricao;
        this.evidenciadoEm = evidenciadoEm;
        this.prioridade = prioridade;
        this.recomendacao = recomendacao;
    }

    // métodos getters/setters
    public int getIdInsight() {
        return idInsight;
    }

    public void setIdInsight(int idInsight) {
        this.idInsight = idInsight;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEvidenciadoEm() {
        return evidenciadoEm;
    }

    public void setEvidenciadoEm(String evidenciadoEm) {
        this.evidenciadoEm = evidenciadoEm;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    public String getRecomendacao() {
        return recomendacao;
    }

    public void setRecomendacao(String recomendacao) {
        this.recomendacao = recomendacao;
    }

    // métodos da classe
    public String gerarRecomendacao() {
        if (prioridade.equalsIgnoreCase("ALTA")) {
            recomendacao = "Analisar o insight com urgência.";
        } else if (prioridade.equalsIgnoreCase("MEDIA")) {
            recomendacao = "Acompanhar o insight com atenção.";
        } else {
            recomendacao = "Manter o insight registrado para consulta.";
        }

        return recomendacao;
    }

    public String exibirInsight() {
        return "Descrição: " + descricao +
                "\nPrioridade: " + prioridade +
                "\nRecomendação: " + recomendacao;
    }
}