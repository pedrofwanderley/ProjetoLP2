package emprestimo;
import java.util.*;

import itens.EstadoItem;
import usuario.Usuario;
import usuario.UsuarioController;


public class ControllerEmprestimo {
	
	
	private ArrayList <Emprestimo> emprestimos;
	
	public ControllerEmprestimo(){
		emprestimos = new ArrayList<Emprestimo>();
	}
	/**
	 * Realiza o emprestimo. Verifica se os usuarios, itens e disponiblidades de itens estao corretos para realizar o emprestimo.
	 * Feito isto, adiciona na lista de emprestimo, os emprestimos atuais e muda o estado do item para emprestado.
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
	 * Delvove o emprestimo. Primeiro eh verificado se o na lista de emprestimo eh o emprestimo que se deseja encerrar.
	 * Feito isto, eh retirado o emprestimo dos da lista de emprestimos atuais e o item retorna ao seu estado original. 
	 * Tambem eh registrado no historico dos usuarios envolvidos o registro desse emprestimo.
	 * dos usuarios envolvidos 
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
	 * @return emprestimo
	 */
	
	public ArrayList<Emprestimo> getEmprestimos() {
		return emprestimos;
	}
	
	
}
