import java.util.*;

import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;

import itens.*;

public class UsuarioController {;
	private Map<String, Usuario> usuarios;

	public UsuarioController() {
		usuarios = new HashMap<>();
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
		for (Usuario usuario : usuarios.values()) {
			if (usuario.getNome().trim().equals(nome.trim()) && usuario.getCelular().equals(celular)) {
				throw new Exception("Usuario ja cadastrado");
			}
		}
		Usuario usuario = new Usuario(nome, celular, email);
		usuarios.put(nome, usuario);
		return "Usuario cadastrado com sucesso!";
	}

	/**
	 * Metodo que recebe a identificacao do usuario, e remove o mesmo da colecao de
	 * usuarios
	 * 
	 * @param nome
	 * @param celular
	 * @return mensagem de sucesso ou nao
	 * @throws Exception
	 */

	public String removerUsuario(String nome, String celular) throws Exception {
		for (Usuario usuario : usuarios.values()) {
			if (usuario.getNome().trim().equals(nome.trim()) && usuario.getCelular().equals(celular)) {
				usuarios.remove(nome);
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
		for (Usuario usuario : usuarios.values()) {
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
			for (Usuario usuario : usuarios.values()) {
				if (usuario.getNome().trim().equals(nome.trim()) && usuario.getCelular().equals(celular)) {
					usuario.setEmail(valor);
					return "Usuario atualizado!";
				}
			}
		}

		else if (atributo.equalsIgnoreCase("telefone")) {
			for (Usuario usuario : usuarios.values()) {
				if (usuario.getNome().trim().equals(nome.trim()) && usuario.getCelular().equals(celular)) {
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
		if (usuarios.containsKey(nome) == false) {
			throw new Exception("Usuario invalido");
		}
		if (atributo.equalsIgnoreCase("email")) {
			for (Usuario usuario : usuarios.values()) {
				if (usuario.getNome().trim().equals(nome.trim()) || usuario.getCelular().equals(celular)) {
					return usuario.getEmail();
				}
			}
		}
		throw new Exception("Usuario invalido");
	}

	/**
	 * Metodo que cadastra um novo item do tipo jogo eletronico e adiciona ao mapa
	 * de itens de determinado usuario
	 * 
	 * @param nome
	 * @param celular
	 * @param nomeItem
	 * @param preco
	 * @param plataforma
	 * @return Mensagem de status
	 * @throws Exception
	 */

	public String cadastrarEletronico(String nome, String celular, String nomeItem, double preco, String plataforma)
			throws Exception {
		for (Usuario usuario : usuarios.values()) {
			if (usuario.getNome().trim().equals(nome.trim()) && usuario.getCelular().equals(celular)) {
				JogoEletronico game = new JogoEletronico(nomeItem, preco, plataforma);
				usuario.getItens().put(nomeItem, game);
				return "Item cadastrado!";
			}
		}
		return "Item nao cadastrado";
	}

	/**
	 * Metodo para cadastrar um novo jogo de tabuleiro no sistema
	 * 
	 * @param nome
	 * @param celular
	 * @param nomeItem
	 * @param preco
	 * @return Mensagem de sucesso
	 * @throws Exception
	 */

	public String cadastrarJogoTabuleiro(String nome, String celular, String nomeItem, double preco) throws Exception {
		if (usuarios.containsKey(nome) == false) {
			throw new Exception("Usuario invalido");
		}

		if (preco < 0) {
			throw new Exception("Preco invalido");
		}
		for (Usuario usuario : usuarios.values()) {
			if (usuario.getNome().trim().equals(nome.trim()) && usuario.getCelular().equals(celular)) {
				JogoTabuleiro jogo = new JogoTabuleiro(nomeItem, preco);
				usuario.getItens().put(nomeItem, jogo);
				return "Item cadastrado!";
			}
		}
		return "Item nao cadastrado";
	}

	/**
	 * Metodo para cadastrar um novo blu-ray de filme no sistema
	 * 
	 * @param nome
	 * @param celular
	 * @param nomeItem
	 * @param preco
	 * @param duracao
	 * @param genero
	 * @param classificacao
	 * @param anoLancamento
	 * @return Mensagem de sucesso
	 * @throws Exception
	 */

	public String cadastrarBluRayFilme(String nome, String celular, String nomeItem, double preco, int duracao,
			String genero, String classificacao, int anoLancamento) throws Exception {
		for (Usuario usuario : usuarios.values()) {
			if (usuario.getNome().trim().equals(nome.trim()) && usuario.getCelular().equals(celular)) {
				BlurayFilme filme = new BlurayFilme(nomeItem, preco, duracao, genero, classificacao, anoLancamento);
				usuario.getItens().put(nomeItem, filme);;
				return "Item cadastrado!";
			}
		}
		return "Item nao cadastrado";
	}

	/**
	 * Metodo para cadastrar um novo blu-ray de show no sistema
	 * 
	 * @param nome
	 * @param celular
	 * @param nomeItem
	 * @param preco
	 * @param duracao
	 * @param classificacao
	 * @param artista
	 * @param numeroDeFaixas
	 * @return Mensagem de sucesso
	 * @throws Exception
	 */

	public void cadastrarBluRayShow(String nome, String celular, String nomeItem, double preco, int duracao,
			int numeroFaixas, String artista, String classificacao) throws Exception {
		for (Usuario usuario : usuarios.values()) {
			if (usuario.getNome().trim().equals(nome.trim()) && usuario.getCelular().equals(celular)) {
				BlurayShow show = new BlurayShow(nomeItem, preco, duracao, numeroFaixas, artista, classificacao);
				usuario.getItens().put(nomeItem, show);
			}
		}
	}

	/**
	 * Metodo que cadastra um novo Blu-Ray de serie no sistema
	 * 
	 * @param nome
	 * @param telefone
	 * @param nomeItem
	 * @param preco
	 * @param descricao
	 * @param duracao
	 * @param classificacao
	 * @param genero
	 * @param temporada
	 * @throws Exception
	 */

	public void cadastrarBluRaySerie(String nome, String telefone, String nomeItem, double preco, String descricao,
			int duracao, String classificacao, String genero, int temporada) throws Exception {
		for (Usuario usuario : usuarios.values()) {
			if (usuario.getNome().trim().equals(nome.trim()) && usuario.getCelular().equals(telefone)) {
				Bluray serie = new BluraySerie(nomeItem, preco, descricao, duracao, classificacao, genero,
						temporada);

				usuario.getItens().put(nomeItem, serie);
			}

		}
	}

	/**
	 * Metodo que adiciona um blu-ray simples em uma temporada de determinada serie
	 * 
	 * @param nome
	 * @param telefone
	 * @param nomeBlurayTemporada
	 * @param duracao
	 */

	public void adicionarBluRay(String nome, String telefone, String nomeBlurayTemporada, int duracao) {
		for (Item item : encontraUsuario(nome, telefone).getItens().values()) {
			if (nomeBlurayTemporada.equals(item.getNomeItem())) {
				((BluraySerie) item).setDuracaoTotal(duracao);

			}
		}
	}

	/**
	 * Metodo que encontra determinado usuario cadastrado no sistema
	 * 
	 * @param nome
	 * @param celular
	 * @return Usuario desejado pronto para uso
	 */

	public Usuario encontraUsuario(String nome, String celular) {
		Usuario retorno = null;
		for (Usuario usuario : usuarios.values()) {
			if (usuario.getNome().trim().equals(nome.trim()) && usuario.getCelular().equals(celular)) {
				retorno = usuario;
			}
		}
		return retorno;

	}

	/**
	 * Metodo que remove o item desejado de um determinado usuario
	 * 
	 * @param nome
	 * @param celular
	 * @param nomeItem
	 * @return Mensagem de status
	 * @throws Exception
	 */

	public String removerItem(String nome, String celular, String nomeItem) throws Exception {
		if (usuarios.containsKey(nome) == false) {
			throw new Exception("Usuario invalido");
		}
		for (Item item : encontraUsuario(nome, celular).getItens().values()) {
			if (item.getNomeItem().equals(nomeItem)) {
				encontraUsuario(nome, celular).getItens().values().remove(item);
				return "Item removido!";
			}
		}
		throw new Exception("Item nao encontrado");
	}

	/**
	 * Metodo que atualiza determinada informacao sobre um item desejado
	 * 
	 * @param nome
	 * @param celular
	 * @param nomeItem
	 * @param atributo
	 * @param valor
	 * @throws Exception
	 */

	public void atualizarItem(String nome, String celular, String nomeItem, String atributo, String valor)
			throws Exception {
		if (usuarios.containsKey(nome) == false) {
			throw new Exception("Usuario invalido");
		} else if (usuarios.get(nome).getItens().containsKey(nomeItem) == false) {
			throw new Exception("Item nao encontrado");
		}
		if ("Preco".equalsIgnoreCase(atributo)) {
			for (Item item : encontraUsuario(nome, celular).getItens().values()) {
				if (nomeItem.equals(item.getNomeItem())) {
					Double valorDouble = Double.parseDouble(valor);
					item.setValor(valorDouble);
				}

			}
		} else if ("Nome".equalsIgnoreCase(atributo)) {
			for (Item item : encontraUsuario(nome, celular).getItens().values()) {
				if (nomeItem.equals(item.getNomeItem())) {
					item.setNomeItem(valor);
					;
				}

			}
		}

	}

	/**
	 * Metodo que adicona uma peca perdida a determinado jogo de tabuleiro
	 * @param nome
	 * @param telefone
	 * @param nomeItem
	 * @param nomePeca
	 */
	
	public void adicionarPecaPerdida(String nome, String telefone, String nomeItem, String nomePeca) {
		for (Item item : encontraUsuario(nome, telefone).getItens().values()) {
			if (item instanceof JogoTabuleiro) {
				((JogoTabuleiro) item).getPecasPerdidas().add(nomePeca);
			}

		}
	}

	/**
	 * Metodo que retorna a informacao desejada sobre o item desejado
	 * @param nome
	 * @param celular
	 * @param nomeItem
	 * @param atributo
	 * @return Mensagem de status
	 * @throws Exception
	 */
	
	public String getInfoItem(String nome, String celular, String nomeItem, String atributo) throws Exception {

		if ("Preco".equalsIgnoreCase(atributo)) {
			for (Usuario usuario : usuarios.values()) {
				if (usuario.getNome().trim().equals(nome.trim()) && usuario.getCelular().equals(celular)) {
					for (Item item : usuario.getItens().values()) {
						if (nomeItem.equals(item.getNomeItem())) {
							return String.valueOf(item.getValor());
						}

					}
				}
			}

		}

		else if ("Nome".equalsIgnoreCase(atributo)) {
			for (Usuario usuario : usuarios.values()) {
				if (usuario.getNome().trim().equals(nome.trim()) && usuario.getCelular().equals(celular)) {
					for (Item item : usuario.getItens().values()) {
						if (nomeItem.equals(item.getNomeItem())) {
							return item.getNomeItem();
						}

					}
				}
			}

		}

		throw new Exception("Item nao encontrado");
	}

	/**
	 *
	 * @author Wesley
	 * @param usuario
	 * @param usuarioHistorico
	 * @param item
	 * @param situacao
	 */

	public void registraHistorico(Usuario usuario, Usuario usuarioHistorico, Item item, SituacaoEmprestimo situacao,
			Calendar dataFinal) {
		for (Usuario u : usuarios.values()) {
			if (u.equals(usuario)) {
				usuario.getHistoricos().add(new Historico(usuarioHistorico, item, situacao, dataFinal));
			}
		}
	}

	public Map<String, Usuario> getUsuarios() {
		return usuarios;
	}
}