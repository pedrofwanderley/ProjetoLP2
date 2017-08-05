package itens;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BlurayTemporadaTest {

	BlurayTemporada blurayTemporada;
	
	@Before
	public void inicializaBlurayTemporada() throws Exception{
		blurayTemporada = new BlurayTemporada("GoT", 100.53, null, 600, "Maiores de 18", "Fantasia", 7);
	}
	
	@Test
	public void testConstrutorBlurayTemporada() {
		assertEquals("GoT", blurayTemporada.getNomeItem());
		assertEquals(100.53, blurayTemporada.getValor(), 0.001);
		assertEquals(600, blurayTemporada.getDuracao());
		assertEquals("Maiores de 18", blurayTemporada.getClassificacao());
		assertEquals("Fantasia", blurayTemporada.getGeneroSerie());
		assertEquals(7, blurayTemporada.getNumeroDaTemporada());
	}

	
	
}
