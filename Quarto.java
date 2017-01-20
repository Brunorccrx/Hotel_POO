package sistemadehotel;

public class Quarto {
	static private int totalQuartos;
  private String numeroQuarto;
  private String situacaoQuarto;
	private String tipoQuarto;
	private double consumo;
	Cliente cliente;


//Construtor
	public Quarto(String numeroQuarto,String tipoQuarto){
		Quarto.totalQuartos++;
		this.numeroQuarto=numeroQuarto;
		this.tipoQuarto=tipoQuarto;
	}

//Get and Set
	public double getConsumo(){
		return this.consumo;
	}
	public void setConsumo(double consumo){
		this.consumo=consumo;
	}
	public String getTipoQuarto(){
		return this.tipoQuarto;
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
  public String getSituacaoQuarto() {
    return situacaoQuarto;
  }
	public void setSituacaoQuarto(String situacaoQuarto){
		this.situacaoQuarto=situacaoQuarto;
	}

//Funcoes Quarto
	public double valorQuarto(){
		if(this.tipoQuarto.equals("Solteiro"))
			return 1000;
		else if(this.tipoQuarto.equals("Casal"))
			return 2000;
		else
			return 1500;//DuploSolteiro
	}
	public String quartoDisponivel(Cliente cliente){
		if(cliente==null && situacaoQuarto.equals("Limpo"))
			return "Quarto disponivel.";
		else if(cliente!=null)
			return "Quarto indisponivel.Quarto ocupado pelo(a) cliente"+" "+cliente.getNome();
		else
			return "Quarto indisponivel.Quarto ainda não foi limpo.";
	}
	public void removerCliente(){
		this.cliente = null;
	}
	public void adicionarCliente(Cliente cliente){
		this.cliente=cliente;
		this.situacaoQuarto="Ocupado";
	}
	//Funcao para calucular consumo
	
}
