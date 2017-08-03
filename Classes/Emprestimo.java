import itens.Item;
import java.util.*;

public class Emprestimo {
	/**
	 * declaracao de variaveis
	 */
	private Usuario donoItem;
	private Usuario usuarioEmprestado;
	private Item item;
	private int tempoEmprestimo;
	
	private Calendar dataInicial = Calendar.getInstance().DAY_OF_YEAR;
	private Calendar dataFinal = Calendar.getInstance();
	
	/**
	 * construtor
	 * @param donoItem
	 * @param usuarioEmprestado
	 * @param item
	 * @param tempoEmprestimo
	 */
	public Emprestimo(Usuario donoItem, Usuario usuarioEmprestado, Item item, int tempoEmprestimo) {
		
		this.donoItem = donoItem;
		this.usuarioEmprestado = usuarioEmprestado;
		this.item = item;
		this.tempoEmprestimo = tempoEmprestimo;
		
		dataFinal.add(Calendar.DATE, tempoEmprestimo); 
	}

	public Usuario getDonoItem() {
		return donoItem;
	}

	public void setDonoItem(Usuario donoItem) {
		this.donoItem = donoItem;
	}

	public Usuario getUsuarioEmprestado() {
		return usuarioEmprestado;
	}

	public void setUsuarioEmprestado(Usuario usuarioEmprestado) {
		this.usuarioEmprestado = usuarioEmprestado;
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
	
	
	
}