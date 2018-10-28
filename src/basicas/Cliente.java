package basicas;

public class Cliente extends PessoaAbstrata {
	
	private String cpf;
	private double saldo;
	private Funcionario garcom;
	
	public Cliente(String nome, String cpf, double saldo, Funcionario garcom) {
		super(nome);
		// TODO Auto-generated constructor stub
		this.cpf = cpf;
		this.saldo = saldo;
		this.garcom = garcom;
	}

	public void incrementarSaldo(double valor) {
		this.saldo = saldo + valor;
	}
	
	public double pagar() {
		double temp = this.saldo;
		this.saldo = 0;
		return temp;
	}
	
	public double getSaldo() {
		return this.saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public Funcionario getGarcom() {
		return this.garcom;
	}

	public void setGarcom(Funcionario garcom) {
		this.garcom = garcom;
	}
	
	public String getCodigo() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
}
