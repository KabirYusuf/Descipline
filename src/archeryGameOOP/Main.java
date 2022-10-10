package archeryGameOOP;

import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.System.exit;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static int sum = 0;
    private static int chance = 0;
    private static int playerTurn = 1;
    private static final Player playerOne = new Player();
    private static final Player playerTwo = new Player();
    private static final Player playerThree = new Player();
    private static final Player playerFour = new Player();
    private static final ResultSheet resultSheet = new ResultSheet();

    public static void main(String[] args) {
        startArcheryCompetition();
    }

    private static void startArcheryCompetition() {
        prompt("""
                Select an option
                1- Start Competition
                2- exit""");
       try {
           switch (input()){
               case 1: shoot();
               case 2: exit(2);
           }
       }catch (InputMismatchException e){
           prompt("Enter a valid option");
           scanner.nextLine();
           startArcheryCompetition();
       }

    }

    private static void shoot() {
        sum = 0;
        chance = 0;
        scanner.nextLine();
        winnerOfTheCompetition();
        playerToShoot();

    }

    private static void playerToShoot() {
        if(playerTurn == 1) playerOneShots();
        if(playerTurn == 2) playerTwoShots();
        if(playerTurn == 3) playerThreeShots();
        if(playerTurn == 4) playerFourShots();
    }

    private static void winnerOfTheCompetition() {
        if (playerTurn > 4){
            prompt("Thanks for taking part in the Competition");
            resultSheet.winner();
            exit(2);
        }
    }

    private static void playerFourShots() {
//        prompt("""
//                    Select an option
//                    1- Agree to shoot
//                    2- Exit""");
//        switch (input()){
//            case 1: playerShot(playerFour);
//            case 2:exit(2);
//        }
        prompt("Player 4 shoot");
        scanner.nextLine();
        playerShot(playerFour);
    }

    private static void playerThreeShots() {
        prompt("Player 3 shoot");
        scanner.nextLine();
        playerShot(playerThree);
    }

    private static void playerTwoShots() {
        prompt("Player 2 shoot");
        scanner.nextLine();
        playerShot(playerTwo);
    }

    private static void playerOneShots() {
            prompt("Player 1 Shoot");
            scanner.nextLine();
            playerShot(playerOne);
    }


    private static void playerShot(Player player) {
        var sheet = resultSheet.getResultSheet();
        while (chance < 3) {
            playerShootingChance(player, sheet);
            if (isPlayerChanceComplete()) break;
        }
        resultUpdate(player, sheet);

    }

    private static void resultUpdate(Player player, int[][] sheet) {
        prompt("Result sheet update");
        sheet[player.getPlayerNumber() - 1][3] = sum;
        resultSheet.displayResultSheet();
        displayAfterAPlayerShoots();
        playerTurn++;
        shoot();
    }

    private static void displayAfterAPlayerShoots() {
        if(playerTurn <= 3)prompt("Next player");
        else prompt("Display winner of the competition");
    }

    private static boolean isPlayerChanceComplete() {
        if(chance == 3) return true;
        else if(playerTurn == 1)playerOneShots();
        else if (playerTurn == 2) playerTwoShots();
        else if (playerTurn == 3) playerThreeShots();
        else if (playerTurn == 4) playerFourShots();
        return false;
    }

    private static void playerShootingChance(Player player, int[][] sheet) {
        int point = player.shoot();
        sum += point;
        sheet[player.getPlayerNumber() - 1][chance] = point;
        resultSheet.displayResultSheet();
        chance++;
    }

    private static void prompt(String message){
        System.out.println(message);
    }
    private static int input(){
        return scanner.nextInt();
    }
}
