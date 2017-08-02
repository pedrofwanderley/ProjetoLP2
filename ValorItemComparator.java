
public class ValorItemComparator implements Comparator<Item> {
	
	@Override
	public int compare(Item item, Item outroItem) {
		Integer item1 = item.getValor();
		Integer item2 = outroItem.getValor);
		return item1.compareTo(item2);
	}

}
