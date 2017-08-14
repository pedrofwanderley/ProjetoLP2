package usuario;

import java.util.Comparator;

import emprestimo.Emprestimo;

public class HistoricoComparator implements Comparator<Emprestimo> {

	@Override
	public int compare(Emprestimo emprestimo, Emprestimo outroEmprestimo) {
		return emprestimo.getItem().getNomeItem().compareTo(outroEmprestimo.getItem().getNomeItem());
	}
	 
}
