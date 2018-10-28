package repositorios;

import basicas.Funcionario;
import excecoes.FuncionarioNaoEncontradoException;
import excecoes.RepositorioFuncionariosCheioException;
import interfaces.RepositorioFuncionarios;

public class RepositorioFuncionariosArray implements RepositorioFuncionarios {

	private Funcionario[] funcionarios = new Funcionario[50];

	public void inserir(Funcionario funcionario) throws RepositorioFuncionariosCheioException {
		boolean cheio = true;
		for (int i = 0; i < funcionarios.length && cheio; i++) {
			if (funcionarios[i] == null) {
				funcionarios[i] = funcionario;
				cheio = false;
			}
		}
		if (cheio) {
			throw new RepositorioFuncionariosCheioException();
		}
	}

	public Funcionario procurar(String cpf) throws FuncionarioNaoEncontradoException {
		boolean achou = false;
		Funcionario procurado = null;
		for (int i = 0; i < funcionarios.length && !achou; i++) {
			if (funcionarios[i] != null && funcionarios[i].getCodigo().equals(cpf)) {
				procurado = funcionarios[i];
				achou = true;
			}
		}
		if (!achou) {
			throw new FuncionarioNaoEncontradoException();
		}
		return procurado;
	}

	public void atualizar(Funcionario funcionario) throws FuncionarioNaoEncontradoException {
		boolean achou = false;
		for (int i = 0; i < funcionarios.length && !achou; i++) {
			if (funcionarios[i] != null && funcionarios[i].getCodigo().equals(funcionario.getCodigo())) {
				this.funcionarios[i].setNome(funcionario.getNome());
				this.funcionarios[i].setSalario(funcionario.getSalario());
				this.funcionarios[i].setFuncao(funcionario.getFuncao());
				this.funcionarios[i].setSalario(funcionario.getSalario());
				achou = true;
			}
		}
		if (!achou) {
			throw new FuncionarioNaoEncontradoException();
		}
	}

	public void remover(String cpf) throws FuncionarioNaoEncontradoException {
		
		boolean achou = false;
		for (int i = 0; i < funcionarios.length && !achou; i++) {
			if (funcionarios[i] != null && funcionarios[i].getCodigo().equals(cpf)) {
				funcionarios[i] = null;
				achou = true;
			}
		}
		if (!achou) {
			throw new FuncionarioNaoEncontradoException();
		}
	}

	@Override
	public boolean existe(String cpf) {
		for (int i = 0; i < funcionarios.length; i++) {
			if (funcionarios[i] != null && funcionarios[i].getCodigo().equals(cpf)) {
				return true;
			}
		}
		return false;
	}
}
