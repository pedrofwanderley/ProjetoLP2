
import java.util.HashSet;

public class UsuarioController {
	private HashSet<Usuario> usuarios;

	public UsuarioController() {
		usuarios = new HashSet<>();
	}

	public String CadastrarUsuario(String nome, String celular, String email) throws Exception {
		Usuario usuario = new Usuario(nome, celular, email);
		usuarios.add(usuario);
		return "Usuário cadastrado com sucesso!";
	}

	public String removerUsuario(String nome, String celular) {
		for (Usuario usuario : usuarios) {
			if (usuario.getNome().trim().equals(nome.trim()) && usuario.getCelular().equals(celular)) {
				usuarios.remove(usuario);
				return "Usuario removido com sucesso";
			}
		}

		return "Usuario invalido";
	}

	public String PesquisarUsuario(String nome) {
		for (Usuario usuario : usuarios) {
			if (usuario.getNome().trim().equals(nome.trim())) {
				return usuario.toString();
			}
		}

		return "Usuario invalido";

	}

	public String AtualizarUsuario(String nome) {
		return "";
	}

	public String getInfoUsuario(String nome, String celular, String atributo) {
		if (atributo.equalsIgnoreCase("email")) {
			for (Usuario usuario : usuarios) {
				if (usuario.getNome().trim().equals(nome.trim()) || usuario.getCelular().equals(celular)) {
					return usuario.getEmail();
				}
			}
		}
		return "Usuario invalido";
	}

	public HashSet<Usuario> getUsuarios() {
		return usuarios;
	}
}