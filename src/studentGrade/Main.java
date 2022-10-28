package studentGrade;

import java.util.List;
import java.util.Scanner;


import static ticTacToe.Main.prompt;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    private static final Teacher teacher = new Teacher();

    public static void main(String[] args) {
        studentGradeApplication();
    }

    private static void studentGradeApplication() {
        prompt("""
                Select an option
                1. Enter student grade
                2. Display result""");
        int option = scanner.nextInt();
        switch (option) {
            case 1 -> enterStudentGrade();
            case 2 -> displayStudentResult();
        }


    }

    private static void displayStudentResult() {
        List<Student> students = teacher.getStudents();
        for (Student student:students) {
            student.printFormat();
        }

    }

    private static void enterStudentGrade() {
        prompt("Enter student name");
        String name = scanner.next();
        prompt("Enter subject one grade");
        double subOneScore = scanner.nextDouble();
        prompt("Enter subject two grade");
        double subTwoScore = scanner.nextDouble();
        prompt("Enter subject three grade");
        double subThreeScore = scanner.nextDouble();
        teacher.addStudent(name, subOneScore,subTwoScore,subThreeScore);
        studentGradeApplication();
    }

}
