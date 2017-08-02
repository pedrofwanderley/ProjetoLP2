
public class NomeItemComparator implements Comparator<Item> {
	
	@Override
	public int compare(Item item, Item outroItem) {
		return item.getNome().compareTo(outroItem.getNome());
	}

}
