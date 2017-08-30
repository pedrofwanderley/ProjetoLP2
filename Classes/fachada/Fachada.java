package fachada;

import java.io.IOException;

import easyaccept.EasyAccept;
import emprestimo.ControllerEmprestimo;
import listing.ControllerListing;
import usuario.ControllerUsuario;

public class Fachada {
	public static void main(String[] args) {
		args = new String[] { "fachada.Fachada", "Acceptance_test/us1_test.txt.txt", "Acceptance_test/us2_test.txt.txt",
				"Acceptance_test/us3_test.txt.txt", "Acceptance_test/us4_test.txt.txt",
				"Acceptance_test/us5_test.txt.txt", "Acceptance_test/us6_test.txt.txt",
				"Acceptance_test/us7_test.txt.txt", "Acceptance_test/us8_test.txt.txt" };
		EasyAccept.main(args);
	}

	private ControllerListing pesquisa = new ControllerListing();
	public ControllerEmprestimo controllerEmprestimo = new ControllerEmprestimo();
	public ControllerUsuario usuarioController = new ControllerUsuario();

	/**
	 * Metodo inicializa sistema e recupera os arquivos gravados quando o sistema fechou pela última vez.
	 */
	public void iniciarSistema() {
		usuarioController.recuperaUsuarios("Usuarios.ser");
		controllerEmprestimo.recuperaEmprestimos("Emprestimos.ser");
	}
	/**
	 * Metodo fecha sistema, e guarda os dados do sistema, atualizados, em arquivos.
	 */
	public void fecharSistema() {
		usuarioController.gravaUsuarios(usuarioController.getUsuarios(), "Usuarios.ser");
		controllerEmprestimo.gravaEmprestimos(controllerEmprestimo.getEmprestimos(), "Emprestimos.ser");
	}

	/**
	 * Metodo cadastra usuario
	 * 
	 * @param nome nome do usuario
	 * @param email email do usuario
	 * @param celular celular do usuario
	 * @return
	 * @throws IOException 
	 * @throws Exception os tratamentos estao na classe itens
	 */
	public String cadastrarUsuario(String nome, String email, String celular) throws IOException {
		usuarioController.CadastrarUsuario(nome, email, celular);
		return email;
	}

	/**
	 * Metodo pesquisa os usuarios apartir do seu nome e celular, parametros que
	 * compoe a chave
	 * 
	 * @param nome nome do usuario
	 * @param celular celular do usuario
	 * @return representacao textual do usuario
	 */
	public String PesquisarUsuario(String nome, String celular) {
		return usuarioController.PesquisarUsuario(nome, celular);
	}

	/**
	 * Metodo pesquisa os usuarios apartir do seu nome e celular, parametros que
	 * compoe a chave, e fornece informacoes especificas dos usuarios.
	 * 
	 * @param nome nome do usuario
	 * @param celular celualar do usuario
	 * @param atributo atributo que se deseja obter do usuario em questao
	 * @return representaocao textual do atributo desejado
	 * @throws Exception
	 */
	public String getInfoUsuario(String nome, String celular, String atributo) {
		return usuarioController.getInfoUsuario(nome, celular, atributo);
	}

	/**
	 * Metodo remove usuario
	 * 
	 * @param nome nome do usuario
	 * @param celular celular do usuario
	 * @throws Exception
	 */
	public void removerUsuario(String nome, String celular) {
		usuarioController.removerUsuario(nome, celular);
	}

	/**
	 * Metodo edita algum atributo do usuario, atributo este informado, assim como o
	 * seu novo valor.
	 * 
	 * @param nome nome do usuario
	 * @param celular celualar do usuario
	 * @param atributo atributo a ser modificado
	 * @param valor valor do atributo modificado
	 * @throws Exception
	 */
	public void atualizarUsuario(String nome, String celular, String atributo, String valor) {
		usuarioController.AtualizarUsuario(nome, celular, atributo, valor);
	}

	/**
	 * Metodo cadastra um bluray de filme
	 * 
	 * @param nome nome do usuario
	 * @param celular celular do usuario
	 * @param nomeItem nome do item
	 * @param preco preco do item
	 * @param duracao duracao do emprestimo
	 * @param genero genero do filme
	 * @param classificacao classificacao do filme
	 * @param anoLancamento ano de lancamento do filme
	 * @throws Exception
	 */
	public void cadastrarBluRayFilme(String nome, String celular, String nomeItem, double preco, int duracao,
			String genero, String classificacao, int anoLancamento) {
		usuarioController.cadastrarBluRayFilme(nome, celular, nomeItem, preco, duracao, genero, classificacao,
				anoLancamento);
	}

	/**
	 * Metodo cadastra bluray de show
	 * 
	 * @param nome nome do usuario
	 * @param celular celular do usuario
	 * @param nomeItem nome do show(evento)
	 * @param preco preco do item
	 * @param duracao duracao do show
	 * @param numeroFaixas numero de musicas do show
	 * @param artista nome do artista
	 * @param classificacao classificacao do show
	 * @throws Exception
	 */
	public void cadastrarBluRayShow(String nome, String celular, String nomeItem, double preco, int duracao,
			int numeroFaixas, String artista, String classificacao) {
		usuarioController.cadastrarBluRayShow(nome, celular, nomeItem, preco, duracao, numeroFaixas, artista,
				classificacao);
	}

	/**
	 * Metodo cadastra bluray serie
	 * 
	 * @param nome nome do usuario
	 * @param telefone telefone do usuario
	 * @param nomeItem nome da serie
	 * @param preco preco do item
	 * @param descricao descricao do dono do bluray sobre a serie
	 * @param duracao duracao da serie
	 * @param classificacao classificacao da seirie
	 * @param genero genero da serie
	 * @param temporada temporada da serie
	 * @throws Exception
	 */
	public void cadastrarBluRaySerie(String nome, String telefone, String nomeItem, double preco, String descricao,
			int duracao, String classificacao, String genero, int temporada) {
		usuarioController.cadastrarBluRaySerie(nome, telefone, nomeItem, preco, descricao, duracao, classificacao,
				genero, temporada);
	}

	/**
	 * Metodo adiciona bluray de episodio em um bluray de serie. O bluray de
	 * episodio e representado somente por sua duracao.
	 * 
	 * @param nome nome do usuario
	 * @param telefone telefone do usuario
	 * @param nomeBlurayTemporada nome do bluray de serie que o episodio pertence
	 * @param duracao duracao do episodio
	 * @throws Exception
	 */
	public void adicionarBluRay(String nome, String telefone, String nomeBlurayTemporada, int duracao) {
		usuarioController.adicionarBluRay(nome, telefone, nomeBlurayTemporada, duracao);
	}

	/**
	 * Metodo cadastra um jogo eletronico
	 * 
	 * @param nome nome do usuario
	 * @param celular celular do usuario
	 * @param nomeItem nome do jogo eletronico
	 * @param preco preco do jogo eletronico
	 * @param plataforma plataforma em que o jogo eletronico funciona
	 * @throws Exception
	 */
	public void cadastrarEletronico(String nome, String celular, String nomeItem, double preco, String plataforma) {
		usuarioController.cadastrarEletronico(nome, celular, nomeItem, preco, plataforma);
	}

	/**
	 * Cadastra jogo de tabuleiro
	 * 
	 * @param nome nome do usuario
	 * @param celular do usuario
	 * @param nomeItem nome do jogo de tabuleiro
	 * @param preco preco do jogo de tabuleiro
	 * @throws Exception
	 */
	public void cadastrarJogoTabuleiro(String nome, String celular, String nomeItem, double preco) {
		usuarioController.cadastrarJogoTabuleiro(nome, celular, nomeItem, preco);
	}

	/**
	 * Metodo fornece informacoes especificas de um item
	 * 
	 * @param nome nome do usuario
	 * @param celular celular do usuario
	 * @param nomeItem nome do item que se quer obter informacao
	 * @param atributo que se quer ter informacao
	 * @return
	 * @throws Exception
	 */
	public String getInfoItem(String nome, String celular, String nomeItem, String atributo) {
		return usuarioController.getInfoItem(nome, celular, nomeItem, atributo);
	}

	/**
	 * Metodo adiciona peca que foi perdida, de um jogo de tabuleiro.
	 * 
	 * @param nome nome do usuario
	 * @param telefone telefone do usuario
	 * @param nomeItem nome do jogo de tabuleiro que se perdeu a peca
	 * @param nomePeca nome da peca perdida
	 * @throws Exception
	 */
	public void adicionarPecaPerdida(String nome, String telefone, String nomeItem, String nomePeca) {
		usuarioController.adicionarPecaPerdida(nome, telefone, nomeItem, nomePeca);
	}

	/**
	 * Metodo remove item a ser emprestado
	 * 
	 * @param nome nome do usuario
	 * @param celular celular do usuario
	 * @param nomeItem nome do item a ser removido
	 * @throws Exception
	 */
	public void removerItem(String nome, String celular, String nomeItem) {
		usuarioController.removerItem(nome, celular, nomeItem);
	}

	/**
	 * Metodo atualiza informacoes de um item
	 * 
	 * @param nome nome do usuario
	 * @param celular celular do usuario
	 * @param nomeItem nome do item que se quer atualizar informacoes
	 * @param atributo atributo que se quer atualizar nos itens
	 * @param valor valor do atributo atualizado(modificado)
	 * @throws Exception
	 */
	public void atualizarItem(String nome, String celular, String nomeItem, String atributo, String valor) {
		usuarioController.atualizarItem(nome, celular, nomeItem, atributo, valor);
	}

	/**
	 * Metodo lista Itens ordenados por ordem alfabetica
	 * 
	 * @return lista lista de itens em ordem alfabetica
	 */
	public String listarItensOrdenadosPorNome() {
		return pesquisa.listaItensUsuariosNome(usuarioController.getUsuarios());
	}

	/**
	 * Metodo lista itens pelo valor do item
	 * 
	 * @return itens listados por valor
	 */
	public String listarItensOrdenadosPorValor() {
		return pesquisa.listaItensUsuariosValor(usuarioController.getUsuarios());
	}

	/**
	 * Metodo pesquisa detalhes de um item
	 * 
	 * @param nome nome do usuario
	 * @param telefone telefone do usuario
	 * @param nomeItem nome do item a ser pesquisado
	 * @return representacao textual do item pesquisado
	 */
	public String pesquisarDetalhesItem(String nome, String telefone, String nomeItem) {
		return pesquisa.pesquisarDetalhesItem(usuarioController.getUsuarios(), nome, telefone, nomeItem);
	}

	/**
	 * Metodo registra emprestimo
	 * 
	 * @param nomeDono nome do dono do item
	 * @param telefoneDono telefone do dono do item
	 * @param nomeRequerente nome do requerente do item
	 * @param telefoneRequerente telefone do requerente do item
	 * @param nomeItem nome do item a ser emprestado
	 * @param dataEmprestimo data em que o emprestimo foi feito
	 * @param periodo periodo em que o item permanecera emprestado
	 * @throws IOException 
	 * @throws Exception 
	 */
	public void registrarEmprestimo(String nomeDono, String telefoneDono, String nomeRequerente,
			String telefoneRequerente, String nomeItem, String dataEmprestimo, int periodo) throws IOException {
		controllerEmprestimo.registrarEmprestimo(nomeDono, telefoneDono, nomeRequerente, telefoneRequerente, nomeItem,
				dataEmprestimo, periodo, usuarioController.getUsuarios());

	}

	/**
	 * Metodo devolve item que estava emprestado
	 * 
	 * @param nomeDono nome do dono do item
	 * @param telefoneDono telefone do dono do item
	 * @param nomeRequerente nome do requerente do item
	 * @param telefoneRequerente telefone do requerente do item
	 * @param nomeItem nome do item a ser emprestado
	 * @param dataEmprestimo data em que o emprestimo foi feito
	 * @param dataDevolucao data de devolucao do item emprestado
	 */
	public void devolverItem(String nomeDono, String telefoneDono, String nomeRequerente, String telefoneRequerente,
			String nomeItem, String dataEmprestimo, String dataDevolucao) {
		controllerEmprestimo.devolverItem(nomeDono, telefoneDono, nomeRequerente, telefoneRequerente, nomeItem,
				dataEmprestimo, dataDevolucao, usuarioController);

	}

	/**
	 * 
	 * @param nome
	 * @param telefone
	 */
	public String listarEmprestimosUsuarioEmprestando(String nome, String telefone) {
		return usuarioController.listaEmprestimosEmprestando(nome, telefone);

	}

	/**
	 * 
	 * @param nome
	 * @param telefone
	 */
	public String listarEmprestimosUsuarioPegandoEmprestado(String nome, String telefone) {
		return usuarioController.listaEmprestimosPegos(nome, telefone);
	}

	/**
	 * 
	 * @param nomeItem
	*/
	public String listarEmprestimosItem(String nomeItem) {
		return pesquisa.listarEmprestimosItem(usuarioController.getUsuarios(), nomeItem);
	}

	/**
	 * Lista itens que estao disponiveis no momento
	 * 
	 */
	public String listarItensNaoEmprestados() {
		return pesquisa.listarItensNaoEmprestados(usuarioController.getUsuarios());
	}

	/**
	 * Lista os itens emprestados no momento
	 *
	 */
	public String listarItensEmprestados() {
		return pesquisa.listarItensEmprestados(usuarioController.getUsuarios());
	}

	/**
	 * Lista os dez itens que mais foram requisitados
	 * 
	 */
	public String listarTop10Itens() {
		return pesquisa.listaTop10itens(usuarioController.getUsuarios());
	}
	
	/**
	 * Lista todos os usuarios que possuem reputacao negativa
	 * 
	 */
	public String listarCaloteiros(){
		return pesquisa.listarCaloteiros(usuarioController.getUsuarios());
	}
	
	/**
	 * Lista os dez melhores usuarios em reputacao
	 * 
	 */
	public String listarTop10MelhoresUsuarios(){
		return pesquisa.listarTop10MelhoresUsuarios(usuarioController.getUsuarios());
	}
	
	/**
	 * Lista os dez piores usuarios em reputacao
	 * 
	 */
	public String listarTop10PioresUsuarios(){
		return pesquisa.listarTop10PioresUsuarios(usuarioController.getUsuarios());
	}	
	
	}
