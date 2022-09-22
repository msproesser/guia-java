package exemplos.bibliotecas.sqlite;

import java.sql.*;

public class Basico {

    public static final String TABLE_NAME = "person";

    public static void main(String[] args) {
        Connection connection = null;
        try {
            // create a database connection
            connection = getConnection(null);
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.

            //statement.executeUpdate("drop table if exists person");
            createTable(statement, TABLE_NAME);
            insertRow(statement, TABLE_NAME, 1, "leo");
            insertRow(statement, TABLE_NAME, 2, "yui");
            ResultSet rs = findAll(statement, TABLE_NAME);
            while (rs.next()) {
                // read the result set
                System.out.println("name = " + rs.getString("name"));
                System.out.println("id = " + rs.getInt("id"));
            }
        } catch (SQLException e) {
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null) connection.close();
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
    }

    public static void createTable(Statement stmt, String tableName) throws SQLException {
        stmt.executeUpdate("create table if not exists " + tableName + "(id integer, name string)");
    }
    public static void deleteTable(Statement stmt, String tableName) throws SQLException {
        stmt.executeUpdate("drop table if exists " + tableName);
    }
    public static void insertRow(Statement stmt, String tableName, Integer id, String name) throws SQLException {
        stmt.executeUpdate("insert into "+ tableName +" values(" + id + ", '" + name + "')");
    }
    public static ResultSet findAll(Statement stmt, String tableName) throws SQLException {
        return stmt.executeQuery("select * from " + tableName);
    }

    public static Connection getConnection(final String filename) throws SQLException {
        //se o nome do arquivo for nulo, utilizar modo in-memory
        if (filename == null) return DriverManager.getConnection("jdbc:sqlite::memory:");
        // se tiver filename usa como nome para criar o banco
        return DriverManager.getConnection("jdbc:sqlite:"+filename);
    }
}
