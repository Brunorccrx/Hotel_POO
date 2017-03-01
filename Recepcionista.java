package sistemadehotel;
/**
 *
 * @author Bruno Rodrigues Caputo
 * @author Francisco Pires Júnior
 * @author Gabriel Rodrigues Machado
 * @author Philip Mahama Akpanyi
 */

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Recepcionista extends Funcionario implements Autentica {

	private String login = "samus";
	private String senha = "321";
	private Scanner entrada = new Scanner(System.in);
	static BufferedWriter BufWrit;
	//Tratar reserva do quarto
    private boolean reservaDisponivel;
    private String reservaTipoQuarto;
    private String clienteIdentidade;
    private String clienteContato;
    private int totalReserva = 0;
	/**
	*
	* @return
	*/
	public String getSenha() {
		return senha;
	}
	/**
	*
	* @param senha
	* @throws IOException
	*/
	public void setSenha(String senha) throws IOException {
		if (senha.length() < 7)
			throw new IOException("Senha deve ter no mínimo 7 caracteres");
		if (senha.length() > 14)
			throw new IOException("Senha ultrapassou o limite máximo de 14 caracteres");

		this.senha = senha;
	}
	/**
	*
	* @return
	*/
	public String getLogin() {
		return login;
	}
	/**
	*
	* @param login
	* @throws IOException
	*/
	public void setLogin(String login) throws IOException {
		if (login.length() < 5)
			throw new IOException("Login deve ter no mínimo 5 caracteres");
		if (login.length() > 20)
			throw new IOException("Login ultrapassou o limite máximo de 20 caracteres");

		this.login = login;
	}
	/**
	*
	* @return
	*/
	 public boolean isReservaDisponivel() {
	        return reservaDisponivel;
	    }
	/**
	*
	* @param reservaDisponivel
	*/
	    public void setReservaDisponivel(boolean reservaDisponivel) {
	        this.reservaDisponivel = reservaDisponivel;
	    }
	/**
	*
	* @return
	*/
	    public String getReservaTipoQuarto() {
	        return reservaTipoQuarto;
	    }
	/**
	*
	* @param reservaTipoQuarto
	*/
	    public void setReservaTipoQuarto(String reservaTipoQuarto) {
	        this.reservaTipoQuarto = reservaTipoQuarto;
	    }
	/**
	*
	* @return
	*/
	    public String getClienteIdentidade() {
	        return clienteIdentidade;
	    }
	/**
	*
	*/
	    public void setClienteIdentidade(String clienteIdentidade) {
	        this.clienteIdentidade = clienteIdentidade;
	    }
	/**
	*
	* @return
	*/
	    public String getClienteContato() {
	        return clienteContato;
	    }
	/**
	*
	*/
	    public void setClienteContato(String clienteContato) {
	        this.clienteContato = clienteContato;
	    }
	/**
	*
	* @return
	*/
	    public int getTotalReserva() {
	        return totalReserva;
	    }
	/**
	*
	*/
	    public void setTotalReserva(int totalReserva) {
	        this.totalReserva = totalReserva;
	    }
	  
	/**
	*
	* @param senha
	* @param login
	* @return
	*/
	public boolean autentica(String senha, String login) {
		return this.senha.equals(senha) && this.login.equals(login);
	}
	/**
	*
	* @param clientes
	* @param cliente
	*/
	protected void cadastrarCliente(List<Cliente> clientes, Cliente cliente) {
		//Scanner entrada = new Scanner(System.in);

		System.out.print("Nome: ");
		cliente.setNome(entrada.nextLine().toUpperCase());
		System.out.print("Nacionalidade: ");
		cliente.setNacionalidade(entrada.nextLine().toUpperCase());
		if (cliente.getNacionalidade().equals("BRASILEIRO")) {
			System.out.print("CPF: ");
			cliente.setCPF(entrada.nextLine());
			System.out.print("RG: ");
			cliente.setRG(entrada.nextLine());
		} else {
			System.out.print("Passaporte: ");
			cliente.setPassaporte(entrada.nextLine());
		}
		System.out.print("Data de nascimento: : ");
		cliente.setDataNasc(entrada.nextLine());
		System.out.print("Contato: ");
		cliente.setNumTelefone(entrada.nextLine());
		System.out.print("Rua: ");
		cliente.setRua(entrada.nextLine());
		System.out.print("Bairro: ");
		cliente.setBairro(entrada.nextLine());
		System.out.print("Complemento: ");
		cliente.setComplemento(entrada.nextLine());
		System.out.print("Numero da casa: ");
		cliente.setNumeroCasa(entrada.nextLine());
		System.out.print("Cidade: ");
		cliente.setCidade(entrada.nextLine());
		System.out.print("Estado: ");
		cliente.setEstado(entrada.nextLine());

		clientes.add(cliente);
	}
	/**
	*
	* @param clientes
	*/
	protected void cadastrarCliente(List<Cliente> clientes) {
		//Scanner entrada = new Scanner(System.in);
		//Recepcionista recepcionista = new Recepcionista();
		int n;

		while (true) {
			System.out.println("1 - Cadastro de Cliente  2 - Voltar");
			n = entrada.nextInt();
			entrada.nextLine();// Ler Enter
			if (n == 1) {// Opção de Cadastrar Cliente
				Cliente cliente = new Cliente();

				System.out.print("Nome: ");
				cliente.setNome(entrada.nextLine().toUpperCase());
				System.out.print("Nacionalidade: ");
				cliente.setNacionalidade(entrada.nextLine().toUpperCase());
				if (cliente.getNacionalidade().equals("BRASILEIRO")) {
					System.out.print("CPF: ");
					cliente.setCPF(entrada.nextLine());
					System.out.print("RG: ");
					cliente.setRG(entrada.nextLine());
				} else {
					System.out.print("Passaporte: ");
					cliente.setPassaporte(entrada.nextLine());
				}
				System.out.print("Data de nascimento: : ");
				cliente.setDataNasc(entrada.nextLine());
				System.out.print("Contato: ");
				cliente.setNumTelefone(entrada.nextLine());
				System.out.print("Rua: ");
				cliente.setRua(entrada.nextLine());
				System.out.print("Bairro: ");
				cliente.setBairro(entrada.nextLine());
				System.out.print("Complemento: ");
				cliente.setComplemento(entrada.nextLine());
				System.out.print("Numero da casa: ");
				cliente.setNumeroCasa(entrada.nextLine());
				System.out.print("Cidade: ");
				cliente.setCidade(entrada.nextLine());
				System.out.print("Estado: ");
				cliente.setEstado(entrada.nextLine());

				clientes.add(cliente);

			} else if (n == 2)
				break;
			System.out.println("*** CADASTRO REALIZADO COM SUCESSO ***");
			System.out.print("1 - Cadastrar Outro Cliente  2 - Não\n");
			n = entrada.nextInt();
			if (n == 2)
				break;
		}

	}
	/**
	*
	* @param nome
	* @param CPF
	* @param clientes
	* @return
	*/
	protected Cliente verificaCliente(String nome, String CPF, List<Cliente> clientes) {
		for (Cliente cliente : clientes)
			if (cliente.getNome().equals(nome) && cliente.getCPF().equals(CPF))
				return cliente;

		return null;
	}
	/**
	*
	* @param nome
	* @param ID
	* @param clientes
	* @return
	*/
	protected Cliente verificaCliente(String nome, int ID, List<Cliente> clientes) {
		for (Cliente cliente : clientes)
			if (cliente.getNome().equals(nome) && cliente.getID() == ID)
				return cliente;

		return null;
	}
	/**
	*
	* @param clientes
	*/
	protected void removerCliente(List<Cliente> clientes) {
		Cliente cliente;
		//Scanner entrada = new Scanner(System.in);
		Recepcionista recepcionista = new Recepcionista();

		System.out.println("Nome cliente: ");
		String nome = entrada.nextLine().toUpperCase();
		System.out.println("Nacionalidade: ");
		String nacionalidade = entrada.nextLine().toUpperCase();
		if (nacionalidade.equals("BRASILEIRO")) {
			System.out.println("CPF: ");
			String cpf = entrada.nextLine().toUpperCase();
			cliente = recepcionista.verificaCliente(nome, cpf, clientes);
		} else {
			System.out.println("ID: ");
			int clienteID = entrada.nextInt();
			entrada.nextLine();
			cliente = recepcionista.verificaCliente(nome, clienteID, clientes);
		}

		if (cliente == null)
			System.out.println("** CLIENTE NÃO ENCONTRADO **");
		else {
			clientes.remove(cliente);
			System.out.println("** CLIENTE REMOVIDO COM SUCESSO! **");
		}
	}
	/**
	*
	* @param clientes
	*/
	protected void alterarCliente(List<Cliente> clientes) {
		int opcao;
		Cliente cliente;
		//Scanner entrada = new Scanner(System.in);
		Recepcionista recepcionista = new Recepcionista();

		System.out.println("Nome cliente: ");
		String nome = entrada.nextLine().toUpperCase();
		System.out.println("Nacionalidade: ");
		String nacionalidade = entrada.nextLine().toUpperCase();

		if (nacionalidade.equals("BRASILEIRO")) {
			System.out.println("CPF: ");
			String cpf = entrada.nextLine().toUpperCase();
			cliente = recepcionista.verificaCliente(nome, cpf, clientes);
		} else {
			System.out.println("ID: ");
			int clienteID = entrada.nextInt();
			entrada.nextLine();
			cliente = recepcionista.verificaCliente(nome, clienteID, clientes);
		}
		if (cliente == null)
			System.out.println("** CLIENTE NÃO ENCONTRADO **");
		else {
			System.out.println("Qual dado deseja remover do cliente? " + cliente.getNome());
			System.out.println("1 - Nome  2 - CPF  3 - RG  4 - NúmeroDeTelefone  5 - DataDeNascimento" + '\n'
					+ "6 - Rua  7 - Bairro  8 - Complemento  9 - NumeroDaCasa  10 - Cidade" + '\n'
					+ "11 - Estado  12 - Nacionalidade" + '\n');

			opcao = entrada.nextInt();
			entrada.nextLine();

			if (opcao == 1)
				cliente.setNome(entrada.nextLine());
			else if (opcao == 2)
				cliente.setCPF(entrada.nextLine());
			else if (opcao == 3)
				cliente.setRG(entrada.nextLine());
			else if (opcao == 4)
				cliente.setNumTelefone(entrada.nextLine());
			else if (opcao == 5)
				cliente.setDataNasc(entrada.nextLine());
			else if (opcao == 6)
				cliente.setRua(entrada.nextLine());
			else if (opcao == 7)
				cliente.setBairro(entrada.nextLine());
			else if (opcao == 8)
				cliente.setComplemento(entrada.nextLine());
			else if (opcao == 9)
				cliente.setNumeroCasa(entrada.nextLine());
			else if (opcao == 10)
				cliente.setCidade(entrada.nextLine());
			else if (opcao == 11)
				cliente.setEstado(entrada.nextLine());
			else if (opcao == 12)
				cliente.setNacionalidade(entrada.nextLine());
		}
	}
	/**
	*
	* @param clientes
	*/
	protected void mostrarClientes(List<Cliente> clientes) {
		for (Cliente cliente : clientes)
			System.out.println(cliente);
	}
	/**
	*
	* @param list
	* @throws IOException
	*/
	public void salvarDadosCliente(List<Cliente> list) throws IOException {

        Iterator<Cliente> inter = list.iterator();

        try {
            BufWrit = new BufferedWriter(new FileWriter("Clientes.txt"));
            while (inter.hasNext()) {
                Cliente c = inter.next();
                if(c.getNacionalidade().equals("BRASILEIRO")){
                    Recepcionista.BufWrit.write(c.getNome() + "|" + c.getNacionalidade()+ "|" + c.getCPF() + "|"+ c.getRG() + "|"+
                    c.getDataNasc() + "|" + c.getNumTelefone() + "|" + c.getRua() + "|"+ c.getBairro()+ "|" + c.getComplemento()
                    + "|" + c.getNumeroCasa() + "|" + c.getCidade() + "|" + c.getEstado());
                 Recepcionista.BufWrit.newLine();
                }else{
                    Recepcionista.BufWrit.write(c.getNome() + "|" + c.getNacionalidade()+ "|" + c.getPassaporte()+ "|"+
                    c.getDataNasc() + "|" + c.getNumTelefone() + "|" + c.getRua() + "|"+ c.getBairro()+ "|" + c.getComplemento()
                    + "|" + c.getNumeroCasa() + "|" + c.getCidade() + "|" + c.getEstado());
                 Recepcionista.BufWrit.newLine();
                    
                }
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
	/* public void reservaQuarto(){
	      totalReserva++;
	      String nome = entrada.nextLine();
	      String identidade = entrada.nextLine();
	      String contato = entrada.nextLine();
	      String tipoQuarto = entrada.nextLine().toUpperCase();
	      
	  }*/
}
