package models;

import models.util.Data;

public class Vendedor extends Funcionario {
  private static int qtdVendedores = 0;

  private int idVendedor;
  private int tempoTreinamento;

  public Vendedor() {
    this(++qtdVendedores, 0, null, null, null, 0, 0);
  }

  public Vendedor(int idVendedor, long rg, String nome, Data dataNascimento, Data dataAdmissao, double salario,
      int tempoTreinamento) {
    super(rg, nome, dataNascimento, dataAdmissao, salario);
    this.idVendedor = idVendedor;
    this.tempoTreinamento = tempoTreinamento;
  }

  public int getIdVendedor() {
    return this.idVendedor;
  }

  public void setIdVendedor(int idVendedor) {
    this.idVendedor = idVendedor;
  }

  public int getTempoTreinamento() {
    return tempoTreinamento;
  }

  public void setTempoTreinamento(int tempoTreinamento) {
    this.tempoTreinamento = tempoTreinamento;
  }
}