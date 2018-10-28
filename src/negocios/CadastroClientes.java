package negocios;

import basicas.Cliente;
import interfaces.RepositorioClientes;
import excecoes.*;

public class CadastroClientes {
	
	private RepositorioClientes clientes;

	public CadastroClientes(RepositorioClientes rep) {
		this.clientes = rep;
	}

	public void inserir(Cliente cliente) throws ClienteJaCadastradoException, RepositorioClientesCheioException {
		if (!(this.clientes.existe(cliente.getCodigo()))) {
			this.clientes.inserir(cliente);
		} else {
			throw new ClienteJaCadastradoException();
		}
	}

	public Cliente procurar(String cpf) throws ClienteNaoEncontradoException {
		return clientes.procurar(cpf);
	}
	
	public void atualizar(Cliente cliente) throws ClienteNaoEncontradoException {
		this.clientes.atualizar(cliente);
	}
	
	public void remover(String cpf) throws ClienteNaoEncontradoException{
		this.clientes.remover(cpf);
	}

	public RepositorioClientes getClientes() {
		return this.clientes;
	}

	public void setClientes(RepositorioClientes clientes) {
		this.clientes = clientes;
	}
}
