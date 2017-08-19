package chaves;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ChaveUsuarioTest {

	ChaveUsuario chave1;
	ChaveUsuario chave2;
	ChaveUsuario chave3;
	ChaveUsuario chave4;
	
	@Before
	public void inicializaChaveUsuario() {
		chave1 = new ChaveUsuario("Guilherme", "89 91929394");
		chave2 = new ChaveUsuario("Guilherme", "89 91929394");
		chave3 = new ChaveUsuario("Matheus", "89 91929394");
		chave4 = new ChaveUsuario("Guilherme", "83 95969798");
	}
	
	@Test
	public void testConstrutor() {
		assertEquals("Guilherme", chave1.getNome());
		assertEquals("89 91929394", chave1.getCelular());
	}
	
	@Test
	public void test() {
		// nome e telefone iguais
		assertTrue(chave1.equals(chave2));
		
		// nome diferente e telefone iguais
		assertFalse(chave1.equals(chave3));
		
		// nome igual e telefone diferente
		assertFalse(chave1.equals(chave4));
	}

}
