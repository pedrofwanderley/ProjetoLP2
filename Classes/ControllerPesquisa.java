import java.util.Collections;
import java.util.List;

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
	/**
	 * Método de ordenacao e exibicao de itens em ordem alfabetica.
	 * @param itens, o parametro é uma lista de itens.
	 * @return, retorna as representacoes dos itens em forma de string.
	 */
	public String listaItensUsuariosNome(List<Item> itens) {
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
	public String listaItensUsuariosValor(List<Item> itens) {
		ValorItemComparator comparator = new ValorItemComparator();
		Collections.sort(itens, comparator);
		String listaItens = "";
		for (int i = 0; i < itens.size(); i++) {
			listaItens += itens.get(i).toString() + "|";

		}

		return listaItens;
	}
	
	public String pesquisarDetalhesItem(List<Usuario> usuarios, String nome, String telefone, String nomeitem){
		String itemDetalhado = "";
		for (int i = 0; i < usuarios.size(); i++) {
			if (nome.equals(usuarios.get(i).getNome()) && telefone.equals(usuarios.get(i).getCelular()) && 
					usuarios.get(i).getItens().get(i).getNomeItem().equals(nomeitem)) {
						
					itemDetalhado = usuarios.get(i).getItens().get(i).toString();	
				
				
				
			}
			
		}
		return itemDetalhado;
	}
	
	

}