import java.sql.*;
import java.util.*;

import javax.xml.stream.events.StartElement;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class DataProcessing {
    public static void showInfo(ResultSet rs) {
        try {
            while(rs.next()) {
                System.out.println(rs.getInt(1) + "-" + rs.getString(2));
            }
        } catch (Exception e) {
            System.out.println("Loi showinfo");
        }
    }

    public static boolean isPatientExist(int id) {
        var url = "jdbc:mysql://localhost:3306/mydatabase";
        var user = "root";
        var password = "";
        try(Connection connection = DriverManager.getConnection(url, user, password)) {
            String sql = "SELECT id FROM patient_data WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()) {
                System.out.println("ID đã tồn tại trong cơ sở dữ liệu");
                return false;
            }
            return true;


        } catch(Exception e) {
            System.out.println("Loi ket noi");
        }
        return false;
    }

    public static void addPatient(int id, String name, int age, int dayborn, int monthborn, int yearborn) {
        if(isPatientExist(id)) {
            var url = "jdbc:mysql://localhost:3306/mydatabase";
            var user = "root";
            var password = "";
            try(Connection connection = DriverManager.getConnection(url, user, password)) {
                PreparedStatement statement = null;

                String sql1 = "INSERT INTO patient_data(id, name, age, dayborn, monthborn, yearborn) VALUES (?, ?, ?, ?, ?, ?)";

                statement = connection.prepareStatement(sql1, 0, 0, 0);
                statement.setInt(1, id);
                statement.setString(2, name);
                statement.setInt(3, age);
                statement.setInt(4, dayborn);
                statement.setInt(5, monthborn);
                statement.setInt(6, yearborn);
                statement.addBatch();
                
                statement.executeBatch();

                connection.close();

            } catch(Exception e) {
                System.out.println("Loi insert");
            }
        }
    }

    public static void removePatient(int id, String name) {

    }
    public static void main(String[] args) {
        addPatient(6, "Day la id 6", 0, 0, 0, 0);
         
    }
}
