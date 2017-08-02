package itens;

/**
 * Classe abstrata Item, tem como funcionalidade servir como modelo para os demais itens. 
 * Por ser uma classe abstrata ela nao pode ser instanceada
 * 
 * @author Guilherme Fran�a
 *
 */
public abstract class Item {
	
	protected String nomeItem;
	protected double valor;
	
	public Item(String nome, double valor){
		
		this.nomeItem = nome;
		this.valor = valor;
	}

	public String getNomeItem() {
		return nomeItem;
	}

	public void setNomeItem(String nomeItem) {
		this.nomeItem = nomeItem;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
}
