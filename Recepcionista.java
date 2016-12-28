package sistemadehotel;

classe Recepcionista extends Funcionario implements Autentica{


	private String login;
	private String senha;

	public String getSenha() {
			return senha;
	}

	public void setSenha(String senha) {
			this.senha = senha;
	}

}
