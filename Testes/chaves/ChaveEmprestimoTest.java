package chaves;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ChaveEmprestimoTest {

	ChaveEmprestimo chave1;
	ChaveEmprestimo chave2;
	ChaveEmprestimo chave3;
	
	@Before
	public void inicializaChave() {
		chave1 = new ChaveEmprestimo("Guilherme", "Carlos", "89 91929394", 
				"89 95969798", "15/03/1997", "War");
		chave2 = new ChaveEmprestimo("Guilherme", "Carlos", "89 91929394", 
				"89 95969798", "15/03/1997", "War");
		chave3 = new ChaveEmprestimo("Dinorah", "Carlos", "89 91929394", 
				"89 95969798", "15/03/1997", "War");
	}
	
	@Test
	public void testeconstrutor() {
		assertEquals("Guilherme", chave1.getNomeDono());
		assertEquals("Carlos", chave1.getNomeRequerente());
		assertEquals("89 91929394", chave1.getTelefoneDono());
		assertEquals("89 95969798", chave1.getTelefoneRequerente());
		assertEquals("15/03/1997", chave1.getDataEmprestimo());
		assertEquals("War", chave1.getItem());
	}
	
	@Test
	public void testEquals() {
		// chaves sao iguais
		assertTrue(chave1.equals(chave2));
		
		// chaves tem nome do dono diferente
		assertFalse(chave1.equals(chave3));
	}

}
