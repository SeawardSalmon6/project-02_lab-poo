package data;

import java.util.ArrayList;
import java.util.Scanner;
import models.Vendedor;
import services.Utils;
import models.util.Data;
import models.Gerente;

public class ListaVendedores {
  private static ArrayList<Vendedor> listaVendedores = new ArrayList<>();

  // ======= Métodos Auxiliares
  public static boolean estaVazia() {
    return listaVendedores.size() == 0;
  }

  public static int getQuantidade() {
    return listaVendedores.size();
  }

  //Metodos da classe 
  public void cadastroVendedor(Scanner sc) {
    final Data dataNascimento = new Data();
    final Data dataAdmissao = new Data();
    Vendedor novoVendedor = new Vendedor();
    Gerente gerenteResponsavel = new Gerente();

    Utils.printCabecalho("Cadastro de vendedor");

    novoVendedor.setRg(Utils.lerLong("RG", sc));
    novoVendedor.setNome(Utils.lerString("Nome", sc));
    dataNascimento.setDia(Utils.lerInt("Dia de nascimento", sc));
    dataNascimento.setMes(Utils.lerInt("Mes de nascimento", sc));
    dataNascimento.setAno(Utils.lerInt("Ano de nascimento", sc));
    dataAdmissao.setDia(Utils.lerInt("Dia de nascimento", sc));
    dataAdmissao.setMes(Utils.lerInt("Mes de nascimento", sc));
    dataAdmissao.setAno(Utils.lerInt("Ano de nascimento", sc));
    novoVendedor.setDataNascimento(dataNascimento);
    novoVendedor.setDataAdmissao(dataAdmissao);
    novoVendedor.setSalario(Utils.lerDouble("Salario", sc));
    novoVendedor.setTempoTreinamento(Utils.lerInt("Tempo de treinamento", sc));
    gerenteResponsavel.setNome(Utils.lerString("Nome do gerente responsavel", sc));
    novoVendedor.setGerenteResponsavel(gerenteResponsavel);

    listaVendedores.add(novoVendedor);
    System.out.println("\nCadastro efetuado com sucesso!");
    Utils.aguardarTecla();
  }

  // Alteracao de dados
  public void alteraVendedor(ArrayList<Vendedor> listaVendedores, Scanner sc, int id) {

    Utils.printCabecalho("Alterar dados do vendedor");
    System.out.println("\n 1 - Rg");
    System.out.println("\n 2 - Nome");
    System.out.println("\n 3 - Data de nascimento");
    System.out.println("\n 4 - Data de admissao");
    System.out.println("\n 5 - Salario");
    System.out.println("\n 6 - Tempo treinamento");
    System.out.println("\n 7 - Gerente responsavel");
    int op = Utils.lerInt("Selecione a opcao", sc);

    switch (op) {
      case 1:
        alterarRg(listaVendedores, sc, id);
        break;
      case 2:
        alterarNome(listaVendedores, sc, id);
        break;
      case 3:
        alterarDataNasc(listaVendedores, sc, id);
        break;
      case 4:
        alterarDataAdmissao(listaVendedores, sc, id);
        break;
      case 5:
        alterarSalario(listaVendedores, sc, id);
        break;
      case 6:
        alterarTempoTreinamento(listaVendedores, sc, id);
        break;
      case 7:
        alterarGerente(listaVendedores, sc, id);
        break;
      default:
        break;
    }

  }

  public void alterarRg(ArrayList<Vendedor> listaVendedores, Scanner sc, int id) {

    listaVendedores.get(id).setRg(Utils.lerLong("Novo rg do vendedor", sc));
    System.out.println("\nRg do vendedor" + id + "atualizado!");
    Utils.aguardarTecla();
  }

  public void alterarNome(ArrayList<Vendedor> listaVendedores, Scanner sc, int id) {

    listaVendedores.get(id).setNome(Utils.lerString("Novo nome do vendedor", sc));
    System.out.println("\nNome do vendedor" + id + "atualizado!");
    Utils.aguardarTecla();
   
  }

  public void alterarDataNasc(ArrayList<Vendedor> listaVendedores, Scanner sc, int id) {
    Data dataNascimento = new Data();

    dataNascimento.setDia(Utils.lerInt("Novo dia de nascimento", sc));
    dataNascimento.setMes(Utils.lerInt("Novo mes de nascimento", sc));
    dataNascimento.setAno(Utils.lerInt("Novo ano de nascimento", sc));
    listaVendedores.get(id).setDataNascimento(dataNascimento);
    System.out.println("\nData de nascimento do vendedor" + id + "atualizada!");
    Utils.aguardarTecla();
  }

  public void alterarDataAdmissao(ArrayList<Vendedor> listaVendedores, Scanner sc, int id) {
    Data dataAdmissao = new Data();

    dataAdmissao.setDia(Utils.lerInt("Novo dia de admissao", sc));
    dataAdmissao.setMes(Utils.lerInt("Novo mes de admissao", sc));
    dataAdmissao.setAno(Utils.lerInt("Novo ano de admissao", sc));
    listaVendedores.get(id).setDataAdmissao(dataAdmissao);
    System.out.println("\nData de admissao do vendedor" + id + "atualizada!");
    Utils.aguardarTecla();
  }

  public void alterarSalario(ArrayList<Vendedor> listaVendedores, Scanner sc, int id) {

    listaVendedores.get(id).setSalario(Utils.lerDouble("Novo salario", sc));
    System.out.println("\nSalario do vendedor" + id + "atualizado!");
    Utils.aguardarTecla();
  }

  public void alterarTempoTreinamento(ArrayList<Vendedor> listaVendedores, Scanner sc, int id) {

    listaVendedores.get(id).setTempoTreinamento(Utils.lerInt("Novo tempo de treinamento", sc));
    System.out.println("\nTempo de treinamento do vendedor" + id + "atualizado!");
    Utils.aguardarTecla();
  }

  public void alterarGerente(ArrayList<Vendedor> listaVendedores, Scanner sc, int id) {
    Gerente gerenteResponsavel = new Gerente();
    gerenteResponsavel.setNome(Utils.lerString("Nome do novo gerente responsavel", sc));
    listaVendedores.get(id).setGerenteResponsavel(gerenteResponsavel);
    System.out.println("\nSalario do vendedor" + id + "atualizado!");
    Utils.aguardarTecla();
    Utils.limpaTela();
  }
}
