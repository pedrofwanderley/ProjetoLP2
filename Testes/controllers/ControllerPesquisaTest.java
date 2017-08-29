package controllers;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import emprestimo.ControllerEmprestimo;
import listing.ControllerListing;
import usuario.Usuario;
import usuario.ControllerUsuario;

public class ControllerPesquisaTest {

	private ControllerListing pesquisa;
	private ControllerUsuario usuarioController;
	private Usuario usuario, usuario2;
	private ControllerEmprestimo emprestimoController;
	@Before
	public void controllerPesquisa() {
		pesquisa = new ControllerListing();
		usuario = new Usuario("Pedro", "0000-0000", "projeto@gmail.com");
		usuario2 = new Usuario("Fulano", "9999-9999", "fulano@gmail.com");
		usuarioController = new ControllerUsuario();
		emprestimoController = new ControllerEmprestimo();

	}

	@Test
	public void testListaItensUsuariosNome() {
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
	public void testListaItensUsuariosValor() {
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
	public void testPesquisarDetalhesItem() {
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
    public void testListarEmprestimosItem() {
        usuarioController.CadastrarUsuario(usuario.getNome(), usuario.getCelular(), usuario.getEmail());
        usuarioController.CadastrarUsuario(usuario2.getNome(), usuario2.getCelular(), usuario2.getEmail());
        usuarioController.cadastrarBluRayFilme(usuario.getNome(), usuario.getCelular(), "A volta dos que nao foram",
                50.00, 140, "comedia", "12_ANOS", 2010);
        emprestimoController.registrarEmprestimo(usuario.getNome(), usuario.getCelular(), usuario2.getNome(),usuario2.getCelular(),
                "A volta dos que nao foram", "12/08/2017", 3, usuarioController.getUsuarios());
        assertEquals("Emprestimos associados ao item: " + "EMPRESTIMO - De: " +usuario.getNome() + ", Para: " + usuario2.getNome() + ", " +
                "A volta dos que nao foram" + ", " + "12/08/2017" + ", " + 3 + " dias, ENTREGA: " + "Emprestimo em andamento" + "|",
                pesquisa.listarEmprestimosItem(usuarioController.getUsuarios(), "A volta dos que nao foram"));
        
    }
    
    @Test
    public void testListarItensNaoEmprestados() {
        usuarioController.CadastrarUsuario(usuario.getNome(), usuario.getCelular(), usuario.getEmail());
        usuarioController.cadastrarBluRayFilme(usuario.getNome(), usuario.getCelular(), "A volta dos que nao foram",
                50.00, 140, "comedia", "12_ANOS", 2010);
        usuarioController.cadastrarBluRayFilme(usuario.getNome(), usuario.getCelular(), "Poeira em alto mar", 40.00,
                120, "comedia", "14_ANOS", 2012);
        usuarioController.cadastrarEletronico(usuario.getNome(), usuario.getCelular(), "Tibia", 30.00, "PC");
        assertEquals("FILME: " + "A volta dos que nao foram"
                + ", R$ " + 50.00 + ", " + "Nao emprestado" + ", " + 140 + " min, " + "12_ANOS" + ", "
                + "comedia" + ", " + 2010 + "|" + "FILME: " + "Poeira em alto mar" + ", R$ " + 40.00 + ", " + "Nao emprestado" + ", " + 120 + " min, "
                + "14_ANOS" + ", " + "comedia" + ", " + 2012 + "|" + "JOGO ELETRONICO: " + "Tibia" + ", R$ " + 30.00 + ", " + "Nao emprestado" +
                ", " + "PC" + "|", pesquisa.listarItensNaoEmprestados(usuarioController.getUsuarios()));
    }
    
    @Test
    public void testListarItensEmprestados() {
        usuarioController.CadastrarUsuario(usuario.getNome(), usuario.getCelular(), usuario.getEmail());
        usuarioController.CadastrarUsuario(usuario2.getNome(), usuario2.getCelular(), usuario2.getEmail());
        usuarioController.cadastrarBluRayFilme(usuario.getNome(), usuario.getCelular(), "A volta dos que nao foram",
                50.00, 140, "comedia", "12_ANOS", 2010);
        emprestimoController.registrarEmprestimo(usuario.getNome(), usuario.getCelular(), usuario2.getNome(),usuario2.getCelular(),
                "A volta dos que nao foram", "12/08/2017", 3, usuarioController.getUsuarios());
        assertEquals("Dono do item: " + usuario.getNome() + ", Nome do item emprestado: " + "A volta dos que nao foram" + "|", 
                pesquisa.listarItensEmprestados(usuarioController.getUsuarios()));
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
	public void testPesquisaDetalhesItensUsuarioException() {
		
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
