import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UsuarioControllerTest {

	Fachada fachada;

	@Before
	public void setUp() throws Exception {
		fachada = new Fachada();
		fachada.cadastrarUsuario("Lucas", "Lucas@gmail.com", "12345");
		fachada.cadastrarUsuario("Pedro", "Pedro@gmail.com", "24680");
		fachada.cadastrarBluRayFilme("Lucas", "12345", "Resident Evil", 10.0, 100, "Terror", "16", 2000);
		fachada.cadastrarBluRayFilme("Lucas", "12345", "Resident Evil 2", 10.0, 93, "Terror", "16", 2004);
		fachada.cadastrarBluRayFilme("Lucas", "12345", "Resident Evil 3", 10.0, 110, "Terror", "16", 2006);

	}

	@Test
	public void test() {
		assertEquals(10.0, 0.1,
				fachada.usuarioController.getUsuarios().get("Lucas").getItens().get("Resident Evil").getValor());
	}

}
