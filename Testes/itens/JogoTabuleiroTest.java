package itens;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class JogoTabuleiroTest {

	JogoTabuleiro jogoTabuleiro1;
	JogoTabuleiro jogoTabuleiro2;
	
	@Before
	public void inicializaJogoTabuleiro() throws Exception{
		jogoTabuleiro1 = new JogoTabuleiro("War", 100.55);
		jogoTabuleiro2 = new JogoTabuleiro("Banco Imobiliario", 99.77);
	}
	
	
	@Test
	public void testConstrutorJogoTabuleiro() {
		assertEquals("War", jogoTabuleiro1.getNomeItem());
		assertEquals(100.55, jogoTabuleiro1.getValor(), 0.001);
	}

	
	@Test
	public void testEquals(){
		
	}
}
