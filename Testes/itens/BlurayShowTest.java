package itens;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BlurayShowTest {

	BlurayShow blurayShow;
	
	@Before
	public void inicializaBlurayShow() throws Exception{
		blurayShow = new BlurayShow("SOAD - Live in Rock in Rio", 100.89, 127, "Show de Rock", "SOAD", 15);
	}
	
	
	@Test
	public void testContrutor() {
		assertEquals("SOAD - Live in Rock in Rio", blurayShow.getNomeItem());
		assertEquals(100.89, blurayShow.getValor(), 0.001);
		assertEquals(127, blurayShow.getDuracao());
		assertEquals("Show de Rock", blurayShow.getClassificacao());
		assertEquals("SOAD", blurayShow.getNomeDoArtista());
		assertEquals(15, blurayShow.getNumeroDeFaixas());
	}


	@Test(expected = IllegalArgumentException.class)
	public void testNumeroDefaixasInvalidoZedo() throws Exception{
		blurayShow = new BlurayShow("SOAD - Live in Rock in Rio", 100.89, 127, "Show de Rock", "SOAD", 0);
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testNumerodeFaixasInvalidoNegativo() throws Exception{
		blurayShow = new BlurayShow("SOAD - Live in Rock in Rio", 100.89, 127, "Show de Rock", "SOAD", -7);
	}

	
	@Test(expected = NullPointerException.class)
	public void testNomeDoArtistaNull() throws Exception{
		blurayShow = new BlurayShow("SOAD - Live in Rock in Rio", 100.89, 127, "Show de Rock", null, 15);
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testNomeDoArtistaInvalida() throws Exception{
		blurayShow = new BlurayShow("SOAD - Live in Rock in Rio", 100.89, 127, "Show de Rock", "", 15);
	}
}