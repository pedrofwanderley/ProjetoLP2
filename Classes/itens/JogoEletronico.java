package itens;


/**
 * A classe JogosEletronicos estende a classe Item, tendo assim todas as suas funcionalidades
 * e os seus atributos. Os jogos eletronicos representam os jogos de video game e os jogos de
 * PC que possuem mideas que podem ser emprestadas. A classe tem por atributos o nome do jogo
 * e o nome da plataforma.
 * 
 *
 */
public class JogoEletronico extends Item{
	protected String plataforma;


	/**
	 * Construtor da classe JogosEletronicos
	 * 
	 * @param nome do Item 
	 * @param valor do Item 
	 * @param nomeDoJogo nome do jogo disponibilizado
	 * @param plataforma nome da plataforma em que o jogo funciona
	 */
	public JogoEletronico(String nome, double valor, String plataforma) throws Exception{
		super(nome, valor);
		
		if (plataforma.trim().equals("")) {
			throw new IllegalArgumentException();
		}
		if (plataforma.equals(null)) {
			throw new NullPointerException();
		}
		
		this.plataforma = plataforma;
	}


	/**
	 * Sobrescrita do metodo HashCode baseado no nome do jogo e na platadorma. Dois jogos 
	 * eletronicos serao iguais se tiverem o mesmo nome e funcionarem na mesma plataforma.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((super.nomeItem == null) ? 0 : super.nomeItem.hashCode());
		result = prime * result + ((this.plataforma == null) ? 0 : plataforma.hashCode());
		return result;
	}

	/**
	 * Sobrescrita do metodo Equals baseado no nome do jogo e na platadorma. Dois jogos 
	 * eletronicos serao iguais se tiverem o mesmo nome e funcionarem na mesma plataforma.
	 */
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		JogoEletronico jogoEletronicoTeste = (JogoEletronico) obj;
		
		if (this.plataforma == null) {
			if (jogoEletronicoTeste.plataforma != null)
				return false;
		} else if (!plataforma.equals(jogoEletronicoTeste.plataforma))
			return false;
		
		if (super.nomeItem == null) {
			if (jogoEletronicoTeste.nomeItem != null)
				return false;
		} else if (!super.nomeItem.equals(jogoEletronicoTeste.nomeItem))
			return false;
		
		return true;
	}


	public String getPlataforma() {
		return plataforma;
	}


	@Override
	public String toString() {
		return "JOGO ELETRONICO: " + nomeItem + ", R$ " + valor + ", " + estado.getEstadoItem() +
				", " + plataforma;
		
	}
	
	
}
