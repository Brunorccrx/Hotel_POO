package sistemadehotel;

import java.util.Scanner;

public class Quarto {
	static private int totalQuartos;
        private String numeroQuarto;
        private String situacaoQuarto;
	private String tipoQuarto;
	private double consumo;
        private String refeicao;
	Cliente cliente;
        Scanner input = new Scanner(System.in);


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
public String getRefeicao(){
    return this.refeicao;
}
public void setRefeicao(String tipo){
    this.refeicao=tipo;
}
//Funcoes Quarto
public double alugarQuarto(){
    this.setTipoQuarto(this.tipoQuarto.toUpperCase());
    switch(this.tipoQuarto){
        case "SOLTEIRO":
            return 1000;
        case "CASAL":
            return 2000;
        default:
            System.out.print("Digite o valor: ");
            double v = input.nextDouble();
            return v;//Caso o tipo do quarto for diferente
    }
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
public void comprarRefeicao(){
    System.out.print("Quantos itens quer comprar: ");
    int aux = input.nextInt();
    for(int i = 1; i <= aux; i++){
        this.setRefeicao(input.nextLine());
    this.setRefeicao(this.refeicao.toUpperCase());
            switch (this.refeicao) {
                case "REFRIGERANTE":
                    this.calcularConsumo(4.5);
                case "PIZZA":
                    this.calcularConsumo(50.0);
                case "SANDUICHE":
                    this.calcularConsumo(20.0);
                default://se a comprar for diferente que já definido
                    System.out.print("Digite o valor: ");
                    double v = input.nextDouble();
                    this.calcularConsumo(v);
            }
    }
}
//Funcao para calucular consumo
public void calcularConsumo(double valor){
    this.setConsumo(this.getConsumo() + valor);
}
	
}
