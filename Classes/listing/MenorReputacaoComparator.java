package listing;

import java.util.Comparator;

import usuario.Usuario;
/**
 * Classe de comparacao de dois usuarios pela menor reputacao.
 * @author Wesley
 *
 */
public class MenorReputacaoComparator implements Comparator<Usuario> {
	
	public int compare(Usuario usuario1, Usuario usuario2) {
		Double reputacao1 = usuario1.getReputacao(); 
		Double reputacao2 = usuario2.getReputacao();
		return reputacao1.compareTo(reputacao2);
	}

}
