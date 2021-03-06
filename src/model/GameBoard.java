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

    public StringBuilder gameBoardInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 9; j++) {
                if (cells[i][j].getMinion() == null && !cells[i][j].getIsFlag()) {
                    stringBuilder.append("__ ");
                    continue;
                }
                if (cells[i][j].getMinion() == null && cells[i][j].getIsFlag()) {
                    stringBuilder.append("f_ ");
                    continue;
                }
                if (cells[i][j].getMinion() instanceof Hero
                        && Account.getCurrentAccount().getCurrentBattle().getPlayer1().getDeck().getHero() == cells[i][j].getMinion()) {
                    stringBuilder.append("H").append(1);
                    if (cells[i][j].getIsFlag()) {
                        stringBuilder.append("f");
                    } else {
                        stringBuilder.append("_");
                    }
                    continue;
                }
                if (cells[i][j].getMinion() instanceof Hero
                        && Account.getCurrentAccount().getCurrentBattle().getPlayer2().getDeck().getHero() == cells[i][j].getMinion()) {
                    stringBuilder.append("H").append(2);
                    if (cells[i][j].getIsFlag()) {
                        stringBuilder.append("f");
                    } else {
                        stringBuilder.append(" ");
                    }
                    continue;
                }
                if (cells[i][j].getMinion() != null
                        && Account.getCurrentAccount().getCurrentBattle().getPlayer1().getDeck().getCards().get(cells[i][j].getMinion().getId()) != null)
                    stringBuilder.append("M").append(1);
                if (cells[i][j].getMinion() != null
                        && Account.getCurrentAccount().getCurrentBattle().getPlayer2().getDeck().getCards().get(cells[i][j].getMinion().getId()) != null)
                    stringBuilder.append("M").append(2);
                if (cells[i][j].getIsFlag()) {
                    stringBuilder.append("f");
                } else {
                    stringBuilder.append(" ");
                }
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

    public void distributingFlags(int numOfFlags) {
        Random random = new Random();
        int n = numOfFlags;
        boolean checked28 = false;
        boolean checked20 = false;
        while (n > 0) {
            int x = random.nextInt(5);
            int y = random.nextInt(9);
            if (x == 2 & y == 0 & !checked20) {
                Account.getCurrentAccount().getCurrentBattle().getPlayer1().getCardsInGameBoard().getHero().catchFlag();
                n--;
                checked20 = true;
                continue;
            }
            if (x == 2 & y == 8 & !checked28) {
                Account.getCurrentAccount().getCurrentBattle().getPlayer1().getCardsInGameBoard().getHero().catchFlag();
                n--;
                checked28 = true;
                continue;
            }
            if (!this.getCell(x, y).getIsFlag()) {
                this.getCell(x, y).setFlag(true);
                n--;
            }
        }
    }

    public void setOneFlag() {
        Random random = new Random();
        int y = 3 + random.nextInt(5);
        int x = 2 + random.nextInt(2);
        this.getCell(x, y).setFlag(true);
    }

}

