package itens;

public enum EstadoItem {

	Emprestado("Emprestado"), NEmprestado("Nao emprestado");

	protected String estadoItem;

	EstadoItem(String estadoItem) {
		this.estadoItem = estadoItem;
	}

	public String getEstadoItem() {

		return this.estadoItem;

	}
}

