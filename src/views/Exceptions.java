package views;

import model.Card;

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
    }

    public static class  CardAndItemNotAvailabilityException extends Exception{
        public CardAndItemNotAvailabilityException(){
            super("No Card or Item found!");
        }
    }

    public static class IDNotAvailableInDeckException extends Exception {
        public IDNotAvailableInDeckException(String id , String deckName){
            super("No thing with ID " + id  + " in deck " + deckName + " found!");
        }
    }


    public static class NotValidDeckException extends Exception {
        public NotValidDeckException(String deckName) {
            super("The deck with name " + deckName + " is not valid!");
        }
    }

    public static class CardNotAvailableInCollectionException extends Exception {
        public CardNotAvailableInCollectionException(String thingName){
            super("No thing with name " + thingName + "found!");
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
