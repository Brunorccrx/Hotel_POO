
package sistemadehotel;


public abstract class Funcionario {
  // Dados Pessoais
	static private int ID;
	private String nome;
	private String CPF;
	private String RG;
	private String numTelefone;
	//Endereço
	private String rua;
	private String bairro;
	private String nomeCasa;
	private String cidade;
	private String estado;
	//Data de Nascimento
	private int dia;
	private int mes;
	private int ano;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        Funcionario.ID = ID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getNomeCasa() {
        return nomeCasa;
    }

    public void setNomeCasa(String nomeCasa) {
        this.nomeCasa = nomeCasa;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

	void autenticaSenha(String senha)throws Exception{
		if(senha.length()<7)
			throw new IOException("Senha deve ter no mínimo 7 caracteres");
		if(senha.length()>14)
			throw new IOException("Senha ultrapassou o limite máximo de 14 caracteres");
	}
	void autenticaLogin(String login) throws IOException{
		if(login.length()<5)
			throw new IOException("Login deve ter no mínimo 5 caracteres");
		if(login.length()>20)
			throw new IOException("Login ultrapassou o limite máximo de 20 caracteres");
	}
}
