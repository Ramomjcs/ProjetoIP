package excecoes;

public class FuncionarioJaCadastradoException extends Exception {
	public FuncionarioJaCadastradoException() {
		super("Funcionário já cadastrado.");
	}
}
