import java.util.Scanner;

import services.Utilidades;

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

  static long count_digit(long x) // Calcula o numero de digitos de um tipo long
  {
    return (long) Math.floor(Math.log10(x) + 1);
  }

  // Cadastro cliente
  public void cadastraCliente(ArrayList<Cliente> listaClientes, Scanner sc) {
    Cliente c1 = new Cliente();
    Data dataNascimento = new Data();
    Utilidades util = new Utilidades();

    util.printCabecalho("Cadastro de cliente");
    nome = util.lerString("Nome", sc);

    do {
      cpf = util.lerLong("CPF do cliente", sc);
    } while (count_digit(cpf) != 11); // verifica se o cpf tem 11 digitos

    dataNascimento.setDia(util.lerInt("Dia de nascimento", sc));
    dataNascimento.setMes(util.lerInt("Mes de nascimento", sc));
    dataNascimento.setAno(util.lerInt("Ano de nascimento", sc));
    renda = util.lerFloat("Renda", sc);
    dependentes = util.lerInt("Numero de dependentes", sc);

    c1.setNome(nome);
    c1.setCpf(cpf);
    c1.setDataNasc(dataNasc);
    c1.setRenda(renda);
    c1.setDependentes(dependentes);

    listaClientes.add(c1);
    System.out.println("\nCadastro efetuado com sucesso!");
    util.aguardarTecla();
    util.limpaTela();
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