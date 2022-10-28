package studentGrade;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TeacherTest {
    private List<Student>students = new ArrayList<>();

    private Student firstStudent;
    private Student secondStudent;

    private Student thirdStudent;
    private Teacher teacher;

    @BeforeEach
    void setUp() {
        firstStudent = new Student("Kabir",12,30,49);
        secondStudent = new Student("Yusuf", 54,32,59);
        thirdStudent = new Student("Ade", 74,16,59);
        teacher = new Teacher();

    }

    @Test
    void testThatTotalScoreOfStudentCanBeReturned(){
        double totalScore = firstStudent.getTotalScore();
        assertEquals(91, totalScore);
    }
    @Test
    void testThatFirstPositionIsReturnedForStudentTwoAndSecondPositionForStudentOne(){
        students.add(firstStudent);
        students.add(secondStudent);
        students.add(thirdStudent);
        students.sort((s1, s2) -> {
            return Double.compare(s2.getTotalScore(), s1.getTotalScore());
        });
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            student.setPosition(i + 1);
        }
        System.out.println(students);
    }
//    @Test
//    void test(){
//
//        for (Student student: students) {
//
//            int i = 1;
//            student.setPosition(i ++);
//        }
//    }

}