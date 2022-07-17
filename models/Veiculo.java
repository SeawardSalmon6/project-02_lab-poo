package models;

public abstract class Veiculo {
  protected long numChassi;
  protected String marca;
  protected String modelo;
  protected int ano;
  protected double km;
  protected String tipoCombustivel;
  protected double peso;
  protected boolean vendido;

  // ============= Construtores
  public Veiculo() {
    this(0, "", "", 0, 0, "", 0, false);
  }

  public Veiculo(long numChassi, String marca, String modelo, int ano, double km, String tipoCombustivel, double peso,
      boolean vendido) {
    this.setNumChassi(numChassi);
    this.setMarca(marca);
    this.setModelo(modelo);
    this.setAno(ano);
    this.setKm(km);
    this.setTipoCombustivel(tipoCombustivel);
    this.setPeso(peso);
    this.setVendido(vendido);
  }

  // ============= Getters e Setters
  public long getNumChassi() {
    return this.numChassi;
  }

  public String getMarca() {
    return this.marca;
  }

  public String getModelo() {
    return this.modelo;
  }

  public int getAno() {
    return this.ano;
  }

  public double getKm() {
    return this.km;
  }

  public String getTipoCombustivel() {
    return this.tipoCombustivel;
  }

  public double getPeso() {
    return this.peso;
  }

  public boolean getVendido() {
    return this.vendido;
  }

  public void setNumChassi(long numChassi) {
    this.numChassi = numChassi;
  }

  public void setMarca(String marca) {
    this.marca = marca;
  }

  public void setModelo(String modelo) {
    this.modelo = modelo;
  }

  public void setAno(int ano) {
    this.ano = ano;
  }

  public void setKm(double km) {
    this.km = km;
  }

  public void setTipoCombustivel(String tipoCombustivel) {
    this.tipoCombustivel = tipoCombustivel;
  }

  public void setPeso(double peso) {
    this.peso = peso;
  }

  public void setVendido(boolean vendido) {
    this.vendido = vendido;
  }
}