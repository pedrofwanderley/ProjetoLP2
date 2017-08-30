package chaves;

import java.io.Serializable;
/**
 * Classe que gera uma chave para o mapa de usuários.
 * @author Guilherme
 *
 */
public class ChaveUsuario implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nome;
	private String celular;
	
	public ChaveUsuario(String nome, String telefone){
		if (nome.trim().equals("") || telefone.trim().equals("")) {
			throw new IllegalArgumentException();
		}
		if (nome.equals(null) || telefone.equals(null)) {
			throw new NullPointerException();
		}
		
		this.nome = nome;
		this.celular = telefone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((celular == null) ? 0 : celular.hashCode());
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
		ChaveUsuario other = (ChaveUsuario) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (celular == null) {
			if (other.celular != null)
				return false;
		} else if (!celular.equals(other.celular))
			return false;
		return true;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getNome() {
		return nome;
	}

	public String getCelular() {
		return celular;
	}
	
	
}
