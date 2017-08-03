/**
 * @author wesley
 */

import java.util.*;

import itens.Item;
import itens.SituacaoEmprestimo;

public class ControllerEmprestimo {
	
	UsuarioController usuarioController = new UsuarioController();
	
	private ArrayList <Emprestimo> emprestimos;
	
	public ControllerEmprestimo(){
		emprestimos = new ArrayList<Emprestimo>();
	}
	
	//verificar se os usuarios e item existem e pode ser emprestado
	public void registraEmprestimo(Usuario donoItem, Usuario usuarioEmprestado, Item item, int tempoEmprestimo){
		emprestimos.add(new Emprestimo(donoItem, usuarioEmprestado, item, tempoEmprestimo));
		usuarioController.registraHistorico(donoItem, usuarioEmprestado,item, SituacaoEmprestimo.EMPRESTOU);
		
	}
	 
	public void devolverItem(){
		
		usuarioController.registraHistorico(usuarioEmprestado, donoItem, item, SituacaoEmprestimo.EMPRESTADO, dataFinal, diasAtrasados);
	}
	
	
}
