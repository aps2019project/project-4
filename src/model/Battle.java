package model;

import views.View;

public class Battle {
    private Player player1;
    private Player player2;
    private Player whoseTurn;
    private Player whoseNext;
    private Player winner;
    private int seconds;
    private GameBoard gameBoard;
    private Enums.GameMode gameMode;
    private int numOfFlags;
    private int numOfAllFlags;

    public Player getWhoseTurn() {
        return whoseTurn;
    }

    public Battle(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public StringBuilder gameInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        if (gameMode == Enums.GameMode.MULTI_PLAYER) {
            stringBuilder.append("player 1's hero health: ").append(player1.getDeck().getHero().getHealthPoint()).append("\n");
            stringBuilder.append("player 2's hero health: ").append(player2.getDeck().getHero().getHealthPoint()).append("\n");
        }
        if (gameMode == Enums.GameMode.MONO_FLAG) {
            Minion m1 = player1.getDeck().whoHasFlag();
            try {
                stringBuilder.append("minion: ").append(m1.getName()).append(" of player1 in cell ").
                        append(m1.getCellPlace().getX()).append(" and ").append(m1.getCellPlace().getY()).
                        append("has flag\n");
            } catch (Exception e) {
            }
            Minion m2 = player2.getDeck().whoHasFlag();
            try {
                stringBuilder.append("minion: ").append(m2.getName()).append(" of player2 in cell ").
                        append(m2.getCellPlace().getX()).append(" and ").append(m2.getCellPlace().getY()).
                        append("has flag\n");
            } catch (Exception e) {
            }
            if (m1 == null && m2 == null) {
                Cell cell = gameBoard.withFlagCell();
                try {
                    stringBuilder.append("cell with ").append(cell.getX()).append(" and ").
                            append(cell.getY()).append(" has flag");
                } catch (Exception e) {
                }
            }
        }
        if (gameMode == Enums.GameMode.MULTIPLE_FLAG) {
            for (Card card : player1.getDeck().getCards().values()) {
                if (card instanceof Minion && ((Minion) card).isHasFlag()) {
                    stringBuilder.append("card of player1 with name ").append(card.getName()).append(" in ")
                            .append(((Minion) card).getCellPlace().getX()).append(" ")
                            .append(((Minion) card).getCellPlace().getY()).append("\n");
                }
            }
            for (Card card : player2.getDeck().getCards().values()) {
                if (card instanceof Minion && ((Minion) card).isHasFlag()) {
                    stringBuilder.append("card of player2 with name ").append(card.getName()).append(" in ")
                            .append(((Minion) card).getCellPlace().getX()).append(" ")
                            .append(((Minion) card).getCellPlace().getY()).append("\n");
                }
            }
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 9; j++) {
                    if (gameBoard.getCell(i, j).getIsFlag())
                        stringBuilder.append("cell with coordinates ").append(i).append(" ").append(j).append(" has flag");
                }
            }
        }
        return stringBuilder;
    }

    public StringBuilder showMyMinions() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Card card : whoseTurn.getDeck().getCards().values()) {
            if (!(card instanceof Spell)) {
                Minion m = (Minion) card;
                stringBuilder.append(card.getId() + ": ").append(card.getName() + ", health: ").append(m.getHealthPoint());
                stringBuilder.append(", location: (").append(m.getCellPlace().getX()).append(", ").append(m.getCellPlace().getY()).append("), ");
                stringBuilder.append("power: ").append(m.getAttackPoint()).append("\n");
            }
        }
        return stringBuilder;
    }
    public StringBuilder showOpponentMinions() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Card card : whoseNext.getDeck().getCards().values()) {
            if (!(card instanceof Spell)) {
                Minion m = (Minion) card;
                stringBuilder.append(card.getId() + ": ").append(card.getName() + ", health: ").append(m.getHealthPoint());
                stringBuilder.append(", location : (").append(m.getCellPlace().getX()).append(", ").append(m.getCellPlace().getY()).append("), ");
                stringBuilder.append("power: ").append(m.getAttackPoint()).append("\n");
            }
        }
        return stringBuilder;
    }

    public boolean isMinionsBetween(Cell cell, int x, int y) {
        if (cell.getX() == x) {
            if (cell.getY() > y) {
                for (int i = y; i < cell.getY(); i++) {
                    if (this.gameBoard.getCell(x, i).getMinion() != null) {
                        View.showInvalidTargetMessage();
                        return true;
                    }
                }
            }
            if (cell.getY() < y) {
                for (int i = y; i > cell.getY(); i--) {
                    if (this.gameBoard.getCell(x, i).getMinion() != null) {
                        View.showInvalidTargetMessage();
                        return true;
                    }
                }
            }
        }
        if (cell.getY() == y) {
            if (cell.getX() > x) {
                for (int i = x; i < cell.getX(); i++) {
                    if (this.gameBoard.getCell(i, y).getMinion() != null) {
                        View.showInvalidTargetMessage();
                        return true;
                    }
                }
            }
            if (cell.getX() < x) {
                for (int i = x; i > cell.getX(); i--) {
                    if (this.gameBoard.getCell(i, y).getMinion() != null) {
                        View.showInvalidTargetMessage();
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
