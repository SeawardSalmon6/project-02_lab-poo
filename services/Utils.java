package services;

import java.util.Scanner;

public final class Utils {
  // Limpa Tela, como se fosse o system("clear")
  public static void limpaTela() {
    final String ANSI_CODE_CLEANER = "\033[H\033[2J";
    System.out.print(ANSI_CODE_CLEANER);
    System.out.flush();
  }

  // Tipo um system("pause")
  public static void aguardarTecla() {
    System.out.println("\n\nPressione uma tecla para continuar...");
    try {
      System.in.read();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  // ========== Funções de Leitura e formatação
  public static void printCabecalho(String title) {
    System.out.printf("\n================= %s\n", title);
  }

  public static String lerString(String label, Scanner sc) {
    String str = "";

    System.out.print("\n  --> " + label);
    str = sc.nextLine();

    return str;
  }

  public static int lerInt(String label, Scanner sc) {
    int num = 0;

    System.out.print("\n  --> " + label);
    num = sc.nextInt();
    sc.nextLine();

    return num;
  }

  public static long lerLong(String label, Scanner sc) {
    long num = 0;

    System.out.print("\n  --> " + label);
    num = sc.nextLong();
    sc.nextLine();

    return num;
  }
}
