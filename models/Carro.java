package models;

public class Carro extends Veiculo {
  private static final String[] tiposCarro = { "Utilitário", "Pickup", "Sedan", "Hatch", "Esportivo" };
  private int potencia;
  private int numCilindros;
  private int numAssentos;
  private int indexTipoCarro;
  private double altura;
  private double largura;
  private double comprimento;

  // ========= Métodos de Classe
  public String getTipoCarro() {
    return tiposCarro[this.indexTipoCarro];
  }

  public static void printOpcoesTiposCarro() {
    for (int i = 0; i < tiposCarro.length; i++)
      System.out.printf("\n(%d) %s", i + 1, tiposCarro[i]);

    System.out.println();
  }

  // ========= Construtores
  public Carro() {
    this(0, "", "", 0, 0, "", 0, false, 0, 0, 0, 0, 0, 0, 0);
  }

  public Carro(long numChassi, String marca, String modelo, int ano, int km, String tipoCombustivel, int peso,
      boolean vendido, int potencia, int numCilindros, int numAssentos, int indexTipoCarro, double altura,
      double largura, double comprimento) {
    super(numChassi, marca, modelo, ano, km, tipoCombustivel, peso, vendido);
    this.setPotencia(potencia);
    this.setNumCilindros(numCilindros);
    this.setNumAssentos(numAssentos);
    this.setIndexTipoCarro(indexTipoCarro);
    this.setAltura(altura);
    this.setLargura(largura);
    this.setComprimento(comprimento);
  }

  // ========= Getters e Setters
  public static String[] getTiposCarros() {
    return tiposCarro;
  }

  public int getPotencia() {
    return this.potencia;
  }

  public void setPotencia(int potencia) {
    this.potencia = potencia;
  }

  public int getNumCilindros() {
    return this.numCilindros;
  }

  public void setNumCilindros(int numCilindros) {
    this.numCilindros = numCilindros;
  }

  public int getNumAssentos() {
    return this.numAssentos;
  }

  public void setNumAssentos(int numAssentos) {
    this.numAssentos = numAssentos;
  }

  public int getIndexTipoCarro() {
    return this.indexTipoCarro;
  }

  public void setIndexTipoCarro(int indexTipoCarro) {
    this.indexTipoCarro = indexTipoCarro;
  }

  public double getAltura() {
    return this.altura;
  }

  public void setAltura(double altura) {
    this.altura = altura;
  }

  public double getLargura() {
    return this.largura;
  }

  public void setLargura(double largura) {
    this.largura = largura;
  }

  public double getComprimento() {
    return this.comprimento;
  }

  public void setComprimento(double comprimento) {
    this.comprimento = comprimento;
  }
}