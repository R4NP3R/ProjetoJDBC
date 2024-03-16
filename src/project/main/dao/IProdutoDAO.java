package project.main.dao;

import project.Cliente;
import project.Produto;

import java.util.List;

public interface IProdutoDAO {

    public Integer cadastrar(Produto Produto) throws Exception;

    public Integer atualizar(Produto produto) throws Exception;
    Produto consultar(String codigo) throws Exception;

    Integer excluir(Produto produtoDB) throws Exception;

    List<Produto> consultarTodos() throws Exception;
}
