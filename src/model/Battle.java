package model;

import controller.Controller;
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
    private int numberOfTurns = 0;

    public Player getWhoseTurn() {
        return whoseTurn;
    }

    public Battle(Player player1) {
        this.player1 = player1;
        this.whoseTurn = player1;
        this.gameBoard = new GameBoard();
        Account.getCurrentAccount().setCurrentBattle(this);
        Account.getCurrentAccount().getCurrentBattle().getGameBoard().getCell(2 , 0).setMinion(player1.getDeck().getHero());
        player1.getDeck().getHero().setCellPlace(Account.getCurrentAccount().getCurrentBattle().getGameBoard().getCell(2 , 0));
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
        this.whoseNext = player2;
        Account.getCurrentAccount().getCurrentBattle().getGameBoard().getCell(2 , 8).setMinion(player2.getDeck().getHero());
        player2.getDeck().getHero().setCellPlace(Account.getCurrentAccount().getCurrentBattle().getGameBoard().getCell(2 , 8));
    }

    public Player getPlayer1() {
        return player1;
    }

    public GameBoard getGameBoard() {
        return gameBoard;
    }

    public Player getPlayer2() {
        return player2;
    }

    public Player getWhoseNext() {
        return whoseNext;
    }

    public Player getWinner() {
        return winner;
    }

    public Player getLoser() {
        if (this.getWinner() == this.getPlayer1())
            return this.getPlayer2();
        return this.getPlayer1();
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public void setGameMode(Enums.GameMode gameMode) {
        this.gameMode = gameMode;
    }

    public void setNumOfAllFlags(int numOfAllFlags) {
        this.numOfAllFlags = numOfAllFlags;
        this.getGameBoard().distributingFlags(numOfAllFlags);
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
        if (gameMode == Enums.GameMode.HERO_VS_HERO) {
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
                            append(cell.getY()).append(" has flag\n");
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
                        stringBuilder.append("cell with coordinates ").append(i).append(" ").append(j).append(" has flag\n");
                }
            }
        }
        return stringBuilder;
    }

    public StringBuilder myMinionsInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Card card : whoseTurn.getCardsInGameBoard().getCards().values()) {
            if (!(card instanceof Spell)) {
                Minion m = (Minion) card;
                stringBuilder.append(card.getId() + ": ").append(card.getName() + ", health: ").append(m.getHealthPoint());
                stringBuilder.append(", location: (").
                        append(m.getCellPlace().getX()).
                        append(", ").
                        append(m.getCellPlace().getY()).append("), ");
                stringBuilder.append("power: ").append(m.getAttackPoint()).append("\n");
            }
        }
        return stringBuilder;
    }

    public StringBuilder opponentMinionsInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Card card : whoseNext.getCardsInGameBoard().getCards().values()) {
            if (!(card instanceof Spell)) {
                Minion m = (Minion) card;
                stringBuilder.append(card.getId() + ": ").append(card.getName() + ", health: ").append(m.getHealthPoint());
                stringBuilder.append(", location : (").
                        append(m.getCellPlace().getX()).append(", ").
                        append(m.getCellPlace().getY()).append("), ");
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

    public void attack(String cardId, int x, int y) {
        Cell cell = gameBoard.getCell(x, y);
        Card card = whoseTurn.getCardsInGameBoard().getCards().get(cardId);
        if (card instanceof Minion) {
            Minion minion = (Minion) card;
            minion.attack(cell.getMinion());
            moveDeadsToGraveyard();
            if (cell.getMinion().getSpecialPowerActivationType() == Enums.ActivationTypes.ON_DEFEND)
                insertSpell(cell.getMinion().getSpecialPower(), minion.getCellPlace().getX(), minion.getCellPlace().getX());
            moveDeadsToGraveyard();
            if (minion.getSpecialPowerActivationType() == Enums.ActivationTypes.ON_SPAWN)
                insertSpell(minion.getSpecialPower(), x, y);
            moveDeadsToGraveyard();
        }
    }

    public void insert(String cardId, int x, int y) {
        Card card = whoseTurn.getHand().getCard(cardId);
        if (card == null && whoseTurn.getDeck().getHero().getId() != cardId && whoseNext.getDeck().getHero().getId() != cardId) {
            View.showCardNotInHandMessage();
            return;
        }

        if (card instanceof Spell) {
            insertSpell((Spell) card, x, y);
        }
        if (card instanceof Minion) {
            Minion minion = (Minion) card;
            Cell cell = gameBoard.getCell(x, y);
            cell.setMinion(minion);
            minion.setCellPlace(cell);
            if (minion.getSpecialPowerActivationType() == Enums.ActivationTypes.ON_SPAWN) {
                insertSpell(minion.getSpecialPower(), x, y);
            }
            whoseTurn.getHand().removeCard(card);
            whoseTurn.getHand().moveNextCardToHand(whoseTurn.getMutableDeck());
            whoseTurn.getHand().changeNextCard(whoseTurn.getMutableDeck());
            whoseTurn.getCardsInGameBoard().addCard(card);
        }
        if (whoseTurn == player1)
            View.showGameBoardInfo(this.gameBoard, 1);
        else
            View.showGameBoardInfo(this.gameBoard, 2);
    }

    public void insertSpell(Spell spell, int x, int y) {
        Cell cell = gameBoard.getCell(x, y);
        if (spell.getCellOrSoldier() == Enums.OnCellOrSoldier.CEll) {
            if (spell.getCellsType() == Enums.WhichCellsType.SQUARE) {
                for (Buff buff : spell.getBuffs()) {
                    gameBoard.putBuffInSquare(buff, x, y, spell.getLengthOfSideOfSquare());
                }//todo random
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
                            if (spell.getBuffNutralizer() == Enums.BuffNutralizer.BOTH) {
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
                    for (Cell cell1 : targets) {
                        if (whoseNext.getDeck().getHero() == cell1.getMinion()) {
                            if (spell.getBuffNutralizer() == Enums.BuffNutralizer.POSITIVE ||
                                    spell.getBuffNutralizer() == Enums.BuffNutralizer.BOTH)
                                cell1.getMinion().removeAllPositiveBuffs();
                            for (Buff buff : spell.getBuffs()) {
                                buff.stickBuffTo(cell1);
                                return;
                            }
                        }
                    }
                case FRIEND_HERO:
                    for (Cell cell1 : targets) {
                        if (whoseTurn.getDeck().getHero() == cell1.getMinion()) {
                            if (spell.getBuffNutralizer() == Enums.BuffNutralizer.NEGATIVE ||
                                    spell.getBuffNutralizer() == Enums.BuffNutralizer.BOTH)
                                cell1.getMinion().removeAllNegativeBuffs();
                            for (Buff buff : spell.getBuffs()) {
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

    //    public void insertSpellRandomly(Spell spell, int x, int y){
//        ArrayList<Cell> targets = gameBoard.cellTargets(spell.getCellsType(), x, y, spell.getLengthOfSideOfSquare());
//        if (spell.getCellsType() == Enums.WhichCellsType.RANDOM_MINION_OF_ALL){
//            if (!isEmpty(targets)){
//                Cell cell = getRandomCell(targets);
//
//            }
//        }
//    }
    public void moveTo(int x, int y) throws Exception {
        if (whoseTurn.getSelectedCard() instanceof Spell)
            throw new SpellsCanNotMoveException();
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

    public boolean isGameEnded() {
        switch (this.getGameMode()) {
            case MULTIPLE_FLAG:
                return this.isEndedMultipleFlagGame();
            case MONO_FLAG:
                return this.isEndedMonoFlagGame();
            case HERO_VS_HERO:
                return this.isEndedHeroVsHeroGame();
        }
        return false;
    }

    public void endBattle() {
        Account.getCurrentAccount().setCurrentBattle(null);
        Controller.enterEndBattleMenu(this);
        Account.getAccounts().get(this.getWinner().getName()).changeDrack(this.getReward());
    }

    public boolean isEndedMultipleFlagGame() {
        if (this.getPlayer1().getNumOfFlags() >= (this.getNumOfAllFlags() / 2)) {
            this.setWinner(player1);
            return true;
        }
        if (this.getPlayer2().getNumOfFlags() >= (this.getNumOfAllFlags() / 2)) {
            this.setWinner(player2);
            return true;
        }
        return false;
    }

    public boolean isEndedMonoFlagGame() {
        if (this.getPlayer1().getNumOfTurnsHeldFlag() == 6) {
            this.setWinner(player1);
            return true;
        }
        if (this.getPlayer2().getNumOfTurnsHeldFlag() == 6) {
            this.setWinner(player2);
            return true;
        }
        return false;
    }

    public boolean isEndedHeroVsHeroGame() {
        if (!this.getPlayer1().getCardsInGameBoard().isHaveHero() && this.getPlayer2().getMutableDeck().isHaveHero()) {
            this.setWinner(player2);
            return true;
        }
        if (this.getPlayer1().getCardsInGameBoard().isHaveHero() && !this.getPlayer2().getMutableDeck().isHaveHero()) {
            this.setWinner(player1);
            return true;
        }
        return false;
    }

    public void moveDeadsToGraveyard() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 9; j++) {
                Cell cell = gameBoard.getCell(i, j);
                Minion minion = cell.getMinion();
                if (minion.isDead()) {
                    if (minion.getSpecialPowerActivationType() == Enums.ActivationTypes.ON_DEATH)
                        insertSpell(minion.getSpecialPower(), cell.getX(), cell.getY());
                    cell.setMinion(null);
                    minion.setCellPlace(null);
                    if (minion.isHasFlag())
                        minion.dropFlag();
                    if (player1.getDeck().getCards().values().contains(minion))
                        player1.getGraveYard().put(minion.getId(), minion);
                    if (player1.getDeck().getCards().values().contains(minion))
                        player1.getGraveYard().put(minion.getId(), minion);
                }
            }
        }
    }

    public void nextTurn() {
        for (int i = 0; i < 5; i++){
            for (int j = 0; j < 9 ; j++){
                for (Buff buff : gameBoard.getCell(i, j).getBuffs()){

                }
            }
        }
    }

}