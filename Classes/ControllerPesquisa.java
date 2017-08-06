import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import itens.Item;

/**
 * Classe de controle de pesquisas.
 * 
 * @author pedrofw
 *
 */
public class ControllerPesquisa {
	
	
	public ControllerPesquisa() {
	}
		
	public List<Item> geraListaItens(Map<String,Usuario> usuarios){
		List<Item> itensSistema = new ArrayList<>();
		for (Usuario usuario : usuarios.values()){
			for(Item item : usuario.getItens().values()){
				itensSistema .add(item);
			}
		}
		return itensSistema;
	}
	
	/**
	 * Método de ordenacao e exibicao de itens em ordem alfabetica.
	 * @param itens, o parametro é uma lista de itens.
	 * @return, retorna as representacoes dos itens em forma de string.
	 */
	public String listaItensUsuariosNome(Map<String,Usuario> usuarios) {
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
	public String listaItensUsuariosValor(Map<String,Usuario> usuarios) {
		List<Item> itens = geraListaItens(usuarios);
		ValorItemComparator comparator = new ValorItemComparator();
		Collections.sort(itens, comparator);
		String listaItens = "";
		for (int i = 0; i < itens.size(); i++) {
			listaItens += itens.get(i).toString() + "|";

		}

		return listaItens;
	}
	
	public String pesquisarDetalhesItem(Map<String,Usuario> usuarios, String nome, String telefone, String nomeitem){
		String itemDetalhado = "";
		int confereUsuario = 0;
		int confereItem = 0;
		for (Usuario usuario : usuarios.values()){
			if (nome.equals(usuario.getNome()) && telefone.equals(usuario.getCelular())) {
				confereUsuario++;
				for(Item itens : usuario.getItens().values()){
					if (nomeitem.equals(itens.getNomeItem())){
						confereItem++;
						itemDetalhado = itens.toString();
					}
					
				}
							
			}
			
			
		}
		if (confereUsuario == 0) {
			throw new IllegalArgumentException("Usuario invalido");
			
		}
		else if(confereItem == 0){
			throw new IllegalArgumentException("Item nao encontrado");
		}
		
		return itemDetalhado;
	}
	
	
	

}