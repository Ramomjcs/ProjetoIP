package negocios;

import basicas.Funcionario;
import excecoes.FuncionarioJaCadastradoException;
import excecoes.FuncionarioNaoEncontradoException;
import excecoes.RepositorioFuncionariosCheioException;
import interfaces.RepositorioFuncionarios;

public class CadastroFuncionarios {

	private RepositorioFuncionarios funcionarios;

	public CadastroFuncionarios(RepositorioFuncionarios rep) {
		this.funcionarios = rep;
	}

	public void inserir(Funcionario funcionario) throws FuncionarioJaCadastradoException, RepositorioFuncionariosCheioException {
		if (!(this.funcionarios.existe(funcionario.getCodigo()))) {
			this.funcionarios.inserir(funcionario);
		} else {
			throw new FuncionarioJaCadastradoException();
		}
	}

	public Funcionario procurar(String cpf) throws FuncionarioNaoEncontradoException {
		return funcionarios.procurar(cpf);
	}
	
	public void atualizar(Funcionario funcionario) throws FuncionarioNaoEncontradoException {
		this.funcionarios.atualizar(funcionario);
	}
	
	public void remover(String cpf) throws FuncionarioNaoEncontradoException{
		funcionarios.remover(cpf);
	}

	public RepositorioFuncionarios getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(RepositorioFuncionarios funcionarios) {
		this.funcionarios = funcionarios;
	}
	
	
}
