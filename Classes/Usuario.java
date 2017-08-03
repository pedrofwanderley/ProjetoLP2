

import java.util.ArrayList;

import itens.Item;

public class Usuario {

	private String nome;
	private String email;
	private String celular;
	private ArrayList<Item> itens;
	private ArrayList<Historico> historicos;
	
	public Usuario(String nome, String celular, String email) throws Exception {
		if (nome == null || email == null || celular == null) {
			throw new Exception("Parametros de usuario nao podem ser nulos");
		}
		
		else if (nome.trim().equals("") || email.trim().equals("") || celular.trim().equals("")) {
			throw new Exception("Parametros de usuario nao podem ser vazios");
		}
		
		this.setNome(nome);
		this.setEmail(email);
		this.setCelular(celular);
		itens = new ArrayList<>();
		historicos = new ArrayList<>();
	}

	

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<Item> getItens() {
		return itens;
	}

	public void setItens(ArrayList<Item> itens) {
		this.itens = itens;
	}
	
	private void setHistoricos(ArrayList<Historico> historicos) {
		this.historicos = historicos;
		
	}
	public ArrayList<Historico> getHistoricos() {
		return historicos;
	}
	
	@Override
	public String toString() {
		return nome + ", " + email + ", " + celular;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((celular == null) ? 0 : celular.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Usuario other = (Usuario) obj;
		if (celular == null) {
			if (other.celular != null)
				return false;
		} else if (!celular.equals(other.celular))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
}
