import java.util.Scanner;
import java.util.ArrayList;

public class Motocicleta extends Veiculo {

  private static final String[] tiposMotocicleta = { "Trail", "Street", "Sport", "Custom" };
  private int op;
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

  public Motocicleta() {
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

  // Metodos extra
  // ===========
  public void cadastroMotocicleta(ArrayList<Motocicleta> listaMotocicletas, Scanner sc) {
    Motocicleta m1 = new Motocicleta();

    System.out.println("\nNumero do Chassi: ");
    numChassi = sc.nextLong();
    System.out.println("Marca da moto: ");
    sc.next();
    marca = sc.nextLine();
    System.out.println("\nModelo da moto: ");
    sc.next();
    modelo = sc.nextLine();
    System.out.println("\nAno da moto: ");
    ano = sc.nextInt();
    System.out.println("\nQuilometragem da moto: ");
    km = sc.nextInt();
    System.out.println("\nTipo do combustivel: ");
    sc.next();
    tipoCombustivel = sc.nextLine();
    System.out.println("\nPeso da moto: ");
    peso = sc.nextInt();

    System.out.println("\nDigite o numero de cilindradas da moto: ");
    cilindradas = sc.nextInt();

    do {
      System.out.println("\nDigite o tipo de motocicleta: ");
      System.out.println("\n 0 - Trail");
      System.out.println("\n 1 - Street");
      System.out.println("\n 2 - Sport");
      System.out.println("\n 3 - Custom");
      System.out.println("\n --------------");
      indexTipoMotocicleta = sc.nextInt();
    } while (indexTipoMotocicleta < 0 && indexTipoMotocicleta > 3);

    // Verificar se a moto foi vendida
    do {
      System.out.println("\nA moto foi vendida?");
      System.out.println("\n 0 - Nao");
      System.out.println("\n 1 - Sim");
      System.out.println("\n --------------");
      op = sc.nextInt();
    } while (op > 1 && op < 0);

    // Se foi vendida(1), recebe true. c.c.(0) recebe false
    if (op == 1) {
      vendido = true;
    } else if (op == 0) {
      vendido = false;
    }

    m1.setNumChassi(numChassi);
    m1.setMarca(marca);
    m1.setModelo(modelo);
    m1.setAno(ano);
    m1.setKm(km);
    m1.setTipoCombustivel(tipoCombustivel);
    m1.setPeso(peso);
    m1.setVendido(vendido);
    m1.setCilindradas(cilindradas);
    m1.setIndexTipoMotocicleta(indexTipoMotocicleta);

    listaMotocicletas.add(m1);
    System.out.println("\nCadastro efetuado com sucesso!");
    System.out.println("\nAperte enter para sair do cadastro!");
    sc.nextLine();
  }
}