package itens;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class JogoTabuleiroTest {

	JogoTabuleiro jogoTabuleiro1;
	JogoTabuleiro jogoTabuleiro2;
	JogoTabuleiro jogoTabuleiro3;
	JogoTabuleiro jogoTabuleiro4;
	
	
	/**
	 * Inicializa objetos jogo tabuleito, para uso nos testes posteriores. Adiciona pecas perdidas
	 * aos objetos 
	 * @throws Exception
	 */
	@Before
	public void inicializaJogoTabuleiro() throws Exception{
		jogoTabuleiro1 = new JogoTabuleiro("War", 100.55);
		jogoTabuleiro2 = new JogoTabuleiro("War Guerra Mundial", 5.43);
		jogoTabuleiro3 = new JogoTabuleiro("War", 90.55);
		jogoTabuleiro4 = new JogoTabuleiro("War", 100.55);
		
		jogoTabuleiro1.adicionarPecaPerdida("Carta Brasil");
		jogoTabuleiro1.adicionarPecaPerdida("Carta USA");
		jogoTabuleiro1.adicionarPecaPerdida("Carta Argentina");
		
		jogoTabuleiro3.adicionarPecaPerdida("Carta USA");
		jogoTabuleiro3.adicionarPecaPerdida("Carta Brasil");
		jogoTabuleiro3.adicionarPecaPerdida("Carta Argentina");
		
		jogoTabuleiro2.adicionarPecaPerdida("Carta USA");
		jogoTabuleiro2.adicionarPecaPerdida("Carta Brasil");
		jogoTabuleiro2.adicionarPecaPerdida("Carta Argentina");
		
		jogoTabuleiro4.adicionarPecaPerdida("Italia");
		jogoTabuleiro4.adicionarPecaPerdida("Asia");
		jogoTabuleiro4.adicionarPecaPerdida("Africa");
	}
	
	/**
	 * Testa o contrutor, conferir se a chamada de super classe esta funcionando 
	 */
	@Test
	public void testConstrutorJogoTabuleiro() {
		assertEquals("War", jogoTabuleiro1.getNomeItem());
		assertEquals(100.55, jogoTabuleiro1.getValor(), 0.001);
	}

	
	/**
	 * Testa o metodo equals sobrescrito da classe JogoTabuleiro, dois jogos de tabuleiro sao iguais se
	 * eles tem o mesmo nome e as mesmas pecas perdidas
	 */
	@Test
	public void testEquals(){
		//Mesmo nome e mesmas pecas perdidas, com ordem de adicao diferentes
		assertTrue(jogoTabuleiro1.equals(jogoTabuleiro3));
		
		//Mesmas pecas perdidas e nomes diferentes
		assertFalse(jogoTabuleiro1.equals(jogoTabuleiro2));
		
		//Mesmo nome e pecas perdidas diferentes
		assertFalse(jogoTabuleiro1.equals(jogoTabuleiro4));
	}
	
	
	/**
	 * Testa o caso de o parametro peca do metodo adicionarPecaPerdida ser informado com valor invalido
	 * (vazio ou so de  espacos).
	 * @throws Exception
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAdicionaPacaInvalidaVazia() throws Exception{
		jogoTabuleiro1.adicionarPecaPerdida("");
	}
	
	
	/**
	 * Testa o caso de o parametro peca do metodo adicionarPecaPerdida ser informado com valor invalido
	 * (vazio ou so de  espacos).
	 * @throws Exception
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAdicionaPacaInvalidaVaziaEspacos() throws Exception{
		jogoTabuleiro1.adicionarPecaPerdida("          ");
	}
	
	/**
	 * Testa o caso de o parametro peca do metodo adicionarPecaPerdida ser nulo.
	 * @throws Exception
	 */
	@Test(expected = NullPointerException.class)
	public void testAdicionaPacaInvalidaNull() throws Exception{
		jogoTabuleiro1.adicionarPecaPerdida(null);
	}
	
	
}
