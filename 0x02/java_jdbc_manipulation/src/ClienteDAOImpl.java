package src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Logger;

public class ClienteDAOImpl implements ClienteDAO {

    Logger logger = Logger.getLogger(ClienteDAOImpl.class.getName());
    private Connection connection;

    public ClienteDAOImpl() {
        try {
            Class.forName("org.sqlite.JDBC");
            this.connection = DriverManager.getConnection("jdbc:sqlite:sqlite_database_marco_2022.db");
            logger.info("Connection to SQLite has been established.");
        } catch (Exception e) {
            throw new RuntimeException("Connection to SQLite has not been established.", e);
        }
    }

    @Override
    public Connection connect(String urlConexao) {
        return new ClienteDAOImpl().connection;
    }

    @Override
    public void createTable(String urlConexao) {
        try {
            String sql = "CREATE TABLE IF NOT EXISTS Cliente (id INTEGER PRIMARY KEY, nome TEXT, idade INTEGER, cpf TEXT, rg TEXT)";
            connection.createStatement().execute(sql);
            logger.info("Table Cliente has been created.");
        } catch (Exception e) {
            throw new RuntimeException("Table Cliente has not been created.", e);
        }
    }

    @Override
    public void insert(String url_conexao, Cliente cliente) {
        try {
            String sql = String.format("INSERT INTO Cliente (nome, idade, cpf, rg) VALUES ('%s', %d, '%s', '%s')", cliente.getNome(), cliente.getIdade(), cliente.getCpf(), cliente.getRg());
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.executeUpdate();
            logger.info("Cliente has been inserted.");
        } catch (Exception e) {
            throw new RuntimeException("Cliente has not been inserted.", e);
        }
    }

    @Override
    public void selectAll(String urlConexao) {
        try {
            String sql = String.format("SELECT * FROM Cliente");
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setIdade(rs.getInt("idade"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setRg(rs.getString("rg"));
            }
            logger.info("All clients have been selected.");
        } catch (Exception e) {
            throw new RuntimeException("Cliente has not been selected.", e);
        }
    }

    @Override
    public void update(String urlConexao, int id, String name, Integer idade) {
        try {
            String sql = String.format("UPDATE Cliente SET nome = '%s', idade = %d WHERE id = %d", name, idade, id);
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.executeUpdate();
            logger.info("Cliente has been updated.");
        } catch (Exception e) {
            throw new RuntimeException("Cliente has not been updated.", e);
        }
    }

    @Override
    public void delete(String urlConexao, int id) {
        try {
            String sql = String.format("DELETE FROM Cliente WHERE id = %d", id);
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.executeUpdate();
            logger.info("Cliente has been deleted.");
        } catch (Exception e) {
            throw new RuntimeException("Cliente has not been deleted.", e);
        }
    }
}
