import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import itens.Item;
/**
 * Classe de controle de pesquisas.
 * @author pedrofw
 *
 */
public class ControllerPesquisa {


	public ControllerPesquisa() {
	}

	public String listaItensUsuariosNome(List<Item> itens) {
		NomeItemComparator comparator = new NomeItemComparator();
		Collections.sort(itens, comparator);
		String listaItens = "";
		for (int i = 0; i < itens.size(); i++) {
			listaItens += itens.get(i).toString() + System.lineSeparator();

		}

		return listaItens;
	}

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