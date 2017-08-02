package itens;

import java.util.ArrayList;

public class JogosTabuleiro extends Item{

	protected ArrayList<String> pecasPerdidas = new ArrayList<String> ();

	public JogosTabuleiro(String nome, double valor, ArrayList<String> pecasPerdidas) {
		super(nome, valor);
		this.pecasPerdidas = pecasPerdidas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((super.nomeItem == null) ? 0 : super.nomeItem.hashCode());
		result = prime * result + ((pecasPerdidas == null) ? 0 : pecasPerdidas.hashCode());
		return result;
	}

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
	
	
}
