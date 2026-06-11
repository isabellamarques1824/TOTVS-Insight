package br.com.fiap.bean;

public class InsightOportunidade extends Insight {
    // atributos
    private double scoreOportunidade;

    // construtores
    public InsightOportunidade() {
    }

    public InsightOportunidade(int idInsight, String descricao, String prioridade, String recomendacao, double scoreOportunidade) {
        super.setIdInsight(idInsight);
        super.setDescricao(descricao);
        super.setPrioridade(prioridade);
        super.setRecomendacao(recomendacao);
        this.scoreOportunidade = scoreOportunidade;
    }

    // métodos getters/setters
    public double getScoreOportunidade() {
        return scoreOportunidade;
    }

    public void setScoreOportunidade(double scoreOportunidade) {
        if (scoreOportunidade >= 0 && scoreOportunidade <= 100) {
            this.scoreOportunidade = scoreOportunidade;
        }
    }

    // métodos da classe
    public String gerarRecomendacao() {
        if (scoreOportunidade >= 80) {
            super.setRecomendacao("Entrar em contato com o cliente para explorar a oportunidade.");
        } else if (scoreOportunidade >= 50) {
            super.setRecomendacao("Acompanhar a oportunidade e avaliar uma proposta futura.");
        } else {
            super.setRecomendacao("Registrar a oportunidade para análise posterior.");
        }

        return super.getRecomendacao();
    }
}