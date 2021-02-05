import java.sql.*;
import java.text.ParseException;
import java.util.Scanner;

public class Class {

    private final String connectionUrl = "jdbc:mysql://localhost:3306/firsttrial";
    private final String connectionUser = "root";
    private final String connectionPassword = "C00perSymin";

    public void addClass() throws SQLException {

        Scanner scan = new Scanner(System.in);

        String updateStatement = "INSERT INTO class (Class_name, Class_teacher) VALUES (?, ?);";
        Connection conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
        PreparedStatement stmt = conn.prepareStatement(updateStatement);

        System.out.println("Class name?");
        String className = scan.nextLine();

        System.out.println("Teacher's last name?");
        String lastName = scan.nextLine();

        String resultSet1 = "SELECT TeacherID FROM teachers WHERE Teacher_lastname = VALUES (?);";
        PreparedStatement stmt2 = conn.prepareStatement(resultSet1);

        stmt2.setString(1, lastName);
        ResultSet rs = stmt2.executeQuery();

        while (rs.next()) {
            int classId = rs.getInt("ClassID");
            String name = rs.getString("Class_name");
            String teacherId = rs.getString("Class_teacher");
        }

        stmt.setString(1, className);
        stmt.setString(2, lastName);

        stmt.executeUpdate();
    }

    public void getClassList() {

        try {
            Connection conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM firsttrial.class;");

            while (rs.next()) {
                int classId = rs.getInt("ClassID");
                String name = rs.getString("Class_name");
                String teacherId = rs.getString("Class_teacher");

                System.out.println("Class ID:" + classId + ", name:" + name
                        + ", Teacher ID:" + teacherId);
            }
            try {
                if (rs != null) rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
