package studentGrade;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Teacher {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private final List<Student> students = new ArrayList<>();

    public void addStudent(String name, double firstSubjectScore, double secondSubjectScore, double thirdSubjectScore){
        Student student = new Student(name, firstSubjectScore, secondSubjectScore, thirdSubjectScore);
        students.add(student);
        sort();
        position();
    }

    private void sort(){
        students.sort((s1, s2) -> Double.compare(s2.getTotalScore(), s1.getTotalScore()));

    }

    private void position(){
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            student.setPosition(i + 1);
        }
    }


    public List<Student> getStudents(){
        return students;
    }
}
