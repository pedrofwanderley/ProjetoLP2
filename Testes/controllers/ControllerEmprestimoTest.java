package controllers;

import static org.junit.Assert.*;
import fachada.Fachada;
import org.junit.Before;
import org.junit.Test;


public class ControllerEmprestimoTest {

	private Fachada fac = new Fachada();
	
	@Before
	public void setUp() throws Exception {
		fac.cadastrarUsuario("Joao",  "1234-5678", "joao123@gmail.com");
		fac.cadastrarUsuario("Antonio", "5555-5555","antonio5@hotmail.com");
		fac.cadastrarUsuario("Ana", "9999-8888","ana@gmail.com");
		fac.cadastrarJogoTabuleiro("Joao", "1234-5678", "War 2", 50.0);
		fac.cadastrarEletronico("Joao", "1234-5678", "Mafia 3", 150.0, "PC");
		fac.cadastrarEletronico("Ana", "9999-8888", "The Witcher 3", 100.0 , "PS4");
	}
	
	@Test
	public void testRegistraEmprestimo(){
		
		fac.registrarEmprestimo("Joao", "1234-5678", "Antonio", "5555-5555", "War 2", "7/7/2017", 7);
		fac.registrarEmprestimo("Ana", "9999-8888", "Antonio", "5555-5555", "The Witcher 3", "25/7/2017", 7);
		
		assertEquals("Joao", fac.controllerEmprestimo.getEmprestimos().get(0).getDono().getNome());
		assertEquals("Antonio", fac.controllerEmprestimo.getEmprestimos().get(0).getRequerente().getNome());
		assertEquals("War 2", fac.controllerEmprestimo.getEmprestimos().get(0).getItem().getNomeItem());
		assertEquals("7/7/2017", fac.controllerEmprestimo.getEmprestimos().get(0).getDataEmprestimo());
		assertEquals("14/7/2017", fac.controllerEmprestimo.getEmprestimos().get(0).getDataFinal());
		
		assertEquals("Ana", fac.controllerEmprestimo.getEmprestimos().get(1).getDono().getNome());
		assertEquals("Antonio", fac.controllerEmprestimo.getEmprestimos().get(1).getRequerente().getNome());
		assertEquals("The Witcher 3", fac.controllerEmprestimo.getEmprestimos().get(1).getItem().getNomeItem());
		assertEquals("25/7/2017", fac.controllerEmprestimo.getEmprestimos().get(1).getDataEmprestimo());
		assertEquals("1/8/2017", fac.controllerEmprestimo.getEmprestimos().get(1).getDataFinal());
		
	}
	
		
	@Test(expected = IllegalArgumentException.class)
	public void testItemEmprestado() {
		
		fac.registrarEmprestimo("Joao", "1234-5678", "Antonio", "5555-5555", "War 2", "7/7/2017", 7);
		fac.registrarEmprestimo("Joao", "1234-5678", "Ana", "9999-8888", "War 2", "7/7/2017", 7);
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testItemNaoExistente(){
		
		fac.registrarEmprestimo("Joao", "1234-5678", "Ana", "9999-8888", "Uno", "10/7/2017", 7);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testIUsuarioNaoExistente(){
		
		fac.registrarEmprestimo("Jose", "0000-0000", "Ana", "9999-8888", "FIFA 17", "10/7/2017", 7);
		fac.registrarEmprestimo("Joao", "1234-5678", "Jose", "0000-0000", "Mafia 3", "10/7/2017", 7);
	}
	
	
	@Test 
	public void testDevolucao() {
		
		fac.registrarEmprestimo("Joao", "1234-5678", "Antonio", "5555-5555", "War 2", "7/7/2017", 7);
		fac.registrarEmprestimo("Ana", "9999-8888", "Antonio", "5555-5555", "The Witcher 3", "25/7/2017", 7);
		
		fac.devolverItem("Joao", "1234-5678", "Antonio", "5555-5555", "War 2", "7/7/2017", "14/7/2017");
		
		assertEquals("Ana", fac.controllerEmprestimo.getEmprestimos().get(0).getDono().getNome());
		assertEquals("Antonio", fac.controllerEmprestimo.getEmprestimos().get(0).getRequerente().getNome());
		assertEquals("The Witcher 3", fac.controllerEmprestimo.getEmprestimos().get(0).getItem().getNomeItem());
		assertEquals("25/7/2017", fac.controllerEmprestimo.getEmprestimos().get(0).getDataEmprestimo());
		assertEquals("1/8/2017", fac.controllerEmprestimo.getEmprestimos().get(0).getDataFinal());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testDevolucaoExececao(){
		
		fac.devolverItem("Joao", "1234-5678", "Jose", "0000-0000", "War 2", "7/7/2017", "14/7/2017");
		fac.devolverItem("Joao", "1234-5678", "Antonio", "5555-5555", "War 2", "7/7/2017", "14/7/2017");
		fac.devolverItem("Ana", "1234-5678", "Antonio", "5555-5555", "The Witcher 3", "25/7/2017", "2/8/2017");
		fac.devolverItem("Ana", "1234-5678", "Joao", "1234-5678", "The Witcher 3", "12/7/2017", "19/7/2017");
		
	}
	
}
