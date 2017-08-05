package itens;


/**
 * A classe BlurayFilme estende a classe Bluray, tendo assim todas as suas funcionalidades e
 * seus atributos. A classe representa o Bluray de filme e tem por caracteristica propria
 * possuir um genero e um ano de lancamento.
 * 
 * @author Guilherme Fran�a
 *
 */
public class BlurayFilme extends Bluray{

	protected String genero;
	protected int anoDeLancamento;
	
	
	/**
	 * Construtor da classe BlurayFilme
	 * 
	 * @param nome 
	 * @param valor
	 * @param duracao
	 * @param classificacao
	 * @param genero
	 * @param anoDeLancamento
	 */
	public BlurayFilme(String nome, double valor, int duracao, String classificacao, 
			String genero, int anoDeLancamento) throws Exception{
		super(nome, valor, duracao, classificacao);
		
		if (genero.trim().equals("")) {
			throw new IllegalArgumentException();
		}
		if (genero.equals(null)) {
			throw new NullPointerException();
		}
		if (anoDeLancamento <= 0) {
			throw new IllegalArgumentException();
		}
		
		this.genero = genero;
		this.anoDeLancamento = anoDeLancamento;
	}


	public String getGenero() {
		return genero;
	}


	public int getAnoDeLancamento() {
		return anoDeLancamento;
	}


	@Override
	public String toString() {
		return "FILME: " + nomeItem + ", R$ " + valor + ", " + estado.getEstadoItem() +
				", " + duracao + " min, "  + genero + ", " + classificacao + ", " + anoDeLancamento;
	}
}
