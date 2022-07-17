package data;
import services.Utils;
import models.util.*;
import models.Cliente;
import models.Vendedor;
import models.Carro;
import models.Motocicleta;
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

    System.out.println("\nDigite a hora e minuto de venda separadamente!");
    horario.setHora(Utils.lerInt("Hora da venda", sc));
    horario.setMinuto(Utils.lerInt("Minuto da venda", sc));

    listaVendas.add(novaVenda);
    System.out.println("\n---> Cadastro efetuado com sucesso!");
    Utils.aguardarTecla();
}
}
