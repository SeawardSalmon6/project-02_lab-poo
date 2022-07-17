package data;

import java.util.ArrayList;
import java.util.Scanner;

import models.Gerente;
import models.util.Data;
import services.Utils;

public class ListaGerentes {
  private static ArrayList<Gerente> listaGerentes = new ArrayList<>();

  // ======= Métodos Auxiliares
  public static boolean estaVazia() {
    return listaGerentes.size() == 0;
  }

  public static int getQuantidade() {
    return listaGerentes.size();
  }

  // ======= Métodos da Classe
  public void cadastroGerente(ArrayList<Gerente> listaGerentes, Scanner sc) {
    Gerente novoGerente = new Gerente();
    Data dataNascimento = new Data();
    Data dataAdmissao = new Data();

    Utils.printCabecalho("CADASTRO DE GERENTE");

    novoGerente.setRg(Utils.lerLong("Digite o RG: ", sc));
    novoGerente.setNome(Utils.lerString("Digite o nome: ", sc));

    System.out.println("== Insira a data de nascimento do gerente: ");
    dataNascimento.setDia(Utils.lerInt("Dia: ", sc));
    dataNascimento.setMes(Utils.lerInt("Mês: ", sc));
    dataNascimento.setAno(Utils.lerInt("Ano: ", sc));

    novoGerente.setDataNascimento(dataNascimento);

    System.out.println("== Insira a data de admissão do gerente: ");
    dataAdmissao.setDia(Utils.lerInt("Dia: ", sc));
    dataAdmissao.setMes(Utils.lerInt("Mês: ", sc));
    dataAdmissao.setAno(Utils.lerInt("Ano: ", sc));

    novoGerente.setDataAdmissao(dataNascimento);

    novoGerente.setSalario(Utils.lerDouble("Digite o salário do gerente: ", sc));
    novoGerente.setAnosExperiencia(Utils.lerInt("Digite quantos anos de experiência tem o gerente: ", sc));

    listaGerentes.add(novoGerente);
    System.out.println("\n---> Cadastro efetuado com sucesso!");
    Utils.aguardarTecla();
  }
}
