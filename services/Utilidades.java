package services;

import java.util.Scanner;

public final class Utilidades {
  // Limpa Tela, como se fosse o system("clear")
  public void limpaTela() {
    final String ANSI_CODE_CLEANER = "\033[H\033[2J";
    System.out.print(ANSI_CODE_CLEANER);
    System.out.flush();
  }

  // Tipo um system("pause")
  public void aguardarTecla() {
    System.out.println("\n\nPressione uma tecla para continuar...");
    try {
      System.in.read();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  // ========== Funções de Leitura e formatação
  public void printCabecalho(String title) {
    System.out.printf("\n================= %s\n", title);
  }

  // ler string
  public String lerString(String label, Scanner sc) {
    String str = "";

    System.out.print("\n  --> " + label);
    str = sc.nextLine();

    return str;
  }

  // ler int
  public int lerInt(String label, Scanner sc) {
    int num = 0;

    System.out.print("\n  --> " + label);
    num = sc.nextInt();
    sc.nextLine();

    return num;
  }

  // ler long
  public long lerLong(String label, Scanner sc) {
    long num = 0;

    System.out.print("\n  --> " + label);
    num = sc.nextLong();
    sc.nextLine();

    return num;
  }

  // ler double
  public double lerDouble(String label, Scanner sc) {
    double num = 0;

    System.out.print("\n  --> " + label);
    num = sc.nextDouble();
    sc.nextLine();

    return num;
  }

  public float lerFloat(String label, Scanner sc) {
    float num = 0;

    System.out.print("\n  --> " + label);
    num = sc.nextFloat();
    sc.nextLine();

    return num;
  }
}
