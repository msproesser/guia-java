package exemplos.bibliotecas.sqlite.encapsulamento;

import java.sql.*;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Sqlite {
    private final Connection connection;
    private final Statement statement;

    public Sqlite(final String dbFilename) throws SQLException {
        String dbName = dbFilename == null ? ":memory:" : dbFilename;
        connection = DriverManager.getConnection("jdbc:sqlite:"+dbName);
        statement = connection.createStatement();
        statement.setQueryTimeout(30);  // set timeout to 30 sec.
    }

    public void dropTable(String tableName) throws SQLException {
        statement.executeUpdate("drop table if exists " + tableName);
    }

    public ResultSet findAll(String tableName) throws SQLException {
        return statement.executeQuery("select * from " + tableName);
    }

    public void createTable(String tableName, Map<String, String> fields) throws SQLException {
        String fieldsString = fields.entrySet().stream()
                .map(entry -> entry.getKey() + " " + entry.getValue())
                .collect(Collectors.joining(","));
        statement.executeUpdate("create table if not exists " + tableName + "(" + fieldsString + ")");
    }

    public int insertRow(String tableName, List<DbField> fields) throws SQLException {
        var tableColumns = fields.stream().map(DbField::column).collect(Collectors.joining(", "));
        var placeholders = fields.stream().map(DbField::column).map(x -> "?").collect(Collectors.joining(", "));
        PreparedStatement preparedStatement = connection.prepareStatement("insert into " + tableName +" (" + tableColumns + ") values ("+ placeholders +")");

        for (int index = 1; index <= fields.size() ; index++) {
            DbField field = fields.get(index - 1);
            if (field.value() instanceof Integer) preparedStatement.setInt(index, (Integer) field.value());
            if (field.value() instanceof String) preparedStatement.setString(index, (String) field.value());
        }
        return preparedStatement.executeUpdate();
    }
}
