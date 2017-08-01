package item;

public abstract class Bluray extends Item{

	protected int duracao;
	protected String classificacao;
	
	
	public Bluray(String nome, double valor, int duracao, String classificacao) {
		super(nome, valor);
		
		this.duracao = duracao;
		this.classificacao = classificacao;
	}
		
}
