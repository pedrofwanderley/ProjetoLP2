package itens;

import java.util.HashSet;

public class BlurayTemporada extends Bluray{

	protected String generoSerie;
	protected int numeroDaTemporada;
	protected int duracaoTotal;
	protected HashSet<Bluray> discosTemporada = new HashSet<Bluray> ();
	
	
	public BlurayTemporada(String nome, double valor, int duracao, String classificacao, String generoSerie,
			int numeroDaTemporada, int duracaoTotal, HashSet<Bluray> discosTemporada) {
		
		super(nome, valor, duracao, classificacao);
		
		this.generoSerie = generoSerie;
		this.numeroDaTemporada = numeroDaTemporada;
		this.duracaoTotal = duracaoTotal;
		this.discosTemporada = discosTemporada;
	}
	
	
}
