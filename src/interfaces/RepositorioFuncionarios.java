package interfaces;

import basicas.Funcionario;
import excecoes.FuncionarioNaoEncontradoException;
import excecoes.RepositorioFuncionariosCheioException;

public interface RepositorioFuncionarios {

	public void inserir(Funcionario funcionario) throws RepositorioFuncionariosCheioException;
	public Funcionario procurar(String cpf) throws FuncionarioNaoEncontradoException;
	public void atualizar(Funcionario funcionario) throws FuncionarioNaoEncontradoException;
	public void remover(String cpf) throws FuncionarioNaoEncontradoException;
	public boolean existe(String cpf);
	
}
