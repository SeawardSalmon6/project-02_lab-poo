import java.util.Scanner;
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

        System.out.println("\nDigite o id da venda: ");
        idVenda = sc.nextInt();
        System.out.println("\nRG do Vendedor: ");
        newVendedor.setRg(sc.nextLong());
        System.out.println("\nCPF do cliente: ");
        newCliente.setCpf(sc.nextLong());

        do{
            System.out.println("\nQual veiculo sera vendido?(Selecione 0 ou 1)");
            System.out.println("\n 0 - Carro");
            System.out.println("\n 1 - Motocicleta");
            op = sc.nextInt();
        }while(op < 0 && op > 1);

        if(op == 0){
            System.out.println("\nDigite o chassi do carro vendido: ");
            newCarro.setNumChassi(sc.nextLong());
        }
        else if(op == 1){
            System.out.println("\nDigite o chassi da moto vendida: ");
            newMoto.setNumChassi(sc.nextLong());
        }

        System.out.println("\nDigite o valor da venda: ");
        valor = sc.nextDouble();
        System.out.println("\nDigite o dia da venda: ");
        data.setDia(sc.nextInt());
        System.out.println("\nDigite o mes da venda: ");
        data.setMes(sc.nextInt());
        System.out.println("\nDigite o ano da venda: ");
        data.setAno(sc.nextInt());
        System.out.println("\nDigite a hora e minuto de venda separadamente!");
        System.out.println("\nHora da venda: ");
        horario.setHora(sc.nextInt());
        System.out.println("\nMinuto da venda: ");
       horario.setMinuto(sc.nextInt());

       listaVendas.add(v1);
       System.out.println("\nCadastro efetuado com sucesso!");
       System.out.println("\nAperte enter para sair do cadastro!");
       sc.nextLine();
    }
}