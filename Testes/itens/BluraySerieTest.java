package itens;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BluraySerieTest {

	BluraySerie bluraySerie1;
	BluraySerie bluraySerie2;
	BluraySerie bluraySerie3;
	
	@Before
	public void inicializaBlurayTemporada() {
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
	public void testGeneroSerieInvalidoVazio() {
		bluraySerie1 = new BluraySerie("GoT", 100.53, "Guerra e mais guerra", 600, "Maiores de 18", "", 7);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGeneroSerieInvalidoVazioEspacos() {
		bluraySerie1 = new BluraySerie("GoT", 100.53, "Guerra e mais guerra", 600, "Maiores de 18", "        ", 7);
	}
	
	@Test(expected = NullPointerException.class)
	public void testGeneroSerieNull() {
		bluraySerie1 = new BluraySerie("GoT", 100.53, "Guerra e mais guerra", 600, "Maiores de 18", null, 7);
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testDescricaoSerieInvalidoVazio() {
		bluraySerie1 = new BluraySerie("GoT", 100.53, "", 600, "Maiores de 18", "Fantasia", 7);
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testDescricaoSerieInvalidoVazioEspacos() {
		bluraySerie1 = new BluraySerie("GoT", 100.53, "         ", 600, "Maiores de 18", "Fantasia", 7);
	}
	
	@Test(expected = NullPointerException.class)
	public void testDescricaoSerieNull() {
		bluraySerie1 = new BluraySerie("GoT", 100.53, null, 600, "Maiores de 18", null, 7);
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testNumeroDaTemporadaNegativo() {
		bluraySerie1 = new BluraySerie("GoT", 100.53, "Guerra e mais guerra", 600, "Maiores de 18", "Fantasia", -7);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testNumeroDaTemporadaZero() {
		bluraySerie1 = new BluraySerie("GoT", 100.53, "Guerra e mais guerra", 600, "Maiores de 18", "Fantasia", 0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testAdicionarBlurayInvalidoZero() {
		bluraySerie1.adicionarBluRay(0);
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testAdicionarBlurayInvalidoNegativo() {
		bluraySerie1.adicionarBluRay(-4);
	}
}
