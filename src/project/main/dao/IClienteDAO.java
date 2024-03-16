package project.main.dao;

import project.Cliente;

import java.util.List;

public interface IClienteDAO {

    public Integer cadastrar(Cliente cliente) throws Exception;

    public Integer atualizar(Cliente cliente) throws Exception;

    Cliente consultar(String codigo) throws Exception;

    Integer excluir(Cliente clienteBD) throws Exception;

    List<Cliente> consultarTodos() throws Exception;
}
