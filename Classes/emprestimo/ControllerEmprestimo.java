package emprestimo;
import java.util.*;

import chaves.ChaveUsuario;
import itens.EstadoItem;
import itens.Item;
import usuario.Usuario;
import usuario.UsuarioController;


public class ControllerEmprestimo {
	
	
	private ArrayList <Emprestimo> emprestimos;
	
	public ControllerEmprestimo(){
		emprestimos = new ArrayList<Emprestimo>();
	}
	/**
	 * Realiza o emprestimo. Verifica se os usuarios, item e disponiblidades do item estao corretos para realizar o emprestimo.
	 * Feito isto, adiciona na lista de emprestimos atuais, o emprestimos e muda o estado do item para emprestado.
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
			String nomeItem,String dataEmprestimo, int periodo, Map<ChaveUsuario, Usuario> usuarios){
		
		ChaveUsuario chaveDono = new ChaveUsuario(nomeDono, telefoneDono);
		ChaveUsuario chaveRequerente = new ChaveUsuario(nomeRequerente, telefoneRequerente);
				
		if (!usuarios.containsKey(chaveDono) || !usuarios.containsKey(chaveRequerente)) {
			throw new IllegalArgumentException("Usuario invalido");
		}
		
		Usuario usuarioDono = usuarios.get(chaveDono);
		Usuario usuarioRequerente = usuarios.get(chaveRequerente);
		HashMap<String, Item> itensDoDono = usuarioDono.getItens();
		
		if (!itensDoDono.containsKey(nomeItem)) {
			throw new IllegalArgumentException("Item nao encontrado");
		}
		
		Item itemDesejado = itensDoDono.get(nomeItem);
		
		if (itemDesejado.getEstado() == EstadoItem.Emprestado) {
			throw new IllegalArgumentException("Item emprestado no momento");
		}
		
		double dezporcento = (itemDesejado.getValor() * 0.10) + usuarioDono.getReputacao();
		
		Emprestimo emprestimo = new Emprestimo(usuarioDono, usuarioRequerente, itemDesejado,dataEmprestimo, periodo);
		usuarios.get(chaveDono).setReputacao(dezporcento);
		emprestimos.add(emprestimo);
		itemDesejado.setEstado(EstadoItem.Emprestado);
	}
		
	/**
	 * Delvove o emprestimo. Primeiro eh verificado se o na lista de emprestimos atuais tem o emprestimo que se deseja encerrar.
	 * Feito isto, eh retirado o emprestimo da lista e o item retorna ao seu estado original. 
	 * Tambem eh registrado no historico dos usuarios envolvidos o registro desse emprestimo.
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
