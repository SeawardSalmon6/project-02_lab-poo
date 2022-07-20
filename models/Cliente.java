package models;

import models.util.Data;
import models.util.Endereco;

public class Cliente {
  private static int qtdClientes = 0;

  private int idCliente;
  private long cpf;
  private String nome;
  private Data dataNasc;
  private Endereco endereco;
  private float renda;
  private int dependentes;

  // Construtores
  public Cliente() {
    this(++qtdClientes, 0, "", null, null, 0, 0);
  }

  public Cliente(int idCliente, long cpf, String nome, Data dataNasc, Endereco endereco, float renda, int dependentes) {
    this.idCliente = idCliente;
    this.cpf = cpf;
    this.nome = nome;
    this.dataNasc = dataNasc;
    this.endereco = endereco;
    this.renda = renda;
    this.dependentes = dependentes;
  }

  // ======= Getters e Setters
  public int getIdCliente() {
    return this.idCliente;
  }

  public long getCpf() {
    return this.cpf;
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

  public void setIdCliente(int idCliente) {
    this.idCliente = idCliente;
  }

  public void setDependentes(int dependentes) {
    this.dependentes = dependentes;
  }

  public void setEndereco(Endereco endereco) {
    this.endereco = endereco;
  }

  public Endereco getEndereco() {
    return this.endereco;
  }
}