import java.sql.SQLException;
import java.text.ParseException;

public class Main {

    public static void main(String[] args) {

        Teacher teacherTest = new Teacher();
        Student studentTest = new Student();

/*        try{
            Test.addTeacher();
        } catch (SQLException | ParseException e){
            System.out.println("Error adding person to database.");
        }*/


        teacherTest.getTeacherList();
        studentTest.getStudentList();

    }

}
