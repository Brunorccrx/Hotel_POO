package sistemadehotel;

public class Hotel {

    public static void main(String[] agrs){
		Funcionario gerente = new Gerente();
		gerente.setNome("Mario");
		gerente.setLogin("Ana");
		gerente.setSenha("ABCDEFGHIJKLMNOPQRSTUVX");
    try {
			gerente.autentica(gerente.login,gerente.senha);
    }catch (IOException e) {
			System.out.println(e.getMessage());
    }

    }

}
