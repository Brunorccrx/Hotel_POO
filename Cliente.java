/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemadehotel;

import java.util.Scanner;
/**
 *
 * @author FELIPEY
 */
public class Cliente {
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
    
    public void insereCliente(){
        System.out.print("Nome: ");
        this.nome = input.nextLine();
        System.out.print("Endereço: ");
        this.endereco = input.nextLine();
        System.out.print("Telefone: ");
        this.contato = input.nextLine();
        System.out.print("E-mail: ");
        this.email = input.nextLine();
        System.out.print("Nationalidade: ");
        this.nationalidade = input.nextLine();
        if((this.nationalidade).equals("Br")){
            System.out.print("RG: ");
            this.RG = input.nextLine();
            System.out.print("CPF: ");
            this.CPF = input.nextLine();
        }
        else{
            System.out.print("Passaporte: ");
            this.passaporte = input.nextLine();
        }
        System.out.print("Data De Nascimento(dd/mm/yyyy): ");
        this.data_de_nascimento = input.nextLine();
    }
}
