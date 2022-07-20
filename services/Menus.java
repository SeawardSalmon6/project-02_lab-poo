package services;

import java.util.Scanner;
import data.ListaCarros;
import data.ListaClientes;
import data.ListaMotos;
import data.ListaVendas;
import data.ListaVendedores;

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
      Utils.limpaTela();
      Utils.printCabecalho("ÁREA DE LOGIN");
      senhaLida = Utils.lerString("Digite sua senha de acesso: ", sc);

      System.out.println("\n(1) Realizar Login");
      System.out.println("(0) Sair");
      op = Utils.lerInt("Escolha a opção desejada: ", sc);

      switch (op) {
        case 1:
          if (senhaLida.equals(SENHA_GERENTE)) {
            Menus.setGerenteAtivo(true);
            Menus.menuPrincipal(sc);
          } else if (senhaLida.equals(SENHA_VENDEDOR)) {
            Menus.setGerenteAtivo(true);
            Menus.menuPrincipal(sc);
          } else {
            Utils.printAviso("A senha de acesso inserida está incorreta!");
            Utils.aguardarTecla();
          }
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
      Utils.limpaTela();

      Utils.printCabecalho("MENU PRINCIPAL\n");
      System.out.println("(1) Realizar Venda");
      System.out.println("(2) Consultar Veículo");
      System.out.println("(3) Consultar Veículos Disponíveis");
      System.out.println("(4) Consultar Cliente");
      System.out.println("(5) Listar Vendas");

      if (gerenteAtivo)
        System.out.println("(6) Acessar Gerência");

      System.out.println("(0) Sair para o Login");
      op = Utils.lerInt("Digite a opção desejada: ", sc);

      switch (op) {
        case 1:
          ListaVendas.realizarVenda(sc);
          break;
        case 2:
          tipoVeiculo = Menus.consultarTipoVeiculo(sc);

          if (tipoVeiculo != 0)
            // Menus.consultarVeiculo(tipoVeiculo, sc);

            break;
        case 3:
          tipoVeiculo = Menus.consultarTipoVeiculo(sc);

          if (tipoVeiculo != 0)
            // Menus.consultarVeiculosDisponiveis(tipoVeiculo, sc);

            break;
        case 4:
          // ListaClientes.consultarCliente(sc);
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
      Utils.printCabecalho("TIPO DE VEÍCULO\n");
      System.out.println("(1) Carro");
      System.out.println("(2) Moto");
      System.out.println("(0) Voltar");

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

      Utils.printCabecalho("MENU DE GERÊNCIA\n");
      System.out.println("(1) Gerenciar Clientes");
      System.out.println("(2) Gerenciar Vendedores");
      System.out.println("(3) Gerenciar Veículos");
      System.out.println("(4) Gerenciar Vendas");
      System.out.println("(5) Gerar Relatório de Vendas");
      System.out.println("(0) Voltar para o Menu Principal");

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
          Menus.gerenciarVendas(sc);
          break;
        case 5:
          // ListaVendas.gerarRelatorio();
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

      Utils.printCabecalho("GERENCIAR CLIENTES\n");
      System.out.println("(1) Adicionar Cliente");
      System.out.println("(2) Alterar Cliente");
      System.out.println("(3) Excluir Cliente");
      System.out.println("(4) Listar Clientes");
      System.out.println("(0) Voltar para o Menu Gerência");

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

      Utils.printCabecalho("GERENCIAR VENDEDORES\n");
      System.out.println("(1) Adicionar Vendedor");
      System.out.println("(2) Alterar Vendedor");
      System.out.println("(3) Excluir Vendedor");
      System.out.println("(4) Listar Vendedores");
      System.out.println("(0) Voltar para o Menu Gerência");

      op = Utils.lerInt("Digite a opção desejada: ", sc);

      switch (op) {
        case 1:
          ListaVendedores.cadastroVendedor(sc);
          break;
        case 2:
          ListaVendedores.alterarVendedor(sc);
          break;
        case 3:
          ListaVendedores.excluirVendedor(sc);
          break;
        case 4:
          ListaVendedores.listarVendedores();
          break;
        case 0:
          break;
        default:
          Utils.printAviso("Insira uma opção válida!");
      }
    } while (op != 0);
  }

  public static void gerenciarVeiculos(Scanner sc) {
    int op, tipoVeiculo;

    do {
      Utils.limpaTela();

      Utils.printCabecalho("GERENCIAR VEÍCULOS\n");
      System.out.println("(1) Adicionar Veículo");
      System.out.println("(2) Alterar Veículo");
      System.out.println("(3) Excluir Veículo");
      System.out.println("(4) Listar Veículos");
      System.out.println("(0) Voltar para o Menu Gerência");

      op = Utils.lerInt("Digite a opção desejada: ", sc);

      do {
        System.out.println("\n== Qual o tipo de veículo?");
        System.out.println("\n(1) Carro");
        System.out.println("\n(2) Motocicleta");

        tipoVeiculo = Utils.lerInt("Digite o tipo de veículo: ", sc);

        if (tipoVeiculo < 1 && tipoVeiculo > 2)
          Utils.printAviso("Insira uma opção válida!");
      } while (tipoVeiculo < 1 && tipoVeiculo > 2);

      switch (op) {
        case 1:
          if (tipoVeiculo == 1)
            ListaCarros.cadastrarCarro(sc);
          else if (tipoVeiculo == 2)
            ListaMotos.cadastroMotocicleta(sc);
          break;
        case 2:
          if (tipoVeiculo == 1)
            ListaCarros.alterarCarro(sc);
          else if (tipoVeiculo == 2)
            ListaMotos.alterarMotocicleta(sc);
          break;
        case 3:
          if (tipoVeiculo == 1)
            ListaCarros.excluirCarro(sc);
          else if (tipoVeiculo == 2)
            ListaMotos.excluirMotocicleta(sc);
          break;
        case 4:
          if (tipoVeiculo == 1)
            ListaCarros.listarCarros();
          else if (tipoVeiculo == 2)
            ListaMotos.listarMotocicletas();
          break;
        case 0:
          break;
        default:
          Utils.printAviso("Insira uma opção válida!");
      }
    } while (op != 0);
  }

  public static void gerenciarVendas(Scanner sc) {
    int op;

    do {
      Utils.limpaTela();

      Utils.printCabecalho("GERENCIAR VENDEDORES\n");
      System.out.println("(1) Realizar Nova Venda");
      System.out.println("(2) Alterar Venda");
      System.out.println("(3) Excluir Venda");
      System.out.println("(4) Listar Vendas");
      System.out.println("(0) Voltar para o Menu Gerência");

      op = Utils.lerInt("Digite a opção desejada: ", sc);

      switch (op) {
        case 1:
          ListaVendas.realizarVenda(sc);
          break;
        case 2:
          ListaVendas.alterarVenda(sc);
          break;
        case 3:
          ListaVendas.excluirVenda(sc);
          break;
        case 4:
          ListaVendas.listarVendas();
          break;
        case 0:
          break;
        default:
          Utils.printAviso("Insira uma opção válida!");
      }
    } while (op != 0);
  }
}
