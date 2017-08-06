import itens.Item;


public class Emprestimo {
	/**
	 * declaracao de variaveis
	 */
	private Usuario dono;
	private Usuario requerente;
	private Item item;
	private int periodo;
	private String dataEmprestimo;
	private String dataDevolucao;
		
	/**
	 * construtor
	 * @param dono
	 * @param Requerente
	 * @param item
	 * @param periodo
	 * @param dataEmprestimo
	 */
	public Emprestimo(Usuario dono, Usuario requerente, Item item, String dataEmprestimo ,int periodo, String dataDevolucao){
		
		this.dono = dono;
		this.requerente = requerente;
		this.item = item;
		this.periodo = periodo;
		this.dataEmprestimo = dataEmprestimo;
		this.dataDevolucao = dataDevolucao;
		
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

	public int getPeriodo() {
		return periodo;
	}

	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}

	public String getDataEmprestimo() {
		return dataEmprestimo;
	}

	public void setDataEmprestimo(String dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	public String getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(String dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	@Override
	public String toString() {
		return "Dono do item: " + dono.getNome() + " - Requerente:  " + requerente.getNome() + " - Item: " + item.getNomeItem() 
		+ " - Data Inicial do Emprestimo: " + dataEmprestimo + " - Data de Devoluçao do Emprestimo: " + dataDevolucao;
	
	}
	


	
}