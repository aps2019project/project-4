package model;

import views.Exceptions.*;

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
        this.getCards().put(card.getId(), card);
    }

    public void removeThingWithID(String id, Boolean throwError) throws IDNotAvailableException, NullPointerException {
        boolean isNotRemoval = this.removeCard(id) & this.removeItem(id);
        if (isNotRemoval & throwError)
            throw new IDNotAvailableException(id, this.getName());
    }

    public boolean removeItem(String itemID) throws NullPointerException {
        if (this.getItem().getId().equals(itemID))
            this.setItem(null);
        else
            return true;
        return false;
    }

    public boolean removeCard(String cardID) {
        return (this.getCards().remove(cardID) == null);
    }

    public int getNumOfOtherHeroCards() {
        int i = 0;
        for (Card card : this.getCards().values())
            if (!(card instanceof Hero))
                i++;
        return i;
    }

    public boolean isHaveHero() {
        return this.getHero() != null;
    }

    public Hero getHero() {
        for (Card card : this.getCards().values())
            if (card instanceof Hero)
                return (Hero) card;
        return null;
    }

    public boolean validateDeck() {
        if (this.isHaveHero() & this.getNumOfOtherHeroCards() == 20)
            return true;
        return false;
    }
}
