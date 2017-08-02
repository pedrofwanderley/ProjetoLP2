import java.util.Comparator;

import itens.Item;

public class ValorItemComparator implements Comparator<Item> {
	
	@Override
	public int compare(Item item, Item outroItem) {
		Double item1 = item.getValor();
		Double item2 = outroItem.getValor();
		return item1.compareTo(item2);
	}

}
