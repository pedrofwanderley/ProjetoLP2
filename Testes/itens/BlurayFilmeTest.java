package itens;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BlurayFilmeTest {

	BlurayFilme blurayFilme;
	
	/**
	 * Inicializa objeto blurayFilme para utilizacao nos testes
	 * @throws Exception
	 */
	@Before
	public void inicializaBlurayFilme() throws Exception{
		blurayFilme = new BlurayFilme("CDZ", 50.60, 60, "Infantil", "Fantasia", 1995);
	}
	
	
	/**
	 * Testa Contrutor da classe BlurayFilme
	 */
	@Test
	public void testConstrutor() {
		assertEquals("CDZ", blurayFilme.getNomeItem());
		assertEquals(50.60, blurayFilme.getValor(), 0.001);
		assertEquals(60, blurayFilme.getDuracao());
		assertEquals("Infantil", blurayFilme.getClassificacao());
		assertEquals("Fantasia", blurayFilme.getGenero());
		assertEquals(1995, blurayFilme.getAnoDeLancamento());
	}

	
	/**
	 * Testa o caso em que o parametro ano e invalido, informado como sendo zero
	 * @throws Exception
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAnoInvalidoZedo() throws Exception{
		blurayFilme = new BlurayFilme("CDZ", 50.60, 60, "Infantil", "Fantasia", 0);
	}
	
	/**
	 * Testa o caso em que o parametro ano e invalido, informado como sendo negativo
	 * @throws Exception
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAnoInvalidoNegativo() throws Exception{
		blurayFilme = new BlurayFilme("CDZ", 50.60, 60, "Infantil", "Fantasia", -5);
	}
	
	
	/**
	 * Testa o caso em que o parametro genero e nulo
	 * @throws Exception
	 */
	@Test(expected = NullPointerException.class)
	public void testGeneroNull() throws Exception{
		blurayFilme = new BlurayFilme("CDZ", 50.60, 60, "Infantil", null, 1995);
	}
	
	
	/**
	 * Testa o caso em que o parametro genero e invalido, informado como sendo vazio
	 * @throws Exception
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGeneroInvalidaVazio() throws Exception{
		blurayFilme = new BlurayFilme("CDZ", 50.60, 60, "Infantil", "", 1995);
	}
	
	
	/**
	 * Testa o caso em que o parametro genero e invalido, informado como sendo vazio
	 * @throws Exception
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGeneroInvalidaVazioespacos() throws Exception{
		blurayFilme = new BlurayFilme("CDZ", 50.60, 60, "Infantil", "        ", 1995);
	}
	
	
	/**
	 * Testa o metodo toString da classe BlurayFilme
	 */
	@Test 
	public void testToString(){
		String resultadoEsperado = "FILME: CDZ, R$ 50.6, Nao emprestado, 60 min, Fantasia, Infantil, 1995";
		String resultado = blurayFilme.toString();
		
		assertEquals(resultadoEsperado, resultado);
	}
}
