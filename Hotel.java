package sistemadehotel;

public class Hotel {

    public static void main(String[] agrs){
		Funcionario gerente = new Gerente();
		gerente.setNome("Mario");
		gerente.setLogin("Ana");
		gerente.setSenha("ABCDEFGHIJKLMNOPQRSTUVX");
    try {
			gerente.autenticaLogin(gerente.getLogin());
    }catch (Exception e) {
			System.out.println(e.getMessage());
    }
	try {
		gerente.autenticaSenha(gerente.getSenha());
	}catch (Exception e){
		System.out.println(e.getMessage());
	}

    }

}
