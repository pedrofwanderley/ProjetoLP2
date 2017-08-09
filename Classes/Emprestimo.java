import java.util.Calendar;

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
	private String dataFinal;
		
	/**
	 * construtor
	 * @param dono
	 * @param Requerente
	 * @param item
	 * @param periodo
	 * @param dataEmprestimo
	 */
	public Emprestimo(Usuario dono, Usuario requerente, Item item, String dataEmprestimo ,int periodo){
		
		this.dono = dono;
		this.requerente = requerente;
		this.item = item;
		this.periodo = periodo;
		this.dataEmprestimo = dataEmprestimo;
		this.dataFinal = this.calculaDataFinal(dataEmprestimo, periodo);
				
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
	
	public String getDataFinal() {
		return dataFinal;
	}
	
	/**
	 * 
	 * @param dataEmprestimo
	 * @param periodo
	 * @return
	 */
	private String calculaDataFinal(String dataEmprestimo, int periodo){
		
		String[] datasEmp = dataEmprestimo.split("/");
		Calendar calendarEmp = Calendar.getInstance();
		calendarEmp.set(Integer.parseInt(datasEmp[2]),Integer.parseInt(datasEmp[1]), Integer.parseInt(datasEmp[0]));
		calendarEmp.add(Calendar.DATE, periodo);
		
		return calendarEmp.get(Calendar.DAY_OF_MONTH) + "/" + calendarEmp.get(Calendar.MONTH)+ "/" + calendarEmp.get(Calendar.YEAR);
		
		
	}
	
	@Override
	public String toString() {
		return "Dono do item: " + dono.getNome() + " - Requerente:  " + requerente.getNome() + " - Item: " + item.getNomeItem() 
		+ " - Data Inicial do Emprestimo: " + dataEmprestimo + " - Data de Devolušao do Emprestimo: " + dataFinal;
	
	}
	


	
}