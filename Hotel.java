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
	/**
	*
	* @param args
	*/
	public static void main(String args[]) {
		/*
		*Todas as listas que serão utilizadas são declaradas na classe principal Hotel
		**/
		List<Recepcionista> recepcionistas = new ArrayList<>();
		List<Camareira> camareiras = new ArrayList<>();
		List<Cliente> clientes = new ArrayList<>();
		Funcionario gerente = Gerente.getInstance();
		recepcionistas.add(new Recepcionista());
		Funcionario recepcionista = new Recepcionista();
		Camareira Objcamareira = new Camareira();
		Scanner entrada = new Scanner(System.in);
		String login;
		String senha;
		Boolean autenticaGerente;
		Boolean autenticaRecepcionista = false;
		Cliente clienteAux = new Cliente();

		/**
		*Leitura e carregamento de dados em arquivos para os quartos
		*/
		BufferedReader BufRed ;
		try {
			BufRed = new BufferedReader(new FileReader("Relatorio de Consumo.txt"));
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
			/** e.printStackTrace();*/
		} catch (IOException e) {
			/** TODO Auto-generated catch block*/
			e.printStackTrace();
		} finally {
			
		}
		/**
		 * ******** CARREGAMENTO DE DADOS DOS FUNCIONARIOS.******
		 */
		/**
		 * DADOS RECEPCIONISTA *
		 */
		try {
			BufRed = new BufferedReader(new FileReader("recepcionista.txt"));
			String str = BufRed.readLine();
			while (str != null) {
				StringTokenizer strtok = new StringTokenizer(str, "|");
				while (strtok.hasMoreTokens()) {
					recepcionista.setNome(strtok.nextToken());
					recepcionista.setRG(strtok.nextToken());
					recepcionista.setCPF(strtok.nextToken());
					recepcionista.setNumTelefone(strtok.nextToken());
					recepcionista.setDataNasc(strtok.nextToken());
					recepcionista.setRua(strtok.nextToken());
					recepcionista.setBairro(strtok.nextToken());
					recepcionista.setComplemento(strtok.nextToken());
					recepcionista.setNumeroCasa(strtok.nextToken());
					recepcionista.setCidade(strtok.nextToken());
					recepcionista.setEstado(strtok.nextToken());
					recepcionista.setSalario(Double.parseDouble((String) strtok.nextElement()));

					recepcionistas.add((Recepcionista) recepcionista);
					str = BufRed.readLine();
				}
			}
		} catch (FileNotFoundException e) {
			System.out.printf("\n\t!!! Arquivo não encontrado !!!\n\n");
			/** e.printStackTrace();*/
		} catch (IOException e) {
			/** TODO Auto-generated catch block*/
			e.printStackTrace();
		} finally {

		}
		/* CARREGAMENTO DOS DADOS DAS CAMAREIRAS */
		try {
			BufRed = new BufferedReader(new FileReader("Camareiras.txt"));
			String str = BufRed.readLine();
			while (str != null) {
				StringTokenizer strtok = new StringTokenizer(str, "|");
				while (strtok.hasMoreTokens()) {
					Objcamareira.setNome(strtok.nextToken());
					Objcamareira.setRG(strtok.nextToken());
					Objcamareira.setCPF(strtok.nextToken());
					Objcamareira.setNumTelefone(strtok.nextToken());
					Objcamareira.setDataNasc(strtok.nextToken());
					Objcamareira.setRua(strtok.nextToken());
					Objcamareira.setBairro(strtok.nextToken());
					Objcamareira.setComplemento(strtok.nextToken());
					Objcamareira.setNumeroCasa(strtok.nextToken());
					Objcamareira.setCidade(strtok.nextToken());
					Objcamareira.setEstado(strtok.nextToken());
					Objcamareira.setSalario(Double.parseDouble((String) strtok.nextElement()));

					camareiras.add(Objcamareira);
					str = BufRed.readLine();
				}
			}
		} catch (FileNotFoundException e) {
			System.out.printf("\n\t!!! Arquivo não encontrado !!!\n\n");
			/** e.printStackTrace();*/
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

		}
		/** CARREGAMENTO DOS DADOS DOS CLIENTES **/
		try {
			BufRed = new BufferedReader(new FileReader("Clientes.txt"));
			String str = BufRed.readLine();
			while (str != null) {
				StringTokenizer strtok = new StringTokenizer(str, "|");
				while (strtok.hasMoreTokens()) {
					clienteAux.setNome(strtok.nextToken());
					clienteAux.setNacionalidade(strtok.nextToken());
					if (clienteAux.getNacionalidade().equals("BRASILEIRO")) {
						clienteAux.setCPF(strtok.nextToken());
						clienteAux.setRG(strtok.nextToken());
					} else {
						clienteAux.setPassaporte(strtok.nextToken());
					}
					clienteAux.setDataNasc(strtok.nextToken());
					clienteAux.setNumTelefone(strtok.nextToken());
					clienteAux.setRua(strtok.nextToken());
					clienteAux.setBairro(strtok.nextToken());
					clienteAux.setComplemento(strtok.nextToken());
					clienteAux.setNumeroCasa(strtok.nextToken());
					clienteAux.setCidade(strtok.nextToken());
					clienteAux.setEstado(strtok.nextToken());
					clientes.add(clienteAux);
					str = BufRed.readLine();
				}
			}
		} catch (FileNotFoundException e) {
			System.out.printf("\n\t!!! Arquivo não encontrado !!!\n\n");
			/** e.printStackTrace();*/
		} catch (IOException e) {
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
				for (Recepcionista recepcionista1 : recepcionistas)
					if (recepcionista1.autentica(senha, login)) {
						System.out.println("** BEM VINDA RECEPCIONISTA **");
						autenticaRecepcionista = true;
						break;
					}
			}
			if (autenticaRecepcionista)
				break;

			System.out.println("Login ou Senha incorretos");
		}
		recepcionistas.remove(0);/** remover a recepcionista auxiliar*/ 

		if (autenticaGerente) {/** Gerente*/ 
			int n = 0;
			while (n != 4) {
				System.out.println("1- Cadastro de funcionarios  2 - Remoção  3- Alteração  4-Salvar e sair"
						+ "\n5-Mostrar funcionarios");
				System.out.print("Opção: ");
				n = entrada.nextInt();
				entrada.nextLine();/**Ler Enter */ 
				if (n == 1) {/** CADASTRO DE FUNCIONARIOS */
					while (true) {
						System.out.println("1 - Cadastro de Recepcionista  2 - Cadastro de Camareira  3 - Voltar");
						n = entrada.nextInt();
						entrada.nextLine();/** Ler Enter */
						if (n == 1) {/** Opção de Cadastrar Recepcionistas*/
							Funcionario recepcionista1 = new Recepcionista();
							((Gerente) gerente).cadastrarFuncionario(recepcionistas, (Recepcionista) recepcionista1);
						} else if (n == 2) { /** Opção de Cadastrar Camareiras*/
							Funcionario camareira = new Camareira();
							((Gerente) gerente).cadastrarFuncionario(camareiras, (Camareira) camareira);
						} else if (n == 3)/**Voltar*/
							break;
						System.out.println("*** CADASTRO REALIZADO COM SUCESSO ***");
						System.out.print("1 - Cadastrar Outro Funcionário  2 - NÃO\n");
						n = entrada.nextInt();
						if (n == 2)
							break;
					}
				} else if (n == 2) {/** REMOÇÃO*/
					((Gerente) gerente).removerFuncionario(camareiras, recepcionistas);
				} else if (n == 3) {/** Alteração*/
					((Gerente) gerente).alterarFuncionario(camareiras, recepcionistas);
				} else if (n == 5) {/** Mostrar Funcionarios*/
					((Gerente) gerente).mostrarFuncionarios(camareiras);
					((Gerente) gerente).mostrarFuncionarios(recepcionistas);
				}
			}
		} else {/** Recepcionista*/
			int n = 0;
			while (n != 4) {
				System.out.println("1- Cadastro de cliente  2- Remoção  3- Alteração  4-Salvar e sair"
						+ "\n5- Mostrar Clientes  6- Alugar quarto");
				System.out.print("Opção: ");
				n = entrada.nextInt();
				entrada.nextLine();/** Ler Enter*/
				if (n == 1) /** CADASTRO DE CLIENTE*/
					((Recepcionista) recepcionista).cadastrarCliente(clientes);
				else if (n == 2) /** REMOÇÃO*/
					((Recepcionista) recepcionista).removerCliente(clientes);
				else if (n == 3)/** Alteração*/
					((Recepcionista) recepcionista).alterarCliente(clientes);
				else if (n == 5)/** Mostrar Clientes*/
					((Recepcionista) recepcionista).mostrarClientes(clientes);
				else if (n == 6) {/** Alugar Quarto*/
				}
			}
		}

		/** SALVAR DADOS DO ARRAY EM ARQUIVO **/

		/** DADOS DE CONSUMO **/
		Quarto aux = new Quarto();
		try {
			aux.salvarConsumo(clientes);
		} catch (IOException e) {
			System.out.println("\nIOException\n");
			e.printStackTrace();
		}

		/** DADOS DE CADASTRO ( RECEPCIONISTAS ) **/
		Gerente gaux = Gerente.getInstance();
		try {
			gaux.salvarDadosRecepcionista(recepcionistas);
		} catch (IOException e) {
			System.out.println("\nIOException\n");
			e.printStackTrace();
		}
		/** DADOS DE CADASTRO ( CAMAREIRAS ) **/
		try {
			gaux.salvarDadosCamareira(camareiras);
		} catch (IOException e) {
			System.out.println("\nIOException\n");
			e.printStackTrace();
		}

		/** DADOS DE CADASTRO ( CLIENTES ) **/
		Recepcionista raux = new Recepcionista();
		try {
			raux.salvarDadosCliente(clientes);
		} catch (IOException e) {
			System.out.println("\nIOException\n");
			e.printStackTrace();
		}
		System.out.println("Todos os dados foram salvos com sucesso!");
	}
}
