package itens;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BluraySerieTest {

	BluraySerie bluraySerie1;
	BluraySerie bluraySerie2;
	BluraySerie bluraySerie3;
	
	@Before
	public void inicializaBlurayTemporada() throws Exception{
		bluraySerie1 = new BluraySerie("GoT", 100.53, "Guerra e mais guerra", 600, "Maiores de 18", "Fantasia", 7);
		
	}
	
	@Test
	public void testConstrutorBlurayTemporada() {
		assertEquals("GoT", bluraySerie1.getNomeItem());
		assertEquals(100.53, bluraySerie1.getValor(), 0.001);
		assertEquals("Guerra e mais guerra", bluraySerie1.getDescricao());
		assertEquals(600, bluraySerie1.getDuracao());
		assertEquals("Maiores de 18", bluraySerie1.getClassificacao());
		assertEquals("Fantasia", bluraySerie1.getGeneroSerie());
		assertEquals(7, bluraySerie1.getNumeroDaTemporada());
	}

	
	@Test(expected = IllegalArgumentException.class)
	public void testGeneroSerieInvalido() throws Exception{
		bluraySerie1 = new BluraySerie("GoT", 100.53, "Guerra e mais guerra", 600, "Maiores de 18", "", 7);
	}
	
	
	@Test(expected = NullPointerException.class)
	public void testGeneroSerieNull() throws Exception{
		bluraySerie1 = new BluraySerie("GoT", 100.53, "Guerra e mais guerra", 600, "Maiores de 18", null, 7);
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testDescricaoSerieInvalido() throws Exception{
		bluraySerie1 = new BluraySerie("GoT", 100.53, "", 600, "Maiores de 18", "", 7);
	}
	
	
	@Test(expected = NullPointerException.class)
	public void testDescricaoSerieNull() throws Exception{
		bluraySerie1 = new BluraySerie("GoT", 100.53, null, 600, "Maiores de 18", null, 7);
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testNumeroDaTemporadaNegativo() throws Exception{
		bluraySerie1 = new BluraySerie("GoT", 100.53, "Guerra e mais guerra", 600, "Maiores de 18", "Fantasia", -7);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testNumeroDaTemporadaZero() throws Exception{
		bluraySerie1 = new BluraySerie("GoT", 100.53, "Guerra e mais guerra", 600, "Maiores de 18", "Fantasia", 0);
	}
	
	@Test
	public void testAdicionarBluray(){
		
	}
}
