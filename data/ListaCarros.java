package data;

import java.util.ArrayList;
import java.util.Scanner;
import models.Carro;
import services.Utils;

public class ListaCarros {
  private static ArrayList<Carro> listaCarros = new ArrayList<>();

  // ======= Métodos Auxiliares
  public static boolean estaVazia() {
    return listaCarros.size() == 0;
  }

  public static int getQuantidade() {
    return listaCarros.size();
  }

  public static boolean chassiExiste(long chassi) {
    if (ListaCarros.estaVazia())
      return true;

    for (int i = 0; i < listaCarros.size(); i++) {
      if (listaCarros.get(i).getNumChassi() == chassi) {
        return false;
      }
    }

    return true;
  }

  // ======= Métodos da Classe
  public void cadastrarCarro(Scanner sc) {
    Carro novoCarro = new Carro();
    long auxChassi;
    int auxTipoCarro, auxVendido;

    Utils.printCabecalho("CADASTRAR NOVO CARRO");

    do {
      auxChassi = Utils.lerLong("Digite o número do chassi: ", sc);

      if (!ListaCarros.chassiExiste(auxChassi)) {
        Utils.printAviso("O chassi indicado já existe. Insira um chassi válido!");
        auxChassi = -1;
      }
    } while (auxChassi == -1);

    novoCarro.setNumChassi(auxChassi);
    novoCarro.setMarca(Utils.lerString("Digite a marca do veículo: ", sc));
    novoCarro.setModelo(Utils.lerString("Digite o modelo do veículo: ", sc));
    novoCarro.setAno(Utils.lerInt("Digite o ano do veículo: ", sc));
    novoCarro.setKm(Utils.lerDouble("Digite a quilometragem do veículo: ", sc));
    novoCarro.setTipoCombustivel(Utils.lerString("Digite o tipo de combustível: ", sc));
    novoCarro.setPeso(Utils.lerDouble("Digite o peso do veículo: ", sc));
    novoCarro.setPotencia(Utils.lerInt("Digite a potência do veículo: ", sc));
    novoCarro.setNumCilindros(Utils.lerInt("Digite a quantidade de cilindros: ", sc));
    novoCarro.setNumAssentos(Utils.lerInt("Digite a quantidade de assentos do veículo: ", sc));

    do {
      System.out.println("== Tipo de Carro");
      Carro.printOpcoesTiposCarro();
      auxTipoCarro = Utils.lerInt("Escolha o tipo de carro desejado: ", sc);

      if (auxTipoCarro < 1 && auxTipoCarro > 5)
        Utils.printAviso("Insira um valor válido!");
    } while (auxTipoCarro < 1 && auxTipoCarro > 5);

    novoCarro.setIndexTipoCarro(auxTipoCarro - 1);
    novoCarro.setAltura(Utils.lerDouble("Digite a altura do veículo: ", sc));
    novoCarro.setLargura(Utils.lerDouble("Digite a largura do veículo: ", sc));
    novoCarro.setComprimento(Utils.lerDouble("Digite o comprimento do veículo: ", sc));

    do {
      System.out.println("\n== O carro foi vendido?");
      System.out.println("\n(0) Não");
      System.out.println("\n(1) Sim");
      auxVendido = Utils.lerInt("Insira a opção desejada: ", sc);

      if (auxVendido < 0 && auxVendido > 1)
        Utils.printAviso("Insira um valor válido!");
    } while (auxVendido < 0 && auxVendido > 1);

    novoCarro.setVendido(auxVendido == 0 ? false : true);

    listaCarros.add(novoCarro);
    System.out.println("\n---> Cadastro efetuado com sucesso!");
    Utils.aguardarTecla();
  }

  //Alteracao
  public void alterarCarro(ArrayList<Carro> listaCarros, Scanner sc, int id) {

    Utils.printCabecalho("Alterar dados da motocicleta");
    System.out.println("\n 1 - Numero chassi");
    System.out.println("\n 2 - Marca");
    System.out.println("\n 3 - Modelo");
    System.out.println("\n 4 - Ano");
    System.out.println("\n 5 - Quilometragem");
    System.out.println("\n 6 - Tipo combustivel");
    System.out.println("\n 7 - Peso");
    System.out.println("\n 8 - Situacao de venda");
    System.out.println("\n 9 - Potencia");
    System.out.println("\n 10 - Cilindros");
    System.out.println("\n 11 - Assentos");
    System.out.println("\n 12 - Tipo de carro");
    System.out.println("\n 13 - Altura");
    System.out.println("\n 14 - Largura");
    System.out.println("\n 15 - Comprimento");


    int op = Utils.lerInt("Selecione a opcao", sc);

    switch (op) {
      case 1:
        alterarNumChassi(listaCarros, sc, id);
        break;
      case 2:
        alterarMarca(listaCarros, sc, id);
        break;
      case 3:
        alterarModelo(listaCarros, sc, id);
        break;
      case 4:
        alterarAno(listaCarros, sc, id);
        break;
      case 5:
        alterarKm(listaCarros, sc, id);
        break;
      case 6:
        alterarTipoCombustivel(listaCarros, sc, id);
        break;
      case 7:
        alterarPeso(listaCarros, sc, id);
        break;
      case 8:
        alterarVendido(listaCarros, sc, id);
        break;
      case 9:
        alterarPotencia(listaCarros, sc, id);
        break;
      case 10:
        alterarCilindros(listaCarros, sc, id);
        break;
      case 11:
        alterarAssentos(listaCarros, sc, id);
        break;
      case 12:
        alterarTipoCarro(listaCarros, sc, id);
        break;
      case 13:
        alterarAltura(listaCarros, sc, id);
        break;
      case 14:
        alterarLargura(listaCarros, sc, id);
        break;
      case 15:
        alterarComprimento(listaCarros, sc, id);
        break;
      default:
        break;
    }
  }

  public void alterarNumChassi(ArrayList<Carro> listaCarros, Scanner sc, int id) {

    listaCarros.get(id).setNumChassi(Utils.lerLong("Novo numero chassi", sc));
    System.out.println("\nNumero chassi do carro" + id + "atualizado!");
    Utils.aguardarTecla();
  }

  public void alterarMarca(ArrayList<Carro> listaCarros, Scanner sc, int id) {

    listaCarros.get(id).setMarca(Utils.lerString("Nova marca do carro", sc));
    System.out.println("\nMarca do carro" + id + "atualizada!");
    Utils.aguardarTecla();
  }

  public void alterarModelo(ArrayList<Carro> listaCarros, Scanner sc, int id) {

    listaCarros.get(id).setModelo(Utils.lerString("Novo modelo do carro", sc));
    System.out.println("\nModelo do carro" + id + "atualizado!");
    Utils.aguardarTecla();
  }

  public void alterarAno(ArrayList<Carro> listaCarros, Scanner sc, int id) {

    listaCarros.get(id).setAno(Utils.lerInt("Novo ano do carro", sc));
    System.out.println("\nAno do carro" + id + "atualizado!");
    Utils.aguardarTecla();
  }

  public void alterarKm(ArrayList<Carro> listaCarros, Scanner sc, int id) {

    listaCarros.get(id).setKm(Utils.lerDouble("Nova quilometragem do carro", sc));
    System.out.println("\nQuilometragem do carro" + id + "atualizada!");
    Utils.aguardarTecla();
  }

  public void alterarTipoCombustivel(ArrayList<Carro> listaCarros, Scanner sc, int id) {

    listaCarros.get(id).setTipoCombustivel(Utils.lerString("Novo combustivel", sc));
    System.out.println("\nCombustivel do carro" + id + "atualizado!");
    Utils.aguardarTecla();
  }

  public void alterarPeso(ArrayList<Carro> listaCarros, Scanner sc, int id) {

    listaCarros.get(id).setPeso(Utils.lerInt("Novo peso do carro", sc));
    System.out.println("\nPeso do carro" + id + "atualizado!");
    Utils.aguardarTecla();
  }

  public void alterarVendido(ArrayList<Carro> listaCarros, Scanner sc, int id) {
    int auxVendido;

    do {
      System.out.println("\n== O carro foi vendido?");
      System.out.println("\n(0) Não");
      System.out.println("\n(1) Sim");
      auxVendido = Utils.lerInt("Insira a opção desejada: ", sc);

      if (auxVendido < 0 && auxVendido > 1)
        Utils.printAviso("Insira um valor válido!");
    } while (auxVendido < 0 && auxVendido > 1);

    listaCarros.get(id).setVendido(auxVendido == 0 ? false : true);
    System.out.println("\nSituacao do carro" + id + "atualizada!");
    Utils.aguardarTecla();
  }

  public void alterarPotencia(ArrayList<Carro> listaCarros, Scanner sc, int id) {

    listaCarros.get(id).setPotencia(Utils.lerInt("Nova potencia do carro", sc));
    System.out.println("\nPotencia do carro" + id + "atualizado!");
    Utils.aguardarTecla();
  }

  public void alterarCilindros(ArrayList<Carro> listaCarros, Scanner sc, int id) {

    listaCarros.get(id).setNumCilindros(Utils.lerInt("Novo numero de cilindros do carro", sc));
    System.out.println("\nNumero de cilindros do carro" + id + "atualizado!");
    Utils.aguardarTecla();
  }

  public void alterarAssentos(ArrayList<Carro> listaCarros, Scanner sc, int id) {

    listaCarros.get(id).setNumAssentos(Utils.lerInt("Novo numero de assentos do carro", sc));
    System.out.println("\nNumero de assentos do carro" + id + "atualizado!");
    Utils.aguardarTecla();
  }

  public void alterarTipoCarro(ArrayList<Carro> listaCarros, Scanner sc, int id) {
    int auxTipoCarro;
    do {
      System.out.println("== Tipo de Carro");
      Carro.printOpcoesTiposCarro();
      auxTipoCarro = Utils.lerInt("Escolha o tipo de carro desejado: ", sc);

      if (auxTipoCarro < 1 && auxTipoCarro > 5)
        Utils.printAviso("Insira um valor válido!");
    } while (auxTipoCarro < 1 && auxTipoCarro > 5);

    listaCarros.get(id).setIndexTipoCarro(auxTipoCarro - 1);
    System.out.println("\nNumero de assentos do carro" + id + "atualizado!");
    Utils.aguardarTecla();
  }

  public void alterarAltura(ArrayList<Carro> listaCarros, Scanner sc, int id) {

    listaCarros.get(id).setAltura(Utils.lerInt("Nova altura do carro", sc));
    System.out.println("\nAltura do carro" + id + "atualizada!");
    Utils.aguardarTecla();
  }

  public void alterarLargura(ArrayList<Carro> listaCarros, Scanner sc, int id) {

    listaCarros.get(id).setLargura(Utils.lerInt("Nova largura do carro", sc));
    System.out.println("\nLargura do carro" + id + "atualizada!");
    Utils.aguardarTecla();
  }

  public void alterarComprimento(ArrayList<Carro> listaCarros, Scanner sc, int id) {

    listaCarros.get(id).setComprimento(Utils.lerInt("Novo comprimento do carro", sc));
    System.out.println("\nComprimento do carro" + id + "atualizado!");
    Utils.aguardarTecla();
  }
}
