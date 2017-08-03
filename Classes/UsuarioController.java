import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;

import itens.Bluray;
import itens.BlurayFilme;
import itens.BlurayShow;
import itens.Item;
import itens.JogoEletronico;
import itens.JogoTabuleiro;
import itens.SituacaoEmprestimo;

public class UsuarioController {
	private List<Item> itensTotais;
	private List<Usuario> usuarios;

	public UsuarioController() {
		usuarios = new ArrayList<>();
		itensTotais = new ArrayList<>();
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
		return "Usuario cadastrado com sucesso!";
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
				if (usuario.getNome().trim().equals(nome.trim()) && usuario.getCelular().equals(celular)) {
					usuario.setEmail(valor);
					return "Usuario atualizado!";
				}
			}
		}

		else if (atributo.equalsIgnoreCase("telefone")) {
			for (Usuario usuario : usuarios) {
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
		if (atributo.equalsIgnoreCase("email")) {
			for (Usuario usuario : usuarios) {
				if (usuario.getNome().trim().equals(nome.trim()) || usuario.getCelular().equals(celular)) {
					return usuario.getEmail();
				}
			}
		}
		throw new Exception("Usuario invalido");
	}

	public String cadastrarEletronico(String nome, String celular, String nomeItem, double preco, String plataforma)
			throws Exception {
		for (Usuario usuario : usuarios) {
			if (usuario.getNome().trim().equals(nome.trim()) && usuario.getCelular().equals(celular)) {
				JogoEletronico game = new JogoEletronico(nomeItem, preco, plataforma);
				usuario.getItens().add(game);
				itensTotais.add(game);
				return "Item cadastrado!";
			}
		}
		return "Item nao cadastrado";
	}

	/**
	 * Metodo para cadastrar um novo jogo de tabuleiro no sistema
	 * @param nome
	 * @param celular
	 * @param nomeItem
	 * @param preco
	 * @return Mensagem de sucesso
	 * @throws Exception
	 */
	
	public String cadastrarJogoTabuleiro(String nome, String celular, String nomeItem, double preco) throws Exception {
		if (preco < 0) {
			throw new Exception("Preco invalido");
		}
		for (Usuario usuario : usuarios) {
			if (usuario.getNome().trim().equals(nome.trim()) && usuario.getCelular().equals(celular)) {
				JogoTabuleiro jogo = new JogoTabuleiro(nomeItem, preco);
				usuario.getItens().add(jogo);
				itensTotais.add(jogo);
				return "Item cadastrado!";
			}
		}
		return "Item nao cadastrado";
	}

	/**
	 * Metodo para cadastrar um novo blu-ray de filme no sistema
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
		for (Usuario usuario : usuarios) {
			if (usuario.getNome().trim().equals(nome.trim()) && usuario.getCelular().equals(celular)) {
				BlurayFilme filme = new BlurayFilme(nomeItem, preco, duracao, genero, classificacao, anoLancamento);
				usuario.getItens().add(filme);
				itensTotais.add(filme);
				return "Item cadastrado!";
			}
		}
		return "Item nao cadastrado";
	}

	/**
	 * Metodo para cadastrar um novo blu-ray de show no sistema
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
	
	public String cadastrarBluRayShow(String nome, String celular, String nomeItem, double preco, int duracao,
			String classificacao, String artista, int numeroDeFaixas) throws Exception {
		for (Usuario usuario : usuarios) {
			if (usuario.getNome().trim().equals(nome.trim()) && usuario.getCelular().equals(celular)) {
				BlurayShow show = new BlurayShow(nomeItem, preco, duracao, classificacao, artista, numeroDeFaixas);
				usuario.getItens().add(show);
				itensTotais.add(show);
				return "Item cadastrado!";
			}
		}
		return "Item nao cadastrado";
	}

	// public String cadastrarBluRaySerieBlurayTemporada(String nome, String
	// celular, String nomeItem, double preco, int duracao,
	// String classificacao, String generoSerie, int numeroDaTemporada, int
	// duracaoTotal,
	// HashSet<Bluray> discosTemporada) throws Exception {
	// for (Usuario usuario : usuarios) {
	// if (usuario.getNome().trim().equals(nome.trim()) &&
	// usuario.getCelular().equals(celular)) {
	// BlurayShow show = new BlurayShow(nomeItem, preco, duracao, classificacao,
	// artista, numeroDeFaixas);
	// usuario.getItens().add(show);
	// itensTotais.add(show);
	// return "Item cadastrado!";
	// }
	// }
	// return "Item nao cadastrado";
	// }

	public Usuario encontraUsuario(String nome, String celular) {
		Usuario retorno = null;
		for (int i = 0; i < usuarios.size(); i++) {
			if (usuarios.get(i).getNome().trim().equals(nome.trim()) && usuarios.get(i).getCelular().equals(celular)) {
				retorno = usuarios.get(i);
			}
		}
		return retorno;

	}

	public String removerItem(String nome, String celular, String nomeItem) throws Exception {
		for (int i = 0; i < encontraUsuario(nome, celular).getItens().size(); i++) {
			if (encontraUsuario(nome, celular).getItens().get(i).getNomeItem().equals(nomeItem)) {
				encontraUsuario(nome, celular).getItens().remove(i);
				return "Item removido!";
			}
		}
		throw new Exception("Item nao encontrado");
	}

	public ArrayList arrayDeItensDesejado(String nome, String celular) {
		ArrayList<Item> retorno = null;
		for (int i = 0; i < usuarios.size(); i++) {
			if (usuarios.get(i).getNome().trim().equals(nome.trim()) && usuarios.get(i).getCelular().equals(celular)) {
				retorno = usuarios.get(i).getItens();
			}
		}
		return retorno;
	}

	public String atualizarItem(String nome, String celular, String nomeItem, String atributo, String valor)
			throws Exception {
		for (int i = 0; i < encontraUsuario(nomeItem, celular).getItens().size(); i++) {
			if (encontraUsuario(nomeItem, celular).getItens().get(i).getNomeItem().equals(nomeItem)) {
				encontraUsuario(nomeItem, celular).getItens().get(i).setNomeItem(valor);
				return "Item atualizado!";
			}
		}

		throw new Exception("Item nao encontrado");
	}

	public double getInfoItem(String nome, String celular, String nomeItem, String atributo) throws Exception {
		int x = encontraUsuario(nome, celular).getItens().size();
		
		for (int i = 0; i < x; i++) {
			if (encontraUsuario(nome, celular).getItens().get(i).getNomeItem().equals(nomeItem)) {
				
				if (atributo.equalsIgnoreCase("preco")) {
					return encontraUsuario(nome, celular).getItens().get(i).getValor();
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
	
	public void registraHistorico(Usuario usuario, Usuario usuarioHistorico, Item item, SituacaoEmprestimo situacao, Calendar dataFinal) {
		for (Usuario u : usuarios) {
			if (u.equals(usuario)) {
				usuario.getHistoricos().add(new Historico(usuarioHistorico, item, situacao, dataFinal));
			}
		}
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public List<Item> getItensTotais() {
		return itensTotais;
	}

	public void setItensTotais(List<Item> itensTotais) {
		this.itensTotais = itensTotais;
	}
}