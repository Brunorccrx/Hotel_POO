package sistemadehotel;
/**
 *
 * @author Bruno Rodrigues Caputo
 * @author Francisco Pires Júnior
 * @author Gabriel Rodrigues Machado
 * @author Philip Mahama Akpanyi
 */

abstract public class Funcionario extends Pessoa {
	private double salario;
	static private int ID;
	/**
	*
	* 
	*/
	public Funcionario() {
		Funcionario.ID++;
	}
	/**
	*
	* @return Valor de Salário
	*/
	public double getSalario() {
		return salario;
	}
	/**
	*
	* @param salario Valor de Salário
	*/
	public void setSalario(double salario) {
		this.salario = salario;
	}
	/**
	*
	* @return ID
	*/
	public static int getID() {
		return ID;
	}
	/**
	*
	* @return Nome, Data de nascimento, Contato, Rua, Bairro, Complemento, Número de casa, Cidade, Estado e Salário
	*/
	@Override
	public String toString() {
		String saida = "Nome: " + this.getNome() + "\n" + "Data de nascimento: : " + this.getDataNasc() + "\n"
				+ "Contato: " + this.getNumTelefone() + "\n" + "Rua: " + this.getRua() + "\n" + "Bairro: "
				+ this.getBairro() + "\n" + "Complemento: " + this.getComplemento() + "\n" + "Numero da casa: "
				+ this.getNumeroCasa() + "\n" + "Cidade: " + this.getCidade() + "\n" + "Estado: " + this.getEstado()
				+ "\n" + "Salário: " + this.getSalario() + "\n";

		return saida;
	}
}
