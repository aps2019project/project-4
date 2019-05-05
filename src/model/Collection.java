package model;

import views.Exceptions.*;
import views.View;

import java.util.ArrayList;
import java.util.HashMap;

public class Collection {
    private HashMap<String, Deck> decks;
    private HashMap<String, Card> allCards;
    private HashMap<String, UsableItem> usableItems;
    //String is id of card and items

    public Collection() {
        this.decks = new HashMap<>();
        this.allCards = new HashMap<>();
        this.usableItems = new HashMap<>();
    }

    public void addCard(Card card) {
        this.getAllCards().put(this.idGenerator(card), card);
    }

    public void addItem(UsableItem item) {
        this.getUsableItems().put(this.idGenerator(item), item);
    }

    public int numOfCard(String cardName) {
        int i = 0;
        for (Card card: this.getAllCards().values()){
            if (card.getName().equals(cardName))
                i++;
        }
        return i;
    }

    public int numOfItem(String itemName) {
        int i = 0;
        for (UsableItem usableItem: this.getUsableItems().values()){
            if (usableItem.getName().equals(itemName))
                i++;
        }
        return i;
    }

    public String idGenerator(UsableItem item) {
        return Account.getCurrentAccount().getName() + "_" + item.getName() + "_" + this.numOfItem(item.getName());
    }

    public String idGenerator(Card card) {
        return Account.getCurrentAccount().getName() + "_" + card.getName() + "_" + this.numOfCard(card.getName());
    }

    public HashMap<String, Deck> getDecks() {
        return decks;
    }

    public HashMap<String, Card> getAllCards() {
        return allCards;
    }

    public HashMap<String, Hero> getHeros() {
        HashMap<String, Hero> heros = new HashMap<>();
        for (Card card : getAllCards().values()) {
            if (card instanceof Hero) {
                heros.put(card.getName(), (Hero) card);
            }
        }
        return heros;
    }

    public boolean isHaveSpecialHero(String heroID) {
        Card card = this.getAllCards().get(heroID);
        return card instanceof Hero;
    }

    public boolean isHaveSpecialCardNonHero(String cardID) {
        Card card = this.getAllCards().get(cardID);
        return !(card instanceof Hero);
    }

    public boolean isHaveSpecialItem(String itemID) {
        return this.getUsableItems().get(itemID) != null;
    }

    public Enums.TypeOfThing typeOfThing(String thingID) throws ThingNotAvailableInCollectionException {
        if (isHaveSpecialHero(thingID)) return Enums.TypeOfThing.HERO;
        if (isHaveSpecialItem(thingID)) return Enums.TypeOfThing.ITEM;
        if (isHaveSpecialCardNonHero(thingID)) return Enums.TypeOfThing.NONHERO;
        throw new ThingNotAvailableInCollectionException(thingID);
    }

    public void addThingToDeck(String thingID, String deckName) throws Exception {
        if (this.getDecks().get(deckName) == null)
            throw new DeckNotAvailabilityException(deckName);
        if (this.getDecks().get(deckName).getCards().size() == 20)
            throw new DeckFullException(deckName);
        Enums.TypeOfThing typeOfThing = typeOfThing(thingID);
        switch (typeOfThing) {
            case HERO:
                if (this.getDecks().get(deckName).isHaveHero())
                    throw new HeroAvailableInDeckException(deckName);
                this.getDecks().get(deckName).addCard(this.getAllCards().get(thingID));
                View.showAddThingToDeckMessage(thingID, deckName);
                break;
            case ITEM:
                if (this.getDecks().get(deckName).getItem() != null)
                    throw new ItemAvailableInDeckException(thingID, deckName);
                this.getDecks().get(deckName).setItem(this.getUsableItems().get(thingID));
                View.showAddThingToDeckMessage(thingID, deckName);
                break;
            case NONHERO:
                if (this.getDecks().get(deckName).getCards().get(thingID) != null)
                    throw new CardAvailableInDeckException(thingID, deckName);
                this.getDecks().get(deckName).addCard(this.getAllCards().get(thingID));
                View.showAddThingToDeckMessage(thingID, deckName);
                break;
        }
    }

    public HashMap<String, Card> getNonHeroCards() {
        HashMap<String, Card> cardHashMap = new HashMap<>();
        this.getAllCards().forEach((s, card) -> {
            if (!(card instanceof Hero)) cardHashMap.put(card.getName(), card);
        });
        return cardHashMap;
    }

    public HashMap<String, UsableItem> getUsableItems() {
        return usableItems;
    }

    public void removeThingFromAllDecks(String thingID) throws Exception {
        for (Deck deck : this.getDecks().values())
            deck.removeThingWithID(thingID, false);
    }

    public void removeCard(String thingID, String deckName) throws DeckNotAvailabilityException, IDNotAvailableException {
        if (!(this.getDecks().containsKey(deckName)))
            throw new DeckNotAvailabilityException(deckName);
        this.getDecks().get(deckName).removeThingWithID(thingID, true);
        View.showRemovalCardMessage(thingID, deckName);
    }

    public ArrayList<Card> searchCard(String string) {
        ArrayList<Card> cards = new ArrayList<>();
        this.getAllCards().forEach((s, card) -> {
            if (card.getName().contains(string)) {
                cards.add(card);
            }
        });
        return cards;
    }

    public ArrayList<UsableItem> searchItem(String string) {
        ArrayList<UsableItem> usableItems = new ArrayList<>();
        this.getUsableItems().forEach((s, usableItem) -> {
            if (usableItem.getName().contains(string)) {
                usableItems.add(usableItem);
            }
        });
        return usableItems;
    }

    public void removeDeck(String deckName) throws DeckNotAvailabilityException {
        if (!(this.getDecks().containsKey(deckName)))
            throw new DeckNotAvailabilityException(deckName);
        this.getDecks().remove(deckName);
        View.showRemovalDeckMessage(deckName);
    }

    public void addDeck(String deckName) throws DeckAvailabilityException {
        if (this.getDecks().containsKey(deckName))
            throw new DeckAvailabilityException(deckName);
        this.getDecks().put(deckName, new Deck(deckName));
        View.showAddDeckMessage(deckName);
    }

}
