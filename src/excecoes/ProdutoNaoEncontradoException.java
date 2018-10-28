package excecoes;

public class ProdutoNaoEncontradoException extends Exception {
	public ProdutoNaoEncontradoException() {
		super("Produto Nao Encontrado.");
	}
}
