package data;

import java.util.ArrayList;
import moldes.Venda;

public class ListaVendas {
  private static ArrayList<Venda> listaVendas = new ArrayList<>();

  // ======= Métodos Auxiliares
  public static boolean estaVazia() {
    return listaVendas.size() == 0;
  }

  public static int getQuantidade() {
    return listaVendas.size();
  }
}
