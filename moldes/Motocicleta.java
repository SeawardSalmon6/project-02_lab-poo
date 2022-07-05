import java.util.Scanner;
import java.util.ArrayList;

public class Motocicleta extends Veiculo {
  private static final String[] tiposMotocicleta = { "Trail", "Street", "Sport", "Custom" };

  private int cilindradas;
  private int indexTipoMotocicleta;

  ArrayList<Motocicleta> listaMotocicletas = new ArrayList<Motocicleta>();
  Scanner sc = new Scanner(System.in);

  // ============ Métodos de Classe
  public String getTipoMotocicleta() {
    return tiposMotocicleta[this.indexTipoMotocicleta];
  }

  // ============ Construtores
  public Motocicleta(int cilindradas, int indexTipoMotocicleta) {
    this.cilindradas = cilindradas;
    this.indexTipoMotocicleta = indexTipoMotocicleta;
  }

  public Motocicleta(long numChassi, String marca, String modelo, int ano, int km, String tipoCombustivel, int peso,
      boolean vendido, int cilindradas, int indexTipoMotocicleta) {
    super(numChassi, marca, modelo, ano, km, tipoCombustivel, peso, vendido);
    this.cilindradas = cilindradas;
    this.indexTipoMotocicleta = indexTipoMotocicleta;
  }
  
  public Motocicleta(){
    this(0, null, null, 0, 0, null, 0, false, 0, 0);
  }

  // ============ Getters e Setters
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

  //Metodos extra
  // ===========

  public void cadastroMotocicleta(ArrayList<Motocicleta> listaMotocicletas, Scanner sc){
    Motocicleta m1 = new Motocicleta();
    
  }
}