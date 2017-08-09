package pesquisa;
import java.util.Comparator;

import itens.Item;
/**
 * Classe usada para comparacao de itens pelo valor.
 * @author pedrofw
 *
 */
public class ValorItemComparator implements Comparator<Item> {
	/**
	 * Método de comparacao de itens pelo valor, para futura ordenacao.
	 */
	@Override
	public int compare(Item item, Item outroItem) {
		Double item1 = item.getValor();
		Double item2 = outroItem.getValor();
		return item1.compareTo(item2);
	}

}
