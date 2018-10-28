package repositorios;

import basicas.Fornecedor;
import excecoes.FornecedorNaoEncontradoException;
import excecoes.RepositorioFornecedoresCheioException;
import interfaces.RepositorioFornecedores;

public class RepositorioFornecedoresArray implements RepositorioFornecedores{

	private Fornecedor[] fornecedores = new Fornecedor[50];

	public void inserir(Fornecedor fornecedor) throws RepositorioFornecedoresCheioException {
		boolean cheio = true;
		for (int i = 0; i < fornecedores.length && cheio; i++) {
			if (fornecedores[i] == null) {
				fornecedores[i] = fornecedor;
				cheio = false;
			}
		}
		if (cheio) {
			throw new RepositorioFornecedoresCheioException();
		}
	}

	public Fornecedor procurar(String cpf) throws FornecedorNaoEncontradoException {
		boolean achou = false;
		Fornecedor procurado = null;
		for (int i = 0; i < fornecedores.length && !achou; i++) {
			if (fornecedores[i] != null && fornecedores[i].getCodigo().equals(cpf)) {
				procurado = fornecedores[i];
				achou = true;
			}
		}
		if (!achou) {
			throw new FornecedorNaoEncontradoException();
		}
		return procurado;
	}

	public void atualizar(Fornecedor fornecedor) throws FornecedorNaoEncontradoException  {
		boolean achou = false;
		for (int i = 0; i < fornecedores.length && !achou; i++) {
			if (fornecedores[i] != null && fornecedores[i].getCodigo().equals(fornecedor.getCodigo())) {
				this.fornecedores[i].setNome(fornecedor.getNome());
				achou = true;
			}
		}
		if (!achou) {
			throw new FornecedorNaoEncontradoException();
		}
	}

	public void remover(String cpf) throws FornecedorNaoEncontradoException  {
		
		boolean achou = false;
		for (int i = 0; i < fornecedores.length && !achou; i++) {
			if (fornecedores[i] != null && fornecedores[i].getCodigo().equals(cpf)) {
				fornecedores[i] = null;
				achou = true;
			}
		}
		if (!achou) {
			throw new FornecedorNaoEncontradoException();
		}
	}

	public boolean existe(String cnpj) {
		for (int i = 0; i < fornecedores.length; i++) {
			if (fornecedores[i] != null && fornecedores[i].getCodigo().equals(cnpj)) {
				return true;
			}
		}
		return false;
	}
}
