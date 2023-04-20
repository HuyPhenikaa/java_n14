import java.sql.*;
import java.util.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class DataProcessing {
    private static void showInfo(ResultSet rs) {
        try {
            while(rs.next()) {
                System.out.println(rs.getInt(1) + "-" + rs.getString(2));
            }
        } catch (Exception e) {
            System.out.println("Loi");
        }
    }
    public static void main(String[] args) {
        var url = "jdbc:mysql://localhost:3306/mydatabase";
        var user = "root";
        var password = "";
        try(Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println(conn.getCatalog());
            Statement statement = conn.createStatement(0, 0, 0);
            ResultSet resultSet = statement.executeQuery("select * from tblpatient");
            showInfo(resultSet);
        }
        catch (Exception e) {
            System.out.println("Loi");
        }
    }
}
