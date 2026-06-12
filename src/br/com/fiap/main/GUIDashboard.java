package br.com.fiap.main;

import br.com.fiap.bean.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

public class GUIDashboard extends JPanel {

    private JTextArea taAlertas;
    private JButton btProcessar;
    private JButton btRelatorio;
    private JButton btAssistente;
    private JButton btMenuDashboard;
    private JButton btMenuTranscricoes;
    private JButton btMenuAssistente;
    private Usuario usuario;
    private GUIPrincipal principal;

    public GUIDashboard(Usuario usuario, GUIPrincipal principal) {
        this.usuario = usuario;
        this.principal = principal;
        inicializarComponentes();
        definirEventos();
    }

    private void inicializarComponentes() {
        setLayout(null);
        setBackground(new Color(245, 248, 252));

        JPanel menuLateral = new JPanel();
        menuLateral.setLayout(null);
        menuLateral.setBackground(new Color(26, 27, 99));
        menuLateral.setBounds(0, 0, 130, 500);

        JLabel lbLogo = new JLabel("TOTVS Insight");
        lbLogo.setForeground(Color.WHITE);
        lbLogo.setFont(new Font("Arial", Font.BOLD, 14));
        lbLogo.setBounds(15, 20, 110, 25);
        menuLateral.add(lbLogo);

        btMenuDashboard = criarBotaoMenu("Dashboard", 80);
        btMenuTranscricoes = criarBotaoMenu("Transcrições", 120);
        btMenuAssistente = criarBotaoMenu("Assistente", 160);

        menuLateral.add(btMenuDashboard);
        menuLateral.add(btMenuTranscricoes);
        menuLateral.add(btMenuAssistente);

        JPanel topo = new JPanel();
        topo.setLayout(null);
        topo.setBackground(new Color(0, 169, 230));
        topo.setBounds(130, 0, 570, 55);

        JLabel lbBusca = new JLabel("  Buscar reuniões, clientes, análises...");
        lbBusca.setOpaque(true);
        lbBusca.setBackground(new Color(70, 160, 210));
        lbBusca.setForeground(Color.WHITE);
        lbBusca.setFont(new Font("Arial", Font.PLAIN, 12));
        lbBusca.setBounds(130, 13, 250, 28);
        topo.add(lbBusca);

        JLabel lbUsuario = new JLabel(usuario.getNome());
        lbUsuario.setForeground(Color.WHITE);
        lbUsuario.setFont(new Font("Arial", Font.BOLD, 12));
        lbUsuario.setBounds(410, 13, 140, 28);
        topo.add(lbUsuario);

        JPanel painelPrincipal = new JPanel();
        painelPrincipal.setLayout(null);
        painelPrincipal.setBackground(Color.WHITE);
        painelPrincipal.setBounds(150, 75, 520, 360);

        JLabel lbSubtitulo = new JLabel("Bem-vindo ao TOTVS Insight");
        lbSubtitulo.setFont(new Font("Arial", Font.PLAIN, 12));
        lbSubtitulo.setForeground(new Color(80, 80, 80));
        lbSubtitulo.setBounds(20, 10, 250, 20);

        JLabel lbTitulo = new JLabel("Dashboard Inicial");
        lbTitulo.setFont(new Font("Arial", Font.BOLD, 22));
        lbTitulo.setForeground(new Color(26, 27, 99));
        lbTitulo.setBounds(20, 30, 300, 30);

        JLabel lbTexto = new JLabel("Explorar insights");
        lbTexto.setFont(new Font("Arial", Font.BOLD, 13));
        lbTexto.setBounds(20, 65, 200, 20);

        painelPrincipal.add(lbSubtitulo);
        painelPrincipal.add(lbTitulo);
        painelPrincipal.add(lbTexto);

        criarCard(painelPrincipal, "Oportunidades", "128", 20, 105, new Color(220, 235, 255));
        criarCard(painelPrincipal, "Risco Churn", "24", 145, 105, new Color(255, 230, 210));
        criarCard(painelPrincipal, "Sentimento", "72%", 270, 105, new Color(215, 255, 225));
        criarCard(painelPrincipal, "Alta Priorid.", "15", 395, 105, new Color(255, 220, 225));

        taAlertas = new JTextArea();
        taAlertas.setEditable(false);
        taAlertas.setFont(new Font("Arial", Font.PLAIN, 12));

        JScrollPane scroll = new JScrollPane(taAlertas);
        scroll.setBounds(20, 185, 480, 100);
        painelPrincipal.add(scroll);

        btProcessar = new JButton("Processar");
        btProcessar.setBounds(20, 305, 120, 30);

        btRelatorio = new JButton("Relatório");
        btRelatorio.setBounds(155, 305, 120, 30);

        btAssistente = new JButton("Assistente");
        btAssistente.setBounds(290, 305, 120, 30);

        painelPrincipal.add(btProcessar);
        painelPrincipal.add(btRelatorio);
        painelPrincipal.add(btAssistente);

        add(menuLateral);
        add(topo);
        add(painelPrincipal);
    }

    private JButton criarBotaoMenu(String texto, int y) {
        JButton botao = new JButton(texto);
        botao.setBounds(15, y, 100, 30);
        botao.setForeground(Color.WHITE);
        botao.setBackground(new Color(26, 27, 99));
        botao.setBorderPainted(false);
        botao.setFocusPainted(false);
        botao.setHorizontalAlignment(SwingConstants.LEFT);
        return botao;
    }

    private void criarCard(JPanel painel, String titulo, String valor, int x, int y, Color cor) {
        JPanel card = new JPanel();
        card.setLayout(null);
        card.setBackground(new Color(245, 248, 252));
        card.setBounds(x, y, 105, 60);

        JLabel bolinha = new JLabel();
        bolinha.setOpaque(true);
        bolinha.setBackground(cor);
        bolinha.setBounds(10, 12, 22, 22);

        JLabel lbTituloCard = new JLabel(titulo);
        lbTituloCard.setFont(new Font("Arial", Font.PLAIN, 10));
        lbTituloCard.setBounds(38, 8, 65, 20);

        JLabel lbValor = new JLabel(valor);
        lbValor.setFont(new Font("Arial", Font.BOLD, 18));
        lbValor.setForeground(new Color(26, 27, 99));
        lbValor.setBounds(38, 28, 70, 25);

        card.add(bolinha);
        card.add(lbTituloCard);
        card.add(lbValor);

        painel.add(card);
    }

    private void definirEventos() {
        btProcessar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carregarIndicadores();
            }
        });

        btRelatorio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Relatorio relatorio = new Relatorio(1, usuario, "Resumo Geral", "Todos os clientes", LocalDateTime.now());
                taAlertas.setText(relatorio.gerarRelatorio());
            }
        });

        btAssistente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                principal.abrirAssistente();
            }
        });

        btMenuDashboard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                principal.abrirDashboard();
            }
        });

        btMenuTranscricoes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                principal.abrirTranscricoes();
            }
        });

        btMenuAssistente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                principal.abrirAssistente();
            }
        });
    }

    public void carregarIndicadores() {
        Cliente cliente = new Cliente(1, "Cliente TOTVS", "Tecnologia", "Grande Porte", "ATIVO");

        Alerta alerta = new Alerta(1, "CHURN", "Cliente apresentou sinais de insatisfação.", "ALTA", "ABERTO");

        Insight insight = new InsightChurn(
                1,
                "Risco de perda do cliente identificado na reunião.",
                "ALTA",
                "",
                78
        );

        String texto = cliente.exibirResumoCliente()
                + "\n\nAlerta: " + alerta.getMensagem()
                + "\nPrioridade: " + alerta.getPrioridade()
                + "\n\nInsight: " + insight.getDescricao()
                + "\nRecomendação: " + insight.gerarRecomendacao();

        taAlertas.setText(texto);
    }
}