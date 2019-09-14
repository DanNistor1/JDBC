package main;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Persoana> persoane = new ArrayList<>();

        Connection connection = null;
        try {
            connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select id, name from persoana");
            while (resultSet.next()) {
                persoane.add(mapRowToPersoana(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            tryToCloseConnection(connection);
        }

        print(persoane);
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

    private static Persoana mapRowToPersoana(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt(1);
        String name = resultSet.getString(2);
        return new Persoana(id, name);
    }

    private static void tryToCloseConnection(Connection connection) {

        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void print(List<Persoana> persoane){
        for(Persoana persoana : persoane  ) {
            System.out.println(persoana.id + " " + persoana.name);
        }
    }
}



