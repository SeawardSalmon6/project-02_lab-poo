public class Vendedor extends Funcionario {
  private int tempoTreinamento;
  private Gerente gerenteResponsavel;

  public Vendedor(int tempoTreinamento, Gerente gerenteResponsavel) {
    this.tempoTreinamento = tempoTreinamento;
    this.gerenteResponsavel = gerenteResponsavel;
  }

  public int getTempoTreinamento() {
    return tempoTreinamento;
  }

  public void setTempoTreinamento(int tempoTreinamento) {
    this.tempoTreinamento = tempoTreinamento;
  }

  public Gerente getGerenteResponsavel() {
    return gerenteResponsavel;
  }

  public void setGerenteResponsavel(Gerente gerenteResponsavel) {
    this.gerenteResponsavel = gerenteResponsavel;
  }
}