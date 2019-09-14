package masina_proprietar;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import static masina_proprietar.Utils.getConnection;
import static masina_proprietar.Utils.tryToCloseConnection;

public class Join1 {

    public static void main(String[] args) {

        Map<Masina, Proprietar> map = new HashMap<>();

        Connection connection = null;
        try {
            connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select masina.*, proprietar.* from masina inner join proprietar on masina.cnp_proprietar = proprietar.cnp_proprietar");
            while (resultSet.next()) {
                map.put(Utils.mapRowToMasina(resultSet), Utils.mapRowToProprietar(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            tryToCloseConnection(connection);
        }

        Utils.print(map);
    }
}
