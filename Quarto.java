package sistemadehotel;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

public class Quarto {
	static private int totalQuartos;
	private String numeroQuarto;
	private String situacaoQuarto;
	private String tipoQuarto;
	Cliente cliente;
	//Gastos
	private double aluguelDoQuarto = 0;
	private double consumo = 0;
	private double danosCausados = 0;
	private double gastoTotal = 0;


//Construtor
	public Quarto(String numeroQuarto,String tipoQuarto){
		Quarto.totalQuartos++;			//aqui será adicionado um quarto a mais toda vez que instanciado só que ...
		
		this.numeroQuarto=numeroQuarto;
		this.tipoQuarto=tipoQuarto;
	}

//Geters and Seters
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
	
	//get e set Aluguel do Quarto
		public double getAluguelDoQuarto() {
			return aluguelDoQuarto;
		}
		public void setAluguelDoQuarto(double aluguelDoQuarto) {
			this.aluguelDoQuarto = aluguelDoQuarto;
		}
		//get Danos Causados
		public double getDanosCausados() {
			return danosCausados;
		}
		//get Gasto Total
		public double getGastoTotal() {
			return gastoTotal;
		}
		//      ### Funções ###
		// Soma valor do Quarto
		public void soma_Quarto(double valor)  {
			String numero_Relatorio = this.numeroQuarto +" - "+ "Relatorio.txt";
			File relatorio = new File(numero_Relatorio);
			
			try {
				relatorio.createNewFile();
			} catch (IOException e1) {
				System.out.println("!!! Erro ao tentar Criar o Arquivo");
				e1.printStackTrace();
			}
			
			PrintWriter gravaRelatorio = null;
			
			try {
				gravaRelatorio = new PrintWriter(relatorio);
			} catch (FileNotFoundException e) {
				System.out.println("!!! Erro ao tentar instanciar 'PrintWriter' quarto");
				e.printStackTrace();
			}
			
			gravaRelatorio.println("#------Relatótio------#\n");
			gravaRelatorio.printf("| Quarto: %.2f \n",valor);
			gravaRelatorio.close();
			
			this.aluguelDoQuarto += valor;
		}
		// Soma valor do Consumo
		public void soma_Consumo(double valor) {
			String numero_Relatorio = this.numeroQuarto + " - " + "Relatorio.txt";
			Writer relatorio = null;
			
			try {
				relatorio = new BufferedWriter(new FileWriter(numero_Relatorio, true));
			} catch (IOException e) {
				System.out.println("!!! Erro ao tentar instanciar 'BufferedWriter' Cosumo");
				e.printStackTrace();
			}
			
			PrintWriter gravaRelatorio = new PrintWriter(relatorio);
		
			gravaRelatorio.println();
			gravaRelatorio.printf("| Consumo: %.2f ", valor);
			gravaRelatorio.close();
			
			this.consumo += valor;
		}
		// Soma valor dos Danos
		public void soma_Danos(double valor) {
			String numero_Relatorio = this.numeroQuarto + " - " + "Relatorio.txt";
			Writer relatorio = null;
			
			try {
				relatorio = new BufferedWriter(new FileWriter(numero_Relatorio, true));
			} catch (IOException e) {
				System.out.println("!!! Erro ao tentar instanciar 'BufferedWriter' Danos");
				e.printStackTrace();
			}
			
			PrintWriter gravaRelatorio = new PrintWriter(relatorio);
		
			gravaRelatorio.println();
			gravaRelatorio.printf("| Danos: %.2f ", valor);
			gravaRelatorio.close();
			
			this.danosCausados += valor;
		}
		// Soma valor Total
		public void soma_Total() {
			String numero_Relatorio = this.numeroQuarto + " - " + "Relatorio.txt";
			Writer relatorio = null;
			
			try {
				relatorio = new BufferedWriter(new FileWriter(numero_Relatorio, true));
			} catch (IOException e) {
				System.out.println("!!! Erro ao tentar instanciar 'BufferedWriter' Total");
				e.printStackTrace();
			}
			
			PrintWriter gravaRelatorio = new PrintWriter(relatorio);
		
			gravaRelatorio.println();
			gravaRelatorio.printf("| TOTAL: %.2f ", this.gastoTotal = this.aluguelDoQuarto + this.consumo + this.danosCausados);
			gravaRelatorio.close();
		}
}
