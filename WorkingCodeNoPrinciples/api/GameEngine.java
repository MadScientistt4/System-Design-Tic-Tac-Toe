package api;
import game.Board;
import boards.TicTacToeBoard;
import game.Move;
import game.Player;
import game.GameResult;
import game.Cell;
public class GameEngine {

    public Board start(String type){
        if (type.equals("TicTacToe")) {
            return new TicTacToeBoard();
        } else {
            throw new IllegalArgumentException("Unsupported board type: " + type);
        }
    }

    public void move(Board board, Player player, Move move){
        if (board instanceof TicTacToeBoard) {
            TicTacToeBoard board1 = (TicTacToeBoard) board;
            board1.setCell(player.symbol(), move.getCell());
        } else {
            throw new IllegalArgumentException("Unsupported board type for move");
        }
    }

    public GameResult isComplete(Board board){
        if (board instanceof TicTacToeBoard) {
            TicTacToeBoard board1 = (TicTacToeBoard) board;
            // Check rows, columns, and diagonals for a win

            String firstCharacter = "-";
            boolean rowComplete = true;

            for (int i = 0; i < 3; i++) {
                firstCharacter = board1.getCell(i, 0);
                rowComplete = firstCharacter != null;
                if (firstCharacter != null) {
                    for (int j = 1; j < 3; j++) {
                        if (!firstCharacter.equals(board1.getCell(i, j))) {
                            rowComplete = false;
                            break;
                        } 
                    }
                }
                
                if (rowComplete) {
                    break;
                }
            }

            if (rowComplete) {
                return new GameResult(true, firstCharacter);
            }

            boolean colComplete = true;
            for (int i = 0; i < 3; i++) {
                firstCharacter = board1.getCell(0, i);
                colComplete = firstCharacter != null;
                if (firstCharacter != null) {
                    for (int j = 1; j < 3; j++) {
                        if (!firstCharacter.equals(board1.getCell(j, i))) {
                            colComplete = false;
                            break;
                        } 
                    }
                }
                if (colComplete) {
                    break;
                }
            }
            if (colComplete) {
                return new GameResult(true, firstCharacter);
            }
        
            
            firstCharacter = board1.getCell(0, 0);
            boolean diaComplete = firstCharacter!= null;
            for (int i = 1; i < 3; i++) {
                if (firstCharacter != null && !firstCharacter.equals(board1.getCell(i, i))) {
                    diaComplete = false;
                    break;
                }
            }

            if (diaComplete) {
                return new GameResult(true, firstCharacter);
            }

            firstCharacter = board1.getCell(0, 2);
            boolean revDiaComplete = firstCharacter!= null;
            for (int i = 1; i < 3; i++) {
                if (firstCharacter != null && !firstCharacter.equals(board1.getCell(i, 2-i))){
                    revDiaComplete = false;
                    break;
                }
            }
            if (revDiaComplete) {
                return new GameResult(true, firstCharacter);
            }

            int countOfFilledCells = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board1.getCell(i, j) != null) {
                        countOfFilledCells++;
                    }
                }
            }

            if (countOfFilledCells == 9) {

                return new GameResult(true, "-");
            } else {
                return new GameResult(false, "-");
            }
        } else {
            throw new IllegalArgumentException("Unsupported board type for isComplete");
        }
    }


    public Move suggestMove(Player computer, Board board) {
        
        if (board instanceof TicTacToeBoard) {
            TicTacToeBoard board1 = (TicTacToeBoard) board;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board1.getCell(i, j) == "" || board1.getCell(i, j) == null) {
                        return new Move(new Cell(i, j));
                    }
                }
            }
            throw new IllegalStateException();
        } else {
            throw new IllegalArgumentException();
        }
    }

}



