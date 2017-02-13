package sistemadehotel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Hotel {
	@SuppressWarnings({ "resource", "unused" })
	public static void main(String args[]) {
		// TODO toda vez que o sistema for inicializado ira carregar as listas
		// das pessoas no hotel
		// TODO carregar login e senha do gerente de um arquivo

		List<Recepcionista> recepcionistas = new ArrayList<>();
		List<Camareira> camareiras = new ArrayList<>();
		List<Cliente> clientes = new ArrayList<>();
		Funcionario gerente = new Gerente();
		Scanner entrada = new Scanner(System.in);
		String login;
		String senha;
		Boolean autenticaGerente;
		Boolean autenticaRecepcionista = false;
		
		Recepcionista recepcionista = new Recepcionista();

		System.out.println("*** BEM VINDO AO SISTEMA ***");
		while (true) {
			System.out.println("Por favor, informe o Login: ");
			login = entrada.next();
			System.out.println("Por favor, informe a Senha: ");
			senha = entrada.next();

			autenticaGerente = ((Gerente) gerente).autentica(senha, login);
			if (autenticaGerente) {
				System.out.println("** BEM VINDO GERENTE **");
				break;
			} else {
				//for (Recepcionista recepcionista : recepcionistas)
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
		if (autenticaGerente) {
			int n = 0;
			while (n != 4) {
				System.out.println("1- CADASTRO DE FUNCIONARIOS  2 - REMO��O  3- ALTERA��O  4-SALVAR E SAIR");
				System.out.print("Op��o: ");
				n = entrada.nextInt();
				entrada.nextLine();// Ler Enter
				if (n == 1) {// CADASTRO DE FUNCIONARIOS
					while (true) {
						System.out.println("1 - Cadastro de Recepcionista  2 - Cadastro de Camareira  3 - Voltar");
						n = entrada.nextInt();
						entrada.nextLine();// Ler Enter
						if (n == 1) {// Op��o de Cadastrar Recepcionistas
							//Funcionario recepcionista = new Recepcionista();
							((Gerente) gerente).cadastrarFuncionario(recepcionistas, (Recepcionista) recepcionista);
						} else if (n == 2) { // Op��o de Cadastrar Camareiras
							Funcionario camareira = new Camareira();
							((Gerente) gerente).cadastrarFuncionario(camareiras, (Camareira) camareira);
						} else if (n == 3)
							break;
						System.out.println("*** CADASTRO REALIZADO COM SUCESSO ***");
						System.out.print("1 - Cadastrar Outro Funcion�rio  2 - N�O\n");
						n = entrada.nextInt();
						if (n == 2)
							break;
					}
				} else if (n == 2) {// REMO��O
					System.out.println("Nome funcionario: ");
					String nome = entrada.next().toUpperCase();
					System.out.println("CPF: ");
					String cpf = entrada.next().toUpperCase();
					Camareira camareira;
					//Recepcionista recepcionista;

					camareira = (Camareira) ((Gerente) gerente).verificaFuncionario(nome, cpf, camareiras);
					if (camareira == null) {
						recepcionista = (Recepcionista) ((Gerente) gerente).verificaFuncionario(nome, cpf,
								recepcionistas);
						if (recepcionista == null)
							System.out.println("Funcionario n�o encontrado");
						else
							((Gerente) gerente).removerFuncionario(recepcionistas, recepcionista);
					} else
						((Gerente) gerente).removerFuncionario(camareiras, camareira);
				} else if (n == 3) {
					// TODO altera��o de cadastro
				} else if (n == 4) {
					
					// TODO salvar e sair
				}
			}
			((Gerente) gerente).mostrarFuncionarios(camareiras);
			((Gerente) gerente).mostrarFuncionarios(recepcionistas);
		}
	}
}