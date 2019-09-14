package masina_proprietar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class Utils {

    static void tryToCloseConnection(Connection connection) {

        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static Connection getConnection(){

        String url = "jdbc:mysql://localhost/companie";
        String user = "root";
        String password = "root";

        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException("Nu exista conexiune.");
        }
    }

    static Masina mapRowToMasina(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String culoare = resultSet.getString("culoare");
        String marca = resultSet.getString("marca");
        int cnp_proprietar = resultSet.getInt("cnp_proprietar");
        return new Masina(id, culoare, marca, cnp_proprietar);
    }

    static Proprietar mapRowToProprietar(ResultSet resultSet) throws SQLException {
        int cnp_proprietar = resultSet.getInt("cnp_proprietar");
        String nume = resultSet.getString("nume");
        return new Proprietar(cnp_proprietar, nume);
    }

    static Proprietar mapRowToProprietar1(ResultSet resultSet) throws SQLException {
        int cnp_proprietar = resultSet.getInt("cnp_proprietar");
        String nume = resultSet.getString("nume");
        int count = resultSet.getInt("count(*)");
        return new Proprietar(cnp_proprietar, nume, count);
    }

    public static void print(Map<Masina, Proprietar> map) {
        map.forEach((key, value) -> System.out.println(key + ":" + value));
    }

    public static void print(List<Proprietar> proprietarList){
        for(Proprietar proprietar : proprietarList  ) {
            System.out.println(proprietar.nume + " " + proprietar.count);
        }
    }
}
