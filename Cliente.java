package sistemadehotel;

public class Cliente extends Pessoa {
	// Dados Pessoais
	static private int ID;
	private String passaporte;
	private String nacionalidade;
	Quarto quarto;

	// Construtor

	public Cliente(String numeroQuarto, String tipoQuarto) {
		Cliente.ID++;
		quarto = new Quarto(numeroQuarto, tipoQuarto);
	}

	public Cliente() {
		// Apenas AUXILIAR
		quarto = new Quarto();
	}

	// get ID
	public int getID() {
		return ID;
	}

	// get e set Nacionalidade
	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		String toUpperCase = nacionalidade.toUpperCase();
		this.nacionalidade = toUpperCase;
	}

	// get e set Passaporte
	public String getPassaporte() {
		return passaporte;
	}

	public void setPassaporte(String passaporte) {
		this.passaporte = passaporte;
	}

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

	// TODO Metodo para comprar refeicao
}