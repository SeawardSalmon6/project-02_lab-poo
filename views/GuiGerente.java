package views;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.GridBagConstraints;

public class GuiGerente extends JFrame {
    private JTabbedPane abas;
    private JPanel painelCadastro;
    private JPanel painelExclusao;
    private JPanel painelAlteracao;
    private JPanel painelConsulta;
    private JPanel painelLateral;
    private JLabel lblOpcao;
    private JButton btnFuncionario;
    private JLabel lblPotencia;
    private JTextField tfPotencia;
    private JLabel lblNumCilindros;
    private JTextField tfNumCilindros;
    private JLabel lblNumOcupantes;
    private JTextField tfNumOcupantes;
    private JLabel lblTipo;
    private JComboBox cbTipo;
    private JLabel lblDimensoes;
    private JLabel lblAltura;
    private JTextField tfAltura;
    private JLabel lblLargura;
    private JTextField tfLargura;
    private JLabel lblComprimento;
    private JTextField tfComprimento;

    public GuiGerente() {
        iniciarComponentes();
        definirEventos();
    }
    
    private void iniciarComponentes() {
        Rectangle tamanhoJPanel = new Rectangle(0, 0, 500, 500);
        GridBagConstraints gbc = new GridBagConstraints();

        abas = new JTabbedPane();
        abas.setBounds(150, 0, 500, 500);
        abas.setFocusable(false);
        add(abas);
        
        painelLateral = new JPanel();
        painelLateral.setLayout(new BoxLayout(painelLateral, BoxLayout.Y_AXIS));
        painelLateral.setBounds(0, 0, 150, 500);
        painelLateral.setAlignmentY(CENTER_ALIGNMENT);
        add(painelLateral);
        

        painelCadastro = new JPanel();
        painelCadastro.setBounds(tamanhoJPanel);
        painelCadastro.setLayout(new GridBagLayout());
        abas.add("Cadastro", painelCadastro);

        painelConsulta = new JPanel();
        painelConsulta.setBounds(tamanhoJPanel);
        abas.add("Consulta", painelConsulta);

        painelAlteracao = new JPanel();
        painelAlteracao.setBounds(tamanhoJPanel);
        abas.add("Alteracao", painelAlteracao);

        painelExclusao = new JPanel();
        painelExclusao.setBounds(tamanhoJPanel);
        abas.add("Exclusao", painelExclusao);

        // ---------------------------
        // Painel Lateral

        lblOpcao = new JLabel();
        lblOpcao.setText("Escolha uma opcao:");
        painelLateral.add(lblOpcao);

        btnFuncionario = new JButton();
        btnFuncionario.setText("Funcionario");
        btnFuncionario.setFocusable(false);
        painelLateral.add(btnFuncionario);

        // ---------------------------
        // Menu Principal

        Dimension d = new Dimension(5, 10);

        lblPotencia = new JLabel();
        lblPotencia.setText("Potencia: ");
        gbc.gridx = 0;
        gbc.gridy = 0;
        painelCadastro.add(lblPotencia, gbc);

        tfPotencia = new JTextField();
        tfPotencia.setColumns(3);
        gbc.gridx = 1;
        gbc.gridy = 0;
        painelCadastro.add(tfPotencia, gbc);

        lblNumCilindros = new JLabel();
        lblNumCilindros.setText("Numero de Cilindros: ");
        lblNumCilindros.setSize(d);
        gbc.gridx = 2;
        gbc.gridy = 0;
        painelCadastro.add(lblNumCilindros, gbc);

        tfNumCilindros = new JTextField();
        tfNumCilindros.setColumns(3);
        gbc.gridx = 3;
        gbc.gridy = 0;
        painelCadastro.add(tfNumCilindros, gbc);

        lblNumOcupantes = new JLabel();
        lblNumOcupantes.setText("Numero de Ocupantes:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        painelCadastro.add(lblNumOcupantes, gbc);

        tfNumOcupantes = new JTextField();
        tfNumOcupantes.setColumns(3);
        gbc.gridx = 1;
        gbc.gridy = 1;
        painelCadastro.add(tfNumOcupantes, gbc);

        lblTipo = new JLabel();
        lblTipo.setText("Tipo:");
        gbc.gridx = 2;
        gbc.gridy = 1;
        painelCadastro.add(lblTipo, gbc);

        String tipos[] = {"Utilitario", "Pickup", "Sedan", "Hatch", "Esportivo"};
        cbTipo = new JComboBox<>(tipos);
        cbTipo.setFocusable(false);
        gbc.gridx = 3;
        gbc.gridy = 1;
        painelCadastro.add(cbTipo, gbc);

        lblDimensoes = new JLabel();
        lblDimensoes.setText("Dimensoes");
        gbc.insets = new Insets(10,0,0,0);
        gbc.gridx = 0;
        gbc.gridy = 2;
        painelCadastro.add(lblDimensoes, gbc);

        lblAltura = new JLabel();
        lblAltura.setText("Altura:");
        gbc.gridx = 0;
        gbc.gridy = 3;
        painelCadastro.add(lblAltura, gbc);

        tfAltura = new JTextField();
        tfAltura.setColumns(3);
        gbc.gridx = 1;
        gbc.gridy = 3;
        painelCadastro.add(tfAltura, gbc);

        lblLargura = new JLabel();
        lblLargura.setText("Largura:");
        gbc.gridx = 2;
        gbc.gridy = 3;
        painelCadastro.add(lblLargura, gbc);

        tfLargura = new JTextField();
        tfLargura.setColumns(3);
        gbc.gridx = 3;
        gbc.gridy = 3;
        painelCadastro.add(tfLargura, gbc);

        lblComprimento = new JLabel();
        lblComprimento.setText("Comprimento:");
        gbc.gridx = 4;
        gbc.gridy = 3;
        painelCadastro.add(lblComprimento, gbc);

        tfComprimento = new JTextField();
        tfComprimento.setColumns(3);
        gbc.gridx = 5;
        gbc.gridy = 3;
        painelCadastro.add(tfComprimento, gbc);
    }

    private void definirEventos() {

    }

    public void abrir() {
        Dimension tamanhoTela = Toolkit.getDefaultToolkit().getScreenSize();

        setTitle("Menu Principal - Gerente");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);
        setSize(675, 550);
        setLocation((tamanhoTela.width - getSize().width) / 2,
                (tamanhoTela.height - getSize().height) / 2);
        setResizable(false);
        setVisible(true);
    }
}
