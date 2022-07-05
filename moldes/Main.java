import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Vendedor> listaVendedor = new ArrayList<Vendedor>();

        Vendedor v1 = new Vendedor(); //teste do codigo
        v1.cadastroVendedor(listaVendedor, sc);

    }
}
