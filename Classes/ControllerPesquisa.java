import java.util.Collections;

public class ControllerPesquisa {
	
	public UsuarioController usuarios = new UsuarioController();
	
	public String listaItensUsuariosNome(){
		NomeItemComparator comparator = new NomeItemComparator();
		Collections.sort(usuarios.getItensTotais(), comparator);
		String listaItens = "";
		for (int i = 0; i < usuarios.getItensTotais().size(); i++) {
			listaItens += usuarios.getItensTotais().get(i).toString() + System.lineSeparator();
			
		}
		
		return listaItens;
	}
	
	public String listaItensUsuariosValor(){
		ValorItemComparator comparator = new ValorItemComparator();
		Collections.sort(usuarios.getItensTotais(),comparator);
		
		String listaItens  = "";
		for (int i = 0; i < usuarios.getItensTotais().size(); i++) {
			listaItens += usuarios.getItensTotais().get(i).toString() + System.lineSeparator();
			
		}
		
		return listaItens;
	}
	
	
	

}