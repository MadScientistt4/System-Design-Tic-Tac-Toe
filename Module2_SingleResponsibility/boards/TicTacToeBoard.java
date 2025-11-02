package boards;
import game.Board;
import game.Cell;

public class TicTacToeBoard extends Board {
    String[][] cells = new String[3][3];

    public String getCell(int row, int col) {
        return cells[row][col];
    }

    public void setCell(String symbol, Cell cell) {
        cells[cell.getRow()][cell.getCol()] = symbol;
    }
    
    @Override
    public String toString() {
        String res = "";
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (cells[i][j] == null) {
                    res += "- ";
                    continue;
                }
                res += cells[i][j] + " ";
            }
            res += "\n";
        }
        return res;
    }
}
