package src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

public class ClienteDAOImpl implements ClienteDAO{

    Logger logger = Logger.getLogger(ClienteDAOImpl.class.getName());
    private Connection connection;

    public ClienteDAOImpl(){
        try {
            Class.forName("org.sqlite.JDBC");
            this.connection = DriverManager.getConnection("jdbc:sqlite:sqlite_database_marco_2022.db");
            logger.info("Connection to SQLite has been established.");
        } catch (Exception e) {
            throw new RuntimeException("Connection to SQLite has not been established.", e);
        }
    }



    @Override
    public Connection connect(String urlConexao)  {
        return new ClienteDAOImpl().connection;
    }

    @Override
    public void createTable(String urlConexao) {

    }

    @Override
    public void insert(String url_conexao, Cliente cliente) {

    }

    @Override
    public void selectAll(String urlConexao) {

    }

    @Override
    public void update(String urlConexao, int id, String name, Integer idade) {

    }

    @Override
    public void delete(String urlConexao, int id) {

    }
}
