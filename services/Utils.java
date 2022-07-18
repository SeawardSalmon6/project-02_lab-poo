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
  public static void printCabecalho(String titulo) {
    System.out.printf("\n================= %s\n", titulo);
  }

  public static void printAviso(String aviso) {
    System.out.println("\n\n==!== AVISO: " + aviso);
  }

  // ler string
  public static String lerString(String mensagem, Scanner sc) {
    String str = "";

    System.out.print("\n  --> " + mensagem);
    str = sc.nextLine();

    return str;
  }

  // ler int
  public static int lerInt(String mensagem, Scanner sc) {
    int num = 0;

    System.out.print("\n  --> " + mensagem);
    num = sc.nextInt();
    sc.nextLine();

    return num;
  }

  // ler long
  public static long lerLong(String mensagem, Scanner sc) {
    long num = 0;

    System.out.print("\n  --> " + mensagem);
    num = sc.nextLong();
    sc.nextLine();

    return num;
  }

  // ler double
  public static double lerDouble(String mensagem, Scanner sc) {
    double num = 0;

    System.out.print("\n  --> " + mensagem);
    num = sc.nextDouble();
    sc.nextLine();

    return num;
  }

  public static float lerFloat(String mensagem, Scanner sc) {
    float num = 0;

    System.out.print("\n  --> " + mensagem);
    num = sc.nextFloat();
    sc.nextLine();

    return num;
  }
}
