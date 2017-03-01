package sistemadehotel;
/**
 *
 * @author Bruno Rodrigues Caputo
 * @author Francisco Pires Júnior
 * @author Gabriel Rodrigues Machado
 * @author Philip Mahama Akpanyi
 */

public class Camareira extends Funcionario {
	public void limparQuarto(Quarto quarto) {
		quarto.setSituacaoQuarto("Limpo");
	}

	public void servicoDeQuarto(Quarto quarto) {
		quarto.comprarRefeicao();
	}
}
