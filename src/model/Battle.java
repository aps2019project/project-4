package model;

import model.buff.Buff;
import views.Exceptions.*;
import views.View;

import java.util.ArrayList;
import java.util.Random;

public class Battle {
    private Player player1;
    private Player player2;
    private Player whoseTurn;
    private Player whoseNext;
    private Player winner;
    private int seconds;
    private GameBoard gameBoard;
    private Enums.GameMode gameMode;
    private Enums.SingleOrMulti opponent;
    private int numOfAllFlags;
    private int reward;

    public Player getWhoseTurn() {
        return whoseTurn;
    }

    public Battle(Player player1) {
        this.player1 = player1;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setGameMode(Enums.GameMode gameMode) {
        this.gameMode = gameMode;
    }

    public void setNumOfAllFlags(int numOfAllFlags) {
        this.numOfAllFlags = numOfAllFlags;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }

    public void setOpponent(Enums.SingleOrMulti opponent) {
        this.opponent = opponent;
    }

    public Enums.GameMode getGameMode() {
        return gameMode;
    }

    public Enums.SingleOrMulti getOpponent() {
        return opponent;
    }

    public int getNumOfAllFlags() {
        return numOfAllFlags;
    }

    public int getReward() {
        return reward;
    }

    public StringBuilder gameInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        if (opponent == Enums.SingleOrMulti.MULTI_PLAYER) {
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

    public StringBuilder myMinionsInfo() {
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

    public StringBuilder opponentMinionsInfo() {
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

    public void insert(String cardId, int x, int y) {

    }

    public void insertSpell(Spell spell, int x, int y) {
        Cell cell = gameBoard.getCell(x, y);
        if (spell.getCellOrSoldier() == Enums.OnCellOrSoldier.CEll) {
            if (spell.getCellsType() == Enums.WhichCellsType.SQUARE) {
                for (Buff buff : spell.getBuffs()) {
                    gameBoard.putBuffInSquare(buff, x, y, spell.getLengthOfSideOfSquare());
                }
            }
        } else {
            ArrayList<Cell> targets = gameBoard.cellTargets(spell.getCellsType(), x, y, spell.getLengthOfSideOfSquare());
            switch (spell.getTarget()) {
                case ENEMY:
                    for (Cell cell1 : targets) {
                        if (whoseNext.getDeck().getCards().containsValue(cell1.getMinion())) {
                            if (spell.getBuffNutralizer() == Enums.BuffNutralizer.POSITIVE ||
                                    spell.getBuffNutralizer() == Enums.BuffNutralizer.BOTH)
                                cell1.getMinion().removeAllPositiveBuffs();
                            for (Buff buff : spell.getBuffs()) {
                                buff.stickBuffTo(cell1);
                            }
                        }
                    }
                    return;
                case Friend:
                    for (Cell cell1 : targets) {
                        if (whoseTurn.getDeck().getCards().containsValue(cell1.getMinion())) {
                            if (spell.getBuffNutralizer() == Enums.BuffNutralizer.NEGATIVE ||
                                    spell.getBuffNutralizer() == Enums.BuffNutralizer.BOTH)
                                cell1.getMinion().removeAllNegativeBuffs();
                            for (Buff buff : spell.getBuffs()) {
                                buff.stickBuffTo(cell1);
                            }
                        }
                    }
                    return;
                case BOTH:
                    for (Cell cell1 : targets) {
                        if (cell1.getMinion() != null) {
                            if (spell.getBuffNutralizer() == Enums.BuffNutralizer.BOTH){
                                if (whoseTurn.getDeck().getCards().containsValue(cell1.getMinion()))
                                    cell1.getMinion().removeAllNegativeBuffs();
                                if (whoseNext.getDeck().getCards().containsValue(cell1.getMinion()))
                                    cell1.getMinion().removeAllPositiveBuffs();
                            }
                            for (Buff buff : spell.getBuffs()) {
                                buff.stickBuffTo(cell1);
                            }
                        }
                    }
                    return;
                case ENEMY_HERO:
                    for (Cell cell1 : targets){
                        if (whoseNext.getDeck().getHero() == cell1.getMinion()){
                            if (spell.getBuffNutralizer() == Enums.BuffNutralizer.POSITIVE ||
                                    spell.getBuffNutralizer() == Enums.BuffNutralizer.BOTH)
                                cell1.getMinion().removeAllPositiveBuffs();
                            for (Buff buff : spell.getBuffs()){
                                buff.stickBuffTo(cell1);
                                return;
                            }
                        }
                    }
                case FRIEND_HERO:
                    for (Cell cell1 : targets){
                        if (whoseTurn.getDeck().getHero() == cell1.getMinion()){
                            if (spell.getBuffNutralizer() == Enums.BuffNutralizer.NEGATIVE ||
                                    spell.getBuffNutralizer() == Enums.BuffNutralizer.BOTH)
                                cell1.getMinion().removeAllNegativeBuffs();
                            for (Buff buff : spell.getBuffs()){
                                buff.stickBuffTo(cell1);
                                return;
                            }
                        }
                    }
                    return;
                case ENEMY_MINION:
                    for (Cell cell1 : targets) {
                        if (whoseNext.getDeck().getCards().containsValue(cell1.getMinion()) &&
                                whoseNext.getDeck().getHero() != cell1.getMinion()) {
                            if (spell.getBuffNutralizer() == Enums.BuffNutralizer.POSITIVE ||
                                    spell.getBuffNutralizer() == Enums.BuffNutralizer.BOTH)
                                cell1.getMinion().removeAllPositiveBuffs();
                            for (Buff buff : spell.getBuffs()) {
                                buff.stickBuffTo(cell1);
                            }
                        }
                    }
                    return;
                case FRIEND_MINION:
                    for (Cell cell1 : targets) {
                        if (whoseTurn.getDeck().getCards().containsValue(cell1.getMinion()) &&
                                whoseTurn.getDeck().getHero() != cell1.getMinion()) {
                            if (spell.getBuffNutralizer() == Enums.BuffNutralizer.NEGATIVE ||
                                    spell.getBuffNutralizer() == Enums.BuffNutralizer.BOTH)
                                cell1.getMinion().removeAllNegativeBuffs();
                            for (Buff buff : spell.getBuffs()) {
                                buff.stickBuffTo(cell1);
                            }
                        }
                    }
                    return;
            }
        }
    }

    public void moveTo(int x, int y) throws Exception {
        if (whoseTurn.getSelectedCard() instanceof Spell) {
            throw new SpellsCanNotMoveException();
        }
        Minion minion = ((Minion) whoseTurn.getSelectedCard());
        Cell cell = minion.getCellPlace();
        if (!isMinionsBetween(cell, x, y)) {
            minion.moveTo(gameBoard.getCell(x, y));
        } else {
            View.showMinionsBetweenMessage();
        }
    }

    public boolean isEmpty(ArrayList<Cell> cells) {
        for (Cell cell : cells) {
            if (cell.getMinion() != null)
                return false;
        }
        return true;
    }

    public Cell getRandomCell(ArrayList<Cell> cells) {
        int size = cells.size();
        Random random = new Random();
        int rand = random.nextInt(size);
        while (cells.get(rand).getMinion() == null)
            rand = random.nextInt(size);
        return cells.get(rand);
    }
}