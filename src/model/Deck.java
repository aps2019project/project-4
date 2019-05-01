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
        this.getCards().put(card.getName(), card);
        //TODO add ID
        //this is wrong
    }

    public void removeThingWithID(String id) throws IDNotAvailableInDeckException, NullPointerException {
        if (this.removeCard(id) & this.removeItem(id))
            throw new IDNotAvailableInDeckException(id, this.getName());
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

    public void sellCard(String cardName) {
        for (int i = 0; i < this.getCards().size(); i++) {
            if (this.getCards().get(i).getName().equals(cardName)) {
                this.getCards().remove(this.getCards().get(i).getId());
                i--;
            }
        }
    }

    public void sellItem(String itemName) throws NullPointerException {
        if (this.getItem().getName().equals(itemName)) {
            this.setItem(null);
        }
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
