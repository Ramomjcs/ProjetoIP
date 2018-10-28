package basicas;

public abstract class PessoaAbstrata {

	private String nome;
	
	public PessoaAbstrata(String nome) {
		// TODO Auto-generated constructor stub
		this.nome = nome;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public abstract String getCodigo();
	
}
