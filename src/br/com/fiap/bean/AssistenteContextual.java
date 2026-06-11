package br.com.fiap.bean;

public class AssistenteContextual {
    // atributos
    private String contextoAtual;
    private String perguntaUsuario;
    private String respostaGerada;
    private Insight insightSelecionado;

    // construtores
    public AssistenteContextual() {
    }

    public AssistenteContextual(String contextoAtual, String perguntaUsuario, String respostaGerada, Insight insightSelecionado) {
        this.contextoAtual = contextoAtual;
        this.perguntaUsuario = perguntaUsuario;
        this.respostaGerada = respostaGerada;
        this.insightSelecionado = insightSelecionado;
    }

    // métodos getters/setters
    public String getContextoAtual() {
        return contextoAtual;
    }

    public void setContextoAtual(String contextoAtual) {
        this.contextoAtual = contextoAtual;
    }

    public String getPerguntaUsuario() {
        return perguntaUsuario;
    }

    public void setPerguntaUsuario(String perguntaUsuario) {
        this.perguntaUsuario = perguntaUsuario;
    }

    public String getRespostaGerada() {
        return respostaGerada;
    }

    public void setRespostaGerada(String respostaGerada) {
        this.respostaGerada = respostaGerada;
    }

    public Insight getInsightSelecionado() {
        return insightSelecionado;
    }

    public void setInsightSelecionado(Insight insightSelecionado) {
        this.insightSelecionado = insightSelecionado;
    }

    // métodos da classe
    public String responderPergunta() {
        if (perguntaUsuario == null) {
            respostaGerada = "Nenhuma pergunta foi informada.";
        } else if (perguntaUsuario.equalsIgnoreCase("CHURN")) {
            respostaGerada = "Churn representa o risco de perda de um cliente.";
        } else if (perguntaUsuario.equalsIgnoreCase("OPORTUNIDADE")) {
            respostaGerada = "Oportunidade representa uma possível chance de venda ou expansão.";
        } else if (perguntaUsuario.equalsIgnoreCase("PRODUTO")) {
            respostaGerada = "Produto representa uma solução ou módulo citado durante a reunião.";
        } else if (perguntaUsuario.equalsIgnoreCase("ALERTA")) {
            respostaGerada = "Alerta representa uma situação importante que precisa de atenção.";
        } else {
            respostaGerada = "O assistente não encontrou uma resposta específica para a pergunta informada.";
        }

        return respostaGerada;
    }

    public String explicarInsight() {
        if (insightSelecionado == null) {
            respostaGerada = "Nenhum insight foi selecionado.";
        } else {
            respostaGerada = "Insight selecionado:" +
                    "\nDescrição: " + insightSelecionado.getDescricao() +
                    "\nPrioridade: " + insightSelecionado.getPrioridade() +
                    "\nRecomendação: " + insightSelecionado.gerarRecomendacao();
        }

        return respostaGerada;
    }
}