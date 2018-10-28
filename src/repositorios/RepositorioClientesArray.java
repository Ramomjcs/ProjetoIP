package repositorios;

import basicas.Cliente;
import excecoes.ClienteNaoEncontradoException;
import excecoes.RepositorioClientesCheioException;
import interfaces.RepositorioClientes;

public class RepositorioClientesArray implements RepositorioClientes {
	private Cliente[] clientes = new Cliente[40];

	public void inserir(Cliente cliente) throws RepositorioClientesCheioException {
		boolean cheio = true;
		for (int i = 0; i < clientes.length && cheio; i++) {
			if (clientes[i] == null) {
				clientes[i] = cliente;
				cheio = false;
			}
		}
		if (cheio) {
			throw new RepositorioClientesCheioException();
		}
	}

	public Cliente procurar(String cpf) throws ClienteNaoEncontradoException {
		boolean achou = false;
		Cliente procurado = null;
		for (int i = 0; i < clientes.length && !achou; i++) {
			if (clientes[i] != null && clientes[i].getCodigo().equals(cpf)) {
				procurado = clientes[i];
				achou = true;
			}
		}
		if (!achou) {
			throw new ClienteNaoEncontradoException();
		}
		return procurado;
	}

	public void atualizar(Cliente cliente) throws ClienteNaoEncontradoException {
		boolean achou = false;
		for (int i = 0; i < clientes.length && !achou; i++) {
			if (clientes[i] != null && clientes[i].getCodigo().equals(cliente.getCodigo())) {
				this.clientes[i].setNome(cliente.getNome());
				this.clientes[i].setSaldo(cliente.getSaldo());
				this.clientes[i].setCpf(cliente.getCodigo());
				this.clientes[i].setGarcom(cliente.getGarcom());
				achou = true;
			}
		}
		if (!achou) {
			throw new ClienteNaoEncontradoException();
		}
	}

	public void remover(String cpf) throws ClienteNaoEncontradoException {

		boolean achou = false;
		for (int i = 0; i < clientes.length && !achou; i++) {
			if (clientes[i] != null && clientes[i].getCodigo().equals(cpf)) {
				clientes[i] = null;
				achou = true;
			}
		}
		if (!achou) {
			throw new ClienteNaoEncontradoException();
		}
	}

	@Override
	public boolean existe(String cpf) {
		for (int i = 0; i < clientes.length; i++) {
			if (clientes[i] != null && clientes[i].getCodigo().equals(cpf)) {
				return true;
			}
		}
		return false;
	}
}
