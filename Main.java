import java.util.Scanner;

import javax.swing.JFrame;

import services.Menus;
import views.GuiLogin;

// Login para GUI: gerente
// Senha para GUI: adminGerente
// ou 
// Login para GUI: vendedor
// Senha para GUI: adminVendedor

// Senha para terminal: adminGerente
// ou
// Senha para terminal: adminVendedor

public class Main extends JFrame {
    public static void main(String[] args) {
        int op;
        System.out.println("Escolha uma opcao:");
        System.out.println("0 - Sistema via terminal");
        System.out.println("1 - Sistema GUI");
        Scanner sc = new Scanner(System.in);
        op = sc.nextInt();
        sc.nextLine();
        switch (op) {
            case 0:
                Menus.areaLogin(sc);
                break;
            case 1:
                new GuiLogin();
                break;
            default:
                break;
        }
    }
}
