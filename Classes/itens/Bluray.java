package itens;

/**
 * A classe Bluray estende a classe item tendo assim os seus atributos, a classe Bluray tem 
 * por funcionalidade servir como base para a construcao das classes que dela variam.
 * 
 * @author Guilherme Fran�a
 *
 */
public class Bluray extends Item{

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
	public Bluray(String nome, double valor, int duracao, String classificacao) throws Exception{
		super(nome, valor);
		
		if (duracao <= 0) {
			throw new IllegalArgumentException();
		}
		if (classificacao.trim().equals("")) {
			throw new IllegalArgumentException();
		}
		if (classificacao.equals(null)) {
			throw new NullPointerException();
		}
		
		this.duracao = duracao;
		this.classificacao = classificacao;
	}


	public int getDuracao() {
		return duracao;
	}


	public String getClassificacao() {
		return classificacao;
	}
		

}
