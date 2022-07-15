
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class MenuPrincipal extends JFrame{

	private MenuPrincipal(){
		inicializarComponentes();
		// definirEventos();
	}

	private void inicializarComponentes(){
        setTitle("Menu Principal");
		setBounds(0,0,500,400);
		setLayout(null);
    }

    public static void abrir() {
		MenuPrincipal frame = new MenuPrincipal();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation((tela.width - frame.getSize().width)/2,
				(tela.height - frame.getSize().height)/2);
		frame.setVisible(true);
	}
}
