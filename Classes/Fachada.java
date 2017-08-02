import easyaccept.EasyAccept;

public class Fachada {
	public static void main(String[] args) {
		args = new String[] { "Classes.Fachada", "Acceptance_test/us1_test.txt.txt" };
		EasyAccept.main(args);
	}
	
	private UsuarioController usuarioController = new UsuarioController();
	
	public String cadastrarUsuario(String nome, String email, String celular) throws Exception {
		usuarioController.CadastrarUsuario(nome, email, celular);
		return email;
	}
	
//	public String getInfoUsuario() {
//		
//	}
	
	public void removerUsuario(String nome, String celular) {
		usuarioController.removerUsuario(nome, celular);
	}
}
