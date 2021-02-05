import java.sql.*;
import java.text.ParseException;
import java.util.Scanner;

public class Teacher {
    private final String connectionUrl = "jdbc:mysql://localhost:3306/firsttrial";
    private final String connectionUser = "root";
    private final String connectionPassword = "C00perSymin";

    public void addTeacher() throws SQLException, ParseException {

        Scanner scan = new Scanner(System.in);

        String updateStatement = "INSERT INTO teachers (Teacher_firstname, Teacher_lastname, Teacher_subject) VALUES (?, ?, ?);";
        Connection conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
        PreparedStatement stmt = conn.prepareStatement(updateStatement);

        System.out.println("Teacher's first name?");
        String firstName = scan.nextLine();

        System.out.println("Teacher's last name?");
        String lastName = scan.nextLine();

        System.out.println("Teacher's subject?");
        String subjectName = scan.nextLine();


        stmt.setString(1, firstName);
        stmt.setString(2, lastName);
        stmt.setString(3, subjectName);

        stmt.executeUpdate();
    }

    public void getTeacherList() {

        try {
            Connection conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM firsttrial.teachers;");

            while (rs.next()) {
                int teacherId = rs.getInt("TeacherID");
                String lastName = rs.getString("Teacher_lastname");
                String firstName = rs.getString("Teacher_firstname");
                String subject = rs.getString("Teacher_subject");
                System.out.println("ID:" + teacherId + ", First Name:" + firstName
                        + ", Last Name:" + lastName + ", subject:" + subject);
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
