package fachada;

import negocios.*;
import basicas.*;
import excecoes.*;
import interfaces.*;

public class Restaurante {
	
	private CadastroProdutos produtos;
	private CadastroClientes clientes;
	private CadastroFuncionarios funcionarios;
	private CadastroFornecedores fornecedores;

	public Restaurante(RepositorioProdutos repProd, RepositorioClientes repCli, RepositorioFuncionarios repFunc, RepositorioFornecedores repForn) {
		this.produtos = new CadastroProdutos(repProd);
		this.clientes = new CadastroClientes(repCli);
		this.funcionarios = new CadastroFuncionarios(repFunc);
		this.fornecedores = new CadastroFornecedores(repForn);
	}

	public void cadastrarFuncionario(Funcionario funcionario) throws FuncionarioJaCadastradoException, RepositorioFuncionariosCheioException {
		funcionarios.inserir(funcionario);
	}
	
	public void cadastrarFornecedor(Fornecedor fornecedor) throws FornecedorJaCadastradoException, RepositorioFornecedoresCheioException {
		fornecedores.inserir(fornecedor);
	}
	
	public void cadastrarProduto(Produto produto) throws ProdutoJaCadastradoException, FornecedorInvalidoException {
		try {
			fornecedores.procurar(produto.getFornecedor().getCodigo());
			produtos.cadastrar(produto);
		} catch (FornecedorNaoEncontradoException e) {
			// TODO Auto-generated catch block
			throw new FornecedorInvalidoException();
		}
	}
	
	public void cadastrarCliente(Cliente cliente) throws FuncionarioInvalidoException, ClienteJaCadastradoException, RepositorioClientesCheioException {
		try {
			funcionarios.procurar(cliente.getGarcom().getCodigo());
			clientes.inserir(cliente);
		} catch (FuncionarioNaoEncontradoException e) {
			// TODO Auto-generated catch block
			throw new FuncionarioInvalidoException();
		}
	}
	
	public void demitirFuncionario(Funcionario funcionario) throws FuncionarioNaoEncontradoException {
		funcionarios.remover(funcionario.getCodigo());
	}
	
	public void desvincularFornecedor(Fornecedor fornecedor) throws FornecedorNaoEncontradoException {
		fornecedores.remover(fornecedor.getCodigo());
	}
	
	public void expulsarCliente(Cliente cliente) throws ClienteNaoEncontradoException {
		clientes.remover(cliente.getCodigo());
	}
	
	public void retirarProduto(Produto produto) throws ProdutoNaoEncontradoException {
		produtos.removerCadastro(produto.getCodigo());
	}
	
	public void atualizarFornecedor(Fornecedor fornecedor) throws FornecedorNaoEncontradoException {
		fornecedores.atualizar(fornecedor);
	}
	
	public void atualizarFuncionario(Funcionario func) throws FuncionarioNaoEncontradoException {
		funcionarios.atualizar(func);
	}
	
	public void atualizarProduto(Produto produto) throws ProdutoNaoEncontradoException {
		produtos.atualizarCadastro(produto);
	}
	
	public void atualizarCliente(Cliente cliente) throws ClienteNaoEncontradoException {
		clientes.atualizar(cliente);
	}
	
	public void pedir(Cliente cliente, Produto produto, int numero) throws FuncionarioInvalidoException, ProdutoNaoEncontradoException, NaoHaEstoqueException {
		try {
			funcionarios.procurar(cliente.getGarcom().getCodigo());
			produtos.procurarCadastro(produto.getCodigo());
			produto.tirarEstoque(numero);
			produtos.atualizarCadastro(produto);
		} catch (FuncionarioNaoEncontradoException e) {
			// TODO Auto-generated catch block
			throw new FuncionarioInvalidoException();
		}
	}
}
