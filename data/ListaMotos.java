package data;

import java.util.ArrayList;
import java.util.Scanner;
import services.Utils;
import models.Motocicleta;

public class ListaMotos {
  private static ArrayList<Motocicleta> listaMotos = new ArrayList<>();

  // ======= Métodos Auxiliares
  public static ArrayList<Motocicleta> getLista() {
    return listaMotos;
  }

  public static void setLista(ArrayList<Motocicleta> novaLista) {
    listaMotos = novaLista;
  }

  public static boolean estaVazia() {
    return listaMotos.size() == 0;
  }

  public static int getQuantidade() {
    return listaMotos.size();
  }

  public static boolean chassiExiste(long chassi) {
    if (ListaMotos.estaVazia())
      return false;

    for (int i = 0; i < listaMotos.size(); i++) {
      if (listaMotos.get(i).getNumChassi() == chassi) {
        return true;
      }
    }

    return false;
  }

  public static void printOpcoesMotos() {
    Motocicleta moto;

    if (ListaMotos.estaVazia()) {
      Utils.printAviso("Não existem motocicletas cadastradas!");
      return;
    }

    for (int i = 0; i < listaMotos.size(); i++) {
      moto = listaMotos.get(i);

      if (!moto.getVendido()) {
        System.out.printf("\n| Motocicleta [%d]", moto.getIdMoto());
        System.out.printf("\n| Marca: %s", moto.getMarca());
        System.out.printf("\n| Modelo: %s", moto.getModelo());
        System.out.printf("\n| Número do Chassi: %d", moto.getNumChassi());
        System.out.println("\n-------------------------");
      }
    }
  }

  public static Motocicleta buscarMotocicleta(int idMotocicleta) {
    if (ListaMotos.estaVazia())
      return null;

    for (int i = 0; i < listaMotos.size(); i++)
      if (listaMotos.get(i).getIdMoto() == idMotocicleta)
        return listaMotos.get(i);

    return null;
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

  public static void alterarMotocicleta(Scanner sc) {
    Motocicleta motocicleta;
    int op, auxVendido;
    long auxChassi;

    if (ListaMotos.estaVazia()) {
      Utils.printCabecalho("ALTERAR DADOS DA MOTOCICLETA");
      Utils.printAviso("Não existem motocicletas cadastradas!");
      Utils.aguardarTecla();
      return;
    }

    do {
      Utils.limpaTela();
      Utils.printCabecalho("ALTERAR DADOS DA MOTOCICLETA");
      ListaMotos.printOpcoesMotos();

      motocicleta = ListaMotos.buscarMotocicleta(Utils.lerInt("Digite o ID da motocicleta: ", sc));

      if (motocicleta == null)
        Utils.printAviso("Insira uma opção válida!");
    } while (motocicleta == null);

    do {
      Utils.limpaTela();

      Utils.printCabecalho("ALTERAR DADOS DO MOTOCICLETA");

      ListaMotos.printOpcoesMotos();

      System.out.println("\n(1) Número do chassi");
      System.out.println("\n(2) Marca");
      System.out.println("\n(3) Modelo");
      System.out.println("\n(4) Ano");
      System.out.println("\n(5) Quilometragem");
      System.out.println("\n(6) Tipo combustível");
      System.out.println("\n(7) Peso");
      System.out.println("\n(8) Status de venda");
      System.out.println("\n(9) Cilindradas");
      System.out.println("\n(10) Tipo de moto");
      System.out.println("\n(0) Cancelar");
      op = Utils.lerInt("Digite a opção desejada: ", sc);

      switch (op) {
        case 1:
          do {
            auxChassi = Utils.lerLong("Digite o novo número do chassi: ", sc);

            if (!ListaMotos.chassiExiste(auxChassi)) {
              Utils.printAviso("O chassi indicado já existe. Insira um chassi válido!");
              auxChassi = -1;
            }
          } while (auxChassi == -1);
          motocicleta.setNumChassi(auxChassi);
          break;
        case 2:
          motocicleta.setMarca(Utils.lerString("Digite a nova marca da motocicleta: ", sc));
          break;
        case 3:
          motocicleta.setModelo(Utils.lerString("Digite o novo modelo da motocicleta: ", sc));
          break;
        case 4:
          motocicleta.setAno(Utils.lerInt("Digite o novo ano da motocicleta: ", sc));
          break;
        case 5:
          motocicleta.setKm(Utils.lerDouble("Digite a nova quilometragem da motocicleta: ", sc));
          break;
        case 6:
          motocicleta.setTipoCombustivel(Utils.lerString("Digite o novo tipo de combustível da motocicleta: ", sc));
          break;
        case 7:
          motocicleta.setPeso(Utils.lerDouble("Digite o novo peso da motocicleta: ", sc));
          break;
        case 8:
          do {
            System.out.println("\n== A moto foi vendida?");
            System.out.println("\n(0) Não");
            System.out.println("\n(1) Sim");
            auxVendido = Utils.lerInt("Insira a opção desejada: ", sc);

            if (auxVendido < 0 && auxVendido > 1)
              Utils.printAviso("Insira um valor válido!");
          } while (auxVendido < 0 && auxVendido > 1);

          motocicleta.setVendido(auxVendido == 0 ? false : true);
          break;
        case 9:
          motocicleta.setCilindradas(Utils.lerInt("Nova quantidade de cilindradas da moto: ", sc));
          break;
        case 10:
          int auxTipoMoto;

          do {
            System.out.println("== Tipo de Motocicleta");
            Motocicleta.printOpcoesTiposMotocicleta();
            auxTipoMoto = Utils.lerInt("Escolha o tipo de motocicleta desejado: ", sc);

            if (auxTipoMoto < 1 && auxTipoMoto > 4)
              Utils.printAviso("Insira um valor válido!");
          } while (auxTipoMoto < 1 && auxTipoMoto > 4);

          motocicleta.setIndexTipoMotocicleta(auxTipoMoto - 1);
          break;
        default:
          Utils.printAviso("Insira uma opção válida!");
          break;
      }
    } while (op != 0);
  }
}