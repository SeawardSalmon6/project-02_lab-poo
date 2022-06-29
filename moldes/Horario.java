public class Horario {
  private int hora;
  private int minuto;

  // ============== Construtores
  public Horario() {
    this(1, 1);
  }

  public Horario(int hora, int minuto) {
    this.setHora(hora);
    this.setMinuto(minuto);
  }

  // ============== Getters e Setters
  public int getHora() {
    return this.hora;
  }

  public int getMinuto() {
    return this.minuto;
  }

  /*
   * Horário: classe implementada, hora (0 a 23) e minuto (0 a 59) deverão ser
   * tratados
   * para evitar a inserção de dados inválidos.
   */
  public void setHora(int hora) {
    do {
      if (hora < 0 || hora > 23)
        System.out.println("Valor para hora invalido");
    } while (hora < 0 || hora > 23);
    this.hora = hora;
  }

  public void setMinuto(int minuto) {
    do {
      if (minuto < 0 || minuto > 59)
        System.out.println("Valor para minuto invalido");
    } while (minuto < 0 || minuto > 59);
    this.minuto = minuto;
  }
}