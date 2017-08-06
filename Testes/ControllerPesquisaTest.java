import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ControllerPesquisaTest {

	private ControllerPesquisa pesquisa;
	private UsuarioController usuarioController;
	private Usuario usuario;

	@Before
	public void controllerPesquisa() throws Exception {
		pesquisa = new ControllerPesquisa();
		usuario = new Usuario("Pedro", "0000-0000", "projeto@gmail.com");
		usuarioController = new UsuarioController();

	}

	@Test
	public void testListaItensUsuariosNome() throws Exception {
		usuarioController.CadastrarUsuario(usuario.getNome(), usuario.getCelular(), usuario.getEmail());
		usuarioController.cadastrarBluRayFilme(usuario.getNome(), usuario.getCelular(), "A volta dos que nao foram",
				50.00, 140, "comedia", "12_ANOS", 2010);
		usuarioController.cadastrarBluRayFilme(usuario.getNome(), usuario.getCelular(), "Poeira em alto mar", 40.00,
				120, "comedia", "14_ANOS", 2012);

		assertEquals(
				"FILME: " + "A volta dos que nao foram" + ", R$ " + 50.00 + ", " + "Nao emprestado" + ", " + 140
						+ " min, " + "12_ANOS" + ", " + "comedia" + ", " + 2010 + "|" + "FILME: " + "Poeira em alto mar"
						+ ", R$ " + 40.00 + ", " + "Nao emprestado" + ", " + 120 + " min, " + "14_ANOS" + ", "
						+ "comedia" + ", " + 2012 + "|",
				pesquisa.listaItensUsuariosNome(usuarioController.getUsuarios()));
	}

	@Test
	public void testListaItensUsuariosValor() throws Exception {
		usuarioController.CadastrarUsuario(usuario.getNome(), usuario.getCelular(), usuario.getEmail());
		usuarioController.cadastrarBluRayFilme(usuario.getNome(), usuario.getCelular(), "A volta dos que nao foram",
				50.00, 140, "comedia", "12_ANOS", 2010);
		usuarioController.cadastrarBluRayFilme(usuario.getNome(), usuario.getCelular(), "Poeira em alto mar", 40.00,
				120, "comedia", "14_ANOS", 2012);

		assertEquals(
				"FILME: " + "Poeira em alto mar" + ", R$ " + 40.00 + ", " + "Nao emprestado" + ", " + 120 + " min, "
						+ "14_ANOS" + ", " + "comedia" + ", " + 2012 + "|" + "FILME: " + "A volta dos que nao foram"
						+ ", R$ " + 50.00 + ", " + "Nao emprestado" + ", " + 140 + " min, " + "12_ANOS" + ", "
						+ "comedia" + ", " + 2010 + "|",
				pesquisa.listaItensUsuariosValor(usuarioController.getUsuarios()));
	}

	@Test
	public void testPesquisarDetalhesItem() throws Exception {
		usuarioController.CadastrarUsuario(usuario.getNome(), usuario.getCelular(), usuario.getEmail());
		usuarioController.cadastrarBluRayFilme(usuario.getNome(), usuario.getCelular(), "A volta dos que nao foram",
				50.00, 140, "comedia", "12_ANOS", 2010);
		assertEquals(
				"FILME: " + "A volta dos que nao foram" + ", R$ " + 50.00 + ", " + "Nao emprestado" + ", " + 140
						+ " min, " + "12_ANOS" + ", " + "comedia" + ", " + 2010,
				pesquisa.pesquisarDetalhesItem(usuarioController.getUsuarios(), usuario.getNome(), usuario.getCelular(),
						"A volta dos que nao foram"));

	}

	@Test(expected = IllegalArgumentException.class)
	public void testPesquisaDetalhesItensItemException() {
		pesquisa.pesquisarDetalhesItem(usuarioController.getUsuarios(), usuario.getNome(), usuario.getCelular(),
				"A volta dos que nao foram");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testPesquisaDetalhesItensUsuarioException() throws Exception {
		usuarioController.cadastrarBluRayFilme(usuario.getNome(), usuario.getCelular(), "A volta dos que nao foram",
				50.00, 140, "comedia", "12_ANOS", 2010);
		pesquisa.pesquisarDetalhesItem(usuarioController.getUsuarios(), "Pedro", "9999-9999",
				"A volta dos que nao foram");
	}

}
