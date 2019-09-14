package main;

import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TestMain {

    @Test
    public void testSelect() {

        List<Persoana> persoane = new ArrayList<>();

        Connection connection = null;
        try {
            connection = Utils.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select id, name from persoana");
            while (resultSet.next()) {
                persoane.add(Utils.mapRowToPersoana(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Utils.tryToCloseConnection(connection);
        }

        System.out.println(persoane);
    }

    @Test
    public void testCRUD() {

        Connection connection = null;
        try {
            connection = Utils.getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate("create table xxx(id int, name varchar(20));");
            statement.executeUpdate("insert into xxx(id, name) values (1, 'gheorghe');");
            statement.executeUpdate("insert into xxx(id, name) values (2, 'marin');");
            statement.executeUpdate("insert into xxx(id, name) values (3, 'dan');");
            statement.executeUpdate("update xxx set name = 'mihai' where id = 2;");
            statement.executeUpdate("delete from xxx where id = 1;");

            PreparedStatement preparedStatement = connection.prepareStatement("select id, name from xxx where id = ? or name = ?;"); // pentru executii frecvente pentru ca se face optimizare si posibilitatea folosirii parametrilor, se foloseste preponderent
            preparedStatement.setInt(1, 2);
            preparedStatement.setString(2, "fgf");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int anInt = resultSet.getInt(1);
                String string = resultSet.getString(2);
                System.out.println(anInt + " " + string);
            }

//            CallableStatement callableStatement = connection.prepareCall("xxx"); //doar pentru proceduri si functii

//            statement.executeUpdate("drop table xxx;");

        } catch (SQLException e) {
            // proceseaza exceptia
            e.printStackTrace();
        } finally {
            Utils.tryToCloseConnection(connection);
        }
    }
}



