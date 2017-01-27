package sistemadehotel;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Gerente extends Funcionario implements Autentica {

    //Autenticação de usuário no Sistema

    private String login;
    private String senha;
    
    File arquivo;
    public void cadastrarFuncionario(Funcionario f ,String nome , String cpf){
        arquivo = new File("Banco de Dados/"+nome+cpf+".txt");
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
    }
    public boolean verificaFuncionario(String nome, String cpf){
        arquivo = new File("Banco de Dados/"+nome+cpf+".txt");
        if(arquivo.exists()){
            System.out.println("Funcionario encontrado!");
            return true;
        }else{
            System.out.println("Funcionario nao encontrado!");
            return false;
        }
        
    }
    public void removerFuncionario(String nome,String cpf){
        arquivo = new File("Banco de Dados/"+nome+cpf+".txt");
        arquivo.delete();
    }
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) throws IOException {
        if (senha.length() < 7) {
            throw new IOException("Senha deve ter no mínimo 7 caracteres");
        }
        if (senha.length() > 14) {
            throw new IOException("Senha ultrapassou o limite máximo de 14 caracteres");
        }

        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) throws IOException {
        if (login.length() < 5) {
            throw new IOException("Login deve ter no mínimo 5 caracteres");
        }
        if (login.length() > 20) {
            throw new IOException("Login ultrapassou o limite máximo de 20 caracteres");
        }

        this.login = login;
    }
    @Override
    public boolean autentica(String senha) {
        return this.senha.equals(senha);
    }
}
