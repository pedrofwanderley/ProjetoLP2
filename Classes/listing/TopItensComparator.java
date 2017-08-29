package listing;

import java.util.Comparator;

import itens.Item;

public class TopItensComparator implements Comparator<Item>{

	@Override
	public int compare(Item item, Item outroItem) {
		Integer item1 = item.getHistoricoItem().size();
		Integer item2 = outroItem.getHistoricoItem().size();
		return item2.compareTo(item1);
	}
	

}
