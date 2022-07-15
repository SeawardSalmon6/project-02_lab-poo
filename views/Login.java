import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.SwingUtilities;

public class Login extends JFrame {
    private JButton btnLogar;
    private JButton btnCancelar;
    private JPasswordField pfSenha;
    private JTextField tfLogin;
    private JLabel lblSenha;
    private JLabel lblLogin;
    private static Login frame;

    private Login(){
        inicializarComponentes();
        definirEventos();
    }

    private void inicializarComponentes(){
        setTitle("Login no Sistema");
		setBounds(0,0,250,200);
		setLayout(null);
		tfLogin=new JTextField (5);
		pfSenha=new JPasswordField(5);
		lblSenha = new JLabel("Senha:");
		lblLogin = new JLabel ("Login:");
		btnLogar = new JButton ("Logar");
		btnCancelar = new JButton ("Cancelar");
		tfLogin.setBounds(100, 30, 120, 25);
		lblLogin.setBounds(30, 30, 80, 25);
		lblSenha.setBounds(30, 75, 80, 25);
		pfSenha.setBounds(100, 75, 120, 25);
		btnLogar.setBounds(20,120,100,25);
		btnCancelar.setBounds(125,120,100,25);
		add(tfLogin);
		add(lblSenha);
		add(lblLogin);
		add(btnLogar);
		add(btnCancelar);
		add(pfSenha);
    }

    private void definirEventos() {
		btnLogar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String senha = String.valueOf(pfSenha.getPassword());
				if(tfLogin.getText().equals("admin")&&senha.equals("admin")) {
					frame.setVisible(false);
					MenuPrincipal.abrir();
				}
				else {
					JOptionPane.showMessageDialog(null, "Login ou senha invalidos!");
				}
			}
		});
		
		btnCancelar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}

    // Chama a GUI, centralizando no meio da tela
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                frame = new Login();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
                frame.setLocation((tela.width - frame.getSize().width) / 2,
                        (tela.height - frame.getSize().height) / 2);
                frame.setVisible(true);
            }
        });
    }
}