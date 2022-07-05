public class Data {
    private int dia;
    private int mes;
    private int ano;
  
    // ============== Construtores
    public Data() {
      this(1, 1, 2022);
    }
  
    public Data(int dia, int mes, int ano) {
      this.setDia(dia);
      this.setMes(mes);
      this.setAno(ano);
    }
  
    // ============== Getters e Setters
    public int getDia() {
      return this.dia;
    }
  
    public int getMes() {
      return this.mes;
    }
  
    public int getAno() {
      return this.ano;
    }
  
    /*
     * Data: classe implementada, o dia (1 a 31), mês (1 a 12) e ano (1950 a 2050)
     * deverão ser tratados para evitar a inserção de dados inválidos.
     */
  
    public boolean setDia(int dia) {
      if (dia < 1 || dia > 31)
        return false;
  
      this.dia = dia;
      return true;
    }

    public boolean setMes(int mes) {
        if (mes < 1 || mes > 12)
          return false;
    
        this.mes = mes;
        return true;
      }

    public boolean setAno(int ano) {
        if (ano < 1950 || ano > 2050)
          return false;
    
        this.ano = ano;
        return true;
      }
  }