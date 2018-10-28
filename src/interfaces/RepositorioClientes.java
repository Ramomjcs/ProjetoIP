package interfaces;

import basicas.Cliente;
import excecoes.ClienteNaoEncontradoException;
import excecoes.RepositorioClientesCheioException;

public interface RepositorioClientes {
	
	public void inserir(Cliente cliente) throws RepositorioClientesCheioException;
	public Cliente procurar(String cpf) throws ClienteNaoEncontradoException;
	public void atualizar(Cliente cliente) throws ClienteNaoEncontradoException;
	public void remover(String cpf) throws ClienteNaoEncontradoException;
	public boolean existe(String cpf);
	
}
