package masina_proprietar;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main1 {

    public static void main(String[] args) {

        List<Join1> list = new ArrayList<>();

        Connection connection = null;
        try {
            connection = Utils.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select masina.*, proprietar.* from masina inner join proprietar on masina.cnp_proprietar = proprietar.cnp_proprietar");
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String culoare = resultSet.getString(2);
                String marca = resultSet.getString(3);
                int cnp_proprietar1 = resultSet.getInt(4);
                int cnp_proprietar2 = resultSet.getInt(5);
                String nume = resultSet.getString(6);
                System.out.println(id + " " + culoare + " " + marca + " " + cnp_proprietar1 +
                        " " + cnp_proprietar2 + " " + nume);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Utils.tryToCloseConnection(connection);
        }
    }
}



