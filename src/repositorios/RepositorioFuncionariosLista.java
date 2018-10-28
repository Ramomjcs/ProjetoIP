package repositorios;

import basicas.Funcionario;
import excecoes.FuncionarioNaoEncontradoException;
import interfaces.RepositorioFuncionarios;

public class RepositorioFuncionariosLista implements RepositorioFuncionarios {

	private Funcionario funcionario;
	private RepositorioFuncionariosLista prox;

	public RepositorioFuncionariosLista() {
		this.funcionario = null;
		this.prox = null;
	}

	@Override
	public void inserir(Funcionario funcionario) {
		if (this.funcionario == null) {
			this.funcionario = funcionario;
			this.prox = new RepositorioFuncionariosLista();
		} else {
			this.prox.inserir(funcionario);
		}
	}

	@Override
	public Funcionario procurar(String cpf) throws FuncionarioNaoEncontradoException {

		if (this.funcionario == null) {
			throw new FuncionarioNaoEncontradoException();
		} else if (this.funcionario.getCodigo().equals(cpf)) {
			return this.funcionario;
		} else {
			return this.prox.procurar(cpf);
		}

	}

	@Override
	public void atualizar(Funcionario funcionario) throws FuncionarioNaoEncontradoException{
		if(this.funcionario.getCodigo().equals(funcionario.getCodigo())){
				this.funcionario.setNome(funcionario.getNome());
				this.funcionario.setSalario(funcionario.getSalario());
				this.funcionario.setFuncao(funcionario.getFuncao());
				this.funcionario.setSalario(funcionario.getSalario());
		} else if(this.prox.funcionario != null) {
			this.prox.atualizar(funcionario);
		} else {
			throw new FuncionarioNaoEncontradoException();
		}
	}

	@Override
	public void remover(String cpf) throws FuncionarioNaoEncontradoException {
		if (this.funcionario == null) {
			throw new FuncionarioNaoEncontradoException();
		} else if (this.funcionario.getCodigo().equals(cpf)) {
			this.funcionario = this.prox.funcionario;
			this.prox = this.prox.prox;
		} else {
			this.prox.remover(cpf);
		}
	}

	@Override
	public boolean existe(String cpf) {
		if (this.funcionario == null) {
			return false;
		}else if (this.funcionario.getCodigo().equals(cpf)) {
			return true;
		} else if (this.prox.funcionario != null) {
			return this.prox.existe(cpf);
		} else {
			return false;
		}
	}
}
