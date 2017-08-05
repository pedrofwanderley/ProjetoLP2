package itens;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BlurayTemporadaTest {

	BlurayTemporada blurayTemporada;
	
	@Before
	public void inicializaBlurayTemporada(){
		blurayTemporada = new BlurayTemporada("GoT", 100.53, 600, "Maiores de 18", "Fantasia", );
	}
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
