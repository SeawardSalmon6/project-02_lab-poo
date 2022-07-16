import java.util.Scanner;

import services.Utilidades;

import java.util.ArrayList;

public class Gerente extends Funcionario {
  private int anosExperiencia;

  ArrayList<Gerente> listaGerentes = new ArrayList<Gerente>();
  Scanner sc = new Scanner(System.in);

  
  // Construtores
  // =======================
  public Gerente(long rg, String nome, Data dataNascimento, Data dataAdmissao, double salario, int anosExperiencia) {
    super(rg, nome, dataNascimento, dataAdmissao, salario);
    this.anosExperiencia = anosExperiencia;
  }
  
  public Gerente(){
    this(0, null, null, null, 0, 0);
  }

  public Gerente(int anosExperiencia) {
    this.anosExperiencia = anosExperiencia;
  }
  // ===================
  //Setters e Getters

public int getAnosExperiencia() {
    return anosExperiencia;
  }

  public void setAnosExperiencia(int anosExperiencia) {
    this.anosExperiencia = anosExperiencia;
  }
  //=====================
  //Metodos

  //Cadastro de gerente 
  public void cadastroGerente(ArrayList<Gerente> listaGerentes, Scanner sc) {
    final Data dataNascimento = new Data();
    final Data dataAdmissao = new Data();
    Gerente g1 = new Gerente();
    Utilidades util = new Utilidades();

    util.printCabecalho("Cadastro de gerente");

    rg = util.lerLong("RG", sc);
    nome = util.lerString("Nome", sc);
    dataNascimento.setDia(util.lerInt("Dia de nascimento", sc));
    dataNascimento.setMes(util.lerInt("Mes de nascimento", sc));
    dataNascimento.setAno(util.lerInt("Ano de nascimento", sc));
    dataAdmissao.setDia(util.lerInt("Dia de nascimento", sc));
    dataAdmissao.setMes(util.lerInt("Mes de nascimento", sc));
    dataAdmissao.setAno(util.lerInt("Ano de nascimento", sc));
    salario = util.lerDouble("Salario", sc);
    anosExperiencia = util.lerInt("Anos de experiencia", sc);

    g1.setRg(rg);
    g1.setNome(nome);
    g1.setDataNascimento(dataNascimento);
    g1.setDataAdmissao(dataAdmissao);
    g1.setSalario(salario);
    g1.setAnosExperiencia(anosExperiencia);

    listaGerentes.add(g1);
    System.out.println("\nCadastro efetuado com sucesso!");
    util.aguardarTecla();
    util.limpaTela();  
  }

  //Consulta 
}