package listing;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import chaves.ChaveUsuario;
import emprestimo.Emprestimo;
import itens.Item;
import usuario.Usuario;

/**
 * Classe de controle de listagem.
 * 
 * @author pedrofw
 *
 */
public class ControllerListing {
	
	
	public ControllerListing() {
		
	}
	
	/**
	 * Método que gera uma lista de itens	
	 * @param usuarios, tem como parametro um hashmap de usuarios.
	 * @return, retorna uma lista de itens.
	 */
	public List<Item> geraListaItens(Map<ChaveUsuario,Usuario> usuarios){
		List<Item> itensSistema = new ArrayList<>();
		for (Usuario usuario : usuarios.values()){
			for(Item item : usuario.getItens().values()){
				itensSistema.add(item);
				
			}
		}
		return itensSistema;
	}
	/**
	 * Metodo que pesquisa em uma lista de item, um determinado item e  lista o historico de emprestimo de item
	 * @param usuarios, mapa de usuarios.
	 * @param nomeItem, nome do item a ser avaliado o historico
	 * @return, retorna os emprestimos do item em questão;
	 */
	
	public String listarEmprestimosItem(Map<ChaveUsuario, Usuario> usuarios, String nomeItem) {
		List<Item> itens = geraListaItens(usuarios);
		String listaHistorico =  "Emprestimos associados ao item: ";
		boolean conferehistorico = false;
		for (Item item : itens) {
			if (nomeItem.equals(item.getNomeItem()) && item.getHistoricoItem().size() > 0) {
				conferehistorico = true;
				for (Emprestimo emprestimo : item.getHistoricoItem()) {
					listaHistorico += emprestimo.toString() + "|";

				}

			}
		}
		if (!conferehistorico) {
			listaHistorico = "Nenhum emprestimos associados ao item";
			
		}
		return listaHistorico;
	}
	/**
	 * Metodo que lista os itens que nao foram emprestados no sistema.
	 * @param usuarios, mapa de usuarios
	 * @return, retorna um representacao em string dos itens nao emprestados, ordenados pelo nome do item.
	 */
	public String listarItensNaoEmprestados(Map<ChaveUsuario, Usuario> usuarios) {
		List<Item> itens = geraListaItens(usuarios);
		List<Item> listaItensNaoEmprestados = new ArrayList<>();
		for (Item item : itens) {
			if ("Nao emprestado".equals(item.getEstado().getEstadoItem())) {
				listaItensNaoEmprestados.add(item);

			}
		}
		Collections.sort(listaItensNaoEmprestados, new NomeItemComparator());
		String itensNaoEmprestados = "";
		for (Item item : listaItensNaoEmprestados) {
			itensNaoEmprestados += item.toString() + "|";

		}
		return itensNaoEmprestados;

	}
	/**
	 * Metodo que lista o top 10 de itens mais emprestados;
	 * @param usuarios, mapa de usuarois
	 * @return, retorna uma representacao em string dos itens mais requisitados.
	 */
	public String listaTop10itens(Map<ChaveUsuario, Usuario> usuarios) {
		List<Item> itens = geraListaItens(usuarios);
		Collections.sort(itens, new TopItensComparator());
		String top10 = "";
		int cont = 1;
		for (Item item : itens) {
			if (item.getHistoricoItem().size() == 0 || cont > 10) {
				break;

			}
			top10 += cont + ") " + item.getHistoricoItem().size() + " emprestimos - " + item.toString() + "|";
			cont++;
			
		}

		return top10;

	}	
	/**
	 * Metodo que lista itens emprestados no momento
	 * @param usuarios, mapa de usuarios.
	 * @return, retorna uma representacao em string dos nomes dos donos dos itens e dos nome dos itens emprestados.
	 */
	public String listarItensEmprestados(Map<ChaveUsuario, Usuario> usuarios) {
		String itensEmprestados = "";
		for (Usuario usuario : usuarios.values()) {
			for (Item item : usuario.getItens().values()) {
				if ("Emprestado".equals(item.getEstado().getEstadoItem())) {
					itensEmprestados += "Dono do item: " + usuario.getNome() + ", " + "Nome do item emprestado: "
							+ item.getNomeItem() + "|";
				}

			}

		}
		return itensEmprestados;

	}
	/**
	 * Metodo de ordenacao e exibicao de itens em ordem alfabetica.
	 * @param itens, o parametro é uma lista de itens.
	 * @return, retorna as representacoes dos itens em forma de string.
	 */
	public String listaItensUsuariosNome(Map<ChaveUsuario, Usuario> usuarios) {
		List<Item> itens = geraListaItens(usuarios);
		Collections.sort(itens, new NomeItemComparator());
		String listaItens = "";
		for (Item item : itens) {
			listaItens += item.toString() + "|";

		}
		return listaItens;
	}
	/**
	 * Metodo de ordenacao e exibicao de itens por ordem de valor.
	 * @param itens, o parametro é uma lista de itens
	 * @return, retorna uma representacao em string de todos os itens dos usuários.
	 */
	public String listaItensUsuariosValor(Map<ChaveUsuario, Usuario> usuarios) {
		List<Item> itens = geraListaItens(usuarios);
		Collections.sort(itens, new ValorItemComparator());
		String listaItens = "";
		for(Item item : itens) {
			listaItens += item.toString() + "|";

		}
		return listaItens;
	}
	/**
	 * Metodo de pesquisa de detalhes de um determinado item.
	 * @param usuarios, tem como primeiro parametro um hashmap de usuarios.
	 * @param nome, tem como segundo parametro o nome de um usuario.
	 * @param telefone, tem como terceiro parametro o telefonede um usuario.
	 * @param nomeitem, tem como quarto parametro o nome do item a ser detalhado.
	 * @return, retorna uma representacao em string do item desejado.
	 */
	public String pesquisarDetalhesItem(Map<ChaveUsuario, Usuario> usuarios, String nome, String telefone, String nomeitem){
		String itemDetalhado = "";
		boolean confereUsuario = false;
		boolean confereItem = false;
		for (Usuario usuario : usuarios.values()){
			if (nome.equals(usuario.getNome()) && telefone.equals(usuario.getCelular())) {
				confereUsuario = true;
				for(Item item : usuario.getItens().values()){
					if (nomeitem.equals(item.getNomeItem())){
						confereItem = true;
						itemDetalhado = item.toString();
					}
					
				}
							
			}
			
			
		}
		if (!confereUsuario) {
			throw new IllegalArgumentException("Usuario invalido");
			
		}
		else if(!confereItem){
			throw new IllegalArgumentException("Item nao encontrado");
		}
		
		return itemDetalhado;
	}
	
	/**
	 * Lista todos os usuarios que possuem reputacao negativa
	 * @param usuarios
	 * @return
	 */
	public String listarCaloteiros(Map<ChaveUsuario, Usuario> usuarios){
		
		List <String> caloteiros = new ArrayList <String>();
		String listaCaloteiros = "Lista de usuarios com reputacao negativa: ";
		
		for(Usuario usuario: usuarios.values()){
			
			if(usuario.getCartao().equals("Caloteiro")){
				caloteiros.add(usuario.toString());
				
			}
		}
		Collections.sort(caloteiros, new NomeComparator());
		
		for(String caloteiro : caloteiros){
			listaCaloteiros += caloteiro + "|";
		}
	
		return listaCaloteiros;
	}
	/**
	 * Lista os dez melhores usuarios em reputacao
	 * @param usuarios
	 * @return
	 */
	public String listarTop10MelhoresUsuarios(Map<ChaveUsuario, Usuario> usuarios){
		
		ArrayList <Usuario> listaUsuarios = new ArrayList<Usuario>();
		String Top10Usuarios = "";
		
		for (Usuario usuario:usuarios.values()){
			listaUsuarios.add(usuario);
			
		}
			
		Collections.sort(listaUsuarios, new MaiorReputacaoComparator());
		
		for(int i = 0; i<10; i++){
			String reputacao = String.format("%1$,.2f", listaUsuarios.get(i).getReputacao());
			Top10Usuarios += i+1 +": " + listaUsuarios.get(i).getNome() + " - Reputacao: " + reputacao + "|" ;
		}
		
		return Top10Usuarios;
	}
	/**
	 *	Lista os dez piores usuarios em reputacao
	 * @param usuarios
	 * @return
	 */
	public String listarTop10PioresUsuarios(Map<ChaveUsuario, Usuario> usuarios){
		
		ArrayList <Usuario> listaUsuarios = new ArrayList<Usuario>();
		String Top10Usuarios = "";
		
		for (Usuario u:usuarios.values()){
			listaUsuarios.add(u);
			
		}
			
		Collections.sort(listaUsuarios, new MenorReputacaoComparator());
		
		for(int i = 0; i<10; i++){
			
			String reputacao = String.format("%1$,.2f", listaUsuarios.get(i).getReputacao());
			Top10Usuarios += i+1 +": " + listaUsuarios.get(i).getNome() + " - Reputacao: " + reputacao + "|" ;
		}
		
		return Top10Usuarios;
	}

}
