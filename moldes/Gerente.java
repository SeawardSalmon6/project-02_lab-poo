import java.util.Scanner;
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

    System.out.println("\nRG: ");
    rg = sc.nextLong();
    System.out.println("\nNome: ");
    sc.next();
    nome = sc.nextLine();
    System.out.println("\nDia de nascimento: ");
    dataNascimento.setDia(sc.nextInt());
    System.out.println("\nMes de nascimento: ");
    dataNascimento.setMes(sc.nextInt());
    System.out.println("\nAno de nascimento: ");
    dataNascimento.setAno(sc.nextInt());
    System.out.println("\nDia de admissao: ");
    dataAdmissao.setDia(sc.nextInt());
    System.out.println("\nMes de admissao: ");
    dataAdmissao.setMes(sc.nextInt());
    System.out.println("\nAno de admissao: ");
    dataAdmissao.setAno(sc.nextInt());
    System.out.println("\nSalario: ");
    salario = sc.nextDouble();
    System.out.println("\nAnos de experiencia: ");
    anosExperiencia = sc.nextInt();

    g1.setRg(rg);
    g1.setNome(nome);
    g1.setDataNascimento(dataNascimento);
    g1.setDataAdmissao(dataAdmissao);
    g1.setSalario(salario);
    g1.setAnosExperiencia(anosExperiencia);

    listaGerentes.add(g1);
    System.out.println("\nCadastro efetuado com sucesso!");
    System.out.println("\nAperte enter para sair do cadastro!");
    sc.nextLine();
  }
}