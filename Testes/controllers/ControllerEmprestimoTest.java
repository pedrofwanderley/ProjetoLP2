package controllers;

import static org.junit.Assert.*;
import fachada.Fachada;
import org.junit.Before;
import org.junit.Test;

import chaves.ChaveEmprestimo;


public class ControllerEmprestimoTest {

	private Fachada fac = new Fachada();
	
	@Before
	public void setUp() throws Exception {
		fac.cadastrarUsuario("Joao",  "1234-5678", "joao123@gmail.com");
		fac.cadastrarUsuario("Ana", "9999-8888","ana@gmail.com");
		fac.cadastrarUsuario("Antonio", "5555-5555","antonio5@hotmail.com");
				
		fac.cadastrarJogoTabuleiro("Joao", "1234-5678", "War 2", 50.0);
		fac.cadastrarEletronico("Joao", "1234-5678", "Mafia 3", 150.0, "PC");
		fac.cadastrarEletronico("Ana", "9999-8888", "The Witcher 3", 100.0 , "PS4");
	}
	
	@Test
	public void testRegistraEmprestimo() throws Exception{
		
		fac.registrarEmprestimo("Joao", "1234-5678", "Antonio", "5555-5555", "War 2", "7/7/2017", 5);
		fac.registrarEmprestimo("Ana", "9999-8888", "Antonio", "5555-5555", "The Witcher 3", "25/7/2017", 5);
		
		ChaveEmprestimo chaveEmprestimo1 = new ChaveEmprestimo("Joao","Antonio","1234-5678","5555-5555","7/7/2017","War 2");
		assertEquals("EMPRESTIMO - De: Joao, Para: Antonio, War 2, 7/7/2017, 5 dias, ENTREGA: Emprestimo em andamento"
				,fac.controllerEmprestimo.getEmprestimos().get(chaveEmprestimo1).toString());
		
		ChaveEmprestimo chaveEmprestimo2 = new ChaveEmprestimo("Ana","Antonio","9999-8888","5555-5555","25/7/2017","The Witcher 3");
		assertEquals("EMPRESTIMO - De: Ana, Para: Antonio, The Witcher 3, 25/7/2017, 5 dias, ENTREGA: Emprestimo em andamento"
				,fac.controllerEmprestimo.getEmprestimos().get(chaveEmprestimo2).toString());
				
	}
	
		
	@Test(expected = IllegalArgumentException.class)
	public void testItemEmprestado() throws Exception {
		
		fac.registrarEmprestimo("Joao", "1234-5678", "Antonio", "5555-5555", "War 2", "7/7/2017", 7);
		fac.registrarEmprestimo("Joao", "1234-5678", "Ana", "9999-8888", "War 2", "7/7/2017", 7);
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testItemNaoExistente() throws Exception{
		
		fac.registrarEmprestimo("Joao", "1234-5678", "Ana", "9999-8888", "Uno", "10/7/2017", 7);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testIUsuarioNaoExistente() throws Exception{
		
		fac.registrarEmprestimo("Jose", "0000-0000", "Ana", "9999-8888", "FIFA 17", "10/7/2017", 7);
		fac.registrarEmprestimo("Joao", "1234-5678", "Jose", "0000-0000", "Mafia 3", "10/7/2017", 7);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testIUsuarioNaoPodePedirEmprestado() throws Exception{
				
		fac.registrarEmprestimo("Joao", "1234-5678", "Ana", "9999-8888", "Mafia 3", "10/7/2017", 8);
	}
		
	@Test 
	public void testDevolucao() throws Exception {
		
		fac.registrarEmprestimo("Joao", "1234-5678", "Antonio", "5555-5555", "War 2", "7/7/2017", 5);
		fac.registrarEmprestimo("Ana", "9999-8888", "Antonio", "5555-5555", "The Witcher 3", "25/7/2017", 5);
		
		fac.devolverItem("Joao", "1234-5678", "Antonio", "5555-5555", "War 2", "7/7/2017", "14/7/2017");
		
		ChaveEmprestimo chaveEmprestimo1 = new ChaveEmprestimo("Joao","Antonio","1234-5678","5555-5555","7/7/2017","War 2");
		assertEquals("EMPRESTIMO - De: Joao, Para: Antonio, War 2, 7/7/2017, 5 dias, ENTREGA: 14/7/2017"
				,fac.controllerEmprestimo.getEmprestimos().get(chaveEmprestimo1).toString());
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testDevolucaoExececao(){
		
		fac.devolverItem("Joao", "1234-5678", "Jose", "0000-0000", "War 2", "7/7/2017", "14/7/2017");
		fac.devolverItem("Joao", "1234-5678", "Antonio", "5555-5555", "War 2", "7/7/2017", "14/7/2017");
		fac.devolverItem("Ana", "1234-5678", "Antonio", "5555-5555", "The Witcher 3", "25/7/2017", "2/8/2017");
		fac.devolverItem("Ana", "1234-5678", "Joao", "1234-5678", "The Witcher 3", "12/7/2017", "19/7/2017");
		
	}
	
}
