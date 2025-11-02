package api;
import game.Board;

public class Main {
    public static void main(String arg){

    }

    public Board start(){
        return new Board()
    }

    public void move(Board board, Player player, Move move){

    }

    public GameResult isComplete(Board board){
        if (board instanceof TicTacToeBoard) {
            TicTacToeBoard board1 = (TicTacToeBoard) board;
            // Check rows, columns, and diagonals for a win
            String firstCharacter = "-";
            boolean rowComplete = true;

            for (int i = 0; i < 3; i++) {
                rowComplete = false;
                firstCharacter = board1.cells[i][0];
                for (int j = 1, j < 3; j++) {
                    if (!board1.cells[i][j].equals(firstCharacter)) {
                        rowComplete = false;
                        break;
                    } 
                }
            }

            boolean colComplete = true;
            for (int i = 0; i < 3; i++) {
                colComplete = false;
                firstCharacter = board1.cells[0][i];
                for (int j = 1; j < 3; j++) {
                    if (!board1.cells[j][i].equals(firstCharacter)) {
                        colComplete = false;
                        break;
                    } 
                }
            }

        }
    }
}


