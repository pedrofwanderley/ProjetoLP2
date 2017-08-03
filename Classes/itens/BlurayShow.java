package itens;


/**
 * A classe BlurayShow estende a classe Bluray, tendo assim todas as suas funcionalidades e
 * seus atributos. A classe representa o Bluray de show e tem por caracteristica propria
 * possuir o nome do artista e o numero de faixas.
 * 
 * @author Guilherme França
 *
 */
public class BlurayShow extends Bluray{

	protected String nomeDoArtista;
	protected int numeroDeFaixas;
	
	
	/**
	 * Construtor da classe BlurayShow
	 * 
	 * @param nome
	 * @param valor
	 * @param duracao
	 * @param classificacao
	 * @param nomeDoArtista
	 * @param numeroDeFaixas
	 */
	public BlurayShow(String nome, double valor, int duracao, String classificacao, 
			String nomeDoArtista, int numeroDeFaixas) throws Exception{
		super(nome, valor, duracao, classificacao);
		
		if (nomeDoArtista.trim().equals("")) {
			throw new IllegalArgumentException();
		}
		if (nomeDoArtista.equals(null)) {
			throw new NullPointerException();
		}
		if (numeroDeFaixas <= 0) {
			throw new IllegalArgumentException();
		}
		
		this.nomeDoArtista = nomeDoArtista;
		this.numeroDeFaixas = numeroDeFaixas;
	}
}
