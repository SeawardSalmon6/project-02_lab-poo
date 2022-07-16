import java.util.Scanner;

import services.Utilidades;

import java.util.ArrayList;

public class Venda {
    private int idVenda;
    private Vendedor vendedor;
    private Cliente cliente;
    private Veiculo veiculo;
    private double valor;
    private Data data;
    private Horario horario;


    //Metodos Construtores
    public Venda(int idVenda, Vendedor vendedor, Cliente cliente, Veiculo veiculo, double valor, Data data, Horario horario) {
        this.idVenda = idVenda;
        this.vendedor = vendedor;
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.valor = valor;
        this.data = data;
        this.horario = horario;
    }

    public Venda(){
        this(0, null, null, null, 0, null, null);
    }


    //Getters e Setters 
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

    //Metodos criados
    //Cadastro venda

    public void cadastroVenda(ArrayList<Venda> listaVendas, Scanner sc){
        Venda v1 = new Venda();
        Data data = new Data();
        Cliente newCliente = new Cliente();
        Vendedor newVendedor = new Vendedor();
        Horario horario = new Horario();
        Carro newCarro = new Carro();
        Motocicleta newMoto = new Motocicleta();
        int op;
        Utilidades util = new Utilidades();

        util.printCabecalho("Cadastro da venda");
        idVenda = util.lerInt("ID da venda", sc);
        newVendedor.setRg(util.lerLong("RG do vendedor", sc));
        newCliente.setCpf(util.lerLong("CPF do cliente", sc));
        

        do{
            System.out.println("\nQual veiculo sera vendido?(Selecione 0 ou 1)");
            System.out.println("\n 0 - Carro");
            System.out.println("\n 1 - Motocicleta");
            op = util.lerInt("Option", sc);
        }while(op < 0 && op > 1);

        if(op == 0){
            newCarro.setNumChassi(util.lerLong("Numero do chassi do carro: ", sc));
        }
        else if(op == 1){
            newMoto.setNumChassi(util.lerLong("Numero do chassi da moto", sc));
        }

        valor = util.lerDouble("Valor da venda", sc);
        System.out.println("\nDigite o dia da venda: ");
        data.setDia(util.lerInt("Dia da venda", sc));
        data.setMes(util.lerInt("Mes da venda", sc));
        data.setAno(util.lerInt("Ano da venda", sc));

        System.out.println("\nDigite a hora e minuto de venda separadamente!");
        horario.setHora(util.lerInt("Hora da venda", sc));
        horario.setMinuto(util.lerInt("Minuto da venda", sc));

       listaVendas.add(v1);
       System.out.println("\nCadastro efetuado com sucesso!");
       util.aguardarTecla();
       util.limpaTela();
    }

    //Alterar dados
    public void alteraIdVenda
}