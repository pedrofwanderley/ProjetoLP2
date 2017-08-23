package itens;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BlurayShowTest {

	BlurayShow blurayShow;
	
	@Before
	public void inicializaBlurayShow() {
		blurayShow = new BlurayShow("SOAD - Live in Rock in Rio", 100.89, 127, 15, "SOAD", "Show de Rock");
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
	public void testNumeroDefaixasInvalidoZedo() {
		blurayShow = new BlurayShow("SOAD - Live in Rock in Rio", 100.89, 127, 0, "SOAD", "Show de Rock");
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testNumerodeFaixasInvalidoNegativo() {
		blurayShow = new BlurayShow("SOAD - Live in Rock in Rio", 100.89, 127, -7, "SOAD", "Show de Rock");
	}

	
	@Test(expected = NullPointerException.class)
	public void testNomeDoArtistaNull() {
		blurayShow = new BlurayShow("SOAD - Live in Rock in Rio", 100.89, 127, 15, null, "Show de Rock");
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testNomeDoArtistaInvalidaVazia() {
		blurayShow = new BlurayShow("SOAD - Live in Rock in Rio", 100.89, 127, 15, "", "Show de Rock");
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testNomeDoArtistaInvalidaVaziaEspacos() {
		blurayShow = new BlurayShow("SOAD - Live in Rock in Rio", 100.89, 127, 15, "       ", "Show de Rock");
	}
	
	
	@Test
	public void testToString(){
		String resultadoEsperado = "SHOW: SOAD - Live in Rock in Rio, R$ 100.89, Nao emprestado, 127 min, Show de Rock, SOAD, 15 faixas";
		String resultado = blurayShow.toString();
		
		assertEquals(resultado, resultadoEsperado);
	}
}
