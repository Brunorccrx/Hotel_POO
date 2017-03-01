package sistemadehotel;

/**
 *
 * @author Bruno Rodrigues Caputo
 * @author Francisco Pires Júnior
 * @author Gabriel Rodrigues Machado
 * @author Philip Mahama Akpanyi
 */

public class Cliente extends Pessoa {
	// Dados Pessoais
	static private int ID;
	private String passaporte;
	private String nacionalidade;
	Quarto quarto;

	/**
	* Construtor
	* @param numeroQuarto
	* @param tipoQuarto
	*/ 
	public Cliente(String numeroQuarto, String tipoQuarto) {
		Cliente.ID++;
		quarto = new Quarto(numeroQuarto, tipoQuarto);
	}
	/**
	* Construtor
	* Vazio
	*/
	public Cliente() {
		// Apenas AUXILIAR
		quarto = new Quarto();
	}

	/**
	* getID
	* @return
	*/
	public int getID() {
		return ID;
	}

	/**
	* getNacionalidade
	* @return
	*/
	public String getNacionalidade() {
		return nacionalidade;
	}
	/**
	* setNacionalidade
	* @param nacionalidade
	*/
	public void setNacionalidade(String nacionalidade) {
		String toUpperCase = nacionalidade.toUpperCase();
		this.nacionalidade = toUpperCase;
	}

	/**
	* getPassaporte
	* @return
	*/
	public String getPassaporte() {
		return passaporte;
	}
	/**
	* setPassaporte
	* @param passaporte
	*/
	public void setPassaporte(String passaporte) {
		this.passaporte = passaporte;
	}

	/**
	* toString
	* @Override
	* @return
	*/
	@Override
	public String toString() {
		String saida = "Nome: " + this.getNome() + "\n" + "Nacionalidade: " + this.getNacionalidade() + "\n"
				+ "Data de nascimento: : " + this.getDataNasc() + "\n" + "Contato: " + this.getNumTelefone() + "\n"
				+ "Rua: " + this.getRua() + "\n" + "Bairro: " + this.getBairro() + "\n" + "Complemento: "
				+ this.getComplemento() + "\n" + "Numero da casa: " + this.getNumeroCasa() + "\n" + "Cidade: "
				+ this.getCidade() + "\n" + "Estado: " + this.getEstado() + "\n";

		if (this.getNacionalidade().equals("BRASILEIRO")) {
			saida = saida.concat("CPF: " + this.getCPF() + "\n" + "RG: " + this.getRG() + "\n");
		} else {
			saida = saida.concat("Passaporte: " + this.getPassaporte() + "\n");
		}

		return saida;
	}
}
