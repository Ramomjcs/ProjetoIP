package repositorios;

import basicas.Produto;
import excecoes.ProdutoNaoEncontradoException;
import interfaces.RepositorioProdutos;

public class RepositorioProdutosArray implements RepositorioProdutos {
	
	private Produto[] produtos;
	private int ultimoIndice;
	private int tamanho;
	
	public RepositorioProdutosArray() {
		produtos = new Produto[100];
		this.ultimoIndice = -1; //não é o tamanho atual, e sim o ultimo indice
		this.tamanho = 100;
	}
	
	public void inserir(Produto produto) {
		// TODO Auto-generated method stub
		if (ultimoIndice < tamanho - 1) { // (tamanho - 1) é o ultimo indice suportado peelo array
			ultimoIndice++;
			produtos[ultimoIndice] = produto;
		} else {
			this.aumentarArray();
			this.inserir(produto);
		}
	}

	public void atualizar(Produto produto) throws ProdutoNaoEncontradoException {
		// TODO Auto-generated method stub
		int atualizado = this.acharIndice(produto.getCodigo());
		produtos[atualizado] = produto;
	}

	public void remover(int codigo) throws ProdutoNaoEncontradoException {
		// TODO Auto-generated method stub
		int indiceRemovido = this.acharIndice(codigo);
		
		for(int i = indiceRemovido; i < this.ultimoIndice; i++) {
			this.produtos[i] = this.produtos[i + 1];
		}
		
		this.produtos[this.ultimoIndice] = null;
		ultimoIndice--;
	}

	public Produto procurar(int codigo) throws ProdutoNaoEncontradoException {
		// TODO Auto-generated method stub
		int indiceProcurado = this.acharIndice(codigo);
		Produto procurado = this.produtos[indiceProcurado];
	
		return procurado;
	}
	
	public int acharIndice(int codigo) throws ProdutoNaoEncontradoException {
		boolean achou = false;
		int indiceProcurado = -1;
		
		for (int i = 0; i <= ultimoIndice && !achou; i++) {
			if(this.produtos[i].getCodigo() == codigo) {
				indiceProcurado = i;
				achou = true;
			}
		}
		
		if (!achou) {
			throw new ProdutoNaoEncontradoException();
		}
		
		return indiceProcurado;
	}
	
	public void aumentarArray() {
		Produto[] novoArray;
		
		this.tamanho *= 2;
		novoArray = new Produto[this.tamanho + 100];
		
		for(int i = 0; i <= this.ultimoIndice; i++) {
			novoArray[i] = this.produtos[i];
		}
		
		this.produtos = novoArray;
	}
	
}