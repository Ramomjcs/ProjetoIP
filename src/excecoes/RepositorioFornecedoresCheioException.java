package excecoes;

public class RepositorioFornecedoresCheioException extends Exception {
	
	public RepositorioFornecedoresCheioException() {
		super("Já temos empresas fornecedoras o suficiente");
	}
	
}
