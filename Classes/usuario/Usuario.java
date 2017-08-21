package usuario;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import emprestimo.Emprestimo;
import itens.Item;

public class Usuario {

	private String nome;
	private String email;
	private String celular;
	private HashMap<String, Item> itens;
	private ArrayList<String> historico;
	private List<Emprestimo> emprestimosEmprestando;
	private List<Emprestimo> emprestimosPegos;
	private CartaoFidelidade cartao;
	private double reputacao;

	public Usuario(String nome, String celular, String email) throws Exception {
		if (nome == null || email == null || celular == null) {
			throw new NullPointerException("Parametros de usuario nao podem ser nulos");
		}

		if (nome.trim().equals("") || email.trim().equals("") || celular.trim().equals("")) {
			throw new IllegalArgumentException("Parametros de usuario nao podem ser vazios");
		}

		this.setNome(nome);
		this.setEmail(email);
		this.setCelular(celular);
		this.itens = new HashMap<>();
		this.historico = new ArrayList<>();
		this.emprestimosEmprestando = new ArrayList<>();
		this.emprestimosPegos = new ArrayList<>();
		this.cartao = CartaoFidelidade.FreeRider;
		this.reputacao = 0.0;
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

	public HashMap<String, Item> getItens() {
		return itens;
	}

	public String getCartao() {
		return cartao.getEstadoItem();
	}

	public void setCartao(CartaoFidelidade cartao) {
		this.cartao = cartao;
	}

	public double getReputacao() {
		return reputacao;
	}

	public void setItens(HashMap<String, Item> itens) {
		this.itens = itens;
	}

	public ArrayList<String> getHistorico() {
		return historico;
	}

	public List<Emprestimo> getEmprestimosEmprestando() {
		return emprestimosEmprestando;
	}

	public List<Emprestimo> getEmprestimosPegos() {
		return emprestimosPegos;
	}

	public String listaEmprestimo() {
		String listaEmprestimos = "Emprestimos: ";
		if (emprestimosEmprestando.size() == 0) {
			listaEmprestimos = "Nenhum item emprestado";
		} else {
			EmprestimosComparator comparator = new EmprestimosComparator();
			Collections.sort(emprestimosEmprestando, comparator);
			for (Emprestimo emprestimo : emprestimosEmprestando) {
				listaEmprestimos += emprestimo.toString() + "|";
			}

		}
		return listaEmprestimos;

	}

	public String listaEmprestimosPegos() {
		String listaEmprestimosPegos = "Emprestimos pegos: ";
		if (emprestimosPegos.size() == 0) {
			listaEmprestimosPegos = "Nenhum item pego emprestado";
		} else {
			EmprestimosComparator comparator = new EmprestimosComparator();
			Collections.sort(emprestimosPegos, comparator);
			for (Emprestimo emprestimo : emprestimosPegos) {
				listaEmprestimosPegos += emprestimo.toString() + "|";
			}

		}
		return listaEmprestimosPegos;

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

	public void reputacaoNovoItem(double preco) {
		double adicaoReputacao = 0.05 * preco;
		this.reputacao += adicaoReputacao;
	}

	public void reputacaoEmprestimoItem(double preco) {
		double adicaoReputacao = 0.1 * preco;
		this.reputacao += adicaoReputacao;
	}

	public void reputacaoDevolucaoNoPrazo(double preco) {
		double adicaoReputacao = 0.05 * preco;
		this.reputacao += adicaoReputacao;
	}

	public void reputacaoDevolucaoForaDoPrazo(double preco, int atraso) {
		double subtracaoReputacao = atraso * 0.01 * preco;
		this.reputacao -= subtracaoReputacao;
	}
}
