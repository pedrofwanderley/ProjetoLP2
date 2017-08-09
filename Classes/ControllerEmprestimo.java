import java.util.*;

import itens.EstadoItem;


public class ControllerEmprestimo {
	
	
	private ArrayList <Emprestimo> emprestimos;
	
	public ControllerEmprestimo(){
		emprestimos = new ArrayList<Emprestimo>();
	}
	/**
	 * 
	 * @param nomeDono
	 * @param telefoneDono
	 * @param nomeRequerente
	 * @param telefoneRequerente
	 * @param nomeItem
	 * @param dataEmprestimo
	 * @param periodo
	 * @param usuarios
	 */
	
	
	public void registrarEmprestimo(String nomeDono, String telefoneDono, String nomeRequerente, String telefoneRequerente, 
			String nomeItem,String dataEmprestimo, int periodo, Map<String, Usuario> usuarios){
				
		if(usuarios.containsKey(nomeDono) && usuarios.get(nomeDono).getCelular().equals(telefoneDono)
				&& usuarios.containsKey(nomeRequerente) && usuarios.get(nomeRequerente).getCelular().equals(telefoneRequerente)){
									
			if(usuarios.get(nomeDono).getItens().containsKey(nomeItem)){
				
				if(usuarios.get(nomeDono).getItens().get(nomeItem).getEstado() == EstadoItem.NEmprestado){
					emprestimos.add(new Emprestimo(usuarios.get(nomeDono),usuarios.get(nomeRequerente),usuarios.get(nomeDono).getItens().get(nomeItem),dataEmprestimo, periodo));
					usuarios.get(nomeDono).getItens().get(nomeItem).setEstado(EstadoItem.Emprestado);
				
				}else{
					throw new IllegalArgumentException("Item emprestado no momento");
				}
				
			}else{
				throw new IllegalArgumentException("Item nao encontrado");
			}
			
		}else{
			throw new IllegalArgumentException("Usuario invalido");
		}
				
	}
		
	/**
	 * 
	 * @param nomeDono
	 * @param telefoneDono
	 * @param nomeRequerente
	 * @param telefoneRequerente
	 * @param nomeItem
	 * @param dataEmprestimo
	 * @param dataDevolucao
	 * @param conUsuario
	 */
	
	public void devolverItem(String nomeDono, String telefoneDono, String nomeRequerente, String telefoneRequerente, 
			String nomeItem, String dataEmprestimo, String dataDevolucao, UsuarioController conUsuario){
		
		int empSize = emprestimos.size();
		
		for(Emprestimo emprestimo : emprestimos){
						
			if(emprestimo.getDono().getNome().equals(nomeDono) && emprestimo.getDono().getCelular().equals(telefoneDono)
					&& emprestimo.getRequerente().getNome().equals(nomeRequerente) && emprestimo.getRequerente().getCelular().equals(telefoneRequerente)
					&& emprestimo.getItem().getNomeItem().equals(nomeItem)){
				
				emprestimos.remove(emprestimo);
				conUsuario.getUsuarios().get(nomeDono).getItens().get(nomeItem).setEstado(EstadoItem.NEmprestado);
				
				conUsuario.registraHistorico(conUsuario.getUsuarios().get(nomeDono), conUsuario.getUsuarios().get(nomeRequerente), emprestimo.getItem(), SituacaoEmprestimo.EMPRESTOU, emprestimo.getDataFinal(), dataDevolucao);
				conUsuario.registraHistorico(conUsuario.getUsuarios().get(nomeRequerente), conUsuario.getUsuarios().get(nomeDono), emprestimo.getItem(), SituacaoEmprestimo.DEVOLVIDO, emprestimo.getDataFinal(), dataDevolucao);
			}
		}
		
		if(emprestimos.size()==empSize){
			throw new IllegalArgumentException("Emprestimo nao encontrado");
			}
	}
	
	
	/**
	 * 
	 * @return
	 */
	
	public ArrayList<Emprestimo> getEmprestimos() {
		return emprestimos;
	}
	
	
}
