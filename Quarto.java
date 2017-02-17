
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
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
  Cliente cliente;
  Scanner input = new Scanner(System.in);

  // Construtor
  public Quarto(String numeroQuarto, String tipoQuarto) {
    Quarto.totalQuartos++;
    this.numeroQuarto = numeroQuarto;
    this.tipoQuarto = tipoQuarto;
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

  // Funcoes Quarto
  public double alugarQuarto() {
    this.setTipoQuarto(this.tipoQuarto.toUpperCase());
    switch (this.tipoQuarto) {
      case "SOLTEIRO":
        return 1000;
      case "CASAL":
        return 2000;
      default:
        System.out.print("Digite o valor: ");
        return input.nextDouble();// Caso o tipo do quarto for diferente
    }
  }

  public String quartoDisponivel(Cliente cliente) {
    if (cliente == null && situacaoQuarto.equals("Limpo"))
      return "Quarto disponivel.";
    else if (cliente != null)
      return "Quarto indisponivel.Quarto ocupado pelo(a) cliente" + " " + cliente.getNome();
    else
      return "Quarto indisponivel.Quarto ainda nÃ£o foi limpo.";
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
        default:// se a comprar for diferente que jÃ¡ definido
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
  // ### Funções ###
  // Soma valor do Quarto
  public void soma_Quarto(double valor) {
    String numero_Relatorio = this.numeroQuarto + " - " + "Relatorio.txt";
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
    gravaRelatorio.printf("| Quarto: %.2f \n", valor);
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

    try (PrintWriter gravaRelatorio = new PrintWriter(relatorio)) {
      gravaRelatorio.println();
      gravaRelatorio.printf("| TOTAL: %.2f ",
              this.setGastoTotal(this.aluguelDoQuarto + this.consumo + this.danosCausados));

    }
  }

  public double getGastoTotal() {
    return gastoTotal;
  }

  public double setGastoTotal(double gastoTotal) {
    this.gastoTotal = gastoTotal;
    return gastoTotal;
  }
}
