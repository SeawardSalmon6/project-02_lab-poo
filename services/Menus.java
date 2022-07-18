package services;

import java.util.Scanner;
import data.ListaCarros;
import data.ListaClientes;
import data.ListaVendas;

public final class Menus {
  private static final String SENHA_GERENTE = "adminGerente";
  private static final String SENHA_VENDEDOR = "adminVendedor";
  private static boolean gerenteAtivo = false;

  public static void setGerenteAtivo(boolean gerenteAtivo) {
    Menus.gerenteAtivo = gerenteAtivo;
  }

  public static void areaLogin(Scanner sc) {
    int op;
    String senhaLida;

    do {
      Utils.printCabecalho("ÁREA DE LOGIN");
      senhaLida = Utils.lerString("Digite sua senha de acesso: ", sc);

      System.out.println("\n(1) Realizar Login");
      System.out.println("\n(0) Sair");
      op = Utils.lerInt("Escolha a opção desejada: ", sc);

      switch (op) {
        case 1:
          if (senhaLida.equals(SENHA_GERENTE)) {
            Menus.setGerenteAtivo(true);
            Menus.menuPrincipal(sc);
          } else if (senhaLida.equals(SENHA_VENDEDOR)) {
            Menus.setGerenteAtivo(true);
            Menus.menuPrincipal(sc);
          } else
            Utils.printAviso("A senha de acesso inserida está incorreta!");

          break;
        case 0:
          Utils.limpaTela();
          System.out.println("--> Obrigado por utilizar nossa aplicação!");
          break;
        default:
          Utils.printAviso("Insira uma opção válida!");
          break;
      }
    } while (op != 0);
  }

  public static void menuPrincipal(Scanner sc) {
    int op, tipoVeiculo;

    do {
      Utils.printCabecalho("MENU PRINCIPAL");
      System.out.println("\n(1) Realizar Venda");
      System.out.println("\n(2) Consultar Veículo");
      System.out.println("\n(3) Consultar Veículos Disponíveis");
      System.out.println("\n(4) Consultar Cliente");
      System.out.println("\n(5) Listar Vendas");

      if (gerenteAtivo)
        System.out.println("\n(6) Acessar Gerência");

      System.out.println("\n(0) Sair para o Login");
      op = Utils.lerInt("Digite a opção desejada: ", sc);

      switch (op) {
        case 1:
          ListaVendas.realizarVenda(sc);
          break;
        case 2:
          tipoVeiculo = Menus.consultarTipoVeiculo(sc);

          if (tipoVeiculo != 0)
            Menus.consultarVeiculo(tipoVeiculo, sc);

          break;
        case 3:
          tipoVeiculo = Menus.consultarTipoVeiculo(sc);

          if (tipoVeiculo != 0)
            Menus.consultarVeiculosDisponiveis(tipoVeiculo, sc);

          break;
        case 4:
          ListaClientes.consultarCliente(sc);
          break;
        case 5:
          ListaVendas.listarVendas();
          break;
        case 6:
          if (gerenteAtivo)
            Menus.acessarGerencia(sc);
          break;
        case 0:
          break;
        default:
          Utils.printAviso("Insira um valor válido!");
          break;
      }
    } while (op != 0);
  }

  public static int consultarTipoVeiculo(Scanner sc) {
    int tipoVeiculo;

    do {
      Utils.limpaTela();
      Utils.printCabecalho("CONSULTAR VEÍCULO");
      System.out.println("\n(1) Carro");
      System.out.println("\n(2) Moto");
      System.out.println("\n(0) Voltar");

      tipoVeiculo = Utils.lerInt("Escolha o tipo de veículo para consulta: ", sc);

      if (tipoVeiculo < 0 && tipoVeiculo > 2)
        Utils.printAviso("Insira um valor válido!");
    } while (tipoVeiculo < 0 && tipoVeiculo > 2);

    return tipoVeiculo;
  }

  public static void acessarGerencia(Scanner sc) {
    int op;

    do {
      Utils.limpaTela();

      Utils.printCabecalho("MENU DE GERÊNCIA");
      System.out.println("\n(1) Gerenciar Clientes");
      System.out.println("\n(2) Gerenciar Vendedores");
      System.out.println("\n(3) Gerenciar Veículos");
      System.out.println("\n(4) Gerar Relatório de Vendas");
      System.out.println("\n(0) Voltar para o Menu Principal");

      op = Utils.lerInt("Digite a opção desejada: ", sc);

      switch (op) {
        case 1:
          Menus.gerenciarClientes(sc);
          break;
        case 2:
          Menus.gerenciarVendedores(sc);
          break;
        case 3:
          Menus.gerenciarVeiculos(sc);
          break;
        case 4:
          ListaVendas.gerarRelatorio();
          break;
        case 0:
          break;
        default:
          Utils.printAviso("Insira uma opção válida!");
          break;
      }
    } while (op != 0);
  }

  public static void gerenciarClientes(Scanner sc) {
    int op;

    do {
      Utils.limpaTela();

      Utils.printCabecalho("GERENCIAR CLIENTES");
      System.out.println("\n(1) Adicionar Cliente");
      System.out.println("\n(2) Alterar Cliente");
      System.out.println("\n(3) Excluir Cliente");
      System.out.println("\n(4) Listar Clientes");
      System.out.println("\n(0) Voltar para o Menu Gerência");

      op = Utils.lerInt("Digite a opção desejada: ", sc);

      switch (op) {
        case 1:
          ListaClientes.cadastrarCliente(sc);
          break;
        case 2:
          ListaClientes.alterarCliente(sc);
          break;
        case 3:
          ListaClientes.excluirCliente(sc);
          break;
        case 4:
          ListaClientes.listarClientes();
          break;
        case 0:
          break;
        default:
          Utils.printAviso("Insira uma opção válida!");
      }
    } while (op != 0);
  }

  public static void gerenciarVendedores(Scanner sc) {
    int op;

    do {
      Utils.limpaTela();

      Utils.printCabecalho("GERENCIAR VENDEDORES");
      System.out.println("\n(1) Adicionar Vendedor");
      System.out.println("\n(2) Alterar Vendedor");
      System.out.println("\n(3) Excluir Vendedor");
      System.out.println("\n(4) Listar Vendedores");
      System.out.println("\n(0) Voltar para o Menu Gerência");

      op = Utils.lerInt("Digite a opção desejada: ", sc);

      switch (op) {
        case 1:
          ListaClientes.adicionarVendedor(sc);
          break;
        case 2:
          ListaClientes.alterarVendedor(sc);
          break;
        case 3:
          ListaClientes.excluirVendedor(sc);
          break;
        case 4:
          ListaClientes.listarVendedores();
          break;
        case 0:
          break;
        default:
          Utils.printAviso("Insira uma opção válida!");
      }
    } while (op != 0);
  }

  public static void gerenciarVeiculos(Scanner sc) {
    int op;

    do {
      Utils.limpaTela();

      Utils.printCabecalho("GERENCIAR VEÍCULOS");
      System.out.println("\n(1) Adicionar Veículo");
      System.out.println("\n(2) Alterar Veículo");
      System.out.println("\n(3) Excluir Veículo");
      System.out.println("\n(4) Listar Veículos");
      System.out.println("\n(0) Voltar para o Menu Gerência");

      op = Utils.lerInt("Digite a opção desejada: ", sc);

      switch (op) {
        case 1:
          ListaClientes.adicionarVeiculo(sc);
          break;
        case 2:
          ListaClientes.alterarVeiculo(sc);
          break;
        case 3:
          ListaClientes.excluirVeiculo(sc);
          break;
        case 4:
          ListaClientes.listarVeiculos();
          break;
        case 0:
          break;
        default:
          Utils.printAviso("Insira uma opção válida!");
      }
    } while (op != 0);
  }
}
