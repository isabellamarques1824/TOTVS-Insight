package br.com.fiap.main;

import br.com.fiap.bean.AssistenteContextual;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIAssistente extends JPanel {

    private JTextField tfPergunta;
    private JTextArea taResposta;
    private JButton btEnviar;
    private JButton btLimpar;
    private JButton btVoltar;
    private JButton btMenuDashboard;
    private JButton btMenuTranscricoes;
    private JButton btMenuAssistente;
    private AssistenteContextual assistente;
    private GUIPrincipal principal;

    public GUIAssistente(GUIPrincipal principal) {
        this.principal = principal;
        assistente = new AssistenteContextual();
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

        JLabel lbTopo = new JLabel("Assistente Contextual");
        lbTopo.setForeground(Color.WHITE);
        lbTopo.setFont(new Font("Arial", Font.BOLD, 18));
        lbTopo.setBounds(25, 13, 250, 28);
        topo.add(lbTopo);

        JPanel painelPrincipal = new JPanel();
        painelPrincipal.setLayout(null);
        painelPrincipal.setBackground(Color.WHITE);
        painelPrincipal.setBounds(150, 75, 520, 360);

        JLabel lbTitulo = new JLabel("Pergunte ao assistente");
        lbTitulo.setFont(new Font("Arial", Font.BOLD, 22));
        lbTitulo.setForeground(new Color(26, 27, 99));
        lbTitulo.setBounds(20, 20, 300, 30);

        JLabel lbSubtitulo = new JLabel("Digite CHURN, OPORTUNIDADE, PRODUTO ou ALERTA.");
        lbSubtitulo.setFont(new Font("Arial", Font.PLAIN, 12));
        lbSubtitulo.setForeground(new Color(80, 80, 80));
        lbSubtitulo.setBounds(20, 50, 350, 20);

        JLabel lbPergunta = new JLabel("Pergunta:");
        lbPergunta.setFont(new Font("Arial", Font.BOLD, 12));
        lbPergunta.setBounds(20, 90, 80, 25);

        tfPergunta = new JTextField();
        tfPergunta.setBounds(100, 90, 280, 25);

        btEnviar = new JButton("Enviar");
        btEnviar.setBounds(395, 90, 100, 25);

        taResposta = new JTextArea();
        taResposta.setEditable(false);
        taResposta.setFont(new Font("Arial", Font.PLAIN, 13));
        taResposta.setLineWrap(true);
        taResposta.setWrapStyleWord(true);

        JScrollPane scroll = new JScrollPane(taResposta);
        scroll.setBounds(20, 135, 475, 140);

        btLimpar = new JButton("Limpar");
        btLimpar.setBounds(20, 300, 100, 30);

        btVoltar = new JButton("Voltar");
        btVoltar.setBounds(135, 300, 100, 30);

        painelPrincipal.add(lbTitulo);
        painelPrincipal.add(lbSubtitulo);
        painelPrincipal.add(lbPergunta);
        painelPrincipal.add(tfPergunta);
        painelPrincipal.add(btEnviar);
        painelPrincipal.add(scroll);
        painelPrincipal.add(btLimpar);
        painelPrincipal.add(btVoltar);

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

    private void definirEventos() {
        btEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enviarPergunta();
            }
        });

        btLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfPergunta.setText("");
                taResposta.setText("");
            }
        });

        btVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                principal.abrirDashboard();
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

    public void enviarPergunta() {
        assistente.setPerguntaUsuario(tfPergunta.getText());
        taResposta.setText(assistente.responderPergunta());
    }
}