import java.beans.Statement;
import java.sql.*;
import java.util.*;

import javax.swing.plaf.nimbus.State;
import javax.xml.stream.events.StartElement;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class DataProcessing {
    // in
    public static void showInfo(ResultSet rs) {
        try {
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                System.out.println("ID: " + id + "     " + "Name: " + name);
                System.out.println("--------------------");
            }
        } catch (Exception e) {
            System.out.println("Loi showinfo");
        }
    }

    // kiem tra xem id co ton tai chua
    public static boolean isPatientExist(int id) {
        var url = "jdbc:mysql://localhost:3306/mydatabase";
        var user = "root";
        var password = "";
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String sql = "SELECT id FROM patient_data WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                System.out.println("ID is already exist in the database");
                return false;
            }
            return true;

        } catch (Exception e) {
            System.out.println("Loi ket noi");
        }
        return false;
    }

    public static boolean isPatientExist(int id, boolean medical) {
        var url = "jdbc:mysql://localhost:3306/mydatabase2";
        var user = "root";
        var password = "";
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String sql = "SELECT id FROM medicalchart WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                System.out.println("ID đã tồn tại trong cơ sở dữ liệu");
                return false;
            }
            return true;

        } catch (Exception e) {
            System.out.println("Loi ket noi");
        }
        return false;
    }

    // them benh nhan
    public static void addToDB(int id, String name, int age, int dayborn, int monthborn, int yearborn, int room) {
        if (!isPatientExist(id)) {
            var url = "jdbc:mysql://localhost:3306/mydatabase";
            var user = "root";
            var password = "";
            try (Connection connection = DriverManager.getConnection(url, user, password)) {
                String sql1 = "INSERT INTO patient_data(id, name, age, dayborn, monthborn, yearborn, room) VALUES (?, ?, ?, ?, ?, ?, ?)";

                PreparedStatement statement = connection.prepareStatement(sql1);
                statement.setInt(1, id);
                statement.setString(2, name);
                statement.setInt(3, age);
                statement.setInt(4, dayborn);
                statement.setInt(5, monthborn);
                statement.setInt(6, yearborn);
                statement.setInt(7, room);
                statement.addBatch();

                statement.executeBatch();
                connection.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void addtoDB(int id, String name, int dayIn, int monIN, int yeIN, int dayOut, int monOut, int yeOut,
            String illness, String note) {
        if (isPatientExist(id, true)) { // dang loi neu la true thi moi add
            var url = "jdbc:mysql://localhost:3306/mydatabase2";
            var user = "root";
            var password = "";
            try (Connection connection = DriverManager.getConnection(url, user, password)) {
                String sql1 = "INSERT INTO medicalchart(id, name, dayin, monthin, yearin, dayout, monthout, yearout, illness, note) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

                PreparedStatement statement = connection.prepareStatement(sql1);
                statement.setInt(1, id);
                statement.setString(2, name);
                statement.setInt(3, dayIn);
                statement.setInt(4, monIN);
                statement.setInt(5, yeIN);
                statement.setInt(6, dayOut);
                statement.setInt(7, monOut);
                statement.setInt(8, yeOut);
                statement.setString(9, illness);
                statement.setString(10, note);
                statement.addBatch();

                statement.executeBatch();
                connection.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // xoa benh nhan theo id
    public static void removeFromDB(int idToDelete) {
        var url = "jdbc:mysql://localhost:3306/mydatabase";
        var user = "root";
        var password = "";
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            PreparedStatement statement = null;
            String sql = "DELETE FROM patient_data WHERE id = ?";
            statement = connection.prepareStatement(sql);

            statement.setInt(1, idToDelete);
            statement.addBatch();

            statement.executeBatch();

            connection.close();
        } catch (Exception e) {
            System.out.println("Loi xoa");
        }
    }

    public static void removeFromDB(int idToDelete, boolean medical) {
        var url = "jdbc:mysql://localhost:3306/mydatabase2";
        var user = "root";
        var password = "";
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            PreparedStatement statement = null;
            String sql = "DELETE FROM medicalchart WHERE id = ?";
            statement = connection.prepareStatement(sql);

            statement.setInt(1, idToDelete);
            statement.addBatch();

            statement.executeBatch();

            connection.close();
        } catch (Exception e) {
            System.out.println("Loi xoa");
        }
    }

    public static void changeInformationToDB(int id, String name, int age, int dayborn, int monthborn, int yearborn,
            int room) {
        var url = "jdbc:mysql://localhost:3306/mydatabase";
        var user = "root";
        var password = "";
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            removeFromDB(id);
            addToDB(id, name, age, dayborn, monthborn, yearborn, room);
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void changeInformationToDB(int id, String name, int dayIn, int monIN, int yeIN, int dayOut,
            int monOut, int yeOut, String illness, String note) {
        var url = "jdbc:mysql://localhost:3306/mydatabase2";
        var user = "root";
        var password = "";
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            removeFromDB(id, true);
            addtoDB(id, name, dayIn, monIN, yeIN, dayOut, monOut, yeOut, illness, note);
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void filterAge(int age) {
        var url = "jdbc:mysql://localhost:3306/mydatabase";
        var user = "root";
        var password = "";
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            PreparedStatement statement = null;
            String sql = "SELECT id, name FROM patient_data WHERE age = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, age);

            ResultSet rs = statement.executeQuery();
            showInfo(rs);
            // while(rs.next()) {
            //     System.out.println(rs.getInt(1) + " " + rs.getString(2));
            // }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void filterRoom(int room) {
        var url = "jdbc:mysql://localhost:3306/mydatabase";
        var user = "root";
        var password = "";
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            PreparedStatement statement = null;
            String sql = "SELECT id FROM patient_data WHERE room = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, room);

            ResultSet rs = statement.executeQuery();
            showInfo(rs);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateDB(TreatmentRoom tmr[]) {
        int i = 0;
        int n = 0;
        for (TreatmentRoom treatmentRoom : tmr) {
            n = n + treatmentRoom.getNumberOfPatient();
        }
        String[] name = new String[n];
        int[] id = new int[n];
        int[] age = new int[n];
        int[] dayOfBirth = new int[n];
        int[] monthOfBirth = new int[n];
        int[] yearOfBirth = new int[n];
        String[] nameOfTreatmentroom = new String[n];
        String[] nameOfIllness = new String[n];
        String[] note = new String[n];
        int[] dayOfIn = new int[n];
        int[] monthOfIn = new int[n];
        int[] yearOfIn = new int[n];
        int[] dayOfOut = new int[n];
        int[] monthOfOut = new int[n];
        int[] yearOfOut = new int[n];
        for (TreatmentRoom treatmentRoom : tmr) {
            treatmentRoom.getInformation(name, id, age, dayOfBirth, monthOfBirth, yearOfBirth, nameOfTreatmentroom,
                    nameOfIllness, note, dayOfIn, monthOfIn, yearOfIn, dayOfOut, monthOfOut, yearOfOut, i);
        }
    }

    public static void main(String[] args) {
        // addToDB(7, "Day la id 6", 18, 13, 12, 2004);
        // removeFromDB(1);
        // changeInformationToDB(7, "da changed", 18, 17, 5, 2004, 1);
        // filterAge(18);
        // filterRoom(0);
        // addtoDB(2, " Huy", 1, 3, 2017, 13, 12, 2018, "dau bung", "Khong co gi");
        // removeFromDB(1, false);
        // changeInformationToDB(1, "Huy Quang", 4, 9, 9, 9, 9, 9, "good", "nothing");
    }
}
