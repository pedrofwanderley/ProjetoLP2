package itens;
import java.util.ArrayList;
import java.util.Collections;



/**
 *  A classe JogosTabuleiro estende a classe Item, tendo assim todas as suas funcionalidades
 * e os seus atributos. A classe representa os jogos de tabuleiro, estes que podem possuir 
 * muitas pecas pequenas, por esse motivo possui um ArrayList de String para reportar se
 * alguma peca ja foi perdida. Caso nenhuma peca tenha sido perdida o jogo estara completo.
 * 
 * 
 * Provavelmente esta classe tem erros na questao do funcionamento deste ArrayList de pecas
 * perdidas(comparacao, criacao e etc)
 * 
 * @author Guilherme Fran�a
 *
 */
public class JogoTabuleiro extends Item{

	protected ArrayList<String> pecasPerdidas;

	
	/**
	 * Construtor da classe JogosTabuleiro
	 * 
	 * @param nome
	 * @param valor
	 * @param pecasPerdidas
	 */
	public JogoTabuleiro(String nome, double valor) throws Exception{
		super(nome, valor);
		pecasPerdidas = new ArrayList<String>();
	}

	
	/**
	 * Sobrescrita do metodo  HashCode, baseado no nome do jogo de tabuleito e nas pecas
	 * perdidas. Dois jogos de tabuleiro sao iguais se tem o mesmo nome e as mesmas pecas
	 * perdidas. 
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((super.nomeItem == null) ? 0 : super.nomeItem.hashCode());
		result = prime * result + ((pecasPerdidas == null) ? 0 : pecasPerdidas.hashCode());
		return result;
	}

	
	/**
	 * Sobrescrita do metodo  Equals, baseado no nome do jogo de tabuleito e nas pecas
	 * perdidas. Dois jogos de tabuleiro sao iguais se tem o mesmo nome e as mesmas pecas
	 * perdidas. 
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		JogoTabuleiro jogoTabuleiro = (JogoTabuleiro) obj;
		
		if (pecasPerdidas == null) {
			if (jogoTabuleiro.pecasPerdidas != null)
				return false;
		} else if (!pecasPerdidas.equals(jogoTabuleiro.pecasPerdidas))
			return false;
		
		if (super.nomeItem == null) {
			if (jogoTabuleiro.nomeItem != null) 
				return false;
		} else if (!super.nomeItem.equals(jogoTabuleiro.nomeItem)) 
			return false;
	
		return true;
	}


	/**
	 * Metodo toString segundo as especificacoes dadas nos testes de aceitacao
	 */
	@Override
	public String toString() {
		String temPecasPerdidas = "";
		if (pecasPerdidas.size() > 0) {
			temPecasPerdidas = "COM PECAS PERDIDAS";
			
		}else{
			temPecasPerdidas = "COMPLETO";
		}
		
		return "JOGO DE TABULEIRO: " + nomeItem + ", R$ " + valor + ", " + estado.getEstadoItem() + 
				", " + temPecasPerdidas ;
				 
	}
	
	
	/**
	 * Metodo adiciona a as pecas do jogo que estao perdidas e ordena a lista a cada nova peca adicionada 
	 * para permitir que mesmo que pecas tenham sido perdidas em ordens diferentes posam ser agrupadas
	 * juntas para efeito de comparacao
	 * 
	 * @param pecaPerdida
	 * @throws Exception
	 */
	public void adicionarPecaPerdida(String pecaPerdida)throws Exception{
		if (pecaPerdida.trim().equals("")) {
			throw new IllegalArgumentException();
		}
		if (pecaPerdida.equals(null)) {
			throw new NullPointerException();
		}
		
		pecasPerdidas.add(pecaPerdida);
		Collections.sort(pecasPerdidas);
	}	
}
