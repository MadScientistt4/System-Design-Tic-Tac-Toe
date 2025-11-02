package SingleResponsibility;
import api.GameEngine;
import game.Board;
import game.Move;
import game.Cell;
import java.util.Scanner;
import game.Player;

public class Main {
    public static void main(String[] args) {
        GameEngine gameEngine = new GameEngine();
        Board board = gameEngine.start("TicTacToe");

        int row, col;
        Scanner scanner = new Scanner(System.in);
        while (!gameEngine.isComplete(board).isOver()) {
            Player computer = new Player("O");
            Player human = new Player("X");
            
            System.out.println("Make your move! :");
            row = scanner.nextInt();
            col = scanner.nextInt();

            Move humanMove = new Move(new Cell(row, col));
            gameEngine.move(board, human, humanMove);

            if (!gameEngine.isComplete(board).isOver()) {
                Move computerMove = gameEngine.suggestMove(computer, board);
                gameEngine.move(board, computer, computerMove);
            }
            System.out.println(board);
        }
        System.out.println("Game Over! Result: " + gameEngine.isComplete(board));
        System.out.println(board);
    }
}
