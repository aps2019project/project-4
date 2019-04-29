package views;

import controller.Controller;
import model.*;
import views.Exceptions.*;

import java.io.CharArrayReader;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Comparator;

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
        System.out.println("enter model.Collection|model.Shop|model.Battle : Enter in menus");
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
        System.out.print("1.Create model.Account\n2.Login\n3.Show Leaderboard\n4.Save\n5.Help\n6.Exit game\n");
    }

    private static void showMainMenu() {
        System.out.print("1.model.Collection\n2.model.Shop\n3.model.Battle\n4.Logout\n5.Exit game\n6.Help\n");
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

    public static void showValidateDeckMessage(String deckName) throws DeckNotAvailabilityException {
        if (!Account.getCurrentAccount().getCollection().getDecks().containsKey(deckName))
            throw new DeckNotAvailabilityException(deckName);
        if (Account.getCurrentAccount().getCollection().getDecks().get(deckName).validateDeck()) {
            System.out.println("The " + deckName + " deck is valid!");
        } else {
            System.out.println("The " + deckName + " deck is not valid!!");
        }
    }

    public static void showAllCards(){
        System.out.println("Heros:");
        Account.getCurrentAccount().getCollection().getHeros().forEach((s, hero) -> System.out.println(hero.infoForDeckWithPrice()));
        System.out.println("Items:");
        Account.getCurrentAccount().getCollection().getUsableItems().forEach((s, item) -> System.out.println((item.infoWithPrice())));
        System.out.println("Cards:");
        Account.getCurrentAccount().getCollection().getNonHeroCards().forEach((s, card) -> System.out.println(card.infoForDeckWithPrice()));

    }

    public static void showAllDecks() {
        if (Account.getCurrentAccount().getSelectedDeck() != null) {
            System.out.println("1 : " + Account.getCurrentAccount().getSelectedDeck().getName() + " :");
            View.showDeck(Account.getCurrentAccount().getSelectedDeck());
        }
        int index = 2;
        for (Deck deck : Account.getCurrentAccount().getCollection().getDecks().values()) {
            if (deck != Account.getCurrentAccount().getSelectedDeck()) {
                System.out.println(index + " : " + deck.getName() + " :");
                View.showDeck(deck);
            }
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