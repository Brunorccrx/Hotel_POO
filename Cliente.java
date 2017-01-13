package sistemadehotel;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

public class Cliente {
	//Dados Pessoais
	static private int ID;
	private String nome;
	private String CPF;
	private String passaporte;
	private String RG;
	private String numTelefone;
	private String nacionalidade;
	private String dataNasc;
	//Endereço
	private String rua;
	private String bairro;
	private String numCasa;
	private String cidade;
	private String estado;
	//Gastos
	private double aluguelDoQuarto = 0;
	private double consumo = 0;
	private double danosCausados = 0;
	private double gastoTotal = 0;
	
	//Construtor
	public Cliente(String nome, String CPF, String RG) {
		Cliente.ID++;
		this.nome = nome;
		this.CPF = CPF;
		this.RG = RG;
	}
	public Cliente(String nome, String passaporte) {
		Cliente.ID++;
		this.nome = nome;
		this.passaporte = passaporte;
	}
	//get ID
	public int getID() {
		return ID;
	}
	//get e set Nome
	public String getNacionalidade() {
		return nacionalidade;
	}
	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}
	//get e set CPF
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String cPF) {
		CPF = cPF;
	}
	//get e set Passaporte
	public String getPassaporte() {
		return passaporte;
	}
	public void setPassaporte(String passaporte) {
		this.passaporte = passaporte;
	}
	//get e set RG
	public String getRG() {
		return RG;
	}
	public void setRG(String rG) {
		RG = rG;
	}
	//get e set Numero de Telefone
	public String getNumTelefone() {
		return numTelefone;
	}
	public void setNumTelefone(String numTelefone) {
		this.numTelefone = numTelefone;
	}
	//get e set Nome
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	//get e set Rua
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	//get e set Bairro
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	//get e set Numero da Casa
	public String getNumCasa() {
		return numCasa;
	}
	public void setNumCasa(String numCasa) {
		this.numCasa = numCasa;
	}
	//get e set Cidade
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	//get e set Estado
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	//get e set Data de Nascimento
	public String getDataNasc() {
		return dataNasc;
	}
	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}
	//get e set Aluguel do Quarto
	public double getAluguelDoQuarto() {
		return aluguelDoQuarto;
	}
	public void setAluguelDoQuarto(double aluguelDoQuarto) {
		this.aluguelDoQuarto = aluguelDoQuarto;
	}
	//get Consumo
	public double getConsumo() {
		return consumo;
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
		String numero_Relatorio = Cliente.ID +" - "+ "Relatorio.txt";
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
		String numero_Relatorio = Cliente.ID + " - " + "Relatorio.txt";
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
		String numero_Relatorio = Cliente.ID + " - " + "Relatorio.txt";
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
		String numero_Relatorio = Cliente.ID + " - " + "Relatorio.txt";
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
