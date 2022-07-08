import java.util.Scanner;
import java.util.ArrayList;

public class Cliente {
  private long cpf;
  private String nome;
  private Data dataNasc;
  private float renda;
  private int dependentes;

  ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
  Scanner sc = new Scanner(System.in);

  // Construtores
  public Cliente() {
    this(0, "", null, 0, 0);
  }

  public Cliente(long cpf, String nome, Data dataNasc, float renda, int dependentes) {
    this.cpf = cpf;
    this.nome = nome;
    this.dataNasc = dataNasc;
    this.renda = renda;
    this.dependentes = dependentes;
  }

  static long count_digit(long x) //Calcula o numero de digitos de um tipo long
    {
        return (long)Math.floor(Math.log10(x) + 1);
    }

  public void cadastraCliente(ArrayList<Cliente> listaClientes, Scanner sc) {
    Cliente c1 = new Cliente();
    Data dataNascimento = new Data();

    System.out.println("\nNome do cliente: ");
    sc.next();
    nome = sc.nextLine();
    
    do{
      System.out.println("\nCPF do cliente: ");
      cpf = sc.nextLong();
    }while(count_digit(cpf) != 11); //verifica se o cpf tem 11 digitos

    System.out.println("\nDia de nascimento: ");
    dataNascimento.setDia(sc.nextInt());
    System.out.println("\nMes de nascimento: ");
    dataNascimento.setMes(sc.nextInt());
    System.out.println("\nAno de nascimento: ");
    dataNascimento.setAno(sc.nextInt());
    System.out.println("\nRenda: ");
    renda = sc.nextFloat();
    System.out.println("\nNumero de dependentes: ");
    dependentes = sc.nextInt();

    c1.setNome(nome);
    c1.setCpf(cpf);
    c1.setDataNasc(dataNasc);
    c1.setRenda(renda);
    c1.setDependentes(dependentes);

    listaClientes.add(c1);
    System.out.println("\nCadastro efetuado com sucesso!");
    System.out.println("\nAperte enter para sair do cadastro!");
    sc.nextLine();
    
  }

  // Getters e Setters
  public long getCpf() {
    return cpf;
  }

  public void setCpf(long cpf) {
    this.cpf = cpf;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Data getDataNasc() {
    return dataNasc;
  }

  public void setDataNasc(Data dataNasc) {
    this.dataNasc = dataNasc;
  }

  public float getRenda() {
    return renda;
  }

  public void setRenda(float renda) {
    this.renda = renda;
  }

  public int getDependentes() {
    return dependentes;
  }

  public void setDependentes(int dependentes) {
    this.dependentes = dependentes;
  }
}