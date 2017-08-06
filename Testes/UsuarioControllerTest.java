import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UsuarioControllerTest {

	Fachada fachada;

	@Before
	public void setUp() throws Exception {
		Usuario usuario = new Usuario("Lucas", "Lucas@gmail.com", "12345");
		fachada = new Fachada();
		fachada.cadastrarUsuario(usuario.getNome(), usuario.getEmail(), usuario.getCelular());
		fachada.cadastrarBluRayFilme("Lucas", "12345", "Resident Evil", 10.0, 100, "Terror", "16", 2000);
		fachada.cadastrarEletronico("Lucas", "12345", "FIFA17", 20.0, "PC");
		fachada.cadastrarBluRaySerie("Lucas", "12345", "Criminal Minds", 10.0, "investigacao", 200, "14", "Acao", 1);
	}
	
	@Test
	public void testCadastroUsuario() {
		assertEquals(true,
				fachada.usuarioController.getUsuarios().containsKey("Lucas"));
	}

	@Test
	public void testCadastroBlurayFilme() {
		assertEquals(true,
				fachada.usuarioController.getUsuarios().get("Lucas").getItens().containsKey("Resident Evil"));
	}
	
	@Test
	public void testCadastroBluraySerie() {
		assertEquals(true,
				fachada.usuarioController.getUsuarios().get("Lucas").getItens().containsKey("Resident Evil"));
	}
	
	@Test
	public void testCadastroEletronico() {
		assertEquals(true, fachada.usuarioController.getUsuarios().get("Lucas").getItens().containsKey("Criminal Minds"));
	}
}
