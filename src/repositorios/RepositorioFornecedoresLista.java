package repositorios;

import basicas.Fornecedor;
import excecoes.FornecedorNaoEncontradoException;
import interfaces.RepositorioFornecedores;

public class RepositorioFornecedoresLista implements RepositorioFornecedores {

	private Fornecedor fornecedores;
	private RepositorioFornecedoresLista prox;

	public RepositorioFornecedoresLista() {
		this.fornecedores = null;
		this.prox = null;
	}

	public void inserir(Fornecedor fornecedor) {
		if (this.fornecedores == null) {
			this.fornecedores = fornecedor;
			this.prox = new RepositorioFornecedoresLista();
		} else {
			this.prox.inserir(fornecedor);
		}
	}

	public Fornecedor procurar(String cnpj) throws FornecedorNaoEncontradoException {

		if (this.fornecedores == null) {
			throw new FornecedorNaoEncontradoException();
		} else if (this.fornecedores.getCodigo().equals(cnpj)) {
			return this.fornecedores;
		} else {
			return this.prox.procurar(cnpj);
		}

	}

	public void atualizar(Fornecedor fornecedor) throws FornecedorNaoEncontradoException{
		if(this.fornecedores.getCodigo().equals(fornecedor.getCodigo())){
				this.fornecedores.setNome(fornecedor.getNome());
		} else if(this.prox.fornecedores != null) {
			this.prox.atualizar(fornecedor);
		} else {
			throw new FornecedorNaoEncontradoException();
		}
	}

	public void remover(String cnpj) throws FornecedorNaoEncontradoException {
		if (this.fornecedores == null) {
			throw new FornecedorNaoEncontradoException();
		} else if (this.fornecedores.getCodigo().equals(cnpj)) {
			this.fornecedores = this.prox.fornecedores;
			this.prox = this.prox.prox;
		} else {
			this.prox.remover(cnpj);
		}
	}

	public boolean existe(String cnpj) {
		if (this.fornecedores == null) {
			return false;
		}else if (this.fornecedores.getCodigo().equals(cnpj)) {
			return true;
		} else if (this.prox.fornecedores != null) {
			return this.prox.existe(cnpj);
		} else {
			return false;
		}
	}
}
