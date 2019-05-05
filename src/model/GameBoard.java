package model;

public class GameBoard {
    private Cell[][] cells = new Cell[5][9];

    public Cell getCell(int x, int y){
        if (x < 5 && y < 9 && x > 0 && y > 0)
            return cells[x][y];
        return null;
    }
    public Cell withFlagCell(){
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 9; j++)
                if (cells[i][j].getIsFlag())
                    return cells[i][j];
        return null;
        }
    }
}
