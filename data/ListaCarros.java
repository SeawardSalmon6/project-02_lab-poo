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
}
