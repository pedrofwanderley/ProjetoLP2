/**
 * @author Wesley
 */
import java.util.Calendar;

import itens.Item;
import itens.SituacaoEmprestimo;

public class Historico {
	
	private Usuario usuario;
	private Item item;
	private SituacaoEmprestimo situacao;
	private String dataDevolucao;
	private int diasAtrasados;
	
	
	public Historico(Usuario usuario, Item item, SituacaoEmprestimo situacao, String dataDevolucao){
		
		this.usuario=usuario;
		this.item=item;
		this.situacao=situacao;
		this.dataDevolucao = dataDevolucao;
		
		
	}
	
	private int getDiasAtrasados(String dataDevolucao){
		
		Calendar dataAtual = Calendar.getInstance();
		Calendar calendarDev = Calendar.getInstance();
		
		String[] datasDev = dataDevolucao.split("/");
		calendarDev.set(Integer.parseInt(datasDev[2]),Integer.parseInt(datasDev[1])-1, Integer.parseInt(datasDev[0]));
		
		diasAtrasados = dataAtual.get(Calendar.DAY_OF_YEAR) - calendarDev.get(Calendar.DAY_OF_YEAR);
		
		if(diasAtrasados > 0){
			return diasAtrasados;
		}else{
			return 0;
		}
		
		
	}
	
	public String toString(){
		return usuario + " - " + item + " - " + situacao+ " - " + dataDevolucao + " - " + getDiasAtrasados(dataDevolucao); 
	}
}
