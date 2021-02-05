import java.sql.SQLException;
import java.text.ParseException;

public class Main {

    public static void main(String[] args) {

        Teacher Test = new Teacher();

        try{
            Test.addTeacher();
        } catch (SQLException | ParseException e){
            System.out.println("Error adding person to database.");
        }


        Test.getTeacherList();

    }

}
