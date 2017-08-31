package usuario;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
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
	 * @param nome, nome do usuario.
	 * @param celular, telefone do usuario.
	 * @param email, email do usuario.
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
	 * @param nome, nome do usuario.
	 * @param celular, telefone do usuario.
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
	 * @param nome, nome do usuario.
	 * @param celular, telefone do usuario.
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
	 * @param nome, nome do usuario.
	 * @param celular, telefone do usuario.
	 * @param atributo, atributo a ser atualizado.
	 * @param valor, valor do item.
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
	 * Metodo que recebe a identificao do usuario e exibe o email do mesmo
	 * 
	 * @param nome, nome do usuario.
	 * @param celular, telefone do usuario.
	 * @param atributo, atributo a ser identificado.
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
	 * @param nome, nome do usuario.
	 * @param celular, telefone do usuario.
	 * @param nomeItem, nome do item.
	 * @param preco, valor do item.
	 * @param plataforma, tipo de plataforma do jogo.
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
	 * @param nome, nome do usuario.
	 * @param celular, telefone do usuario.
	 * @param nomeItem, nome do item.
	 * @param preco, valor do item.
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
	 * @param nome, nome do usuario.
	 * @param celular, telefone do usuario.
	 * @param nomeItem, nome do item.
	 * @param preco, valor do item.
	 * @param duracao, duracao do filme.
	 * @param genero, genero do filme.
	 * @param classificacao, classificacao do filme.
	 * @param anoLancamento, ano de lancamento do filme.
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
	 * @param nome, nome do usuario.
	 * @param celular, telefone do usuario.
	 * @param nomeItem, nome do item.
	 * @param preco, valor do item.
	 * @param duracao, duracao do show.
	 * @param classificacao, classificacao do show.
	 * @param artista, artista do show.
	 * @param numeroFaixas, numero de faixas do show.
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
	 * @param nome, nome do usuario.
	 * @param celular, telefone do usuario.
	 * @param nomeItem, nome do item.
	 * @param preco, valor do item.
	 * @param descricao, descricao da serie.
	 * @param duracao, duracao da serie.
	 * @param classificacao, classificao da serie.
	 * @param genero, genero da serie.
	 * @param temporada, temporada da serie.
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
	 * @param nome, nome do usuario.
	 * @param celular, telefone do usuario.
	 * @param nomeBlurayTemporada, nome do item.
	 * @param duracao, duracao do episodio.
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
	 * @param nome, nome do usuario.
	 * @param celular, telefone do usuario.
	 * @param nomeItem, nome do item.
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
	 * @param nome, nome do usuario.
	 * @param celular, telefone do usuario.
	 * @param nomeItem, nome do item.
	 * @param atributo, atributo a ser atualizado.
	 * @param valor, valor do item.
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
	 * @param nome, nome do usuario.
	 * @param celular, telefone do usuario.
	 * @param nomeItem, nome do item.
	 * @param nomePeca, nome da peca perdida.
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
	 * @param nome, nome do usuario.
	 * @param celular, telefone do usuario.
	 * @param nomeItem, nome do item.
	 * @param atributo, atributo a ser informado.
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
	 * Metodo de registro de emprestimo no historico do usuario.
	 * @param nomeUsuario, nome do usuario.
	 * @param telefoneUsuario, telefone do usuario.
	 * @param nomeUsuarioRelacionado, usuario requerente.
	 * @param nomeItem, nome do item.
	 * @param situacao, situacao do emprestimo.
	 * @param dataDevolucao, data de devolucao do item.
	 * @param diasAtrasados, dias de atraso na devolucao.
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
	/**
	 * Método de gravação de mapa de usuários, o objeto é gravado após o sistema ser fechado.
	 * @param map, mapa de usuários.
	 * @param arquivo, nome do arquivo de destino.
	 */
	public void gravaUsuarios(Map<ChaveUsuario, Usuario> map, String arquivo){
		FileOutputStream arquivoUsuarios;
		try {
			arquivoUsuarios = new FileOutputStream(arquivo);
			ObjectOutputStream gravarUsuario = new ObjectOutputStream(arquivoUsuarios);
			gravarUsuario.writeObject(map);
			gravarUsuario.flush();
			gravarUsuario.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * Método de recuperação de mapa gravado.
	 * @param arquivo, nome do arquivo onde os dados serão buscados.
	 * @return, retorna um mapa de usuários gravado anteriormente.
	 */
	public Map<ChaveUsuario, Usuario> recuperaUsuarios(String arquivo){
		File arquivoUsuarios = null;
		arquivoUsuarios = new File(arquivo);
		Map<ChaveUsuario, Usuario> map = new HashMap<>();
		FileInputStream fis;
		try {
			if (!arquivoUsuarios.exists()) {
				arquivoUsuarios.createNewFile();
			}	
			else if (arquivoUsuarios.length() == 0) {
				System.out.println("ARQUIVO VAZIO");
				
			}else{
			fis = new FileInputStream(arquivo);
			ObjectInputStream ois = new ObjectInputStream(fis);
			map = (Map<ChaveUsuario, Usuario>) ois.readObject();
			ois.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return map;
		
		
	}
	
	
	
}
