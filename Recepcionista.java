package sistemadehotel;

import java.io.IOException;
import java.util.Scanner;
import java.io.IOException;
import java.util.Scanner;

public class Recepcionista extends Funcionario implements Autentica {
	
	private String login;
	private String senha;
	private Cliente cliente;
	

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha)throws IOException{
		if(senha.length()<7)
			throw new IOException("Senha deve ter no mínimo 7 caracteres");
		if(senha.length()>14)
			throw new IOException("Senha ultrapassou o limite máximo de 14 caracteres");

		this.senha = senha;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) throws IOException {
		if(login.length()<5)
			throw new IOException("Login deve ter no mínimo 5 caracteres");
		if(login.length()>20)
			throw new IOException("Login ultrapassou o limite máximo de 20 caracteres");

		this.login = login;
	}

	public boolean autentica(String senha){
		if(this.senha.equals(senha))
			return true;
		else
			return false;
	}
	// Cadastra um novo cliente
	public Cliente cadastra_Cliente(String nacionalidade) {
		nacionalidade.toUpperCase();
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		if(nacionalidade.equals("BRASILEIRO")){
			String nome, CPF, RG;
			System.out.print("Nome: ");
			nome = input.next();
			System.out.print("CPF: ");
			CPF = input.next();
			System.out.print("RG: ");
			RG = input.next();
			cliente = new Cliente(nome, CPF, RG);
		}else {
			String nome, passaporte;
			System.out.print("Nome: ");
			nome = input.nextLine();
			System.out.print("Passaporte: ");
			passaporte = input.nextLine();
			cliente = new Cliente(nome, passaporte);
		}
		
		return cliente;
	}
public class Recepcionista extends Funcionario implements Autentica{
	
	private String login;
	private String senha;
	
	public String getSenha() {
    return senha;
	}
	public void setSenha(String senha)throws IOException{
    if(senha.length()<7){
	throw new IOException("Senha deve ter no mínimo 7 caracteres");
    }
    if(senha.length()>14){
	throw new IOException("Senha ultrapassou o limite máximo de 14 caracteres");
    }

	this.senha = senha;
}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) throws IOException {
		if(login.length()<5){
			throw new IOException("Login deve ter no mínimo 5 caracteres");
		}
	if(login.length()>20){
		throw new IOException("Login ultrapassou o limite máximo de 20 caracteres");  
	}	
	this.login = login;	
}
	@Override
	public boolean autentica(String senha){
		return this.senha.equals(senha);
	}
}