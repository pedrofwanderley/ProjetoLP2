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
	
	public void registraEmreprestimo(String nomeDono, String telefoneDono, String nomeRequerente, String telefoneRequerente, 
			String nomeItem, int tempoEmprestimo){
		if(usuarioController.getUsuarios().containsKey(nomeDono). && usuarioController.getUsuarios().containsKey(nomeDono))
		
	}
	
	
	
	//necessario trocar usuario e itens para hashmap
	/*public void registraEmprestimo(String nomeDono, String telefoneDono, String nomeRequerente, String telefoneRequerente, 
			String nomeItem, int tempoEmprestimo){
		if(usuarioController.getUsuarios().)
			for(Usuario usuario:usuarioController.getUsuarios()){
				if(usuario.getNome().equals(nomeDono)){
					for(Item item:usuario.getItens()){
						if(item.getNomeItem().equals(nomeItem) && item.getEstado().equals("Item disponivel")){
							emprestimos.add(new Emprestimo(usuario, nomeRequerente, item, tempoEmprestimo));
						}
					}
				}
			}
		
	}*/
	
	
	

	
	/*public void registraEmprestimo(Usuario nomeDono, Usuario nomeRequerente, String nomeItem, int tempoEmprestimo){
		if(usuarioController.getUsuarios().contains(nomeDono) && usuarioController.getUsuarios().contains(nomeRequerente)){	
			for(Usuario usuario: usuarioController.getUsuarios()){
				if(usuario.getNome().equals(nomeDono) && usuario.getItens().contains(item)){
					for(Item item: usuario.getItens()){
						if(item.getEstado().equals("Item disponivel")){
							emprestimos.add(new Emprestimo(nomeDono, nomeRequerente, item, tempoEmprestimo));
						}
					}
									
				}else{
					System.out.println("Nao foi possivel realizar o emprestimo. Item nao existente ou nao disponivel");
				}
			}
		}else{
			System.out.println("Nao foi possivel realizar o emprestimo. Usuario(s) nao existente(s)");
		}
	}*/
		
	

	
	
	
	
	
	
	 
	public void devolverItem(){		
		usuarioController.registraHistorico(nomeDono, nomeRequerente ,item, SituacaoEmprestimo.EMPRESTOU);
	}
	
	
}
