import easyaccept.EasyAccept;

public class Fachada {
	public static void main(String[] args) {
		args = new String[] { "Fachada", "Acceptance_test/us1_test.txt.txt", "Acceptance_test/us2_test.txt.txt" };
		EasyAccept.main(args);
	}
	
	private UsuarioController usuarioController = new UsuarioController();
	
	public String cadastrarUsuario(String nome, String email, String celular) throws Exception {
		usuarioController.CadastrarUsuario(nome, email, celular);
		return email;
	}
	
	public String getInfoUsuario(String nome, String celular, String atributo) throws Exception {
		return usuarioController.getInfoUsuario(nome, celular, atributo);
	}
	
	public void removerUsuario(String nome, String celular) throws Exception {
		usuarioController.removerUsuario(nome, celular);
	}
	
	public void atualizarUsuario(String nome, String celular, String atributo, String novoEmail) throws Exception {
		 usuarioController.AtualizarUsuario(nome, celular, atributo, novoEmail);
	}
}
