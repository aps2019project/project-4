package model;

import java.util.Random;

public class GameBoard {
    private Cell[][] cells = new Cell[5][9];

    public Cell getCell(int x, int y) {
        if (x < 5 && y < 9 && x > 0 && y > 0)
            return cells[x][y];
        return null;
    }

    public Cell withFlagCell() {
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 9; j++)
                if (cells[i][j].getIsFlag())
                    return cells[i][j];
        return null;
    }

    public void initializeGameBoard() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 9; j++) {
                cells[i][j].setX(i);
                cells[i][j].setY(j);
            }
        }
    }

    public Cell getRandomCellAround(Cell cell) {
        Random random = new Random();
        int dx = random.nextInt(3) - 1;
        int dy = random.nextInt(3) - 1;
        if (checkIfMinionExitsAround(cell)) {
            while ((dx == 0 && dy == 0) || (cell.getX() + dx < 0 || cell.getX() + dx >= 9)
                    || (cell.getY() + dy < 0 || cell.getY() + dy >= 9)) {
                dx = random.nextInt(3) - 1;
                dy = random.nextInt(3) - 1;
            }
            return cells[cell.getX() + dx][cell.getY() + dy];
        }
        return null;
    }

    public boolean checkIfMinionExitsAround(Cell cell) {
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
        for (int i = 0; i < dx.length; i++) {
            if (cell.getX() + dx[i] >= 0 && cell.getX() + dx[i] < 9 &&
                    cell.getY() + dy[i] >= 0 && cell.getY() + dy[i] < 9 &&
                    cells[cell.getX() + dx[i]][cell.getY() + dy[i]].getMinion() != null)
                return true;
        }
        return false;
    }
}

