package models;

public class Motocicleta extends Veiculo {
  private static int qtdMotos = 0;

  private static final String[] tiposMotocicleta = { "Trail", "Street", "Sport", "Custom" };
  private int idMoto;
  private int cilindradas;
  private int indexTipoMotocicleta;

  // ============ Métodos de Classe
  public String getTipoMotocicleta() {
    return tiposMotocicleta[this.indexTipoMotocicleta];
  }

  public static void printOpcoesTiposMotocicleta() {
    for (int i = 0; i < tiposMotocicleta.length; i++)
      System.out.printf("\n(%d) %s", i + 1, tiposMotocicleta[i]);

    System.out.println();
  }

  // ============ Construtores
  public Motocicleta() {
    this(++qtdMotos, 0, null, null, 0, 0, null, 0, false, 0, 0);
  }

  public Motocicleta(int idMoto, long numChassi, String marca, String modelo, int ano, double km,
      String tipoCombustivel, int peso,
      boolean vendido, int cilindradas, int indexTipoMotocicleta) {
    super(numChassi, marca, modelo, ano, km, tipoCombustivel, peso, vendido);
    this.idMoto = idMoto;
    this.cilindradas = cilindradas;
    this.indexTipoMotocicleta = indexTipoMotocicleta;
  }

  // ============ Getters e Setters
  public int getIdMoto() {
    return this.idMoto;
  }

  public void setIdMoto(int idMoto) {
    this.idMoto = idMoto;
  }

  public int getCilindradas() {
    return this.cilindradas;
  }

  public int getIndexTipoMotocicleta() {
    return this.indexTipoMotocicleta;
  }

  public void setCilindradas(int cilindradas) {
    this.cilindradas = cilindradas;
  }

  public void setIndexTipoMotocicleta(int indexTipoMotocicleta) {
    this.indexTipoMotocicleta = indexTipoMotocicleta;
  }
}