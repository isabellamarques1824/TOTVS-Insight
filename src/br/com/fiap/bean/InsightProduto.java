package br.com.fiap.bean;

public class InsightProduto extends Insight {
    // atributos
    private String produtoRelacionado;

    // construtores
    public InsightProduto() {
    }

    public InsightProduto(int idInsight, String descricao, String prioridade, String recomendacao, String produtoRelacionado) {
        super.setIdInsight(idInsight);
        super.setDescricao(descricao);
        super.setPrioridade(prioridade);
        super.setRecomendacao(recomendacao);
        this.produtoRelacionado = produtoRelacionado;
    }

    // métodos getters/setters
    public String getProdutoRelacionado() {
        return produtoRelacionado;
    }

    public void setProdutoRelacionado(String produtoRelacionado) {
        this.produtoRelacionado = produtoRelacionado;
    }

    // métodos da classe
    public String gerarRecomendacao() {
        if (super.getPrioridade().equalsIgnoreCase("ALTA")) {
            super.setRecomendacao("Verificar necessidade do cliente relacionada ao produto " + produtoRelacionado + ".");
        } else if (super.getPrioridade().equalsIgnoreCase("MEDIA")) {
            super.setRecomendacao("Acompanhar interesse do cliente no produto " + produtoRelacionado + ".");
        } else {
            super.setRecomendacao("Registrar menção ao produto " + produtoRelacionado + " para análise posterior.");
        }

        return super.getRecomendacao();
    }
}