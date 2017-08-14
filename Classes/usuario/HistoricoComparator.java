package usuario;

import java.util.Comparator;

public class HistoricoComparator implements Comparator<Historico> {
	  @Override
	   public int compare(Historico historico, Historico outroHistorico) {
	       return historico.getItem().getNomeItem().compareTo(outroHistorico.getItem().getNomeItem());
	   }

}
