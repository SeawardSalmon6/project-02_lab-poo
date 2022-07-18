package views;

import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Toolkit;

public class GuiVendedor extends JFrame{

    public GuiVendedor(){
        iniciarComponentes();
        definirEventos();
    }

    private void iniciarComponentes(){
        
    }

    private void definirEventos(){

    }

    public void abrir(){
        Dimension tamanhoTela = Toolkit.getDefaultToolkit().getScreenSize();
        
        setTitle("Menu Principal - Vendedor");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);
        setSize(500, 500);
        setLocation((tamanhoTela.width - getSize().width)/2,
				(tamanhoTela.height - getSize().height)/2);
        setResizable(false);
        setVisible(true);
    }
}
