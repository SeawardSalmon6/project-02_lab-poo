public class Gerente extends Funcionario {
  private int anosExperiencia;

  public Gerente(int anosExperiencia) {
    this.anosExperiencia = anosExperiencia;
  }

  public Gerente() {
}

public int getAnosExperiencia() {
    return anosExperiencia;
  }

  public void setAnosExperiencia(int anosExperiencia) {
    this.anosExperiencia = anosExperiencia;
  }

}