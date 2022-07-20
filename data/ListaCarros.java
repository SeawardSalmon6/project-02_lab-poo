package data;

import java.util.ArrayList;
import java.util.Scanner;
import models.Carro;
import services.Utils;

public class ListaCarros {
  private static ArrayList<Carro> listaCarros = new ArrayList<>();

  // ======= Métodos Auxiliares
  public static ArrayList<Carro> getLista() {
    return listaCarros;
  }

  public static void setLista(ArrayList<Carro> novaLista) {
    listaCarros = novaLista;
  }

  public static boolean estaVazia() {
    return listaCarros.size() == 0;
  }

  public static int getQuantidade() {
    return listaCarros.size();
  }

  public static boolean chassiExiste(long chassi) {
    if (ListaCarros.estaVazia())
      return false;

    for (int i = 0; i < listaCarros.size(); i++) {
      if (listaCarros.get(i).getNumChassi() == chassi) {
        return true;
      }
    }

    return false;
  }

  public static void printOpcoesCarros() {
    Carro carro;

    if (ListaCarros.estaVazia()) {
      Utils.printAviso("Não existem Carros cadastrados!");
      return;
    }

    for (int i = 0; i < listaCarros.size(); i++) {
      carro = listaCarros.get(i);

      System.out.printf("\n| Carro [%d]", carro.getIdCarro());
      System.out.printf("\n| Marca: %s", carro.getMarca());
      System.out.printf("\n| Modelo: %s", carro.getModelo());
      System.out.printf("\n| Número do Chassi: %d", carro.getNumChassi());
      System.out.println("\n-------------------------");
    }
  }

  public static Carro buscarCarro(int idCarro) {
    if (ListaCarros.estaVazia())
      return null;

    for (int i = 0; i < listaCarros.size(); i++)
      if (listaCarros.get(i).getIdCarro() == idCarro)
        return listaCarros.get(i);

    return null;
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

  // Alteracao
  public void alterarCarro(Scanner sc) {
    int op;
    Carro carro;

    if (ListaCarros.estaVazia()) {
      Utils.printCabecalho("ALTERAR DADOS DA MOTOCICLETA");
      Utils.printAviso("Não existem motocicletas cadastradas!");
      Utils.aguardarTecla();
      return;
    }

    do {
      Utils.limpaTela();
      Utils.printCabecalho("ALTERAR DADOS DA MOTOCICLETA");
      ListaCarros.printOpcoesCarros();

      carro = ListaCarros.buscarCarro(Utils.lerInt("Digite o ID do carro: ", sc));

      if (carro == null)
        Utils.printAviso("Insira uma opção válida!");
    } while (carro == null);

    do {
      Utils.limpaTela();

      Utils.printCabecalho("ALTERAR DADOS DO MOTOCICLETA");

      ListaCarros.printOpcoesCarros();

      System.out.println("\n(1) Numero do chassi");
      System.out.println("\n(2) Marca");
      System.out.println("\n(3) Modelo");
      System.out.println("\n(4) Ano");
      System.out.println("\n(5) Quilometragem");
      System.out.println("\n(6) Tipo combustivel");
      System.out.println("\n(7) Peso");
      System.out.println("\n(8) Status de venda");
      System.out.println("\n(9) Potencia");
      System.out.println("\n(10) Numero de cilindros");
      System.out.println("\n(11) Numero de ocupantes");
      System.out.println("\n(12) Tipo do carro");
      System.out.println("\n(13) Altura");
      System.out.println("\n(14) Largura");
      System.out.println("\n(15) Comprimento");
      System.out.println("\n(0) Cancelar");
      op = Utils.lerInt("Digite a opção desejada: ", sc);

      switch (op) {
        case 1:
          carro.setNumChassi(Utils.lerLong("Novo numero do chassi: ", sc));
          ;
          break;
        case 2:
          carro.setMarca(Utils.lerString("Nova marca da moto: ", sc));
          break;
        case 3:
          carro.setModelo(Utils.lerString("Novo modelo da moto: ", sc));
          break;
        case 4:
          carro.setAno(Utils.lerInt("Novo ano da moto: ", sc));
          break;
        case 5:
          carro.setKm(Utils.lerDouble("Nova quilometragem da moto: ", sc));
          break;
        case 6:
          carro.setTipoCombustivel(Utils.lerString("Novo tipo de combustivel da moto: ", sc));
          break;
        case 7:
          carro.setPeso(Utils.lerDouble("Novo peso da moto: ", sc));
          break;
        case 8:
          int auxVendido;

          do {
            System.out.println("\n== A moto foi vendida?");
            System.out.println("\n(0) Não");
            System.out.println("\n(1) Sim");
            auxVendido = Utils.lerInt("Insira a opção desejada: ", sc);

            if (auxVendido < 0 && auxVendido > 1)
              Utils.printAviso("Insira um valor válido!");
          } while (auxVendido < 0 && auxVendido > 1);
          carro.setVendido(auxVendido == 0 ? false : true);
          System.out.println("\nSitaucao da moto atualizada!");

          break;
        case 9:
          carro.setPotencia(Utils.lerInt("Nova potencia do carro: ", sc));
          break;
        case 10:
          carro.setNumCilindros(Utils.lerInt("Novo numero de cilindros do carro: ", sc));
          break;
        case 11:
          carro.setNumAssentos(Utils.lerInt("Novo numero de assentos do carro: ", sc));
          break;
        case 12:
          int auxTipoCarro;

          do {
            System.out.println("== Tipo de Motocicleta");
            Carro.printOpcoesTiposCarro();
            auxTipoCarro = Utils.lerInt("Escolha o tipo de motocicleta desejado: ", sc);

            if (auxTipoCarro < 1 && auxTipoCarro > 5)
              Utils.printAviso("Insira um valor válido!");
          } while (auxTipoCarro < 1 && auxTipoCarro > 5);

          carro.setIndexTipoCarro(auxTipoCarro - 1);
          System.out.println("\nTipo da moto atualizado!");
          break;
        case 13:
          carro.setAltura(Utils.lerDouble("Nova altura do carro: ", sc));
          break;
        case 14:
          carro.setLargura(Utils.lerDouble("Nova largura do carro: ", sc));
          break;
        case 15:
          carro.setComprimento(Utils.lerDouble("Novo comprimento do carro: ", sc));
        default:
          Utils.printAviso("Insira uma opção válida!");
          break;
      }
    } while (op != 0);
  }
}
