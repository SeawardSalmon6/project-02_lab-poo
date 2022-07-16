package moldes;

import java.util.Scanner;
import moldes.aux.Data;
import services.Utils;
import java.util.ArrayList;

public class Vendedor extends Funcionario {
  private int tempoTreinamento;
  private Gerente gerenteResponsavel;

  public Vendedor(long rg, String nome, Data dataNascimento, Data dataAdmissao, double salario, int tempoTreinamento,
      Gerente gerenteResponsavel) {
    super(rg, nome, dataNascimento, dataAdmissao, salario);
    this.tempoTreinamento = tempoTreinamento;
    this.gerenteResponsavel = gerenteResponsavel;
  }

  public Vendedor() {
    this(0, null, null, null, 0, 0, null);
  }

  public int getTempoTreinamento() {
    return tempoTreinamento;
  }

  public void setTempoTreinamento(int tempoTreinamento) {
    this.tempoTreinamento = tempoTreinamento;
  }

  public Gerente getGerenteResponsavel() {
    return gerenteResponsavel;
  }

  public void setGerenteResponsavel(Gerente gerenteResponsavel) {
    this.gerenteResponsavel = gerenteResponsavel;
  }

  // =============== Metodos

  public void cadastroVendedor(ArrayList<Vendedor> listaVendedores, Scanner sc) {
    final Data dataNascimento = new Data();
    final Data dataAdmissao = new Data();
    Vendedor v1 = new Vendedor();
    Gerente gerenteResponsavel = new Gerente();

    Utils util = new Utils();

    util.printCabecalho("Cadastro de vendedor");
    rg = util.lerLong("RG", sc);
    nome = util.lerString("Nome", sc);
    dataNascimento.setDia(util.lerInt("Dia de nascimento", sc));
    dataNascimento.setMes(util.lerInt("Mes de nascimento", sc));
    dataNascimento.setAno(util.lerInt("Ano de nascimento", sc));
    dataAdmissao.setDia(util.lerInt("Dia de nascimento", sc));
    dataAdmissao.setMes(util.lerInt("Mes de nascimento", sc));
    dataAdmissao.setAno(util.lerInt("Ano de nascimento", sc));
    salario = util.lerDouble("Salario", sc);
    tempoTreinamento = util.lerInt("Tempo de treinamento", sc);
    gerenteResponsavel.setNome(util.lerString("Nome do gerente responsavel", sc));

    v1.setRg(rg);
    v1.setNome(nome);
    v1.setDataNascimento(dataNascimento);
    v1.setDataAdmissao(dataAdmissao);
    v1.setSalario(salario);
    v1.setTempoTreinamento(tempoTreinamento);
    v1.setGerenteResponsavel(gerenteResponsavel);

    listaVendedores.add(v1);
    System.out.println("\nCadastro efetuado com sucesso!");
    util.aguardarTecla();
    util.limpaTela();
  }

  // Alteracao de dados
  public void alteraVendedor(ArrayList<Vendedor> listaVendedores, Scanner sc, int id) {
    Utils util = new Utils();

    util.printCabecalho("Alterar dados do vendedor");
    System.out.println("\n 1 - Rg");
    System.out.println("\n 2 - Nome");
    System.out.println("\n 3 - Data de nascimento");
    System.out.println("\n 4 - Data de admissao");
    System.out.println("\n 5 - Salario");
    System.out.println("\n 6 - Tempo treinamento");
    System.out.println("\n 7 - Gerente responsavel");
    int op = util.lerInt("Selecione a opcao", sc);

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
    Utils util = new Utils();

    rg = util.lerLong("Novo rg do vendedor", sc);
    listaVendedores.get(id).setRg(rg);
    System.out.println("\nRg do vendedor" + id + "atualizado!");
    util.aguardarTecla();
    util.limpaTela();
  }

  public void alterarNome(ArrayList<Vendedor> listaVendedores, Scanner sc, int id) {
    Utils util = new Utils();

    nome = util.lerString("Novo nome do vendedor", sc);
    listaVendedores.get(id).setNome(nome);
    System.out.println("\nNome do vendedor" + id + "atualizado!");
    util.aguardarTecla();
    util.limpaTela();
  }

  public void alterarDataNasc(ArrayList<Vendedor> listaVendedores, Scanner sc, int id) {
    Utils util = new Utils();

    dataNascimento.setDia(util.lerInt("Novo dia de nascimento", sc));
    dataNascimento.setMes(util.lerInt("Novo mes de nascimento", sc));
    dataNascimento.setAno(util.lerInt("Novo ano de nascimento", sc));
    listaVendedores.get(id).setDataNascimento(dataNascimento);
    System.out.println("\nData de nascimento do vendedor" + id + "atualizada!");
    util.aguardarTecla();
    util.limpaTela();
  }

  public void alterarDataAdmissao(ArrayList<Vendedor> listaVendedores, Scanner sc, int id) {
    Utils util = new Utils();

    dataNascimento.setDia(util.lerInt("Novo dia de admissao", sc));
    dataNascimento.setMes(util.lerInt("Novo mes de admissao", sc));
    dataNascimento.setAno(util.lerInt("Novo ano de admissao", sc));
    listaVendedores.get(id).setDataAdmissao(dataAdmissao);
    System.out.println("\nData de admissao do vendedor" + id + "atualizada!");
    util.aguardarTecla();
    util.limpaTela();
  }

  public void alterarSalario(ArrayList<Vendedor> listaVendedores, Scanner sc, int id) {
    Utils util = new Utils();

    salario = util.lerDouble("Novo salario", sc);
    listaVendedores.get(id).setSalario(salario);
    System.out.println("\nSalario do vendedor" + id + "atualizado!");
    util.aguardarTecla();
    util.limpaTela();
  }

  public void alterarTempoTreinamento(ArrayList<Vendedor> listaVendedores, Scanner sc, int id) {
    Utils util = new Utils();

    tempoTreinamento = util.lerInt("Novo tempo de treinamento", sc);
    listaVendedores.get(id).setTempoTreinamento(tempoTreinamento);
    System.out.println("\nTempo de treinamento do vendedor" + id + "atualizado!");
    util.aguardarTecla();
    util.limpaTela();
  }

  public void alterarGerente(ArrayList<Vendedor> listaVendedores, Scanner sc, int id) {
    Utils util = new Utils();

    gerenteResponsavel.setNome(util.lerString("Nome do novo gerente responsavel", sc));
    listaVendedores.get(id).setGerenteResponsavel(gerenteResponsavel);
    System.out.println("\nSalario do vendedor" + id + "atualizado!");
    util.aguardarTecla();
    util.limpaTela();
  }
}