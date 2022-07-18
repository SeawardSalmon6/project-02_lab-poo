package models;

import models.util.Data;

public class Gerente extends Funcionario {
  private int anosExperiencia;

  // ======== Construtores
  public Gerente() {
    this(0, null, null, null, 0, 0);
  }

  public Gerente(long rg, String nome, Data dataNascimento, Data dataAdmissao, double salario, int anosExperiencia) {
    super(rg, nome, dataNascimento, dataAdmissao, salario);
    this.anosExperiencia = anosExperiencia;
  }

  // ====== Setters e Getters
  public int getAnosExperiencia() {
    return anosExperiencia;
  }

  public void setAnosExperiencia(int anosExperiencia) {
    this.anosExperiencia = anosExperiencia;
  }
}