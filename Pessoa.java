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
	* @return
	*/
	public String getNome() {
		return nome;
	}
	/**
	*
	* @param nome
	*/
	public void setNome(String nome) {
		this.nome = nome.toUpperCase();
	}
	/**
	*
	* @return
	*/
	public String getCPF() {
		return CPF;
	}
	/**
	*
	* @param CPF
	*/
	public void setCPF(String CPF) {
		this.CPF = CPF;
	}
	/**
	*
	* @return
	*/
	public String getRG() {
		return RG;
	}
	/**
	* 
	* @param RG
	*/
	public void setRG(String RG) {
		this.RG = RG;
	}
	/**
	*
	* @return
	*/
	public String getNumTelefone() {
		return numTelefone;
	}
	/**
	*
	* @param numTelefone
	*/
	public void setNumTelefone(String numTelefone) {
		this.numTelefone = numTelefone;
	}
	/**
	*
	* @return
	*/
	public String getDataNasc() {
		return dataNasc;
	}
	/**
	*
	* @param dataNasc
	*/
	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}
	/**
	*
	* @return
	*/
	public String getRua() {
		return rua;
	}
	/**
	*
	* @param rua
	*/
	public void setRua(String rua) {
		this.rua = rua.toUpperCase();
	}
	/**
	*
	* @return
	*/
	public String getBairro() {
		return bairro;
	}
	/**
	*
	* @param bairro
	*/
	public void setBairro(String bairro) {
		this.bairro = bairro.toUpperCase();
	}
	/**
	*
	* @return
	*/
	public String getComplemento() {
		return complemento;
	}
	/**
	*
	* @param complemento
	*/
	public void setComplemento(String complemento) {
		this.complemento = complemento.toUpperCase();
	}
	/**
	*
	* @return
	*/
	public String getNumeroCasa() {
		return numeroCasa;
	}
	/**
	*
	* @param numeroCasa
	*/
	public void setNumeroCasa(String numeroCasa) {
		this.numeroCasa = numeroCasa;
	}
	/**
	*
	* @return
	*/
	public String getCidade() {
		return cidade;
	}
	/**
	*
	* @param cidade
	*/
	public void setCidade(String cidade) {
		this.cidade = cidade.toUpperCase();
	}
	/**
	*
	* @return
	*/
	public String getEstado() {
		return estado;
	}
	/**
	*
	* @param estado
	*/
	public void setEstado(String estado) {
		this.estado = estado.toUpperCase();
	}
}
