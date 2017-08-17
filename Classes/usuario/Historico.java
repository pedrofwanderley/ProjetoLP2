package usuario;
/**
 * @author Wesley
 */
import java.util.Calendar;

import E.SituacaoEmprestimo;
import itens.Item;

public class Historico {
	
	private Usuario usuario;
	private Item item;
	private SituacaoEmprestimo situacao;
	private String dataDevolucao;
	private String dataFinal;
	private int diasAtrasados;
	
	
	public Historico(Usuario usuario, Item item, SituacaoEmprestimo situacao, String dataFinal ,String dataDevolucao){
		
		this.usuario=usuario;
		this.item=item;
		this.situacao=situacao;
		this.dataDevolucao = dataDevolucao;
		this.dataFinal= dataFinal;
				
	}
	
	public Item getItem() {
		return item;
	}

	/**
	 * Calcula os dias atrasados que o item foi devolvido
	 * @param dataFinal
	 * @param dataDevolucao
	 * @return
	 */
	private int getDiasAtrasados(String dataFinal,String dataDevolucao){
		
		Calendar calendarFinal = Calendar.getInstance();
		String[] datasFinal = dataFinal.split("/");
		calendarFinal.set(Integer.parseInt(datasFinal[2]),Integer.parseInt(datasFinal[1]), Integer.parseInt(datasFinal[0]));
		
		
		Calendar calendarDev = Calendar.getInstance();
		String[] datasDev = dataDevolucao.split("/");
		calendarDev.set(Integer.parseInt(datasDev[2]),Integer.parseInt(datasDev[1]), Integer.parseInt(datasDev[0]));
		
		
		diasAtrasados = calendarFinal.get(Calendar.DAY_OF_YEAR) - calendarDev.get(Calendar.DAY_OF_YEAR);
		
		if(diasAtrasados > 0){
			return diasAtrasados;
		}else{
			return 0;
		}
		
		
	}
	
	public String toString(){
		return usuario + " - " + item + " - " + situacao+ " - " + dataDevolucao + " - " + getDiasAtrasados(dataFinal,dataDevolucao); 
	}
}
