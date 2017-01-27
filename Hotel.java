
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Hotel {
	File arquivo;
	List<Funcionario> f = new ArrayList<>();

    public void SalvarFuncionario(Funcionario f){
        arquivo = new File("Banco de Dados/"+f.getNome()+f.getCPF()+".txt");
        try{
            arquivo.createNewFile();

            FileWriter fw = new FileWriter(arquivo);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write("Nome: "+f.getNome());
            bw.newLine();
            bw.write("RG: "+ f.getRG());
            bw.newLine();
            bw.write("CPF: "+ f.getCPF());
            bw.newLine();
            bw.write("Data de nascimento: "+ f.getDataNasc());
            bw.newLine();
            bw.write("Contato: "+ f.getNumTelefone());
            bw.newLine();
            bw.write("RUA: "+ f.getRua());
            bw.newLine();
            bw.write("Bairro: "+ f.getBairro());
            bw.newLine();
            bw.write("Complemento: "+ f.getComplemento());
            bw.newLine();
            bw.write("Numero casa: "+ f.getNumeroCasa());
            bw.newLine();
            bw.write("Cidade: "+ f.getCidade());
            bw.newLine();
            bw.write("Estado: "+ f.getEstado());
            bw.newLine();
            bw.write("Salario: "+ f.getSalario());
            bw.newLine();

            bw.close();
            fw.close();

        }catch(IOException ex){

        }

		public boolean verificaFuncionario(Funcionario f){
			arquivo = new File("Banco de Dados/"+f.getNome()+f.getCPF()+".txt");
		        if(arquivo.exists()){
		            System.out.println("Funcionario encontrado!");
		            return true;
		        }else{
		            System.out.println("Funcionario nao encontrado!");
		            return false;
		        }

		    }
		    public void removerFuncionario(Funcionario f){
		        arquivo = new File("Banco de Dados/"+f.getNome()+f.getCPF()+".txt");
		        arquivo.delete();
		    }
    }

    public static void main(String[] agrs) throws IOException {




        Scanner input = new Scanner(System.in);
        Funcionario gerente = new Gerente();
        //Recepcionista r = new Recepcionista();
        //Camareira c = new Camareira();
        List<Funcionario> f = new ArrayList<>();
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
            if (n == 1){
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
                        /*System.out.print("CPF: ");
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
                        r.setEstado(input.nextLine());*/
                        System.out.print("Salario Funcionario: ");
                        r.setSalario(input.nextDouble());
                        //((Gerente) gerente).cadastrarRecepcionista(r);
                        //((Gerente) gerente).cadastrarFuncionario(r,r.getNome(),r.getCPF());
                        System.out.print("1 - Cadastrar Outro Funcionário  2 - NÃO\n");
                        i = input.nextInt();
                    } while (i == 1);
                    System.out.println("*** CADASTRO REALIZADO COM SUCESSO ***");
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
                        ((Gerente) gerente).cadastrarFuncionario(c,c.getNome(),c.getCPF());
                        //((Gerente) gerente).cadastrarCamareira(c);
                        System.out.print("1 - Cadastrar Outro Funcionário  2 - NÃO\n");
                        i = input.nextInt();
                    } while (i == 1);
                    System.out.println("*** CADASTRO REALIZADO COM SUCESSO ***");
                }

            }
            else if(n == 2){
                //025 046 332 50
                input.nextLine();
                System.out.println("Nome funcionario: ");
                String nome = input.nextLine();
                System.out.println("CPF: ");
                String cpf = input.nextLine();
                boolean retorno = ((Gerente) gerente).verificaFuncionario(nome, cpf);
                if (retorno == true) {
                    System.out.println("Deseja remover o funcionario? 1 - SIM  2 - NÃO");
                    n = input.nextInt();
                    if (n == 1) {
                        ((Gerente) gerente).removerFuncionario(nome, cpf);
                        System.out.println("Funcionario Removido com sucesso!");
                    }else{
                        System.out.println("Processo finalizado.");
                    }
                }else{
                    System.out.println("Processo finalizado.");
                }
            }

        }

    }

}
