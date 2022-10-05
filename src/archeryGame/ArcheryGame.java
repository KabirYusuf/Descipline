package archeryGame;

import java.util.Random;

public class ArcheryGame {
    private static final Random random = new Random();
    public static void main(String[] args) {
        randomArcheryGamePointCal();
    }

    private static int [][] gamePointsCalculation(){
        int [][] gamePoints = new int[4][4];
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                gamePoints[i][j] = random.nextInt(10);
                sum += gamePoints[i][j];
                if(j == 3){
                    sum -= gamePoints[i][j];
                    gamePoints[i][j] = sum;
                }
            }
            sum = 0;
        }
        return gamePoints;
    }


    public static  void randomArcheryGamePointCal(){
        int [][] highestScore = gamePointsCalculation();
        int maxScore = 0;
        System.out.println("\t\t Chance1 \t\t\tChance2\t\t\t  Chance3\t\t\t\tTotal");
        for (int i = 0; i < 4; i++) {
            System.out.print("Player " + (i + 1));
            for (int j = 0; j < 4; j++) {
                System.out.printf("    %-15d", highestScore[i][j]);
            }
            System.out.println();

        }
        maxScore = getMaxScore(highestScore, maxScore);
        System.out.println("The Maximum score is: " + maxScore);

    }

    private static int getMaxScore(int[][] highestScore, int maxScore) {
        int count = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 3; j < 4; j++) {
                if(highestScore[i][j] > maxScore){
                    maxScore = highestScore[i][j];
                    count = i;
                }
            }

        }
        System.out.println();
        System.out.println("Player" + " " +(count + 1) + " " + "Wins");
        return maxScore;
    }
}
