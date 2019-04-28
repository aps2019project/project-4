
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
        patternsOfAccountMenu.add(Pattern.compile("create account ([a-zA-Z0-9]+)", Pattern.CASE_INSENSITIVE));
        patternsOfAccountMenu.add(Pattern.compile("login ([a-zA-Z0-9]+)", Pattern.CASE_INSENSITIVE));
        patternsOfAccountMenu.add(Pattern.compile("show leaderboard", Pattern.CASE_INSENSITIVE));
        patternsOfAccountMenu.add(Pattern.compile("save", Pattern.CASE_INSENSITIVE));
        patternsOfAccountMenu.add(Pattern.compile("help", Pattern.CASE_INSENSITIVE));
        patternsOfAccountMenu.add(Pattern.compile("exit", Pattern.CASE_INSENSITIVE));
        patternsOfMainMenu.add(Pattern.compile("enter (Collection|Shop|Battle|Exit|Help)", Pattern.CASE_INSENSITIVE));
        patternsOfMainMenu.add(Pattern.compile("logout", Pattern.CASE_INSENSITIVE));
        patternsOfMainMenu.add(Pattern.compile("exit", Pattern.CASE_INSENSITIVE));
        patternsOfMainMenu.add(Pattern.compile("battle", Pattern.CASE_INSENSITIVE));
        patternsOfMainMenu.add(Pattern.compile("help", Pattern.CASE_INSENSITIVE));
        patternsOfCollectionMenu.add(Pattern.compile("exit", Pattern.CASE_INSENSITIVE));
        patternsOfCollectionMenu.add(Pattern.compile("show", Pattern.CASE_INSENSITIVE));
        patternsOfCollectionMenu.add(Pattern.compile("search ([a-zA-Z0-9]+)", Pattern.CASE_INSENSITIVE));
        patternsOfCollectionMenu.add(Pattern.compile("save", Pattern.CASE_INSENSITIVE));
        patternsOfCollectionMenu.add(Pattern.compile("create deck ([a-zA-Z0-9]+)", Pattern.CASE_INSENSITIVE));
        patternsOfCollectionMenu.add(Pattern.compile("delete deck ([a-zA-Z0-9]+)", Pattern.CASE_INSENSITIVE));
        patternsOfShopMenu.add(Pattern.compile("xxx"));


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
        }
    }

    public static void start() {
        setStartGame();
        setMenu(Enums.Menus.ACCOUNT);
        setPatterns();
        setScanner();
        while (!isEndedGame()) {
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
            if (matcher.find())
                return i;
            i++;
        }
        throw new InvalidCommandException();
    }

    public static void doCommand() {
        try {
            int index = Controller.getIndexCommand();
            switch (getMenu()) {
                case MAIN:
                    doMainMenuCommand(index);
                case ACCOUNT:
                    doAccountMenuCommand(index);
                case BATTLE:
                    doBattleMenuCommand(index);
                case SHOP:
                    doShopMenuCommand(index);
                case COLLECTION:
                    doCollectionMenuCommand(index);
            }
        } catch (InvalidCommandException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void doMainMenuCommand(int index) {
        Pattern pattern = getPatterns().get(index);
        Matcher matcher = pattern.matcher(getCommand().trim());
        matcher.find();

    }

    public static void doAccountMenuCommand(int index) {
        Pattern pattern = getPatterns().get(index);
        Matcher matcher = pattern.matcher(getCommand().trim());
        matcher.find();
        switch (index) {
            case 0:
                System.out.println("matched with createAccount");
                Account.createAccount(matcher.group(1));
                break;
            case 1:
                Account.login(matcher.group(1));
                break;
            case 2:
                Account.showLeaderBoard();
                break;
            case 3:
                //toDo write save command
            case 4:
                View.showHelp();
                break;
            case 5:
                Controller.setEndGame();
                break;
        }
    }

    public static void doBattleMenuCommand(int index) {
        Pattern pattern = getPatterns().get(index);
        Matcher matcher = pattern.matcher(getCommand().trim());
        matcher.find();

    }

    public static void doCollectionMenuCommand(int index) {
        Pattern pattern = getPatterns().get(index);
        Matcher matcher = pattern.matcher(getCommand().trim());
        matcher.find();

    }

    public static void doShopMenuCommand(int index) {
        Pattern pattern = getPatterns().get(index);
        Matcher matcher = pattern.matcher(getCommand().trim());
        matcher.find();

    }

    public static Scanner getScanner() {
        return scanner;
    }

    public static Enums.Menus getMenu() {
        return menu;
    }

    public static void setMenu(Enums.Menus menu) {
        Controller.menu = menu;
    }

    public static Boolean isEndedGame() {
        return isEndedGame;
    }

    public static void setEndGame() {
        Controller.isEndedGame = true;
    }

    public static void setStartGame() {
        Controller.isEndedGame = false;
    }

    public static void showMainMenu() {

    }

    public static void showShopMenu() {

    }

    public static void showCollectionMenu() {

    }
}

