package pesquisa;
import java.util.Comparator;

import itens.Item;
/**
 * Classe usada para comparacao de itens pelo nome.
 * @author pedrofw
 *
 */
public class NomeItemComparator implements Comparator<Item> {
	/**
	 * Método de comparacao de itens pelo nome, para uma futura ordenacao.
	 */
	@Override
	public int compare(Item item, Item outroItem) {
		return item.getNomeItem().trim().compareTo(outroItem.getNomeItem().trim());
	}

}
