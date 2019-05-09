package model;

import views.Exceptions.*;
import views.View;

import java.util.HashMap;

public class Player {
    private String name;
    protected Deck deck;//first deck
    protected Deck mutableDeck;//mutable deck
    protected Hand hand;
    private int numOfFlags;
    private int numOfTurnsHeldFlag;
    private Card selectedCard;
    private Item selectedItem;
    protected HashMap<String, Item> collectableItems;
    protected HashMap<String, Card> graveYard;
    protected Deck cardsInGameBoard;
    private int mana = 2;

    public Player(String name, Deck mainDeck) {
        this.name = name;
        this.deck = mainDeck;
        this.mutableDeck = mainDeck.clone();
        this.collectableItems = new HashMap<>();
        this.graveYard = new HashMap<>();
        this.cardsInGameBoard = new Deck("");
        this.mutableDeck.removeCard(this.getDeck().getHero().getId());
        hand = new Hand(mutableDeck);
    }

    public Player() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public Deck getDeck() {
        return this.deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public Hand getHand() {
        return hand;
    }

    public String getName() {
        return name;
    }

    public int getNumOfTurnsHeldFlag() {
        return numOfTurnsHeldFlag;
    }

    public int getNumOfFlags() {
        return numOfFlags;
    }

    public Deck getMutableDeck() {
        return mutableDeck;
    }

    public void setMutableDeck(Deck mutableDeck) {
        this.mutableDeck = mutableDeck;
    }

    public HashMap<String, Card> getGraveYard() {
        return graveYard;
    }

    public HashMap<String, Item> getCollectableItems() {
        return collectableItems;
    }

    public Deck getCardsInGameBoard() {
        return cardsInGameBoard;
    }

    public Item getSelectedItem() {
        return selectedItem;
    }

    public void putCardInGraveYard(Card card) {
    }

    public void changeMana(int change) {
        this.mana += change;
    }

    public void addNumOfTurnsHeldFlag() {
        this.numOfTurnsHeldFlag++;
    }

    public void zeroNumOfTurnsHeldFlag() {
        this.numOfTurnsHeldFlag = 0;
    }

    public void changeNumberOfFlag(int change) {
        this.numOfFlags += change;
    }

    public int getMana() {
        return mana;
    }

    public Card getSelectedCard() {
        return selectedCard;
    }

    public void setSelectedCard(Card selectedCard) {
        this.selectedCard = selectedCard;
    }

    public void selectCard(String cardId) throws Exception {
        if (this.getCardsInGameBoard().getCards().get(cardId) == null)
            throw new InvalidCardIdException(cardId);
        this.setSelectedCard(this.getCardsInGameBoard().getCards().get(cardId));
        View.showSelectCardMessage(cardId);
    }

    public void setMana(int mana) {
        this.mana = mana;
    }
}
