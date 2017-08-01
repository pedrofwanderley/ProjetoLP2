package itens;

public class BlurayShow extends Bluray{

	protected String nomeDoArtista;
	protected int numeroDeFaixas;
	
	
	public BlurayShow(String nome, double valor, int duracao, String classificacao, String nomeDoArtista,
			int numeroDeFaixas) {
		
		super(nome, valor, duracao, classificacao);
		
		this.nomeDoArtista = nomeDoArtista;
		this.numeroDeFaixas = numeroDeFaixas;
	}

	
}
