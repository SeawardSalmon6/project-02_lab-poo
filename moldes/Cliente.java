public class Cliente {
  private long cpf;
  private String nome;
  private Data dataNasc;
  private float renda;
  private int dependentes;

  // Construtores
  public Cliente() {
    this(0, "", null, 0, 0);
  }

  public Cliente(long cpf, String nome, Data dataNasc, float renda, int dependentes) {
    this.cpf = cpf;
    this.nome = nome;
    this.dataNasc = dataNasc;
    this.renda = renda;
    this.dependentes = dependentes;
  }

  public void cadastraCliente(long cpf, String nome, Data dataNasc, float renda, int dependentes) {

  }

  // Getters e Setters
  public long getCpf() {
    return cpf;
  }

  public void setCpf(long cpf) {
    this.cpf = cpf;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Data getDataNasc() {
    return dataNasc;
  }

  public void setDataNasc(Data dataNasc) {
    this.dataNasc = dataNasc;
  }

  public float getRenda() {
    return renda;
  }

  public void setRenda(float renda) {
    this.renda = renda;
  }

  public int getDependentes() {
    return dependentes;
  }

  public void setDependentes(int dependentes) {
    this.dependentes = dependentes;
  }
}