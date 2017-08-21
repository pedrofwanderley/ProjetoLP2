package pesquisa;

import java.util.Comparator;
import usuario.Usuario;

public class ReputacaoComparator implements Comparator<Usuario> {
	
	public int compare(Usuario usuario1, Usuario usuario2) {
		Double reputacao1 = usuario1.getReputacao(); 
		Double reputacao2 = usuario2.getReputacao();
		return reputacao1.compareTo(reputacao2);
	}

}
