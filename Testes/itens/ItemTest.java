package itens;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ItemTest {

	Item item1;
	Item item2;
	
	@Before
	public void inicializaItem() throws Exception{
		item1 = new Item("CDZ", 50.60);
	}
	
	
	@Test
	public void testConstrutor() {
		assertEquals("CDZ", item1.getNomeItem());
		assertEquals(50.60, item1.getValor(), 0.001);
		assertEquals(EstadoItem.NEmprestado, item1.getEstado());
	}

	
	@Test(expected = NullPointerException.class)
	public void testDescricaoNull() throws Exception{
		item2 = new Bluray(null, 50.60, 60, "Infantil");
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testDescricaoInvalida() throws Exception{
		item2 = new Bluray("", 50.60, 60, "Infantil");
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testValorInvalidoZero() throws Exception{
		item2 = new Bluray("CDZ", 0, 60, "Infantil");
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testValorInvalidoNegativo() throws Exception{
		item2 = new Bluray("CDZ", -5, 60, "Infantil");
	}
	
	
}
