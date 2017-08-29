package listing;

import java.util.Comparator;

public class NomeComparator implements Comparator<String>{
	
	public int compare(String nome1, String nome2) {
		return nome1.compareTo(nome2);
	}

}
