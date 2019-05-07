package model;

import views.Exceptions.*;
import views.View;

import java.util.HashMap;

public class Player {
    private String name;
    private Deck deck;//first deck
    private Deck mutableDeck;//mutable deck
    private Hand hand;
    private int numOfFlags;
    private int numOfTurnsHeldFlag;
    private Card selectedCard;
    private Item selectedItem;
    private HashMap<String, Item> collectableItems;
    private HashMap<String, Card> graveYard;
    private Deck cardsInGameBoard;
    private int mana;

    public Player(String name, Deck mainDeck) {
        this.name = name;
        this.deck = mainDeck;
        this.mutableDeck = mainDeck.clone();
        this.collectableItems = new HashMap<>();
        this.graveYard = new HashMap<>();
        this.cardsInGameBoard = new Deck("");
        Deck mutableDeck = mainDeck.clone();
        hand = new Hand(mutableDeck);
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

    public HashMap<String, Card> getGraveYard() {
        return graveYard;
    }

    public HashMap<String, Item> getCollectableItems() {
        return collectableItems;
    }

    public Deck getCardsInGameBoard() {
        return cardsInGameBoard;
    }

    public void putCardInGraveYard(Card card) {
    }

    public void changeMana(int change) {
        this.mana += change;
    }

    public void addNumOfTurnsHeldFlag(){
        this.numOfTurnsHeldFlag++;
    }

    public void zeroNumOfTurnsHeldFlag(){
        this.numOfTurnsHeldFlag = 0;
    }

    public void changeNumberOfFlag(int change){
        this.numOfFlags += change;
    }

    //public

    public int getMana() {
        return mana;
    }

    public void replaceCard(Card cardInHand) {
    }

    public Card getSelectedCard() {
        return selectedCard;
    }

    public void setSelectedCard(Card selectedCard) {
        this.selectedCard = selectedCard;
    }

    public void selectCard(String cardId)throws Exception {
        if (this.getCardsInGameBoard().getCards().get(cardId) == null)
            throw new InvalidCardIdException(cardId);
        this.setSelectedCard(this.getCardsInGameBoard().getCards().get(cardId));
        View.showSelectCardMessage(cardId);
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
