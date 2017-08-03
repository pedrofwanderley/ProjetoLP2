package itens;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class JogoEletronicoTest {

	private JogoEletronico jogoEletronico1;
	private JogoEletronico jogoEletronico2;
	private JogoEletronico jogoEletronico3;
	private JogoEletronico jogoEletronico4;
	private JogoEletronico jogoEletronico5;
	
	@Before
	public void inicializaJogosEletronicos() throws Exception{
		jogoEletronico1 = new JogoEletronico("God of War", 70.83, "PS2");
		jogoEletronico2 = new JogoEletronico("Mario", 40.26, "PC");
		jogoEletronico3 = new JogoEletronico("Mario", 50.47, "PC");
		jogoEletronico4 = new JogoEletronico("God of War", 70.83, "PC");
		jogoEletronico5 = new JogoEletronico("Bomber Man", 70.83, "PS2");
	}
	
	@Test
	public void testConstrutor() {
		assertEquals("God of War", jogoEletronico1.getNomeItem());
		assertEquals(70.83, jogoEletronico1.getValor(), 0.001);
		assertEquals("PS2", jogoEletronico1.getPlataforma());
	}

	
	@Test(expected = NullPointerException.class)
	public void testPlataformaNull() throws Exception{
		jogoEletronico1 = new JogoEletronico("God of War", 70.83, null);
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testPlataformaInvalida() throws Exception{
		jogoEletronico1 = new JogoEletronico("God of War", 70.83, "");
	}
	
	@Test
	public void testEquals(){
		assertTrue(jogoEletronico2.equals(jogoEletronico3));
		assertFalse(jogoEletronico1.equals(jogoEletronico4));
		assertFalse(jogoEletronico1.equals(jogoEletronico5));
	}
	
}
