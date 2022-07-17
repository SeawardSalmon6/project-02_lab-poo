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
}
