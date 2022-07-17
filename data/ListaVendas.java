package data;
import services.Utils;
import models.util.*;
import models.Cliente;
import models.Vendedor;
import models.Carro;
import models.Motocicleta;
import models.Veiculo;

import java.util.ArrayList;
import java.util.Scanner;
import models.Venda;

public class ListaVendas {
  private static ArrayList<Venda> listaVendas = new ArrayList<>();

  // ======= Métodos Auxiliares
  public static boolean estaVazia() {
    return listaVendas.size() == 0;
  }

  public static int getQuantidade() {
    return listaVendas.size();
  }

  //Metodos da classe

  public void cadastroVenda(Scanner sc) {
    Venda novaVenda = new Venda();
    Data data = new Data();
    Cliente novoCliente = new Cliente();
    Vendedor novoVendedor = new Vendedor();
    Horario horario = new Horario();
    Carro novoCarro = new Carro();
    Motocicleta novaMoto = new Motocicleta();
    int op;

    Utils.printCabecalho("CADASTRO DA VENDA");

    novaVenda.setIdVenda(Utils.lerInt("ID da venda", sc));
    novoVendedor.setRg(Utils.lerLong("RG do vendedor", sc));
    novaVenda.setVendedor(novoVendedor);
    novoCliente.setCpf(Utils.lerLong("CPF do cliente", sc));
    novaVenda.setCliente(novoCliente);


    do {
        System.out.println("\nQual veiculo sera vendido?");
        Venda.printOpcoesTipoVenda();
        op = Utils.lerInt("Option", sc);
    } while (op < 0 && op > 1);

    if (op == 0) {
        novoCarro.setNumChassi(Utils.lerLong("Numero do chassi do carro: ", sc));
    } else if (op == 1) {
        novaMoto.setNumChassi(Utils.lerLong("Numero do chassi da moto", sc));
    }

    novaVenda.setValor(Utils.lerDouble("Valor da venda", sc));

    data.setDia(Utils.lerInt("Dia da venda", sc));
    data.setMes(Utils.lerInt("Mes da venda", sc));
    data.setAno(Utils.lerInt("Ano da venda", sc));
    novaVenda.setData(data);

    System.out.println("\nDigite a hora e minuto de venda separadamente!");
    horario.setHora(Utils.lerInt("Hora da venda", sc));
    horario.setMinuto(Utils.lerInt("Minuto da venda", sc));
    novaVenda.setHorario(horario);

    listaVendas.add(novaVenda);
    System.out.println("\n---> Cadastro efetuado com sucesso!");
    Utils.aguardarTecla();
  }
// Alteracao de dados
public void alteraVenda(ArrayList<Venda> listaVendas, Scanner sc, int id) {

  Utils.printCabecalho("Alterar dados da venda");
  System.out.println("\n 1 - ID da venda");
  System.out.println("\n 2 - Vendedor");
  System.out.println("\n 3 - Cliente");
  System.out.println("\n 4 - Veiculo");
  System.out.println("\n 5 - Valor");
  System.out.println("\n 6 - Data");
  System.out.println("\n 7 - Horario");
  int op = Utils.lerInt("Selecione a opcao", sc);

  switch (op) {
    case 1:
      alterarIdVenda(listaVendas, sc, id);
      break;
    case 2:
      alteraVendedor(listaVendas, sc, id);//supostamente chama a funcao do listaVendedores
      break;
    case 3:
      alteraCliente(listaVendas, sc, id);//supostamente chama a funcao do listaClientes
      break;
    case 4:
      alterarVeiculo(listaVendas, sc, id);
      break;
    case 5:
      alterarValor(listaVendas, sc, id);
      break;
    case 6:
      alterarData(listaVendas, sc, id);
      break;
    case 7:
      alterarHorario(listaVendas, sc, id);
      break;
    default:
      break;
  }
}

  public void alterarIdVenda(ArrayList<Venda> listaVenda, Scanner sc, int id) {

    listaVenda.get(id).setIdVenda(Utils.lerInt("Novo id da venda", sc));
    System.out.println("\nId da venda" + id + "atualizado!");
    Utils.aguardarTecla();
  }

  public void alterarVeiculo(ArrayList<Venda> listaVenda, Scanner sc, int id) {//falta finalizar implementacao
    
    do {
      System.out.println("\nQual veiculo sera alterado?");
      Venda.printOpcoesTipoVenda();
      op = Utils.lerInt("Option", sc);
    } while (op < 0 && op > 1);

    if (op == 0) {
      Carro novoCarro = new Carro();
      novoCarro.setNumChassi(Utils.lerLong("Numero do chassi do carro: ", sc));
    } else if (op == 1) {
      Motocicleta novaMoto = new Motocicleta();
      novaMoto.setNumChassi(Utils.lerLong("Numero do chassi da moto", sc));
    }
  }

  public void alterarData(ArrayList<Venda> listaVendas, Scanner sc, int id) {
    Data novaData = new Data();

    novaData.setDia(Utils.lerInt("Novo dia de venda", sc));
    novaData.setMes(Utils.lerInt("Novo mes de venda", sc));
    novaData.setAno(Utils.lerInt("Novo ano de venda", sc));
    listaVendas.get(id).setData(novaData);
    System.out.println("\nData de venda" + id + "atualizada!");
    Utils.aguardarTecla();
  }

  public void alterarHorario(ArrayList<Venda> listaVendas, Scanner sc, int id){
    Horario novoHorario = new Horario();

    novoHorario.setHora(Utils.lerInt("Nova hora de venda", sc));
    novoHorario.setMinuto(Utils.lerInt("Novo minuto de venda", sc));
    listaHorario.get(id).setHorario(novoHorario);
    System.out.println("\nHora de venda" + id + "atualizada!");
    Utils.aguardarTecla();
  }
}