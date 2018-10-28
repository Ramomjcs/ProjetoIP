package basicas;

public class Funcionario extends PessoaAbstrata {
	
	private String cpf;
	private String funcao;
	private double salario;
	
	public Funcionario(String nome, String cpf, String funcao, double salario) {
		super(nome);
		// TODO Auto-generated constructor stub
		this.cpf = cpf;
		this.funcao = funcao;
		this.salario = salario;
	}
	
	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	@Override
	public String getCodigo() {
		// TODO Auto-generated method stub
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}
