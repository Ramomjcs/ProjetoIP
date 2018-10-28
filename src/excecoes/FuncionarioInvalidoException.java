package excecoes;

public class FuncionarioInvalidoException extends Exception {
	public FuncionarioInvalidoException() {
		super("Cliente nao esta sendo atendido.");
	}
}
