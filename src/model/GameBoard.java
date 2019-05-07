package model;

import model.buff.Buff;

import java.util.ArrayList;
import java.util.Random;

public class GameBoard {
    private Cell[][] cells;


    public GameBoard() {
        cells = new Cell[5][9];
        initializeGameBoard();
    }

    public Cell getCell(int x, int y) {
        if (x < 5 && y < 9 && x >= 0 && y >= 0)
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
                cells[i][j] = new Cell(i, j);
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

    public StringBuilder gameBoardInfo(int a) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 9; j++) {
                if (cells[i][j].getMinion() == null){
                    stringBuilder.append("__ ");
                }
                else if (cells[i][j].getMinion() instanceof Hero)
                    stringBuilder.append("H").append(a).append(" ");
                else if (cells[i][j].getMinion() != null)
                    stringBuilder.append("M ").append(a).append(" ");
            }
            stringBuilder.append("\n");
        }
        return stringBuilder;
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

    public void putBuffInSquare(Buff buff, int x, int y, int length) {
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                try {
                    this.getCell(x + i, y - j).addBuff(buff);
                } catch (Exception e) {
                }
            }
        }
    }

    public ArrayList<Cell> cellTargets(Enums.WhichCellsType cellsType, int x, int y, int length) {
        ArrayList<Cell> targets = new ArrayList<>();
        switch (cellsType) {
            case MONO_CELL:
                try {
                    targets.add(cells[x][y]);
                } catch (Exception e) {
                }
                return targets;
            case SQUARE:
                for (int i = 0; i < length; i++) {
                    for (int j = 0; j < length; j++) {
                        try {
                            targets.add(cells[x + i][y - j]);
                        } catch (Exception e) {
                        }
                    }
                }
                return targets;
            case COLUMN:
                for (int i = 0; i < 5; i++)
                    targets.add(cells[i][y]);
                return targets;
            case ROW:
                for (int j = 0; j < 0; j++)
                    targets.add(cells[x][j]);
                return targets;
            case ALL:
            case RANDOM_MINION_OF_ALL:
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 9; j++) {
                        targets.add(cells[i][j]);
                    }
                }
                return targets;
            case ALL_MINIONS_AROUND:
            case RANDOM_MINION_AROUND_HERO:
            case RANDOM_MINION_AROUND:
                int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
                int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
                for (int i = 0; i < dx.length; i++) {
                    if (x + dx[i] >= 0 && x + dx[i] < 9 && y + dy[i] >= 0 && y + dy[i] < 9)
                        targets.add(cells[x + dx[i]][y + dy[i]]);
                }
                return targets;
            case ALL_MINIONS_AROUND_DISTANCE_2:
                targets = cellTargets(Enums.WhichCellsType.ALL_MINIONS_AROUND, x, y, 0);
                int[] dx2 = {-2, 0, 0, 2};
                int[] dy2 = {0, -2, 2, 0};
                for (int i = 0; i < dx2.length; i++) {
                    if (x + dx2[i] < 9 && x + dx2[i] >= 0 && y + dy2[i] >= 0 && y + dy2[i] < 9)
                        targets.add(cells[x + dx2[i]][y + dy2[i]]);
                }
                return targets;
            case ALL_MINIONS_AROUND_AND_ITSELF:
                targets = cellTargets(Enums.WhichCellsType.ALL_MINIONS_AROUND, x, y, 0);
                targets.add(cells[x][y]);
                return targets;
        }
        return null;
    }

}

