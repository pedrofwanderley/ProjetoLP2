package emprestimos;
import java.util.Calendar;

import itens.Item;
import usuario.Usuario;


public class Emprestimo {
	
	private Usuario dono;
	private Usuario requerente;
	private Item item;
	private int periodo;
	private String dataEmprestimo;
	private String dataFinal;
		

	public Emprestimo(Usuario dono, Usuario requerente, Item item, String dataEmprestimo ,int periodo){
		
		this.dono = dono;
		this.requerente = requerente;
		this.item = item;
		this.periodo = periodo;
		this.dataEmprestimo =dataEmprestimo;
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
	
	
	
	public void setDataFinal(String dataFinal) {
		this.dataFinal = dataFinal;
	}
	public String estadoDataFinal() {
		if ("Emprestado".equals(item.getEstado().getEstadoItem())) {
			return "Emprestimo em andamento";
		}else {
			return dataFinal;
		}
	}

	/**
	 * Calcula a data que eh pra ser devolvido o item
	 * @param dataEmprestimo
	 * @param periodo
	 * @return
	 */
	private String calculaDataFinal(String dataEmprestimo, int periodo){
		
		String[] datasEmp = dataEmprestimo.split("/");
		Calendar calendarEmp = Calendar.getInstance();
		calendarEmp.set(Integer.parseInt(datasEmp[2]),Integer.parseInt(datasEmp[1]), Integer.parseInt(datasEmp[0]));
		calendarEmp.add(Calendar.DATE, periodo-1);
		
		return calendarEmp.get(Calendar.DAY_OF_MONTH) + "/" + calendarEmp.get(Calendar.MONTH)+ "/" + calendarEmp.get(Calendar.YEAR);
	}
	
	
	
	
	@Override
	public String toString() {
		return "EMPRESTIMO - De: " + dono.getNome() + ", Para: " + requerente.getNome() + ", "+ item.getNomeItem() 
		+ ", " + dataEmprestimo + ", " + periodo + " dias, " + "ENTREGA: " + estadoDataFinal();
	
	}
	


	
}
