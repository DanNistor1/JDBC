package masina_proprietar;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main2 {

    public static void main(String[] args) {

        Connection connection = null;
        try {
            connection = Utils.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select  proprietar.cnp_proprietar, proprietar.nume, count(*) \n" +
                    "from masina inner join proprietar on masina.cnp_proprietar = proprietar.cnp_proprietar\n" +
                    "group by masina.cnp_proprietar, proprietar.nume;");
            while (resultSet.next()) {
                int cnp_proprietar = resultSet.getInt(1);
                String nume = resultSet.getString(2);
                int count = resultSet.getInt(3);
                System.out.println(cnp_proprietar +
                        " " + nume  + " " + count);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Utils.tryToCloseConnection(connection);
        }
    }
}



