package data;

import java.util.ArrayList;

import models.Motocicleta;

public class ListaMotos {
  private static ArrayList<Motocicleta> listaMotos = new ArrayList<>();

  // ======= Métodos Auxiliares
  public static boolean estaVazia() {
    return listaMotos.size() == 0;
  }

  public static int getQuantidade() {
    return listaMotos.size();
  }
}
