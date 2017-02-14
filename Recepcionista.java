package sistemadehotel;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Recepcionista extends Funcionario implements Autentica {
	private String login = "luidi";
	private String senha = "321";
	Scanner entrada = new Scanner(System.in);

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) throws IOException {
		if (senha.length() < 7)
			throw new IOException("Senha deve ter no mínimo 7 caracteres");
		if (senha.length() > 14)
			throw new IOException("Senha ultrapassou o limite máximo de 14 caracteres");

		this.senha = senha;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) throws IOException {
		if (login.length() < 5)
			throw new IOException("Login deve ter no mínimo 5 caracteres");
		if (login.length() > 20)
			throw new IOException("Login ultrapassou o limite máximo de 20 caracteres");

		this.login = login;
	}

	public boolean autentica(String senha, String login) {
		return this.senha.equals(senha) && this.login.equals(login);
	}

	protected void cadastrarCliente(List<Cliente> clientes ) {
		System.out.print("Numero do quarto: ");
		String numeroQuarto = entrada.next();
		System.out.print("Tipo do quarto: ");
		String tipoQuarto = entrada.next();
		Cliente cliente = new Cliente(numeroQuarto, tipoQuarto);
		System.out.print("Nome: ");
		cliente.setNome(entrada.next());
		System.out.print("Nacionalidade: ");
		cliente.setNacionalidade(entrada.next());
		if (cliente.getNacionalidade().equals("BRASILEIRO")) {
			System.out.print("CPF: ");
			cliente.setCPF(entrada.next());
			System.out.print("RG: ");
			cliente.setRG(entrada.next());
		} else {
			System.out.print("Passaporte: ");
			cliente.setPassaporte(entrada.next());
		}
		System.out.print("Data de nascimento: : ");
		cliente.setDataNasc(entrada.next());
		System.out.print("Contato: ");
		cliente.setNumTelefone(entrada.next());
		System.out.print("Rua: ");
		cliente.setRua(entrada.next());
		System.out.print("Bairro: ");
		cliente.setBairro(entrada.next());
		System.out.print("Complemento: ");
		cliente.setComplemento(entrada.next());
		System.out.print("Numero da casa: ");
		cliente.setNumeroCasa(entrada.next());
		System.out.print("Cidade: ");
		cliente.setCidade(entrada.next());
		System.out.print("Estado: ");
		cliente.setEstado(entrada.next());

		clientes.add(cliente);
	}

	protected void removerCliente(List<Cliente> clientes, Cliente cliente) {
		clientes.remove(cliente);
	}

	protected void mostrarClientes(List<Cliente> clientes) {
		for (Cliente cliente : clientes)
			System.out.println(cliente);

	}
}