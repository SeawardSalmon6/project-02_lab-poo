package services;

import data.*;
import models.*;
import models.util.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public final class Backup {
  private static final String PASTA_RAIZ = "../files/";

  // ===== Arquivos Existentes
  private static final String nomeArqCarros = "lista_carros.txt";
  private static final String nomeArqClientes = "lista_clientes.txt";
  private static final String nomeArqMotos = "lista_motocicletas.txt";
  private static final String nomeArqVendas = "lista_vendas.txt";
  private static final String nomeArqVendedores = "lista_vendedores.txt";

  private static void fazerBackupCarros() {
    ArrayList<Carro> listaCarros = ListaCarros.getLista();
    Carro carro;

    try {
      File arqCarros = new File(PASTA_RAIZ + nomeArqCarros);
      FileWriter wrCarros = new FileWriter(arqCarros);

      for (int i = 0; i < ListaCarros.getQuantidade(); i++) {
        carro = listaCarros.get(i);
        wrCarros.write(carro.getIdCarro() + ";");
        wrCarros.write(carro.getNumChassi() + ";");
        wrCarros.write(carro.getMarca() + ";");
        wrCarros.write(carro.getModelo() + ";");
        wrCarros.write(carro.getAno() + ";");
        wrCarros.write(carro.getKm() + ";");
        wrCarros.write(carro.getTipoCombustivel() + ";");
        wrCarros.write(carro.getPeso() + ";");
        wrCarros.write(carro.getVendido() + ";");
        wrCarros.write(carro.getPotencia() + ";");
        wrCarros.write(carro.getNumCilindros() + ";");
        wrCarros.write(carro.getNumAssentos() + ";");
        wrCarros.write(carro.getIndexTipoCarro() + ";");
        wrCarros.write(carro.getAltura() + ";");
        wrCarros.write(carro.getLargura() + ";");
        wrCarros.write(carro.getComprimento() + ";");
        wrCarros.write("\n");
      }

      wrCarros.close();
    } catch (IOException e) {
      System.out.println("Erro: " + e);
    }
  }

  private static void fazerBackupClientes() {
    ArrayList<Cliente> listaClientes = ListaClientes.getLista();
    Cliente cliente;

    try {
      File arqClientes = new File(PASTA_RAIZ + nomeArqClientes);
      FileWriter wrClientes = new FileWriter(arqClientes);

      for (int i = 0; i < ListaClientes.getQuantidade(); i++) {
        cliente = listaClientes.get(i);
        wrClientes.write(cliente.getIdCliente() + ";");
        wrClientes.write(cliente.getCpf() + ";");
        wrClientes.write(cliente.getNome() + ";");
        wrClientes.write(cliente.getDataNasc().getDia() + ";");
        wrClientes.write(cliente.getDataNasc().getMes() + ";");
        wrClientes.write(cliente.getDataNasc().getAno() + ";");
        wrClientes.write(cliente.getEndereco().getRua() + ";");
        wrClientes.write(cliente.getEndereco().getNumero() + ";");
        wrClientes.write(cliente.getEndereco().getBairro() + ";");
        wrClientes.write(cliente.getEndereco().getCidade() + ";");
        wrClientes.write(cliente.getRenda() + ";");
        wrClientes.write(cliente.getDependentes() + ";");
        wrClientes.write("\n");
      }

      wrClientes.close();
    } catch (IOException e) {
      System.out.println("Erro: " + e);
    }
  }

  private static void fazerBackupMotocicletas() {
    ArrayList<Motocicleta> listaMotos = ListaMotos.getLista();
    Motocicleta moto;

    try {
      File arqMotos = new File(PASTA_RAIZ + nomeArqMotos);
      FileWriter wrMotos = new FileWriter(arqMotos);

      for (int i = 0; i < ListaMotos.getQuantidade(); i++) {
        moto = listaMotos.get(i);
        wrMotos.write(moto.getIdMoto() + ";");
        wrMotos.write(moto.getNumChassi() + ";");
        wrMotos.write(moto.getMarca() + ";");
        wrMotos.write(moto.getModelo() + ";");
        wrMotos.write(moto.getAno() + ";");
        wrMotos.write(moto.getKm() + ";");
        wrMotos.write(moto.getTipoCombustivel() + ";");
        wrMotos.write(moto.getPeso() + ";");
        wrMotos.write(moto.getVendido() + ";");
        wrMotos.write(moto.getCilindradas() + ";");
        wrMotos.write(moto.getIndexTipoMotocicleta() + ";");
        wrMotos.write("\n");
      }

      wrMotos.close();
    } catch (IOException e) {
      System.out.println("Erro: " + e);
    }
  }

  private static void fazerBackupVendedores() {
    ArrayList<Vendedor> listaVendedores = ListaVendedores.getLista();
    Vendedor vendedor;

    try {
      File arqVendedores = new File(PASTA_RAIZ + nomeArqVendedores);
      FileWriter wrVendedores = new FileWriter(arqVendedores);

      for (int i = 0; i < ListaVendedores.getQuantidade(); i++) {
        vendedor = listaVendedores.get(i);
        wrVendedores.write(vendedor.getIdVendedor() + ";");
        wrVendedores.write(vendedor.getRg() + ";");
        wrVendedores.write(vendedor.getNome() + ";");
        wrVendedores.write(vendedor.getDataNascimento().getDia() + ";");
        wrVendedores.write(vendedor.getDataNascimento().getMes() + ";");
        wrVendedores.write(vendedor.getDataNascimento().getAno() + ";");
        wrVendedores.write(vendedor.getDataAdmissao().getDia() + ";");
        wrVendedores.write(vendedor.getDataAdmissao().getMes() + ";");
        wrVendedores.write(vendedor.getDataAdmissao().getAno() + ";");
        wrVendedores.write(vendedor.getSalario() + ";");
        wrVendedores.write(vendedor.getTempoTreinamento() + ";");
        wrVendedores.write("\n");
      }

      wrVendedores.close();
    } catch (IOException e) {
      System.out.println("Erro: " + e);
    }
  }

  private static void fazerBackupVendas() {
    ArrayList<Venda> listaVendas = ListaVendas.getLista();
    Venda venda;

    try {
      File arqVendas = new File(PASTA_RAIZ + nomeArqVendas);
      FileWriter wrVendas = new FileWriter(arqVendas);

      for (int i = 0; i < ListaVendas.getQuantidade(); i++) {
        venda = listaVendas.get(i);
        wrVendas.write(venda.getIdVenda() + ";");
        wrVendas.write(venda.getVendedor().getIdVendedor() + ";");
        wrVendas.write(venda.getCliente().getIdCliente() + ";");
        wrVendas.write(venda.getCarro().getIdCarro() + ";");
        wrVendas.write(venda.getMotocicleta().getIdMoto() + ";");
        wrVendas.write(venda.getValor() + ";");
        wrVendas.write(venda.getData().getDia() + ";");
        wrVendas.write(venda.getData().getMes() + ";");
        wrVendas.write(venda.getData().getAno() + ";");
        wrVendas.write(venda.getHorario().getHora() + ";");
        wrVendas.write(venda.getHorario().getMinuto() + ";");
        wrVendas.write("\n");
      }

      wrVendas.close();
    } catch (IOException e) {
      System.out.println("Erro: " + e);
    }
  }

  public static void fazerBackup() {
    Backup.fazerBackupCarros();
    Backup.fazerBackupClientes();
    Backup.fazerBackupMotocicletas();
    Backup.fazerBackupVendedores();
    Backup.fazerBackupVendas();
  }

  public static void lerBackupCarros() {
    ArrayList<Carro> novaLista = new ArrayList<>();
    String[] linhaLida;

    try {
      FileReader arqCarros = new FileReader(PASTA_RAIZ + nomeArqCarros);
      BufferedReader rdCarros = new BufferedReader(arqCarros);

      while (rdCarros.ready()) {
        linhaLida = rdCarros.readLine().split(";");

        Carro novoCarro = new Carro();
        novoCarro.setIdCarro(Integer.parseInt(linhaLida[0]));
        novoCarro.setNumChassi(Long.parseLong(linhaLida[1]));
        novoCarro.setMarca(linhaLida[2]);
        novoCarro.setModelo(linhaLida[3]);
        novoCarro.setAno(Integer.parseInt(linhaLida[4]));
        novoCarro.setKm(Double.parseDouble(linhaLida[5]));
        novoCarro.setTipoCombustivel(linhaLida[6]);
        novoCarro.setPeso(Double.parseDouble(linhaLida[7]));
        novoCarro.setVendido(Boolean.parseBoolean(linhaLida[8]));
        novoCarro.setPotencia(Integer.parseInt(linhaLida[9]));
        novoCarro.setNumCilindros(Integer.parseInt(linhaLida[10]));
        novoCarro.setNumAssentos(Integer.parseInt(linhaLida[11]));
        novoCarro.setIndexTipoCarro(Integer.parseInt(linhaLida[12]));
        novoCarro.setAltura(Double.parseDouble(linhaLida[13]));
        novoCarro.setLargura(Double.parseDouble(linhaLida[14]));
        novoCarro.setComprimento(Double.parseDouble(linhaLida[15]));

        novaLista.add(novoCarro);
      }

      ListaCarros.setLista(novaLista);
      rdCarros.close();
    } catch (IOException e) {
      System.out.println("Erro: " + e);
    }
  }

  public static void lerBackupClientes() {
    ArrayList<Cliente> novaLista = new ArrayList<>();
    String[] linhaLida;

    try {
      FileReader arqClientes = new FileReader(PASTA_RAIZ + nomeArqClientes);
      BufferedReader rdClientes = new BufferedReader(arqClientes);

      while (rdClientes.ready()) {
        linhaLida = rdClientes.readLine().split(";");

        Cliente novoCliente = new Cliente();
        Data dataNasc = new Data();
        Endereco endereco = new Endereco();
        novoCliente.setIdCliente(Integer.parseInt(linhaLida[0]));
        novoCliente.setCpf(Long.parseLong(linhaLida[1]));
        novoCliente.setNome(linhaLida[2]);

        dataNasc.setDia(Integer.parseInt(linhaLida[3]));
        dataNasc.setMes(Integer.parseInt(linhaLida[4]));
        dataNasc.setAno(Integer.parseInt(linhaLida[5]));
        novoCliente.setDataNasc(dataNasc);

        endereco.setRua(linhaLida[6]);
        endereco.setNumero(Integer.parseInt(linhaLida[7]));
        endereco.setBairro(linhaLida[8]);
        endereco.setCidade(linhaLida[9]);
        novoCliente.setEndereco(endereco);

        novoCliente.setRenda(Float.parseFloat(linhaLida[10]));
        novoCliente.setDependentes(Integer.parseInt(linhaLida[11]));

        novaLista.add(novoCliente);
      }

      ListaClientes.setLista(novaLista);
      rdClientes.close();
    } catch (IOException e) {
      System.out.println("Erro: " + e);
    }
  }

  public static void lerBackupMotocicletas() {
    ArrayList<Motocicleta> novaLista = new ArrayList<>();
    String[] linhaLida;

    try {
      FileReader arqMotos = new FileReader(PASTA_RAIZ + nomeArqMotos);
      BufferedReader rdMotos = new BufferedReader(arqMotos);

      while (rdMotos.ready()) {
        linhaLida = rdMotos.readLine().split(";");

        Motocicleta novaMoto = new Motocicleta();
        novaMoto.setIdMoto(Integer.parseInt(linhaLida[0]));
        novaMoto.setNumChassi(Long.parseLong(linhaLida[1]));
        novaMoto.setMarca(linhaLida[2]);
        novaMoto.setModelo(linhaLida[3]);
        novaMoto.setAno(Integer.parseInt(linhaLida[4]));
        novaMoto.setKm(Double.parseDouble(linhaLida[5]));
        novaMoto.setTipoCombustivel(linhaLida[6]);
        novaMoto.setPeso(Double.parseDouble(linhaLida[7]));
        novaMoto.setVendido(Boolean.parseBoolean(linhaLida[8]));
        novaMoto.setCilindradas(Integer.parseInt(linhaLida[9]));
        novaMoto.setIndexTipoMotocicleta(Integer.parseInt(linhaLida[10]));

        novaLista.add(novaMoto);
      }

      ListaMotos.setLista(novaLista);
      rdMotos.close();
    } catch (IOException e) {
      System.out.println("Erro: " + e);
    }
  }

  public static void lerBackupVendedores() {
    ArrayList<Vendedor> novaLista = new ArrayList<>();
    String[] linhaLida;

    try {
      FileReader arqVendedores = new FileReader(PASTA_RAIZ + nomeArqVendedores);
      BufferedReader rdVendedores = new BufferedReader(arqVendedores);

      while (rdVendedores.ready()) {
        linhaLida = rdVendedores.readLine().split(";");

        Vendedor novoVendedor = new Vendedor();
        Data dataNasc = new Data();
        Data dataAdmissao = new Data();

        novoVendedor.setIdVendedor(Integer.parseInt(linhaLida[0]));
        novoVendedor.setRg(Long.parseLong(linhaLida[1]));
        novoVendedor.setNome(linhaLida[2]);

        dataNasc.setDia(Integer.parseInt(linhaLida[3]));
        dataNasc.setMes(Integer.parseInt(linhaLida[4]));
        dataNasc.setAno(Integer.parseInt(linhaLida[5]));
        novoVendedor.setDataNascimento(dataNasc);

        dataAdmissao.setDia(Integer.parseInt(linhaLida[6]));
        dataAdmissao.setMes(Integer.parseInt(linhaLida[7]));
        dataAdmissao.setAno(Integer.parseInt(linhaLida[8]));
        novoVendedor.setDataNascimento(dataAdmissao);

        novoVendedor.setSalario(Double.parseDouble(linhaLida[9]));
        novoVendedor.setTempoTreinamento(Integer.parseInt(linhaLida[10]));

        novaLista.add(novoVendedor);
      }

      ListaVendedores.setLista(novaLista);
      rdVendedores.close();
    } catch (IOException e) {
      System.out.println("Erro: " + e);
    }
  }

  public static void lerBackupVendas() {
    ArrayList<Venda> novaLista = new ArrayList<>();
    String[] linhaLida;

    try {
      FileReader arqVendas = new FileReader(PASTA_RAIZ + nomeArqVendas);
      BufferedReader rdvendas = new BufferedReader(arqVendas);

      while (rdvendas.ready()) {
        linhaLida = rdvendas.readLine().split(";");

        Venda novaVenda = new Venda();
        Data data = new Data();
        Horario horario = new Horario();

        novaVenda.setIdVenda(Integer.parseInt(linhaLida[0]));
        novaVenda.setVendedor(ListaVendedores.buscarVendedor(Integer.parseInt(linhaLida[1])));
        novaVenda.setCliente(ListaClientes.buscarCliente(Integer.parseInt(linhaLida[2])));
        novaVenda.setCarro(ListaCarros.buscarCarro(Integer.parseInt(linhaLida[3])));
        novaVenda.setMotocicleta(ListaMotos.buscarMotocicleta(Integer.parseInt(linhaLida[4])));
        novaVenda.setValor(Double.parseDouble(linhaLida[5]));

        data.setDia(Integer.parseInt(linhaLida[6]));
        data.setMes(Integer.parseInt(linhaLida[7]));
        data.setAno(Integer.parseInt(linhaLida[8]));
        novaVenda.setData(data);

        horario.setHora(Integer.parseInt(linhaLida[9]));
        horario.setHora(Integer.parseInt(linhaLida[10]));
        novaVenda.setHorario(horario);

        novaLista.add(novaVenda);
      }

      ListaVendas.setLista(novaLista);
      rdvendas.close();
    } catch (IOException e) {
      System.out.println("Erro: " + e);
    }
  }

  public static void carregarBackup() {
    Backup.lerBackupCarros();
    Backup.lerBackupClientes();
    Backup.lerBackupMotocicletas();
    Backup.lerBackupVendedores();
    Backup.lerBackupVendas();
  }
}
