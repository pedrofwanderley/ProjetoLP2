package itens;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BlurayTemporadaTest {

	BlurayTemporada blurayTemporada1;
	BlurayTemporada blurayTemporada2;
	BlurayTemporada blurayTemporada3;
	
	@Before
	public void inicializaBlurayTemporada() throws Exception{
		blurayTemporada1 = new BlurayTemporada("GoT", 100.53, "Guerra e mais guerra", 600, "Maiores de 18", "Fantasia", 7);
		
	}
	
	@Test
	public void testConstrutorBlurayTemporada() {
		assertEquals("GoT", blurayTemporada1.getNomeItem());
		assertEquals(100.53, blurayTemporada1.getValor(), 0.001);
		assertEquals("Guerra e mais guerra", blurayTemporada1.getDescricao());
		assertEquals(600, blurayTemporada1.getDuracao());
		assertEquals("Maiores de 18", blurayTemporada1.getClassificacao());
		assertEquals("Fantasia", blurayTemporada1.getGeneroSerie());
		assertEquals(7, blurayTemporada1.getNumeroDaTemporada());
	}

	
	@Test(expected = IllegalArgumentException.class)
	public void testGeneroSerieInvalido() throws Exception{
		blurayTemporada1 = new BlurayTemporada("GoT", 100.53, "Guerra e mais guerra", 600, "Maiores de 18", "", 7);
	}
	
	
	@Test(expected = NullPointerException.class)
	public void testGeneroSerieNull() throws Exception{
		blurayTemporada1 = new BlurayTemporada("GoT", 100.53, "Guerra e mais guerra", 600, "Maiores de 18", null, 7);
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testDescricaoSerieInvalido() throws Exception{
		blurayTemporada1 = new BlurayTemporada("GoT", 100.53, "", 600, "Maiores de 18", "", 7);
	}
	
	
	@Test(expected = NullPointerException.class)
	public void testDescricaoSerieNull() throws Exception{
		blurayTemporada1 = new BlurayTemporada("GoT", 100.53, null, 600, "Maiores de 18", null, 7);
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testNumeroDaTemporadaNegativo() throws Exception{
		blurayTemporada1 = new BlurayTemporada("GoT", 100.53, "Guerra e mais guerra", 600, "Maiores de 18", "Fantasia", -7);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testNumeroDaTemporadaZero() throws Exception{
		blurayTemporada1 = new BlurayTemporada("GoT", 100.53, "Guerra e mais guerra", 600, "Maiores de 18", "Fantasia", 0);
	}
}
