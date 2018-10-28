package excecoes;

public class FornecedorJaCadastradoException extends Exception{
	public FornecedorJaCadastradoException() {
		super("Fornecedor ja cadastrado");
	}
}
