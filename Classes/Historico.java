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

	
	
	public Historico(Usuario usuario, Item item, SituacaoEmprestimo situacao){
		
		this.usuario=usuario;
		this.item=item;
		this.situacao=situacao;

		
	}
	
	public String toString(){
		return usuario + " - " + item + " - " + situacao;
	}
}
