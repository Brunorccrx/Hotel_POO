package sistemadehotel;
/**
 *
 * @author Bruno Rodrigues Caputo
 * @author Francisco Pires Júnior
 * @author Gabriel Rodrigues Machado
 * @author Philip Mahama Akpanyi
 */

abstract public class Pessoa {
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
	/**
	*
	* @return nome
	*/
	public String getNome() {
		return nome;
	}
	/**
	*
	* @param nome Nome da pessoa
	*/
	public void setNome(String nome) {
		this.nome = nome.toUpperCase();
	}
	/**
	*
	* @return CPF da pessoa
	*/
	public String getCPF() {
		return CPF;
	}
	/**
	*
	* @param CPF CPF da Pessoa
	*/
	public void setCPF(String CPF) {
		this.CPF = CPF;
	}
	/**
	*
	* @return RG da Pessoa
	*/
	public String getRG() {
		return RG;
	}
	/**
	* 
	* @param RG RG da Pessoa
	*/
	public void setRG(String RG) {
		this.RG = RG;
	}
	/**
	*
	* @return Número de telefone
	*/
	public String getNumTelefone() {
		return numTelefone;
	}
	/**
	*
	* @param numTelefone Número de Telefone
	*/
	public void setNumTelefone(String numTelefone) {
		this.numTelefone = numTelefone;
	}
	/**
	*
	* @return Data de Nascimento
	*/
	public String getDataNasc() {
		return dataNasc;
	}
	/**
	*
	* @param dataNasc Data de Nascimento
	*/
	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}
	/**
	*
	* @return Nome da rua
	*/
	public String getRua() {
		return rua;
	}
	/**
	*
	* @param rua Nome da rua
	*/
	public void setRua(String rua) {
		this.rua = rua.toUpperCase();
	}
	/**
	*
	* @return Nome do bairro
	*/
	public String getBairro() {
		return bairro;
	}
	/**
	*
	* @param bairro Nome do bairro
	*/
	public void setBairro(String bairro) {
		this.bairro = bairro.toUpperCase();
	}
	/**
	*
	* @return Complemento de endereço
	*/
	public String getComplemento() {
		return complemento;
	}
	/**
	*
	* @param complemento Complemento de endereço
	*/
	public void setComplemento(String complemento) {
		this.complemento = complemento.toUpperCase();
	}
	/**
	*
	* @return Número da casa
	*/
	public String getNumeroCasa() {
		return numeroCasa;
	}
	/**
	*
	* @param numeroCasa Número da casa 
	*/
	public void setNumeroCasa(String numeroCasa) {
		this.numeroCasa = numeroCasa;
	}
	/**
	*
	* @return Nome da cidade
	*/
	public String getCidade() {
		return cidade;
	}
	/**
	*
	* @param cidade Nome da cidade
	*/
	public void setCidade(String cidade) {
		this.cidade = cidade.toUpperCase();
	}
	/**
	*
	* @return Nome do Estado
	*/
	public String getEstado() {
		return estado;
	}
	/**
	*
	* @param estado Nome do Estado
	*/
	public void setEstado(String estado) {
		this.estado = estado.toUpperCase();
	}
}
