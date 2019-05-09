package model;

import java.util.ArrayList;
import java.util.Random;

public class AIPlayer extends Player {
    private int stage;

    public AIPlayer(Deck deck) {
        this.setDeck(deck);
        this.stage = -1;
    }

    public void setStage(int stage) {
        this.stage = stage;
    }

    public int getStage() {
        return stage;
    }

    public void handleTurn() {
        Random random = new Random();
        Account.getCurrentAccount().getCurrentBattle().getWhoseTurn().setSelectedCard(
                new ArrayList<>(Account.getCurrentAccount().getCurrentBattle().getPlayer2().getCardsInGameBoard().getCards().values()).get(1));
        Account.getCurrentAccount().getCurrentBattle().moveTo(((Minion)Account.getCurrentAccount().getCurrentBattle().getPlayer2().getSelectedCard()).getCellPlace().getX()
        //((Minion)Account.getCurrentAccount().getCurrentBattle().getPlayer2().getSelectedCard()).getCellPlace().getY()+ random.nextInt(2));
        for(Card card: this.getCardsInGameBoard().getCards().values()){

        }
    }
}
