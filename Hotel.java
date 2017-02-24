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
	public static void main(String args[]) {
		// TODO toda vez que o sistema for inicializado ira carregar as listas
		// das pessoas no hotel
		// TODO carregar login e senha do gerente de um arquivo

		List<Recepcionista> recepcionistas = new ArrayList<>();
		List<Camareira> camareiras = new ArrayList<>();
		List<Cliente> clientes = new ArrayList<>();
		Funcionario gerente = Gerente.getInstance();
		recepcionistas.add(new Recepcionista());
		Funcionario recepcionistaAtiva = new Recepcionista();
		Scanner entrada = new Scanner(System.in);
		String login;
		String senha;
		Boolean autenticaGerente;
		Boolean autenticaRecepcionista = false;
		Cliente clienteAux = new Cliente();

		try {
			@SuppressWarnings("resource")
			BufferedReader BufRed = new BufferedReader(new FileReader("Relatorio de Consumo.txt"));
			String str = BufRed.readLine();
			while (str != null) {
				StringTokenizer strtok = new StringTokenizer(str);
				while (strtok.hasMoreTokens()) {
					clienteAux.quarto.setNumeroQuarto(strtok.nextToken(" "));
					clienteAux.quarto.setAluguelDoQuarto(Double.parseDouble((String) strtok.nextElement()));
					clienteAux.quarto.setConsumo(Double.parseDouble((String) strtok.nextElement()));
					clienteAux.quarto.setDanosCausados(Double.parseDouble((String) strtok.nextElement()));
					clienteAux.quarto.setGastoTotal(Double.parseDouble((String) strtok.nextElement()));
					clientes.add(clienteAux);
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
		// CARREGAMENTO DE DADOS DOS FUNCIONARIOS.
		try {
			@SuppressWarnings("resource")
			BufferedReader BufRed = new BufferedReader(new FileReader("Recepcionista.txt"));
			String str = BufRed.readLine();
			while (str != null) {
				StringTokenizer strtok = new StringTokenizer(str);
				while (strtok.hasMoreTokens()) {
					recepcionistaAtiva.setNome(strtok.nextToken(" "));

					recepcionistas.add((Recepcionista) recepcionistaAtiva);
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
			System.out.println("Por favor, informe o Login: ");
			login = entrada.nextLine();
			System.out.println("Por favor, informe a Senha: ");
			senha = entrada.nextLine();

			autenticaGerente = ((Gerente) gerente).autentica(senha, login);
			if (autenticaGerente) {
				System.out.println("** BEM VINDO GERENTE **");
				break;
			} else {
				for (Recepcionista recepcionista : recepcionistas)
					if (recepcionista.autentica(senha, login)) {
						System.out.println("** BEM VINDA RECEPCIONISTA **");
						autenticaRecepcionista = true;
						break;
					}
			}
			if (autenticaRecepcionista)
				break;

			System.out.println("Login ou Senha incorretos");
		}
		if (autenticaGerente) {// Gerente
			int n = 0;
			while (n != 4) {
				System.out.println("1- CADASTRO DE FUNCIONARIOS  2 - REMOÇÃO  3- ALTERAÇÃO  4-SALVAR E SAIR"
						+ "\n5-MOSTRAR FUNCIONARIOS");
				System.out.print("Opção: ");
				n = entrada.nextInt();
				entrada.nextLine();// Ler Enter
				if (n == 1) {// CADASTRO DE FUNCIONARIOS
					while (true) {
						System.out.println("1 - Cadastro de Recepcionista  2 - Cadastro de Camareira  3 - Voltar");
						n = entrada.nextInt();
						entrada.nextLine();// Ler Enter
						if (n == 1) {// Opção de Cadastrar Recepcionistas
							Funcionario recepcionista = new Recepcionista();
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
					String nome = entrada.nextLine().toUpperCase();
					System.out.println("CPF: ");
					String cpf = entrada.nextLine().toUpperCase();
					Camareira camareira;
					Recepcionista recepcionista;

					camareira = (Camareira) ((Gerente) gerente).verificaFuncionario(nome, cpf, camareiras);
					if (camareira == null) {
						recepcionista = (Recepcionista) ((Gerente) gerente).verificaFuncionario(nome, cpf,
								recepcionistas);
						if (recepcionista == null)
							System.out.println("** FUNCIONARIO NÃO ENCONTRADO **");
						else {
							((Gerente) gerente).removerFuncionario(recepcionistas, recepcionista);
							System.out.println("** RECEPCIONISTA REMOVIDA COM SUCESSO! **");
						}
					} else {
						((Gerente) gerente).removerFuncionario(camareiras, camareira);
						System.out.println("** CAMAREIRA REMOVIDA COM SUCESSO! **");
					}
				} else if (n == 3) {// Alteração
					System.out.println("Nome funcionario: ");
					String nome = entrada.nextLine().toUpperCase();
					System.out.println("CPF: ");
					String cpf = entrada.nextLine().toUpperCase();
					Camareira camareira;
					Recepcionista recepcionista;

					camareira = (Camareira) ((Gerente) gerente).verificaFuncionario(nome, cpf, camareiras);
					if (camareira == null) {
						recepcionista = (Recepcionista) ((Gerente) gerente).verificaFuncionario(nome, cpf,
								recepcionistas);
						if (recepcionista == null)
							System.out.println("** FUNCIONARIO NÃO ENCONTRADO **");
						else {
							System.out.println("Qual dado deseja remover da recepcionista? " + recepcionista.getNome());
							((Gerente) gerente).alterarFuncionario(recepcionista);
						}
					} else {
						System.out.println("Qual dado deseja remover da camareira? " + camareira.getNome());
						((Gerente) gerente).alterarFuncionario(camareira);
					}
				} else if (n == 5) {// Mostrar Funcionarios
					((Gerente) gerente).mostrarFuncionarios(camareiras);
					((Gerente) gerente).mostrarFuncionarios(recepcionistas);
				}
			}
		} else {// Recepcionista
			int n = 0;
			while (n != 4) {
				System.out.println(
						"1- CADASTRO DE CLIENTE  2 - REMOÇÃO  3- ALTERAÇÃO  4-SALVAR E SAIR" + "\n5- Mostrar Clientes  6 - RESERVAR QUARTO");
				System.out.print("Opção: ");
				n = entrada.nextInt();
				entrada.nextLine();// Ler Enter
				if (n == 1) {// CADASTRO DE CLIENTE
					while (true) {
						System.out.println("1 - Cadastro de Cliente  2 - Voltar");
						n = entrada.nextInt();
						entrada.nextLine();// Ler Enter
						if (n == 1) {// Opção de Cadastrar Cliente
							Pessoa cliente = new Cliente();
							((Recepcionista) recepcionistaAtiva).cadastrarCliente(clientes, (Cliente) cliente);
						} else if (n == 2)
							break;
						System.out.println("*** CADASTRO REALIZADO COM SUCESSO ***");
						System.out.print("1 - Cadastrar Outro Cliente  2 - NÃO\n");
						n = entrada.nextInt();
						if (n == 2)
							break;
					}
				} else if (n == 2) {// REMOÇÃO
					System.out.println("Nome cliente: ");
					String nome = entrada.nextLine().toUpperCase();
					System.out.println("CPF: ");
					String cpf = entrada.nextLine().toUpperCase();
					Cliente cliente;

					cliente = ((Recepcionista) recepcionistaAtiva).verificaCliente(nome, cpf, clientes);
					if (cliente == null)
						System.out.println("** CLIENTE NÃO ENCONTRADO **");
					else {
						((Recepcionista) recepcionistaAtiva).removerCliente(clientes, cliente);
						System.out.println("** CLIENTE REMOVIDO COM SUCESSO! **");
					}
				} else if (n == 3) {// Alteração
					System.out.println("Nome cliente: ");
					String nome = entrada.nextLine().toUpperCase();
					System.out.println("CPF: ");
					String cpf = entrada.nextLine().toUpperCase();
					Cliente cliente;

					cliente = ((Recepcionista) recepcionistaAtiva).verificaCliente(nome, cpf, clientes);
					if (cliente == null)
						System.out.println("** CLIENTE NÃO ENCONTRADO **");
					else {
						System.out.println("Qual dado deseja remover do cliente? " + cliente.getNome());
						((Recepcionista) recepcionistaAtiva).alterarCliente(cliente);
					}
				} else if (n == 5) {
					((Recepcionista) recepcionistaAtiva).mostrarClientes(clientes);
				}
				else if(n == 6){//Reservar Quarto
            				((Recepcionista) recepcionistaAtiva).reservaQuarto();
        			}
			}
		}
		Quarto aux = new Quarto();
		try {
			aux.salvarConsumo(clientes);
		} catch (IOException e) {
			System.out.println("\nIOException\n");
			e.printStackTrace();
		}

		try {
			((Gerente) gerente).salvarDadosRecepcionista(recepcionistas);
		} catch (IOException e) {
			System.out.println("!!! ERRO !!! Ao Salvar Recepcionista !!!");
			e.printStackTrace();
		}

		System.out.println("Tudo Salvo e OK");
	}
}
