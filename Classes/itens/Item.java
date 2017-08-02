package itens;

/**
 * Classe abstrata Item, tem como funcionalidade servir como modelo para os demais itens. 
 * Por ser uma classe abstrata ela nao pode ser instanceada
 * 
 * @author Guilherme França
 *
 */
public abstract class Item {
	
	protected String nomeItem;
	protected double valor;
	
	public Item(String nome, double valor){
		
		this.nomeItem = nome;
		this.valor = valor;
	}
	
}
