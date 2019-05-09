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
        Account.getCurrentAccount().getCurrentBattle().getGameBoard().getCell(2, 0).setMinion(player1.getDeck().getHero());
        Account.getCurrentAccount().getCurrentBattle().getPlayer1().getMutableDeck().removeCard(player1.getDeck().getHero().getId());
        Account.getCurrentAccount().getCurrentBattle().getPlayer1().getCardsInGameBoard().addCard(player1.getDeck().getHero());
        player1.getDeck().getHero().setCellPlace(Account.getCurrentAccount().getCurrentBattle().getGameBoard().getCell(2, 0));
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
        this.whoseNext = player2;
        Account.getCurrentAccount().getCurrentBattle().getGameBoard().getCell(2, 8).setMinion(player2.getDeck().getHero());
        Account.getCurrentAccount().getCurrentBattle().getPlayer2().getMutableDeck().removeCard(player2.getDeck().getHero().getId());
        Account.getCurrentAccount().getCurrentBattle().getPlayer2().getCardsInGameBoard().addCard(player2.getDeck().getHero());
        player2.getDeck().getHero().setCellPlace(Account.getCurrentAccount().getCurrentBattle().getGameBoard().getCell(2, 8));
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
            Minion m1 = player1.getCardsInGameBoard().whoHasFlag();
            if (m1 != null)
                stringBuilder.append("Minion ").append(m1.getId()).append(" of player1 in cell ").
                        append(m1.getCellPlace().getX()).append(", ").append(m1.getCellPlace().getY()).
                        append(" has flag\n");

            Minion m2 = player2.getCardsInGameBoard().whoHasFlag();
            if (m2 != null)
                stringBuilder.append("Minion ").append(m2.getId()).append(" of player2 in cell ").
                        append(m2.getCellPlace().getX()).append(", ").append(m2.getCellPlace().getY()).
                        append(" has flag\n");
            if (m1 == null && m2 == null) {
                Cell cell = gameBoard.withFlagCell();
                stringBuilder.append("Cell with ").append(cell.getX()).append(" and ").
                        append(cell.getY()).append(" has flag and no one get it!\n");
            }
        }
        if (gameMode == Enums.GameMode.MULTIPLE_FLAG) {
            for (Card card : player1.getCardsInGameBoard().getCards().values()) {
                if (card instanceof Minion && ((Minion) card).isHasFlag()) {
                    stringBuilder.append("Card of player1 with id ").append(card.getId()).append(" in ")
                            .append(((Minion) card).getCellPlace().getX()).append(" ")
                            .append(((Minion) card).getCellPlace().getY()).append("\n");
                }
            }
            for (Card card : player2.getCardsInGameBoard().getCards().values()) {
                if (card instanceof Minion && ((Minion) card).isHasFlag()) {
                    stringBuilder.append("card of player2 with id ").append(card.getId()).append(" in ")
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
                stringBuilder.append("power: ").append(m.getAttackPoint() + m.moreAttackPoints() + m.lessAttackPoints()).append("\n");
            }
        }
        return stringBuilder;
    }

    public ArrayList<Minion> getMinions() {
        ArrayList<Minion> minions = new ArrayList<>();
        for (Card card : this.getWhoseTurn().getCardsInGameBoard().getCards().values()) {
            if (card instanceof Minion)
                minions.add((Minion) card);
        }
        return minions;
    }

    public ArrayList<Minion> getOppMinions() {
        ArrayList<Minion> minions = new ArrayList<>();
        for (Card card : this.getWhoseNext().getCardsInGameBoard().getCards().values()) {
            if (card instanceof Minion)
                minions.add((Minion) card);
        }
        return minions;
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

    public void select(String cardId) {
        Card card = whoseTurn.getCardsInGameBoard().getCards().get(cardId);
        //if (card != null)
            //whoseTurn.setSelectedCard();
        //else
    }

    public void attack(int x, int y) {
        Cell cell = gameBoard.getCell(x, y);
        Card card = whoseTurn.getSelectedCard();
        if (card == null) {
            View.showCardHasNotSelected();
            return;
        }
        if (card instanceof Minion) {
            Minion minion = (Minion) card;
            if (whoseNext.getDeck().getCards().containsKey(cell.getMinion().getId())) {
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
    }


    public void insert(String cardId, int x, int y) throws Exception {
        if (!((x < 5 && y < 9 && x >= 0 && y >= 0)))
            throw new InvalidCellException();
        Card card = whoseTurn.getHand().getCard(cardId);
        if (card == null && whoseTurn.getDeck().getHero().getId() != cardId && whoseNext.getDeck().getHero().getId() != cardId) {
            View.showCardNotInHandMessage();
            return;
        }

        if (card instanceof Spell) {
            if (whoseTurn.getMana() >= card.getRequiredManas()) {
                if (insertSpell((Spell) card, x, y)) {
                    insertNewCardInHand(card);
                    whoseTurn.changeMana( -card.getRequiredManas());
                }
            }
            else
                View.showNotEnoughManasMessage();
        } else if (card instanceof Minion) {
            if (whoseTurn.getMana() >= card.getRequiredManas()) {
                Minion minion = (Minion) card;
                Cell cell = gameBoard.getCell(x, y);
                if (!cell.isEmpty()) {
                    View.showCellIsCurrentlyFullMessage();
                    return;
                }
                cell.setMinion(minion);
                minion.setCellPlace(cell);
                whoseTurn.changeMana(-card.getRequiredManas());
                if (minion.getSpecialPowerActivationType() == Enums.ActivationTypes.ON_SPAWN) {
                    insertSpell(minion.getSpecialPower(), x, y);
                }
                insertNewCardInHand(card);
                if (cell.getIsFlag()) {
                    cell.setFlag(false);
                    minion.catchFlag();
                }
            }
            else
                View.showNotEnoughManasMessage();
        }
        boardInfo();
    }

    private void insertNewCardInHand(Card card) {
        whoseTurn.getHand().removeCard(card);
        whoseTurn.getHand().moveNextCardToHand(whoseTurn.getMutableDeck());
        whoseTurn.getHand().changeNextCard(whoseTurn.getMutableDeck());
        whoseTurn.getCardsInGameBoard().addCard(card);
    }


    public boolean insertSpell(Spell spell, int x, int y) {
        Cell cell = gameBoard.getCell(x, y);
        boolean result = false;
        if (spell.getCellOrSoldier() == Enums.OnCellOrSoldier.CEll) {
            if (spell.getCellsType() == Enums.WhichCellsType.SQUARE) {
                for (Buff buff : spell.getBuffs()) {
                    gameBoard.putBuffInSquare(buff, x, y, spell.getLengthOfSideOfSquare());
                    result = true;
                }//todo random
            }
        } else {
            ArrayList<Cell> targets = gameBoard.cellTargets(spell.getCellsType(), x, y, spell.getLengthOfSideOfSquare());
            switch (spell.getTarget()) {
                case ENEMY:
                    for (Cell cell1 : targets) {
                        if (whoseNext.getDeck().getCards().containsKey(cell1.getMinion().getId())) {
                            result = true;
                            if (spell.getBuffNutralizer() == Enums.BuffNutralizer.POSITIVE ||
                                    spell.getBuffNutralizer() == Enums.BuffNutralizer.BOTH)
                                cell1.getMinion().removeAllPositiveBuffs();
                            for (Buff buff : spell.getBuffs()) {
                                buff.stickBuffTo(cell1);
                                cell1.getMinion().applyBuff(buff);
                            }
                        }
                    }
                    break;
                case FRIEND:
                    for (Cell cell1 : targets) {
                        if (whoseTurn.getDeck().getCards().containsKey(cell1.getMinion().getId())) {
                            result = true;
                            if (spell.getBuffNutralizer() == Enums.BuffNutralizer.NEGATIVE ||
                                    spell.getBuffNutralizer() == Enums.BuffNutralizer.BOTH)
                                cell1.getMinion().removeAllNegativeBuffs();
                            for (Buff buff : spell.getBuffs()) {
                                buff.stickBuffTo(cell1);
                                cell1.getMinion().applyBuff(buff);
                            }
                        }
                    }
                    break;
                case BOTH:
                    for (Cell cell1 : targets) {
                        if (cell1.getMinion() != null) {
                            result = true;
                            if (spell.getBuffNutralizer() == Enums.BuffNutralizer.BOTH) {
                                if (whoseTurn.getDeck().getCards().containsKey(cell1.getMinion().getId()))
                                    cell1.getMinion().removeAllNegativeBuffs();
                                if (whoseNext.getDeck().getCards().containsKey(cell1.getMinion().getId()))
                                    cell1.getMinion().removeAllPositiveBuffs();
                            }
                            for (Buff buff : spell.getBuffs()) {
                                buff.stickBuffTo(cell1);
                                cell1.getMinion().applyBuff(buff);
                            }
                        }
                    }
                    break;
                case ENEMY_HERO:
                    for (Cell cell1 : targets) {
                        if (whoseNext.getDeck().getHero() == cell1.getMinion()) {
                            result = true;
                            if (spell.getBuffNutralizer() == Enums.BuffNutralizer.POSITIVE ||
                                    spell.getBuffNutralizer() == Enums.BuffNutralizer.BOTH)
                                cell1.getMinion().removeAllPositiveBuffs();
                            for (Buff buff : spell.getBuffs()) {
                                buff.stickBuffTo(cell1);
                                cell1.getMinion().applyBuff(buff);
                            }
                            break;
                        }
                    }
                    break;
                case FRIEND_HERO:
                    for (Cell cell1 : targets) {
                        if (whoseTurn.getDeck().getHero() == cell1.getMinion()) {
                            result = true;
                            if (spell.getBuffNutralizer() == Enums.BuffNutralizer.NEGATIVE ||
                                    spell.getBuffNutralizer() == Enums.BuffNutralizer.BOTH)
                                cell1.getMinion().removeAllNegativeBuffs();
                            for (Buff buff : spell.getBuffs()) {
                                buff.stickBuffTo(cell1);
                                cell1.getMinion().applyBuff(buff);
                            }
                            break;
                        }
                    }
                    break;
                case ENEMY_MINION:
                    for (Cell cell1 : targets) {
                        if (whoseNext.getDeck().getCards().containsKey(cell1.getMinion().getId()) &&
                                whoseNext.getDeck().getHero() != cell1.getMinion()) {
                            result = true;
                            if (spell.getBuffNutralizer() == Enums.BuffNutralizer.POSITIVE ||
                                    spell.getBuffNutralizer() == Enums.BuffNutralizer.BOTH)
                                cell1.getMinion().removeAllPositiveBuffs();
                            for (Buff buff : spell.getBuffs()) {
                                buff.stickBuffTo(cell1);
                                cell1.getMinion().applyBuff(buff);
                            }
                        }
                    }
                    break;
                case FRIEND_MINION:
                    for (Cell cell1 : targets) {
                        if (whoseTurn.getDeck().getCards().containsKey(cell1.getMinion().getId()) &&
                                whoseTurn.getDeck().getHero() != cell1.getMinion()) {
                            result = true;
                            if (spell.getBuffNutralizer() == Enums.BuffNutralizer.NEGATIVE ||
                                    spell.getBuffNutralizer() == Enums.BuffNutralizer.BOTH)
                                cell1.getMinion().removeAllNegativeBuffs();
                            for (Buff buff : spell.getBuffs()) {
                                buff.stickBuffTo(cell1);
                                cell1.getMinion().applyBuff(buff);
                            }
                        }
                    }
                    break;
            }
        }
        if (result) {
            moveDeadsToGraveyard();
        }
        return result;
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
        if (!isMinionsBetween(cell, x, y) && !(this.getWhoseTurn() instanceof AIPlayer)) {
            minion.moveTo(gameBoard.getCell(x, y));
        } else if (!isMinionsBetween(cell, x, y) && (this.getWhoseTurn() instanceof AIPlayer)) {
            minion.moveToNoMessageShow(gameBoard.getCell(x, y));
        } else {
            if (!(this.getWhoseTurn() instanceof AIPlayer))
                View.showMinionsBetweenMessage();
        }
        boardInfo();
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
                    if (minion.isHasFlag())
                        minion.dropFlag();
                    cell.setMinion(null);
                    minion.setCellPlace(null);
                    if (player1.getCardsInGameBoard().getCards().values().contains(minion))
                        player1.getGraveYard().put(minion.getId(), minion);
                    if (player1.getCardsInGameBoard().getCards().values().contains(minion))
                        player1.getGraveYard().put(minion.getId(), minion);
                }
            }
        }
    }

    public void nextTurn() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 9; j++) {
                Cell cell = gameBoard.getCell(i, j);
                Minion minion = cell.getMinion();
                cell.removeExpiredBuffs();
                try {
                    minion.removeExpiredBuffs();
                    minion.unlockAttack();
                    minion.unlockMovement();
                } catch (NullPointerException e){ }
                cell.applyBuffs();
            }
        }
        unselectCards();
        swapWhoseTurn();
        numberOfTurns++;
        handleManas();
        //todo unlock attack and movement
        //todo select cards should be set to null
    }

    public void boardInfo() {
        if (whoseTurn == player1)
            View.showGameBoardInfo(this.gameBoard, 1);
        else
            View.showGameBoardInfo(this.gameBoard, 2);
    }

    public void swapWhoseTurn() {
        Player temp = whoseNext;
        whoseNext = whoseTurn;
        whoseTurn = temp;
    }

    public void unselectCards() {
        player1.setSelectedCard(null);
        player2.setSelectedCard(null);
    }

    public void handleManas() {
        if (numberOfTurns > 14) {
            player1.setMana(9);
            player2.setMana(9);
            return;
        }
        int numberOfManas = numberOfTurns / 2 + 2;
        player1.setMana(numberOfManas);
        player2.setMana(numberOfManas);
    }
    public void applyBuffsOfCellsOfGameboard(){
        for (int i = 0; i < 5; i++){
            for (int j = 0; j < 9; j++){
                gameBoard.getCell(i, j).applyBuffs();
            }
        }
    }
}