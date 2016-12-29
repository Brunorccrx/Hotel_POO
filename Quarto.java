
package sistemadehotel;

public class Quarto {
	static private int totalQuartos;
  private String numeroQuarto;
  private String disponibilidadeQuarto;
	private String situacaoQuarto;
	private String tipoQuarto;
	Cliente cliente;


	public String getTipoQuarto(){
		return this.numeroQuarto;
	}
	public void setTipoQuarto(String tipoQuarto){
		this.tipoQuarto=tipoQuarto;
	}
	public String getNumeroQuarto(){
		return this.numeroQuarto;
	}
	public void setNumeroQuarto(String numeroQuarto){
		this.numeroQuarto=numeroQuarto;
	}

  public int getTotalQuartos() {
    return totalQuartos;
  }

  public void setTotalQuartos(int totalQuartos) {
    Quarto.totalQuartos = totalQuartos;
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
