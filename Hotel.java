
import java.util.ArrayList;
import java.util.Iterator;
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
          if (recepcionista.autentica(login, senha)) {
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
      int n=0;
      while (n != 4) {
        System.out.println("1- CADASTRO DE FUNCIONARIOS  2 - REMOÇÃO  3- ALTERAÇÃO  4-SALVAR E SAIR");
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
              System.out.println("Funcionario não encontrado");
            else
              ((Gerente) gerente).removerFuncionario(recepcionistas, recepcionista);
          }
          else
            ((Gerente) gerente).removerFuncionario(camareiras,camareira);
        }
      }
			((Gerente) gerente).mostrarFuncionarios(camareiras);
			((Gerente) gerente).mostrarFuncionarios(recepcionistas);
    }
  }
}
