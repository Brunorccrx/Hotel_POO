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
     * @param senha
     * @param login
     * @return 
     */
	public boolean autentica(String senha, String login);
}
