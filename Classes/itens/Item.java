package itens;

public abstract class Item {
	
	protected String nomeItem;
	protected double valor;
	
	public Item(String nome, double valor){
		
		this.nomeItem = nome;
		this.valor = valor;
	}
	
}
