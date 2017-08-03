package itens;


/**
 * A classe BlurayFilme estende a classe Bluray, tendo assim todas as suas funcionalidades e
 * seus atributos. A classe representa o Bluray de filme e tem por caracteristica propria
 * possuir um genero e um ano de lancamento.
 * 
 * @author Guilherme França
 *
 */
public class BlurayFilme extends Bluray{

	protected String genero;
	protected String anoDeLancamento;
	
	
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
			String genero,String anoDeLancamento) throws Exception{
		super(nome, valor, duracao, classificacao);
		
		if (genero.trim().equals("")) {
			throw new IllegalArgumentException();
		}
		if (genero.equals(null)) {
			throw new NullPointerException();
		}
		if (anoDeLancamento.trim().equals("")) {
			throw new IllegalArgumentException();
		}
		if (anoDeLancamento.equals(null)) {
			throw new NullPointerException();
		}
		
		this.genero = genero;
		this.anoDeLancamento = anoDeLancamento;
	}
	
	
}
