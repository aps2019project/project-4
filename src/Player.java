import java.util.HashMap;

public class Player {
    private String name;
    private Deck selectedDeck;
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
        Constants instance = Constants.getInstance();
        this.name = name;
        this.selectedDeck = mainDeck;

    }

    public Player() {

    }

    public Deck getDeck() {
        return this.selectedDeck;
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

    public void selectCard(String id) {
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
