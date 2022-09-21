package ticTacToe;

import org.junit.jupiter.api.*;
import ticTacToe.exception.TicTacToeException;

import static org.junit.jupiter.api.Assertions.*;
import static ticTacToe.Mark.*;

class PlayerTest {
    private Player player1;
    private Player player2;

    private Board board;

    @BeforeEach
    void setUp(){
        player1 = new Player(X, "kaybee");
        player2 = new Player(O, "Jerry");
        board = new Board();
    }


    @Test
    void testToGetPlayerMark(){
        assertEquals(X, player1.getMark());
        assertEquals(O, player2.getMark());
    }

    @Test
    void testThatBoardExists(){
        assertNotNull(board);
    }

    @Test
    void testThatBoardIsEmpty(){
        board.displayBoardSurface();
    }

    @Test
    void player1CanPlayGameByPuttingMarkXOnThePositionEntered(){
        player1.playGame(2, board);
        Mark [][] boardSurface = board.getBoardSurface();
        assertEquals(X, boardSurface[0][1]);
    }
    @Test
    void player2CanPlayGameByPuttingMarkOOnThePositionEntered(){
        player2.playGame(3, board);
        Mark [][] boardSurface = board.getBoardSurface();
        assertEquals(O, boardSurface[0][2]);
    }

    @Test
    void player1AndPlayer2CanPlayGameByPuttingMarkXAndMarkOOnThePositionEnteredRespectively(){
        player1.playGame(5, board);
        player2.playGame(3, board);
        Mark [][] boardSurface = board.getBoardSurface();
        assertEquals(X, boardSurface[1][1]);
        assertEquals(O, boardSurface[0][2]);
    }

    @Test
    void exceptionIsThrownIfAPlayerEntersAPositionThatIsNotOnBoard(){
        assertThrows(ArrayIndexOutOfBoundsException.class,()-> player1.playGame(11,board));
        assertThrows(ArrayIndexOutOfBoundsException.class,()-> player1.playGame(0,board));
        assertThrows(ArrayIndexOutOfBoundsException.class,()-> player1.playGame(-5,board));
    }


    @Test
    void testThatPlayerCanOnlyPlayInAPositionThatIsEmpty_ExceptionIsThrownIfAPlayersTryToPlayOnAPositionThatIsNotEmpty(){
        Mark [][] boardSurface = board.getBoardSurface();
        player1.playGame(5, board);
        assertThrows(TicTacToeException.class, ()-> player2.playGame(5,board));
        assertEquals(X, boardSurface[1][1]);
    }

    @Test
    void trueIsReturnedIfThereIsAWinnerOnRowZero(){
        player1.playGame(1, board);
        player2.playGame(9, board);
        player1.playGame(2, board);
        player2.playGame(6, board);
        player1.playGame(3, board);
        assertTrue(board.isAWinner());
    }

    @Test
    void trueIsReturnedIfThereIsAWinnerOnRowOne(){
        player1.playGame(9, board);
        player2.playGame(4, board);
        player1.playGame(7, board);
        player2.playGame(5, board);
        player1.playGame(1, board);
        player2.playGame(6, board);
        assertTrue(board.isAWinner());
    }

    @Test
    void trueIsReturnedIfThereIsAWinnerOnRowTwo(){
        player1.playGame(7, board);
        player2.playGame(2, board);
        player1.playGame(8, board);
        player2.playGame(6, board);
        player1.playGame(9, board);
        assertTrue(board.isAWinner());
    }
    @Test
    void trueIsReturnedIfThereIsAWinnerOnColumnZero(){
        player1.playGame(9, board);
        player2.playGame(1, board);
        player1.playGame(5, board);
        player2.playGame(4, board);
        player1.playGame(3, board);
        player2.playGame(7, board);
        assertTrue(board.isAWinner());
    }

    @Test
    void trueIsReturnedIfThereIsAWinnerOnColumnOne(){
        player1.playGame(1, board);
        player2.playGame(2, board);
        player1.playGame(3, board);
        player2.playGame(5, board);
        player1.playGame(9, board);
        player2.playGame(8, board);
        assertTrue(board.isAWinner());
    }

    @Test
    void trueIsReturnedIfThereIsAWinnerOnColumnTwo(){
        player1.playGame(3, board);
        player2.playGame(2, board);
        player1.playGame(6, board);
        player2.playGame(5, board);
        player1.playGame(9, board);
        player2.playGame(1, board);
        assertTrue(board.isAWinner());
    }

    @Test
    void trueIsReturnedIfThereIsAWinnerForwardDiagonal(){
        player1.playGame(1, board);
        player2.playGame(2, board);
        player1.playGame(5, board);
        player2.playGame(6, board);
        player1.playGame(9, board);
        player2.playGame(8, board);
        assertTrue(board.isAWinner());
    }

    @Test
    void trueIsReturnedIfThereIsAWinnerBackWardDiagonal(){
        player1.playGame(3, board);
        player2.playGame(2, board);
        player1.playGame(5, board);
        player2.playGame(6, board);
        player1.playGame(7, board);
        player2.playGame(8, board);
        assertTrue(board.isAWinner());

    }
    @Test
    void trueIsReturnedWhenThereIsATie(){
        player1.playGame(1, board);
        player2.playGame(2, board);
        player1.playGame(3, board);
        player2.playGame(9, board);
        player1.playGame(5, board);
        player2.playGame(6, board);
        player1.playGame(8, board);
        player2.playGame(7, board);
        player1.playGame(4, board);
        assertFalse(board.isAWinner());
        assertTrue(board.isATie());

    }
}