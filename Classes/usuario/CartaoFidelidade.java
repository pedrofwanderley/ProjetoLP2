package usuario;

public enum CartaoFidelidade {

	NOOB("Noob"), Caloteiro("Caloteiro"), FreeRider("FreeRyder"), BomAmigo("BomAmigo");

	protected String CartaoFidelidade;

	CartaoFidelidade(String estadoItem) {
		this.CartaoFidelidade = estadoItem;
	}

	public String getEstadoItem() {

		return this.CartaoFidelidade;

	}
}
