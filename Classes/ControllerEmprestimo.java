/**
 * @author wesley
 */

import java.util.*;

import itens.Item;
import itens.SituacaoEmprestimo;

public class ControllerEmprestimo {
	
	private UsuarioController usuarioController = new UsuarioController();
	
	private ArrayList <Emprestimo> emprestimos;
	
	public ControllerEmprestimo(){
		emprestimos = new ArrayList<Emprestimo>();
	}
	
	//verificar se os usuarios e item existem e pode ser emprestado
	public void registraEmprestimo(Usuario donoItem, Usuario usuarioEmprestado, Item item, int tempoEmprestimo){
		if(usuarioController.getUsuarios().contains(donoItem) && usuarioController.getUsuarios().contains(usuarioEmprestado)){
			if(item){
				emprestimos.add(new Emprestimo(donoItem, usuarioEmprestado, item, tempoEmprestimo));
				
				
			}else{
				System.out.println("Nao foi possivel realizar emprestimo. Item nao existente ou nao disponivel ");
			}
		}else{
			System.out.println("Nao foi possivel realizar emprestimo. Usuario(s) nao existente(s)");
						
		}
		
		
		
		
		
		
	}
	 
	public void devolverItem(){		
		usuarioController.registraHistorico(donoItem, usuarioEmprestado,item, SituacaoEmprestimo.EMPRESTOU);
	}
	
	
}
