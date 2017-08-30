package usuario;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

import chaves.ChaveUsuario;
import itens.*;

public class ControllerUsuario implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map<ChaveUsuario, Usuario> usuarios;

	public ControllerUsuario() {
		usuarios = new HashMap<>();
	}
	
	public Map<ChaveUsuario, Usuario> getUsuarios() {
		return usuarios;
	}
	/**
	 * Recebe os parametros do usuario e adiciona o mesmo a colecao de usuarios
	 * 
	 * @param nome
	 * @param celular
	 * @param email
	 * @return mensagem de sucesso
	 * @throws IOException 
	 * @throws Exception
	 */

	public void CadastrarUsuario(String nome, String celular, String email) throws IOException {
		
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

	public void removerUsuario(String nome, String celular) {
		
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

	public void AtualizarUsuario(String nome, String celular, String atributo, String valor) {
		
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

	public String getInfoUsuario(String nome, String celular, String atributo) {
		
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
		
		else if (atributo.equalsIgnoreCase("cartao")) {
			return usuario.getCartao();
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

	public void cadastrarEletronico(String nome, String celular, String nomeItem, double preco, String plataforma) {
		
		ChaveUsuario chave = new ChaveUsuario(nome, celular);
		if (!usuarios.containsKey(chave)) {
			throw new IllegalArgumentException("Usuario invalido");
		}
		
		Usuario usuario = usuarios.get(chave);
		usuario.reputacaoNovoItem(preco);
		verificaCartao(usuario);
		JogoEletronico game = new JogoEletronico(nomeItem, preco, plataforma);
		usuario.getItens().put(nomeItem, game);
	}
	
	public void verificaCartao(Usuario usuario) {
		if(usuario.getReputacao() > 0 && usuario.getReputacao() < 100) {
			usuario.setCartao(CartaoFidelidade.NOOB);
			return;
		}

		 if(usuario.getReputacao() > 100.0) {
			usuario.setCartao(CartaoFidelidade.BomAmigo);
			return;
		}
		
		if(usuario.getReputacao() < 0) {
			usuario.setCartao(CartaoFidelidade.Caloteiro);
			return;
		}
		
		else if(usuario.getReputacao() >= 0 && usuario.getItens().isEmpty()) {
			usuario.setCartao(CartaoFidelidade.FreeRider);
		}
		
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

	public void cadastrarJogoTabuleiro(String nome, String celular, String nomeItem, double preco) {
		
		ChaveUsuario chave = new ChaveUsuario(nome, celular);
		if (!usuarios.containsKey(chave)) {
			throw new IllegalArgumentException("Usuario invalido");
		}
		
		Usuario usuario = usuarios.get(chave);
		usuario.reputacaoNovoItem(preco);
		verificaCartao(usuario);
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
			String genero, String classificacao, int anoLancamento) {
		
		ChaveUsuario chave = new ChaveUsuario(nome, celular);
		if (!usuarios.containsKey(chave)) {
			throw new IllegalArgumentException("Usuario invalido");
		}
	
		Usuario usuario = usuarios.get(chave);
		usuario.reputacaoNovoItem(preco);
		verificaCartao(usuario);
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
			int numeroFaixas, String artista, String classificacao) {
		
		ChaveUsuario chave = new ChaveUsuario(nome, celular);
		if (!usuarios.containsKey(chave)) {
			throw new IllegalArgumentException("Usuario invalido");
		}
	
		Usuario usuario = usuarios.get(chave);
		usuario.reputacaoNovoItem(preco);
		verificaCartao(usuario);
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
			int duracao, String classificacao, String genero, int temporada) {
		
		ChaveUsuario chave = new ChaveUsuario(nome, celular);
		if (!usuarios.containsKey(chave)) {
			throw new IllegalArgumentException("Usuario invalido");
		}
	
		Usuario usuario = usuarios.get(chave);
		usuario.reputacaoNovoItem(preco);
		verificaCartao(usuario);
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

	public void adicionarBluRay(String nome, String celular, String nomeBlurayTemporada, int duracao) {
		
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

	public void removerItem(String nome, String celular, String nomeItem) {
		
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

	public void atualizarItem(String nome, String celular, String nomeItem, String atributo, String valor) {
		
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
			
			double nr = usuario.getReputacao() - (0.05 * itensDoUsuario.get(nomeItem).getValor());
			usuario.setReputacao(nr);
			usuario.reputacaoNovoItem(valorDouble);
			verificaCartao(usuario);
			
		} else if ("Nome".equalsIgnoreCase(atributo)) {
			item.setNomeItem(valor);
			
			itensDoUsuario.remove(nomeItem);
			itensDoUsuario.put(valor, item);
		}
	}

	/**
	 * Metodo que adicona uma peca perdida a determinado jogo de tabuleiro
	 * poderiamos consideram um caso em que o item escolhido nï¿½o fosse um 
	 * jogo de tabuleiro, entao neste caso com iriamos lidar com este erro?
	 * 
	 * @param nome
	 * @param telefone
	 * @param nomeItem
	 * @param nomePeca
	 * @throws Exception 
	 */

	public void adicionarPecaPerdida(String nome, String celular, String nomeItem, String nomePeca) {
		
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

	public String getInfoItem(String nome, String celular, String nomeItem, String atributo) {

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
	
	/**
	 
	 * Registra no historico do usuario informacao sobre emprestimos passados.
	 * @param usuario
	 * @param usuarioHistorico
	 * @param item
	 * @param situacao
	 */
	
	public void registraHistorico(String nomeUsuario, String telefoneUsuario, String nomeUsuarioRelacionado,
			String nomeItem, String situacao, String dataDevolucao, int diasAtrasados) {
		
		ChaveUsuario chaveUsuario = new ChaveUsuario(nomeUsuario,telefoneUsuario);
		
		ArrayList <String> historico = getUsuarios().get(chaveUsuario).getHistorico();
		
		String historicoDeEmprestimo = situacao + " a: " + nomeUsuarioRelacionado + " - Item:  " + nomeItem + " - Data de devolucao: " +  dataDevolucao + " - Dia(s) de atraso: " + diasAtrasados; 
		
		historico.add(historicoDeEmprestimo);
		
	}
	
	

	/**
	 * Metodo que lista os emprestimos emprestados por um usuario.
	 * @param nome, nome do usuario.
	 * @param telefone, telefone do usuario.
	 * @return, representacao em string dos emprestimos emprestados por o usario em questao.
	 */
	public String listaEmprestimosEmprestando(String nome, String telefone){
		ChaveUsuario chave = new ChaveUsuario(nome, telefone);
		if (!usuarios.containsKey(chave)) {
			throw new IllegalArgumentException("Usuario invalido");
		}
		return usuarios.get(chave).listaEmprestimoEmprestando();
	}
	/**
	 * Metodo que lista os emprestimos pegos pelo usuario desejado.
	 * @param nome, nome do usuario.
	 * @param telefone, telefone do usuario.
	 * @return, representacao em string dos emprestimos pegos pelo usuario em questao.
	 */
	public String listaEmprestimosPegos(String nome, String telefone){
		ChaveUsuario chave = new ChaveUsuario(nome, telefone);
		if (!usuarios.containsKey(chave)) {
			throw new IllegalArgumentException("Usuario invalido");
		}
		return usuarios.get(chave).listaEmprestimosPegos();
		
	}
	
	public void gravaUsuarios(Map<ChaveUsuario, Usuario> map, String arquivo){
		FileOutputStream arquivoUsuarios;
		try {
			arquivoUsuarios = new FileOutputStream(arquivo);
			ObjectOutputStream gravarUsuario = new ObjectOutputStream(arquivoUsuarios);
			gravarUsuario.writeObject(map);
			arquivoUsuarios.close();
			gravarUsuario.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public Map<ChaveUsuario, Usuario> recuperaUsuarios(String arquivo){
		Map<ChaveUsuario, Usuario> map = new HashMap<>();
		FileInputStream fis;
		try {
			fis = new FileInputStream(arquivo);
			ObjectInputStream ois = new ObjectInputStream(fis);
			map = (Map<ChaveUsuario, Usuario>) ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return map;
		
		
	}
	
	
	
}
