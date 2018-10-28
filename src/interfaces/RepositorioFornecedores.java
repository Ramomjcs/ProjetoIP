package interfaces;

import basicas.Fornecedor;
import excecoes.FornecedorNaoEncontradoException;
import excecoes.RepositorioFornecedoresCheioException;

public interface RepositorioFornecedores {

	public void inserir(Fornecedor fornecedor) throws RepositorioFornecedoresCheioException;
	public Fornecedor procurar(String cnpj) throws FornecedorNaoEncontradoException;
	public void atualizar(Fornecedor fornecedor) throws FornecedorNaoEncontradoException;
	public void remover(String cpf) throws FornecedorNaoEncontradoException;
	public boolean existe(String cpf);
	
}
