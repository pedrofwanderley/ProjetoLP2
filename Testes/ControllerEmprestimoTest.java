import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ControllerEmprestimoTest {

	private Fachada fac = new Fachada();
	
	@Before
	public void setUp() throws Exception {
		fac.cadastrarUsuario("Joao", "joao123@gmail.com", "1234-5678");
		fac.cadastrarUsuario("Antonio", "antonio5@hotmail.com","5555-5555");
		fac.cadastrarUsuario("Ana", "ana@gmail.com","9999-8888");
		
		fac.cadastrarJogoTabuleiro("Joao", "1234-5678", "War 2", 50.0);
		fac.cadastrarEletronico("Joao", "1234-5678", "Mafia 3", 150.0, "PC");
		fac.cadastrarEletronico("Ana", "9999-8888", "The Witcher 3", 100.0 , "PS4");
	}
	
	@Test
	public void testRegistraEmprestimo() throws Exception{
		
		fac.registrarEmprestimo("Joao", "1234-5678", "Antonio", "5555-5555", "War 2", "07/07/2017", 7);
		fac.registrarEmprestimo("Ana", "9999-8888", "Antonio", "5555-5555", "The Witcher 3", "25/07/2017", 7);
		
		assertEquals("Joao", fac.controllerEmprestimo.getEmprestimos().get(0).getDono());
		assertEquals("Antonio", fac.controllerEmprestimo.getEmprestimos().get(0).getRequerente());
		assertEquals("War 2", fac.controllerEmprestimo.getEmprestimos().get(0).getItem());
		assertEquals("07/07/2017", fac.controllerEmprestimo.getEmprestimos().get(0).getDataEmprestimo());
		assertEquals("14/07/2017", fac.controllerEmprestimo.getEmprestimos().get(0).getDataDevolucao());
		
		assertEquals("Ana", fac.controllerEmprestimo.getEmprestimos().get(1).getDono());
		assertEquals("Antonio", fac.controllerEmprestimo.getEmprestimos().get(1).getRequerente());
		assertEquals("The Witcher 3", fac.controllerEmprestimo.getEmprestimos().get(1).getItem());
		assertEquals("25/07/2017", fac.controllerEmprestimo.getEmprestimos().get(1).getDataEmprestimo());
		assertEquals("01/08/2017", fac.controllerEmprestimo.getEmprestimos().get(1).getDataDevolucao());
		
	}
	
		
	@Test(expected = "Item emprestado no momento")
	public void testItemEmprestado(){
		
		fac.registrarEmprestimo("Joao", "1234-5678", "Ana", "9999-8888", "War 2", "10/07/2017", 7);
	}
	
	@Test(expected = "Item nao encontrado")
	public void testItemEmprestado(){
		
		fac.registrarEmprestimo("Joao", "1234-5678", "Ana", "9999-8888", "Uno", "10/07/2017", 7);
	}
	
	@Test(expected = "Usuario invalido")
	public void testItemEmprestado(){
		
		fac.registrarEmprestimo("Jose", "0000-0000", "Ana", "9999-8888", "FIFA 17", "10/07/2017", 7);
		fac.registrarEmprestimo("Joao", "1234-5678", "Jose", "0000-0000", "Mafia 3", "10/07/2017", 7);
	}
	
	
	@Test 
	public void testDevolucao(){
		
		fac.devolverItem("Joao", "1234-5678", "Antonio", "5555-5555", "War 2", "07/07/2017", "14/07/2017");
		
		assertEquals("Ana", fac.controllerEmprestimo.getEmprestimos().get(0).getDono());
		assertEquals("Antonio", fac.controllerEmprestimo.getEmprestimos().get(0).getRequerente());
		assertEquals("The Witcher 3", fac.controllerEmprestimo.getEmprestimos().get(0).getItem());
		assertEquals("25/07/2017", fac.controllerEmprestimo.getEmprestimos().get(0).getDataEmprestimo());
		assertEquals("01/08/2017", fac.controllerEmprestimo.getEmprestimos().get(0).getDataDevolucao());
	}
	
	@Test(expected = "Emprestimo nao encontrado")
	public void testItemEmprestado(){
		
		fac.devolverItem("Joao", "1234-5678", "Jose", "0000-0000", "War 2", "07/07/2017", "14/07/2017");
		fac.devolverItem("Joao", "1234-5678", "Antonio", "5555-5555", "War 2", "07/07/2017", "14/07/2017");
		fac.devolverItem("Ana", "1234-5678", "Antonio", "5555-5555", "The Witcher 3", "25/07/2017", "02/08/2017");
		fac.devolverItem("Ana", "1234-5678", "Joao", "1234-5678", "The Witcher 3", "12/07/2017", "19/07/2017");
		
	}
	
}
