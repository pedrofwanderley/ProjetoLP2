package usuario;
import java.util.*;

import chaves.ChaveUsuario;
import emprestimo.SituacaoEmprestimo;
import itens.*;

public class UsuarioController {
	
	private Map<ChaveUsuario, Usuario> usuarios;

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

	public void CadastrarUsuario(String nome, String celular, String email) throws Exception {
		
		ChaveUsuario chave = new ChaveUsuario(nome, celular);
		if (usuarios.containsKey(chave)) {
			throw new IllegalArgumentException("Usuario ja cadastrado");
		}
		
		Usuario usuario = new Usuario(nome, celular, email);
		usuarios.put(chave, usuario);
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

	public void removerUsuario(String nome, String celular) throws Exception {
		
		ChaveUsuario chave = new ChaveUsuario(nome, celular);
		if (!usuarios.containsKey(chave)) {
			throw new IllegalArgumentException("Usuario invalido");
		}
		
		usuarios.remove(chave);
	}

	/**
	 * Metodo que recebe o nome do usuario e retorna a representacao textual do
	 * mesmo
	 * 
	 * @param nome
	 * @return toString do usuario desejado
	 */

	public String PesquisarUsuario(String nome, String celular) {
		
		ChaveUsuario chave = new ChaveUsuario(nome, celular);
		if (!usuarios.containsKey(chave)) {
			throw new IllegalArgumentException("Usuario invalido");
		}
		
		Usuario usuario = usuarios.get(chave);
		return usuario.toString();
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

	public void AtualizarUsuario(String nome, String celular, String atributo, String valor) throws Exception {
		
		ChaveUsuario chave = new ChaveUsuario(nome, celular);
		if (!usuarios.containsKey(chave)) {
			throw new IllegalArgumentException("Usuario invalido");
		}
		
		Usuario usuario = usuarios.get(chave);
		
		if (atributo.equalsIgnoreCase("email")) {
			usuario.setEmail(valor);
			
		} else if (atributo.equalsIgnoreCase("telefone")) {
			usuario.setCelular(valor);
			ChaveUsuario novaChave = new ChaveUsuario(nome, valor);
			usuarios.remove(chave);
			usuarios.put(novaChave, usuario);
		}
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
		
		ChaveUsuario chave = new ChaveUsuario(nome, celular);
		if (!usuarios.containsKey(chave)) {
			throw new IllegalArgumentException("Usuario invalido");
		}
		
		Usuario usuario = usuarios.get(chave);
		if (atributo.equalsIgnoreCase("email")) {
		return usuario.getEmail();	
		}
		
		else if (atributo.equalsIgnoreCase("reputacao")) {
			return String.valueOf(usuario.getReputacao());
		}
		return "";
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

	public void cadastrarEletronico(String nome, String celular, String nomeItem, double preco, String plataforma)
			throws Exception {
		
		ChaveUsuario chave = new ChaveUsuario(nome, celular);
		if (!usuarios.containsKey(chave)) {
			throw new IllegalArgumentException("Usuario invalido");
		}
		
		Usuario usuario = usuarios.get(chave);
		double aumentoreputacao = getPorcentagem5(preco) + usuario.getReputacao();
		usuario.setReputacao(aumentoreputacao);
		JogoEletronico game = new JogoEletronico(nomeItem, preco, plataforma);
		usuario.getItens().put(nomeItem, game);
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

	public void cadastrarJogoTabuleiro(String nome, String celular, String nomeItem, double preco) throws Exception {
		
		ChaveUsuario chave = new ChaveUsuario(nome, celular);
		if (!usuarios.containsKey(chave)) {
			throw new IllegalArgumentException("Usuario invalido");
		}
		
		Usuario usuario = usuarios.get(chave);
		double aumentoreputacao = getPorcentagem5(preco) + usuario.getReputacao();
		usuario.setReputacao(aumentoreputacao);
		JogoTabuleiro jogo = new JogoTabuleiro(nomeItem, preco);
		usuario.getItens().put(nomeItem, jogo);
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

	public void cadastrarBluRayFilme(String nome, String celular, String nomeItem, double preco, int duracao,
			String genero, String classificacao, int anoLancamento) throws Exception {
		
		ChaveUsuario chave = new ChaveUsuario(nome, celular);
		if (!usuarios.containsKey(chave)) {
			throw new IllegalArgumentException("Usuario invalido");
		}
	
		Usuario usuario = usuarios.get(chave);
		double aumentoreputacao = getPorcentagem5(preco) + usuario.getReputacao();
		usuario.setReputacao(aumentoreputacao);
		BlurayFilme filme = new BlurayFilme(nomeItem, preco, duracao, genero, classificacao, anoLancamento);
		usuario.getItens().put(nomeItem, filme);
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
		
		ChaveUsuario chave = new ChaveUsuario(nome, celular);
		if (!usuarios.containsKey(chave)) {
			throw new IllegalArgumentException("Usuario invalido");
		}
	
		Usuario usuario = usuarios.get(chave);
		double aumentoreputacao = getPorcentagem5(preco) + usuario.getReputacao();
		usuario.setReputacao(aumentoreputacao);
		BlurayShow show = new BlurayShow(nomeItem, preco, duracao, numeroFaixas, artista, classificacao);
		usuario.getItens().put(nomeItem, show);
	
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

	public void cadastrarBluRaySerie(String nome, String celular, String nomeItem, double preco, String descricao,
			int duracao, String classificacao, String genero, int temporada) throws Exception {
		
		ChaveUsuario chave = new ChaveUsuario(nome, celular);
		if (!usuarios.containsKey(chave)) {
			throw new IllegalArgumentException("Usuario invalido");
		}
	
		Usuario usuario = usuarios.get(chave);
		double aumentoreputacao = getPorcentagem5(preco) + usuario.getReputacao();
		usuario.setReputacao(aumentoreputacao);
		Bluray serie = new BluraySerie(nomeItem, preco, descricao, duracao, classificacao, genero, temporada);
		usuario.getItens().put(nomeItem, serie);	
	}

	/**
	 * Metodo que adiciona um blu-ray simples em uma temporada de determinada serie
	 * 
	 * @param nome
	 * @param telefone
	 * @param nomeBlurayTemporada
	 * @param duracao
	 * @throws Exception 
	 */

	public void adicionarBluRay(String nome, String celular, String nomeBlurayTemporada, int duracao) throws Exception {
		
		ChaveUsuario chave = new ChaveUsuario(nome, celular);
		if (!usuarios.containsKey(chave)) {
			throw new IllegalArgumentException("Usuario invalido");
		}

		Usuario usuario = usuarios.get(chave);
		HashMap<String, Item> itensDoUsuario = usuario.getItens();
		Item item = itensDoUsuario.get(nomeBlurayTemporada);
		((BluraySerie) item).adicionarBluRay(duracao);
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

	public void removerItem(String nome, String celular, String nomeItem) throws Exception {
		
		ChaveUsuario chave = new ChaveUsuario(nome, celular);
		if (!usuarios.containsKey(chave)) {
			throw new IllegalArgumentException("Usuario invalido");
		}
		
		Usuario usuario = usuarios.get(chave);
		HashMap<String, Item> itensDoUsuario = usuario.getItens();
		
		if (!itensDoUsuario.containsKey(nomeItem)) {
			throw new IllegalArgumentException("Item nao encontrado");
		}
		
		itensDoUsuario.remove(nomeItem);
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
		
		ChaveUsuario chave = new ChaveUsuario(nome, celular);
		if (!usuarios.containsKey(chave)) {
			throw new IllegalArgumentException("Usuario invalido");
		}
		
		Usuario usuario = usuarios.get(chave);
		HashMap<String, Item> itensDoUsuario = usuario.getItens();
		
		if (!itensDoUsuario.containsKey(nomeItem)) {
			throw new IllegalArgumentException("Item nao encontrado");
		}
		
		Item item = itensDoUsuario.get(nomeItem);
	
		if ("Preco".equalsIgnoreCase(atributo)) {
			Double valorDouble = Double.parseDouble(valor);
			item.setValor(valorDouble);
		} else if ("Nome".equalsIgnoreCase(atributo)) {
			item.setNomeItem(valor);
			
			itensDoUsuario.remove(nomeItem);
			itensDoUsuario.put(valor, item);
		}
	}

	/**
	 * Metodo que adicona uma peca perdida a determinado jogo de tabuleiro
	 * poderiamos consideram um caso em que o item escolhido n�o fosse um 
	 * jogo de tabuleiro, entao neste caso com iriamos lidar com este erro?
	 * 
	 * @param nome
	 * @param telefone
	 * @param nomeItem
	 * @param nomePeca
	 * @throws Exception 
	 */

	public void adicionarPecaPerdida(String nome, String celular, String nomeItem, String nomePeca) throws Exception {
		
		ChaveUsuario chave = new ChaveUsuario(nome, celular);
		if (!usuarios.containsKey(chave)) {
			throw new IllegalArgumentException("Usuario invalido");
		}
		
		Usuario usuario = usuarios.get(chave);
		HashMap<String, Item> itensDoUsuario = usuario.getItens();
		
		if (!itensDoUsuario.containsKey(nomeItem)) {
			throw new IllegalArgumentException("Item nao encontrado");
		}
		
		Item item = itensDoUsuario.get(nomeItem);
	
		((JogoTabuleiro) item).adicionarPecaPerdida(nomePeca);
	}

	/**
	 * Metodo que retorna a informacao desejada sobre o item desejado
	 * 
	 * @param nome
	 * @param celular
	 * @param nomeItem
	 * @param atributo
	 * @return Mensagem de status
	 * @throws Exception
	 */

	public String getInfoItem(String nome, String celular, String nomeItem, String atributo) throws Exception {

		ChaveUsuario chave = new ChaveUsuario(nome, celular);
		if (!usuarios.containsKey(chave)) {
			throw new IllegalArgumentException("Usuario invalido");
		}
		
		Usuario usuario = usuarios.get(chave);
		HashMap<String, Item> itensDoUsuario = usuario.getItens();
		
		if (!itensDoUsuario.containsKey(nomeItem)) {
			throw new IllegalArgumentException("Item nao encontrado");
		}
		
		Item item = itensDoUsuario.get(nomeItem);


		if (atributo.equalsIgnoreCase("preco")) {
			return String.valueOf(item.getValor());
		}

		else if (atributo.equalsIgnoreCase("nome")) {
			return item.getNomeItem();
		}
		else {
			throw new IllegalArgumentException("Atributo invalido!");
		}
	}
	
	/**
	 * Metodo que retorna o valor de 5% sobre o preco total do item em questao
	 * @param preco
	 * @return valor requerido
	 */
	
	public double getPorcentagem5(double preco) {
		return preco * 0.05;
	}

	/**
	 
	 * Registra no historico do usuario informacao sobre emprestimos passados.
	 * @param usuario
	 * @param usuarioHistorico
	 * @param item
	 * @param situacao
	 */

	public void registraHistorico(Usuario usuario, Usuario usuarioHistorico, Item item, SituacaoEmprestimo situacao, 
			String dataFinal,String dataDevolucao) {
			
			if (usuarios.containsValue(usuario)) {
				throw new IllegalArgumentException("Usuario invalido");
			}

			ArrayList<Historico> historicoDoUsuario = usuario.getHistoricos();
			Historico novoHistorico = new Historico(usuarioHistorico, item, situacao, dataFinal ,dataDevolucao);
			historicoDoUsuario.add(novoHistorico);
	}

	public Map<ChaveUsuario, Usuario> getUsuarios() {
		return usuarios;
	}
	public String listaEmprestimos(String nome, String telefone){
		ChaveUsuario chave = new ChaveUsuario(nome, telefone);
		return usuarios.get(chave).listaEmprestimo();
	}
	
	public String listaEmprestimosPegos(String nome, String telefone){
		ChaveUsuario chave = new ChaveUsuario(nome, telefone);
		return usuarios.get(chave).listaEmprestimosPegos();
		
	}
}