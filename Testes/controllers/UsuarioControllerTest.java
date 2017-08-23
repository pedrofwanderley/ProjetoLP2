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
	ChaveUsuario chaveLucas;
	ChaveUsuario chavePedro;

	@Before
	public void setUp() {
		Usuario usuario = new Usuario("Lucas", "lucas@gmail.com", "12345");
		Usuario usuario2 = new Usuario("Pedro", "pedro@gmail.com", "67890");
		fachada = new Fachada();
		fachada.cadastrarUsuario(usuario.getNome(), usuario.getEmail(), usuario.getCelular());
		fachada.cadastrarUsuario(usuario2.getNome(), usuario2.getEmail(), usuario2.getCelular());
		
		fachada.cadastrarBluRayFilme("Lucas", "12345", "Resident Evil", 10.0, 100, "Terror", "16", 2000);
		fachada.cadastrarEletronico("Lucas", "12345", "FIFA17", 20.0, "PC");
		fachada.cadastrarBluRaySerie("Lucas", "12345", "Criminal Minds", 10.0, "investigacao", 200, "14", "Acao", 1);
		fachada.adicionarBluRay("Lucas", "12345", "Criminal Minds", 43);
		fachada.adicionarBluRay("Lucas", "12345", "Criminal Minds", 42);
		fachada.cadastrarJogoTabuleiro("Lucas", "12345", "Jumanji", 20.0);
		fachada.adicionarPecaPerdida("Lucas", "12345", "Jumanji", "Alguma");
		
		chaveLucas = new ChaveUsuario(usuario.getNome(), "12345");
		chavePedro = new ChaveUsuario(usuario2.getNome(), "67890");

	}

	@Test
	public void testCadastroUsuario() {
		assertEquals(true, fachada.usuarioController.getUsuarios().containsKey(chaveLucas));
	}

	@Test
	public void testAdicionaBluray() {
		BluraySerie br = (BluraySerie) fachada.usuarioController.getUsuarios().get(chaveLucas).getItens()
				.get("Criminal Minds");
		assertEquals(200, br.getDuracao());
	}

	@Test
	public void testCadastroBlurayFilme() {
		assertEquals(true,
				fachada.usuarioController.getUsuarios().get(chaveLucas).getItens().containsKey("Resident Evil"));
	}

	@Test
	public void testCadastroBluraySerie() {
		assertEquals(true,
				fachada.usuarioController.getUsuarios().get(chaveLucas).getItens().containsKey("Resident Evil"));
	}

	@Test
	public void testCadastroEletronico() {
		assertEquals(true,
				fachada.usuarioController.getUsuarios().get(chaveLucas).getItens().containsKey("Criminal Minds"));
	}

	@Test
	public void testCadastroJogoTabuleiro() {
		assertEquals(true, fachada.usuarioController.getUsuarios().get(chaveLucas).getItens().containsKey("Jumanji"));
	}

	@Test
	public void testAdicionaPecaPerdida() {
		assertEquals("20.0", fachada.usuarioController.getInfoItem("Lucas", "12345", "Jumanji", "Preco"));
	}

	@Test
	public void testAtualizaItem() {
		assertEquals("20.0", fachada.usuarioController.getInfoItem("Lucas", "12345", "Jumanji", "Preco"));
		fachada.atualizarItem("Lucas", "12345", "Jumanji", "Preco", "30.0");
		assertEquals("30.0", fachada.usuarioController.getInfoItem("Lucas", "12345", "Jumanji", "Preco"));
		fachada.atualizarItem("Lucas", "12345", "Jumanji", "Nome", "Zathura");
		assertEquals(true, fachada.usuarioController.getUsuarios().get(chaveLucas).getItens().containsKey("Zathura"));
		assertEquals("30.0", fachada.usuarioController.getInfoItem("Lucas", "12345", "Zathura", "Preco"));
	}

	@Test
	public void testAtualizaUsuario() {
		assertEquals("lucas@gmail.com", fachada.usuarioController.getInfoUsuario("Lucas", "12345", "email"));
		fachada.atualizarUsuario("Lucas", "12345", "email", "lucasanthony@gmail.com");
		assertEquals("lucasanthony@gmail.com", fachada.usuarioController.getInfoUsuario("Lucas", "12345", "email"));
	}

	@Test
	public void testRemoverItem() {
		fachada.removerItem("Lucas", "12345", "Jumanji");
		assertEquals(false, fachada.usuarioController.getUsuarios().get(chaveLucas).getItens().containsKey("Jumanji"));
	}

	@Test
	public void testRemoverUsuario() {
		fachada.removerUsuario("Lucas", "12345");
		assertEquals(false, fachada.usuarioController.getUsuarios().containsKey(chaveLucas));
	}
	
	@Test
	public void testAlteraReputacao() {
		assertEquals("Noob", fachada.usuarioController.getUsuarios().get(chaveLucas).getCartao());
		assertEquals("FreeRyder", fachada.usuarioController.getUsuarios().get(chavePedro).getCartao());
		
		fachada.registrarEmprestimo("Lucas", "12345", "Pedro", "67890", "Jumanji", "10/01/2017", 3);
		fachada.devolverItem("Lucas", "12345", "Pedro", "67890", "Jumanji", "10/01/2017", "15/01/2017");
		
		assertEquals("Caloteiro", fachada.usuarioController.getUsuarios().get(chavePedro).getCartao());
		
		fachada.cadastrarEletronico("Pedro", "67890", "GTA: SA", 200.0, "PC");
		
		assertEquals("Noob", fachada.usuarioController.getUsuarios().get(chavePedro).getCartao());
		
		fachada.removerItem("Pedro", "67890", "GTA: SA");
		
		assertEquals("Caloteiro", fachada.usuarioController.getUsuarios().get(chavePedro).getCartao());
		
		fachada.cadastrarEletronico("Pedro", "67890", "GTA IV", 200.0, "PC");
		fachada.cadastrarEletronico("Pedro", "67890", "GTA: V", 300.0, "PC");
		fachada.cadastrarEletronico("Pedro", "67890", "Resident Evil: Coleção Completa", 600.0, "PC");
		fachada.cadastrarEletronico("Pedro", "67890", "Gog of WAR 2", 1000.0, "PC");
		fachada.cadastrarBluRaySerie("Pedro", "67890", "HOUSE MD.", 500.0, "alguma coisa", 800, "14", "Drama", 7);
		
		assertEquals("BomAmigo", fachada.usuarioController.getUsuarios().get(chavePedro).getCartao());
	}
	
	@Test
    public void testListarItensEmprestando() {
        fachada.registrarEmprestimo("Lucas", "12345", "Pedro", "67890", "Jumanji", "10/01/2017", 3);
        assertEquals("Emprestimos: EMPRESTIMO - De: " + "Lucas" + ", Para: " + "Pedro" + ", "
                + "Jumanji" + ", " + "10/01/2017" + ", " + "3 " + "dias, ENTREGA: " + "Emprestimo em andamento" +
                "|", fachada.listarEmprestimosUsuarioEmprestando("Lucas","12345"));
    }
    
    @Test
    public void testListarItensPegandoEmprestado() {
        fachada.registrarEmprestimo("Lucas", "12345", "Pedro", "67890", "Resident Evil", "10/02/2017", 3);
        assertEquals("Emprestimos pegos: EMPRESTIMO - De: " + "Lucas" + ", Para: " + "Pedro" + ", " + "Resident Evil" +
        ", " + "10/02/2017" + ", " + "3" + " dias, ENTREGA: " + "Emprestimo em andamento" + "|",
        fachada.listarEmprestimosUsuarioPegandoEmprestado("Pedro","67890"));
    }
	//////////////// Testes de exceção \\\\\\\\\\\\\\\\\\\\
	
		@Test
	public void testCadastraUsuarioException() {
		Usuario usuario = new Usuario("Lucas", "lucas@gmail.com", "12345");
		try {
			fachada.cadastrarUsuario(usuario.getNome(), usuario.getEmail(), usuario.getCelular());
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Usuario ja cadastrado");
		}
	}
	
	@Test
	public void testAtualizaUsuarioException() {
		try {
			fachada.atualizarUsuario("Pedin", "1225", "email", "pedin@email");
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Usuario invalido");
		}
	}
	
	@Test
	public void removeItemException() {
		try {
			fachada.removerItem("Lucas", "12345", "abc");
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Item nao encontrado");
		}
	}
	
	@Test
	public void getInfoUsuarioException() {
		try {
			fachada.getInfoUsuario("Pedro", "12354", "email");
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Usuario invalido");
		}
	}

}
