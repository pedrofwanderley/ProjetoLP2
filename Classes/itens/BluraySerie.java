package itens;
import java.util.ArrayList;



/**
 * A classe BlurayTemporada estende a classe Bluray, tendo assim todas as suas funcionalidades
 * e atributos. A classe tem por caracteristica conter os Blurays que compoe uma temporada, 
 * possuir um genero, um numero de temporada e a duracao total de uma temporada.
 * 
 * 
 * @author Guilherme Franca
 *
 */
public class BluraySerie extends Bluray{

	protected String descricao;
	protected String generoSerie;
	protected int numeroDaTemporada;
	protected ArrayList<Integer> episodios;
	
	

	/**
	 * Construtor da classe BlurayTemporada
	 * 
	 * @param nome
	 * @param valor
	 * @param descricao 
	 * @param duracao
	 * @param classificacao
	 * @param generoSerie
	 * @param numeroDaTemporada
	 */
	public BluraySerie(String nome, double valor, String descricao, int duracao, String classificacao, 
			String generoSerie, int numeroDaTemporada) {
		super(nome, valor, duracao, classificacao);
		
		if (descricao.trim().equals("")) {
			throw new IllegalArgumentException();
		}
		if (descricao.equals(null)) {
			throw new NullPointerException();
		}
		if (generoSerie.trim().equals("")) {
			throw new IllegalArgumentException();
		}
		if (generoSerie.equals(null)) {
			throw new NullPointerException();
		}
		if (numeroDaTemporada <= 0) {
			throw new IllegalArgumentException();
		}

		
		this.descricao = descricao;
		this.generoSerie = generoSerie;
		this.numeroDaTemporada = numeroDaTemporada;
		this.episodios = new ArrayList<Integer> ();
	}


	/**
	 * Sobrescrita do metodo HashCode baseado no nome do Bluray da temporada e no numero da
	 * temporada. Pois dois Blurays de temporada sao iguais se tiverem o mesmo nome e o
	 * mesmo numero de temporada.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((super.nomeItem == null) ? 0 : super.nomeItem.hashCode());
		result = prime * result + this.numeroDaTemporada;
		return result;
	}


	/**
	 * Sobrescrita do metodo Equals baseado no nome do Bluray da temporada e no numero da
	 * temporada. Pois dois Blurays de temporada sao iguais se tiverem o mesmo nome e o
	 * mesmo numero de temporada.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		BluraySerie temporada = (BluraySerie) obj;
		
		if (numeroDaTemporada != temporada.numeroDaTemporada)
			return false;
		
		if (super.nomeItem == null) {
			if (temporada.nomeItem != null)
				return false;
		}else if(!super.nomeItem.equals(temporada.nomeItem))
			return false;
		
		return true;
	}


	/**
	 * Metodo toString segundo o que estava estabelecido nos testes de aceitacao fornecidos
	 */
	@Override
	public String toString() {
		return "SERIE: " + nomeItem + ", R$ " + valor + ", " +  estado.getEstadoItem() +
				", " + duracao + " min, " + classificacao + ", " + generoSerie + 
				", " +  "Temporada " + numeroDaTemporada;
			
	}

	/**
	 * Metodo adiciona Bluray de episodio na lista de epiosodios, como estamos consederando que os episodios 
	 * sao so uma representacao de sua duracao em min, o parametro que recebemos e um inteiro, ele sera 
	 * a representacao do episodio na lista, o numero do episodio e seu indice + 1.
	 * 
	 * @param duracao
	 */
	public void adicionarBluRay(int duracao) {
		if (duracao <= 0) {
			throw new IllegalArgumentException();
		}
		
		episodios.add(duracao);
	}

	
	/**
	 * Metodo que retorna o genero da serie
	 * @return String representando o genero da serie
	 */
	public String getGeneroSerie() {
		return generoSerie;
	}


	/**
	 * Metodo que retorna o numero da temporada
	 * @return inteiro representando o numero da trempoeada
	 */
	public int getNumeroDaTemporada() {
		return numeroDaTemporada;
	}


	/**
	 * Metodo que retorna a descricao dada pelo dono a Bluray de temporada 
	 * @return String com descricao do Bluray de temporada
	 */
	public String getDescricao() {
		return descricao;
	}
	

	
}
