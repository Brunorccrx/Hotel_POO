package sistemadehotel;

public class Pessoa {
	// Dados Pessoais
	private String nome;
	private String CPF;
	private String RG;
	private String numTelefone;
	private String dataNasc;
	// Endereço
	private String rua;
	private String bairro;
	private String complemento;
	private String numeroCasa;
	private String cidade;
	private String estado;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome.toUpperCase();
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String CPF) {
		this.CPF = CPF;
	}

	public String getRG() {
		return RG;
	}

	public void setRG(String RG) {
		this.RG = RG;
	}

	public String getNumTelefone() {
		return numTelefone;
	}

	public void setNumTelefone(String numTelefone) {
		this.numTelefone = numTelefone;
	}

	public String getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua.toUpperCase();
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro.toUpperCase();
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento.toUpperCase();
	}

	public String getNumeroCasa() {
		return numeroCasa;
	}

	public void setNumeroCasa(String numeroCasa) {
		this.numeroCasa = numeroCasa;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade.toUpperCase();
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado.toUpperCase();
	}
}
