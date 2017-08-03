package itens;
import java.util.ArrayList;


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
public class JogosTabuleiro extends Item{

	protected ArrayList<String> pecasPerdidas;

	
	/**
	 * Construtor da classe JogosTabuleiro
	 * 
	 * @param nome
	 * @param valor
	 * @param pecasPerdidas
	 */
	public JogosTabuleiro(String nome, double valor) throws Exception{
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
		
		JogosTabuleiro jogoTabuleiro = (JogosTabuleiro) obj;
		
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


	public ArrayList<String> getPecasPerdidas() {
		return pecasPerdidas;
	}


	public void setPecasPerdidas(ArrayList<String> pecasPerdidas) {
		this.pecasPerdidas = pecasPerdidas;
	}
}
