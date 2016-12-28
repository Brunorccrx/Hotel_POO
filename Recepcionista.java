package sistemadehotel;

import java.io.IOException;

class Recepcionista extends Funcionario implements Autentica{


private String login;
private String senha;


public String getSenha() {
    return senha;
}
public void setSenha(String senha)throws IOException{
    if(senha.length()<7){
	throw new IOException("Senha deve ter no mínimo 7 caracteres");
    }
    if(senha.length()>14){
	throw new IOException("Senha ultrapassou o limite máximo de 14 caracteres");
    }

	this.senha = senha;
}
public String getLogin() {
    return login;
}
public void setLogin(String login) throws IOException {
    if(login.length()<5){
	throw new IOException("Login deve ter no mínimo 5 caracteres");
    }
    if(login.length()>20){
        throw new IOException("Login ultrapassou o limite máximo de 20 caracteres");
    }
	this.login = login;
}
@Override
public boolean autentica(String senha){
    return this.senha.equals(senha);
}

}

