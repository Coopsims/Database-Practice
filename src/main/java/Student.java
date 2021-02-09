import java.sql.*;
import java.text.ParseException;
import java.util.Scanner;

public class Student {

    private final String connectionUrl = "jdbc:mysql://localhost:3306/firsttrial";
    private final String connectionUser = "root";
    private final String connectionPassword = "C00perSymin";

    public void addStudent() throws SQLException {

        Scanner scan = new Scanner(System.in);

        String updateStatement = "INSERT INTO students (Student_firstname, Student_lastname, Student_DOB) VALUES (?, ?, ?);";
        Connection conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
        PreparedStatement stmt = conn.prepareStatement(updateStatement);

        ////////////////
        // Add student info to the preparedStatement
        ////////////////

        System.out.println("Student's first name?");
        String firstName = scan.nextLine();

        System.out.println("Student's last name?");
        String lastName = scan.nextLine();

        System.out.println("Student's date of birth? yyyy-MM-dd");
        String sBirthday = scan.nextLine();

        Date birthday=Date.valueOf(sBirthday);

        ////////////////
        // Adds student to table
        ////////////////

        stmt.setString(1, firstName);
        stmt.setString(2, lastName);
        stmt.setDate(3, birthday);

        stmt.executeUpdate();
    }

    public void getStudentList() {

        ////////////////
        // Gets all info for each row in table
        ////////////////

        try {
            Connection conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM firsttrial.students;");

            while (rs.next()) {
                int studentId = rs.getInt("StudentID");
                String lastName = rs.getString("Student_lastname");
                String firstName = rs.getString("Student_firstname");
                Date birthday = Date.valueOf(rs.getString("Student_DOB"));
                System.out.println("ID:" + studentId + ", First Name:" + firstName
                        + ", Last Name:" + lastName + ", Date of Birth:" + birthday);
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
