package sistemadehotel;


import java.io.IOException;
import java.util.Scanner;

public class Hotel {

    public static void main(String[] agrs) throws IOException {

        Scanner input = new Scanner(System.in);
        Funcionario gerente = new Gerente();
        ((Gerente) gerente).recepcionista = new Recepcionista[2];
        ((Gerente) gerente).camareira = new Camareira[5];
        int i, n;
        //Menu
        System.out.println("*** BEM VINDO AO SISTEMA ***");
        System.out.println("1 - GERENCIA    2 - RECEPÇÃO");
        System.out.print("Opção: ");
        n = input.nextInt();
        if (n == 1) {//Opção do Gerente
            input.nextLine();//Ler Enter
            System.out.println("Login: ");
            ((Gerente) gerente).setLogin(input.nextLine());
            System.out.println("Senha: ");
            ((Gerente) gerente).setSenha(input.nextLine());
            ((Gerente) gerente).autentica(((Gerente) gerente).getSenha());
            
            System.out.println("1- CADASTRO DE FUNCIONARIOS  2 - REMOÇÃO   3- ALTERAÇÃO");
            System.out.print("Opção: ");
            n = input.nextInt();
            if (n == 1) {
                input.nextLine();//Ler Enter
                System.out.println("1 - Cadastro de Recepcionista  2 - Cadastro de Camareira");
                n = input.nextInt();
                if (n == 1) {//Opção de Cadastrar Recepcionistas
                    do {
                        input.nextLine();//Ler Enter
                        Recepcionista r = new Recepcionista();
                        System.out.print("Nome: ");
                        r.setNome(input.nextLine());
                        System.out.println("RG: ");
                        r.setRG(input.nextLine());
                        System.out.print("CPF: ");
                        r.setCPF(input.nextLine());
                        System.out.print("Data de nascimento: : ");
                        r.setDataNasc(input.nextLine());
                        System.out.print("Contato: ");
                        r.setNumTelefone(input.nextLine());
                        System.out.print("Rua: ");
                        r.setRua(input.nextLine());
                        System.out.print("Bairro: ");
                        r.setBairro(input.nextLine());
                        System.out.print("Complemento: ");
                        r.setComplemento(input.nextLine());
                        System.out.print("Numero da casa: ");
                        r.setNumeroCasa(input.nextLine());
                        System.out.print("Cidade: ");
                        r.setCidade(input.nextLine());
                        System.out.print("Estado: ");
                        r.setEstado(input.nextLine());
                        System.out.print("Salario Funcionario: ");
                        r.setSalario(input.nextDouble());
                        ((Gerente) gerente).cadastrarRecepcionista(r);
                        System.out.print("1 - Cadastrar Outro Funcionário  2 - NÃO\n");
                        i = input.nextInt();
                    } while (i == 1);
                    System.out.println("*** CADASTRO REALIZADO COM SUCESSO ***");
                    ((Gerente) gerente).mostraRecepcionista();
                } else if (n == 2) { //Opção de Cadastrar Camareiras
                    do {
                        input.nextLine();//Ler Enter
                        Camareira c = new Camareira();
                        System.out.print("Nome: ");
                        c.setNome(input.nextLine());
                        System.out.println("RG: ");
                        c.setRG(input.nextLine());
                        System.out.print("CPF: ");
                        c.setCPF(input.nextLine());
                        System.out.print("Data de nascimento: : ");
                        c.setDataNasc(input.nextLine());
                        System.out.print("Contato: ");
                        c.setNumTelefone(input.nextLine());
                        System.out.print("Rua: ");
                        c.setRua(input.nextLine());
                        System.out.print("Bairro: ");
                        c.setBairro(input.nextLine());
                        System.out.print("Complemento: ");
                        c.setComplemento(input.nextLine());
                        System.out.print("Numero da casa: ");
                        c.setNumeroCasa(input.nextLine());
                        System.out.print("Cidade: ");
                        c.setCidade(input.nextLine());
                        System.out.print("Estado: ");
                        c.setEstado(input.nextLine());
                        System.out.print("Salario Funcionario: ");
                        c.setSalario(input.nextDouble());
                        ((Gerente) gerente).cadastrarCamareira(c);
                        System.out.print("1 - Cadastrar Outro Funcionário  2 - NÃO\n");
                        i = input.nextInt();
                    } while (i == 1);
                    System.out.println("*** CADASTRO REALIZADO COM SUCESSO ***");
                    ((Gerente) gerente).mostraCamareira();
                }

            }

        }

    }

}
