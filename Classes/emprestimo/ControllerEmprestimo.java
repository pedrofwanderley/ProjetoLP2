package emprestimo;
import java.util.*;

import chaves.ChaveEmprestimo;
import chaves.ChaveUsuario;
import itens.EstadoItem;
import itens.Item;
import usuario.Usuario;
import usuario.UsuarioController;


public class ControllerEmprestimo {
	
	private HashMap <ChaveEmprestimo, Emprestimo> emprestimos;
	
	
	public ControllerEmprestimo(){
		emprestimos = new HashMap<ChaveEmprestimo, Emprestimo>();
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
		
		ChaveEmprestimo chaveEmprestimo = new ChaveEmprestimo(nomeDono, nomeRequerente, telefoneDono, telefoneRequerente, dataEmprestimo, nomeItem);
		
		Emprestimo emprestimo = new Emprestimo(usuarioDono, usuarioRequerente, itemDesejado,dataEmprestimo, periodo);
		usuarios.get(chaveDono).setReputacao(dezporcento);
		emprestimos.put(chaveEmprestimo, emprestimo);
		itemDesejado.setEstado(EstadoItem.Emprestado);
		usuarioDono.getEmprestimos().add(emprestimo);
		usuarioRequerente.getEmprestimosPegos().add(emprestimo);
		itemDesejado.getHistoricoItem().add(emprestimo);
	}
		
	/**
	 * Delvove o emprestimo. Primeiro eh verificado se o na lista de emprestimos atuais tem o emprestimo que se deseja encerrar.
	 * Feito isto, eh retirado o emprestimo da lista e o item retorna ao seu estado original. 
	 * Tambem eh registrado no historico dos usuarios envolvidos o registro desse emprestimo.
	 * @param <E>
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
		
		ChaveUsuario chaveDono = new ChaveUsuario(nomeDono, telefoneDono);
		ChaveEmprestimo chaveEmprestimo = new ChaveEmprestimo(nomeDono, nomeRequerente, telefoneDono, telefoneRequerente, dataEmprestimo, nomeItem);
		
		
		if (!emprestimos.containsKey(chaveEmprestimo)) {
			throw new IllegalArgumentException("Emprestimo nao encontrado");
		}
		
		Emprestimo emprestimo = emprestimos.get(chaveEmprestimo);
		
		int atraso = calculaDiasAtrasados(emprestimo.getDataFinal(), dataDevolucao);
		
		conUsuario.getUsuarios().get(chaveDono).getItens().get(nomeItem).setEstado(EstadoItem.NEmprestado);
		
		emprestimo.setDataDevolucao(dataDevolucao);		
	
		conUsuario.registraHistorico(nomeDono, telefoneDono, nomeRequerente, nomeItem,"Emprestou"
				, dataDevolucao, atraso);
				
		conUsuario.registraHistorico(nomeRequerente, telefoneRequerente, nomeDono , nomeItem, "Devolvido"
				, dataDevolucao, atraso);
			
						
		if (atraso > 0) {
			double newReputacao = emprestimo.getRequerente().getReputacao() - (emprestimo.getItem().getValor() * 2 * 0.01);
			emprestimo.getRequerente().setReputacao(newReputacao);
				
		}
				
		if (atraso <= 0){
			double newReputacao = emprestimo.getRequerente().getReputacao() + (emprestimo.getItem().getValor() * 0.05);
			emprestimo.getRequerente().setReputacao(newReputacao);
					
			}
			
	}
			
	/**
	 *  
	 * @param dataFinal
	 * @param dataDevolucao
	 * @return
	 */

	private int calculaDiasAtrasados(String dataFinal,String dataDevolucao){
		
		Calendar calendarFinal = Calendar.getInstance();
		String[] datasFinal = dataFinal.split("/");
		calendarFinal.set(Integer.parseInt(datasFinal[2]),Integer.parseInt(datasFinal[1]), Integer.parseInt(datasFinal[0]));
		
		
		Calendar calendarDev = Calendar.getInstance();
		String[] datasDev = dataDevolucao.split("/");
		calendarDev.set(Integer.parseInt(datasDev[2]),Integer.parseInt(datasDev[1]), Integer.parseInt(datasDev[0]));
		
		
		int diasAtrasados =  calendarDev.get(Calendar.DAY_OF_YEAR) - calendarFinal.get(Calendar.DAY_OF_YEAR);
		
		if(diasAtrasados > 0){
			return diasAtrasados;
			
		}else{
			return 0;
		}
	}
	
	/**
	 * 
	 * @return emprestimo
	 */
	
	public HashMap<ChaveEmprestimo, Emprestimo> getEmprestimos() {
		return emprestimos;
	}
}
