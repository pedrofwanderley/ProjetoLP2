package emprestimo;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

import chaves.ChaveEmprestimo;
import chaves.ChaveUsuario;
import itens.EstadoItem;
import itens.Item;
import usuario.Usuario;
import usuario.ControllerUsuario;

/**
 * Classe controladora de emprestimos.
 * @author Wesley
 *
 */
public class ControllerEmprestimo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map <ChaveEmprestimo, Emprestimo> emprestimos;
	
	
	public ControllerEmprestimo(){
		emprestimos = new HashMap<ChaveEmprestimo, Emprestimo>();
	}
	/**
	 * 
	 * @return emprestimo
	 */
	
	public Map<ChaveEmprestimo, Emprestimo> getEmprestimos() {
		return emprestimos;
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
	 * @throws IOException 
	 * @throws Exception 
	 */
	
	
	public void registrarEmprestimo(String nomeDono, String telefoneDono, String nomeRequerente, String telefoneRequerente, 
			String nomeItem,String dataEmprestimo, int periodo, Map<ChaveUsuario, Usuario> usuarios) throws IOException {
		
		ChaveUsuario chaveDono = new ChaveUsuario(nomeDono, telefoneDono);
		ChaveUsuario chaveRequerente = new ChaveUsuario(nomeRequerente, telefoneRequerente);
				
		if (!usuarios.containsKey(chaveDono) || !usuarios.containsKey(chaveRequerente)) 
			throw new IllegalArgumentException("Usuario invalido");
		
		Usuario usuarioDono = usuarios.get(chaveDono);
		Usuario usuarioRequerente = usuarios.get(chaveRequerente);
		
		if (usuarioRequerente.getReputacao() < 0) 
			throw new IllegalArgumentException("Usuario nao pode pegar nenhum item emprestado");
		
		HashMap<String, Item> itensDoDono = usuarioDono.getItens();
		
		if (!itensDoDono.containsKey(nomeItem)) 
			throw new IllegalArgumentException("Item nao encontrado");
		
		Item itemDesejado = itensDoDono.get(nomeItem);
		
		if (itemDesejado.getEstado() == EstadoItem.Emprestado) {
			throw new IllegalArgumentException("Item emprestado no momento");
		}
		
		ChaveEmprestimo chaveEmprestimo = new ChaveEmprestimo(nomeDono, nomeRequerente, telefoneDono, 
				telefoneRequerente, dataEmprestimo, nomeItem);
		
		Emprestimo emprestimo = new Emprestimo(usuarioDono, usuarioRequerente, itemDesejado,dataEmprestimo, periodo);
		
		podePedirEmprestado(usuarioRequerente, periodo);
		
		usuarioDono.reputacaoEmprestimoItem(itemDesejado.getValor());
		verificaCartao(usuarioDono);
		itemDesejado.setEstado(EstadoItem.Emprestado);
		emprestimos.put(chaveEmprestimo, emprestimo);
		emprestimo.setDataDevolucao("Emprestimo em andamento");
		usuarioDono.getEmprestimosEmprestando().add(emprestimo);
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
			String nomeItem, String dataEmprestimo, String dataDevolucao, ControllerUsuario controllerUsuario) {

		ChaveUsuario chaveDono = new ChaveUsuario(nomeDono, telefoneDono);
		ChaveEmprestimo chaveEmprestimo = new ChaveEmprestimo(nomeDono, nomeRequerente, telefoneDono,
				telefoneRequerente, dataEmprestimo, nomeItem);

		if (!emprestimos.containsKey(chaveEmprestimo)) {
			throw new IllegalArgumentException("Emprestimo nao encontrado");
		}

		Emprestimo emprestimo = emprestimos.get(chaveEmprestimo);

		int atraso = calculaDiasAtrasados(emprestimo.getDataFinal(), dataDevolucao);

		modificaEstadoEmprestimoItem(controllerUsuario, chaveDono, nomeItem);
		emprestimo.setDataDevolucao(dataDevolucao);

		controllerUsuario.registraHistorico(nomeDono, telefoneDono, nomeRequerente, nomeItem, "Emprestou", dataDevolucao,
				atraso);

		controllerUsuario.registraHistorico(nomeRequerente, telefoneRequerente, nomeDono, nomeItem, "Devolvido", dataDevolucao,
				atraso);

		Usuario requerente = emprestimo.getRequerente();
		double valorItem = emprestimo.getItem().getValor();

		if (atraso > 0) {
			requerente.reputacaoDevolucaoForaDoPrazo(valorItem, atraso);
		} else {
			requerente.reputacaoDevolucaoNoPrazo(valorItem);
		}

		verificaCartao(requerente);

	}
	/**
	 * Metodo que modifica o estado de um item.	
	 * @param conUsuario, COntrollerUsuário
	 * @param chaveDono, chave do mapa de usuários, que representa o dono.
	 * @param nomeItem, nome do item a ser modificado o estado.
	 */
	private void modificaEstadoEmprestimoItem(ControllerUsuario conUsuario, ChaveUsuario chaveDono, String nomeItem) {
		
		Usuario usuarioDono = conUsuario.getUsuarios().get(chaveDono);
		Item itemEmprestimo = usuarioDono.getItens().get(nomeItem);
		itemEmprestimo.setEstado(EstadoItem.NEmprestado);
		
	}
	/**
	 * Metodo que define se um usuário pode ou não pedir emprestado, dependendo do seu cartão fidelidade.
	 * @param requerente, Usuário requerente.
	 * @param periodo, periodo de empréstimo.
	 */
	private void podePedirEmprestado(Usuario requerente, int periodo) {
		if (requerente.getCartao().equals("Noob") && periodo > 7) {
			throw new IllegalArgumentException("Usuario impossiblitado de pegar emprestado por esse periodo");
		}
		
		if (requerente.getCartao().equals("BomAmigo") && periodo > 14) {
			throw new IllegalArgumentException("Usuario impossiblitado de pegar emprestado por esse periodo");
		}
		
		if (requerente.getCartao().equals("FreeRyder") && periodo > 5) {
			throw new IllegalArgumentException("Usuario impossiblitado de pegar emprestado por esse periodo");
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
		calendarFinal.set(Integer.parseInt(datasFinal[2]), Integer.parseInt(datasFinal[1]), Integer.parseInt(datasFinal[0]));
		
		Calendar calendarDev = Calendar.getInstance();
		String[] datasDev = dataDevolucao.split("/");
		calendarDev.set(Integer.parseInt(datasDev[2]), Integer.parseInt(datasDev[1]), Integer.parseInt(datasDev[0]));
		
		int diasAtrasados =  calendarDev.get(Calendar.DAY_OF_YEAR) - calendarFinal.get(Calendar.DAY_OF_YEAR);
		
		if(diasAtrasados > 0){
			return diasAtrasados;
			
		}else{
			return 0;
		}
	}
	
	
	private void verificaCartao(Usuario usuario) {
		ControllerUsuario usuarioController = new ControllerUsuario();
		usuarioController.verificaCartao(usuario);
	}
	
	/**
	 * Metodo de gravacao da colecao de emprestimos em um arquivo.
	 * @param map, mapa de emprestimos.
	 * @param arquivo, nome do arquivo a ser direcionada a gravacao.
	 */
	public void gravaEmprestimos(Map<ChaveEmprestimo, Emprestimo> map, String arquivo){
		FileOutputStream arquivoEmprestimos;
		try {
			arquivoEmprestimos = new FileOutputStream(arquivo);
			ObjectOutputStream gravarEmprestimos = new ObjectOutputStream(arquivoEmprestimos);
			gravarEmprestimos.writeObject(map);
			gravarEmprestimos.flush();
			gravarEmprestimos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * Metodo de recuperacao de mapa de emprestimos.
	 * @param arquivo, nome do arquivo onde se encontra o mapa.
	 * @return, retorna o mapa de emprestimos recuperado.
	 */
	public Map<ChaveEmprestimo, Emprestimo> recuperaEmprestimos(String arquivo){
		File arquivoEmprestimos = null;
		arquivoEmprestimos = new File(arquivo);
		Map<ChaveEmprestimo, Emprestimo> map = new HashMap<>();
		FileInputStream fis;
		try {
			if (!arquivoEmprestimos.exists()) {
				arquivoEmprestimos.createNewFile();
			}
			else if (arquivoEmprestimos.length() == 0) {
				System.out.println("ARQUIVO VAZIO");
			}else{
			fis = new FileInputStream(arquivo);
			ObjectInputStream ois = new ObjectInputStream(fis);
			map = (Map<ChaveEmprestimo, Emprestimo>) ois.readObject();
			ois.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return map;
		
		
	}
	
}
