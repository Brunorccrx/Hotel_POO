
package com.compilar.testes;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Gerente extends Funcionario implements Autentica {
  private String login;
  private String senha;


  protected void cadastrarFuncionario(List funcionarios,Funcionario funcionario){
    Scanner entrada = new Scanner(System.in);

    System.out.print("Nome: ");
    funcionario.setNome(entrada.nextLine());
    System.out.print("RG: ");
    funcionario.setRG(entrada.nextLine());
    System.out.print("CPF: ");
    funcionario.setCPF(entrada.nextLine());
    System.out.print("Data de nascimento: : ");
    funcionario.setDataNasc(entrada.nextLine());
    System.out.print("Contato: ");
    funcionario.setNumTelefone(entrada.nextLine());
    System.out.print("Rua: ");
    funcionario.setRua(entrada.nextLine());
    System.out.print("Bairro: ");
    funcionario.setBairro(entrada.nextLine());
    System.out.print("Complemento: ");
    funcionario.setComplemento(entrada.nextLine());
    System.out.print("Numero da casa: ");
    funcionario.setNumeroCasa(entrada.nextLine());
    System.out.print("Cidade: ");
    funcionario.setCidade(entrada.nextLine());
    System.out.print("Estado: ");
    funcionario.setEstado(entrada.nextLine());
    System.out.print("Salário: ");
    funcionario.setSalario(entrada.nextDouble());

    funcionarios.add(funcionario);
  }
  protected void removerFuncionario(List<Object>funcionarios,Funcionario funcionario){
    funcionarios.remove(funcionario);
  }//TODO verificar se remoção da lista altera o funcionario na main

  protected void mostrarFuncionarios(List<Funcionario>funcionarios){
    for (Funcionario funcionario:funcionarios)
      System.out.println(funcionario);
  }


  protected Funcionario  verificaFuncionario(String nome, String CPF, List<Funcionario> funcionarios){
    for (Funcionario funcionario:funcionarios)
      if(funcionario.getNome().equals(nome) && funcionario.getCPF().equals(CPF))
        return funcionario;

    return null;
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
  public boolean autentica(String senha,String login ) {
    return this.senha.equals(senha) && this.login.equals(login);
  }
}
