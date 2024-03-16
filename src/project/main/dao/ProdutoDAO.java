package project.main.dao;

import project.Cliente;
import project.Produto;
import project.main.dao.IProdutoDAO;
import project.main.dao.jdbc.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO implements IProdutoDAO {
    @Override
    public Integer cadastrar(Produto produto) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;

        try {
            connection = ConnectionFactory.getConnection();
            String sql ="INSERT INTO TB_PRODUTOS (ID, NOME, QTD, VALOR, CODIGO) VALUES(nextval('SQ_PRODUTOS'),?,?,?,?)";
            stm = connection.prepareStatement(sql);
            stm.setString(1, produto.getNome());
            stm.setInt(2, produto.getQuantidade());
            stm.setInt(3, produto.getValor());
            stm.setString(4, produto.getCodigo());
            return stm.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            if (stm != null && !stm.isClosed()) {
                stm.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }

    @Override
    public Integer atualizar(Produto produto) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = "INSERT INTO TB_PRODUTOS (ID, NOME, QTD, VALOR, CODIGO) VALUES (nextval('SQ_PRODUTOS'),?,?,?,?";
            stm = connection.prepareStatement(sql);
            stm.setString(1, produto.getNome());
            stm.setInt(2, produto.getQuantidade());
            stm.setInt(3, produto.getValor());
            stm.setString(4, produto.getCodigo());
            return stm.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            if(stm != null && !stm.isClosed()) {
                stm.close();
            }
            if(connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }

    @Override
    public Produto consultar(String codigo) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Produto produto = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = "SELECT * FROM TB_PRODUTOS WHERE CODIGO = ?";
            stm = connection.prepareStatement(sql);
            stm.setString(1, codigo);
            rs = stm.executeQuery();
             if (rs.next()) {
                produto = new Produto();
                produto.setId(rs.getLong("ID"));
                produto.setNome(rs.getString("NOME"));
                produto.setQuantidade(rs.getInt("QTD"));
                produto.setCodigo(rs.getString("CODIGO"));
                produto.setValor(rs.getInt("VALOR"));
            }
            return produto;
        } catch (Exception e) {
            throw e;
        } finally {
            if (rs != null) {
                rs.close();
            }
            if(stm != null && !stm.isClosed()) {
                stm.close();
            }
            if(connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }

    @Override
    public Integer excluir(Produto produtoDB) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = "DELETE FROM TB_PRODUTOS WHERE CODIGO = ?";
            stm = connection.prepareStatement(sql);
            stm.setString(1, produtoDB.getCodigo());
            return stm.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            if(stm != null && !stm.isClosed()) {
                stm.close();
            }
            if(connection != null && !connection.isClosed()) {
                stm.close();
            }
        }
    }

    @Override
    public List<Produto> consultarTodos() throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<Produto> list = new ArrayList<>();
        Produto produto = null;

        try {
            connection = ConnectionFactory.getConnection();
            String sql = "SELECT * FROM TB_PRODUTOS";
            stm = connection.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                produto = new Produto();

                produto.setId(rs.getLong("ID"));
                produto.setNome(rs.getString("NOME"));
                produto.setQuantidade(rs.getInt("QTD"));
                produto.setValor(rs.getInt("VALOR"));
                produto.setCodigo(rs.getString("CODIGO"));

                list.add(produto);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (rs != null && !rs.isClosed()) {
                rs.close();
            }
            if (stm != null && !stm.isClosed()) {
                stm.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
        return list;
    }
}
