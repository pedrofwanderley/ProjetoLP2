package listing;

import java.util.Comparator;
import usuario.Usuario;
/**
 * Classe usada para comparacao de dois usuarios pela maior reputacao.
 * @author Wesley.
 *
 */
public class MaiorReputacaoComparator implements Comparator<Usuario> {
	
	public int compare(Usuario usuario1, Usuario usuario2) {
		Double reputacao1 = usuario1.getReputacao(); 
		Double reputacao2 = usuario2.getReputacao();
		return reputacao2.compareTo(reputacao1);
	}

}
