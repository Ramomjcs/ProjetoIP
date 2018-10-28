package excecoes;

public class RepositorioClientesCheioException extends Exception {
	public RepositorioClientesCheioException() {
		super("O restaurante está cheio");
	}
}
