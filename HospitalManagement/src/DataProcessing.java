import java.sql.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class DataProcessing {

    public static void showInfo() {

        var url = "jdbc:mysql://localhost:3306/mydatabase";
        var user = "root";
        var password = "";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {

            String sql = "SELECT * FROM patient_data";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                int age = resultSet.getInt(3);
                int dayborn = resultSet.getInt(4);
                int monthborn = resultSet.getInt(5);
                int yearborn = resultSet.getInt(6);
                String room = resultSet.getString(7);

                System.out.println("ID: " + id + "     " + "Name: " + name + "     " + "Age: " + age + "     "
                        + "Birthday: " + dayborn + "/" + monthborn + "/" + yearborn + "     " + "Room: " + room);
                System.out.println(
                        "----------------------------------------------------------------------------------------------------");
            }

            // dong ket noi
            connection.close();

            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase2", user, password);
            String sql2 = "SELECT * FROM medicalchart";
            PreparedStatement stmt = conn.prepareStatement(sql2);
            ResultSet res = stmt.executeQuery();

            System.out.println(
                    "----------------------------------------------------------------------------------------------------");
            while (res.next()) {

                int id = res.getInt(1);
                int dayin = res.getInt(2);
                int monthin = res.getInt(3);
                int yearin = res.getInt(4);
                int dayout = res.getInt(5);
                int monthout = res.getInt(6);
                int yearout = res.getInt(7);
                String illness = res.getString(8);
                String note = res.getString(9);

                System.out.println("ID: " + id + "      " + "Date in: " + dayin + "/" + monthin + "/" + yearin + "     "
                        + "Date out: " + dayout + "/" + monthout + "/" + yearout + "     " + "Illness: " + illness
                        + "     " + "Note: " + note);
                System.out.println(
                        "----------------------------------------------------------------------------------------------------");
            }

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // in theo filter
    public static void showInfo(ResultSet resultSet) {

        try {
            while (resultSet.next()) {

                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                int age = resultSet.getInt(3);
                int dayborn = resultSet.getInt(4);
                int monthborn = resultSet.getInt(5);
                int yearborn = resultSet.getInt(6);
                String room = resultSet.getString(7);

                System.out.println("ID: " + id + "     " + "Name: " + name + "     " + "Age: " + age + "     "
                        + "Birthday: " + dayborn + "/" + monthborn + "/" + yearborn + "     " + "Room: " + room);
                System.out.println(
                        "----------------------------------------------------------------------------------------------------");
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
                System.out.println("ID is already exist in the patient database");
                return true;
            }
            return false;

        } catch (Exception e) {
            System.out.println("Loi ket noi");
            e.printStackTrace();
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
                System.out.println("ID is already exist in the medical chart database");
                return true;
            }

        } catch (Exception e) {
            System.out.println("Loi ket noi");
            e.printStackTrace();
        }
        return false;
    }

    // them benh nhan
    public static void addToDB(int id, String name, int age, int dayborn, int monthborn, int yearborn, String room) {

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
            statement.setString(7, room);
            statement.addBatch();

            statement.executeBatch();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addtoDB(int id, int dayIn, int monIN, int yeIN, int dayOut, int monOut, int yeOut,
            String illness, String note) {
        var url = "jdbc:mysql://localhost:3306/mydatabase2";
        var user = "root";
        var password = "";
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String sql1 = "INSERT INTO medicalchart(id, dayin, monthin, yearin, dayout, monthout, yearout, illness, note) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement statement = connection.prepareStatement(sql1);
            statement.setInt(1, id);
            statement.setInt(2, dayIn);
            statement.setInt(3, monIN);
            statement.setInt(4, yeIN);
            statement.setInt(5, dayOut);
            statement.setInt(6, monOut);
            statement.setInt(7, yeOut);
            statement.setString(8, illness);
            statement.setString(9, note);
            statement.addBatch();

            statement.executeBatch();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
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
            e.printStackTrace();
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
            e.printStackTrace();
        }
    }

    public static void changeInformationToDB(int id, String name, int age, int dayborn, int monthborn, int yearborn,
            String room) {

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

    public static void changeInformationToDB(int id, int dayIn, int monIN, int yeIN, int dayOut, int monOut, int yeOut,
            String illness, String note) {

        var url = "jdbc:mysql://localhost:3306/mydatabase2";
        var user = "root";
        var password = "";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {

            removeFromDB(id, true);
            addtoDB(id, dayIn, monIN, yeIN, dayOut, monOut, yeOut, illness, note);
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
            String sql = "SELECT id, name, age, dayborn, monthborn, yearborn, room FROM patient_data WHERE age = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, age);

            ResultSet rs = statement.executeQuery();
            showInfo(rs);
            // while(rs.next()) {
            // System.out.println(rs.getInt(1) + " " + rs.getString(2));
            // }
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // public static void filterRoom(int room) {

    // var url = "jdbc:mysql://localhost:3306/mydatabase";
    // var user = "root";
    // var password = "";

    // try (Connection connection = DriverManager.getConnection(url, user,
    // password)) {
    // PreparedStatement statement = null;
    // String sql = "SELECT id FROM patient_data WHERE room = ?";
    // statement = connection.prepareStatement(sql);
    // statement.setInt(1, room);

    // ResultSet rs = statement.executeQuery();
    // showInfo(rs);
    // connection.close();

    // } catch (SQLException e) {
    // e.printStackTrace();
    // }
    // }

    // public static void updateDB(TreatmentRoom tmr[]) {
    // int i = 0;
    // int n = 0;
    // for (TreatmentRoom treatmentRoom : tmr) {
    // n = n + treatmentRoom.getNumberOfPatient();
    // }
    // String[] name = new String[n];
    // int[] id = new int[n];
    // int[] age = new int[n];
    // int[] dayOfBirth = new int[n];
    // int[] monthOfBirth = new int[n];
    // int[] yearOfBirth = new int[n];
    // String[] nameOfTreatmentroom = new String[n];
    // String[] nameOfIllness = new String[n];
    // String[] note = new String[n];
    // int[] dayOfIn = new int[n];
    // int[] monthOfIn = new int[n];
    // int[] yearOfIn = new int[n];
    // int[] dayOfOut = new int[n];
    // int[] monthOfOut = new int[n];
    // int[] yearOfOut = new int[n];
    // for (TreatmentRoom treatmentRoom : tmr) {
    // treatmentRoom.getInformation(name, id, age, dayOfBirth, monthOfBirth,
    // yearOfBirth, nameOfTreatmentroom,
    // nameOfIllness, note, dayOfIn, monthOfIn, yearOfIn, dayOfOut, monthOfOut,
    // yearOfOut, i);
    // }
    // }
}
