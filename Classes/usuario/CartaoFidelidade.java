package usuario;

public enum CartaoFidelidade {

	NOOB(""), Caloteiro(""), FreeRider(""), BomAmigo("");

	protected String CartaoFidelidade;

	CartaoFidelidade(String estadoItem) {
		this.CartaoFidelidade = estadoItem;
	}

	public String getEstadoItem() {

		return this.CartaoFidelidade;

	}
}
