package data;

import java.util.Scanner;
import models.Cliente;
import models.util.Data;
import models.util.Endereco;

import java.util.ArrayList;
import services.Utils;

public class ListaClientes {
  private static ArrayList<Cliente> listaClientes = new ArrayList<>();

  // ======= Métodos Auxiliares
  public static ArrayList<Cliente> getLista() {
    return listaClientes;
  }

  public static void setLista(ArrayList<Cliente> novaLista) {
    listaClientes = novaLista;
  }

  public static boolean estaVazia() {
    return listaClientes.size() == 0;
  }

  public static int getQuantidade() {
    return listaClientes.size();
  }

  public static boolean cpfExiste(long cpf) {
    if (ListaClientes.estaVazia())
      return false;

    for (int i = 0; i < listaClientes.size(); i++) {
      if (listaClientes.get(i).getCpf() == cpf) {
        return true;
      }
    }

    return false;
  }

  public static void printarCliente(Cliente cliente) {
    System.out.println("\n| ---------------------------");
    System.out.println("\n| Cliente " + cliente.getNome());
    System.out.println("\n| CPF: " + cliente.getCpf());
    System.out.println("\n| Renda Atual: " + cliente.getRenda());
    System.out.println("\n| Data de Nascimento: " + cliente.getDataNasc().gerarData());
    System.out.println("\n| Endereço: " + cliente.getEndereco().gerarEndereco());
    System.out.println("\n| Quantidade de Dependentes: " + cliente.getDependentes());
    System.out.println("\n| ---------------------------");
  }

  public static void printOpcoesClientes() {
    Cliente cliente;

    if (ListaClientes.estaVazia()) {
      Utils.printAviso("Não existem clientes cadastrados!");
      return;
    }

    for (int i = 0; i < listaClientes.size(); i++) {
      cliente = listaClientes.get(i);

      System.out.printf("\n| Cliente [%d]", cliente.getIdCliente());
      System.out.printf("\n| Nome: %s", cliente.getNome());
      System.out.printf("\n| CPF: %d", cliente.getCpf());
      System.out.println("\n-------------------------");
    }
  }

  public static Cliente buscarCliente(int idCliente) {
    if (ListaClientes.estaVazia())
      return null;

    for (int i = 0; i < listaClientes.size(); i++)
      if (listaClientes.get(i).getIdCliente() == idCliente)
        return listaClientes.get(i);

    return null;
  }

  // Calcula o numero de digitos de um tipo long
  private static long contarDigitosCpf(long x) {
    return (long) Math.floor(Math.log10(x) + 1);
  }

  // ======= Métodos da Classe
  public static void cadastrarCliente(Scanner sc) {
    Cliente novoCliente = new Cliente();
    Data dataNascimento = new Data();
    Endereco novoEndereco = new Endereco();
    long auxCpf;
    boolean erro;

    Utils.limpaTela();
    Utils.printCabecalho("CADASTRAR NOVO CLIENTE");
    novoCliente.setNome(Utils.lerString("Digite o nome do cliente: ", sc));

    do {
      auxCpf = Utils.lerLong("Digite o CPF do cliente: ", sc);

      if (ListaClientes.contarDigitosCpf(auxCpf) != 11) {
        Utils.printAviso("O CPF deve conter exatos 11 dígitos!");
        erro = true;
      } else if (ListaClientes.cpfExiste(auxCpf)) {
        Utils.printAviso("O CPF inserido já existe, digite um válido!");
        erro = true;
      } else
        erro = false;
    } while (erro);

    novoCliente.setCpf(auxCpf);

    System.out.println("\n== Insira a data de nascimento do cliente: ");

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

    novoCliente.setDataNasc(dataNascimento);

    System.out.println("\n== Insira o endereço do cliente: ");
    novoEndereco.setRua(Utils.lerString("Digite a rua: ", sc));
    novoEndereco.setNumero(Utils.lerInt("Digite o número da residência: ", sc));
    novoEndereco.setBairro(Utils.lerString("Digite o bairro: ", sc));
    novoEndereco.setCidade(Utils.lerString("Digite a cidade: ", sc));
    novoCliente.setEndereco(novoEndereco);

    novoCliente.setRenda(Utils.lerFloat("Digite a renda: ", sc));
    novoCliente.setDependentes(Utils.lerInt("Digite a quantidade de dependentes: ", sc));

    listaClientes.add(novoCliente);
    System.out.println("\n---> Cadastro efetuado com sucesso!");
    Utils.aguardarTecla();
  }

  public static void alterarCliente(Scanner sc) {
    Cliente cliente;
    Data dataNascimento;
    Endereco endereco;
    int op;
    long auxCpf;
    boolean erro;

    if (ListaClientes.estaVazia()) {
      Utils.printCabecalho("ALTERAR DADOS DO CLIENTE");
      Utils.printAviso("Não existem clientes cadastrados!");
      Utils.aguardarTecla();
      return;
    }

    do {
      Utils.limpaTela();
      Utils.printCabecalho("ALTERAR DADOS DO CLIENTE");
      ListaClientes.printOpcoesClientes();

      cliente = ListaClientes.buscarCliente(Utils.lerInt("Digite o ID do cliente: ", sc));

      if (cliente == null)
        Utils.printAviso("Insira uma opção válida!");
    } while (cliente == null);

    dataNascimento = cliente.getDataNasc();
    endereco = cliente.getEndereco();

    do {
      Utils.limpaTela();

      Utils.printCabecalho("ALTERAR DADOS DO CLIENTE");

      ListaClientes.printarCliente(cliente);
      System.out.println();

      System.out.println("(1) CPF");
      System.out.println("(2) Nome");
      System.out.println("(3) Data de nascimento");
      System.out.println("(4) Endereço");
      System.out.println("(5) Renda");
      System.out.println("(6) Número de dependentes");
      System.out.println("(0) Cancelar");

      op = Utils.lerInt("Digite a opção desejada: ", sc);

      switch (op) {
        case 1:
          do {
            auxCpf = Utils.lerLong("Digite o novo CPF do cliente: ", sc);

            if (ListaClientes.contarDigitosCpf(auxCpf) != 11) {
              Utils.printAviso("O CPF deve conter exatos 11 dígitos!");
              erro = true;
            } else if (ListaClientes.cpfExiste(auxCpf)) {
              Utils.printAviso("O CPF inserido já existe, digite um válido!");
              erro = true;
            } else
              erro = false;
          } while (erro);

          cliente.setCpf(auxCpf);
          break;
        case 2:
          cliente.setNome(Utils.lerString("Digite o novo nome: ", sc));
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
          System.out.println("\n== Insira o novo endereço: ");

          endereco.setRua(Utils.lerString("Digite a rua: ", sc));
          endereco.setNumero(Utils.lerInt("Digite o número da residência: ", sc));
          endereco.setBairro(Utils.lerString("Digite o bairro: ", sc));
          endereco.setCidade(Utils.lerString("Digite a cidade: ", sc));

          break;
        case 5:
          cliente.setRenda(Utils.lerFloat("Digite a nova renda: ", sc));
          break;
        case 6:
          cliente.setDependentes(Utils.lerInt("Digite o novo número de dependentes: ", sc));
          break;
        default:
          Utils.printAviso("Insira uma opção válida!");
          break;
      }
    } while (op != 0);
  }

  public static void excluirCliente(Scanner sc) {
    Cliente cliente;

    if (ListaClientes.estaVazia()) {
      Utils.printCabecalho("EXCLUIR CLIENTE");
      Utils.printAviso("Não existem clientes cadastrados!");
      Utils.aguardarTecla();
      return;
    }

    do {
      Utils.limpaTela();
      Utils.printCabecalho("EXCLUIR CLIENTE");
      ListaClientes.printOpcoesClientes();

      cliente = ListaClientes.buscarCliente(Utils.lerInt("Digite o ID do cliente: ", sc));

      if (cliente == null)
        Utils.printAviso("Insira uma opção válida!");
    } while (cliente == null);

    ListaClientes.printarCliente(cliente);
    listaClientes.remove(cliente);
    System.out.println("\n---> Cliente removido com sucesso!");
    Utils.aguardarTecla();
  }

  public static void listarClientes() {
    if (ListaClientes.estaVazia()) {
      Utils.printCabecalho("LISTA COMPLETA DE CLIENTES");
      Utils.printAviso("Não existem clientes cadastrados!");
      Utils.aguardarTecla();
      return;
    }

    Utils.printCabecalho("LISTA COMPLETA DE CLIENTES");
    for (int i = 0; i < listaClientes.size(); i++)
      printarCliente(listaClientes.get(i));

    Utils.aguardarTecla();
  }
}
