package controllers;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import chaves.ChaveUsuario;
import fachada.Fachada;
import itens.BluraySerie;
import usuario.Usuario;

public class UsuarioControllerTest {

	Fachada fachada;
	ChaveUsuario chave;

	@Before
	public void setUp() throws Exception {
		Usuario usuario = new Usuario("Lucas", "lucas@gmail.com", "12345");
		fachada = new Fachada();
		fachada.cadastrarUsuario(usuario.getNome(), usuario.getEmail(), usuario.getCelular());
		fachada.cadastrarBluRayFilme("Lucas", "12345", "Resident Evil", 10.0, 100, "Terror", "16", 2000);
		fachada.cadastrarEletronico("Lucas", "12345", "FIFA17", 20.0, "PC");
		fachada.cadastrarBluRaySerie("Lucas", "12345", "Criminal Minds", 10.0, "investigacao", 200, "14", "Acao", 1);
		fachada.adicionarBluRay("Lucas", "12345", "Criminal Minds", 43);
		fachada.adicionarBluRay("Lucas", "12345", "Criminal Minds", 42);
		fachada.cadastrarJogoTabuleiro("Lucas", "12345", "Jumanji", 20.0);
		fachada.adicionarPecaPerdida("Lucas", "12345", "Jumanji", "Alguma");
		chave = new ChaveUsuario(usuario.getNome(), "12345");
		System.out.println(chave.toString());
	}

	@Test
	public void testCadastroUsuario() {
		assertEquals(true, fachada.usuarioController.getUsuarios().containsKey(chave));
	}

	@Test
	public void testAdicionaBluray() {
		BluraySerie br = (BluraySerie) fachada.usuarioController.getUsuarios().get(chave).getItens()
				.get("Criminal Minds");
		assertEquals(200, br.getDuracao());
	}

	@Test
	public void testCadastroBlurayFilme() {
		assertEquals(true,
				fachada.usuarioController.getUsuarios().get(chave).getItens().containsKey("Resident Evil"));
	}

	@Test
	public void testCadastroBluraySerie() {
		assertEquals(true,
				fachada.usuarioController.getUsuarios().get(chave).getItens().containsKey("Resident Evil"));
	}

	@Test
	public void testCadastroEletronico() {
		assertEquals(true,
				fachada.usuarioController.getUsuarios().get(chave).getItens().containsKey("Criminal Minds"));
	}

	@Test
	public void testCadastroJogoTabuleiro() {
		assertEquals(true, fachada.usuarioController.getUsuarios().get(chave).getItens().containsKey("Jumanji"));
	}

	@Test
	public void testAdicionaPecaPerdida() throws Exception {
		assertEquals("20.0", fachada.usuarioController.getInfoItem("Lucas", "12345", "Jumanji", "Preco"));
	}

	@Test
	public void testAtualizaItem() throws Exception {
		assertEquals("20.0", fachada.usuarioController.getInfoItem("Lucas", "12345", "Jumanji", "Preco"));
		fachada.atualizarItem("Lucas", "12345", "Jumanji", "Preco", "30.0");
		assertEquals("30.0", fachada.usuarioController.getInfoItem("Lucas", "12345", "Jumanji", "Preco"));
		fachada.atualizarItem("Lucas", "12345", "Jumanji", "Nome", "Zathura");
		assertEquals(true, fachada.usuarioController.getUsuarios().get(chave).getItens().containsKey("Zathura"));
		assertEquals("30.0", fachada.usuarioController.getInfoItem("Lucas", "12345", "Zathura", "Preco"));
	}

	@Test
	public void testAtualizaUsuario() throws Exception {
		assertEquals("lucas@gmail.com", fachada.usuarioController.getInfoUsuario("Lucas", "12345", "email"));
		fachada.atualizarUsuario("Lucas", "12345", "email", "lucasanthony@gmail.com");
		assertEquals("lucasanthony@gmail.com", fachada.usuarioController.getInfoUsuario("Lucas", "12345", "email"));
	}

	@Test
	public void testRemoverItem() throws Exception {
		fachada.removerItem("Lucas", "12345", "Jumanji");
		assertEquals(false, fachada.usuarioController.getUsuarios().get(chave).getItens().containsKey("Jumanji"));
	}

	@Test
	public void testRemoverUsuario() throws Exception {
		fachada.removerUsuario("Lucas", "12345");
		assertEquals(false, fachada.usuarioController.getUsuarios().containsKey(chave));
	}

	
	//////////////// Testes de exceção \\\\\\\\\\\\\\\\\\\\
	
		@Test
	public void testCadastraUsuarioException() throws Exception {
		Usuario usuario = new Usuario("Lucas", "lucas@gmail.com", "12345");
		try {
			fachada.cadastrarUsuario(usuario.getNome(), usuario.getEmail(), usuario.getCelular());
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Usuario ja cadastrado");
		}
	}
	
	@Test
	public void testAtualizaUsuarioException() throws Exception {
		try {
			fachada.atualizarUsuario("Pedin", "1225", "email", "pedin@email");
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Usuario invalido");
		}
	}
	
	@Test
	public void removeItemException() throws Exception {
		try {
			fachada.removerItem("Lucas", "12345", "abc");
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Item nao encontrado");
		}
	}
	
	@Test
	public void getInfoUsuarioException() throws Exception {
		try {
			fachada.getInfoUsuario("Pedro", "12354", "email");
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Usuario invalido");
		}
	}

}
