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
	private int diasAtrasados;
	
	
	public Historico(Usuario usuario, Item item, SituacaoEmprestimo situacao,Calendar dataFinal){
		
		this.usuario=usuario;
		this.item=item;
		this.situacao=situacao;
		this.diasAtrasados= diasAtrasados;
		this.dataFinal=dataFinal;

		
	}
	
	public String toString(){
		return usuario + " - " + item + " - " + situacao+ " - " + dataFinal + " - " + diasAtrasados; 
	}
}
