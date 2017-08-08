import easyaccept.EasyAccept;

public class Fachada {
	public static void main(String[] args) {
		args = new String[] { "Fachada", "Acceptance_test/us1_test.txt.txt", "Acceptance_test/us2_test.txt.txt",
				"Acceptance_test/us3_test.txt.txt", "Acceptance_test/us4_test.txt.txt" };
		EasyAccept.main(args);
	}

	private ControllerPesquisa pesquisa = new ControllerPesquisa();
	public ControllerEmprestimo controllerEmprestimo = new ControllerEmprestimo();
	public UsuarioController usuarioController = new UsuarioController();

	public void iniciarSistema() {
	}

	public void fecharSistema() {
	}

	public String cadastrarUsuario(String nome, String email, String celular) throws Exception {
		usuarioController.CadastrarUsuario(nome, email, celular);
		return email;
	}

	public String PesquisarUsuario(String nome) {
		return usuarioController.PesquisarUsuario(nome);
	}
	
	public String getInfoUsuario(String nome, String celular, String atributo) throws Exception {
		return usuarioController.getInfoUsuario(nome, celular, atributo);
	}

	public void removerUsuario(String nome, String celular) throws Exception {
		usuarioController.removerUsuario(nome, celular);
	}

	public void atualizarUsuario(String nome, String celular, String atributo, String valor) throws Exception {
		usuarioController.AtualizarUsuario(nome, celular, atributo, valor);
	}

	public void cadastrarBluRayFilme(String nome, String celular, String nomeItem, double preco, int duracao,
			String genero, String classificacao, int anoLancamento) throws Exception {
		usuarioController.cadastrarBluRayFilme(nome, celular, nomeItem, preco, duracao, genero, classificacao,
				anoLancamento);
	}

	public void cadastrarBluRayShow(String nome, String celular, String nomeItem, double preco, int duracao,
			int numeroFaixas, String artista, String classificacao) throws Exception {
		usuarioController.cadastrarBluRayShow(nome, celular, nomeItem, preco, duracao, numeroFaixas, artista,
				classificacao);
	}

	public void cadastrarBluRaySerie(String nome, String telefone, String nomeItem, double preco, String descricao,
			int duracao, String classificacao, String genero, int temporada) throws Exception {
		usuarioController.cadastrarBluRaySerie(nome, telefone, nomeItem, preco, descricao, duracao, classificacao,
				genero, temporada);
	}
	public void adicionarBluRay(String nome, String telefone, String nomeBlurayTemporada, int duracao){
		usuarioController.adicionarBluRay(nome, telefone, nomeBlurayTemporada, duracao);
	}

	public void cadastrarEletronico(String nome, String celular, String nomeItem, double preco, String plataforma)
			throws Exception {
		usuarioController.cadastrarEletronico(nome, celular, nomeItem, preco, plataforma);
	}

	public void cadastrarJogoTabuleiro(String nome, String celular, String nomeItem, double preco) throws Exception {
		usuarioController.cadastrarJogoTabuleiro(nome, celular, nomeItem, preco);
	}

	public String getInfoItem(String nome, String celular, String nomeItem, String atributo) throws Exception {
		return usuarioController.getInfoItem(nome, celular, nomeItem, atributo);
	}

	public void adicionarPecaPerdida(String nome, String telefone, String nomeItem, String nomePeca) throws Exception {
		usuarioController.adicionarPecaPerdida(nome, telefone, nomeItem, nomePeca);
	}

	public void removerItem(String nome, String celular, String nomeItem) throws Exception {
		usuarioController.removerItem(nome, celular, nomeItem);
	}

	public void atualizarItem(String nome, String celular, String nomeItem, String atributo, String valor)
			throws Exception {
		usuarioController.atualizarItem(nome, celular, nomeItem, atributo, valor);
	}

	public String listarItensOrdenadosPorNome() {
		return pesquisa.listaItensUsuariosNome(usuarioController.getUsuarios());
	}

	public String listarItensOrdenadosPorValor() {
		return pesquisa.listaItensUsuariosValor(usuarioController.getUsuarios());
	}

	public String pesquisarDetalhesItem(String nome, String telefone, String nomeItem) {
		return pesquisa.pesquisarDetalhesItem(usuarioController.getUsuarios(), nome, telefone, nomeItem);
	}
	public void registrarEmprestimo(String nomeDono, String telefoneDono, String nomeRequerente, String telefoneRequerente, 
			String nomeItem,String dataEmprestimo, int periodo) throws Exception{
		controllerEmprestimo.registrarEmprestimo(nomeDono, telefoneDono, nomeRequerente, telefoneRequerente, nomeItem,dataEmprestimo,  periodo, usuarioController.getUsuarios());
		
	}
	public void devolverItem(String nomeDono, String telefoneDono, String nomeRequerente, String telefoneRequerente, 
			String nomeItem, String dataEmprestimo, String dataDevolucao) throws Exception{
		controllerEmprestimo.devolverItem(nomeDono, telefoneDono, nomeRequerente, telefoneRequerente, nomeItem,dataEmprestimo,dataDevolucao, usuarioController);
		
	}
}
