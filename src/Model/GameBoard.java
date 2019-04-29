package Model;

public class GameBoard {
    private Cell[][] cells = new Cell[5][9];

    public Cell getCell(int x, int y){
        if (x < 5 && y < 9 && x > 0 && y > 0)
            return cells[x][y];
        return null;
    }
}
