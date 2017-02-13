package sistemadehotel;

public class Funcionario extends Pessoa {
	private double salario;
	static private int ID;

	public Funcionario() {
		Funcionario.ID++;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public static int getID() {
		return ID;
	}

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
