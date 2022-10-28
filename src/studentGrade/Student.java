package studentGrade;

public class Student {
    private String name;
    private int id;
    private double subjectOneScore;
    private double subjectTwoScore;
    private double subjectThreeScore;

    private double totalScore;

    private int position;

   private static int count  = 1;

    public Student(String name, double subjectOneScore, double subjectTwoScore, double subjectThreeScore){

        this.name = name;
        this.subjectOneScore = subjectOneScore;
        this.subjectTwoScore = subjectTwoScore;
        this.subjectThreeScore = subjectThreeScore;
        totalScore = subjectOneScore + subjectTwoScore + subjectThreeScore;
        id = count;
        count ++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public double getTotalScore() {
        return totalScore;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }



    public void printFormat() {
        System.out.printf("%d\t\t%s\t\t%.2f\t\t%.2f\t\t%.2f\t\t%.2f\t\t%d%n",id,name,subjectOneScore,subjectTwoScore,subjectThreeScore,totalScore,position);
    }

}
