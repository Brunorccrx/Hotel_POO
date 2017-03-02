package sistemadehotel;
/**
 *
 * @author Bruno Rodrigues Caputo
 * @author Francisco Pires Júnior
 * @author Gabriel Rodrigues Machado
 * @author Philip Mahama Akpanyi
 */
     
public interface Autentica {
    /**
     * @param senha Senha para efetuar autenticação
     * @param login Nome do funcionário
     * @return Verdade ou Falso
     */
	public boolean autentica(String senha, String login);
}
