package controllers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fachada.Fachada;


public class EmprestimoTest {

	Fachada fachada = new Fachada();
	
	@Before
	public void inicializaMetodos() throws Exception {
		fachada.cadastrarUsuario("Joao",  "1234-5678", "joao123@gmail.com");
		fachada.cadastrarUsuario("Antonio", "5555-5555","antonio5@hotmail.com");
		fachada.cadastrarUsuario("Ana", "9999-8888","ana@gmail.com");
		fachada.cadastrarJogoTabuleiro("Joao", "1234-5678", "War 2", 50.0);
		fachada.cadastrarEletronico("Joao", "1234-5678", "Mafia 3", 150.0, "PC");
		fachada.cadastrarEletronico("Ana", "9999-8888", "The Witcher 3", 100.0 , "PS4");
		
	}
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
