package sistemadehotel;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Gerente extends Funcionario implements Autentica {
	private String login = "mario";
	private String senha = "123";
	private Scanner entrada = new Scanner(System.in);
    private static BufferedWriter BufWrit;
	private static Gerente gerente = new Gerente();

	private Gerente() {
	}

	public static Gerente getInstance() {
		return gerente;
	}

	protected void cadastrarFuncionario(List<Camareira> camareiras, Camareira camareira) {

		System.out.print("Nome: ");
		camareira.setNome(entrada.nextLine().toUpperCase());
		System.out.print("RG: ");
		camareira.setRG(entrada.nextLine().toUpperCase());
		System.out.print("CPF: ");
		camareira.setCPF(entrada.nextLine().toUpperCase());
		System.out.print("Data de nascimento: : ");
		camareira.setDataNasc(entrada.nextLine().toUpperCase());
		System.out.print("Contato: ");
		camareira.setNumTelefone(entrada.nextLine().toUpperCase());
		System.out.print("Rua: ");
		camareira.setRua(entrada.nextLine().toUpperCase());
		System.out.print("Bairro: ");
		camareira.setBairro(entrada.nextLine().toUpperCase());
		System.out.print("Complemento: ");
		camareira.setComplemento(entrada.nextLine().toUpperCase());
		System.out.print("Numero da casa: ");
		camareira.setNumeroCasa(entrada.nextLine().toUpperCase());
		System.out.print("Cidade: ");
		camareira.setCidade(entrada.nextLine().toUpperCase());
		System.out.print("Estado: ");
		camareira.setEstado(entrada.nextLine().toUpperCase());
		System.out.print("Salário: ");
		camareira.setSalario(entrada.nextDouble());

		camareiras.add(camareira);
	}

	protected void cadastrarFuncionario(List<Recepcionista> recepcionistas, Recepcionista recepcionista) {
		// Scanner entrada = new Scanner(System.in);

		System.out.print("Nome: ");
		recepcionista.setNome(entrada.nextLine().toUpperCase());
		System.out.print("RG: ");
		recepcionista.setRG(entrada.nextLine().toUpperCase());
		System.out.print("CPF: ");
		recepcionista.setCPF(entrada.nextLine().toUpperCase());
		System.out.print("Data de nascimento: : ");
		recepcionista.setDataNasc(entrada.nextLine().toUpperCase());
		System.out.print("Contato: ");
		recepcionista.setNumTelefone(entrada.nextLine().toUpperCase());
		System.out.print("Rua: ");
		recepcionista.setRua(entrada.nextLine().toUpperCase());
		System.out.print("Bairro: ");
		recepcionista.setBairro(entrada.nextLine().toUpperCase());
		System.out.print("Complemento: ");
		recepcionista.setComplemento(entrada.nextLine().toUpperCase());
		System.out.print("Numero da casa: ");
		recepcionista.setNumeroCasa(entrada.nextLine().toUpperCase());
		System.out.print("Cidade: ");
		recepcionista.setCidade(entrada.nextLine().toUpperCase());
		System.out.print("Estado: ");
		recepcionista.setEstado(entrada.nextLine().toUpperCase());
		System.out.print("Salário: ");
		recepcionista.setSalario(entrada.nextDouble());

		recepcionistas.add(recepcionista);
	}

	protected Funcionario removerFuncionario(List<? extends Funcionario> funcionarios,
			List<? extends Funcionario> funcionarios2) {
		// Scanner entrada = new Scanner(System.in);
		Gerente gerente = new Gerente();
		Funcionario funcionario;

		System.out.println("Nome funcionario: ");
		String nome = entrada.nextLine().toUpperCase();
		System.out.println("CPF: ");
		String cpf = entrada.nextLine().toUpperCase();

		funcionario = gerente.verificaFuncionario(nome, cpf, funcionarios);
		if (funcionario == null) {
			funcionario = gerente.verificaFuncionario(nome, cpf, funcionarios2);
			if (funcionario == null)
				System.out.println("** FUNCIONARIO NÃO ENCONTRADO **");
			else
				funcionarios2.remove(funcionario);
		} else
			funcionarios.remove(funcionario);

		if (funcionario != null)
			System.out.println("** FUNCIONARIO REMOVIDO COM SUCESSO **");

		return funcionario;

	}

	protected void mostrarFuncionarios(List<? extends Funcionario> funcionarios) {
		for (Funcionario funcionario : funcionarios)
			System.out.println(funcionario);
	}

	protected Funcionario verificaFuncionario(String nome, String CPF, List<? extends Funcionario> funcionarios) {
		for (Funcionario funcionario : funcionarios)
			if ((funcionario.getNome().equals(nome) && funcionario.getCPF().equals(CPF)))
				return funcionario;

		return null;
	}

	protected Funcionario alterarFuncionario(List<? extends Funcionario> funcionarios,
			List<? extends Funcionario> funcionarios2) {

		// Scanner entrada = new Scanner(System.in);
		Gerente gerente = new Gerente();
		Funcionario funcionario;

		System.out.println("Nome funcionario: ");
		String nome = entrada.nextLine().toUpperCase();
		System.out.println("CPF: ");
		String cpf = entrada.nextLine().toUpperCase();

		funcionario = gerente.verificaFuncionario(nome, cpf, funcionarios);
		if (funcionario == null) {
			funcionario = gerente.verificaFuncionario(nome, cpf, funcionarios2);
		}
		if (funcionario == null)
			System.out.println("** FUNCIONARIO NÃO ENCONTRADO **");
		else {
			System.out.println("Qual dado deseja alterar do funcionario " + funcionario.getNome() + "?");
			int opcao;

			System.out.println("\n1 - Nome  2 - CPF  3 - RG  4 - NúmeroDeTelefone  5 - DataDeNascimento" + '\n'
					+ "6 - Rua  7 - Bairro  8 - Complemento  9 - NumeroDaCasa  10 - Cidade" + '\n' + "11 - Estado"
					+ '\n');

			opcao = entrada.nextInt();
			entrada.nextLine();
			System.out.println("Por favor insira o novo dado");
			if (opcao == 1)
				funcionario.setNome(entrada.nextLine());
			else if (opcao == 2)
				funcionario.setCPF(entrada.nextLine());
			else if (opcao == 3)
				funcionario.setRG(entrada.nextLine());
			else if (opcao == 4)
				funcionario.setNumTelefone(entrada.nextLine());
			else if (opcao == 5)
				funcionario.setDataNasc(entrada.nextLine());
			else if (opcao == 6)
				funcionario.setRua(entrada.nextLine());
			else if (opcao == 7)
				funcionario.setBairro(entrada.nextLine());
			else if (opcao == 8)
				funcionario.setComplemento(entrada.nextLine());
			else if (opcao == 9)
				funcionario.setNumeroCasa(entrada.nextLine());
			else if (opcao == 10)
				funcionario.setCidade(entrada.nextLine());
			else if (opcao == 11)
				funcionario.setEstado(entrada.nextLine());

			System.out.println("**DADO ALTERADO COM SUCESSO\n");
		}
		return funcionario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) throws IOException {
		if (senha.length() < 7) {
			throw new IOException("Senha deve ter no mínimo 7 caracteres");
		}
		if (senha.length() > 14) {
			throw new IOException("Senha ultrapassou o limite máximo de 14 caracteres");
		}

		this.senha = senha;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) throws IOException {
		if (login.length() < 5) {
			throw new IOException("Login deve ter no mínimo 5 caracteres");
		}
		if (login.length() > 20) {
			throw new IOException("Login ultrapassou o limite máximo de 20 caracteres");
		}

		this.login = login;
	}

	// ### SALVA OS DADOS NO ARQUIVO ###
	public void salvarDadosRecepcionista(List<Recepcionista> list) throws IOException {

		Iterator<Recepcionista> inter = list.iterator();

		try {
			BufWrit = new BufferedWriter(new FileWriter(
					"C:\\Users\\PIRES\\Downloads\\Sistema de Hotelaria\\Banco de Dados\\recepcionista.txt"));
			while (inter.hasNext()) {
				Recepcionista r = inter.next();
				Gerente.BufWrit.write(r.getNome() + "/" + r.getRG() + "/" + r.getCPF() + "/" + r.getNumTelefone() + "/"
						+ r.getDataNasc() + "/" + r.getRua() + "/" + r.getBairro() + "/" + r.getComplemento() + "/"
						+ r.getNumeroCasa() + "/" + r.getCidade() + "/" + r.getEstado() + "/" + r.getSalario() + "/");
				Gerente.BufWrit.newLine();
			}

		} catch (FileNotFoundException e) {
			System.out.println("Erro ao tentar criar arquivo");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Erro ao tentar escrever no arquivo");
			e.printStackTrace();
		} finally {
			BufWrit.close();
		}
	}

	public void salvarDadosCamareira(List<Camareira> list) throws IOException {

		Iterator<Camareira> inter = list.iterator();

		try {
			BufWrit = new BufferedWriter(new FileWriter(
					"C:\\Users\\PIRES\\Downloads\\Sistema de Hotelaria\\Banco de Dados\\Camareiras.txt"));
			while (inter.hasNext()) {
				Camareira c = inter.next();
				Gerente.BufWrit.write(c.getNome() + "/" + c.getRG() + "/" + c.getCPF() + "/" + c.getNumTelefone() + "/"
						+ c.getDataNasc() + "/" + c.getRua() + "/" + c.getBairro() + "/" + c.getComplemento() + "/"
						+ c.getNumeroCasa() + "/" + c.getCidade() + "/" + c.getEstado() + "/" + c.getSalario() + "/");
				Gerente.BufWrit.newLine();
			}

		} catch (FileNotFoundException e) {
			System.out.println("Erro ao tentar criar arquivo");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Erro ao tentar escrever no arquivo");
			e.printStackTrace();
		} finally {
			BufWrit.close();
		}
	}

	@Override
	public boolean autentica(String senha, String login) {
		return this.senha.equals(senha) && this.login.equals(login);
	}
}