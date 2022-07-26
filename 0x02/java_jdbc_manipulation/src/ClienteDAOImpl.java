import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAOImpl implements ClienteDAO{

    Connection conn = null;

    @Override
    public Connection connect(String urlConexao) {
        try {
            String url = "jdbc:sqlite:sqlite_database_marco_2022.db";
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return conn;
    }

    @Override
    public void createTable(String urlConexao) {
        String sql = "CREATE TABLE IF NOT EXISTS (" + "id integer PRIMARY KEY AUTO_INCREMENT ,"
                + "nome VARCHAR(100) NOT NULL," + "idade INTEGER NOT NULL," + "CPF VARCHAR(15) NOT NULL,"
                + "RG VARCHAR(20) NOT NULL)";
        try {
            connect(urlConexao);
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.execute();
            statement.close();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }

    }

    @Override
    public void insert(String url_conexao, Cliente cliente) {

        String sql = "INSERT INTO Clientes (nome, idade, CPF, RG) VALUES(?,?,?,?)";

        try {
            connect(url_conexao);
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, cliente.getNome());
            statement.setInt(2, cliente.getIdade());
            statement.setString(3, cliente.getCpf());
            statement.setString(4, cliente.getRg());

            statement.execute();
            statement.close();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }

    }

    @Override
    public void selectAll(String urlConexao) {
        String sql = "SELECT * FROM Clientes";
        List<Cliente> clientes = new ArrayList<>();

        try {
            connect(urlConexao);
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                Cliente cliente = new Cliente();
                cliente.setNome(resultSet.getString("nome"));
                cliente.setIdade(resultSet.getInt("idade"));
                cliente.setCpf(resultSet.getString("CPF"));
                cliente.setRg(resultSet.getString("RG"));

                clientes.add(cliente);
            }

            resultSet.close();
            statement.close();

            clientes.forEach(System.out::println);
        } catch (SQLException e){
            throw new RuntimeException(e);
        }

    }

    @Override
    public void update(String urlConexao, int id, String name, Integer idade) {
        String sql = "UPDADE Clientes SET nome = ?, idade = ? where id = ?";
        try {
            connect(urlConexao);
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, name);
            statement.setInt(2, idade);
            statement.setInt(3, id);

            statement.executeUpdate();
            statement.close();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }

    }

    @Override
    public void delete(String urlConexao, int id) {
        String sql = "DELETE FROM Clientes where id = ?";

        try {
            connect(urlConexao);
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }

    }
}
