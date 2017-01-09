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
        System.out.println("*** BEM VINDO AO SISTEMA ***");
        System.out.println("1 - GERENCIA    2 - RECEPÇÃO");
        System.out.print("Opção: ");
        n = input.nextInt();
        if (n == 1) {
             System.out.println("Login: ");
             ((Gerente) gerente).setLogin(new Scanner(System.in).nextLine());
             System.out.println("Senha: ");
             ((Gerente) gerente).setSenha(new Scanner(System.in).nextLine());
             ((Gerente) gerente).autentica(((Gerente) gerente).getSenha());
            System.out.println("1- CADASTRO DE FUNCIONARIOS  2 - REMOÇÃO   3- ALTERAÇÃO");
            System.out.print("Opção: ");
            n = input.nextInt();
            if (n == 1) {
                System.out.println("1 - Cadastro de Recepcionista  2 - Cadastro de Camareira");
                n = input.nextInt();
                if (n == 1) {
                    do {
                        Recepcionista r = new Recepcionista();
                        System.out.print("Nome: ");
                        r.setNome(new Scanner(System.in).nextLine());
                        System.out.println("RG: ");
                        r.setRG(new Scanner(System.in).nextLine());
                        System.out.print("CPF: ");
                        r.setCPF(new Scanner(System.in).nextLine());
                        System.out.print("Data de nascimento: : ");
                        r.setDataNasc(new Scanner(System.in).nextLine());
                        System.out.print("Contato: ");
                        r.setNumTelefone(new Scanner(System.in).nextLine());
                        System.out.print("Rua: ");
                        r.setRua(new Scanner(System.in).nextLine());
                        System.out.print("Bairro: ");
                        r.setBairro(new Scanner(System.in).nextLine());
                        System.out.print("Complemento: ");
                        r.setComplemento(new Scanner(System.in).nextLine());
                        System.out.print("Numero da casa: ");
                        r.setNumeroCasa(new Scanner(System.in).nextLine());
                        System.out.print("Cidade: ");
                        r.setCidade(new Scanner(System.in).nextLine());
                        System.out.print("Estado: ");
                        r.setEstado(new Scanner(System.in).nextLine());
                        System.out.print("Salario Funcionario: ");
                        r.setSalario(input.nextDouble());
                        ((Gerente) gerente).cadastrarRecepcionista(r);
                        System.out.print("1 - Cadastrar Outro Recepcionista  2 - NÃO");
                        i = input.nextInt();
                    }while (i == 0);
                    System.out.println("*** CADASTRO REALIZADO COM SUCESSO ***");
                    ((Gerente) gerente).mostraRecepcionista();
                } else if (n == 2) {
                    do {
                        Camareira c = new Camareira();
                        System.out.print("Nome: ");
                        c.setNome(new Scanner(System.in).nextLine());
                        System.out.println("RG: ");
                        c.setRG(new Scanner(System.in).nextLine());
                        System.out.print("CPF: ");
                        c.setCPF(new Scanner(System.in).nextLine());
                        System.out.print("Data de nascimento: : ");
                        c.setDataNasc(new Scanner(System.in).nextLine());
                        System.out.print("Contato: ");
                        c.setNumTelefone(new Scanner(System.in).nextLine());
                        System.out.print("Rua: ");
                        c.setRua(new Scanner(System.in).nextLine());
                        System.out.print("Bairro: ");
                        c.setBairro(new Scanner(System.in).nextLine());
                        System.out.print("Complemento: ");
                        c.setComplemento(new Scanner(System.in).nextLine());
                        System.out.print("Numero da casa: ");
                        c.setNumeroCasa(new Scanner(System.in).nextLine());
                        System.out.print("Cidade: ");
                        c.setCidade(new Scanner(System.in).nextLine());
                        System.out.print("Estado: ");
                        c.setEstado(new Scanner(System.in).nextLine());
                        System.out.print("Salario Funcionario: ");
                        c.setSalario(input.nextDouble());
                        ((Gerente) gerente).cadastrarCamareira(c);
                        System.out.print("1 - Cadastrar Outro Funcionário  2 - NÃO");
                        i = input.nextInt();
                    }while (i == 0);
                    System.out.println("*** CADASTRO REALIZADO COM SUCESSO ***");
                    ((Gerente) gerente).mostraCamareira();
                }

            }

        }

    }

}
