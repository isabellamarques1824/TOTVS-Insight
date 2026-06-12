package br.com.fiap.main;

import br.com.fiap.bean.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUILogin extends JFrame {

    private JLabel lbLogo;
    private JLabel lbEmail;
    private JLabel lbSenha;
    private JTextField tfEmail;
    private JPasswordField pfSenha;
    private JButton btEntrar;

    public GUILogin() {
        inicializarComponentes();
        definirEventos();
    }

    private void inicializarComponentes() {
        setTitle("TOTVS Insight - Login");
        setSize(520, 360);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        PainelGradiente painel = new PainelGradiente();
        painel.setLayout(null);
        setContentPane(painel);

        ImageIcon logoOriginal = new ImageIcon("imagens/insights-branco.png");
        Image imagemRedimensionada = logoOriginal.getImage().getScaledInstance(300, 200, Image.SCALE_SMOOTH);

        lbLogo = new JLabel(new ImageIcon(imagemRedimensionada));
        lbLogo.setBounds(110, 10, 300, 140);

        lbEmail = new JLabel("E-mail:");
        lbEmail.setForeground(Color.WHITE);
        lbEmail.setFont(new Font("Arial", Font.BOLD, 13));
        lbEmail.setBounds(115, 155, 80, 25);

        tfEmail = new JTextField();
        tfEmail.setBounds(195, 155, 190, 25);

        lbSenha = new JLabel("Senha:");
        lbSenha.setForeground(Color.WHITE);
        lbSenha.setFont(new Font("Arial", Font.BOLD, 13));
        lbSenha.setBounds(115, 195, 80, 25);

        pfSenha = new JPasswordField();
        pfSenha.setBounds(195, 195, 190, 25);

        btEntrar = new JButton("Entrar");
        btEntrar.setBounds(195, 245, 110, 30);

        painel.add(lbLogo);
        painel.add(lbEmail);
        painel.add(tfEmail);
        painel.add(lbSenha);
        painel.add(pfSenha);
        painel.add(btEntrar);
    }

    private void definirEventos() {
        btEntrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String email = tfEmail.getText();
                String senha = new String(pfSenha.getPassword());

                if (email.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Informe o e-mail.", "Atenção", JOptionPane.WARNING_MESSAGE);
                    tfEmail.requestFocus();
                    return;
                }

                if (senha.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Informe a senha.", "Atenção", JOptionPane.WARNING_MESSAGE);
                    pfSenha.requestFocus();
                    return;
                }

                Usuario usuario = new Usuario(1, "Usuário Logado", email, senha, "Analista", "ATIVO");

                if (usuario.autenticar()) {
                    GUIPrincipal principal = new GUIPrincipal(usuario);
                    principal.setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Usuário não autorizado.");
                }
            }
        });
    }

    private class PainelGradiente extends JPanel {
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2d = (Graphics2D) g;

            Color azulEscuro = new Color(26, 27, 99);
            Color azulClaro = new Color(0, 169, 230);

            GradientPaint gradiente = new GradientPaint(0, 0, azulEscuro, getWidth(), getHeight(), azulClaro);

            g2d.setPaint(gradiente);
            g2d.fillRect(0, 0, getWidth(), getHeight());
        }
    }

    public static void main(String[] args) {
        GUILogin login = new GUILogin();
        login.setVisible(true);
    }
}