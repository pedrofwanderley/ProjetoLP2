package pesquisa;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import chaves.ChaveUsuario;
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
	
	public String listarEmprestimosItem(Map<ChaveUsuario,Usuario> usuarios, String nomeItem) {
		List<Item> itens = geraListaItens(usuarios);
		String listaHistorico = "";
		for (Item item : itens) {
			if (nomeItem.equals(item.getNomeItem())) {
				listaHistorico = item.listarEmprestimosItem(nomeItem);
				
			}
		}
		return listaHistorico;
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
	
	
	

}