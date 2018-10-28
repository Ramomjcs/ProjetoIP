package basicas;

import excecoes.NaoHaEstoqueException;

public class Produto {

	private String nome;
	private double preco;
	private int codigo;
	private int estoque;
	private Fornecedor fornecedor;
	
	public Produto(String nome, double preco, int codigo, int estoque, Fornecedor fornecedor) {
		this.nome = nome;
		this.preco = preco;
		this.codigo = codigo;
		this.estoque = estoque;
		this.fornecedor = fornecedor;
	}
	
	public void adicionarEstoque(int produtosComprados) {
		this.estoque += produtosComprados;
	}
	
	public void tirarEstoque(int produtosVendidos) throws NaoHaEstoqueException {
		if (produtosVendidos <= this.estoque) {
			this.estoque -= produtosVendidos;
		} else {
			throw new NaoHaEstoqueException();
		}
	}
	
	public Fornecedor getFornecedor() {
		return this.fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public int getEstoque() {
		return this.estoque;
	}

	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}

	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public double getPreco() {
		return this.preco;
	}
	
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	public int getCodigo() {
		return this.codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
}