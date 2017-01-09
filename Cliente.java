package sistemsdehotel;

import java.io.BufferedWriter;
import java.io.File;
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
	private float aluguelDoQuarto;
	private float consumo;
	private float danosCausados;
	private float gastoTotal;
	
	//Construtor
	public Cliente() {
		Cliente.ID++;
	}
	//get ID
	public int getID() {
		return ID;
	}
	//get e set Nacionalidade
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
	//get Aluguel do Quarto
	public float getAluguelDoQuarto() {
		return aluguelDoQuarto;
	}
	//get Consumo
	public float getConsumo() {
		return consumo;
	}
	//get Danos Causados
	public float getDanosCausados() {
		return danosCausados;
	}
	//get Gasto Total
	public int getGastoTotal() {
		return gastoTotal;
	}
	public String getDataNasc() {
        	return dataNasc;
    	}

   	 public void setDataNasc(String dataNasc) {
       	 	this.dataNasc = dataNasc;
    	}
	//      ### Funções ###
	// Soma valor do Quarto
	public void soma_Quarto(double valor) throws IOException {
		String numero_Relatorio = Cliente.ID +" - "+ "Relatorio.txt"; //Cria um nome para o arquivo TXT com o ID do client
		File relatorio = new File(numero_Relatorio); //Cria um Arquivo TXT com o nome acima
		relatorio.createNewFile();		     //Cria um Arquivo TXT 
		PrintWriter gravaRelatorio = new PrintWriter(relatorio); //criei isso aqui só pra formatar o texto logo abaixo
		
		gravaRelatorio.println("#------Relatótio------#\n"); //Escreve no arquivo TXT
		gravaRelatorio.printf("| Quarto: %.2f \n",valor);    //Escreve no arquivo TXT
		gravaRelatorio.close();      //Feixa o arquivo
		
		this.aluguelDoQuarto += valor;
	}
	// Soma valor do Consumo
	public void soma_Consumo(double valor) throws IOException {
		String numero_Relatorio = Cliente.ID + " - " + "Relatorio.txt";
		Writer relatorio = new BufferedWriter(new FileWriter(numero_Relatorio, true)); //Abre o arquivo com append true
		PrintWriter gravaRelatorio = new PrintWriter(relatorio);  //criei isso aqui só pra formatar o texto logo abaixo
	
		gravaRelatorio.println();  //pula uma linha nao estava conseguindo pular com o "\n"
		gravaRelatorio.printf("| Consumo: %.2f ", valor);  //Escreve no arquivo TXT
		gravaRelatorio.close();
		
		this.consumo += valor;
	}
	// Soma valor dos Danos
	public void soma_Danos(double valor) throws IOException {
		String numero_Relatorio = Cliente.ID + " - " + "Relatorio.txt";
		Writer relatorio = new BufferedWriter(new FileWriter(numero_Relatorio, true));
		PrintWriter gravaRelatorio = new PrintWriter(relatorio);
	
		gravaRelatorio.println();
		gravaRelatorio.printf("| Danos: %.2f ", valor);
		gravaRelatorio.close();
		
		this.danosCausados += valor;
	}
	// Soma valor Total
	public void soma_Total() throws IOException {
		String numero_Relatorio = Cliente.ID + " - " + "Relatorio.txt";
		Writer relatorio = new BufferedWriter(new FileWriter(numero_Relatorio, true));
		PrintWriter gravaRelatorio = new PrintWriter(relatorio);
	
		gravaRelatorio.println();
		gravaRelatorio.printf("| TOTAL: %.2f ", this.gastoTotal = this.aluguelDoQuarto + this.consumo + this.danosCausados);
		gravaRelatorio.close();
	}
}
