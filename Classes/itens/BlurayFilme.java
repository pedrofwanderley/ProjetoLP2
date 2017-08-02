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
	public BlurayFilme(String nome, double valor, int duracao, String classificacao, String genero,
			String anoDeLancamento) {
		
		super(nome, valor, duracao, classificacao);
		
		this.genero = genero;
		this.anoDeLancamento = anoDeLancamento;
	}
	
	
}