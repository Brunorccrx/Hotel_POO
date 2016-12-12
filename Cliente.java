package sistemadehotel;

import java.util.Scanner;

public class Cliente {
    //Dados pessoais do cliente
    private String nome;
    private String endereco;
    private String contato;
    private String email;
    private String nacionalidade;
    private String RG;
    private String CPF;
    private String passaporte;
    private String data_de_nascimento;
    
    Scanner input = new Scanner(System.in);
    
    //Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNationalidade() {
        return nationalidade;
    }

    public void setNationalidade(String nationalidade) {
        this.nationalidade = nationalidade;
    }

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getPassaporte() {
        return passaporte;
    }

    public void setPassaporte(String passaporte) {
        this.passaporte = passaporte;
    }

    public String getData_de_nascimento() {
        return data_de_nascimento;
    }

    public void setData_de_nascimento(String data_de_nascimento) {
        this.data_de_nascimento = data_de_nascimento;
    }
   //Metodo para inserir dados do cliente 
    public void insereCliente(){
        System.out.print("Nome: ");
        this.setNome(input.nextLine());
        
        System.out.print("Endereço: ");
        this.setEndereco(input.nextLine());
        
        System.out.print("Telefone: ");
        this.setContato(input.nextLine());
        
        System.out.print("E-mail: ");
        this.setEmail(input.nextLine());
        
        System.out.print("Nationalidade: ");
        this.setNationalidade(input.nextLine());
        
        if((this.nationalidade).equals("Br")){
            System.out.print("RG: ");
            this.setRG(input.nextLine());
            
            System.out.print("CPF: ");
            this.setCPF(input.nextLine());
        }
        else{
            System.out.print("Passaporte: ");
            this.setPassaporte(input.nextLine());
        }
        System.out.print("Data De Nascimento(dd/mm/yyyy): ");
        this.setData_de_nascimento(input.nextLine());
    }
}
