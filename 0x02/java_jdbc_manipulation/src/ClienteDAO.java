package src;

import java.sql.Connection;
import java.sql.SQLException;

public interface ClienteDAO {

    Connection connect(String urlConexao) throws SQLException;

    void createTable(String urlConexao);

    void insert(String url_conexao, Cliente cliente);

    void selectAll(String urlConexao);

    void update(String urlConexao, int id, String name, Integer idade);

    void delete(String urlConexao, int id);
}
