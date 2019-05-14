package controller;

import model.*;
import resources.StageResources;
import views.View;
import views.Exceptions.*;
import resources.Resources;

import java.util.ArrayList;
import java.util.Collections;
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
    private final static ArrayList<Pattern> patternsOfGraveyardMenu = new ArrayList<>();

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
        patternsOfMainMenu.add(Pattern.compile("money", Pattern.CASE_INSENSITIVE));
        patternsOfMainMenu.add(Pattern.compile("show match history", Pattern.CASE_INSENSITIVE));

        patternsOfCollectionMenu.add(Pattern.compile("back", Pattern.CASE_INSENSITIVE));
        patternsOfCollectionMenu.add(Pattern.compile("show", Pattern.CASE_INSENSITIVE));
        patternsOfCollectionMenu.add(Pattern.compile("search ((\\w+ ?\\w*))", Pattern.CASE_INSENSITIVE));
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
        patternsOfShopMenu.add(Pattern.compile("search collection (\\w+ ?\\w*)", Pattern.CASE_INSENSITIVE));
        patternsOfShopMenu.add(Pattern.compile("search (\\w+ ?\\w*)", Pattern.CASE_INSENSITIVE));
        patternsOfShopMenu.add(Pattern.compile("buy (\\w+ ?\\w*)", Pattern.CASE_INSENSITIVE));
        patternsOfShopMenu.add(Pattern.compile("sell (\\w+)", Pattern.CASE_INSENSITIVE));
        patternsOfShopMenu.add(Pattern.compile("show", Pattern.CASE_INSENSITIVE));
        patternsOfShopMenu.add(Pattern.compile("money", Pattern.CASE_INSENSITIVE));
        patternsOfShopMenu.add(Pattern.compile("help", Pattern.CASE_INSENSITIVE));

        patternsOfBattleMenu.add(Pattern.compile("Game info", Pattern.CASE_INSENSITIVE));
        patternsOfBattleMenu.add(Pattern.compile("Show my minions", Pattern.CASE_INSENSITIVE));
        patternsOfBattleMenu.add(Pattern.compile("Show opponent minions", Pattern.CASE_INSENSITIVE));
        patternsOfBattleMenu.add(Pattern.compile("Show card info (\\w+)", Pattern.CASE_INSENSITIVE));
        //use select for both cards and collectable items
        patternsOfBattleMenu.add(Pattern.compile("Select (\\w+)", Pattern.CASE_INSENSITIVE));
        patternsOfBattleMenu.add(Pattern.compile("Move to (\\d+),\\s+(\\d+)", Pattern.CASE_INSENSITIVE));
        patternsOfBattleMenu.add(Pattern.compile("Attack (\\d+),\\s+(\\d+)", Pattern.CASE_INSENSITIVE));
        patternsOfBattleMenu.add(Pattern.compile("Attack combo (\\d+),\\s+(\\d+) ([\\w+\\s]* \\w+)", Pattern.CASE_INSENSITIVE));
        patternsOfBattleMenu.add(Pattern.compile("Use special power (\\d+),\\s+(\\d+)", Pattern.CASE_INSENSITIVE));
        patternsOfBattleMenu.add(Pattern.compile("Show hand", Pattern.CASE_INSENSITIVE));
        patternsOfBattleMenu.add(Pattern.compile("Insert (\\w+) in (\\d+),\\s+(\\d+)", Pattern.CASE_INSENSITIVE));
        patternsOfBattleMenu.add(Pattern.compile("End turn", Pattern.CASE_INSENSITIVE));
        patternsOfBattleMenu.add(Pattern.compile("Show collectables", Pattern.CASE_INSENSITIVE));
        patternsOfBattleMenu.add(Pattern.compile("Show info", Pattern.CASE_INSENSITIVE));
        patternsOfBattleMenu.add(Pattern.compile("Use location (\\d+),\\s+(\\d+)", Pattern.CASE_INSENSITIVE));
        patternsOfBattleMenu.add(Pattern.compile("Show next card", Pattern.CASE_INSENSITIVE));
        patternsOfBattleMenu.add(Pattern.compile("Enter graveyard", Pattern.CASE_INSENSITIVE));
        patternsOfBattleMenu.add(Pattern.compile("show Help", Pattern.CASE_INSENSITIVE));
        patternsOfBattleMenu.add(Pattern.compile("Help", Pattern.CASE_INSENSITIVE));

        patternsOfGraveyardMenu.add(Pattern.compile("Show info (\\w+)", Pattern.CASE_INSENSITIVE));
        patternsOfGraveyardMenu.add(Pattern.compile("Show cards", Pattern.CASE_INSENSITIVE));
        patternsOfGraveyardMenu.add(Pattern.compile("back", Pattern.CASE_INSENSITIVE));
        patternsOfGraveyardMenu.add(Pattern.compile("show Help", Pattern.CASE_INSENSITIVE));

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
            case GRAVEYARD:
                return patternsOfGraveyardMenu;
            default:
                return patternsOfAccountMenu;
        }
    }

    public static void setMenu(String menuName) throws Exception {
        switch (menuName.toLowerCase()) {
            case "main":
                setMenu(Enums.Menus.MAIN);
                break;
            case "battle":
                getBattleConditions();
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
            case "graveyard":
                setMenu(Enums.Menus.GRAVEYARD);
        }
    }

    public static void getBattleConditions() throws Exception {
        if (Account.getCurrentAccount().getSelectedDeck() == null)
            throw new NoDeckSelectedException();
        if (!Account.getCurrentAccount().getSelectedDeck().validateDeck())
            throw new SelectedDeckInvalidException();
        Player player1 = new Player(Account.getCurrentAccount().getName(), Account.getCurrentAccount().getSelectedDeck());
        new Battle(player1);
        Account.getCurrentAccount().getCurrentBattle().setReward(1000);
        while (true) {
            View.showSingleOrMultiPlayerMenu();
            String str = Controller.getNextLine();
            try {
                if (str.toLowerCase().equals("single player")) {
                    Account.getCurrentAccount().getCurrentBattle().setOpponent(Enums.SingleOrMulti.SINGLE_PLAYER);
                    handleSinglePlayerGameStart();
                    break;
                }
                if (str.toLowerCase().equals("multi player")) {
                    Account.getCurrentAccount().getCurrentBattle().setOpponent(Enums.SingleOrMulti.MULTI_PLAYER);
                    handleMultiPlayerGameStart();
                    break;
                }
                throw new InvalidCommandException();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }

    private static void handleMultiPlayerGameStart() {
        Pattern pattern = Pattern.compile("Select user (\\w+)", Pattern.CASE_INSENSITIVE);
        Matcher matcher;
        while (true) {
            View.showAllUsers();
            String command = Controller.getNextLine();
            matcher = pattern.matcher(command);
            try {
                if (!matcher.matches())
                    throw new InvalidCommandException();
                Account account = Account.getAccounts().get(matcher.group(1));
                if (account == null)
                    throw new InvalidUserNameException();
                if (account.getSelectedDeck() == null)
                    throw new UserDeckInvalidException(account.getName());
                Account.getCurrentAccount().getCurrentBattle().setPlayer2(new Player(account.getName(), account.getSelectedDeck()));
                handleMultiPlayerSelectMode();
                break;
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }

    private static void handleSinglePlayerGameStart() {
        while (true) {
            try {
                View.showSelectTypeOfGameMenu();
                String command = Controller.getNextLine();
                if (command.equals("story")) {
                    handleStageSelecting();
                    break;
                }
                if (command.toLowerCase().equals("custom game")) {
                    handleCustomGameStart();
                    break;
                }
                throw new InvalidCommandException();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }

    private static void handleStageSelecting() {
        while (true) {
            View.showSelectStageMenu();
            String stage = Controller.getNextLine();
            try {
                if (stage.toLowerCase().equals("stage 1")) {
                    AIPlayer player = new AIPlayer("stage 1", StageResources.getStage(0).getDeck());
                    player.setStage(1);
                    Account.getCurrentAccount().getCurrentBattle().setPlayer2(player);
                    Account.getCurrentAccount().getCurrentBattle().setGameMode(Enums.GameMode.HERO_VS_HERO);
                    Account.getCurrentAccount().getCurrentBattle().setReward(500);
                    return;
                }
                if (stage.toLowerCase().equals("stage 2")) {
                    AIPlayer player = new AIPlayer("stage 2", StageResources.getStage(1).getDeck());
                    player.setStage(2);
                    Account.getCurrentAccount().getCurrentBattle().setPlayer2(player);
                    Account.getCurrentAccount().getCurrentBattle().setGameMode(Enums.GameMode.MONO_FLAG);
                    Account.getCurrentAccount().getCurrentBattle().getGameBoard().setOneFlag();
                    return;
                }
                if (stage.toLowerCase().equals("stage 3")) {
                    AIPlayer player = new AIPlayer("stage 3", StageResources.getStage(2).getDeck());
                    player.setStage(3);
                    Account.getCurrentAccount().getCurrentBattle().setPlayer2(player);
                    Account.getCurrentAccount().getCurrentBattle().setGameMode(Enums.GameMode.MULTIPLE_FLAG);
                    Account.getCurrentAccount().getCurrentBattle().setReward(1500);
                    return;
                }
                throw new InvalidCommandException();
            } catch (InvalidCommandException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    private static void handleCustomGameStart() {
        Pattern pattern1 = Pattern.compile("Start game (\\w+) 3 ([2-9])", Pattern.CASE_INSENSITIVE);
        Pattern pattern2 = Pattern.compile("Start game (\\w+) ([1-3])", Pattern.CASE_INSENSITIVE);
        Matcher matcher1;
        Matcher matcher2;
        while (true) {
            View.showSelectDeckMethod();
            String startGameCommand = Controller.getNextLine().toLowerCase();
            try {
                matcher1 = pattern1.matcher(startGameCommand);
                matcher2 = pattern2.matcher(startGameCommand);
                if (!matcher1.find() && !matcher2.find())
                    throw new InvalidCommandException();
                if (matcher1.matches()) {
                    if (Account.getCurrentAccount().getCollection().getValidDecks().get(matcher1.group(1)) == null)
                        throw new DeckNotAvailabilityException(matcher1.group(1), true);
                    Account.getCurrentAccount().getCurrentBattle().setPlayer2(new AIPlayer("Custom game with deck " + matcher1.group(1),
                            Account.getCurrentAccount().getCollection().getValidDecks().get(matcher1.group(1)).clone()));
                    Account.getCurrentAccount().getCurrentBattle().setGameMode(Enums.GameMode.MULTIPLE_FLAG);
                    Account.getCurrentAccount().getCurrentBattle().setNumOfAllFlags(Integer.parseInt(matcher1.group(2).trim()));
                    break;
                }
                if (matcher2.matches()) {
                    if (Account.getCurrentAccount().getCollection().getValidDecks().get(matcher2.group(1)) == null)
                        throw new DeckNotAvailabilityException(matcher2.group(1), true);
                    Account.getCurrentAccount().getCurrentBattle().setPlayer2(new AIPlayer("Custom game with deck " + matcher2.group(1),
                            Account.getCurrentAccount().getCollection().getValidDecks().get(matcher2.group(1)).clone()));
                    switch (matcher2.group(2)) {
                        case "1":
                            Account.getCurrentAccount().getCurrentBattle().setGameMode(Enums.GameMode.HERO_VS_HERO);
                            break;
                        case "2":
                            Account.getCurrentAccount().getCurrentBattle().setGameMode(Enums.GameMode.MONO_FLAG);
                            Account.getCurrentAccount().getCurrentBattle().getGameBoard().setOneFlag();
                            break;
                        case "3":
                            Account.getCurrentAccount().getCurrentBattle().setGameMode(Enums.GameMode.MULTIPLE_FLAG);
                            Account.getCurrentAccount().getCurrentBattle().setNumOfAllFlags(7);
                    }
                    break;
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public static void handleMultiPlayerSelectMode() {
        Pattern pattern1 = Pattern.compile("Start multi-player game 3 ([2-9])", Pattern.CASE_INSENSITIVE);
        Pattern pattern2 = Pattern.compile("Start multi-player game ([1-3])", Pattern.CASE_INSENSITIVE);
        Matcher matcher1;
        Matcher matcher2;
        while (true) {
            View.showMultiPlayerSelectModeCommand();
            String command = Controller.getNextLine().trim();
            matcher1 = pattern1.matcher(command);
            matcher2 = pattern2.matcher(command);
            try {
                if (matcher2.matches()) {
                    switch (matcher2.group(1)) {
                        case "1":
                            Account.getCurrentAccount().getCurrentBattle().setGameMode(Enums.GameMode.HERO_VS_HERO);
                            break;
                        case "2":
                            Account.getCurrentAccount().getCurrentBattle().setGameMode(Enums.GameMode.MONO_FLAG);
                            Account.getCurrentAccount().getCurrentBattle().getGameBoard().setOneFlag();
                            break;
                        case "3":
                            Account.getCurrentAccount().getCurrentBattle().setGameMode(Enums.GameMode.MULTIPLE_FLAG);
                            Account.getCurrentAccount().getCurrentBattle().setNumOfAllFlags(7);
                            break;
                    }
                    break;
                }
                if (matcher1.matches()) {
                    Account.getCurrentAccount().getCurrentBattle().setGameMode(Enums.GameMode.MULTIPLE_FLAG);
                    Account.getCurrentAccount().getCurrentBattle().setNumOfAllFlags(Integer.parseInt(matcher1.group(1).trim()));
                    break;
                }
                throw new InvalidCommandException();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
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
        return Controller.getScanner().nextLine().trim().replaceAll("\\s+", " ");
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
                case GRAVEYARD:
                    doGraveYardMenuCommand(index);
            }
        } catch (InvalidCommandException e) {
            e.showMessage();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

    public static void doMainMenuCommand(int index) throws Exception {
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
            case 4:
                View.showMoney();
            case 5:
                View.showMacthHistory();
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

    public static void enterEndBattleMenu(Battle battle) {
        if (battle.getWinner() == null)
            View.showDrawBattleMenu(battle);
        else
            View.showEndBattleMenu(battle);
        while (true) {
            System.out.println("Enter end game to back to main menu:");
            try {
                String command = Controller.getNextLine();
                if (command.toLowerCase().equals("end game")) {
                    Controller.setMenu(Enums.Menus.MAIN);
                    break;
                } else {
                    throw new InvalidCommandException();
                }
            } catch (InvalidCommandException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public static void doBattleMenuCommand(int index) throws Exception {
        Pattern pattern = getPatterns().get(index);
        Matcher matcher = pattern.matcher(getCommand().trim());
        matcher.matches();
        switch (index) {
            case 0:
                View.showGameInfo();
                break;
            case 1:
                View.showMyMinions();
                break;
            case 2:
                View.showOpponentMinions();
                break;
            case 3:
                View.showCardInfo(matcher.group(1));
                break;
            case 4:
                Account.getCurrentAccount().getCurrentBattle().getWhoseTurn().selectCard(matcher.group(1));
                break;
            case 5:
                Account.getCurrentAccount().getCurrentBattle().moveTo(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)));
                break;
            case 6: {
                Battle battle = Account.getCurrentAccount().getCurrentBattle();
                battle.attack(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)));
            }
            break;
            case 7: {
                Battle battle = Account.getCurrentAccount().getCurrentBattle();
                int x = Integer.parseInt(matcher.group(1));
                int y = Integer.parseInt(matcher.group(2));
                String string = matcher.group(3);
                String[] strings = string.split("\\s+");
                ArrayList<String> stringArrayList = new ArrayList<>();
                Collections.addAll(stringArrayList, strings);
                battle.attackCombo(x, y, stringArrayList);
            }
            break;
            case 8: {
                Battle battle = Account.getCurrentAccount().getCurrentBattle();
                Spell spell = battle.getWhoseTurn().getDeck().getHero().getSpecialPower();
                if (battle.getWhoseTurn().getCardsInGameBoard().getHero().isSpecialPowerActive()) {
                    battle.insertSpell(spell, Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)));
                    battle.getWhoseTurn().getCardsInGameBoard().getHero().setSpecialPowerActive(false);
                }
                else
                    View.showSpecialPowerUsed();
            }
            break;
            case 9:
                View.showHand();
                break;
            case 10:
                Account.getCurrentAccount().getCurrentBattle().insert(matcher.group(1), Integer.parseInt(matcher.group(2)), Integer.parseInt(matcher.group(3)));
                break;
            case 11: {
                Battle battle = Account.getCurrentAccount().getCurrentBattle();
                battle.nextTurn();
            }
            break;
            case 12:
                //todo show collectable items
                break;
            case 13:
                //todo show info of item
                break;
            case 14:
                //todo use from collectable item
                break;
            case 15:
                View.showNextCard();
                break;
            case 16:
                Controller.setMenu(Enums.Menus.GRAVEYARD);
                break;
            case 17:
                View.showHelp();
                break;
            case 18:
                //todo Help
        }
    }

    public static void doGraveYardMenuCommand(int index) throws Exception {
        Pattern pattern = getPatterns().get(index);
        Matcher matcher = pattern.matcher(getCommand().trim());
        matcher.matches();
        switch (index) {
            case 0:
                View.searchInGraveyard(matcher.group(1));
                break;
            case 1:
                View.showGraveyard();
                break;
            case 2:
                Controller.setMenu(Enums.Menus.BATTLE);
                break;
            case 3:
                View.showHelp();
        }
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
                View.showSearchResultsInShop(matcher.group(1));
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
                View.showMoney();
                break;
            case 8:
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
        } else {
            System.out.println("Abort");
        }
    }

    public static void setStartGame() {
        Controller.isEndedGame = false;
    }

}

