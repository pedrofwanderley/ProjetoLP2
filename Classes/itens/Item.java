package itens;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import emprestimo.Emprestimo;

/**
 * Classe abstrata Item, tem como funcionalidade servir como modelo para os
 * demais itens. Por ser uma classe abstrata ela nao pode ser instanceada
 * 
 *
 */
public class Item implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String nomeItem;
	protected double valor;
	protected EstadoItem estado;
	protected List<Emprestimo> historicoItem;

	public Item(String nome, double valor) {
		if (nome.trim().equals("")) {
			throw new IllegalArgumentException("Nome vazio ou composto de espacos!");
		}
		if (nome.equals(null)) {
			throw new NullPointerException("Nome nulo!");
		}
		if (valor <= 0) {
			throw new IllegalArgumentException("Preco invalido");
		}

		this.nomeItem = nome;
		this.valor = valor;
		this.estado = EstadoItem.NEmprestado;
		historicoItem = new ArrayList<>();
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

	public List<Emprestimo> getHistoricoItem() {
		return historicoItem;
	}

	

}
