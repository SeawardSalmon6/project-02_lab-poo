package views;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiLogin extends JFrame {
    private JLabel lblLogin;
    private JLabel lblSenha;
    private JTextField tfLogin;
    private JPasswordField pfSenha;
    private JButton btnLogin;
    private JButton btnSair;
    private GuiGerente gerente;
    private GuiVendedor vendedor;

    public GuiLogin() {
        iniciarComponentes();
        definirEventos();
    }

    private void iniciarComponentes() {
        Dimension tamanhoContainer = new Dimension(250, 200);
        Dimension tamanhoTela = Toolkit.getDefaultToolkit().getScreenSize();
        
        lblLogin = new JLabel();
        lblLogin.setText("Login:");
		lblLogin.setBounds(30, 30, 80, 25);
        add(lblLogin);
        
        tfLogin = new JTextField();
		tfLogin.setBounds(100, 30, 120, 25);
        add(tfLogin);
        
        lblSenha = new JLabel();
        lblSenha.setText("Senha:");
		lblSenha.setBounds(30, 75, 80, 25);
        add(lblSenha);

        pfSenha = new JPasswordField();
		pfSenha.setBounds(100, 75, 120, 25);
        add(pfSenha);

        btnLogin = new JButton();
        btnLogin.setText("Entrar");
        btnLogin.setFocusable(false);
		btnLogin.setBounds(10,120,100,25);
        add(btnLogin);

        btnSair = new JButton();
        btnSair.setText("Sair");
        btnSair.setFocusable(false);
		btnSair.setBounds(125,120,100,25);
        add(btnSair);

        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        setSize(tamanhoContainer);
        setLocation((tamanhoTela.width - getSize().width)/2,
				(tamanhoTela.height - getSize().height)/2);
        setResizable(false);
        setVisible(true);
    }

    private void definirEventos() {
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String senha = String.valueOf(pfSenha.getPassword());
                if (tfLogin.getText().equals("gerente") && senha.equals("adminGerente"))
                {
                    dispose();
                    gerente = new GuiGerente();
                    gerente.abrir();
                }
                else if (tfLogin.getText().equals("vendedor") && senha.equals("adminVendedor")){
                    dispose();
                    vendedor = new GuiVendedor();
                    vendedor.abrir();
                }
                else
                    JOptionPane.showMessageDialog(null, "Login ou senha invalidos!", "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnSair.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
