import java.util.Comparator;

import itens.Item;

public class NomeItemComparator implements Comparator<Item> {
	
	@Override
	public int compare(Item item, Item outroItem) {
		return item.getNomeItem().compareTo(outroItem.getNomeItem());
	}

}
