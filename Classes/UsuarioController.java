
import java.util.HashSet;

public class UsuarioController {
	private HashSet<Usuario> usuarios;

	public UsuarioController() {
		usuarios = new HashSet<>();
	}

	/**
	 * Recebe os parametros do usuario e adiciona o mesmo a colecao de usuarios
	 * 
	 * @param nome
	 * @param celular
	 * @param email
	 * @return mensagem de sucesso
	 * @throws Exception
	 */

	public String CadastrarUsuario(String nome, String celular, String email) throws Exception {
		for (Usuario usuario : usuarios) {
			if (usuario.getNome().trim().equals(nome.trim()) && usuario.getCelular().equals(celular)) {
				throw new Exception("Usuario ja cadastrado");
			}
		}
		Usuario usuario = new Usuario(nome, celular, email);
		usuarios.add(usuario);
		return "Usuário cadastrado com sucesso!";
	}

	/**
	 * Metodo que recebe a identificacao do usuario, e remove o mesmo da colecao
	 * de usuarios
	 * 
	 * @param nome
	 * @param celular
	 * @return mensagem de sucesso ou nao
	 * @throws Exception
	 */

	public String removerUsuario(String nome, String celular) throws Exception {
		for (Usuario usuario : usuarios) {
			if (usuario.getNome().trim().equals(nome.trim()) && usuario.getCelular().equals(celular)) {
				usuarios.remove(usuario);
				return "Usuario removido com sucesso";
			}
		}

		throw new Exception("Usuario invalido");
	}

	/**
	 * Metodo que recebe o nome do usuario e retorna a representacao textual do
	 * mesmo
	 * 
	 * @param nome
	 * @return toString do usuario desejado
	 */

	public String PesquisarUsuario(String nome) {
		for (Usuario usuario : usuarios) {
			if (usuario.getNome().trim().equals(nome.trim())) {
				return usuario.toString();
			}
		}

		return "Usuario invalido";

	}

	/**
	 * Metodo que recebe a identificacao do usuario, o atributo que se deseja
	 * modificar e o valor que sera setado
	 * 
	 * @param nome
	 * @param celular
	 * @param atributo
	 * @param valor
	 * @return mensagem de sucesso
	 * @throws Exception
	 */

	public String AtualizarUsuario(String nome, String celular, String atributo, String valor) throws Exception {
		if (atributo.equalsIgnoreCase("email")) {
			for (Usuario usuario : usuarios) {
				if (usuario.getNome().trim().equals(nome.trim()) || usuario.getCelular().equals(celular)) {
					usuario.setEmail(valor);
					return "Usuario atualizado!";
				}
			}
		}

		else if (atributo.equalsIgnoreCase("telefone")) {
			for (Usuario usuario : usuarios) {
				if (usuario.getNome().trim().equals(nome.trim()) || usuario.getCelular().equals(celular)) {
					usuario.setCelular(valor);
					return "Usuario atualizado!";
				}
			}
		}

		throw new Exception("Usuario invalido");
	}

	/**
	 * Metodo que recebe a identificaao do usuario e exibe o email do mesmo
	 * 
	 * @param nome
	 * @param celular
	 * @param atributo
	 * @return Email desejado
	 * @throws Exception
	 */

	public String getInfoUsuario(String nome, String celular, String atributo) throws Exception {
		if (atributo.equalsIgnoreCase("email")) {
			for (Usuario usuario : usuarios) {
				if (usuario.getNome().trim().equals(nome.trim()) || usuario.getCelular().equals(celular)) {
					return usuario.getEmail();
				}
			}
		}
		throw new Exception("Usuario invalido");
	}

	public HashSet<Usuario> getUsuarios() {
		return usuarios;
	}
}