package itens;

public enum EstadoItem {

	Emprestado("Item emprestado"), NEmprestado("Item disponivel");

	protected String estadoItem;

	EstadoItem(String estadoItem) {
		this.estadoItem = estadoItem;
	}

	public String getEstadoItem() {

		return this.estadoItem;

	}

}
