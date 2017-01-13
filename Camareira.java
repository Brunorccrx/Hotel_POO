
class Camareira extends Funcionario{
	public void limpar(Quarto quarto){
		quarto.setSituacaoQuarto("Limpo");
	}
	public void servicoDeQuarto(Quarto quarto,String refeicao){
		quarto.setConsumo(refeicao);
	}


}
