package data;

import models.util.*;
import services.Utils;
import models.Cliente;
import models.Vendedor;
import models.Carro;
import models.Motocicleta;
import models.Venda;
import java.util.ArrayList;
import java.util.Scanner;

public class ListaVendas {
  private static ArrayList<Venda> listaVendas = new ArrayList<>();

  // ======= Métodos Auxiliares
  public static void setLista(ArrayList<Venda> novaLista) {
    listaVendas = novaLista;
  }

  public static void printarVendas(Venda venda) {
    System.out.println("\n| ---------------------------");
    System.out.println("| Venda " + venda.getIdVenda());
    System.out.println("| Valor Total: " + venda.getValor());
    System.out.println("| Cliente: " + venda.getCliente());
    System.out.println("| Vendedor: " + venda.getVendedor().getNome());
    System.out.println("| Data de venda: " + venda.getData());
    System.out.println("| Horário de venda: " + venda.getHorario());

    if (venda.getCarro() != null)
      System.out.println("| Veículo: " + venda.getCarro().getMarca() + venda.getCarro().getModelo());
    else if (venda.getMotocicleta() != null)
      System.out.println("| Veículo: " + venda.getCarro().getMarca() + venda.getCarro().getModelo());

    System.out.println("| ---------------------------");
  }

  public static ArrayList<Venda> getLista() {
    return listaVendas;
  }

  public static boolean estaVazia() {
    return listaVendas.size() == 0;
  }

  public static int getQuantidade() {
    return listaVendas.size();
  }

  public static Venda buscarVenda(int idVenda) {
    if (ListaVendas.estaVazia())
      return null;

    for (int i = 0; i < listaVendas.size(); i++)
      if (listaVendas.get(i).getIdVenda() == idVenda)
        return listaVendas.get(i);

    return null;
  }

  public static void printOpcoesVendas() {
    Venda venda;

    if (ListaVendas.estaVazia()) {
      Utils.printAviso("Não existem vendas cadastradas!");
      return;
    }

    for (int i = 0; i < listaVendas.size(); i++) {
      venda = listaVendas.get(i);

      System.out.printf("\n| Venda [%d]", venda.getIdVenda());
      System.out.printf("\n| Valor: %s", venda.getValor());
      System.out.printf("\n| Horario: %d", venda.getHorario());
      System.out.println("\n-------------------------");
    }
  }

  // ======= Métodos da Classe
  public static void realizarVenda(Scanner sc) {
    Venda novaVenda = new Venda();
    Data data = new Data();
    Horario horario = new Horario();
    Cliente cliente;
    Vendedor vendedor;
    int op;

    Utils.limpaTela();
    Utils.printCabecalho("CADASTRO DA VENDA");

    if (ListaClientes.estaVazia() || ListaVendedores.estaVazia()
        || (ListaCarros.estaVazia() && ListaMotos.estaVazia())) {
      Utils.printAviso("Não é possível realizar uma nova venda no momento por falta de dados cadastrais.");
      Utils.aguardarTecla();
      return;
    }

    do {
      ListaVendedores.printOpcoesVendedores();
      vendedor = ListaVendedores.buscarVendedor(Utils.lerInt("Digite o ID do vendedor: ", sc));

      if (vendedor == null)
        Utils.printAviso("Insira uma opção válida!");
    } while (vendedor == null);

    do {
      ListaClientes.printOpcoesClientes();
      cliente = ListaClientes.buscarCliente(Utils.lerInt("Digite o ID do cliente: ", sc));

      if (cliente == null)
        Utils.printAviso("Insira uma opção válida!");
    } while (cliente == null);

    do {
      System.out.println("\n== Qual veículo sera vendido?");
      System.out.println("\n(1) Carro");
      System.out.println("\n(2) Motocicleta");

      op = Utils.lerInt("Digite o tipo de veículo: ", sc);

      if (op < 1 && op > 2)
        Utils.printAviso("Insira uma opção válida!");
    } while (op < 1 && op > 2);

    if (op == 1 && !ListaCarros.estaVazia()) {
      Carro carro;

      do {
        ListaCarros.printOpcoesCarros();
        carro = ListaCarros.buscarCarro(Utils.lerInt("Digite o ID do carro: ", sc));

        if (carro == null)
          Utils.printAviso("Insira uma opção válida!");
      } while (carro == null);

    } else if (op == 2 && !ListaCarros.estaVazia()) {
      Motocicleta moto;

      do {
        ListaMotos.printOpcoesMotos();
        moto = ListaMotos.buscarMotocicleta(Utils.lerInt("Digite o ID da motocicleta: ", sc));

        if (moto == null)
          Utils.printAviso("Insira uma opção válida!");
      } while (moto == null);
    }

    novaVenda.setValor(Utils.lerDouble("Digite o valor de venda: ", sc));

    System.out.println("\n== Insira a data de venda: ");

    do {
      data.setDia(Utils.lerInt("Dia: ", sc));

      if (data.getDia() == -1)
        Utils.printAviso("Insira um dia válido!");
    } while (data.getDia() == -1);

    do {
      data.setMes(Utils.lerInt("Mês: ", sc));

      if (data.getMes() == -1)
        Utils.printAviso("Insira um mês válido!");
    } while (data.getMes() == -1);

    do {
      data.setAno(Utils.lerInt("Ano: ", sc));

      if (data.getAno() == -1)
        Utils.printAviso("Insira um ano válido!");
    } while (data.getAno() == -1);

    novaVenda.setData(data);

    System.out.println("\n== Insira a hora da venda: ");

    do {
      horario.setHora(Utils.lerInt("Hora: ", sc));

      if (horario.getHora() == -1)
        Utils.printAviso("Insira uma hora válida!");
    } while (horario.getHora() == -1);

    do {
      horario.setMinuto(Utils.lerInt("Minuto: ", sc));

      if (horario.getMinuto() == -1)
        Utils.printAviso("Insira minuto válido!");
    } while (horario.getMinuto() == -1);

    novaVenda.setHorario(horario);
    listaVendas.add(novaVenda);

    System.out.println("\n---> Venda efetuada com sucesso!");
    Utils.aguardarTecla();
  }

  public static void alterarVenda(Scanner sc) {
    int op;
    Venda venda;
    Data data;
    Horario horario;
    Vendedor vendedor;
    Cliente cliente;

    if (ListaVendas.estaVazia()) {
      Utils.printCabecalho("ALTERAR DADOS DA VENDA");
      Utils.printAviso("Não existem vendas cadastradas!");
      Utils.aguardarTecla();
      return;
    }

    do {
      Utils.limpaTela();
      Utils.printCabecalho("ALTERAR DADOS DA VENDA");
      ListaVendas.printOpcoesVendas();

      venda = ListaVendas.buscarVenda(Utils.lerInt("Digite o ID da venda: ", sc));

      if (venda == null)
        Utils.printAviso("Insira uma opção válida!");
    } while (venda == null);

    data = venda.getData();
    horario = venda.getHorario();

    do {
      Utils.limpaTela();

      Utils.printCabecalho("ALTERAR DADOS DA VENDA");
      System.out.println("(1) Vendedor");
      System.out.println("(2) Cliente");
      System.out.println("(3) Veículo");
      System.out.println("(4) Valor");
      System.out.println("(5) Data");
      System.out.println("(6) Horário");
      System.out.println("(0) Cancelar");
      op = Utils.lerInt("Digite a opção desejada: ", sc);

      switch (op) {
        case 1:
          do {
            System.out.println("\n== Escolha o novo vendedor: ");

            ListaVendedores.printOpcoesVendedores();
            vendedor = ListaVendedores.buscarVendedor(Utils.lerInt("Digite a opção desejada: ", sc));

            if (vendedor == null)
              Utils.printAviso("Insira uma opção válida!");
          } while (vendedor == null);

          venda.setVendedor(vendedor);
          break;
        case 2:
          do {
            System.out.println("\n== Escolha o novo cliente: ");

            ListaClientes.printOpcoesClientes();
            cliente = ListaClientes.buscarCliente(Utils.lerInt("Digite a opção desejada: ", sc));

            if (cliente == null)
              Utils.printAviso("Insira uma opção válida!");
          } while (cliente == null);

          venda.setCliente(cliente);
          break;
        case 3:
          do {
            System.out.println("\n== Qual veículo sera vendido?");
            System.out.println("\n(1) Carro");
            System.out.println("\n(2) Motocicleta");

            op = Utils.lerInt("Digite o tipo de veículo: ", sc);

            if (op < 1 && op > 2)
              Utils.printAviso("Insira uma opção válida!");
          } while (op < 1 && op > 2);

          if (op == 1 && !ListaCarros.estaVazia()) {
            Carro carroAtual, carroNovo;

            do {
              System.out.println("\n== Escolha o novo carro: ");

              ListaCarros.printOpcoesCarros();
              carroNovo = ListaCarros.buscarCarro(Utils.lerInt("Digite o ID do carro: ", sc));

              if (carroNovo == null)
                Utils.printAviso("Insira uma opção válida!");
            } while (carroNovo == null);

            carroAtual = venda.getCarro();
            carroAtual.setVendido(false);
            carroNovo.setVendido(true);
            venda.setCarro(carroNovo);

          } else if (op == 2 && !ListaMotos.estaVazia()) {
            Motocicleta motoAtual, motoNova;

            do {
              ListaMotos.printOpcoesMotos();
              motoNova = ListaMotos.buscarMotocicleta(Utils.lerInt("Digite o ID da motocicleta: ", sc));

              if (motoNova == null)
                Utils.printAviso("Insira uma opção válida!");
            } while (motoNova == null);

            motoAtual = venda.getMotocicleta();
            motoAtual.setVendido(false);
            motoNova.setVendido(true);
            venda.setMotocicleta(motoNova);
          }
          break;
        case 4:
          venda.setValor(Utils.lerDouble("Digite o novo valor: ", sc));
          break;
        case 5:
          System.out.println("\n== Insira a nova data de venda: ");

          do {
            data.setDia(Utils.lerInt("Dia: ", sc));

            if (data.getDia() == -1)
              Utils.printAviso("Insira um dia válido!");
          } while (data.getDia() == -1);

          do {
            data.setMes(Utils.lerInt("Mês: ", sc));

            if (data.getMes() == -1)
              Utils.printAviso("Insira um mês válido!");
          } while (data.getMes() == -1);

          do {
            data.setAno(Utils.lerInt("Ano: ", sc));

            if (data.getAno() == -1)
              Utils.printAviso("Insira um ano válido!");
          } while (data.getAno() == -1);
          break;
        case 6:
          System.out.println("\n== Insira a nova hora de venda: ");

          do {
            horario.setHora(Utils.lerInt("Hora: ", sc));

            if (horario.getHora() == -1)
              Utils.printAviso("Insira uma hora válida!");
          } while (horario.getHora() == -1);

          do {
            horario.setMinuto(Utils.lerInt("Minuto: ", sc));

            if (horario.getMinuto() == -1)
              Utils.printAviso("Insira um minuto válido!");
          } while (horario.getMinuto() == -1);
        case 0:
          break;
        default:
          Utils.printAviso("Insira uma opção válida!");
          break;
      }
    } while (op != 0);
  }

  public static void excluirVenda(Scanner sc) {
    Venda venda;

    if (ListaVendas.estaVazia()) {
      Utils.printCabecalho("EXCLUIR VENDA");
      Utils.printAviso("Não existem vendas cadastradas!");
      Utils.aguardarTecla();
      return;
    }

    do {
      Utils.limpaTela();
      Utils.printCabecalho("EXCLUIR VENDA");
      ListaVendas.printOpcoesVendas();

      venda = ListaVendas.buscarVenda(Utils.lerInt("Digite o ID da venda: ", sc));

      if (venda == null)
        Utils.printAviso("Insira uma opção válida!");
    } while (venda == null);

    ListaVendas.printarVendas(venda);
    listaVendas.remove(venda);

    System.out.println("\n---> Venda removida com sucesso!");
    Utils.aguardarTecla();
  }

  public static void listarVendas() {
    Utils.limpaTela();

    if (ListaVendas.estaVazia()) {
      Utils.printCabecalho("LISTA COMPLETA DE VENDAS");
      Utils.printAviso("Não existem vendas cadastradas!");
      Utils.aguardarTecla();
      return;
    }

    Utils.printCabecalho("LISTA COMPLETA DE VENDAS");
    for (int i = 0; i < listaVendas.size(); i++)
      ListaVendas.printarVendas(listaVendas.get(i));

    Utils.aguardarTecla();
  }
}