package itens;

public class BlurayFilme extends Bluray{

	protected String genero;
	protected String anoDeLancamento;
	
	
	public BlurayFilme(String nome, double valor, int duracao, String classificacao, String genero,
			String anoDeLancamento) {
		
		super(nome, valor, duracao, classificacao);
		
		this.genero = genero;
		this.anoDeLancamento = anoDeLancamento;
	}
	
	
}
