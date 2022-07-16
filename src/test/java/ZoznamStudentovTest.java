//import models.Student;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import java.util.Arrays;
//import java.util.List;
//
//import static org.hamcrest.MatcherAssert.assertThat;
//import static org.hamcrest.Matchers.*;
//
//public class ZoznamStudentovTest {
//
//    private static final Student STUDENT_1 = new Student("Laci", "Horvath", 20);
//    private static final Student STUDENT_2 = new Student("Katka", "Mala", 28);
//    private static final Student STUDENT_3 = new Student("Zuzka", "Stihla", 24);
//
//    private List<Student> studentList = null;
//
//    @BeforeEach
//    public void pripravStudentov() {
//        studentList = Arrays.asList(STUDENT_1, STUDENT_2, STUDENT_3);
//    }
//
//    @Test
//    public void testPoctuPrvkovVZozname() {
//        assertThat(studentList, hasSize(3));
//    }
//
//    @Test
//    public void testObsiahnutiaStudentovVLubovolnomPoradi() {
//        assertThat(studentList, containsInAnyOrder(STUDENT_3, STUDENT_1, STUDENT_2));
//    }
//
//    @Test
//    public void testObsiahnutiaStudentovVpRESNOMPoradi() {
//        assertThat(studentList, contains(STUDENT_1, STUDENT_2, STUDENT_3));
//    }
//
//    @Test
//    public void testStudentiStarsiAko25rokov() {
//        List<Integer> rocniky = Arrays.asList(STUDENT_1.getAge(), STUDENT_2.getAge(), STUDENT_3.getAge());
//
//        assertThat(rocniky, everyItem(greaterThanOrEqualTo(20)));
//    }
//
//
//}
