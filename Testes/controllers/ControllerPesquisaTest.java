package controllers;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import pesquisa.ControllerPesquisa;
import usuario.Usuario;
import usuario.UsuarioController;

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
		usuarioController.cadastrarBluRayShow(usuario.getNome(), usuario.getCelular(), "Arctic Monkeys live at Campina Grande",
				60.00, 67, 15, "Arctic Monkeys", "14_ANOS");

		assertEquals("FILME: " + "A volta dos que nao foram" + ", R$ " + 50.00 + ", " + "Nao emprestado" + ", " +
				 140 + " min, " + "12_ANOS" + ", " + "comedia" + ", " + 2010 + "|" +
				 	 "SHOW: "+ "Arctic Monkeys live at Campina Grande" + ", R$ " + 60.00 + ", " + "Nao emprestado" + ", " +
					67 + " min, " + "14_ANOS" + ", " +  "Arctic Monkeys" + ", " + 15 + " faixas" + "|" +
					"FILME: " + "Poeira em alto mar"+ ", R$ " + 40.00 + ", " + "Nao emprestado" + ", " + 
						120 + " min, " + "14_ANOS" + ", " + "comedia" + ", " + 2012 + "|",
				pesquisa.listaItensUsuariosNome(usuarioController.getUsuarios()));
	}

	@Test
	public void testListaItensUsuariosValor() throws Exception {
		usuarioController.CadastrarUsuario(usuario.getNome(), usuario.getCelular(), usuario.getEmail());
		usuarioController.cadastrarBluRayFilme(usuario.getNome(), usuario.getCelular(), "A volta dos que nao foram",
				50.00, 140, "comedia", "12_ANOS", 2010);
		usuarioController.cadastrarBluRayFilme(usuario.getNome(), usuario.getCelular(), "Poeira em alto mar", 40.00,
				120, "comedia", "14_ANOS", 2012);
		usuarioController.cadastrarEletronico(usuario.getNome(), usuario.getCelular(), "Tibia", 30.00, "PC");
		
	
		assertEquals( "JOGO ELETRONICO: " + "Tibia" + ", R$ " + 30.00 + ", " + "Nao emprestado" +
				", " + "PC" + "|" +
						"FILME: " + "Poeira em alto mar" + ", R$ " + 40.00 + ", " + "Nao emprestado" + ", " + 120 + " min, "
						+ "14_ANOS" + ", " + "comedia" + ", " + 2012 + "|" +
						"FILME: " + "A volta dos que nao foram"
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

	@Test
	public void testPesquisaDetalhesItensItemException() {
		try {
			usuarioController.CadastrarUsuario(usuario.getNome(), usuario.getCelular(), usuario.getEmail());
			pesquisa.pesquisarDetalhesItem(usuarioController.getUsuarios(), usuario.getNome(), usuario.getCelular(),
					"A volta dos que nao foram");
			
			
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Item nao encontrado");
		}
		
		
	}

	@Test
	public void testPesquisaDetalhesItensUsuarioException() throws Exception {
		
		try {
			usuarioController.cadastrarBluRayFilme(usuario.getNome(), usuario.getCelular(), "A volta dos que nao foram",
					50.00, 140, "comedia", "12_ANOS", 2010);
			pesquisa.pesquisarDetalhesItem(usuarioController.getUsuarios(), "Pedro", "9999-9999",
					"A volta dos que nao foram");
			
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Usuario invalido");
		}
	}

}
