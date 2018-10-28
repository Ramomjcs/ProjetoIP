package basicas;

public class Fornecedor extends PessoaAbstrata {

	private String cnpj;
	
	public Fornecedor(String nome, String cnpj) {
		super(nome);
		// TODO Auto-generated constructor stub
		this.cnpj = cnpj;
	}

	public String getCodigo() {
		return this.cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

}
