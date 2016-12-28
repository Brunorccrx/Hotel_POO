
package sistemadehotel;

public class Quarto {
	static private int totalQuartos;
  Cliente cliente;

	private String mario;

	public String getTipoQuarto(){
		return this.numeroQuarto;
	}
	public String setTipoQuarto(String tipoQuarto){
		this.tipoQuarto=tipoQuarto;
	}
	public String getNumeroQuarto(){
		return this.numeroQuarto;
	}
	public String setNumeroQuarto(int numeroQuarto){
		this.numeroQuarto=numeroQuarto;
	}

  public int getTotalQuartos() {
    return totalQuartos;
  }

  public void setTotalQuartos(int totalQuartos) {
    this.totalQuartos = totalQuartos;
  }

  public String getDisponibilidadeQuarto() {
    return disponibilidadeQuarto;
  }

  public void setDisponibilidadeQuarto(String disponibilidadeQuarto) {
    this.disponibilidadeQuarto = disponibilidadeQuarto;
  }

 	public String getSituacaoQuarto() {
    return situacaoQuarto;
  }

  public void setSituacaoQuarto(String situacaoQuarto) {
    this.situacaoQuarto = situacaoQuarto;
  }
}
