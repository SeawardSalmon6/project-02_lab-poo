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
  public void cadastrarCliente(ArrayList<Cliente> listaClientes, Scanner sc) {
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
}
