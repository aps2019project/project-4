package views;

import model.Enums;

public class Exceptions {
    public static class InvalidUserNameException extends Exception {
        public InvalidUserNameException() {
            super("User name is invalid");
        }
    }

    public static class InvalidPasswordException extends Exception {
        public InvalidPasswordException() {
            super("Invalid Password");
        }
    }

    public static class DuplicateAccountException extends Exception {
        public DuplicateAccountException(String userName) {
            super("The with name " + userName + " exists!");
        }
    }

    public static class DeckAvailabilityException extends Exception {
        public DeckAvailabilityException(String deckName) {
            super("The deck with name " + deckName + " is available");
        }
    }

    public static class DeckNotAvailabilityException extends Exception {
        public DeckNotAvailabilityException(String deckName) {
            super("The deck with name " + deckName + " is not available");
        }

        public DeckNotAvailabilityException(String deckName, Boolean isInValids) {
            super("The deck with name " + deckName + " is not available in valid decks");
        }
    }

    public static class CardAndItemNotAvailabilityException extends Exception {
        public CardAndItemNotAvailabilityException() {
            super("No Card or Item found!");
        }

        public CardAndItemNotAvailabilityException(String thingName) {
            super("No Card or Item with name " + thingName + " found!");
        }
    }

    public static class MoneyIsNotEnoughException extends Exception {
        public MoneyIsNotEnoughException() {
            super("Your Money is not enough!");
        }
    }

    public static class ThreeItemException extends Exception {
        public ThreeItemException() {
            super("You Have 3 Items!");
        }
    }

    public static class IDNotAvailableException extends Exception {
        public IDNotAvailableException(String id, String deckName) {
            super("No thing with ID " + id + " in deck " + deckName + " found!");
        }

        public IDNotAvailableException(String id) {
            super("No thing with ID " + id + " found!");
        }
    }

    public static class InvalidCardIdException extends Exception {
        public InvalidCardIdException(String cardId) {
            super(cardId + " is invalid card id");
        }
    }

    public static class SpellsCanNotMoveException extends Exception {
        public SpellsCanNotMoveException() {
            super("Spells can not move, select a minion");
        }
    }

    public static class InvalidCellException extends Exception {
        public InvalidCellException() {
            super("The coordinates of cell is invalid!");
        }
    }

    public static class CellIsFullException extends Exception {
        public CellIsFullException(int x , int y){
            super("The cell with coordination of " + x + " , " + y + " is full.");
        }
    }

    public static class CardNotInHandMessage extends Exception {
        public CardNotInHandMessage(){
            super("Choose a card from your hand");
        }
    }

    public static class NoDeckSelectedException extends Exception {
        public NoDeckSelectedException() {
            super("Please Select a deck!");
        }
    }

    public static class UserDeckInvalidException extends Exception {
        public UserDeckInvalidException(String userName) {
            super("Selected deck of " + userName + " is invalid.");
        }
    }

    public static class NotValidDeckException extends Exception {
        public NotValidDeckException(String deckName) {
            super("The deck with name " + deckName + " is not valid!");
        }
    }

    public static class SelectedDeckInvalidException extends Exception {
        public SelectedDeckInvalidException() {
            super("Your Selected deck is invalid!");
        }
    }

    public static class ThingNotAvailableInCollectionException extends Exception {
        public ThingNotAvailableInCollectionException(String thingID) {
            super("No thing with id " + thingID + " found!");
        }
    }

    public static class HeroAvailableInDeckException extends Exception {
        public HeroAvailableInDeckException(String deckName) {
            super("The " + deckName + " has hero!");
        }
    }

    public static class CardAvailableInDeckException extends Exception {
        public CardAvailableInDeckException(String cardName, String deckName) {
            super("Card with name " + cardName + " is Available in deck " + deckName + "!");
        }
    }

    public static class ItemAvailableInDeckException extends Exception {
        public ItemAvailableInDeckException(String itemID, String deckName) {
            super("Item with id " + itemID + " is Available in deck " + deckName + "!");
        }
    }

    public static class DeckFullException extends Exception {
        public DeckFullException(String deckName) {
            super("The deck " + deckName + " is full!");
        }
    }

    public static class InvalidCommandException extends Exception {
        public InvalidCommandException() {
            super("Invalid Command");
        }

        public void showMessage() {
            System.err.println(super.getMessage());
            View.showHelp();
        }
    }
}
