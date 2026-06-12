package br.com.fiap.main;

import br.com.fiap.bean.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIPrincipal extends JFrame {

    private Container contentPane;
    private JMenuBar mnBarra;
    private JMenu mnArquivo;
    private JMenu mnSistema;
    private JMenuItem miSair;
    private JMenuItem miDashboard;
    private JMenuItem miTranscricoes;
    private JMenuItem miAssistente;
    private JPanel painelAtual;
    private Usuario usuario;

    public GUIPrincipal(Usuario usuario) {
        this.usuario = usuario;
        inicializarComponentes();
        definirEventos();
    }

    private void inicializarComponentes() {
        setTitle("TOTVS Insight - Principal");
        setBounds(0, 0, 700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        contentPane = getContentPane();
        contentPane.setLayout(null);

        mnBarra = new JMenuBar();

        mnArquivo = new JMenu("Arquivo");
        mnSistema = new JMenu("Sistema");

        miSair = new JMenuItem("Sair");
        miDashboard = new JMenuItem("Dashboard");
        miTranscricoes = new JMenuItem("Transcrições");
        miAssistente = new JMenuItem("Assistente");

        mnArquivo.add(miSair);
        mnSistema.add(miDashboard);
        mnSistema.add(miTranscricoes);
        mnSistema.add(miAssistente);

        mnBarra.add(mnArquivo);
        mnBarra.add(mnSistema);

        setJMenuBar(mnBarra);

        painelAtual = new GUIDashboard(usuario, this);
        painelAtual.setBounds(0, 0, 700, 500);
        contentPane.add(painelAtual);
    }

    private void definirEventos() {
        miSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        miDashboard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirDashboard();
            }
        });

        miTranscricoes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirTranscricoes();
            }
        });

        miAssistente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirAssistente();
            }
        });
    }

    public void abrirDashboard() {
        contentPane.remove(painelAtual);
        painelAtual = new GUIDashboard(usuario, this);
        painelAtual.setBounds(0, 0, 700, 500);
        contentPane.add(painelAtual);
        contentPane.validate();
        contentPane.repaint();
    }

    public void abrirAssistente() {
        contentPane.remove(painelAtual);
        painelAtual = new GUIAssistente(this);
        painelAtual.setBounds(0, 0, 700, 500);
        contentPane.add(painelAtual);
        contentPane.validate();
        contentPane.repaint();
    }

    public void abrirTranscricoes() {
        JOptionPane.showMessageDialog(null,
                "Área de transcrições:\n\nAqui seriam organizadas as transcrições das reuniões comerciais e de Customer Success.");
    }
}