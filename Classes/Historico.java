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
	private Calendar dataFinal;
	private int diasAtrasados = 0;
	
	
	public Historico(Usuario usuario, Item item, SituacaoEmprestimo situacao,Calendar dataFinal){
		
		this.usuario=usuario;
		this.item=item;
		this.situacao=situacao;
		this.dataFinal=dataFinal;

		
	}
	
	public int getDiasAtrasados(){
		Calendar.getInstance();
		return diasAtrasados = Calendar.DAY_OF_YEAR - dataFinal.DAY_OF_YEAR;
	}
	
	public String toString(){
		return usuario + " - " + item + " - " + situacao+ " - " + dataFinal + " - " + diasAtrasados; 
	}
}
