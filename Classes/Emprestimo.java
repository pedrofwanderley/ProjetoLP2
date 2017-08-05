import itens.Item;
import java.util.*;

public class Emprestimo {
	/**
	 * declaracao de variaveis
	 */
	private Usuario dono;
	private Usuario requerente;
	private Item item;
	private int tempoEmprestimo;
	
	private Calendar dataInicial = Calendar.getInstance();
	private Calendar dataFinal = Calendar.getInstance();
	
	/**
	 * construtor
	 * @param dono
	 * @param nomeRequerente
	 * @param item
	 * @param tempoEmprestimo
	 */
	public Emprestimo(Usuario dono, Usuario requerente, Item item, int tempoEmprestimo) {
		
		this.dono = dono;
		this.requerente = requerente;
		this.item = item;
		this.tempoEmprestimo = tempoEmprestimo;
		
		dataFinal.add(Calendar.DATE, tempoEmprestimo); 
	}

	public Usuario getDono() {
		return dono;
	}

	public void setDonoItem(Usuario dono) {
		this.dono = dono;
	}

	public Usuario getRequerente() {
		return requerente;
	}

	public void setUsuarioEmprestado(Usuario requerente) {
		this.requerente = requerente;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public int getTempoEmprestimo() {
		return tempoEmprestimo;
	}

	public void setTempoEmprestimo(int tempoEmprestimo) {
		this.tempoEmprestimo = tempoEmprestimo;
	}

	public Calendar getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(Calendar dataInicial) {
		this.dataInicial = dataInicial;
	}

	public Calendar getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(Calendar dataFinal) {
		this.dataFinal = dataFinal;
	}

	@Override
	public String toString() {
		return "Emprestimo [donoItem=" + dono + ", usuarioEmprestado=" + requerente + ", item=" + item
				+ ", tempoEmprestimo=" + tempoEmprestimo + ", dataInicial=" + dataInicial + ", dataFinal=" + dataFinal
				+ "]";
	}
	
	
	
}