package models.util;

public class Endereco {
  private String rua;
  private int numero;
  private String bairro;
  private String cidade;

  // ========= Métodos de Classe
  public String gerarEndereco() {
    return this.rua + ", " + this.numero + ", " + this.bairro + " - " + this.cidade;
  }

  // ========= Construtores
  public Endereco() {
    this("", 0, "", "");
  }

  public Endereco(String rua, int numero, String bairro, String cidade) {
    this.setRua(rua);
    this.setNumero(numero);
    this.setBairro(bairro);
    this.setCidade(cidade);
  }

  // ========= Getters e Setters
  public String getRua() {
    return this.rua;
  }

  public int getNumero() {
    return this.numero;
  }

  public String getBairro() {
    return this.bairro;
  }

  public String getCidade() {
    return this.cidade;
  }

  public void setRua(String rua) {
    this.rua = rua;
  }

  public void setNumero(int numero) {
    this.numero = numero;
  }

  public void setBairro(String bairro) {
    this.bairro = bairro;
  }

  public void setCidade(String cidade) {
    this.cidade = cidade;
  }
}