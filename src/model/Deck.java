package model;

import java.util.HashMap;

public class Deck {
    private String name;
    private HashMap<String, Card> cards;
    //String is ID
    private UsableItem item;

    public Deck(String name) {
        this.name = name;
        this.cards = new HashMap<>();
        this.item = null;
    }

    public UsableItem getItem() {
        return item;
    }

    public String getName() {
        return name;
    }

    public HashMap<String, Card> getCards() {
        return cards;
    }

    public void setItem(UsableItem item) {
        this.item = item;
    }

    public void addCard(Card card) {
        this.getCards().put(card.getName(), card);
        //TODO add ID
    }

    public int getNumOfOtherHeroCards() {
        int i = 0;
        for (Card card : this.getCards().values()) {
            if (!(card instanceof Hero)) {
                i++;
            }
        }
        return i;
    }

    public boolean isHaveHero() {
        for (Card card : this.getCards().values()) {
            if (card instanceof Hero) {
                return true;
            }
        }
        return false;
    }

    public Hero getHero() {
        for (Card card : this.getCards().values()) {
            if (card instanceof Hero) {
                return (Hero) card;
            }
        }
        return null;
    }

    public boolean validateDeck() {
        if (this.isHaveHero() & this.getNumOfOtherHeroCards() == 20)
            return true;
        return false;
    }
}
