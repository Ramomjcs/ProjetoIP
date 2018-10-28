package main;

import basicas.*;
import excecoes.*;
//import fachada.Restaurante;
//import negocios.CadastroClientes;
//import negocios.CadastroFuncionarios;
//import negocios.CadastroProdutos;
import repositorios.*;
import fachada.Restaurante;

public class Programa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RepositorioClientesLista repCli = new RepositorioClientesLista();
		RepositorioProdutosLista repPro = new RepositorioProdutosLista();
		RepositorioFuncionariosLista repFunc = new RepositorioFuncionariosLista();
		RepositorioFornecedoresLista repForn = new RepositorioFornecedoresLista();
		
		Restaurante turing = new Restaurante(repPro, repCli, repFunc, repForn);
		
		Funcionario func1 = new Funcionario("Mateus", "0001", "Gerente", (5000.00));
		Funcionario func1rep = new Funcionario("Mateus 2.0", "0001", "Garcom", (3000.00));
		Funcionario func2 = new Funcionario("Ramom", "0002", "Garcom", (3000.00));
		Funcionario func3 = new Funcionario("Paula", "0003", "Garcom", (3000.00));
		Funcionario func4 = new Funcionario("Vinicius", "0004", "Garcom", (3000.00));
		Funcionario func5 = new Funcionario("Mariana", "0005", "Garcom", (3000.00));
		Funcionario func6Inv = new Funcionario("Sergio", "0006", "Garcom", (3000.00));
		
		Fornecedor forn1 = new Fornecedor("forn1", "0001");
		Fornecedor forn1rep = new Fornecedor("forn1 2.0", "0001");
		Fornecedor forn2 = new Fornecedor("forn2", "0002");
		Fornecedor forn3 = new Fornecedor("forn3", "0003");
		Fornecedor forn4 = new Fornecedor("forn4", "0004");
		Fornecedor forn5 = new Fornecedor("forn5", "0005");
		Fornecedor forn6Inv = new Fornecedor("forn6", "0006");
		
		Produto prod1 = new Produto("prod1", 30, 1, 10, forn1);
		Produto prod2 = new Produto("prod2", 30, 2, 10, forn2);
		Produto prod3 = new Produto("prod3", 30, 3, 10, forn3);
		Produto prod4 = new Produto("prod4", 30, 4, 10, forn4);
		Produto prod5 = new Produto("prod5", 30, 5, 10, forn5);
		Produto prod1rep = new Produto("prod1 2.0", 30, 1, 10, forn1);
		Produto prod1Inv = new Produto("prod1", 30, 6, 10, forn6Inv);
		
		Cliente cli1 = new Cliente("cli1", "0001", 100, func1);
		Cliente cli2 = new Cliente("cli2", "0002", 100, func2);
		Cliente cli3 = new Cliente("cli3", "0003", 100, func3);
		Cliente cli4 = new Cliente("cli4", "0004", 100, func4);
		Cliente cli5 = new Cliente("cli5", "0005", 100, func5);
		Cliente cli1rep = new Cliente("cli1 2.0", "0001", 100, func1);
		Cliente cli1Inv = new Cliente("cli1", "0006", 100, func6Inv);
		
		System.out.println("Colocando valores nos repositorios das classes independentes:");
		System.out.println();
			
		try {
			System.out.println("Classe Funcionarios:");
			turing.cadastrarFuncionario(func1);
			turing.cadastrarFuncionario(func2);
			turing.cadastrarFuncionario(func3);
			turing.cadastrarFuncionario(func4);
			turing.cadastrarFuncionario(func5);
			System.out.println("Funcionarios inseridos com sucesso.");
		} catch (FuncionarioJaCadastradoException | RepositorioFuncionariosCheioException e) {
			// TODO Auto-generated catch block
			System.out.println("Erro na inserção de funcionarios.");;
		}
		
		try {
			System.out.println("Adicionando um funcionario ja cadastrado:");
			turing.cadastrarFuncionario(func1rep);
			System.out.println("Inserido funcionario repetido.");
		} catch (FuncionarioJaCadastradoException e) {
			System.out.println("Funcionario ja cadastrado.");
		} catch (RepositorioFuncionariosCheioException e) {
			System.out.println("Não estamos mais contratando");
		}
		
		System.out.println();
		try {
			System.out.println("Classe Fornecedores:");
			turing.cadastrarFornecedor(forn1);
			turing.cadastrarFornecedor(forn2);
			turing.cadastrarFornecedor(forn3);
			turing.cadastrarFornecedor(forn4);
			turing.cadastrarFornecedor(forn5);
			System.out.println("Fornecedores inseridos com sucesso.");
		} catch (FornecedorJaCadastradoException | RepositorioFornecedoresCheioException e) {
			// TODO Auto-generated catch block
			System.out.println("Nao deu certo");
		}
		
		try {
			System.out.println("Adicionando um fornecedor ja cadastrado:");
			turing.cadastrarFornecedor(forn1rep);
			System.out.println("Inserido fornecedor ja cadastrado.");
		} catch (FornecedorJaCadastradoException e) {
			System.out.println("Fornecedor ja cadastrado.");
		} catch (RepositorioFornecedoresCheioException e) {
			System.out.println("Não estamos mais contratando");
		}
		System.out.println();
		
		System.out.println("Agora das classes Basicas dependentes:");
		System.out.println();
		
		try {
			System.out.println("Classe Produto:");
			turing.cadastrarProduto(prod1);
			turing.cadastrarProduto(prod2);
			turing.cadastrarProduto(prod3);
			turing.cadastrarProduto(prod4);
			turing.cadastrarProduto(prod5);
			System.out.println("Produtos inseridos com sucesso.");
		} catch (ProdutoJaCadastradoException e) {
			// TODO Auto-generated catch block
			System.out.println("Deu ruim.");
		} catch (FornecedorInvalidoException e) {
			// TODO Auto-generated catch block
			System.out.println("Deu ruim.");
		}
		
		try {
			System.out.println("Adicionando um Produto ja cadastrado:");
			turing.cadastrarProduto(prod1rep);
			System.out.println("Inserção repetidade realizada.");
		} catch (ProdutoJaCadastradoException e) {
			// TODO Auto-generated catch block
			System.out.println("Produto ja cadastrado.");
		} catch (FornecedorInvalidoException e) {
			// TODO Auto-generated catch block
			System.out.println("Fornecedor invalido.");
		}
		
		try {
			System.out.println("Adicionando um Produto de fornecedor invalido:");
			turing.cadastrarProduto(prod1Inv);
			System.out.println("Inserção de produto invalido realizada.");
		} catch (ProdutoJaCadastradoException e) {
			// TODO Auto-generated catch block
			System.out.println("Produto ja cadastrado.");
		} catch (FornecedorInvalidoException e) {
			// TODO Auto-generated catch block
			System.out.println("Fornecedor invalido.");
		}
		System.out.println();
		
		try {
			System.out.println("Classe Cliente:");
			turing.cadastrarCliente(cli1);
			turing.cadastrarCliente(cli2);
			turing.cadastrarCliente(cli3);
			turing.cadastrarCliente(cli4);
			turing.cadastrarCliente(cli5);
			System.out.println("Clientes inseridos com sucesso.");
		} catch (ClienteJaCadastradoException e) {
			// TODO Auto-generated catch block
			System.out.println("Deu ruim.");
		} catch (FuncionarioInvalidoException e) {
			// TODO Auto-generated catch block
			System.out.println("Deu ruim.");
		} catch (RepositorioClientesCheioException e) {
			System.out.println("Ta cheio."); 
		}
		
		try {
			System.out.println("Cliente repetido:");
			turing.cadastrarCliente(cli1rep);
			System.out.println("Clientes repetido inserido.");
		} catch (ClienteJaCadastradoException e) {
			// TODO Auto-generated catch block
			System.out.println("Cliente ja cadastrado.");
		} catch (FuncionarioInvalidoException e) {
			// TODO Auto-generated catch block
			System.out.println("Garcom invalido");
		} catch (RepositorioClientesCheioException e) {
			System.out.println("Ta cheio."); 
		}
		
		try {
			System.out.println("Cliente invalido:");
			turing.cadastrarCliente(cli1Inv);
			System.out.println("Clientes invalido inserido.");
		} catch (ClienteJaCadastradoException e) {
			// TODO Auto-generated catch block
			System.out.println("Cliente ja cadastrado.");
		} catch (FuncionarioInvalidoException e) {
			// TODO Auto-generated catch block
			System.out.println("Garcom invalido.");
		} catch (RepositorioClientesCheioException e) {
			System.out.println("Ta cheio."); 
		}
		System.out.println();
		
		try {
			System.out.println("Demitindo Funcionario existente:");
			turing.demitirFuncionario(func5);
			System.out.println("Demitido com sucesso.");
		} catch (FuncionarioNaoEncontradoException e){
			System.out.println("Funcionario nao cadastrado.");
		}
		
		try {
			System.out.println("Demitindo Funcionario nao existente:");
			turing.demitirFuncionario(func6Inv);
			System.out.println("Demitido com sucesso.");
		} catch (FuncionarioNaoEncontradoException e){
			System.out.println("Funcionario nao cadastrado.");
		}
		System.out.println();
		
		try {
			System.out.println("Desvinculando empresa existente:");
			turing.desvincularFornecedor(forn5);
			System.out.println("Desvinculada com sucesso.");
		} catch (FornecedorNaoEncontradoException e) {
			System.out.println("Empresa nao cadastrada.");
		}
		
		try {
			System.out.println("Desvinculando empresa existente:");
			turing.desvincularFornecedor(forn6Inv);
			System.out.println("Desvinculada com sucesso.");
		} catch (FornecedorNaoEncontradoException e) {
			System.out.println("Empresa nao cadastrada.");
		}
		System.out.println();
		
		try {
			System.out.println("Expulsando cliente existente:");
			turing.expulsarCliente(cli5);
			System.out.println("Cliente expulso com sucesso.");
		} catch (ClienteNaoEncontradoException e) {
			System.out.println("Cliente nao cadastrado.");
		}
		
		try {
			System.out.println("Expulsando cliente nao existente:");
			turing.expulsarCliente(cli1Inv);
			System.out.println("Cliente expulso com sucesso.");
		} catch (ClienteNaoEncontradoException e) {
			System.out.println("Cliente nao cadastrado.");
		}
		System.out.println();
		
		try {
			System.out.println("Retirando produto existente do menu:");
			turing.retirarProduto(prod5);
			System.out.println("Produto retirado do menu.");
		} catch (ProdutoNaoEncontradoException e) {
			System.out.println("Produto nao cadastrado.");
		}
		
		try {
			System.out.println("Retirando produto nao existente do menu:");
			turing.retirarProduto(prod1Inv);
			System.out.println("Produto retirado do menu.");
		} catch (ProdutoNaoEncontradoException e) {
			System.out.println("Produto nao cadastrado.");
		}
		System.out.println();
		
		try {
			System.out.println("Atualizando fornecedor existente:");
			turing.atualizarFornecedor(forn1rep);
			System.out.println("Fornecedor atualizado com sucesso.");
		} catch (FornecedorNaoEncontradoException e) {
			System.out.println("Fornecedor nao cadastrado.");
		}
		
		try {
			System.out.println("Atualizando fornecedor nao existente:");
			turing.atualizarFornecedor(forn6Inv);
			System.out.println("Fornecedor atualizado com sucesso.");
		} catch (FornecedorNaoEncontradoException e) {
			System.out.println("Fornecedor nao cadastrado.");
		}
		System.out.println();
		
		try {
			System.out.println("Atualizando funcionario existente:");
			turing.atualizarFuncionario(func1rep);
			System.out.println("Atualizado com sucesso.");
		} catch (FuncionarioNaoEncontradoException e) {
			System.out.println("Funcionario nao cadastrado.");
		}
		
		try {
			System.out.println("Atualizando funcionario existente:");
			turing.atualizarFuncionario(func6Inv);
			System.out.println("Atualizado com sucesso.");
		} catch (FuncionarioNaoEncontradoException e) {
			System.out.println("Funcionario nao cadastrado.");
		}
		System.out.println();
		
		try {
			System.out.println("Atualizando Produto existente:");
			turing.atualizarProduto(prod1rep);
			System.out.println("Produto atualizado com sucesso.");
		} catch (ProdutoNaoEncontradoException e) {
			System.out.println("Produto nao cadastrado.");
		}
		
		try {
			System.out.println("Atualizando Produto existente:");
			turing.atualizarProduto(prod1Inv);
			System.out.println("Produto atualizado com sucesso.");
		} catch (ProdutoNaoEncontradoException e) {
			System.out.println("Produto nao cadastrado.");
		}
		
		System.out.println();
		
		try {
			System.out.println("Atualizando Cliente existente:");
			turing.atualizarCliente(cli1rep);
			System.out.println("Cliente atualizado com sucesso.");
		} catch (ClienteNaoEncontradoException e) {
			System.out.println("Cliente nao cadastrado.");
		}
		
		try {
			System.out.println("Atualizando Cliente existente:");
			turing.atualizarCliente(cli1Inv);
			System.out.println("Cliente atualizado com sucesso.");
		} catch (ClienteNaoEncontradoException e) {
			System.out.println("Cliente nao cadastrado.");
		}
		
		System.out.println();
		
		try {
			System.out.println("Realizando pedido tudo certo:");
			turing.pedir(cli4, prod4, 10);
			System.out.println("Pedido realizado com sucesso");
		} catch (FuncionarioInvalidoException e) {
			System.out.println("Cliente pedindo pra um garcom invalido.");
		} catch (ProdutoNaoEncontradoException e) {
			System.out.println("Produto nao tem no menu.");
		} catch (NaoHaEstoqueException e) {
			System.out.println("Produto sem estoque.");
		}
		
		try {
			System.out.println("Realizando pedido produto invalido:");
			turing.pedir(cli4, prod1Inv, 10);
			System.out.println("Pedido realizado com sucesso");
		} catch (FuncionarioInvalidoException e) {
			System.out.println("Cliente pedindo pra um garcom invalido.");
		} catch (ProdutoNaoEncontradoException e) {
			System.out.println("Produto nao tem no menu.");
		} catch (NaoHaEstoqueException e) {
			System.out.println("Produto sem estoque.");
		}
		
		try {
			System.out.println("Realizando pedido garcom invalido:");
			turing.pedir(cli1Inv, prod4, 10);
			System.out.println("Pedido realizado com sucesso");
		} catch (FuncionarioInvalidoException e) {
			System.out.println("Cliente pedindo pra um garcom invalido.");
		} catch (ProdutoNaoEncontradoException e) {
			System.out.println("Produto nao tem no menu.");
		} catch (NaoHaEstoqueException e) {
			System.out.println("Produto sem estoque.");
		}
		
		try {
			System.out.println("Realizando pedido sem estoque:");
			turing.pedir(cli4, prod4, 1000);
			System.out.println("Pedido realizado com sucesso");
		} catch (FuncionarioInvalidoException e) {
			System.out.println("Cliente pedindo pra um garcom invalido.");
		} catch (ProdutoNaoEncontradoException e) {
			System.out.println("Produto nao tem no menu.");
		} catch (NaoHaEstoqueException e) {
			System.out.println("Produto sem estoque.");
		}
	}	
}
