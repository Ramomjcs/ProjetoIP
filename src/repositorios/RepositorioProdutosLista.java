package repositorios;

import basicas.Produto;
import excecoes.ProdutoNaoEncontradoException;
import interfaces.RepositorioProdutos;

public class RepositorioProdutosLista implements RepositorioProdutos {
	
	private Produto produto;
	private RepositorioProdutosLista prox;
	
	public RepositorioProdutosLista() {
		this.produto = null;
		this.prox = null;
	}
	
	@Override
	public void inserir(Produto produto) {
		// TODO Auto-generated method stub
		if (this.produto == null) {
			this.produto = produto;
			this.prox = new RepositorioProdutosLista();
		} else {
			this.prox.inserir(produto);
		}
	}

	@Override
	public void atualizar(Produto produto) throws ProdutoNaoEncontradoException {
		// TODO Auto-generated method stub
		if (this.produto == null) {
			throw new ProdutoNaoEncontradoException();
		} else if (produto.getCodigo() == this.produto.getCodigo()) {
			this.produto = produto;
		} else {
			this.prox.atualizar(produto);
		}
	}

	@Override
	public void remover(int codigo) throws ProdutoNaoEncontradoException {
		// TODO Auto-generated method stub
		if (this.prox == null) {
			throw new ProdutoNaoEncontradoException();
		} else if(this.produto.getCodigo() == codigo) {
			this.produto = this.prox.produto;
			this.prox = this.prox.prox;
		} else {
			this.prox.remover(codigo);
		}
	}

	@Override
	public Produto procurar(int codigo) throws ProdutoNaoEncontradoException {
		if (this.produto == null) {
			throw new ProdutoNaoEncontradoException();
		} else if (this.produto.getCodigo() == codigo) {
			return this.produto;
		} else {
			return this.prox.procurar(codigo);
		}
	}

	public Produto getProduto() {
		return this.produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public RepositorioProdutosLista getProx() {
		return this.prox;
	}

	public void setProx(RepositorioProdutosLista prox) {
		this.prox = prox;
	}
	
}
