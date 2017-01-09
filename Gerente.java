package sistemadehotel;

import java.io.IOException;

public class Gerente extends Funcionario implements Autentica {

    //Autenticação de usuário no Sistema

    private String login;
    private String senha;
    Camareira[] camareira;
    Recepcionista[] recepcionista;
    static int contador1 = 0;
    static int contador2 = 0;

    public void cadastrarRecepcionista(Recepcionista f) {
        this.recepcionista[contador1] = f;
        contador1++;
    }
    public void mostraRecepcionista() {
        for(int i = 0 ; i < this.recepcionista.length ;i++){
            System.out.println("Nome: " + recepcionista[i].getNome() + "\nCPF: "
            + recepcionista[i].getCPF() + "\nData de nascimento: "+ recepcionista[i].getDataNasc()
            + "\nSalario: " + recepcionista[i].getSalario());
            System.out.println();
        }
    }
    public void cadastrarCamareira(Camareira f){
        this.camareira[contador2] = f;
        contador2++;
    }
    public void mostraCamareira() {
        for(int i = 0 ; i < this.camareira.length ;i++){
            System.out.println("Nome: " + camareira[i].getNome() + "\nCPF: "
            + camareira[i].getCPF() + "\nData de nascimento: "+ camareira[i].getDataNasc()
            + "\nSalario: " + camareira[i].getSalario());
            System.out.println();
        }
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
