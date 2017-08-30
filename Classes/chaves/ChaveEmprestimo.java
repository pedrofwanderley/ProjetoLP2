package chaves;

import java.io.Serializable;
/**
 * Classe que serve para ser usada como chave de uma coleção de empréstimos
 * @author Guilherme, Wesley
 *
 */
public class ChaveEmprestimo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nomeDono;
	private String nomeRequerente;
	private String telefoneDono;
	private String telefoneRequerente;
	private String dataEmprestimo;
	private String item;
	
	
	public ChaveEmprestimo(String nomeDono, String nomeRequerente, String telefoneDono, String telefoneRequerente,
			String dataEmprestimo, String item) {
		
		if (nomeDono.trim().equals("") || nomeRequerente.trim().equals("")) {
			throw new IllegalArgumentException();
		}
		if (telefoneDono.trim().equals("") || telefoneRequerente.trim().equals("")) {
			throw new IllegalArgumentException();
		}
		if (dataEmprestimo.trim().equals("") || item.trim().equals("")) {
			throw new IllegalArgumentException();
		}
		if (nomeDono.equals(null) || nomeRequerente.equals(null)) {
			throw new NullPointerException();
		}
		if (telefoneDono.equals(null) || telefoneRequerente.equals(null)) {
			throw new NullPointerException();
		}
		if (dataEmprestimo.equals(null) || item.equals(null)) {
			throw new NullPointerException();
		}
		
		
		this.nomeDono = nomeDono;
		this.nomeRequerente = nomeRequerente;
		this.telefoneDono = telefoneDono;
		this.telefoneRequerente = telefoneRequerente;
		this.dataEmprestimo = dataEmprestimo;
		this.item = item;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataEmprestimo == null) ? 0 : dataEmprestimo.hashCode());
		result = prime * result + ((item == null) ? 0 : item.hashCode());
		result = prime * result + ((nomeDono == null) ? 0 : nomeDono.hashCode());
		result = prime * result + ((nomeRequerente == null) ? 0 : nomeRequerente.hashCode());
		result = prime * result + ((telefoneDono == null) ? 0 : telefoneDono.hashCode());
		result = prime * result + ((telefoneRequerente == null) ? 0 : telefoneRequerente.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChaveEmprestimo other = (ChaveEmprestimo) obj;
		if (dataEmprestimo == null) {
			if (other.dataEmprestimo != null)
				return false;
		} else if (!dataEmprestimo.equals(other.dataEmprestimo))
			return false;
		if (item == null) {
			if (other.item != null)
				return false;
		} else if (!item.equals(other.item))
			return false;
		if (nomeDono == null) {
			if (other.nomeDono != null)
				return false;
		} else if (!nomeDono.equals(other.nomeDono))
			return false;
		if (nomeRequerente == null) {
			if (other.nomeRequerente != null)
				return false;
		} else if (!nomeRequerente.equals(other.nomeRequerente))
			return false;
		if (telefoneDono == null) {
			if (other.telefoneDono != null)
				return false;
		} else if (!telefoneDono.equals(other.telefoneDono))
			return false;
		if (telefoneRequerente == null) {
			if (other.telefoneRequerente != null)
				return false;
		} else if (!telefoneRequerente.equals(other.telefoneRequerente))
			return false;
		return true;
	}


	public String getNomeDono() {
		return nomeDono;
	}


	public String getNomeRequerente() {
		return nomeRequerente;
	}


	public String getTelefoneDono() {
		return telefoneDono;
	}


	public String getTelefoneRequerente() {
		return telefoneRequerente;
	}


	public String getDataEmprestimo() {
		return dataEmprestimo;
	}


	public String getItem() {
		return item;
	}
	
	
}
