package models.util;

public class Horario {
  private int hora;
  private int minuto;

  // ============== Construtores
  public Horario() {
    this(0, 0);
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
    if (hora >= 0 && hora <= 23)
      this.hora = hora;
    else
      this.hora = -1;
  }

  public void setMinuto(int minuto) {
    if (hora >= 0 && hora <= 59)
      this.minuto = minuto;
    else
      this.minuto = -1;
  }
}