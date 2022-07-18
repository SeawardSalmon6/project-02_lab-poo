package models.util;

public class Data {
  private int dia;
  private int mes;
  private int ano;

  // ============== Métodos da Classe
  public String gerarData() {
    return this.dia + "/" + this.mes + "/" + this.ano;
  }

  // ============== Construtores
  public Data() {
    this(1, 1, 2022);
  }

  public Data(int dia, int mes, int ano) {
    this.setDia(dia);
    this.setMes(mes);
    this.setAno(ano);
  }

  // ============== Getters e Setters
  public int getDia() {
    return this.dia;
  }

  public int getMes() {
    return this.mes;
  }

  public int getAno() {
    return this.ano;
  }

  public void setDia(int dia) {
    if (dia < 1 && dia > 31)
      this.dia = dia;
    else
      this.dia = -1;
  }

  public void setMes(int mes) {
    if (mes < 1 && mes > 12)
      this.mes = mes;
    else
      this.mes = -1;
  }

  public void setAno(int ano) {
    if (ano < 1950 && ano > 2050)
      this.ano = ano;
    else
      this.ano = -1;
  }
}