package listing;

import java.util.Comparator;
/**
 * Classe de comparacao de duas strings por ordem alfabetica..
 * @author Wesley
 *
 */
public class NomeComparator implements Comparator<String>{
	
	public int compare(String nome1, String nome2) {
		return nome1.compareTo(nome2);
	}

}
