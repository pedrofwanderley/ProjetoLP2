import itens.Item;
import java.util.*;

public class Emprestimo {
	/**
	 * declaracao de variaveis
	 */
	private Usuario nomeDono;
	private Usuario nomeRequerente;
	private Item item;
	private int tempoEmprestimo;
	
	private Calendar dataInicial = Calendar.getInstance();
	private Calendar dataFinal = Calendar.getInstance();
	
	/**
	 * construtor
	 * @param nomeDono
	 * @param nomeRequerente
	 * @param item
	 * @param tempoEmprestimo
	 */
	public Emprestimo(Usuario nomeDono, Usuario nomeRequerente, Item item, int tempoEmprestimo) {
		
		this.nomeDono = nomeDono;
		this.nomeRequerente = nomeRequerente;
		this.item = item;
		this.tempoEmprestimo = tempoEmprestimo;
		
		dataFinal.add(Calendar.DATE, tempoEmprestimo); 
	}

	public Usuario getNomeDono() {
		return nomeDono;
	}

	public void setDonoItem(Usuario nomeDono) {
		this.nomeDono = nomeDono;
	}

	public Usuario getNomeRequerente() {
		return nomeRequerente;
	}

	public void setUsuarioEmprestado(Usuario nomeRequerente) {
		this.nomeRequerente = nomeRequerente;
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
		return "Emprestimo [donoItem=" + nomeDono + ", usuarioEmprestado=" + nomeRequerente + ", item=" + item
				+ ", tempoEmprestimo=" + tempoEmprestimo + ", dataInicial=" + dataInicial + ", dataFinal=" + dataFinal
				+ "]";
	}
	
	
	
}