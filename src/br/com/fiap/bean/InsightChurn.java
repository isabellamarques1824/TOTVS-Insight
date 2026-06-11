package br.com.fiap.bean;

public class InsightChurn extends Insight {
    // atributos
    private double scoreChurn;

    // construtores
    public InsightChurn() {
    }

    public InsightChurn(int idInsight, String descricao, String prioridade, String recomendacao, double scoreChurn) {
        super.setIdInsight(idInsight);
        super.setDescricao(descricao);
        super.setPrioridade(prioridade);
        super.setRecomendacao(recomendacao);
        this.scoreChurn = scoreChurn;
    }

    // métodos getters/setters
    public double getScoreChurn() {
        return scoreChurn;
    }

    public void setScoreChurn(double scoreChurn) {
        if (scoreChurn >= 0 && scoreChurn <= 100) {
            this.scoreChurn = scoreChurn;
        }
    }

    // métodos da classe
    public String gerarRecomendacao() {
        if (scoreChurn >= 70) {
            super.setRecomendacao("Entrar em contato com o cliente para reduzir o risco de churn.");
        } else if (scoreChurn >= 40) {
            super.setRecomendacao("Acompanhar o cliente com atenção e verificar sinais de insatisfação.");
        } else {
            super.setRecomendacao("Manter acompanhamento normal do cliente.");
        }

        return super.getRecomendacao();
    }
}