package ticTacToe;

import ticTacToe.exception.TicTacToeException;

import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.System.exit;
import static ticTacToe.Mark.*;

public class Main {
    private static Player player1 = new Player(X,"kaybee");
    private static Player player2 = new Player(O,"kay");
    private static Board board = new Board();

    private  static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        startTicTacToe();
    }

    public static void startTicTacToe(){
        boardSurfaceUpdate();
        prompt("""
                Have Fun!!!
                Select an option.
                1- Play Tic Tac Toe
                2- End Game""");
        System.out.println();
        int option = 0;
       boolean isValidInput = true;
       while (isValidInput){
           try {
               option += scanner.nextInt();
               isValidInput = false;
           }catch (InputMismatchException e){
               prompt("Enter a valid number");
               scanner.nextLine();
           }
       }

        switch (option) {
            case 1 -> startGame();
            case 2 -> exit(2);
            default -> {
            }
        }
    }

    private static void prompt(String prompt) {
        System.out.println(prompt);
    }

    private static void boardSurfaceUpdate() {
        board.displayBoardSurface();
    }

    private static void startGame() {

        playerOneFirstInput();
        board.displayBoardSurface();
        int position;
        playerTwoFirstInput();
        board.displayBoardSurface();
        int position2;
        while (!board.isAWinner() && !board.isATie()){

            if (playerOneLoopInput())break;

            if (playerTwoLoopInput())break;



        }
        if(board.isATie()) prompt("Its a tie!!!\nRestart Game");

    }

    private static boolean playerTwoLoopInput() {
        int position2;
        prompt("player 2 enter position");

       boolean isAValidInput = true;
       while (isAValidInput){
           try {
               position2 = scanner.nextInt();
               isAValidInput = false;
               secondInput(player2, position2);
               board.displayBoardSurface();

           }
           catch (TicTacToeException | ArrayIndexOutOfBoundsException | InputMismatchException e) {
               prompt(e.getMessage());
               prompt("Enter a valid number");
               scanner.nextLine();
               playerTwoLoopInput();

           }

       }


        return board.isATie() || board.isAWinner();
    }

    private static boolean playerOneLoopInput() {
        int position;
        prompt("Player 1 enter Position");

       boolean isAValidInput = true;
       while (isAValidInput){
           try {
               position = scanner.nextInt();
               isAValidInput = false;
               firstInput(player1, position);
               boardSurfaceUpdate();


           }
           catch (TicTacToeException | ArrayIndexOutOfBoundsException | InputMismatchException  e){
               prompt(e.getMessage());
               prompt("enter a valid number");
               scanner.nextLine();
               playerOneLoopInput();
           }

       }
        return board.isATie() || board.isAWinner();

    }

    private static void playerTwoFirstInput() {
        int position2;
        prompt("player 2 enter position");
        boolean isAValidInput = true;

        while (isAValidInput){
            try {
                position2 = scanner.nextInt();
                isAValidInput = false;
                secondInput(player2, position2);

            }
            catch (TicTacToeException | ArrayIndexOutOfBoundsException e) {
                prompt(e.getMessage());
                playerTwoFirstInput();
            }
            catch (InputMismatchException e){
                prompt("enter a valid number");
                scanner.nextLine();
            }
        }

    }

    private static void playerOneFirstInput() {
        int position;
        prompt("Player 1 enter Position");
        boolean isAValidInput = true;
        while (isAValidInput){
            try {
                position = scanner.nextInt();
                isAValidInput = false;
                firstInput(player1, position);


            }
            catch (TicTacToeException | ArrayIndexOutOfBoundsException e){
                prompt(e.getMessage());
                playerOneFirstInput();
            }
            catch (InputMismatchException e){
                prompt("Enter a valid number");
                scanner.nextLine();
            }
        }

    }

    private static void secondInput(Player player2, int position2) {
        player2.playGame(position2,board);
    }

    private static void firstInput(Player player1, int position) {
        player1.playGame(position, board);
    }

}
