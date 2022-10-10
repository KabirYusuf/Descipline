package polling;

import java.util.Scanner;

public class Polling {
//    private static int totalNumber;
    private static final String [] topics = {"Political Issues", "Environmental Issues", "Religious Issues", "Global Issues", "Mental Issues"};
    private static final String [] results = {"Pol Issues", "Env Issues", "Rel Issues", "Glo Issues", "Men Issues"};

    private static final int [][] surveyResponses = new int[5][10];

    private static final Scanner scanner = new Scanner(System.in);



    public static void main(String[] args) {
        getSurveyResponses();
        displayResult();

    }

    private static void getSurveyResponses(){
        prompt("Enter total number of people that will be take part in the survey");
         int totalNumber= scanner.nextInt();
        for (int i = 0; i < totalNumber; i++) {
            for (int j = 0; j < topics.length; j++) {
                prompt("Enter rating btw 1 - 10 for " +  topics[j]);
                int rating = scanner.nextInt();
                surveyResponses[j][rating - 1] += rating;
            }
        }

    }

    private static void displayResult(){
        double sum = 0;
        double avg = 0;
        for (int i = 0; i < 5; i++) {
            System.out.print(results[i] + ":");
            for (int j = 0; j < 10; j++) {
                sum += surveyResponses[i][j];
                avg = sum / 10;
               System.out.print("\t\t\t"+ surveyResponses[i][j]);

            }
            System.out.print("\t\t" + avg);
            sum = 0;
            System.out.println();
        }
    }



    private static void prompt(String message){
        System.out.println(message);
    }

}
