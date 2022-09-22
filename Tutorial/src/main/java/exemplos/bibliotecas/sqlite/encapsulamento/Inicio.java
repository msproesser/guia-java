package exemplos.bibliotecas.sqlite.encapsulamento;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;

public class Inicio {

    public static final String SAMPLE_TABLE = "exemplo";

    public static void main(String[] args) throws SQLException {
        Sqlite db = new Sqlite(null);
        db.dropTable(SAMPLE_TABLE);
        HashMap<String, String> fields = new HashMap<>();
        fields.put("id", "integer");
        fields.put("nome", "string");
        db.createTable(SAMPLE_TABLE, fields);
        db.insertRow(SAMPLE_TABLE, Arrays.asList(
                new DbField("Matheus", "nome"),
                new DbField(1, "id")
                )
        );
        ResultSet getAll = db.findAll(SAMPLE_TABLE);
        while (getAll.next()) {
            // read the result set
            System.out.println("name = " + getAll.getString("nome"));
            System.out.println("id = " + getAll.getInt("id"));
        }
    }
}
