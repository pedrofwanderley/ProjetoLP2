package itens;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class JogoTabuleiroTest {

	JogoTabuleiro jogoTabuleiro1;
	JogoTabuleiro jogoTabuleiro2;
	JogoTabuleiro jogoTabuleiro3;
	JogoTabuleiro jogoTabuleiro4;
	
	@Before
	public void inicializaJogoTabuleiro() throws Exception{
		jogoTabuleiro1 = new JogoTabuleiro("War", 100.55);
		jogoTabuleiro2 = new JogoTabuleiro("War Guerra Mundial", 5.43);
		jogoTabuleiro3 = new JogoTabuleiro("War", 90.55);
		jogoTabuleiro4 = new JogoTabuleiro("War", 100.55);
		
		jogoTabuleiro1.adicionarPecaPerdida("Carta Brasil");
		jogoTabuleiro1.adicionarPecaPerdida("Carta USA");
		jogoTabuleiro1.adicionarPecaPerdida("Carta Argentina");
		
		jogoTabuleiro3.adicionarPecaPerdida("Carta USA");
		jogoTabuleiro3.adicionarPecaPerdida("Carta Brasil");
		jogoTabuleiro3.adicionarPecaPerdida("Carta Argentina");
		
		jogoTabuleiro2.adicionarPecaPerdida("Carta USA");
		jogoTabuleiro2.adicionarPecaPerdida("Carta Brasil");
		jogoTabuleiro2.adicionarPecaPerdida("Carta Argentina");
		
		jogoTabuleiro4.adicionarPecaPerdida("Italia");
		jogoTabuleiro4.adicionarPecaPerdida("Asia");
		jogoTabuleiro4.adicionarPecaPerdida("Africa");
	}
	
	
	@Test
	public void testConstrutorJogoTabuleiro() {
		assertEquals("War", jogoTabuleiro1.getNomeItem());
		assertEquals(100.55, jogoTabuleiro1.getValor(), 0.001);
	}

	
	@Test
	public void testEquals(){
		//Mesmo nome e mesmas pecas perdidas, com ordem de adicao diferentes
		assertTrue(jogoTabuleiro1.equals(jogoTabuleiro3));
		
		//Mesmas pecas perdidas e nomes diferentes
		assertFalse(jogoTabuleiro1.equals(jogoTabuleiro2));
		
		//Mesmo nome e pecas perdidas diferentes
		assertFalse(jogoTabuleiro1.equals(jogoTabuleiro4));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testAdicionaPacaInvalidaVazia() throws Exception{
		jogoTabuleiro1.adicionarPecaPerdida("");
	}
	
	@Test(expected = NullPointerException.class)
	public void testAdicionaPacaInvalidaNull() throws Exception{
		jogoTabuleiro1.adicionarPecaPerdida(null);
	}
	
	
}
