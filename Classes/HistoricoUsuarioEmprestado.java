import java.util.Calendar;

import itens.Item;
import itens.SituacaoEmprestimo;

public class HistoricoUsuarioEmprestado extends Historico{
	
	private Calendar dataFinal;
	private int diasAtrasados;
	
	public HistoricoUsuarioEmprestado(Usuario usuario, Item item, SituacaoEmprestimo situacao, Calendar dataFinal, int diasAtrasados) {
		super(usuario, item, situacao);
		this.diasAtrasados= diasAtrasados;
		this.dataFinal=dataFinal;
	}
	
	public String toString(){
		return super.toString() + " - " + dataFinal + " - " + diasAtrasados; 
	}
}
