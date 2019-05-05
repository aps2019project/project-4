package controller;

import model.Account;
import model.Enums;
import model.Shop;
import views.View;
import views.Exceptions.*;
import resources.Resources;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller {

    private static String command;
    private static Scanner scanner;
    private static Enums.Menus menu;
    private static Boolean isEndedGame;
    private final static ArrayList<Pattern> patternsOfAccountMenu = new ArrayList<>();
    private final static ArrayList<Pattern> patternsOfMainMenu = new ArrayList<>();
    private final static ArrayList<Pattern> patternsOfCollectionMenu = new ArrayList<>();
    private final static ArrayList<Pattern> patternsOfShopMenu = new ArrayList<>();
    private final static ArrayList<Pattern> patternsOfBattleMenu = new ArrayList<>();

    public static void setPatterns() {
        patternsOfAccountMenu.add(Pattern.compile("create account (\\w+)", Pattern.CASE_INSENSITIVE));
        patternsOfAccountMenu.add(Pattern.compile("login (\\w+)", Pattern.CASE_INSENSITIVE));
        patternsOfAccountMenu.add(Pattern.compile("show leaderboard", Pattern.CASE_INSENSITIVE));
        patternsOfAccountMenu.add(Pattern.compile("save", Pattern.CASE_INSENSITIVE));
        patternsOfAccountMenu.add(Pattern.compile("help", Pattern.CASE_INSENSITIVE));
        patternsOfAccountMenu.add(Pattern.compile("exit", Pattern.CASE_INSENSITIVE));

        patternsOfMainMenu.add(Pattern.compile("enter (Collection|Shop|Battle)", Pattern.CASE_INSENSITIVE));
        patternsOfMainMenu.add(Pattern.compile("logout", Pattern.CASE_INSENSITIVE));
        patternsOfMainMenu.add(Pattern.compile("exit", Pattern.CASE_INSENSITIVE));
        patternsOfMainMenu.add(Pattern.compile("help", Pattern.CASE_INSENSITIVE));

        patternsOfCollectionMenu.add(Pattern.compile("back", Pattern.CASE_INSENSITIVE));
        patternsOfCollectionMenu.add(Pattern.compile("show", Pattern.CASE_INSENSITIVE));
        patternsOfCollectionMenu.add(Pattern.compile("search (\\w+)", Pattern.CASE_INSENSITIVE));
        patternsOfCollectionMenu.add(Pattern.compile("save", Pattern.CASE_INSENSITIVE));
        patternsOfCollectionMenu.add(Pattern.compile("create deck (\\w+)", Pattern.CASE_INSENSITIVE));
        patternsOfCollectionMenu.add(Pattern.compile("delete deck (\\w+)", Pattern.CASE_INSENSITIVE));
        patternsOfCollectionMenu.add(Pattern.compile("add (\\w+) to deck (\\w+)", Pattern.CASE_INSENSITIVE));
        patternsOfCollectionMenu.add(Pattern.compile("remove (\\w+) from deck (\\w+)", Pattern.CASE_INSENSITIVE));
        patternsOfCollectionMenu.add(Pattern.compile("validate deck (\\w+)", Pattern.CASE_INSENSITIVE));
        patternsOfCollectionMenu.add(Pattern.compile("select deck (\\w+)", Pattern.CASE_INSENSITIVE));
        patternsOfCollectionMenu.add(Pattern.compile("show all decks", Pattern.CASE_INSENSITIVE));
        patternsOfCollectionMenu.add(Pattern.compile("show deck (\\w+)", Pattern.CASE_INSENSITIVE));
        patternsOfCollectionMenu.add(Pattern.compile("help", Pattern.CASE_INSENSITIVE));

        patternsOfShopMenu.add(Pattern.compile("back", Pattern.CASE_INSENSITIVE));
        patternsOfShopMenu.add(Pattern.compile("show collection", Pattern.CASE_INSENSITIVE));
        patternsOfShopMenu.add(Pattern.compile("search (\\w+)", Pattern.CASE_INSENSITIVE));
        patternsOfShopMenu.add(Pattern.compile("search collection (\\w+)", Pattern.CASE_INSENSITIVE));
        patternsOfShopMenu.add(Pattern.compile("buy (\\w+)", Pattern.CASE_INSENSITIVE));
        patternsOfShopMenu.add(Pattern.compile("sell (\\w+)", Pattern.CASE_INSENSITIVE));
        patternsOfShopMenu.add(Pattern.compile("show", Pattern.CASE_INSENSITIVE));
        patternsOfShopMenu.add(Pattern.compile("help", Pattern.CASE_INSENSITIVE));

        patternsOfBattleMenu.add(Pattern.compile("Game info", Pattern.CASE_INSENSITIVE));
        patternsOfBattleMenu.add(Pattern.compile("Show my minions", Pattern.CASE_INSENSITIVE));
        patternsOfBattleMenu.add(Pattern.compile("Show opponent minions", Pattern.CASE_INSENSITIVE));
        patternsOfBattleMenu.add(Pattern.compile("Show card info (\\w+)", Pattern.CASE_INSENSITIVE));
        //use select for both cards and collectable items
        patternsOfBattleMenu.add(Pattern.compile("Select (\\w+)", Pattern.CASE_INSENSITIVE));
        patternsOfBattleMenu.add(Pattern.compile("Move to \\((\\d+),\\s+(\\d+)\\)", Pattern.CASE_INSENSITIVE));
        patternsOfBattleMenu.add(Pattern.compile("Attack (\\w+)", Pattern.CASE_INSENSITIVE));
        patternsOfBattleMenu.add(Pattern.compile("Attack combo (\\w+) ([\\w\\s]+)", Pattern.CASE_INSENSITIVE));
        patternsOfBattleMenu.add(Pattern.compile("Use special power \\((\\d+),\\s+(\\d+)\\)", Pattern.CASE_INSENSITIVE));
        patternsOfBattleMenu.add(Pattern.compile("Show hand", Pattern.CASE_INSENSITIVE));
        patternsOfBattleMenu.add(Pattern.compile("Insert (\\w+) in \\((\\d+),\\s+(\\d+)\\)", Pattern.CASE_INSENSITIVE));
        patternsOfBattleMenu.add(Pattern.compile("End turn", Pattern.CASE_INSENSITIVE));
        patternsOfBattleMenu.add(Pattern.compile("Show collectables", Pattern.CASE_INSENSITIVE));
        //use show info for both collectable items and grave yard menu
        patternsOfBattleMenu.add(Pattern.compile("Show info", Pattern.CASE_INSENSITIVE));
        patternsOfBattleMenu.add(Pattern.compile("Use location \\((\\d+),\\s+(\\d+)\\)", Pattern.CASE_INSENSITIVE));
        patternsOfBattleMenu.add(Pattern.compile("Show next card", Pattern.CASE_INSENSITIVE));
        patternsOfBattleMenu.add(Pattern.compile("Enter graveyard", Pattern.CASE_INSENSITIVE));
        patternsOfBattleMenu.add(Pattern.compile("Show cards", Pattern.CASE_INSENSITIVE));
    }

    public static ArrayList<Pattern> getPatterns() {
        switch (getMenu()) {
            case MAIN:
                return patternsOfMainMenu;
            case SHOP:
                return patternsOfShopMenu;
            case BATTLE:
                return patternsOfBattleMenu;
            case ACCOUNT:
                return patternsOfAccountMenu;
            case COLLECTION:
                return patternsOfCollectionMenu;
            default:
                return patternsOfAccountMenu;
        }
    }

    public static void setMenu(String menuName) {
        switch (menuName.toLowerCase()) {
            case "main":
                setMenu(Enums.Menus.MAIN);
                break;
            case "battle":
                setMenu(Enums.Menus.BATTLE);
                break;
            case "shop":
                setMenu(Enums.Menus.SHOP);
                break;
            case "collection":
                setMenu(Enums.Menus.COLLECTION);
                break;
            case "account":
                setMenu(Enums.Menus.ACCOUNT);
                break;
        }
    }

    public static void start() {
        setStartGame();
        setMenu(Enums.Menus.ACCOUNT);
        setPatterns();
        setScanner();
        Resources.setResources();
        View.showMenu();
        while (!isEndedGame()) {
            View.showNameOfMenu();
            setCommand();
            doCommand();
        }
    }

    public static void setScanner() {
        scanner = new Scanner(System.in);
    }

    public static void setCommand() {
        command = scanner.nextLine();
    }

    public static String getCommand() {
        return command;
    }

    public static int getIndexCommand() throws InvalidCommandException {
        int i = 0;
        for (Pattern pattern : getPatterns()) {
            Matcher matcher = pattern.matcher(getCommand().trim());
            if (matcher.matches())
                return i;
            i++;
        }
        throw new InvalidCommandException();
    }

    public static String getNextLine() {
        return Controller.getScanner().nextLine();
    }

    public static void doCommand() {
        try {
            int index = Controller.getIndexCommand();
            switch (getMenu()) {
                case MAIN:
                    doMainMenuCommand(index);
                    break;
                case ACCOUNT:
                    doAccountMenuCommand(index);
                    break;
                case BATTLE:
                    doBattleMenuCommand(index);
                    break;
                case SHOP:
                    doShopMenuCommand(index);
                    break;
                case COLLECTION:
                    doCollectionMenuCommand(index);
                    break;
            }
        } catch (InvalidCommandException e) {
            e.showMessage();
        } catch (NullPointerException e) {
            System.err.println("ddd");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

    public static void doMainMenuCommand(int index) {
        Pattern pattern = getPatterns().get(index);
        Matcher matcher = pattern.matcher(getCommand().trim());
        matcher.matches();
        switch (index) {
            case 0:
                Controller.setMenu(matcher.group(1));
                break;
            case 1:
                Account.logOut();
                break;
            case 2:
                Controller.setEndGame();
                break;
            case 3:
                View.showHelp();
                break;
        }
    }


    public static void doAccountMenuCommand(int index) throws Exception {
        Pattern pattern = getPatterns().get(index);
        Matcher matcher = pattern.matcher(getCommand().trim());
        matcher.matches();
        switch (index) {
            case 0:
                Account.createAccount(matcher.group(1));
                break;
            case 1:
                Account.login(matcher.group(1));
                break;
            case 2:
                Account.showLeaderBoard();
                break;
            case 3:
                Account.saveChanges();
                break;
            case 4:
                View.showHelp();
                break;
            case 5:
                Controller.setEndGame();
                break;
        }
    }

    public static void doBattleMenuCommand(int index) throws Exception {
        Pattern pattern = getPatterns().get(index);
        Matcher matcher = pattern.matcher(getCommand().trim());
        matcher.matches();

    }

    public static void doCollectionMenuCommand(int index) throws Exception {
        Pattern pattern = getPatterns().get(index);
        Matcher matcher = pattern.matcher(getCommand().trim());
        matcher.matches();
        switch (index) {
            case 0:
                Controller.setMenu(Enums.Menus.MAIN);
                break;
            case 1:
                View.showAllCardsInCollection();
                break;
            case 2:
                View.showSearchResultsInCollection(matcher.group(1));
                break;
            case 3:
                Account.saveChanges();
                break;
            case 4:
                Account.getCurrentAccount().getCollection().addDeck(matcher.group(1));
                break;
            case 5:
                Account.getCurrentAccount().getCollection().removeDeck(matcher.group(1));
                break;
            case 6:
                Account.getCurrentAccount().getCollection().addThingToDeck(matcher.group(1), matcher.group(2));
                break;
            case 7:
                Account.getCurrentAccount().getCollection().removeCard(matcher.group(1), matcher.group(2));
                break;
            case 8:
                View.showValidateDeckMessage(matcher.group(1));
                break;
            case 9:
                Account.getCurrentAccount().selectDeck(matcher.group(1));
                break;
            case 10:
                View.showAllDecks();
                break;
            case 11:
                View.showDeck(matcher.group(1));
                break;
            case 12:
                View.showHelp();
                break;
        }
    }

    public static void doShopMenuCommand(int index) throws Exception {
        Pattern pattern = getPatterns().get(index);
        Matcher matcher = pattern.matcher(getCommand().trim());
        matcher.matches();
        switch (index){
            case 0:
                Controller.setMenu(Enums.Menus.MAIN);
                break;
            case 1:
                View.showAllCardsInCollection();
                break;
            case 2:
                View.showSearchResultsInShop(matcher.group(1));
                break;
            case 3:
                View.showSearchResultsInCollection(matcher.group(1));
                break;
            case 4:
                Shop.buyThing(matcher.group(1));
                break;
            case 5:
                Shop.sellThing(matcher.group(1));
                break;
            case 6:
                View.showShop();
                break;
            case 7:
                View.showHelp();
                break;
        }
    }

    public static Scanner getScanner() {
        return scanner;
    }

    public static Enums.Menus getMenu() {
        return menu;
    }

    public static Boolean getYesOrNo() {
        String yOrN = Controller.getNextLine();
        return (yOrN.equals("Y"));
    }

    public static void setMenu(Enums.Menus menu) {
        Controller.menu = menu;
    }

    public static Boolean isEndedGame() {
        return isEndedGame;
    }

    public static void setEndGame() {
        View.showConfirmationExitMessage();
        if (Controller.getYesOrNo()) {
            Controller.isEndedGame = true;
        }
    }

    public static void setStartGame() {
        Controller.isEndedGame = false;
    }

}

