package test.domain;

import org.junit.Test;
import project.Cliente;
import project.Produto;
import project.main.dao.ClienteDAO;
import project.main.dao.IClienteDAO;
import project.main.dao.IProdutoDAO;
import project.main.dao.ProdutoDAO;

import static org.junit.Assert.*;

public class ProdutoTest {

    @Test
    public void cadastraProduto() throws Exception{
        IProdutoDAO produtoDAO = new ProdutoDAO();
        Produto produto = new Produto();

        produto.setNome("B450m");
        produto.setQuantidade(45);
        produto.setValor(540);
        produto.setCodigo("1234");

        Integer qtd = produtoDAO.cadastrar(produto);
        assertTrue(qtd == 1);

        Produto produtoBD = produtoDAO.consultar(produto.getCodigo());
        assertNotNull(produtoBD);
        assertNotNull(produtoBD.getCodigo());
        assertEquals(produto.getNome(), produtoBD.getNome());
        assertEquals(produto.getQuantidade(), produtoBD.getQuantidade());
        assertEquals(produto.getValor(), produtoBD.getValor());
        assertEquals(produto.getCodigo(), produtoBD.getCodigo());

        Integer qtdDel = produtoDAO.excluir(produtoBD);
        assertNotNull(qtdDel);
    }
}
