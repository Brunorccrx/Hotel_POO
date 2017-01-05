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

    }
    public void cadastrarCamareira(Camareira f){
        this.camareira[contador2] = f;
        contador2++;
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

    public boolean autentica(String senha) {
        return this.senha.equals(senha);
    }
}
