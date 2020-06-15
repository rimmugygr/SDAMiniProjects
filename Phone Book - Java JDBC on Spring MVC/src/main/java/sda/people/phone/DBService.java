package sda.people.phone;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.sql.*;
import java.util.*;

@Service
public class DBService {
    private static String URL_3 ="jdbc:mysql://localhost:3306/mydb?allowMultiQueries=true";
    private static String USER = "root";
    private static String PASSWORD = "admin";
    private Connection connection = null;

    @PostConstruct
    private void startConnection() {
        try {
            this.connection = DriverManager.getConnection(URL_3,USER,PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @PreDestroy
    public void closeConnection(){
        try {
            this.connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    Map<Integer,List<String>> getAllPeople(){
        String query = "select * from people order by id";
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            return stringResult(preparedStatement);
        } catch (SQLException e){
            e.printStackTrace();
            //return e.getMessage();
            return Collections.singletonMap(0, Collections.singletonList(e.getMessage()));
        }
    }

    Map<Integer,List<String>> getAllPhone(){
        String query = "select * from phones order by id";
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            return stringResult(preparedStatement);
        } catch (SQLException e){
            e.printStackTrace();
            //return e.getMessage();
            return Collections.singletonMap(0, Collections.singletonList(e.getMessage()));
        }
    }

    private Map<Integer,List<String>> stringResult(PreparedStatement preparedStatement) throws SQLException {
        Map<Integer,List<String>> resultMap = new HashMap<>();
        try (ResultSet resultSet = preparedStatement.executeQuery()) {
            int numberColumns = resultSet.getMetaData().getColumnCount();
            List<String> columnName = new ArrayList<>();
            for (int i = 1; i <= numberColumns; i++) {
                columnName.add(resultSet.getMetaData().getColumnLabel(i));
            }
            resultMap.put(-1,columnName);
            while (resultSet.next()) {
                List<String> newRecord = new ArrayList<>();
                for (int i = 1; i <= numberColumns; i++) {
                    newRecord.add (resultSet.getString(i));
                }
                resultMap.put(resultSet.getInt(1),newRecord);
            }
        }
        return resultMap;
    }


    public String addPerson(int id, String first_name, String second_name, String age, String gender) {

        String query = "INSERT INTO `people` (`id`,`first_name`,`last_name`,`age`,`gender`) VALUES (?,?,?,?,?);";
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2,first_name);
            preparedStatement.setString(3,second_name);
            preparedStatement.setString(4,age);
            preparedStatement.setString(5,gender);
            preparedStatement.execute();
        } catch (SQLException e){
            e.printStackTrace();
            return e.getMessage();
        }
        return null;
    }

    public String deletePerson(int id) {
        String queryCreateTempTab = "CREATE TEMPORARY table temp (select phones.id from people join phones on people.id=phones.person_id where people.id=?);";
        String queryDeletePhones =  "DELETE FROM phones WHERE id IN (SELECT * FROM temp);";
        String queryDeletePeople =  "DELETE FROM people WHERE id=? ;";
        String queryDropTempTab = "DROP TABLE temp;";

        try {
            connection.setAutoCommit(false);
            // create temp table with id
            PreparedStatement ps = connection.prepareStatement(queryCreateTempTab);
            ps.setInt(1, id);
            ps.execute();
            // delete base on id in temp table phones
            ps.executeUpdate(queryDeletePhones);
            // delete people
            ps = connection.prepareStatement(queryDeletePeople);
            ps.setInt(1,id);
            ps.execute();
            // drop temp table
            ps.executeUpdate(queryDropTempTab);
            connection.commit();
        } catch (SQLException e){
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            return e.getMessage();
        }
        return null;
    }

    public String addPhone(int id, String number, int person_id) {
        String query = "INSERT INTO `phones` (`id`,`number`,`person_id`) VALUES (?,?,?);";
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2,number);
            preparedStatement.setInt(3,person_id);
            preparedStatement.execute();
        } catch (SQLException e){
            e.printStackTrace();
            return e.getMessage();
        }
        return null;
    }

    public String deletePhone(int id) {
        String queryDeletePeople =  "DELETE FROM phones WHERE id=? ;";
        try(PreparedStatement ps = connection.prepareStatement(queryDeletePeople)) {
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException e){
            e.printStackTrace();
            return e.getMessage();
        }
        return null;
    }

    public String updatePerson(int id, String first_name, String second_name, String age, String gender) {
        String query = "UPDATE `people` SET `first_name`=?,`last_name`=?,`age`=?,`gender`=? WHERE id=?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(5, id);
            preparedStatement.setString(1,first_name);
            preparedStatement.setString(2,second_name);
            preparedStatement.setString(3,age);
            preparedStatement.setString(4,gender);
            preparedStatement.execute();
        } catch (SQLException e){
            e.printStackTrace();
            return e.getMessage();
        }
        return null;
    }

    public String updatePhone(int id, String number, int person_id) {
        String query = "UPDATE `phones` SET `number`=?,`person_id`=? WHERE id =?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(3, id);
            preparedStatement.setString(1,number);
            preparedStatement.setInt(2,person_id);
            preparedStatement.execute();
        } catch (SQLException e){
            e.printStackTrace();
            return e.getMessage();
        }
        return null;
    }
}
