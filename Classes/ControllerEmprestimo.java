/**
 /**
 * @author wesley
 */

import java.util.*;

import itens.SituacaoEmprestimo;

public class ControllerEmprestimo {
	
	private UsuarioController usuarioController = new UsuarioController();
	
	private ArrayList <Emprestimo> emprestimos;
	
	public ControllerEmprestimo(){
		emprestimos = new ArrayList<Emprestimo>();
	}
	
	public void registraEmreprestimo(String nomeDono, String telefoneDono, String nomeRequerente, String telefoneRequerente, 
			String nomeItem, int tempoEmprestimo){
		
		if(usuarioController.getUsuarios().containsKey(nomeDono) && usuarioController.getUsuarios().get(nomeDono).getCelular().equals(telefoneDono)
				&& usuarioController.getUsuarios().containsKey(nomeRequerente) && usuarioController.getUsuarios().get(nomeRequerente).getCelular().equals(telefoneRequerente)){
			if(usuarioController.getUsuarios().get(nomeDono).getItens().containsKey(nomeItem) && usuarioController.getUsuarios().get(nomeDono).getItens().get(nomeItem).getEstado().equals("Nao emprestado")){
				emprestimos.add(new Emprestimo(usuarioController.getUsuarios().get(nomeDono),usuarioController.getUsuarios().get(nomeRequerente),usuarioController.getUsuarios().get(nomeDono).getItens().get(nomeItem), tempoEmprestimo));
			}else{
				System.out.println("Nao foi possivel realizar emprestimo. Item nao esta disponivel ou nao existe");
			}
		}else{
			System.out.println("Nao foi possivel realizar emprestimo. Usuario(s) nao localizados ou nao registrado(s).");
		}
		
		
	}
	 
	public void devolverItem(String nomeDono, String telefoneDono, String nomeRequerente, String telefoneRequerente, 
			String nomeItem){
		
		for(Emprestimo emprestimo : emprestimos){
			if(emprestimo.getDono().equals(nomeDono) && emprestimo.getDono().getCelular().equals(telefoneDono)
					&& emprestimo.getRequerente().equals(nomeRequerente) && emprestimo.getRequerente().getCelular().equals(telefoneRequerente)
					&& emprestimo.getItem().getNomeItem().equals(nomeItem)){
				emprestimos.remove(emprestimo);
				usuarioController.registraHistorico(usuarioController.getUsuarios().get(nomeDono), usuarioController.getUsuarios().get(nomeRequerente), emprestimo.getItem(), SituacaoEmprestimo.EMPRESTOU, emprestimo.getDataFinal());
				usuarioController.registraHistorico(usuarioController.getUsuarios().get(nomeRequerente), usuarioController.getUsuarios().get(nomeDono), emprestimo.getItem(), SituacaoEmprestimo.DEVOLVIDO, emprestimo.getDataFinal());
				System.out.println("Devolucao feita com sucesso!");
			}
		}
				
	}
	
	
}