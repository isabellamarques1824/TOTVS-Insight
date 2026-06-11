package br.com.fiap.bean;

public class AnaliseIA {
    // atributos
    private int idAnalise;
    private Transcricao transcricao;
    private String sentimentoGeral;
    private double scoreChurn;
    private double scoreOportunidade;
    private String prioridade;

    // construtores
    public AnaliseIA() {
    }

    public AnaliseIA(int idAnalise, Transcricao transcricao, String sentimentoGeral, double scoreChurn, double scoreOportunidade, String prioridade) {
        this.idAnalise = idAnalise;
        this.transcricao = transcricao;
        this.sentimentoGeral = sentimentoGeral;
        this.scoreChurn = scoreChurn;
        this.scoreOportunidade = scoreOportunidade;
        this.prioridade = prioridade;
    }

    // métodos getters/setters
    public int getIdAnalise() {
        return idAnalise;
    }

    public void setIdAnalise(int idAnalise) {
        this.idAnalise = idAnalise;
    }

    public Transcricao getTranscricao() {
        return transcricao;
    }

    public void setTranscricao(Transcricao transcricao) {
        this.transcricao = transcricao;
    }

    public String getSentimentoGeral() {
        return sentimentoGeral;
    }

    public void setSentimentoGeral(String sentimentoGeral) {
        this.sentimentoGeral = sentimentoGeral;
    }

    public double getScoreChurn() {
        return scoreChurn;
    }

    public void setScoreChurn(double scoreChurn) {
        if (scoreChurn >= 0 && scoreChurn <= 100) {
            this.scoreChurn = scoreChurn;
        }
    }

    public double getScoreOportunidade() {
        return scoreOportunidade;
    }

    public void setScoreOportunidade(double scoreOportunidade) {
        if (scoreOportunidade >= 0 && scoreOportunidade <= 100) {
            this.scoreOportunidade = scoreOportunidade;
        }
    }

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    // métodos da classe
    public String calcularPrioridade() {
        if (scoreChurn >= 70 || scoreOportunidade >= 80) {
            prioridade = "ALTA";
        } else if (scoreChurn >= 40 || scoreOportunidade >= 50) {
            prioridade = "MEDIA";
        } else {
            prioridade = "BAIXA";
        }

        return prioridade;
    }

    public String gerarResumoAnalise() {
        return "Sentimento geral: " + sentimentoGeral +
                "\nScore de churn: " + scoreChurn +
                "\nScore de oportunidade: " + scoreOportunidade +
                "\nPrioridade: " + prioridade;
    }
}