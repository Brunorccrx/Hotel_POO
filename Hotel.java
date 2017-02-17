

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Hotel {
  public static void main(String args[]) {
    //TODO toda vez que o sistema for inicializado ira carregar as listas das pessoas no hotel
    //TODO carregar login e senha do gerente de um arquivo

    List<Recepcionista> recepcionistas = new ArrayList<>();
    List<Camareira> camareiras = new ArrayList<>();
    List<Cliente> clientes = new ArrayList<>();
    Funcionario gerente = new Gerente();
    recepcionistas.add(new Recepcionista());
    Funcionario recepcionistaAtiva = new Recepcionista();
    Scanner entrada = new Scanner(System.in);
    String login;
    String senha;
    Boolean autenticaGerente;
    Boolean autenticaRecepcionista = false;

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
    if (autenticaGerente) {//Gerente
      int n=0;
      while (n != 4) {
        System.out.println("1- CADASTRO DE FUNCIONARIOS  2 - REMOÇÃO  3- ALTERAÇÃO  4-SALVAR E SAIR" +
                "\n5-MOSTRAR FUNCIONARIOS");
        System.out.print("Opção: ");
        n = entrada.nextInt();
        entrada.nextLine();//Ler Enter
        if (n == 1) {//CADASTRO DE FUNCIONARIOS
          while (true) {
            System.out.println("1 - Cadastro de Recepcionista  2 - Cadastro de Camareira  3 - Voltar");
            n = entrada.nextInt();
            entrada.nextLine();//Ler Enter
            if (n == 1) {//Opção de Cadastrar Recepcionistas
              Funcionario recepcionista = new Recepcionista();
              ((Gerente) gerente).cadastrarFuncionario(recepcionistas, (Recepcionista) recepcionista);
            } else if (n == 2) { //Opção de Cadastrar Camareiras
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
        }
        else if (n == 2) {//REMOÇÃO
          System.out.println("Nome funcionario: ");
          String nome = entrada.nextLine().toUpperCase();
          System.out.println("CPF: ");
          String cpf = entrada.nextLine().toUpperCase();
          Camareira camareira;
          Recepcionista recepcionista;

          camareira = (Camareira) ((Gerente) gerente).verificaFuncionario(nome,cpf,camareiras);
          if(camareira==null) {
            recepcionista = (Recepcionista) ((Gerente) gerente).verificaFuncionario(nome, cpf, recepcionistas);
            if (recepcionista == null)
              System.out.println("** FUNCIONARIO NÃO ENCONTRADO **");
            else {
              ((Gerente) gerente).removerFuncionario(recepcionistas, recepcionista);
              System.out.println("** RECEPCIONISTA REMOVIDA COM SUCESSO! **");
            }
          }
          else {
            ((Gerente) gerente).removerFuncionario(camareiras, camareira);
            System.out.println("** CAMAREIRA REMOVIDA COM SUCESSO! **");
          }
        }
        else if(n == 3){//Alteração
          System.out.println("Nome funcionario: ");
          String nome = entrada.nextLine().toUpperCase();
          System.out.println("CPF: ");
          String cpf = entrada.nextLine().toUpperCase();
          Camareira camareira;
          Recepcionista recepcionista;

          camareira = (Camareira) ((Gerente) gerente).verificaFuncionario(nome,cpf,camareiras);
          if(camareira==null) {
            recepcionista = (Recepcionista) ((Gerente) gerente).verificaFuncionario(nome, cpf, recepcionistas);
            if (recepcionista == null)
              System.out.println("** FUNCIONARIO NÃO ENCONTRADO **");
            else {
              System.out.println("Qual dado deseja remover da recepcionista? " + recepcionista.getNome());
              ((Gerente) gerente).alterarFuncionario(recepcionista);

            }
          }
          else {
            System.out.println("Qual dado deseja remover da camareira? " + camareira.getNome());
            ((Gerente) gerente).alterarFuncionario(camareira);
          }
        }
        else if(n==5){//Mostrar Funcionarios
			    ((Gerente) gerente).mostrarFuncionarios(camareiras);
			    ((Gerente) gerente).mostrarFuncionarios(recepcionistas);
        }
      }
    }
    else{//Recepcionista
      int n=0;
      while (n != 4) {
        System.out.println("1- CADASTRO DE CLIENTE  2 - REMOÇÃO  3- ALTERAÇÃO  4-SALVAR E SAIR" +
                "\n5- Mostrar Clientes");
        System.out.print("Opção: ");
        n = entrada.nextInt();
        entrada.nextLine();//Ler Enter
        if (n == 1) {//CADASTRO DE CLIENTE
          while (true) {
            System.out.println("1 - Cadastro de Cliente  2 - Voltar");
            n = entrada.nextInt();
            entrada.nextLine();//Ler Enter
            if (n == 1) {//Opção de Cadastrar Cliente
              Pessoa cliente = new Cliente();
              ((Recepcionista) recepcionistaAtiva).cadastrarCliente(clientes, (Cliente) cliente);
            }
            else if (n == 2)
              break;
            System.out.println("*** CADASTRO REALIZADO COM SUCESSO ***");
            System.out.print("1 - Cadastrar Outro Cliente  2 - NÃO\n");
            n = entrada.nextInt();
            if (n == 2)
              break;
          }
        }
        else if (n == 2) {//REMOÇÃO
          System.out.println("Nome cliente: ");
          String nome = entrada.nextLine().toUpperCase();
          System.out.println("CPF: ");
          String cpf = entrada.nextLine().toUpperCase();
          Cliente cliente;

          cliente = ((Recepcionista) recepcionistaAtiva).verificaCliente(nome,cpf,clientes);
          if(cliente==null)
            System.out.println("** CLIENTE NÃO ENCONTRADO **");
            else {
              ((Recepcionista) recepcionistaAtiva).removerCliente(clientes, cliente);
              System.out.println("** CLIENTE REMOVIDO COM SUCESSO! **");
            }
        }
        else if(n == 3){//Alteração
          System.out.println("Nome cliente: ");
          String nome = entrada.nextLine().toUpperCase();
          System.out.println("CPF: ");
          String cpf = entrada.nextLine().toUpperCase();
          Cliente cliente;

          cliente = ((Recepcionista) recepcionistaAtiva).verificaCliente(nome,cpf,clientes);
          if(cliente==null)
            System.out.println("** CLIENTE NÃO ENCONTRADO **");
            else {
              System.out.println("Qual dado deseja remover do cliente? " + cliente.getNome());
              ((Recepcionista) recepcionistaAtiva).alterarCliente(cliente);
            }
        }
        else if(n == 5){
          ((Recepcionista) recepcionistaAtiva).mostrarClientes(clientes);        }
      }
    }
  }
}
