package data;

import java.util.Scanner;

import models.Cliente;
import models.util.Data;

import java.util.ArrayList;

import services.Utils;

public class ListaClientes {
  private static ArrayList<Cliente> listaClientes = new ArrayList<>();

  // ======= Métodos Auxiliares
  public static boolean estaVazia() {
    return listaClientes.size() == 0;
  }

  public static int getQuantidade() {
    return listaClientes.size();
  }

  public static boolean cpfExiste(long cpf) {
    if (ListaClientes.estaVazia())
      return true;

    for (int i = 0; i < listaClientes.size(); i++) {
      if (listaClientes.get(i).getCpf() == cpf) {
        return false;
      }
    }

    return true;
  }

  // Calcula o numero de digitos de um tipo long
  private static long contarDigitosCpf(long x) {
    return (long) Math.floor(Math.log10(x) + 1);
  }

  // ======= Métodos da Classe
  public void cadastrarCliente(Scanner sc) {
    Cliente novoCliente = new Cliente();
    Data dataNascimento = new Data();
    long auxCpf;
    boolean erro;

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

    System.out.println("== Insira a data de nascimento do cliente: ");
    dataNascimento.setDia(Utils.lerInt("Dia: ", sc));
    dataNascimento.setMes(Utils.lerInt("Mês: ", sc));
    dataNascimento.setAno(Utils.lerInt("Ano: ", sc));

    novoCliente.setDataNasc(dataNascimento);
    novoCliente.setRenda(Utils.lerFloat("Digite a renda: ", sc));
    novoCliente.setDependentes(Utils.lerInt("Digite a quantidade de dependentes: ", sc));

    listaClientes.add(novoCliente);
    System.out.println("\n---> Cadastro efetuado com sucesso!");
    Utils.aguardarTecla();
  }

  //Alteracao
  public void alteraCliente(ArrayList<Cliente> listaClientes, Scanner sc, int id) {

    Utils.printCabecalho("Alterar dados do Cliente");
    System.out.println("\n 1 - CPF");
    System.out.println("\n 2 - Nome");
    System.out.println("\n 3 - Data de nascimento");
    System.out.println("\n 4 - Renda");
    System.out.println("\n 5 - Dependentes");
    int op = Utils.lerInt("Selecione a opcao", sc);

    switch (op) {
      case 1:
        alterarCpf(listaClientes, sc, id);
        break;
      case 2:
        alterarNome(listaClientes, sc, id);
        break;
      case 3:
        alterarDataNasc(listaClientes, sc, id);
        break;
      case 4:
        alterarRenda(listaClientes, sc, id);
        break;
      case 5:
        alterarDependentes(listaClientes, sc, id);
        break;
      default:
        break;
    }
  }

  public void alterarCpf(ArrayList<Cliente> listaClientes, Scanner sc, int id) {

    listaClientes.get(id).setCpf(Utils.lerLong("Novo CPF do Cliente", sc));
    System.out.println("\nCPF do Cliente" + id + "atualizado!");
    Utils.aguardarTecla();
  }

  public void alterarNome(ArrayList<Cliente> listaClientes, Scanner sc, int id) {

    listaClientes.get(id).setNome(Utils.lerString("Novo nome do Cliente", sc));
    System.out.println("\nNome do Cliente" + id + "atualizado!");
    Utils.aguardarTecla();
   
  }

  public void alterarDataNasc(ArrayList<Cliente> listaClientes, Scanner sc, int id) {
    Data dataNascimento = new Data();

    dataNascimento.setDia(Utils.lerInt("Novo dia de nascimento", sc));
    dataNascimento.setMes(Utils.lerInt("Novo mes de nascimento", sc));
    dataNascimento.setAno(Utils.lerInt("Novo ano de nascimento", sc));
    listaClientes.get(id).setDataNasc(dataNascimento);
    System.out.println("\nData de nascimento do Cliente" + id + "atualizada!");
    Utils.aguardarTecla();
  }

  public void alterarRenda(ArrayList<Cliente> listaClientes, Scanner sc, int id) {

    listaClientes.get(id).setRenda(Utils.lerInt("Nova renda do cliente", sc));
    System.out.println("\nRenda do Cliente" + id + "atualizada!");
    Utils.aguardarTecla();
  }

  public void alterarDependentes(ArrayList<Cliente> listaClientes, Scanner sc, int id) {

    listaClientes.get(id).setDependentes(Utils.lerInt("Novo numero de dep. do cliente", sc));
    System.out.println("\nNumero de dependentes do Cliente" + id + "atualizado!");
    Utils.aguardarTecla();
  }
}
