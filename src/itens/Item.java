package itens;

public abstract class Item {
	
	protected String nome;
	protected double valor;
	
	public Item(String nome, double valor){
		
		this.nome = nome;
		this.valor = valor;
	}
	
}
