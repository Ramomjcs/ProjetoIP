package negocios;

import basicas.Produto;
import excecoes.*;
import interfaces.*;

public class CadastroProdutos {
	
	private RepositorioProdutos produtos;
	
	public CadastroProdutos(RepositorioProdutos rep) {
		this.produtos = rep;
	}
	
	public void cadastrar(Produto produto) throws ProdutoJaCadastradoException {
		try {
			produtos.procurar(produto.getCodigo());
			throw new ProdutoJaCadastradoException();
		} catch (ProdutoNaoEncontradoException e) {
			produtos.inserir(produto);
		}
	}
	
	public void atualizarCadastro(Produto produto) throws ProdutoNaoEncontradoException {
//		Produto atualizado = produtos.procurar(produto.getCodigo());
		produtos.atualizar(produto);
	}
	
	public void removerCadastro(int codigo) throws ProdutoNaoEncontradoException {
		produtos.remover(codigo);
	}
	
	public Produto procurarCadastro(int codigo) throws ProdutoNaoEncontradoException {
		return produtos.procurar(codigo);
	}

	public RepositorioProdutos getProdutos() {
		return this.produtos;
	}

	public void setProdutos(RepositorioProdutos produtos) {
		this.produtos = produtos;
	}
}