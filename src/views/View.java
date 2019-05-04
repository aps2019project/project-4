package views;

import controller.Controller;
import model.*;
import views.Exceptions.*;

import java.util.ArrayList;

public class View {
    public static void showHelp() {
        switch (Controller.getMenu()) {
            case ACCOUNT:
                showAccountMenuHelp();
                break;
            case MAIN:
                showMainMenuHelp();
                break;
            case COLLECTION:
                showCollectionMenuHelp();
                break;
            case SHOP:
                showShopMenuHelp();
                break;
            case BATTLE:
                showBattleMenuHelp();
                break;
        }
    }

    private static void showAccountMenuHelp() {
        System.out.println("create account [user name] : Create a new account");
        System.out.println("login [user name] : Login in account with name user name");
        System.out.println("show leaderboard: Sort users by their wins and losses and show them");
        System.out.println("save: Save changes");
        System.out.println("help: Show Helps");
        System.out.println("exit game: Exit from game");
    }

    private static void showMainMenuHelp() {
        System.out.println("enter Collection|Shop|Battle : Enter in menus");
        System.out.println("logout: Log out from account");
        System.out.println("exit game: Exit from game");
        System.out.println("help: to show help");
    }

    private static void showCollectionMenuHelp() {
        System.out.println("back: Back to main menu");
        System.out.println("show: Show all cards and items in collection and their cost");
        System.out.println("search [card name|item name]: Show card or item with special name if exists");
        System.out.println("save: Save changes");
        System.out.println("create deck [deck name]: Create new deck");
        System.out.println("delete deck [deck name]: Delete deck");
        System.out.println("add [card id|hero id|item id] to deck [deck name]: Add a hero or item or card to a deck");
        System.out.println("remove [card id|hero id|item id] from deck [deck name]: Remove a hero or item or card from a deck");
        System.out.println("validate deck [deck name]: Check if a deck is valid? (Having 20 cards and 1 hero)");
        System.out.println("select deck [deck name]: Select a deck to main deck");
        System.out.println("show all decks: Show all decks by special format");
        System.out.println("show deck [deck name]: Show a special deck");
        System.out.println("help: Show help");
    }

    private static void showShopMenuHelp() {

    }

    private static void showBattleMenuHelp() {

    }

    public static void showMenu() {
        switch (Controller.getMenu()) {
            case ACCOUNT:
                showAccountMenu();
                break;
            case BATTLE:
                showBattleMenu();
                break;
            case SHOP:
                showShopMenu();
                break;
            case MAIN:
                showMainMenu();
                break;
        }
    }

    public static void showAccounts(ArrayList<Account> accounts) {
        accounts.forEach(account -> System.out.println(account.toString()));
    }

    private static void showAccountMenu() {
        System.out.print("1.Create Account\n2.Login\n3.Show Leaderboard\n4.Save\n5.Help\n6.Exit game\n");
    }

    private static void showMainMenu() {
        System.out.print("1.Collection\n2.Shop\n3.Battle\n4.Logout\n5.Exit game\n6.Help\n");
    }

    private static void showShopMenu() {

    }

    private static void showBattleMenu() {

    }

    public static void showSuccessfulAccountCreationMessage(String userName) {
        System.out.println("The account with name " + userName + " created!");
    }

    public static void showEnterPasswordMessage() {
        System.out.println("Enter Password");
    }

    public static void showConfirmationLogoutMessage() {
        System.out.println("Are you sure to logout?[Y/N]");
    }

    public static void showConfirmationExitMessage() {
        System.out.println("Are you sure to exit?[Y/N]");
    }

    public static void showStunnedCardMessage(String string) {
        System.out.printf("This card with id: %s is stuned\n", string);
    }

    public static void showCardHasMovedMessage(String string) {
        System.out.printf("This card with id: %s has moved this turn\n", string);
    }

    public static void showOutOfDistanceMessage() {
        System.out.println("Opponent minion or hero is unavailable for attack");
    }

    public static void showHasAttackedMessage(String string) {
        System.out.printf("This card with id: %s has attacked this turn\n", string);
    }

    public static void showInsertedMinionMessage(String name, String id, int x, int y) {
        System.out.printf("%s with id: %s inserted in (%d, %d)\n", name, id, x, y);
    }

    public static void showSelectionDeckMessage(String deckName) {
        System.out.println("The deck " + deckName + "selected!");
    }

    public static void showInvalidTargetMessage() {
        System.err.println("Invalid target");
    }

    public static void showAddDeckMessage(String deckName) {
        System.out.println("The deck with name " + deckName + " created successfully!");
    }

    public static void showRemovalDeckMessage(String deckName) {
        System.out.println("The " + deckName + " deck removed successfully!");
    }

    public static void showRemovalCardMessage(String thingID, String deckName) {
        System.out.println("The " + thingID + " from deck" + deckName + " removed successfully!");
    }

    public static void showAddThingToDeckMessage(String thingID, String deckName) throws Exception{
        switch (Account.getCurrentAccount().getCollection().typeOfThing(thingID)) {
            case HERO:
                System.out.println("The hero " + thingID + " added to deck " + deckName + "!");
                break;
            case ITEM:
                System.out.println("The item " + thingID + " added to deck " + deckName + "!");
                break;
            case NONHERO:
                System.out.println("The card " + thingID + " added to deck " + deckName + "!");
                break;
        }
    }

    public static void showValidateDeckMessage(String deckName) throws DeckNotAvailabilityException {
        if (!Account.getCurrentAccount().getCollection().getDecks().containsKey(deckName))
            throw new DeckNotAvailabilityException(deckName);
        if (Account.getCurrentAccount().getCollection().getDecks().get(deckName).validateDeck()) {
            System.out.println("The " + deckName + " deck is valid!");
        } else {
            System.out.println("The " + deckName + " deck is not valid!!");
        }
    }

    public static void showNameOfMenu() {
        switch (Controller.getMenu()) {
            case ACCOUNT:
                System.out.print("AccountMenu>>");
                break;
            case MAIN:
                System.out.print("MainMenu>>");
                break;
            case COLLECTION:
                System.out.print("CollectionMenu>>");
                break;
            case SHOP:
                System.out.print("ShopMenu>>");
                break;
            case BATTLE:
                System.out.println("BattleMenu>>");
                break;
        }
    }

    public static void showAllCards() {
        System.out.println("Heros:");
        Account.getCurrentAccount().getCollection().getHeros().forEach((s, hero) -> System.out.println(hero.infoForDeckWithPrice()));
        System.out.println("Items:");
        Account.getCurrentAccount().getCollection().getUsableItems().forEach((s, item) -> System.out.println((item.infoWithPrice())));
        System.out.println("Cards:");
        Account.getCurrentAccount().getCollection().getNonHeroCards().forEach((s, card) -> System.out.println(card.infoForDeckWithPrice()));

    }

    public static void showAllDecks() {
        int index = 1;
        if (Account.getCurrentAccount().getSelectedDeck() != null) {
            System.out.println(index + " : " + Account.getCurrentAccount().getSelectedDeck().getName() + " :");
            View.showDeck(Account.getCurrentAccount().getSelectedDeck());
            index = 2;
        }
        for (Deck deck : Account.getCurrentAccount().getCollection().getDecks().values()) {
            if (deck != Account.getCurrentAccount().getSelectedDeck()) {
                System.out.println(index + " : " + deck.getName() + " :");
                View.showDeck(deck);
            }
            index++;
        }
    }

    public static void showSearchResults(String string) throws CardAndItemNotAvailabilityException {
        if (Account.getCurrentAccount().getCollection().searchCard(string).size() == 0 &
                Account.getCurrentAccount().getCollection().searchItem(string).size() == 0) {
            throw new CardAndItemNotAvailabilityException();
        }
        View.showCards(Account.getCurrentAccount().getCollection().searchCard(string));
        View.showItems(Account.getCurrentAccount().getCollection().searchItem(string));
    }

    public static void showCards(ArrayList<Card> cards) {
        int i = 0;
        for (Card card : cards) {
            i++;
            System.out.println(i + ": " + card.infoForDeckWithPrice());
        }
    }

    public static void showItems(ArrayList<UsableItem> items) {
        int i = 0;
        for (UsableItem item : items) {
            i++;
            System.out.println(i + ": " + item.infoWithPrice());
        }
    }

    public static void showDeck(Deck deck) {
        System.out.println("Hero:");
        if (deck.isHaveHero())
            System.out.println("1: " + deck.getHero().infoForDeck());
        System.out.println("Item: ");
        if (deck.getItem() != null) {
            System.out.println("1: " + deck.getItem().info());
        }
        System.out.println("Cards: ");
        if (deck.getCards() != null) {
            int index = 1;
            for (Card card : deck.getCards().values()) {
                if (!(card instanceof Hero))
                    System.out.println(index + " : " + card.infoForDeck());
                index++;
            }
        }
    }

    public static void showDeck(String deckName) throws DeckNotAvailabilityException {
        if (!Account.getCurrentAccount().getCollection().getDecks().containsKey(deckName))
            throw new DeckNotAvailabilityException(deckName);
        showDeck(Account.getCurrentAccount().getCollection().getDecks().get(deckName));
    }
}
