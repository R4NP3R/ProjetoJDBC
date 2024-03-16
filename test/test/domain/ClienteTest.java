package test.domain;

import org.junit.Test;


import project.Cliente;
import project.main.dao.ClienteDAO;
import project.main.dao.IClienteDAO;

import static org.junit.Assert.*;

public class ClienteTest {

    @Test
    public void cadastraCliente() throws Exception {
        IClienteDAO clienteDAO = new ClienteDAO();
        Cliente cliente = new Cliente();
        cliente.setCodigo("01");
        cliente.setNome("Ranper");

        Integer qtd = clienteDAO.cadastrar(cliente);
        assertTrue(qtd == 1);

        Cliente clienteBD = clienteDAO.consultar(cliente.getCodigo());
        assertNotNull(clienteBD);
        assertNotNull(clienteBD.getId());
        assertEquals(cliente.getCodigo(), clienteBD.getCodigo());
        assertEquals(cliente.getNome(), clienteBD.getNome());

        Integer qtdDel = clienteDAO.excluir(clienteBD) ;
        assertNotNull(qtdDel);
    }

}