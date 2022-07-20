package data;

import java.util.ArrayList;
import java.util.Scanner;
import models.Vendedor;
import services.Utils;
import models.util.Data;

public class ListaVendedores {
  private static ArrayList<Vendedor> listaVendedores = new ArrayList<>();

  // ======= Métodos Auxiliares
  public static ArrayList<Vendedor> getLista() {
    return listaVendedores;
  }

  public static void setLista(ArrayList<Vendedor> novaLista) {
    listaVendedores = novaLista;
  }

  public static boolean estaVazia() {
    return listaVendedores.size() == 0;
  }

  public static int getQuantidade() {
    return listaVendedores.size();
  }

  public static void printarVendedor(Vendedor vendedor) {
    System.out.println("\n| Vendedor " + vendedor.getNome());
    System.out.println("\n| ---------------------------");
    System.out.println("\n| RG: " + vendedor.getRg());
    System.out.println("\n| Data de Nascimento: " + vendedor.getDataNascimento().gerarData());
    System.out.println("\n| Data de Admissão: " + vendedor.getDataAdmissao().gerarData());
    System.out.println("\n| Salário Atual: " + vendedor.getSalario());
    System.out.println("\n| Tempo de Treinamento: " + vendedor.getTempoTreinamento());
    System.out.println("\n| ---------------------------");
  }

  public static void printOpcoesVendedores() {
    Vendedor vendedor;

    if (ListaVendedores.estaVazia()) {
      Utils.printAviso("Não existem vendedores cadastrados!");
      return;
    }

    for (int i = 0; i < listaVendedores.size(); i++) {
      vendedor = listaVendedores.get(i);

      System.out.printf("\n| Vendedor [%d]", vendedor.getIdVendedor());
      System.out.printf("\n| Nome: %s", vendedor.getNome());
      System.out.printf("\n| RG: %d", vendedor.getRg());
      System.out.println("\n-------------------------");
    }
  }

  public static Vendedor buscarVendedor(int idVendedor) {
    if (ListaVendedores.estaVazia())
      return null;

    for (int i = 0; i < listaVendedores.size(); i++)
      if (listaVendedores.get(i).getIdVendedor() == idVendedor)
        return listaVendedores.get(i);

    return null;
  }

  // ====== Métodos da Classe
  public static void cadastroVendedor(Scanner sc) {
    Vendedor novoVendedor = new Vendedor();
    Data dataNascimento = new Data();
    Data dataAdmissao = new Data();

    Utils.limpaTela();
    Utils.printCabecalho("CADASTRAR NOVO VENDEDOR");

    novoVendedor.setRg(Utils.lerLong("Digite o RG: ", sc));
    novoVendedor.setNome(Utils.lerString("Digite o nome: ", sc));

    System.out.println("\n== Insira a data de nascimento do vendedor: ");

    do {
      dataNascimento.setDia(Utils.lerInt("Dia: ", sc));

      if (dataNascimento.getDia() == -1)
        Utils.printAviso("Insira um dia válido!");
    } while (dataNascimento.getDia() == -1);

    do {
      dataNascimento.setMes(Utils.lerInt("Mês: ", sc));

      if (dataNascimento.getMes() == -1)
        Utils.printAviso("Insira um mês válido!");
    } while (dataNascimento.getMes() == -1);

    do {
      dataNascimento.setAno(Utils.lerInt("Ano: ", sc));

      if (dataNascimento.getAno() == -1)
        Utils.printAviso("Insira um ano válido!");
    } while (dataNascimento.getAno() == -1);

    novoVendedor.setDataNascimento(dataNascimento);

    System.out.println("\n== Insira a data de admissão do vendedor: ");

    do {
      dataAdmissao.setDia(Utils.lerInt("Dia: ", sc));

      if (dataAdmissao.getDia() == -1)
        Utils.printAviso("Insira um dia válido!");
    } while (dataAdmissao.getDia() == -1);

    do {
      dataAdmissao.setMes(Utils.lerInt("Mês: ", sc));

      if (dataAdmissao.getMes() == -1)
        Utils.printAviso("Insira um mês válido!");
    } while (dataAdmissao.getMes() == -1);

    do {
      dataAdmissao.setAno(Utils.lerInt("Ano: ", sc));

      if (dataAdmissao.getAno() == -1)
        Utils.printAviso("Insira um ano válido!");
    } while (dataAdmissao.getAno() == -1);

    novoVendedor.setDataAdmissao(dataAdmissao);

    novoVendedor.setSalario(Utils.lerDouble("Digite o salário do vendedor: ", sc));
    novoVendedor.setTempoTreinamento(Utils.lerInt("Digite o tempo de treinamento: ", sc));

    listaVendedores.add(novoVendedor);
    System.out.println("\n---> Cadastro efetuado com sucesso!");
    Utils.aguardarTecla();
  }

  // Alteracao de dados
  public static void alterarVendedor(Scanner sc) {
    int op;
    Vendedor vendedor;
    Data dataNascimento;
    Data dataAdmissao;

    if (ListaVendedores.estaVazia()) {
      Utils.printCabecalho("ALTERAR DADOS DO VENDEDOR");
      Utils.printAviso("Não existem vendedores cadastrados!");
      Utils.aguardarTecla();
      return;
    }

    do {
      Utils.limpaTela();
      Utils.printCabecalho("ALTERAR DADOS DO VENDEDOR");
      ListaVendedores.printOpcoesVendedores();

      vendedor = ListaVendedores.buscarVendedor(Utils.lerInt("Digite o ID do vendedor: ", sc));

      if (vendedor == null)
        Utils.printAviso("Insira uma opção válida!");
    } while (vendedor == null);

    dataNascimento = vendedor.getDataNascimento();
    dataAdmissao = vendedor.getDataAdmissao();

    do {
      Utils.limpaTela();

      Utils.printCabecalho("ALTERAR DADOS DO VENDEDOR");

      ListaVendedores.printarVendedor(vendedor);
      System.out.println();

      System.out.println("(1) RG");
      System.out.println("(2) Nome");
      System.out.println("(3) Data de nascimento");
      System.out.println("(4) Data de admissão");
      System.out.println("(5) Salário");
      System.out.println("(6) Tempo treinamento");
      System.out.println("(0) Cancelar");

      op = Utils.lerInt("Digite a opção desejada: ", sc);

      switch (op) {
        case 1:
          vendedor.setRg(Utils.lerLong("Digite o novo RG: ", sc));
          break;
        case 2:
          vendedor.setNome(Utils.lerString("Digite o novo nome: ", sc));
          break;
        case 3:
          System.out.println("\n== Insira a nova data de nascimento: ");

          do {
            dataNascimento.setDia(Utils.lerInt("Dia: ", sc));

            if (dataNascimento.getDia() == -1)
              Utils.printAviso("Insira um dia válido!");
          } while (dataNascimento.getDia() == -1);

          do {
            dataNascimento.setMes(Utils.lerInt("Mês: ", sc));

            if (dataNascimento.getMes() == -1)
              Utils.printAviso("Insira um mês válido!");
          } while (dataNascimento.getMes() == -1);

          do {
            dataNascimento.setAno(Utils.lerInt("Ano: ", sc));

            if (dataNascimento.getAno() == -1)
              Utils.printAviso("Insira um ano válido!");
          } while (dataNascimento.getAno() == -1);
          break;
        case 4:
          System.out.println("\n== Insira a nova data de admissão: ");

          do {
            dataAdmissao.setDia(Utils.lerInt("Dia: ", sc));

            if (dataAdmissao.getDia() == -1)
              Utils.printAviso("Insira um dia válido!");
          } while (dataAdmissao.getDia() == -1);

          do {
            dataAdmissao.setMes(Utils.lerInt("Mês: ", sc));

            if (dataAdmissao.getMes() == -1)
              Utils.printAviso("Insira um mês válido!");
          } while (dataAdmissao.getMes() == -1);

          do {
            dataAdmissao.setAno(Utils.lerInt("Ano: ", sc));

            if (dataAdmissao.getAno() == -1)
              Utils.printAviso("Insira um ano válido!");
          } while (dataAdmissao.getAno() == -1);
          break;
        case 5:
          vendedor.setSalario(Utils.lerDouble("Digite o novo salário: ", sc));
          break;
        case 6:
          vendedor.setTempoTreinamento(Utils.lerInt("Digite o novo tempo de treinamento: ", sc));
          break;
        default:
          Utils.printAviso("Insira uma opção válida!");
          break;
      }
    } while (op != 0);

    Utils.aguardarTecla();
  }

  public static void excluirVendedor(Scanner sc) {
    Vendedor vendedor;

    if (ListaVendedores.estaVazia()) {
      Utils.printCabecalho("EXCLUIR VENDEDOR");
      Utils.printAviso("Não existem vendedores cadastrados!");
      Utils.aguardarTecla();
      return;
    }

    do {
      Utils.limpaTela();
      Utils.printCabecalho("EXCLUIR VENDEDOR");
      ListaVendedores.printOpcoesVendedores();

      vendedor = ListaVendedores.buscarVendedor(Utils.lerInt("Digite o ID do vendedor: ", sc));

      if (vendedor == null)
        Utils.printAviso("Insira uma opção válida!");
    } while (vendedor == null);

    ListaVendedores.printarVendedor(vendedor);
    listaVendedores.remove(vendedor);

    System.out.println("\n---> Vendedor removido com sucesso!");
    Utils.aguardarTecla();
  }

  public static void listarVendedores() {
    Utils.limpaTela();

    if (ListaVendedores.estaVazia()) {
      Utils.printCabecalho("LISTA COMPLETA DE VENDEDORES");
      Utils.printAviso("Não existem vendedores cadastrados!");
      Utils.aguardarTecla();
      return;
    }

    Utils.printCabecalho("LISTA COMPLETA DE VENDEDORES");
    for (int i = 0; i < listaVendedores.size(); i++)
      ListaVendedores.printarVendedor(listaVendedores.get(i));

    Utils.aguardarTecla();
  }
}