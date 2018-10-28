package negocios;

import basicas.Fornecedor;
import excecoes.FornecedorJaCadastradoException;
import excecoes.FornecedorNaoEncontradoException;
import excecoes.RepositorioFornecedoresCheioException;
import interfaces.RepositorioFornecedores;

public class CadastroFornecedores {

	private RepositorioFornecedores fornecedores;

	public CadastroFornecedores(RepositorioFornecedores rep) {
		this.fornecedores = rep;
	}

	public void inserir(Fornecedor fornecedor) throws FornecedorJaCadastradoException, RepositorioFornecedoresCheioException {
		if (!(this.fornecedores.existe(fornecedor.getCodigo()))) {
			this.fornecedores.inserir(fornecedor);
		} else {
			throw new FornecedorJaCadastradoException();
		}
	}

	public Fornecedor procurar(String cnpj) throws FornecedorNaoEncontradoException {
		return fornecedores.procurar(cnpj);
	}
	
	public void atualizar(Fornecedor fornecedor) throws FornecedorNaoEncontradoException {
		this.fornecedores.atualizar(fornecedor);
	}
	
	public void remover(String cnpj) throws FornecedorNaoEncontradoException{
		this.fornecedores.remover(cnpj);
	}

	public RepositorioFornecedores getFornecedores() {
		return this.fornecedores;
	}

	public void setFornecedores(RepositorioFornecedores fornecedor) {
		this.fornecedores = fornecedor;
	}
}
