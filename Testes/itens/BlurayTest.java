package itens;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BlurayTest {

	Bluray bluray1;
	
	
	@Before
	public void inicializa() throws Exception{
		bluray1 = new Bluray("CDZ", 50.60, 60, "Infantil");
	}
	
	@Test
	public void testConstrutor(){
		assertEquals("CDZ", bluray1.getNomeItem());
		assertEquals(50.60, bluray1.getValor(), 0.001);
		assertEquals(60, bluray1.getDuracao());
		assertEquals("Infantil", bluray1.getClassificacao());
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testDuracaoInvalidoZedo() throws Exception{
		bluray1 = new Bluray("CDZ", 50.60, 0, "Infantil");
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testDuracaoInvalidoNegativo() throws Exception{
		bluray1 = new Bluray("CDZ", 50.60, -5, "Infantil");
	}
	
	@Test(expected = NullPointerException.class)
	public void testClassificacaoNull() throws Exception{
		bluray1 = new Bluray("CDZ", 50.60, 60, null);
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testClassificacaoInvalida() throws Exception{
		bluray1 = new Bluray("CDZ", 50.60, 60, "");
	}
	
	
}
