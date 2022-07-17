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
  public void cadastroGerente(Scanner sc) {
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

    novoGerente.setDataAdmissao(dataAdmissao);

    novoGerente.setSalario(Utils.lerDouble("Digite o salário do gerente: ", sc));
    novoGerente.setAnosExperiencia(Utils.lerInt("Digite quantos anos de experiência tem o gerente: ", sc));

    listaGerentes.add(novoGerente);
    System.out.println("\n---> Cadastro efetuado com sucesso!");
    Utils.aguardarTecla();
  }

  //Alteracao
  public void alteraGerente(ArrayList<Gerente> listaGerentes, Scanner sc, int id) {

    Utils.printCabecalho("Alterar dados do Gerente");
    System.out.println("\n 1 - Rg");
    System.out.println("\n 2 - Nome");
    System.out.println("\n 3 - Data de nascimento");
    System.out.println("\n 4 - Data de admissao");
    System.out.println("\n 5 - Salario");
    System.out.println("\n 6 - Anos de experiencia");
    int op = Utils.lerInt("Selecione a opcao", sc);

    switch (op) {
      case 1:
        alterarRg(listaGerentes, sc, id);
        break;
      case 2:
        alterarNome(listaGerentes, sc, id);
        break;
      case 3:
        alterarDataNasc(listaGerentes, sc, id);
        break;
      case 4:
        alterarDataAdmissao(listaGerentes, sc, id);
        break;
      case 5:
        alterarSalario(listaGerentes, sc, id);
        break;
      case 6:
        alterarAnosExperiencia(listaGerentes, sc, id);
        break;
      default:
        break;
    }
  }

  public void alterarRg(ArrayList<Gerente> listaGerentes, Scanner sc, int id) {

    listaGerentes.get(id).setRg(Utils.lerLong("Novo rg do Gerente", sc));
    System.out.println("\nRg do Gerente" + id + "atualizado!");
    Utils.aguardarTecla();
  }

  public void alterarNome(ArrayList<Gerente> listaGerentes, Scanner sc, int id) {

    listaGerentes.get(id).setNome(Utils.lerString("Novo nome do Gerente", sc));
    System.out.println("\nNome do Gerente" + id + "atualizado!");
    Utils.aguardarTecla();
   
  }

  public void alterarDataNasc(ArrayList<Gerente> listaGerentes, Scanner sc, int id) {
    Data dataNascimento = new Data();

    dataNascimento.setDia(Utils.lerInt("Novo dia de nascimento", sc));
    dataNascimento.setMes(Utils.lerInt("Novo mes de nascimento", sc));
    dataNascimento.setAno(Utils.lerInt("Novo ano de nascimento", sc));
    listaGerentes.get(id).setDataNascimento(dataNascimento);
    System.out.println("\nData de nascimento do Gerente" + id + "atualizada!");
    Utils.aguardarTecla();
  }

  public void alterarDataAdmissao(ArrayList<Gerente> listaGerentes, Scanner sc, int id) {
    Data dataAdmissao = new Data();

    dataAdmissao.setDia(Utils.lerInt("Novo dia de admissao", sc));
    dataAdmissao.setMes(Utils.lerInt("Novo mes de admissao", sc));
    dataAdmissao.setAno(Utils.lerInt("Novo ano de admissao", sc));
    listaGerentes.get(id).setDataAdmissao(dataAdmissao);
    System.out.println("\nData de admissao do Gerente" + id + "atualizada!");
    Utils.aguardarTecla();
  }

  public void alterarSalario(ArrayList<Gerente> listaGerentes, Scanner sc, int id) {

    listaGerentes.get(id).setSalario(Utils.lerDouble("Novo salario", sc));
    System.out.println("\nSalario do Gerente" + id + "atualizado!");
    Utils.aguardarTecla();
  }

  public void alterarAnosExperiencia(ArrayList<Gerente> listaGerentes, Scanner sc, int id) {

    listaGerentes.get(id).setAnosExperiencia(Utils.lerInt("Novo ano de experiencia", sc));
    System.out.println("\nAnos de experiencia do Gerente" + id + "atualizado!");
    Utils.aguardarTecla();
  }
}
