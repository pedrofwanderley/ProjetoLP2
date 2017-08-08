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
	public void testDescricaoInvalidaVazia() throws Exception{
		item2 = new Bluray("", 50.60, 60, "Infantil");
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testDescricaoInvalidaVaziaEspacos() throws Exception{
		item2 = new Bluray("        ", 50.60, 60, "Infantil");
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testValorInvalidoZero() throws Exception{
		item2 = new Bluray("CDZ", 0, 60, "Infantil");
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testValorInvalidoNegativo() throws Exception{
		item2 = new Bluray("CDZ", -5, 60, "Infantil");
	}
	
	
	@Test
	public void testSetNomeItem(){
		item1.setNomeItem("GoT");
		assertEquals("GoT", item1.getNomeItem());
	}
	
	
	@Test
	public void testSetValorItem(){
		item1.setValor(70.22);
		assertEquals(70.22, item1.getValor(), 0.001);
	}

	@Test
	public void testSetEstadoItem(){
		item1.setEstado(EstadoItem.Emprestado);
		assertEquals(EstadoItem.Emprestado, item1.getEstado());
	}
}
