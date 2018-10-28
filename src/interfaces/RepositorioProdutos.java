package interfaces;

import excecoes.*;
import basicas.*;

public interface RepositorioProdutos {

	public void inserir(Produto produto);
	public void atualizar(Produto produto) throws ProdutoNaoEncontradoException;
	public void remover(int codigo) throws ProdutoNaoEncontradoException;
	public Produto procurar(int codigo) throws ProdutoNaoEncontradoException;
	
}