package masina_proprietar;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static masina_proprietar.Utils.getConnection;
import static masina_proprietar.Utils.tryToCloseConnection;

public class Join2 {

    public static void main(String[] args) {

        List<Proprietar> list = new ArrayList<>();

        Connection connection = null;
        try {
            connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select  proprietar.cnp_proprietar, proprietar.nume, count(*) \n" +
                    "from masina inner join proprietar on masina.cnp_proprietar = proprietar.cnp_proprietar\n" +
                    "group by masina.cnp_proprietar, proprietar.nume;");
            while (resultSet.next()) {
                list.add(Utils.mapRowToProprietar1(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            tryToCloseConnection(connection);
        }

        Utils.print(list);
    }
}
