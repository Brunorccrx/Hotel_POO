package sistemadehotel;
/**
 *
 * @author Bruno Rodrigues Caputo
 * @author Francisco Pires Júnior
 * @author Gabriel Rodrigues Machado
 * @author Philip Mahama Akpanyi
 */

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Quarto {
	static private int totalQuartos;
	private String numeroQuarto;
	private String situacaoQuarto;
	private String tipoQuarto;
	private String refeicao;
	private double consumo;
	private double aluguelDoQuarto;
	private double danosCausados;
	private double gastoTotal;
	private static BufferedWriter BufWrit;
	Cliente cliente;
	Scanner input = new Scanner(System.in);
	/**
         * 
         * @param numeroQuarto Número do Quarto
         * @param tipoQuarto Tipo do Quarto: Casal, solteiro ou a ser definido
         */
	// Construtor
	public Quarto(String numeroQuarto, String tipoQuarto) {
		Quarto.totalQuartos++;
		this.numeroQuarto = numeroQuarto;
		System.out.println("Valor: " + alugarQuarto(tipoQuarto));
	}
	/**
     	*
     	*/
	public Quarto() {
		// Apenas AUXILIAR
	}
	/**
     	*
     	* @return Valor do consumo
     	*/
	// Get and Set
	public double getConsumo() {
		return this.consumo;
	}
	/**
     	*
     	* @param consumo Valor do consumo
     	*/
	public void setConsumo(double consumo) {
		this.consumo = consumo;
	}
	/**
     	*
     	* @return Tipo de Quarto
     	*/
	public String getTipoQuarto() {
		return this.tipoQuarto;
	}
	/**
     	*
     	* @param tipoQuarto Tipo de Quarto: Casal, solteiro ou a ser definido
     	*/
	public void setTipoQuarto(String tipoQuarto) {
		this.tipoQuarto = tipoQuarto;
	}
	/**
     	*
     	* @return Número do quarto
     	*/
	public String getNumeroQuarto() {
		return this.numeroQuarto;
	}
	/**
     	*
     	* @param numeroQuarto Número do quarto
     	*/
	public void setNumeroQuarto(String numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}
	
	/**
     	*
     	* @return O total de Quartos do hotel
     	*/
	public int getTotalQuartos() {
		return totalQuartos;
	}
	/**
     	*
     	* @param totalQuartos O total de Quartos do hotel
     	*/
	public void setTotalQuartos(int totalQuartos) {
		Quarto.totalQuartos = totalQuartos;
	}
	
	/**
     	*
     	* @return A situação do quarto: Limpo ou sujo
     	*/
	public String getSituacaoQuarto() {
		return situacaoQuarto;
	}
	
	/**
     	*
     	* @param situacaoQuarto A situação do quarto: Limpo ou sujo
     	*/
	public void setSituacaoQuarto(String situacaoQuarto) {
		this.situacaoQuarto = situacaoQuarto;
	}
	
	/**
     	*
     	* @return Tipo de Refeição
     	*/
	public String getRefeicao() {
		return this.refeicao;
	}
	
	/**
     	*
     	* @param tipo Refeição
     	*/
	public void setRefeicao(String tipo) {
		this.refeicao = tipo;
	}
	
	/**
     	*
     	* @return Valor de consumo total
     	*/
	public double getGastoTotal() {
		return gastoTotal;
	}
	
	/**
     	*
     	* @param gastoTotal Valor de consumo total
     	*/
	public void setGastoTotal(double gastoTotal) {
		this.gastoTotal = gastoTotal;
	}
	
	/**
     	*
     	* @return Valor do Aluguel
     	*/
	public double getAluguelDoQuarto() {
		return aluguelDoQuarto;
	}
	
	/**
     	*
     	* @param valorQuarto Valor do Aluguel
     	*/
	public void setAluguelDoQuarto(double valorQuarto) {
		this.aluguelDoQuarto = valorQuarto;
	}
	
	/**
     	*
     	* @return Valor de danos
     	*/
	public double getDanosCausados() {
		return danosCausados;
	}
	
	/**
     	*
     	* @param danosCausados Valor de Danos
     	*/
	public void setDanosCausados(double danosCausados) {
		this.danosCausados = danosCausados;
	}
	
	/**
     	*
	* @param tipoQuarto Solteiro, Casal ou a ser definido
     	* @return Valor do Quarto
     	*/
	// Funcoes cliente
	public double alugarQuarto(String tipoQuarto) {
		this.setTipoQuarto(tipoQuarto.toUpperCase());
		switch (this.tipoQuarto) {
		case "SOLTEIRO":
			this.aluguelDoQuarto = 1000;
			return 1000;
		case "CASAL":
			this.aluguelDoQuarto = 2000;
			return 2000;
		default:
			System.out.print("Digite o valor: ");
			double v = input.nextDouble();
			this.aluguelDoQuarto = v;
			return v;// Caso o tipo do quarto for diferente
		}
	}
	
	/**
     	*
	* @param cliente Cliente
     	* @return Quarto disponivel ou não e a situação do quarto
     	*/
	public String quartoDisponivel(Cliente cliente) {
		if (cliente == null && situacaoQuarto.equals("Limpo"))
			return "Quarto disponivel.";
		else if (cliente != null)
			return "Quarto indisponivel. Quarto ocupado pelo(a) cliente" + " " + cliente.getNome();
		else
			return "Quarto indisponivel. Quarto ainda nao foi limpo.";
	}
	
	/**
     	*
     	* 
     	*/
	public void removerCliente() {
		this.cliente = null;
	}
	
	/**
     	*
     	* @param cliente Cliente
     	*/
	public void adicionarCliente(Cliente cliente) {
		this.cliente = cliente;
		this.situacaoQuarto = "Ocupado";
	}
	
	/**
     	*
     	* 
	*/
	public void comprarRefeicao() {
		System.out.print("Quantos itens quer comprar: ");
		int aux = input.nextInt();
		for (int i = 1; i <= aux; i++) {
			this.setRefeicao(input.nextLine());
			this.setRefeicao(this.refeicao.toUpperCase());
			switch (this.refeicao) {
			case "REFRIGERANTE":
				this.calcularConsumo(4.5);
			case "PIZZA":
				this.calcularConsumo(50.0);
			case "SANDUICHE":
				this.calcularConsumo(20.0);
			default:// se a comprar for diferente que ja foi definido
				System.out.print("Digite o valor: ");
				double v = input.nextDouble();
				this.calcularConsumo(v);
			}
		}
	}
	
	/**
     	*
     	* @param valor Valor do consumo
	*/
	// Funcao para calucular consumo
	public void calcularConsumo(double valor) {
		this.setConsumo(this.getConsumo() + valor);
	}

	// ### Funcoes ###
	// Soma valor dos Danos
	
	/**
     	*
     	* @param valor Valor total de Danos Causados
	*/
	public void somarDanos(double valor) {
		this.danosCausados += valor;
	}
	
	/**
     	*
     	* 
	*/
	// Soma valor Total
	public void somarTotal() {
		this.setGastoTotal(this.aluguelDoQuarto + this.consumo + this.danosCausados);
	}
	
	/**
     	*
	* @param list Lista de Clientes
     	* @throws IOException Erro ao criar/escrever no arquivo
     	*/
	public void salvarConsumo(List<Cliente> list) throws IOException {

		Iterator<Cliente> inter = list.iterator();

		try {
			OutputStream os = new FileOutputStream("Relatorio de Consumo.txt");
			OutputStreamWriter osw = new OutputStreamWriter(os);
			BufWrit = new BufferedWriter(osw);
			while (inter.hasNext()) {
				Cliente cliente = inter.next();
				BufWrit.write(cliente.quarto.numeroQuarto + " " + cliente.quarto.aluguelDoQuarto + " "
						+ cliente.quarto.consumo + " " + cliente.quarto.danosCausados + " "
						+ cliente.quarto.gastoTotal);
				BufWrit.newLine();
			}

		} catch (FileNotFoundException e) {
			System.out.println("Erro ao tentar criar arquivo");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Erro ao tentar escrever no arquivo");
			e.printStackTrace();
		} finally {
			BufWrit.close();
		}
	}
}
