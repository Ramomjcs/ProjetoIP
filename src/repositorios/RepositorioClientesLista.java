package repositorios;

import basicas.Cliente;
import excecoes.ClienteNaoEncontradoException;
import interfaces.RepositorioClientes;

public class RepositorioClientesLista implements RepositorioClientes {

	private Cliente cliente;
	private RepositorioClientesLista prox;

	public RepositorioClientesLista() {
		this.cliente = null;
		this.prox = null;
	}

	@Override
	public void inserir(Cliente cliente) {
		if (this.cliente == null) {
			this.cliente = cliente;
			this.prox = new RepositorioClientesLista();
		} else {
			this.prox.inserir(cliente);
		}
	}

	@Override
	public Cliente procurar(String cpf) throws ClienteNaoEncontradoException {

		if (this.cliente == null) {
			throw new ClienteNaoEncontradoException();
		} else if (this.cliente.getCodigo().equals(cpf)) {
			return this.cliente;
		} else {
			return this.prox.procurar(cpf);
		}

	}

	@Override
	public void atualizar(Cliente cliente) throws ClienteNaoEncontradoException{
		if(this.cliente.getCodigo().equals(cliente.getCodigo())){
			this.cliente.setNome(cliente.getNome());
			this.cliente.setSaldo(cliente.getSaldo());
			this.cliente.setCpf(cliente.getCodigo());
			this.cliente.setGarcom(cliente.getGarcom());
		} else if(this.prox.cliente != null) {
			this.prox.atualizar(cliente);
		} else {
			throw new ClienteNaoEncontradoException();
		}
	}

	@Override
	public void remover(String cpf) throws ClienteNaoEncontradoException {
		if (this.cliente == null) {
			throw new ClienteNaoEncontradoException();
		} else if (this.cliente.getCodigo().equals(cpf)) {
			this.cliente = this.prox.cliente;
			this.prox = this.prox.prox;
		} else {
			this.prox.remover(cpf);
		}
	}

	@Override
	public boolean existe(String cpf) {
		if (this.cliente == null) { //caso de lista vazia
			return false;
		} else if (this.cliente.getCodigo().equals(cpf)) {
			return true;
		} else if (this.prox.cliente != null) {
			return this.prox.existe(cpf);
		} else {
			return false;
		}
	}
}
