package itens;
import java.util.ArrayList;



/**
 * A classe BlurayTemporada estende a classe Bluray, tendo assim todas as suas funcionalidades
 * e atributos. A classe tem por caracteristica conter os Blurays que compoe uma temporada, 
 * possuir um genero, um numero de temporada e a duracao total de uma temporada.
 * 
 * 
 * Provavelmente esta classe tem erro no funcionamento deste Hashset de Blurays, nao sei ainda 
 * com certeza como ele vai funcionar(comparacao, criacao e etc)
 * 
 * @author Guilherme Fran�a
 *
 */
public class BlurayTemporada extends Bluray{

	protected String generoSerie;
	protected int numeroDaTemporada;
	protected int duracaoTotal;
	protected ArrayList<Integer> episodios = new ArrayList<Integer> ();
	
	
	/**
	 * Construtor da classe BlurayTemporada
	 * 
	 * @param nome
	 * @param valor
	 * @param duracao
	 * @param classificacao
	 * @param generoSerie
	 * @param numeroDaTemporada
	 * @param duracaoTotal
	 * @param discosTemporada
	 */
	public BlurayTemporada(String nome, double valor, int duracao, String classificacao, 
			String generoSerie, int numeroDaTemporada, int duracaoTotal) throws Exception{
		super(nome, valor, duracao, classificacao);
		
		if (generoSerie.trim().equals("")) {
			throw new IllegalArgumentException();
		}
		if (generoSerie.equals(null)) {
			throw new NullPointerException();
		}
		if (numeroDaTemporada <= 0) {
			throw new IllegalArgumentException();
		}
		if (duracaoTotal <= 0) {
			throw new IllegalArgumentException();
		}
		
		this.generoSerie = generoSerie;
		this.numeroDaTemporada = numeroDaTemporada;
		this.duracaoTotal = duracaoTotal;
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
		
		BlurayTemporada temporada = (BlurayTemporada) obj;
		
		if (numeroDaTemporada != temporada.numeroDaTemporada)
			return false;
		
		if (super.nomeItem == null) {
			if (temporada.nomeItem != null)
				return false;
		}else if(!super.nomeItem.equals(temporada.nomeItem))
			return false;
		
		return true;
	}	
}
