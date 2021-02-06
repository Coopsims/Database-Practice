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

        Teacher teach = new Teacher();
        teach.getTeacherList();

        System.out.println("Teacher's last name?");
        String lastName = scan.nextLine();

        Statement stmt2 = conn.createStatement();

        ResultSet rs = stmt2.executeQuery("SELECT TeacherID FROM firsttrial.teachers WHERE Teacher_lastname = '" +lastName+"';");
        int classId = 0;
        while (rs.next()) {
            classId = rs.getInt("TeacherID");
        }

        stmt.setString(1, className);
        stmt.setInt(2, classId);

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
