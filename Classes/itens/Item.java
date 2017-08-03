package itens;

/**
 * Classe abstrata Item, tem como funcionalidade servir como modelo para os demais itens. 
 * Por ser uma classe abstrata ela nao pode ser instanceada
 * 
 * @author Guilherme Fran�a
 *
 */
public class Item {
	
	protected String nomeItem;
	protected double valor;
	protected EstadoItem estado;
	
	public Item(String nome, double valor) throws Exception{
		if (nome.trim().equals("")) {
			throw new IllegalArgumentException();
		}
		if (nome.equals(null)) {
			throw new NullPointerException();
		}
		if (valor <= 0) {
			throw new IllegalArgumentException();
		}
		
		
		this.nomeItem = nome;
		this.valor = valor;
		this.estado= EstadoItem.NEmprestado;
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

	public EstadoItem getEstado() {
		return estado;
	}

	public void setEstado(EstadoItem estado) {
		this.estado = estado;
	}
	
}
