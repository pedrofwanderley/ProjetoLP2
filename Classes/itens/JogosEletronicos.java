package itens;

public class JogosEletronicos extends Item{
	protected String nomeDoJogo;
	protected String plataforma;


	public JogosEletronicos(String nome, double valor, String nomeDoJogo, String plataforma) {
		super(nome, valor);
		this.nomeDoJogo = nomeDoJogo;
		this.plataforma = plataforma;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nomeDoJogo == null) ? 0 : nomeDoJogo.hashCode());
		result = prime * result + ((plataforma == null) ? 0 : plataforma.hashCode());
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
		
		JogosEletronicos jogoEletronico = (JogosEletronicos) obj;
		
		if (nomeDoJogo == null) {
			if (jogoEletronico.nomeDoJogo != null)
				return false;
		} else if (!nomeDoJogo.equals(jogoEletronico.nomeDoJogo))
			return false;
		
		if (plataforma == null) {
			if (jogoEletronico.plataforma != null)
				return false;
		} else if (!plataforma.equals(jogoEletronico.plataforma))
			return false;
		
		return true;
	}
	
}
