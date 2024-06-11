import HomeWork3.Person;
import HomeWork3.Student;
import org.junit.jupiter.api.*;
public class testPerson {
private Person p;
private Student s ;

    @BeforeEach
    public void createObjects() {
        p = new Person( " Shomookh", 24, " Al Qassim");
        System.out.println("creating before each");
    }
    @Test
    public void setAge(){
        int actual = p.getAge();
        double expected = 24;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void setStudentId(){
        s= new Student( " Shomookh", 24, " Al Qassim",200,"java");
        Assertions.assertNotNull(s.getStudentId());
        Assertions.assertNotNull(s) ;
        Assertions.assertEquals(-200, s.getStudentId());
    }



}
