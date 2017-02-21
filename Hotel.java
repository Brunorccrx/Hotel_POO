package sistemadehotel;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Hotel {
	@SuppressWarnings({ "resource" })
	public static void main(String args[]) {
		// TODO toda vez que o sistema for inicializado ira carregar as listas
		// das pessoas no hotel
		// TODO carregar login e senha do gerente de um arquivo

		List<Recepcionista> recepcionistas = new ArrayList<>();
		List<Camareira> camareiras = new ArrayList<>();
		List<Cliente> clientes = new ArrayList<>();
		Funcionario gerente = Gerente.getInstance();
		Recepcionista recepcionista = new Recepcionista();
		Scanner entrada = new Scanner(System.in);
		String login;
		String senha;
		Boolean autenticaGerente;
		Boolean autenticaRecepcionista = false;

		Cliente cli = new Cliente();

		try {
			BufferedReader BufRed = new BufferedReader(new FileReader("Relatorio de Consumo.txt"));
			String str = BufRed.readLine();
			while (str != null) {
				StringTokenizer strtok = new StringTokenizer(str);
				while (strtok.hasMoreTokens()) {
					cli.quarto.setNumeroQuarto(strtok.nextToken(" "));
					cli.quarto.setAluguelDoQuarto(Double.parseDouble((String) strtok.nextElement()));
					cli.quarto.setConsumo(Double.parseDouble((String) strtok.nextElement()));
					cli.quarto.setDanosCausados(Double.parseDouble((String) strtok.nextElement()));
					cli.quarto.setGastoTotal(Double.parseDouble((String) strtok.nextElement()));
					clientes.add(cli);
					str = BufRed.readLine();
				}
			}
		} catch (FileNotFoundException e) {
			System.out.printf("\n\t!!! Arquivo não encontrado !!!\n\n");
			// e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

		}

		System.out.println("*** BEM VINDO AO SISTEMA ***");
		while (true) {
			System.out.print("Login: ");
			login = entrada.next();
			System.out.print("Senha: ");
			senha = entrada.next();

			autenticaGerente = ((Gerente) gerente).autentica(senha, login);
			if (autenticaGerente) {
				System.out.println("** GERENCIA **");
				break;
			} else if (recepcionista.autentica(senha, login)) {
				System.out.println("** RECEPÇÃO **");
				autenticaRecepcionista = true;
				break;
			}

			System.out.println("Login ou Senha incorretos");
		}
		if (autenticaGerente) {
			int n = 0;
			while (n != 4) {
				System.out.println("1- CADASTRO DE FUNCIONARIOS  2 - REMOÇÃO  3- ALTERAÇÃO  4-SALVAR E SAIR");
				System.out.print("Opção: ");
				n = entrada.nextInt();
				entrada.nextLine();// Ler Enter
				if (n == 1) {// CADASTRO DE FUNCIONARIOS
					while (true) {
						System.out.println("1 - Cadastro de Recepcionista  2 - Cadastro de Camareira  3 - Voltar");
						n = entrada.nextInt();
						entrada.nextLine();// Ler Enter
						if (n == 1) {// Opção de Cadastrar Recepcionistas
							// Funcionario recepcionista = new Recepcionista();
							((Gerente) gerente).cadastrarFuncionario(recepcionistas, (Recepcionista) recepcionista);
						} else if (n == 2) { // Opção de Cadastrar Camareiras
							Funcionario camareira = new Camareira();
							((Gerente) gerente).cadastrarFuncionario(camareiras, (Camareira) camareira);
						} else if (n == 3)
							break;
						System.out.println("*** CADASTRO REALIZADO COM SUCESSO ***");
						System.out.print("1 - Cadastrar Outro Funcionário  2 - NÃO\n");
						n = entrada.nextInt();
						if (n == 2)
							break;
					}
				} else if (n == 2) {// REMOÇÃO
					System.out.println("Nome funcionario: ");
					String nome = entrada.next().toUpperCase();
					System.out.println("CPF: ");
					String cpf = entrada.next().toUpperCase();
					Camareira camareira;
					// Recepcionista recepcionista;

					camareira = (Camareira) ((Gerente) gerente).verificaFuncionario(nome, cpf, camareiras);
					if (camareira == null) {
						recepcionista = (Recepcionista) ((Gerente) gerente).verificaFuncionario(nome, cpf,
								recepcionistas);
						if (recepcionista == null)
							System.out.println("Funcionario não encontrado");
						else
							((Gerente) gerente).removerFuncionario(recepcionistas, recepcionista);
					} else
						((Gerente) gerente).removerFuncionario(camareiras, camareira);
				} else if (n == 3) {
					// TODO alteração de cadastro
				}
			}
			((Gerente) gerente).mostrarFuncionarios(camareiras);
			((Gerente) gerente).mostrarFuncionarios(recepcionistas);
		} else if (autenticaRecepcionista) {
			int n = 0;
			// TODO Fazer a parte que cabe ao Recepcionista
			do {
				System.out.println("1 - Cadastro de Clientes  2 - Alteração  3 - Remoção  4 - Sauvar e Sair");
				System.out.print("Opção: ");
				n = entrada.nextInt();
				if (n == 1) {
					// TODO Cadastro de Clientes
					recepcionista.cadastrarCliente(clientes);
				} else if (n == 2) {
					// TODO Alteração de Clientes
				} else if (n == 3) {
					// TODO Remoção de clientes
				}
			} while (n != 4);
		}
		// TODO salvar tudo e sair
		Quarto aux = new Quarto();
		try {
			aux.salvarConsumo(clientes);
		} catch (IOException e) {
			System.out.println("\nIOException\n");
			e.printStackTrace();
		}
		System.out.println("Tudo Salvo e OK");
	}
}
