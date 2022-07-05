import java.util.Scanner;
import java.util.ArrayList;

public class Vendedor extends Funcionario {
  private int tempoTreinamento;
  private Gerente gerenteResponsavel;

  Scanner sc = new Scanner(System.in);
  ArrayList<Vendedor> vendedores = new ArrayList<Vendedor>();

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
    System.out.println("\nTempo de treinamento: ");
    tempoTreinamento = sc.nextInt();
    System.out.println("\nGerente responsavel: ");
    gerenteResponsavel.setNome(sc.next());

    v1.setRg(rg);
    v1.setNome(nome);
    v1.setDataNascimento(dataNascimento);
    v1.setDataAdmissao(dataAdmissao);
    v1.setSalario(salario);
    v1.setTempoTreinamento(tempoTreinamento);
    v1.setGerenteResponsavel(gerenteResponsavel);

    listaVendedores.add(v1);
    System.out.println("\nCadastro efetuado com sucesso!");
    System.out.println("\nAperte enter para sair do cadastro!");
    sc.nextLine();
  }
}