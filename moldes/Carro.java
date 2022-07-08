import java.util.Scanner;
import java.util.ArrayList;

public class Carro extends Veiculo {
  private static final String[] tiposCarros = { "Utilitário", "Pickup", "Sedan", "Hatch", "Esportivo" };
  private int op;
  private int potencia;
  private int numCilindros;
  private int numAssentos;
  private int indexTipoCarro;
  private double altura; // Criar classe separada para as dimensoes?
  private double largura;
  private double comprimento;

  ArrayList<Carro> listaCarros = new ArrayList<Carro>();
  Scanner sc = new Scanner(System.in);

  //Metodos Construtor

  public Carro(int potencia, int numCilindros, int numAssentos, int indexTipoCarro, double altura, double largura,
      double comprimento) {
    this.potencia = potencia;
    this.numCilindros = numCilindros;
    this.numAssentos = numAssentos;
    this.indexTipoCarro = indexTipoCarro;
    this.altura = altura;
    this.largura = largura;
    this.comprimento = comprimento;
  }

  public Carro(long numChassi, String marca, String modelo, int ano, int km, String tipoCombustivel, int peso,
      boolean vendido, int potencia, int numCilindros, int numAssentos, int indexTipoCarro, double altura,
      double largura, double comprimento) {
    super(numChassi, marca, modelo, ano, km, tipoCombustivel, peso, vendido);
    this.potencia = potencia;
    this.numCilindros = numCilindros;
    this.numAssentos = numAssentos;
    this.indexTipoCarro = indexTipoCarro;
    this.altura = altura;
    this.largura = largura;
    this.comprimento = comprimento;
  }

  public Carro(){
    this(0, null, null, 0, 0, null, 0, false, 
    0, 0, 0, 0, 0, 0, 0);
  }

  // ============ Métodos de Classe
  public String getTipoCarro() {
    return tiposCarros[this.indexTipoCarro];
  }

  //Getters e Setters

  public static String[] getTiposcarros() {
    return tiposCarros;
  }

  public int getPotencia() {
    return potencia;
  }

  public void setPotencia(int potencia) {
    this.potencia = potencia;
  }

  public int getNumCilindros() {
    return numCilindros;
  }

  public void setNumCilindros(int numCilindros) {
    this.numCilindros = numCilindros;
  }

  public int getNumAssentos() {
    return numAssentos;
  }

  public void setNumAssentos(int numAssentos) {
    this.numAssentos = numAssentos;
  }

  public int getIndexTipoCarro() {
    return indexTipoCarro;
  }

  public void setIndexTipoCarro(int indexTipoCarro) {
    this.indexTipoCarro = indexTipoCarro;
  }

  public double getAltura() {
    return altura;
  }

  public void setAltura(double altura) {
    this.altura = altura;
  }

  public double getLargura() {
    return largura;
  }

  public void setLargura(double largura) {
    this.largura = largura;
  }

  public double getComprimento() {
    return comprimento;
  }

  public void setComprimento(double comprimento) {
    this.comprimento = comprimento;
  }


  //Metodos criados
  //Cadastro
  public void cadastroCarro(ArrayList<Carro> listaCarros, Scanner sc){
    Carro newCar = new Carro();
  
    System.out.println("\nChassi do carro: ");
    numChassi = sc.nextLong();
    System.out.println("Marca do carro: ");
    sc.next();
    marca = sc.nextLine();
    System.out.println("\nModelo do carro: ");
    sc.next();
    modelo = sc.nextLine();
    System.out.println("\nAno do carro: ");
    ano = sc.nextInt();
    System.out.println("\nQuilometragem do carro: ");
    km = sc.nextInt();
    System.out.println("\nTipo do combustivel: ");
    sc.next();
    tipoCombustivel = sc.nextLine();
    System.out.println("\nPeso do carro: ");
    peso = sc.nextInt();
    System.out.println("\nPotencia do carro(inteiros): ");
    potencia = sc.nextInt();
    System.out.println("\nNumero de cilindros: ");
    numCilindros = sc.nextInt();
    System.out.println("\nNumero de Assentos: ");
    numAssentos = sc.nextInt();
    System.out.println("\n");

    do {
      System.out.println("\nDigite o tipo de carro: ");
      System.out.println("\n 0 - Utilitario");
      System.out.println("\n 1 - Pickup");
      System.out.println("\n 2 - Sedan");
      System.out.println("\n 3 - Hatch");
      System.out.println("\n 4 - Esportivo");
      System.out.println("\n --------------");
      indexTipoCarro = sc.nextInt();
    } while (indexTipoCarro < 0 && indexTipoCarro > 4);

    System.out.println("\nAltura do carro: ");
    altura = sc.nextDouble();
    System.out.println("\nLargura do carro: ");
    largura = sc.nextDouble();
    System.out.println("\nComprimento do carro: ");
    comprimento = sc.nextDouble();

    // Verificar se o carro foi vendido
    do {
      System.out.println("\nO carro foi vendido?");
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

    newCar.setNumChassi(numChassi);
    newCar.setMarca(marca);
    newCar.setModelo(modelo);
    newCar.setAno(ano);
    newCar.setKm(km);
    newCar.setTipoCombustivel(tipoCombustivel);
    newCar.setPeso(peso);
    newCar.setPotencia(potencia);
    newCar.setNumCilindros(numCilindros);
    newCar.setNumAssentos(numAssentos);
    newCar.setIndexTipoCarro(indexTipoCarro);
    newCar.setAltura(altura);
    newCar.setLargura(altura);
    newCar.setComprimento(altura);
    newCar.setVendido(vendido);

    listaCarros.add(newCar);
    System.out.println("\nCadastro efetuado com sucesso!");
    System.out.println("\nAperte enter para sair do cadastro!");
    sc.nextLine();
  }
  
}