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

  public static void printarCarro(Carro carro) {
    System.out.println("\n| ---------------------------");
    System.out.println("\n| Carro " + carro.getMarca() + " " + carro.getModelo());
    System.out.println("\n| Ano: " + carro.getAno());
    System.out.println("\n| Número do Chassi: " + carro.getNumChassi());
    System.out.println("\n| Número de Ocupantes: " + carro.getNumAssentos());
    System.out.println("\n| Tipo do Carro: " + carro.getTipoCarro());
    System.out.println("\n| Tipo Combustível: " + carro.getTipoCombustivel());
    System.out.println("\n| Quilometragem rodada: " + carro.getKm());
    System.out.println("\n| Status: " + (carro.getVendido() ? "Vendido" : "A venda"));
    System.out.println("\n| ---------------------------");
  }

  public static void printOpcoesCarros() {
    Carro carro;

    if (ListaCarros.estaVazia()) {
      Utils.printAviso("Não existem carros cadastrados!");
      return;
    }

    for (int i = 0; i < listaCarros.size(); i++) {
      carro = listaCarros.get(i);

      if (!carro.getVendido()) {
        System.out.printf("| Carro [%d]", carro.getIdCarro());
        System.out.printf("| Marca: %s", carro.getMarca());
        System.out.printf("| Modelo: %s", carro.getModelo());
        System.out.printf("| Número do Chassi: %d", carro.getNumChassi());
        System.out.println("-------------------------");
      }
    }
  }

  public static void listarCarrosDisponiveis() {
    if (ListaCarros.estaVazia()) {
      Utils.printAviso("Não existem carros disponíveis!");
      return;
    }

    for (int i = 0; i < listaCarros.size(); i++)
      ListaCarros.printarCarro(listaCarros.get(i));

    System.out.println();
  }

  public static Carro buscarCarro(int idCarro) {
    if (ListaCarros.estaVazia())
      return null;

    for (int i = 0; i < listaCarros.size(); i++)
      if (listaCarros.get(i).getIdCarro() == idCarro)
        return listaCarros.get(i);

    return null;
  }

  public static Carro buscarCarro(String marca, String modelo) {
    if (ListaCarros.estaVazia())
      return null;

    for (int i = 0; i < listaCarros.size(); i++)
      if (listaCarros.get(i).getMarca().equalsIgnoreCase(marca) && listaCarros.get(i).getModelo()
          .equalsIgnoreCase(modelo))
        return listaCarros.get(i);

    return null;
  }

  // ======= Métodos da Classe
  public static void cadastrarCarro(Scanner sc) {
    Carro novoCarro = new Carro();
    long auxChassi;
    int auxTipoCarro, auxVendido;

    Utils.limpaTela();
    Utils.printCabecalho("CADASTRAR NOVO CARRO");

    do {
      auxChassi = Utils.lerLong("Digite o número do chassi: ", sc);

      if (ListaCarros.chassiExiste(auxChassi)) {
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
      System.out.println("\n== Tipo de Carro");
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
  public static void alterarCarro(Scanner sc) {
    Carro carro;
    int op, auxVendido, auxTipoCarro;
    long auxChassi;

    if (ListaCarros.estaVazia()) {
      Utils.printCabecalho("ALTERAR DADOS DO CARRO");
      Utils.printAviso("Não existem carros cadastrados!");
      Utils.aguardarTecla();
      return;
    }

    do {
      Utils.limpaTela();
      Utils.printCabecalho("ALTERAR DADOS DO CARRO");
      ListaCarros.printOpcoesCarros();

      carro = ListaCarros.buscarCarro(Utils.lerInt("Digite o ID do carro: ", sc));

      if (carro == null)
        Utils.printAviso("Insira uma opção válida!");
    } while (carro == null);

    do {
      Utils.limpaTela();

      Utils.printCabecalho("ALTERAR DADOS DO CARRO\n");

      ListaCarros.printOpcoesCarros();

      System.out.println("(1) Número do chassi");
      System.out.println("(2) Marca");
      System.out.println("(3) Modelo");
      System.out.println("(4) Ano");
      System.out.println("(5) Quilometragem");
      System.out.println("(6) Tipo combustivel");
      System.out.println("(7) Peso");
      System.out.println("(8) Status de venda");
      System.out.println("(9) Potência");
      System.out.println("(10) Número de cilindros");
      System.out.println("(11) Número de ocupantes");
      System.out.println("(12) Tipo do carro");
      System.out.println("(13) Altura");
      System.out.println("(14) Largura");
      System.out.println("(15) Comprimento");
      System.out.println("(0) Cancelar");
      op = Utils.lerInt("Digite a opção desejada: ", sc);

      switch (op) {
        case 1:
          do {
            auxChassi = Utils.lerLong("Digite o número do chassi: ", sc);

            if (ListaCarros.chassiExiste(auxChassi)) {
              Utils.printAviso("O chassi indicado já existe. Insira um chassi válido!");
              auxChassi = -1;
            }
          } while (auxChassi == -1);

          carro.setNumChassi(auxChassi);
          break;
        case 2:
          carro.setMarca(Utils.lerString("Nova marca do carro: ", sc));
          break;
        case 3:
          carro.setModelo(Utils.lerString("Novo modelo do carro: ", sc));
          break;
        case 4:
          carro.setAno(Utils.lerInt("Novo ano do carro: ", sc));
          break;
        case 5:
          carro.setKm(Utils.lerDouble("Nova quilometragem do carro: ", sc));
          break;
        case 6:
          carro.setTipoCombustivel(Utils.lerString("Novo tipo de combustivel do carro: ", sc));
          break;
        case 7:
          carro.setPeso(Utils.lerDouble("Novo peso do carro: ", sc));
          break;
        case 8:
          do {
            System.out.println("\n== O carro foi vendido?");
            System.out.println("\n(0) Não");
            System.out.println("\n(1) Sim");
            auxVendido = Utils.lerInt("Insira a opção desejada: ", sc);

            if (auxVendido < 0 && auxVendido > 1)
              Utils.printAviso("Insira um valor válido!");
          } while (auxVendido < 0 && auxVendido > 1);

          carro.setVendido(auxVendido == 0 ? false : true);
          break;
        case 9:
          carro.setPotencia(Utils.lerInt("Nova potencia do carro: ", sc));
          break;
        case 10:
          carro.setNumCilindros(Utils.lerInt("Novo número de cilindros do carro: ", sc));
          break;
        case 11:
          carro.setNumAssentos(Utils.lerInt("Novo número de assentos do carro: ", sc));
          break;
        case 12:
          do {
            System.out.println("\n== Tipo de Carro");
            Carro.printOpcoesTiposCarro();
            auxTipoCarro = Utils.lerInt("Escolha o tipo do carro desejado: ", sc);

            if (auxTipoCarro < 1 && auxTipoCarro > 5)
              Utils.printAviso("Insira um valor válido!");
          } while (auxTipoCarro < 1 && auxTipoCarro > 5);

          carro.setIndexTipoCarro(auxTipoCarro - 1);
          break;
        case 13:
          carro.setAltura(Utils.lerDouble("Nova altura do carro: ", sc));
          break;
        case 14:
          carro.setLargura(Utils.lerDouble("Nova largura do carro: ", sc));
          break;
        case 15:
          carro.setComprimento(Utils.lerDouble("Novo comprimento do carro: ", sc));
        case 0:
          break;
        default:
          Utils.printAviso("Insira uma opção válida!");
          break;
      }
    } while (op != 0);
  }

  public static void excluirCarro(Scanner sc) {
    Carro carro;

    if (ListaCarros.estaVazia()) {
      Utils.printCabecalho("EXCLUIR CARRO");
      Utils.printAviso("Não existem carros cadastrados!");
      Utils.aguardarTecla();
      return;
    }

    do {
      Utils.limpaTela();
      Utils.printCabecalho("EXCLUIR CARROS");
      ListaCarros.printOpcoesCarros();

      carro = ListaCarros.buscarCarro(Utils.lerInt("Digite o ID do carro: ", sc));

      if (carro == null)
        Utils.printAviso("Insira uma opção válida!");
    } while (carro == null);

    ListaCarros.printarCarro(carro);
    listaCarros.remove(carro);

    System.out.println("\n---> Carro removido com sucesso!");
    Utils.aguardarTecla();
  }

  public static void listarCarros() {
    Utils.limpaTela();

    if (ListaCarros.estaVazia()) {
      Utils.printCabecalho("LISTA COMPLETA DE CARROS");
      Utils.printAviso("Não existem carros cadastrados!");
      Utils.aguardarTecla();
      return;
    }

    Utils.printCabecalho("LISTA COMPLETA DE CARROS");
    for (int i = 0; i < listaCarros.size(); i++)
      ListaCarros.printarCarro(listaCarros.get(i));

    Utils.aguardarTecla();
  }
}
