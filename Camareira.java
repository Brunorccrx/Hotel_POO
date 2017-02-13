package sistemadehotel;

public class Camareira extends Funcionario {
	public void limparQuarto(Quarto quarto) {
		quarto.setSituacaoQuarto("Limpo");
	}

	public void servicoDeQuarto(Quarto quarto) {
		quarto.comprarRefeicao();
	}
}
