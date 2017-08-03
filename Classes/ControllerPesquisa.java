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
			listaItens += itens.get(i).toString() + System.lineSeparator();

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
			listaItens += itens.get(i).toString() + System.lineSeparator();

		}

		return listaItens;
	}
	
	

}