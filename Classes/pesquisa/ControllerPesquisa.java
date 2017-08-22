package pesquisa;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import chaves.ChaveUsuario;
import emprestimo.Emprestimo;
import itens.Item;
import usuario.Usuario;

/**
 * Classe de controle de pesquisas.
 * 
 * @author pedrofw
 *
 */
public class ControllerPesquisa {
	
	
	public ControllerPesquisa() {
		
	}
	
	/**
	 * Método que gera uma lista de itens	
	 * @param usuarios, tem como parametro um hashmap de usuarios.
	 * @return, retorna uma lista de itens.
	 */
	public List<Item> geraListaItens(Map<ChaveUsuario,Usuario> usuarios){
		List<Item> itensSistema = new ArrayList<>();
		for (Usuario usuario : usuarios.values()){
			for(Item item : usuario.getItens().values()){
				itensSistema.add(item);
				
			}
		}
		return itensSistema;
	}
	/**
	 * Metodo que pesquisa em uma lista de item, um determinado item e  lista o historico de emprestimo de item
	 * @param usuarios, mapa de usuarios.
	 * @param nomeItem, nome do item a ser avaliado o historico
	 * @return, retorna os emprestimos do item em questão;
	 */
	
	public String listarEmprestimosItem(Map<ChaveUsuario, Usuario> usuarios, String nomeItem) {
		List<Item> itens = geraListaItens(usuarios);
		String listaHistorico =  "Emprestimos associados ao item: ";
		boolean conferehistorico = false;
		for (Item item : itens) {
			if (nomeItem.equals(item.getNomeItem()) && item.getHistoricoItem().size() > 0) {
				conferehistorico = true;
				for (Emprestimo emprestimo : item.getHistoricoItem()) {
					listaHistorico += emprestimo.toString() + "|";

				}

			}
		}
		if (!conferehistorico) {
			listaHistorico = "Nenhum emprestimos associados ao item";
			
		}
		return listaHistorico;
	}
	/**
	 * Metodo que lista os itens que nao foram emprestados no sistema.
	 * @param usuarios, mapa de usuarios
	 * @return, retorna um representacao em string dos itens nao emprestados, ordenados pelo nome do item.
	 */
	public String listarItensNaoEmprestados(Map<ChaveUsuario, Usuario> usuarios) {
		List<Item> itens = geraListaItens(usuarios);
		List<Item> listaItensNaoEmprestados = new ArrayList<>();
		for (Item item : itens) {
			if ("Nao emprestado".equals(item.getEstado().getEstadoItem())) {
				listaItensNaoEmprestados.add(item);

			}
		}
		NomeItemComparator comparator = new NomeItemComparator();
		Collections.sort(listaItensNaoEmprestados, comparator);
		String itensNaoEmprestados = "";
		for (Item item : listaItensNaoEmprestados) {
			itensNaoEmprestados += item.toString() + "|";

		}
		return itensNaoEmprestados;

	}

	public String listaTopitens(Map<ChaveUsuario, Usuario> usuarios) {

		List<Item> itens = geraListaItens(usuarios);
		TopItensComparator comparator = new TopItensComparator();
		Collections.sort(itens, comparator);
		String top10 = "";
		int cont = 1;
		for (Item item : itens) {
			if (item.getHistoricoItem().size() == 0 || cont > 10) {
				break;

			}
			top10 += cont + ") " + item.getHistoricoItem().size() + " emprestimos - " + item.toString() + "|";
			cont++;
			
		}

		return top10;

	}	
	/**
	 * Metodo que lista itens emprestados no momento
	 * @param usuarios, mapa de usuarios.
	 * @return, retorna uma representacao em string dos nomes dos donos dos itens e dos nome dos itens emprestados.
	 */
	public String listarItensEmprestados(Map<ChaveUsuario, Usuario> usuarios) {
		String itensEmprestados = "";
		for (Usuario usuario : usuarios.values()) {
			for (Item item : usuario.getItens().values()) {
				if ("Emprestado".equals(item.getEstado().getEstadoItem())) {
					itensEmprestados += "Dono do item: " + usuario.getNome() + ", " + "Nome do item emprestado: "
							+ item.getNomeItem() + "|";
				}

			}

		}
		return itensEmprestados;

	}
	/**
	 * Metodo de ordenacao e exibicao de itens em ordem alfabetica.
	 * @param itens, o parametro é uma lista de itens.
	 * @return, retorna as representacoes dos itens em forma de string.
	 */
	public String listaItensUsuariosNome(Map<ChaveUsuario, Usuario> usuarios) {
		List<Item> itens = geraListaItens(usuarios);
		NomeItemComparator comparator = new NomeItemComparator();
		Collections.sort(itens, comparator);
		String listaItens = "";
		for (int i = 0; i < itens.size(); i++) {
			listaItens += itens.get(i).toString() + "|";

		}
		return listaItens;
	}
	/**
	 * Metodo de ordenacao e exibicao de itens por ordem de valor.
	 * @param itens, o parametro é uma lista de itens
	 * @return, retorna uma representacao em string de todos os itens dos usuários.
	 */
	public String listaItensUsuariosValor(Map<ChaveUsuario, Usuario> usuarios) {
		List<Item> itens = geraListaItens(usuarios);
		ValorItemComparator comparator = new ValorItemComparator();
		Collections.sort(itens, comparator);
		String listaItens = "";
		for (int i = 0; i < itens.size(); i++) {
			listaItens += itens.get(i).toString() + "|";

		}
		return listaItens;
	}
	/**
	 * Metodo de pesquisa de detalhes de um determinado item.
	 * @param usuarios, tem como primeiro parametro um hashmap de usuarios.
	 * @param nome, tem como segundo parametro o nome de um usuario.
	 * @param telefone, tem como terceiro parametro o telefonede um usuario.
	 * @param nomeitem, tem como quarto parametro o nome do item a ser detalhado.
	 * @return, retorna uma representacao em string do item desejado.
	 */
	public String pesquisarDetalhesItem(Map<ChaveUsuario, Usuario> usuarios, String nome, String telefone, String nomeitem){
		String itemDetalhado = "";
		boolean confereUsuario = false;
		boolean confereItem = false;
		for (Usuario usuario : usuarios.values()){
			if (nome.equals(usuario.getNome()) && telefone.equals(usuario.getCelular())) {
				confereUsuario = true;
				for(Item itens : usuario.getItens().values()){
					if (nomeitem.equals(itens.getNomeItem())){
						confereItem = true;
						itemDetalhado = itens.toString();
					}
					
				}
							
			}
			
			
		}
		if (!confereUsuario) {
			throw new IllegalArgumentException("Usuario invalido");
			
		}
		else if(!confereItem){
			throw new IllegalArgumentException("Item nao encontrado");
		}
		
		return itemDetalhado;
	}
	
	public String listarCaloteiros(Map<ChaveUsuario, Usuario> usuarios){
		
		List <String> caloteiros = new ArrayList <String>();
		String listaCaloteiros = "Lista de usuarios com reputacao negativa: ";
		
		for(Usuario usuario: usuarios.values()){
			
			if(usuario.getCartao().equals("Caloteiro")){
				caloteiros.add(usuario.toString());
				
			}
		}
		Collections.sort(caloteiros, new NomeComparator());
		
		for(String caloteiro : caloteiros){
			listaCaloteiros += caloteiro + "|";
		}
	
		return listaCaloteiros;
	}
	
	public String listarTop10MelhoresUsuarios(Map<ChaveUsuario, Usuario> usuarios){
		
		ArrayList <Usuario> listaUsuarios = new ArrayList<Usuario>();
		String Top10Usuarios = "";
		
		for (Usuario usuario:usuarios.values()){
			listaUsuarios.add(usuario);
			
		}
			
		Collections.sort(listaUsuarios, new ReputacaoComparator());
		
		for(int i = 0; i<10; i++){
			
			Top10Usuarios += i+1 +":" + listaUsuarios.get(i).getNome() + " - Reputacao" + listaUsuarios.get(i).getReputacao() + "|" ;
		}
		
		return Top10Usuarios;
	}
//!!
public String listarTop10PioresUsuarios(Map<ChaveUsuario, Usuario> usuarios){
		
		ArrayList <Usuario> listaUsuarios = new ArrayList<Usuario>();
		String Top10Usuarios = "";
		
		for (Usuario u:usuarios.values()){
			listaUsuarios.add(u);
			
		}
			
		//Collections.sort(listaUsuarios, new ReputacaoComparator());
		
		for(int i = 0; i<10; i++){
			
			Top10Usuarios += i+1 +":" + listaUsuarios.get(i).getNome() + " - Reputacao" + listaUsuarios.get(i).getReputacao() + "|" ;
		}
		
		return Top10Usuarios;
	}
	
	
	

}
