public class Carro extends Veiculo {
  private static final String[] tiposCarros = { "Utilitário", "Pickup", "Sedan", "Hatch", "Esportivo" };

  private int potencia;
  private int numCilindros;
  private int numAssentos;
  private int indexTipoCarro;
  private double altura; // Criar classe separada para as dimensoes?
  private double largura;
  private double comprimento;

  // ============ Métodos de Classe
  public String getTipoCarro() {
    return tiposCarros[this.indexTipoCarro];
  }

  // ============ Construtores
  public Carro(int potencia, int numCilindros, int numAssentos, int indexTipoCarro, double altura, double largura,
      double comprimento) {
    this.setPotencia(potencia);
    this.setNumCilindros(numCilindros);
    this.setNumAssentos(numAssentos);
    this.setIndexTipoCarro(indexTipoCarro);
    this.setAltura(altura);
    this.setLargura(largura);
    this.setComprimento(comprimento);
  }

  // ============ Getters e Setters
  public int getPotencia() {
    return this.potencia;
  }

  public int getNumCilindros() {
    return this.numCilindros;
  }

  public int getNumAssentos() {
    return this.numAssentos;
  }

  public int getIndexTipoCarro() {
    return this.indexTipoCarro;
  }

  public double getAltura() {
    return this.altura;
  }

  public double getLargura() {
    return this.largura;
  }

  public double getComprimento() {
    return this.comprimento;
  }

  public void setPotencia(int potencia) {
    this.potencia = potencia;
  }

  public void setNumCilindros(int numCilindros) {
    this.numCilindros = numCilindros;
  }

  public void setNumAssentos(int numAssentos) {
    this.numAssentos = numAssentos;
  }

  public void setIndexTipoCarro(int indexTipoCarro) {
    this.indexTipoCarro = indexTipoCarro;
  }

  public void setAltura(double altura) {
    this.altura = altura;
  }

  public void setLargura(double largura) {
    this.largura = largura;
  }

  public void setComprimento(double comprimento) {
    this.comprimento = comprimento;
  }
}