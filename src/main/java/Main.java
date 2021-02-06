import java.sql.SQLException;
import java.text.ParseException;

public class Main {

    public static void main(String[] args) {

        Teacher teacherTest = new Teacher();
        Student studentTest = new Student();
        Class classTest = new Class();

        try {
            classTest.addClass();
        } catch (SQLException e){
            System.out.println("You did something wrong mate.");
        }

/*        try{
            Test.addTeacher();
        } catch (SQLException | ParseException e){
            System.out.println("Error adding person to database.");
        }*/


       /* teacherTest.getTeacherList();
        studentTest.getStudentList();*/

    }

}
