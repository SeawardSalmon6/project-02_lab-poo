package models;
import models.util.Data;

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

}