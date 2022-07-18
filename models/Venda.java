package models;

import models.util.Data;
import models.util.Horario;

public class Venda {
    private static int qtdVendas = 0;

    private int idVenda;
    private Vendedor vendedor;
    private Cliente cliente;
    private double valor;
    private Data data;
    private Horario horario;
    private Carro carro;
    private Motocicleta motocicleta;

    // Metodos Construtores
    public Venda(int idVenda, Vendedor vendedor, Cliente cliente, double valor, Data data,
            Horario horario, Carro carro, Motocicleta motocicleta) {
        this.idVenda = idVenda;
        this.vendedor = vendedor;
        this.cliente = cliente;
        this.valor = valor;
        this.data = data;
        this.horario = horario;
        this.carro = carro;
        this.motocicleta = motocicleta;
    }

    public Venda() {
        this(++qtdVendas, null, null, 0, null, null, null, null);
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

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public void setMotocicleta(Motocicleta motocicleta) {
        this.motocicleta = motocicleta;
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

    public Carro getCarro() {
        return carro;
    }

    public Motocicleta getMotocicleta() {
        return motocicleta;
    }
}