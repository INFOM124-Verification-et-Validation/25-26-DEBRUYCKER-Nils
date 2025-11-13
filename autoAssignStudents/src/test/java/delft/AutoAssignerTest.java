package delft;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.within;
import java.time.temporal.ChronoUnit;

import java.util.*;
import java.util.stream.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;
import java.time.*;

class AutoAssignerTest {

    private ZonedDateTime date(int year, int month, int day, int hour, int minute) {
        return ZonedDateTime.of(year, month, day, hour, minute, 0, 0, ZoneId.systemDefault());
    }
    private Student jane = new Student(3156, "Jane", "Jane@student.unamur.be");
    private Student smith = new Student(5651,"smith","smith@student.unamur.be");
    private Student jake = new Student(8415,"jake","@student.unamur.be");
    private List<Student> students = Arrays.asList(jane, smith, jake);

    private ZonedDateTime date_workshop_1 = ZonedDateTime.of(2015, 1, 1, 1, 1, 0, 0, ZoneId.systemDefault());
    private ZonedDateTime date_workshop_2 = ZonedDateTime.of(2015, 2, 1, 1, 1, 0, 0, ZoneId.systemDefault());
    private ZonedDateTime date_workshop_3 = ZonedDateTime.of(2015, 3, 1, 1, 1, 0, 0, ZoneId.systemDefault());

    @BeforeEach
    void three_student_three_tasks(){
        Student jane = new Student(3156, "Jane", "Jane@student.unamur.be");
        Student smith = new Student(5651,"smith","smith@student.unamur.be");
        Student jake = new Student(8415,"jake","@student.unamur.be");
        List<Student> students = Arrays.asList(jane, smith, jake);

        ZonedDateTime date_workshop_1 = ZonedDateTime.of(2015, 1, 1, 1, 1, 0, 0, ZoneId.systemDefault());
        ZonedDateTime date_workshop_2 = ZonedDateTime.of(2015, 2, 1, 1, 1, 0, 0, ZoneId.systemDefault());
        ZonedDateTime date_workshop_3 = ZonedDateTime.of(2015, 3, 1, 1, 1, 0, 0, ZoneId.systemDefault());
        
    }
}
