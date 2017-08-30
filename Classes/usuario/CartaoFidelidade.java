package usuario;
/**
 * Enum que representa a categoria a qual um usuario pertence no cartao fidelidade.
 * @author pedrofw
 *
 */
public enum CartaoFidelidade {

	NOOB("Noob"), Caloteiro("Caloteiro"), FreeRider("FreeRyder"), BomAmigo("BomAmigo");

	protected String CartaoFidelidade;

	CartaoFidelidade(String categoriaFidelidade) {
		this.CartaoFidelidade = categoriaFidelidade;
	}

	public String getCartaoFidelidade() {
		return CartaoFidelidade;
	}

	
}
