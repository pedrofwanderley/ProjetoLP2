package itens;

/**
 * A classe Bluray estende a classe item tendo assim os seus atributos, a classe Bluray tem 
 * por funcionalidade servir como base para a construcao das classes que dela variam.
 * Ainda nao sei se devo estabelecer esta classe como abstrata. 
 * 
 * @author Guilherme França
 *
 */
public abstract class Bluray extends Item{

	protected int duracao;
	protected String classificacao;
	
	
	/**
	 * Construtor da classe Bluray
	 * 
	 * @param nome
	 * @param valor
	 * @param duracao
	 * @param classificacao
	 */
	public Bluray(String nome, double valor, int duracao, String classificacao) {
		
		super(nome, valor);
		
		this.duracao = duracao;
		this.classificacao = classificacao;
	}
		
}
