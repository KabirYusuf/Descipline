package archeryGameOOP;

public class ResultSheet {
    private final int[][] resultSheet = new int[4][4];

    public int[][] getResultSheet() {
        return resultSheet;
    }

    public void displayResultSheet() {
        for (int i = 0; i < 4; i++) {
            System.out.print("Player" + (i + 1)+ "\t\t");
            for (int j = 0; j < 4; j++) {
                System.out.print(resultSheet[i][j]+ "\t\t");
            }
            System.out.println();
        }
    }

    public void winner(){
        int highestScore = resultSheet[0][0];
        int playerNumber = 0;
        for (int i = 0; i < 4; i++) {
            if(resultSheet[i][3] > highestScore){
                highestScore = resultSheet[i][3];
                playerNumber = i;
            }
        }
        System.out.println("Player" + (playerNumber + 1)+ " is the winner who scored a total point of " + highestScore);

    }
}
