import java.util.*;

import itens.EstadoItem;
import itens.SituacaoEmprestimo;


public class ControllerEmprestimo {
	
	
	private ArrayList <Emprestimo> emprestimos;
	
	public ControllerEmprestimo(){
		emprestimos = new ArrayList<Emprestimo>();
	}
	
	
	
	public void registrarEmprestimo(String nomeDono, String telefoneDono, String nomeRequerente, String telefoneRequerente, 
			String nomeItem,String dataEmprestimo, int periodo, Map<String, Usuario> usuarios) throws Exception{
		
		if(usuarios.containsKey(nomeDono) && usuarios.get(nomeDono).getCelular().equals(telefoneDono)
				&& usuarios.containsKey(nomeRequerente) && usuarios.get(nomeRequerente).getCelular().equals(telefoneRequerente)){
									
			if(usuarios.get(nomeDono).getItens().containsKey(nomeItem)){
								
				if(usuarios.get(nomeDono).getItens().get(nomeItem).getEstado() == EstadoItem.NEmprestado){
					emprestimos.add(new Emprestimo(usuarios.get(nomeDono),usuarios.get(nomeRequerente),usuarios.get(nomeDono).getItens().get(nomeItem),dataEmprestimo, periodo, this.calculaDataDevolucao(dataEmprestimo, periodo)));
					usuarios.get(nomeDono).getItens().get(nomeItem).setEstado(EstadoItem.Emprestado);
				
				}else{
					throw new Exception("Item emprestado no momento");
				}
				
			}else{
				throw new Exception("Item nao encontrado");
			}
			
		}else{
			throw new Exception("Usuario invalido");
		}
				
	}
		
			
	
	public void devolverItem(String nomeDono, String telefoneDono, String nomeRequerente, String telefoneRequerente, 
			String nomeItem, String dataEmprestimo, String dataDevolucao, UsuarioController conUsuario) throws Exception{
		
		int empSize = emprestimos.size();
		
		for(Emprestimo emprestimo : emprestimos){
						
			if(emprestimo.getDono().getNome().equals(nomeDono) && emprestimo.getDono().getCelular().equals(telefoneDono)
					&& emprestimo.getRequerente().getNome().equals(nomeRequerente) && emprestimo.getRequerente().getCelular().equals(telefoneRequerente)
					&& emprestimo.getItem().getNomeItem().equals(nomeItem)){
				
				emprestimos.remove(emprestimo);
				conUsuario.getUsuarios().get(nomeDono).getItens().get(nomeItem).setEstado(EstadoItem.NEmprestado);
				
				conUsuario.registraHistorico(conUsuario.getUsuarios().get(nomeDono), conUsuario.getUsuarios().get(nomeRequerente), emprestimo.getItem(), SituacaoEmprestimo.EMPRESTOU, dataDevolucao);
				conUsuario.registraHistorico(conUsuario.getUsuarios().get(nomeRequerente), conUsuario.getUsuarios().get(nomeDono), emprestimo.getItem(), SituacaoEmprestimo.DEVOLVIDO, dataDevolucao);
			}
		}
		
		if(emprestimos.size()==empSize){
			throw new Exception("Emprestimo nao encontrado");
			}
	}
	
	
	private String calculaDataDevolucao(String dataEmprestimo, int periodo){
		
		String[] datasEmp = dataEmprestimo.split("/");
		Calendar calendarEmp = Calendar.getInstance();
		calendarEmp.set(Integer.parseInt(datasEmp[2]),Integer.parseInt(datasEmp[1])-1, Integer.parseInt(datasEmp[0]));
		calendarEmp.add(Calendar.DATE, periodo);
		
		return calendarEmp.get(Calendar.DAY_OF_MONTH) + "/" + calendarEmp.get(Calendar.MONTH)+ "/" + calendarEmp.get(Calendar.YEAR);
		
		
	}
	
	public ArrayList<Emprestimo> getEmprestimos() {
		return emprestimos;
	}
	
	
}
