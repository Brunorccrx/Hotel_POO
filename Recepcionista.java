package sistemadehotel;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Recepcionista extends Funcionario implements Autentica {

  private String login="samus";
  private String senha="321";
  
  Scanner entrada = new Scanner(System.in);
  //Tratar reserva do quarto
    private boolean reservaDisponivel;
    private String reservaTipoQuarto;
    private String clienteIdentidade;
    private String clienteContato;
    private int totalReserva = 0;
       

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
    public boolean isReservaDisponivel() {
        return reservaDisponivel;
    }

    public void setReservaDisponivel(boolean reservaDisponivel) {
        this.reservaDisponivel = reservaDisponivel;
    }

    public String getReservaTipoQuarto() {
        return reservaTipoQuarto;
    }

    public void setReservaTipoQuarto(String reservaTipoQuarto) {
        this.reservaTipoQuarto = reservaTipoQuarto;
    }

    public String getClienteIdentidade() {
        return clienteIdentidade;
    }

    public void setClienteIdentidade(String clienteIdentidade) {
        this.clienteIdentidade = clienteIdentidade;
    }

    public String getClienteContato() {
        return clienteContato;
    }

    public void setClienteContato(String clienteContato) {
        this.clienteContato = clienteContato;
    }

    public int getTotalReserva() {
        return totalReserva;
    }

    public void setTotalReserva(int totalReserva) {
        this.totalReserva = totalReserva;
    }
  

  @Override
  public boolean autentica(String senha, String login){
    return this.senha.equals(senha) && this.login.equals(login);
  }
  protected void cadastrarCliente(List<Cliente> clientes, Cliente cliente){
   
    System.out.print("Nome: ");
    cliente.setNome(entrada.nextLine());
    System.out.print("Nacionalidade: ");
    cliente.setNacionalidade(entrada.nextLine());
    if(cliente.getNacionalidade().equals("BRASILEIRO")) {
      System.out.print("CPF: ");
      cliente.setCPF(entrada.nextLine());
      System.out.print("RG: ");
      cliente.setRG(entrada.nextLine());
    }
    else {
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
  protected Cliente  verificaCliente(String nome, String CPF, List<Cliente> clientes ){
    for (Cliente cliente:clientes)
      if(cliente.getNome().equals(nome) && cliente.getCPF().equals(CPF))
        return cliente;

    return null;
  }

  protected boolean removerCliente(List<Cliente>clientes,Cliente cliente){
    return clientes.remove(cliente);
  }

  protected void alterarCliente(Cliente cliente){
    int opcao;

    System.out.println("1 - Nome  2 - CPF  3 - RG  4 - NúmeroDeTelefone  5 - DataDeNascimento" + '\n' +
            "6 - Rua  7 - Bairro  8 - Complemento  9 - NumeroDaCasa  10 - Cidade" + '\n' +
            "11 - Estado  12 - Nacionalidade" + '\n');

    opcao = entrada.nextInt();
    entrada.nextLine();

    if(opcao==1)
      cliente.setNome(entrada.nextLine());
    else if (opcao==2)
      cliente.setCPF(entrada.nextLine());
    else if(opcao==3)
      cliente.setRG(entrada.nextLine());
    else if(opcao==4)
      cliente.setNumTelefone(entrada.nextLine());
    else if(opcao==5)
      cliente.setDataNasc(entrada.nextLine());
    else if(opcao==6)
      cliente.setRua(entrada.nextLine());
    else if(opcao==7)
      cliente.setBairro(entrada.nextLine());
    else if(opcao==8)
      cliente.setComplemento(entrada.nextLine());
    else if(opcao==9)
      cliente.setNumeroCasa(entrada.nextLine());
    else if(opcao==10)
      cliente.setCidade(entrada.nextLine());
    else if(opcao==11)
      cliente.setEstado(entrada.nextLine());
    else if(opcao==12)
      cliente.setNacionalidade(entrada.nextLine());
  }
  protected void mostrarClientes(List<Cliente>clientes){
    for (Cliente cliente:clientes)
      System.out.println(cliente);
  }
  public void reservaQuarto(){
      totalReserva++;
  }
}
