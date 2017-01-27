package sistemadehotel;

public class Cliente {
	// Dados Pessoais
	static private int ID;
	private String nome;
	private String CPF;
	private String passaporte;
	private String RG;
	private String numTelefone;
	private String nacionalidade;
	private String dataNasc;
	// Endereço
	private String rua;
	private String bairro;
	private String numCasa;
	private String cidade;
	private String estado;

	// Construtor
	public Cliente(String nome, String CPF, String RG) {
		Cliente.ID++;
		this.nome = nome;
		this.CPF = CPF;
		this.RG = RG;
	}

	public Cliente(String nome, String passaporte) {
		Cliente.ID++;
		this.nome = nome;
		this.passaporte = passaporte;
	}

	// get ID
	public int getID() {
		return ID;
	}

	// get e set Nome
	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	// get e set CPF
	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	// get e set Passaporte
	public String getPassaporte() {
		return passaporte;
	}

	public void setPassaporte(String passaporte) {
		this.passaporte = passaporte;
	}

	// get e set RG
	public String getRG() {
		return RG;
	}

	public void setRG(String rG) {
		RG = rG;
	}

	// get e set Numero de Telefone
	public String getNumTelefone() {
		return numTelefone;
	}

	public void setNumTelefone(String numTelefone) {
		this.numTelefone = numTelefone;
	}

	// get e set Nome
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	// get e set Rua
	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	// get e set Bairro
	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	// get e set Numero da Casa
	public String getNumCasa() {
		return numCasa;
	}

	public void setNumCasa(String numCasa) {
		this.numCasa = numCasa;
	}

	// get e set Cidade
	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	// get e set Estado
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	// get e set Data de Nascimento
	public String getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}
}
