package ticTacToe;
import ticTacToe.exception.TicTacToeException;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import static java.lang.System.exit;
import static ticTacToe.Mark.*;
public class Main {
    private static Player player1 = new Player(X,"kaybee");
    private static Player player2 = new Player(O,"kay");
    private static Board board = new Board();
    static Random random = new Random();
    private  static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {startTicTacToe();}
    public static void startTicTacToe(){
        boardSurfaceUpdate();
        prompt("""
                Have Fun!!!
                Select an option.
                1- Play with human
                2- Play with Computer
                3- End Game""");
        System.out.println();
        int option = 0;
           try {
               option += scanner.nextInt();
           }catch (InputMismatchException e){
               prompt("Enter a valid number");
               scanner.nextLine();
               startTicTacToe();
           }


        switch (option) {
            case 1 -> playWithHuman();
            case 2 -> playWithComputer();
            case 3 -> exit(3);
            default -> startTicTacToe();
        }
    }
    public static  void playWithHuman(){
        playerOneMove();
        playerTwoMove();
        playWithHuman();
    }
    public static  void playWithComputer(){
        playerOneMove();
        computerMove();
        playWithComputer();
    }
    private static void playerOneMove() {
        prompt("Player 1 select position");
            try {
                int playerOnePosition = scanner.nextInt();
                player1.playGame(playerOnePosition, board);
                boardSurfaceUpdate();
                winnerTiePrompt("Player 1 is the winner");
            }catch (TicTacToeException | ArrayIndexOutOfBoundsException | InputMismatchException e){
                playerOneCatchBlock(e);
            }
    }
    private static void playerOneCatchBlock(RuntimeException e) {
        if(e.getMessage() == null){
            prompt("Only digits can be entered");
        }
        else prompt("Enter a valid number");
        scanner.nextLine();
        playerOneMove();
    }
    private static void playerTwoMove() {
        prompt("Player 2 select position");
            try {
                int playerTwoPosition = scanner.nextInt();
                player2.playGame(playerTwoPosition, board);
                boardSurfaceUpdate();
                winnerTiePrompt("Player 2 is the winner");
            }catch (TicTacToeException | ArrayIndexOutOfBoundsException | InputMismatchException e){
                playerTwoCatchBlock(e);
            }
    }
    private static void playerTwoCatchBlock(RuntimeException e) {
        if(e.getMessage() == null){
            prompt("Only digits can be entered");
        }
        else prompt("Enter a valid number");
        scanner.nextLine();
        playerTwoMove();
    }
    public static void computerMove(){
        prompt("Player 2 select position");
        try {
                int computerPosition = (1 + random.nextInt(9));
                player2.playGame(computerPosition, board);
                boardSurfaceUpdate();
                winnerTiePrompt("Player 2 is the winner");
            }catch (TicTacToeException | ArrayIndexOutOfBoundsException e){
                computerMoveCatchBlock(e);
            }
    }
    private static void computerMoveCatchBlock(RuntimeException e) {
        prompt(e.getMessage());
        prompt("Enter a valid number");
        computerMove();
    }
    private static void winnerTiePrompt(String prompt) {
        if(board.isAWinner()){
            prompt(prompt);
            exit(3);
        }
        if(board.isATie()){
            prompt("its a tie!!!");
            prompt("Restart Game");
            exit(3);
        }
    }
    public static void prompt(String prompt) {
        System.out.println(prompt);
    }
    private static void boardSurfaceUpdate() {
        board.displayBoardSurface();
    }

}