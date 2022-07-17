package models;

import models.util.Data;
import models.util.Horario;

public class Venda {
    private static final String[] tipoVenda = { "Carro", "Motocicleta" };
    private static int qtdVendas = 0;

    private int idVenda;
    private Vendedor vendedor;
    private Cliente cliente;
    private Veiculo veiculo;
    private double valor;
    private Data data;
    private Horario horario;

    // Metodos Construtores
    public Venda(int idVenda, Vendedor vendedor, Cliente cliente, Veiculo veiculo, double valor, Data data,
            Horario horario) {
        this.idVenda = idVenda;
        this.vendedor = vendedor;
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.valor = valor;
        this.data = data;
        this.horario = horario;
    }

    public Venda() {
        this(++qtdVendas, null, null, null, 0, null, null);
    }

    // Getters e Setters
    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    // Metodos criados
    // Cadastro venda

    public static void printOpcoesTipoVenda() {
        for (int i = 0; i < tipoVenda.length; i++)
            System.out.printf("\n(%d) %s", i + 1, tipoVenda[i]);

        System.out.println();
    }
}