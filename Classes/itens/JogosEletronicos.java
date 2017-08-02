package itens;


/**
 * A classe JogosEletronicos estende a classe Item, tendo assim todas as suas funcionalidades
 * e os seus atributos. Os jogos eletronicos representam os jogos de video game e os jogos de
 * PC que possuem mideas que podem ser emprestadas. A classe tem por atributos o nome do jogo
 * e o nome da plataforma.
 * 
 * @author Guilherme França
 *
 */
public class JogosEletronicos extends Item{
	protected String nomeDoJogo;
	protected String plataforma;


	/**
	 * Construtor da classe JogosEletronicos
	 * 
	 * @param nome do Item 
	 * @param valor do Item 
	 * @param nomeDoJogo nome do jogo disponibilizado
	 * @param plataforma nome da plataforma em que o jogo funciona
	 */
	public JogosEletronicos(String nome, double valor, String nomeDoJogo, String plataforma) {
		super(nome, valor);
		this.nomeDoJogo = nomeDoJogo;
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
		result = prime * result + ((nomeDoJogo == null) ? 0 : nomeDoJogo.hashCode());
		result = prime * result + ((plataforma == null) ? 0 : plataforma.hashCode());
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
		
		JogosEletronicos jogoEletronico = (JogosEletronicos) obj;
		
		if (nomeDoJogo == null) {
			if (jogoEletronico.nomeDoJogo != null)
				return false;
		} else if (!nomeDoJogo.equals(jogoEletronico.nomeDoJogo))
			return false;
		
		if (plataforma == null) {
			if (jogoEletronico.plataforma != null)
				return false;
		} else if (!plataforma.equals(jogoEletronico.plataforma))
			return false;
		
		return true;
	}
	
}
