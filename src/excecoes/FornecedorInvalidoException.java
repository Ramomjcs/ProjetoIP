package excecoes;

public class FornecedorInvalidoException extends Exception {
	public FornecedorInvalidoException() {
		super("Produto esta com fornecedor invalido.");
	}
}
