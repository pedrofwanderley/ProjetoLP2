package itens;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BlurayFilmeTest {

	BlurayFilme blurayFilme;
	
	@Before
	public void inicializaBlurayFilme() throws Exception{
		blurayFilme = new BlurayFilme("CDZ", 50.60, 60, "Infantil", "Fantasia", 1995);
	}
	
	@Test
	public void testConstrutor() {
		assertEquals("CDZ", blurayFilme.getNomeItem());
		assertEquals(50.60, blurayFilme.getValor(), 0.001);
		assertEquals(60, blurayFilme.getDuracao());
		assertEquals("Infantil", blurayFilme.getClassificacao());
		assertEquals("Fantasia", blurayFilme.getGenero());
		assertEquals(1995, blurayFilme.getAnoDeLancamento());
	}

	
	@Test(expected = IllegalArgumentException.class)
	public void testAnoInvalidoZedo() throws Exception{
		blurayFilme = new BlurayFilme("CDZ", 50.60, 60, "Infantil", "Fantasia", 0);
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testAnoInvalidoNegativo() throws Exception{
		blurayFilme = new BlurayFilme("CDZ", 50.60, 60, "Infantil", "Fantasia", -5);
	}
	
	@Test(expected = NullPointerException.class)
	public void testGeneroNull() throws Exception{
		blurayFilme = new BlurayFilme("CDZ", 50.60, 60, "Infantil", null, 1995);
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testGeneroInvalida() throws Exception{
		blurayFilme = new BlurayFilme("CDZ", 50.60, 60, "Infantil", "", 1995);
	}
	
	@Test 
	public void testToString(){
		String resultadoEsperado = "FILME: CDZ, R$ 50.6, Nao emprestado, 60 min, Infantil, Fantasia, 1995";
		String resultado = blurayFilme.toString();
		
		assertEquals(resultadoEsperado, resultado);
	}
}
