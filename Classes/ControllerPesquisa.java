import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import itens.Item;

/**
 * Classe de controle de pesquisas.
 * 
 * @author pedrofw
 *
 */
public class ControllerPesquisa {
	
	private List<Item> itensSistema = new ArrayList<>();
	
	public ControllerPesquisa() {
	}

		
	
	/**
	 * Método de ordenacao e exibicao de itens em ordem alfabetica.
	 * @param itens, o parametro é uma lista de itens.
	 * @return, retorna as representacoes dos itens em forma de string.
	 */
	public String listaItensUsuariosNome(Map<String,Usuario> usuarios) {
		for (Usuario usuario : usuarios.values()){
			for(Item itens : usuario.getItens().values()){
				itensSistema .add(itens);
			}
		}
		NomeItemComparator comparator = new NomeItemComparator();
		Collections.sort(itensSistema , comparator);
		String listaItens = "";
		for (int i = 0; i < itensSistema .size(); i++) {
			listaItens += itensSistema .get(i).toString() + "|";

		}

		return listaItens;
	}
	/**
	 * Metodo de ordenacao e exibicao de itens por ordem de valor.
	 * @param itens, o parametro é uma lista de itens
	 * @return, retorna uma representacao em string de todos os itens dos usuários.
	 */
	public String listaItensUsuariosValor(Map<String,Usuario> usuarios) {
		for (Usuario usuario : usuarios.values()){
			for(Item itens : usuario.getItens().values()){
				itensSistema .add(itens);
			}
		}
		ValorItemComparator comparator = new ValorItemComparator();
		Collections.sort(itensSistema, comparator);
		String listaItens = "";
		for (int i = 0; i < itensSistema .size(); i++) {
			listaItens += itensSistema .get(i).toString() + "|";

		}

		return listaItens;
	}
	
	public String pesquisarDetalhesItem(Map<String,Usuario> usuarios, String nome, String telefone, String nomeitem){
		String itemDetalhado = "";
		for (Usuario usuario : usuarios.values()){
			if (nome.equals(usuario.getNome()) && telefone.equals(usuario.getCelular())) {
				for(Item itens : usuario.getItens().values()){
					if (nomeitem.equals(itens.getNomeItem())){
						itemDetalhado = itens.toString();
					}
				}
				
				
				
			}
			
		}
		return itemDetalhado;
	}
	
	
	

}