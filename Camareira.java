package sistemadehotel;
/**
 *
 * @author Bruno Rodrigues Caputo
 * @author Francisco Pires Júnior
 * @author Gabriel Rodrigues Machado
 * @author Philip Mahama Akpanyi
 */

public class Camareira extends Funcionario {
	/**
	*
	* @param quarto
	*/
	public void limparQuarto(Quarto quarto) {
		quarto.setSituacaoQuarto("Limpo");
	}
	/**
	*
	* @param quarto
	*/
	public void servicoDeQuarto(Quarto quarto) {
		quarto.comprarRefeicao();
	}
}
