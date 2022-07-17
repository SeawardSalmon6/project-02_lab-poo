package data;

import java.util.ArrayList;
import java.util.Scanner;
import services.Utils;
import models.Motocicleta;

public class ListaMotos {
  private static ArrayList<Motocicleta> listaMotos = new ArrayList<>();

  // ======= Métodos Auxiliares
  public static boolean estaVazia() {
    return listaMotos.size() == 0;
  }

  public static int getQuantidade() {
    return listaMotos.size();
  }

  public static boolean chassiExiste(long chassi) {
    if (ListaMotos.estaVazia())
      return true;

    for (int i = 0; i < listaMotos.size(); i++) {
      if (listaMotos.get(i).getNumChassi() == chassi) {
        return false;
      }
    }

    return true;
  }

  // ======== Métodos da Classe
  public static void cadastroMotocicleta(Scanner sc) {
    Motocicleta novaMoto = new Motocicleta();
    long auxChassi;
    int auxTipoMoto, auxVendido;

    Utils.printCabecalho("CADASTRAR NOVA MOTOCICLETA");

    do {
      auxChassi = Utils.lerLong("Digite o número do chassi: ", sc);

      if (!ListaMotos.chassiExiste(auxChassi)) {
        Utils.printAviso("O chassi indicado já existe. Insira um chassi válido!");
        auxChassi = -1;
      }
    } while (auxChassi == -1);

    novaMoto.setNumChassi(auxChassi);
    novaMoto.setMarca(Utils.lerString("Digite a marca do veículo: ", sc));
    novaMoto.setModelo(Utils.lerString("Digite o modelo do veículo: ", sc));
    novaMoto.setAno(Utils.lerInt("Digite o ano do veículo: ", sc));
    novaMoto.setKm(Utils.lerDouble("Digite a quilometragem do veículo: ", sc));
    novaMoto.setTipoCombustivel(Utils.lerString("Digite o tipo de combustível: ", sc));
    novaMoto.setPeso(Utils.lerDouble("Digite o peso do veículo: ", sc));
    novaMoto.setCilindradas(Utils.lerInt("Digite a quantidade de cilindradas da moto: ", sc));

    do {
      System.out.println("== Tipo de Motocicleta");
      Motocicleta.printOpcoesTiposMotocicleta();
      auxTipoMoto = Utils.lerInt("Escolha o tipo de motocicleta desejado: ", sc);

      if (auxTipoMoto < 1 && auxTipoMoto > 4)
        Utils.printAviso("Insira um valor válido!");
    } while (auxTipoMoto < 1 && auxTipoMoto > 4);

    novaMoto.setIndexTipoMotocicleta(auxTipoMoto - 1);

    do {
      System.out.println("\n== A moto foi vendida?");
      System.out.println("\n(0) Não");
      System.out.println("\n(1) Sim");
      auxVendido = Utils.lerInt("Insira a opção desejada: ", sc);

      if (auxVendido < 0 && auxVendido > 1)
        Utils.printAviso("Insira um valor válido!");
    } while (auxVendido < 0 && auxVendido > 1);

    novaMoto.setVendido(auxVendido == 0 ? false : true);

    listaMotos.add(novaMoto);
    System.out.println("\nCadastro efetuado com sucesso!");
    Utils.aguardarTecla();
  }

  //Alteracao
  public void alterarMoto(ArrayList<Motocicleta> listaMotos, Scanner sc, int id) {

    Utils.printCabecalho("Alterar dados da motocicleta");
    System.out.println("\n 1 - Numero chassi");
    System.out.println("\n 2 - Marca");
    System.out.println("\n 3 - Modelo");
    System.out.println("\n 4 - Ano");
    System.out.println("\n 5 - Quilometragem");
    System.out.println("\n 6 - Tipo combustivel");
    System.out.println("\n 7 - Peso");
    System.out.println("\n 8 - Situacao de venda");
    System.out.println("\n 9 - Cilindradas");
    System.out.println("\n 10 - Tipo da moto");

    int op = Utils.lerInt("Selecione a opcao", sc);

    switch (op) {
      case 1:
        alterarNumChassi(listaMotos, sc, id);
        break;
      case 2:
        alterarMarca(listaMotos, sc, id);
        break;
      case 3:
        alterarModelo(listaMotos, sc, id);
        break;
      case 4:
        alterarAno(listaMotos, sc, id);
        break;
      case 5:
        alterarKm(listaMotos, sc, id);
        break;
      case 6:
        alterarTipoCombustivel(listaMotos, sc, id);
        break;
      case 7:
        alterarPeso(listaMotos, sc, id);
        break;
      case 8:
        alterarVendido(listaMotos, sc, id);
        break;
      case 9:
        alterarCilindradas(listaMotos, sc, id);
        break;
      case 10:
        alterarTipoMoto(listaMotos, sc, id);
      default:
        break;
    }
  }

  public void alterarNumChassi(ArrayList<Motocicleta> listaMotos, Scanner sc, int id) {

    listaMotos.get(id).setNumChassi(Utils.lerLong("Novo numero chassi", sc));
    System.out.println("\nNumero chassi da moto" + id + "atualizado!");
    Utils.aguardarTecla();
  }

  public void alterarMarca(ArrayList<Motocicleta> listaMotos, Scanner sc, int id) {

    listaMotos.get(id).setMarca(Utils.lerString("Nova marca da moto", sc));
    System.out.println("\nMarca da moto" + id + "atualizada!");
    Utils.aguardarTecla();
  }

  public void alterarModelo(ArrayList<Motocicleta> listaMotos, Scanner sc, int id) {

    listaMotos.get(id).setModelo(Utils.lerString("Novo modelo da moto", sc));
    System.out.println("\nModelo da moto" + id + "atualizado!");
    Utils.aguardarTecla();
  }

  public void alterarAno(ArrayList<Motocicleta> listaMotos, Scanner sc, int id) {

    listaMotos.get(id).setAno(Utils.lerInt("Novo ano da moto", sc));
    System.out.println("\nAno da moto" + id + "atualizado!");
    Utils.aguardarTecla();
  }

  public void alterarKm(ArrayList<Motocicleta> listaMotos, Scanner sc, int id) {

    listaMotos.get(id).setKm(Utils.lerDouble("Nova quilometragem da moto", sc));
    System.out.println("\nQuilometragem da moto" + id + "atualizada!");
    Utils.aguardarTecla();
  }

  public void alterarTipoCombustivel(ArrayList<Motocicleta> listaMotos, Scanner sc, int id) {

    listaMotos.get(id).setTipoCombustivel(Utils.lerString("Novo combustivel", sc));
    System.out.println("\nCombustivel da moto" + id + "atualizado!");
    Utils.aguardarTecla();
  }

  public void alterarPeso(ArrayList<Motocicleta> listaMotos, Scanner sc, int id) {

    listaMotos.get(id).setPeso(Utils.lerInt("Novo peso da moto", sc));
    System.out.println("\nPeso da moto" + id + "atualizado!");
    Utils.aguardarTecla();
  }

  public void alterarVendido(ArrayList<Motocicleta> listaMotos, Scanner sc, int id) {
    int auxVendido;

    do {
      System.out.println("\n== A moto foi vendida?");
      System.out.println("\n(0) Não");
      System.out.println("\n(1) Sim");
      auxVendido = Utils.lerInt("Insira a opção desejada: ", sc);

      if (auxVendido < 0 && auxVendido > 1)
        Utils.printAviso("Insira um valor válido!");
    } while (auxVendido < 0 && auxVendido > 1);

    listaMotos.get(id).setVendido(auxVendido == 0 ? false : true);
    System.out.println("\nSituacao da moto" + id + "atualizada!");
    Utils.aguardarTecla();
  }

  public void alterarCilindradas(ArrayList<Motocicleta> listaMotos, Scanner sc, int id) {

    listaMotos.get(id).setCilindradas(Utils.lerInt("Nova cilindradas da moto", sc));
    System.out.println("\nCilindradas da moto" + id + "atualizada!");
    Utils.aguardarTecla();
  }

  public void alterarTipoMoto(ArrayList<Motocicleta> listaMotos, Scanner sc, int id) {
    int auxTipoMoto;

    do {
      System.out.println("== Tipo de Motocicleta");
      Motocicleta.printOpcoesTiposMotocicleta();
      auxTipoMoto = Utils.lerInt("Escolha o tipo de motocicleta desejado: ", sc);

      if (auxTipoMoto < 1 && auxTipoMoto > 4)
        Utils.printAviso("Insira um valor válido!");
    } while (auxTipoMoto < 1 && auxTipoMoto > 4);

    listaMotos.get(id).setIndexTipoMotocicleta(auxTipoMoto - 1);
    System.out.println("\nTipo da moto" + id + "atualizado!");
    Utils.aguardarTecla();
  }
}