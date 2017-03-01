package sistemadehotel;

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

	// Construtor
	public Quarto(String numeroQuarto, String tipoQuarto) {
		Quarto.totalQuartos++;
		this.numeroQuarto = numeroQuarto;
		System.out.println("Valor: " + alugarQuarto(tipoQuarto));
	}

	public Quarto() {
		// Apenas AUXILIAR
	}

	// Get and Set
	public double getConsumo() {
		return this.consumo;
	}

	public void setConsumo(double consumo) {
		this.consumo = consumo;
	}

	public String getTipoQuarto() {
		return this.tipoQuarto;
	}

	public void setTipoQuarto(String tipoQuarto) {
		this.tipoQuarto = tipoQuarto;
	}

	public String getNumeroQuarto() {
		return this.numeroQuarto;
	}

	public void setNumeroQuarto(String numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
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

	public void setSituacaoQuarto(String situacaoQuarto) {
		this.situacaoQuarto = situacaoQuarto;
	}

	public String getRefeicao() {
		return this.refeicao;
	}

	public void setRefeicao(String tipo) {
		this.refeicao = tipo;
	}

	public double getGastoTotal() {
		return gastoTotal;
	}

	public void setGastoTotal(double gastoTotal) {
		this.gastoTotal = gastoTotal;
	}

	public double getAluguelDoQuarto() {
		return aluguelDoQuarto;
	}

	public void setAluguelDoQuarto(double valorQuarto) {
		this.aluguelDoQuarto = valorQuarto;
	}

	public double getDanosCausados() {
		return danosCausados;
	}

	public void setDanosCausados(double danosCausados) {
		this.danosCausados = danosCausados;
	}

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

	public String quartoDisponivel(Cliente cliente) {
		if (cliente == null && situacaoQuarto.equals("Limpo"))
			return "Quarto disponivel.";
		else if (cliente != null)
			return "Quarto indisponivel. Quarto ocupado pelo(a) cliente" + " " + cliente.getNome();
		else
			return "Quarto indisponivel. Quarto ainda nao foi limpo.";
	}

	public void removerCliente() {
		this.cliente = null;
	}

	public void adicionarCliente(Cliente cliente) {
		this.cliente = cliente;
		this.situacaoQuarto = "Ocupado";
	}

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

	// Funcao para calucular consumo
	public void calcularConsumo(double valor) {
		this.setConsumo(this.getConsumo() + valor);
	}

	// ### Funcoes ###
	// Soma valor dos Danos
	public void somarDanos(double valor) {
		this.danosCausados += valor;
	}

	// Soma valor Total
	public void somarTotal() {
		this.setGastoTotal(this.aluguelDoQuarto + this.consumo + this.danosCausados);
	}

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