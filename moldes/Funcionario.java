package moldes;

import moldes.aux.Data;

public class Funcionario {
  protected long rg;
  protected String nome;
  protected Data dataNascimento;
  protected Data dataAdmissao;
  protected double salario;

  // ============= Construtores
  public Funcionario() {
    this(0, "", null, null, 0);
  }

  public Funcionario(long rg, String nome, Data dataNascimento, Data dataAdmissao, double salario) {
    this.setRg(rg);
    this.setNome(nome);
    this.setDataNascimento(dataNascimento);
    this.setDataAdmissao(dataAdmissao);
    this.setSalario(salario);
  }

  // ============= Getters e Setters
  public long getRg() {
    return this.rg;
  }

  public String getNome() {
    return this.nome;
  }

  public Data getDataNascimento() {
    return this.dataNascimento;
  }

  public Data getDataAdmissao() {
    return this.dataAdmissao;
  }

  public double getSalario() {
    return this.salario;
  }

  public void setRg(long rg) {
    this.rg = rg;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public void setDataNascimento(Data dataNascimento) {
    this.dataNascimento = dataNascimento;
  }

  public void setDataAdmissao(Data dataAdmissao) {
    this.dataAdmissao = dataAdmissao;
  }

  public void setSalario(double salario) {
    this.salario = salario;
  }
}