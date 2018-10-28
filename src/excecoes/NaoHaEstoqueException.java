package excecoes;

public class NaoHaEstoqueException extends Exception {
	public NaoHaEstoqueException() {
		// TODO Auto-generated constructor stub
		super("Nao temos mais no nosso estoque");
	}
}
