import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@Nested
@DisplayName("Testy pre triedu Student")
public class PrikladVnorenehoTestu {

    public class Student {

        private String firstName;
        private String lastName;
        private int age;

        public Student(String firstName, String lastName, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public int getAge() {
            return age;
        }

    }

    @Test
    public void testInstancnejPremennej() {
        Student student = new Student("Patrik", "Vysoky", 30);
        assertThat(student, hasProperty("age"));
    }

    @Test
    public void testHodnotyInstancnejPremennej() {
        Student student = new Student("Patrik", "Vysoky", 30);
        assertThat(student, hasProperty("age", equalTo(30)));
    }

    @Test
    public void testHodnotyDvochObjektov() {
        Student student = new Student("Patrik", "Vysoky", 30);
        Student student2 = new Student("Patrik", "Vysoky", 30);
        assertThat(student, samePropertyValuesAs(student2));
    }

}
