package usuario;

import java.util.Comparator;

import emprestimos.Emprestimo;

public class EmprestimosComparator implements Comparator<Emprestimo> {

	@Override
	public int compare(Emprestimo emprestimo, Emprestimo outroEmprestimo) {
		return emprestimo.getItem().getNomeItem().compareTo(outroEmprestimo.getItem().getNomeItem());
	}
	 
}
