package model;

import views.Exceptions.*;

import java.util.HashMap;

public class Collection {
    private HashMap<String, Deck> decks;
    private HashMap<String, Card> allCards;
    private HashMap<String, UsableItem> usableItems;

    public Collection() {
        this.decks = new HashMap<>();
        this.allCards = new HashMap<>();
        this.usableItems = new HashMap<>();
    }

    public HashMap<String, Deck> getDecks() {
        return decks;
    }

    public HashMap<String, Card> getAllCards() {
        return allCards;
    }

    public HashMap<String , Hero> getHeros(){
        HashMap<String, Hero> heros = new HashMap<>();
        for(Card card: getAllCards().values()){
            if (card instanceof Hero){
                heros.put(card.getName() , (Hero) card);
            }
        }
        return heros;
    }

    public HashMap<String, Card> getNonHeroCards(){
        HashMap<String, Card> cardHashMap = new HashMap<>();
        for(Card card: getAllCards().values()){
            if (!(card instanceof Hero)){
                cardHashMap.put(card.getName() , card);
            }
        }
        return cardHashMap;
    }

    public HashMap<String, UsableItem> getUsableItems() {
        return usableItems;
    }

    public void removeCard(String cardID) {
        this.getAllCards().remove(cardID);
    }

    public void removeDeck(String deckName) throws DeckNotAvailabilityException {
        if (!(this.getDecks().containsKey(deckName)))
            throw new DeckNotAvailabilityException(deckName);
        this.getDecks().remove(deckName);
    }

    public void addDeck(String deckName) throws DeckAvailabilityException {
        if (this.getDecks().containsKey(deckName))
            throw new DeckAvailabilityException(deckName);
        this.getDecks().put(deckName, new Deck(deckName));
    }
}
