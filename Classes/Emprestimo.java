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
	
	private Calendar dataInicial = Calendar.getInstance();
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
	
	
	
}
