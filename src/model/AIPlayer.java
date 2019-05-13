package model;

import views.View;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class AIPlayer extends Player {
    private int stage;

    public AIPlayer(String name, Deck deck) {
        this.name = name;
        this.deck = deck.clone();
        this.stage = -1;
        this.mutableDeck = deck.clone();
        this.mutableDeck.removeCard(this.getDeck().getHero().getId());
        this.collectableItems = new HashMap<>();
        this.graveYard = new HashMap<>();
        this.cardsInGameBoard = new Deck("");
        hand = new Hand(mutableDeck);
    }

    public void setStage(int stage) {
        this.stage = stage;
    }

    public int getStage() {
        return stage;
    }

    public void handleTurn() {
        Battle battle = Account.getCurrentAccount().getCurrentBattle();
        try {
            Random random = new Random();
            ArrayList<Card> cards = new ArrayList<>(hand.getCards().values());
            for (Card card : cards) {
                if (card instanceof Minion) {
                    battle.insert(card.getId(), random.nextInt(4), random.nextInt(9));
                    break;
                }
            }
            battle.getWhoseTurn().setSelectedCard(
                    new ArrayList<>(Account.getCurrentAccount().getCurrentBattle().getPlayer2().getCardsInGameBoard().getCards().values()).get(random.nextInt(
                            Account.getCurrentAccount().getCurrentBattle().getPlayer2().getCardsInGameBoard().getCards().size()
                    )));
            battle.moveTo(
                    ((Minion) Account.getCurrentAccount().getCurrentBattle().getPlayer2().getSelectedCard()).getCellPlace().getX() + random.nextInt(1),
                    ((Minion) Account.getCurrentAccount().getCurrentBattle().getPlayer2().getSelectedCard()).getCellPlace().getY() - random.nextInt(1));
            for (Card card : new ArrayList<>(battle.getWhoseTurn().getHand().getCards().values())) {
                if (card instanceof Minion) {
                    int x = random.nextInt(5);
                    int y = random.nextInt(9);
                    while (true)
                        if (battle.getGameBoard().getCell(x, y).getMinion() != null) {
                            x = random.nextInt(5);
                            y = random.nextInt(9);
                        } else {
                            break;
                        }
                    battle.insert(card.getId(), x, y);
                } else {
                    battle.insert(card.getId(), battle.getMinions().get(0).getCellPlace().getX(), battle.getMinions().get(0).getCellPlace().getY());
                }
            }
            battle.attack(battle.getOppMinions().get(0).getCellPlace().getX(), battle.getOppMinions().get(0).getCellPlace().getY());
            battle.nextTurn();
        } catch (Exception e) {
        }
    }
}
