import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import usuario.Usuario;

public class UsuarioTest {

	Usuario usuario1;
	Usuario usuario2;
	Usuario usuario3;
	Usuario usuario4;
	
	@Before
	public void inicializaUsuario() throws Exception {
		usuario1 = new Usuario("Guilherme", "89 91929395", "guilherme@email");
		usuario2 = new Usuario("Karla", "89 91929395", "karla@email");
		usuario3 = new Usuario("Guilherme", "89 79791212", "matheus@email");
		usuario4 = new Usuario("Guilherme", "89 91929395", "aleatorio@email");
	}
	
	
	@Test
	public void testConstrutor() {
		assertEquals("Guilherme", usuario1.getNome());
		assertEquals("89 91929395", usuario1.getCelular());
		assertEquals("guilherme@email", usuario1.getEmail());
	}
	
	
	@Test
	public void testEquals() {
		// Nome e numero iguais
		assertTrue(usuario1.equals(usuario4));
		
		// Nome diferente e numero iguais
		assertFalse(usuario1.equals(usuario2));
		
		//Nome igual e numero diferente
		assertFalse(usuario1.equals(usuario3));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testNomeInvalidoVazio() throws Exception {
		usuario1 = new Usuario("", "89 91929395", "guilherme@email");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testNomeInvalidoEspacos() throws Exception {
		usuario1 = new Usuario("       ", "89 91929395", "guilherme@email");
	}
	
	@Test(expected = NullPointerException.class)
	public void testNomeInvalidoNulo() throws Exception {
		usuario1 = new Usuario(null, "89 91929395", "guilherme@email");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCelularInvalidoVazio() throws Exception {
		usuario1 = new Usuario("Guilherme", "", "guilherme@email");
	}
	
	
	@Test(expected = NullPointerException.class)
	public void testCelularInvalidoNulo() throws Exception {
		usuario1 = new Usuario("Guilherme", null, "guilherme@email");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testEmailInvalidoVazio() throws Exception {
		usuario1 = new Usuario("Guilherme", "89 91929395", "");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testEmailInvalidoEspacos() throws Exception {
		usuario1 = new Usuario("Guilherme", "89 91929395", "");
	}
	
	@Test(expected = NullPointerException.class)
	public void testEmailInvalidoNulo() throws Exception {
		usuario1 = new Usuario("Guilherme", "89 91929395", null);
	}
	
	@Test
	public void testReputacaoNovoItem() {
		usuario1.reputacaoNovoItem(40.45);
		assertEquals(2.02, usuario1.getReputacao(), 0.1);
		
		usuario1.reputacaoNovoItem(111.37);
		assertEquals(7.6, usuario1.getReputacao(), 0.1);
	}
	
	@Test
	public void testReputacaoEmprestimoItem() {
		usuario1.reputacaoEmprestimoItem(100);
		assertEquals(10, usuario1.getReputacao(), 0.1);
		
		usuario1.reputacaoEmprestimoItem(200.57);
		assertEquals(30.06, usuario1.getReputacao(), 0.1);
	}
	
	@Test
	public void testReputacaoDevolucaoNoPrazo() {
		usuario1.reputacaoDevolucaoNoPrazo(100);
		assertEquals(5, usuario1.getReputacao(), 0.1);
		
		usuario1.reputacaoDevolucaoNoPrazo(200.57);
		assertEquals(15.03, usuario1.getReputacao(), 0.1);
	}
	
	@Test
	public void testReputacaoDevolucaoForaDoPrazo() {
		//reputacao do usuario e inicialmente 30.0
		usuario1.reputacaoEmprestimoItem(300);
		
		//reputacao continua positiva
		usuario1.reputacaoDevolucaoForaDoPrazo(100, 2);
		assertEquals(28, usuario1.getReputacao(), 0.1);
		
		// reputacao torna - se negativa
		usuario1.reputacaoDevolucaoForaDoPrazo(1000, 10);
		assertEquals(-72, usuario1.getReputacao(), 0.1);
		
		// reputacao continua negativa
		usuario1.reputacaoDevolucaoForaDoPrazo(500, 1);
		assertEquals(-77, usuario1.getReputacao(), 0.1);
	}
}
