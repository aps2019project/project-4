package model;

import java.util.HashMap;

public class Player {
    private String name;
    private Deck deck;//first deck
    private Deck mutableDeck;//mutable deck
    private HashMap<String, Card> hand;
    private int numOfFlags;
    private int numOfTurnsHeldFlag;
    private Card nextCard;
    private Card selectedCard;
    private Item selectedItem;
    private HashMap<String, Item> collectableItems;
    private HashMap<String, Card> graveYard;
    private int mana;

    public Player(String name, Deck mainDeck) {
        this.name = name;
        this.deck = mainDeck;
        this.mutableDeck = mainDeck.clone();
    }

    public Deck getMutableDeck() {
        return mutableDeck;
    }

    public Player() { }

    public void setName(String name) {
        this.name = name;
    }

    public Deck getDeck() {
        return this.deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public void putCardInGraveYard(Card card) {
    }

    public void changeMana(int mana) {
    }

    public int getMana() {
        return mana;
    }

    public void replaceCard(Card cardInHand) {
    }

    public Card getSelectedCard() {
        return selectedCard;
    }

    public Card selectCard(String id) {
        return mutableDeck.getCards().get(id);
    }

    public void moveSelectedCard(int x, int y) {

    }

    public void showHand() {
    }

    public void insertCard(String cardName, int x, int y) {
    }

    public boolean isTargetValid(Card card, int x, int y) {
        return false;
    }

    public void useSpecialPower(int x, int y) {
    }

    public void selectItem(String itemName) {
    }

    public void endTurn() {
    }

    public void changeNumOfFlags(int numOfFlags) {
    }

    public void changeNumOfTurnsFlag(int numOfTurnsHeldFlag) {
    }

    public void showCardInfo(String cardId) {
    }

    public void showCollectables() {
    }

    public void showCardInGraveYard(String id) {
    }

    public void showMyMinions() {
    }

    public void showOpponentMinions() {
    }

    public void enterGraveYard() {
    }

    public void showHelp() {
    }
}
