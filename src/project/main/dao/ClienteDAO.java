package project.main.dao;

import project.main.dao.jdbc.ConnectionFactory;
import project.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO implements IClienteDAO{
    @Override
    public Integer cadastrar(Cliente cliente) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql ="INSERT INTO TB_CLIENTE (ID, CODIGO, NOME) VALUES(nextval('SQ_CLIENTE'),?,?)";
            stm = connection.prepareStatement(sql);
            stm.setString(1, cliente.getCodigo());
            stm.setString(2, cliente.getNome());
            return stm.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            if( stm != null && !stm.isClosed()) {
                stm.close();
            }
            if(connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }

    @Override
    public Integer atualizar(Cliente cliente) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
            try {
                connection = ConnectionFactory.getConnection();
                String sql = "INSERT INTO TB_CLIENTE (ID, CODIGO, NOME) VALUES (nextval('SQ_CLIENTE'),?,?";
                stm = connection.prepareStatement(sql);
                stm.setString(1, cliente.getCodigo());
                stm.setString(2, cliente.getNome());
                return stm.executeUpdate();
            } catch (Exception e) {
                throw e;
            } finally {
                if( stm != null && !stm.isClosed()) {
                    stm.close();
                }
                if(connection != null && !connection.isClosed()) {
                    connection.close();
                }
            }
    }
    @Override
    public Cliente consultar(String codigo) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Cliente cliente = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql ="SELECT * FROM TB_CLIENTE WHERE CODIGO = ?";
            stm = connection.prepareStatement(sql);
            stm.setString(1, codigo);
            rs = stm.executeQuery();
            if (rs.next()) {
                cliente = new Cliente();
                cliente.setId(rs.getLong("id"));
                cliente.setCodigo(rs.getString("codigo"));
                cliente.setNome(rs.getString("nome"));
            }
            return cliente;
        } catch (Exception e) {
            throw e;
        } finally {
            if (rs != null) {
                rs.close();
            }
            if( stm != null && !stm.isClosed()) {
                stm.close();
            }
            if(connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }

    @Override
    public Integer excluir(Cliente cliente) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql ="DELETE FROM TB_CLIENTE WHERE CODIGO= ?";
            stm = connection.prepareStatement(sql);
            stm.setString(1, cliente.getCodigo());
            return stm.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            if( stm != null && !stm.isClosed()) {
                stm.close();
            }
            if(connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }
    public List<Cliente> consultarTodos() throws Exception{
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<Cliente> list = new ArrayList<>();
        Cliente cliente = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = "SELECT * FROM TB_CLIENTE";
            stm = connection.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                cliente = new Cliente();
                cliente.setId(rs.getLong("ID"));
                cliente.setNome(rs.getString("NOME"));
                cliente.setCodigo(rs.getString("CODIGO"));
                list.add(cliente);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (stm != null && !stm.isClosed()) {
                stm.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
            if (rs != null && !rs.isClosed()) {
                rs.close();
            }
        }
        return list;
    }

}
