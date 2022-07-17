package data;

import java.util.ArrayList;

import models.Vendedor;

public class ListaVendedores {
  private static ArrayList<Vendedor> listaVendedores = new ArrayList<>();

  // ======= Métodos Auxiliares
  public static boolean estaVazia() {
    return listaVendedores.size() == 0;
  }

  public static int getQuantidade() {
    return listaVendedores.size();
  }
}
