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
    private JComboBox<String> cbTipo;
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

        abas = new JTabbedPane();
        abas.setBounds(150, 0, 500, 500);
        abas.setFocusable(false);
        add(abas);
        
        painelLateral = new JPanel();
        // painelLateral.setLayout(null);
        painelLateral.setBounds(0, 0, 150, 500);
        painelLateral.setAlignmentY(CENTER_ALIGNMENT);
        add(painelLateral);

        painelCadastro = new JPanel();
        painelCadastro.setBounds(tamanhoJPanel);
        painelCadastro.setLayout(null);
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

        int x = 25, y = 25, w = 100, h = 10;

        lblPotencia = new JLabel();
        lblPotencia.setText("Potencia: ");lblPotencia.setBounds(x, y, w + 60, h);
        painelCadastro.add(lblPotencia);

        tfPotencia = new JTextField();
        tfPotencia.setBounds(x + w + 60, y, w + 60, h);
        painelCadastro.add(tfPotencia);

        lblNumCilindros = new JLabel();
        lblNumCilindros.setText("Numero de Cilindros: ");
        lblNumCilindros.setBounds(x, y * 2, w + 60, h);
        painelCadastro.add(lblNumCilindros);

        tfNumCilindros = new JTextField();
        // tfNumCilindros.setBounds(2 * x + h, y, w, h);
        painelCadastro.add(tfNumCilindros);

        lblNumOcupantes = new JLabel();
        lblNumOcupantes.setText("Numero de Ocupantes:");
        painelCadastro.add(lblNumOcupantes);

        tfNumOcupantes = new JTextField();
        tfNumOcupantes.setColumns(3);
        painelCadastro.add(tfNumOcupantes);

        lblTipo = new JLabel();
        lblTipo.setText("Tipo:");
        painelCadastro.add(lblTipo);

        String tipos[] = {"Utilitario", "Pickup", "Sedan", "Hatch", "Esportivo"};
        cbTipo = new JComboBox<>(tipos);
        cbTipo.setFocusable(false);
        painelCadastro.add(cbTipo);

        lblDimensoes = new JLabel();
        lblDimensoes.setText("Dimensoes");
        painelCadastro.add(lblDimensoes);

        lblAltura = new JLabel();
        lblAltura.setText("Altura:");
        painelCadastro.add(lblAltura);

        tfAltura = new JTextField();
        tfAltura.setColumns(3);
        painelCadastro.add(tfAltura);

        lblLargura = new JLabel();
        lblLargura.setText("Largura:");
        painelCadastro.add(lblLargura);

        tfLargura = new JTextField();
        tfLargura.setColumns(3);
        painelCadastro.add(tfLargura);

        lblComprimento = new JLabel();
        lblComprimento.setText("Comprimento:");
        painelCadastro.add(lblComprimento);

        tfComprimento = new JTextField();
        tfComprimento.setColumns(3);
        painelCadastro.add(tfComprimento);
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
