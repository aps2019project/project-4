import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class controller {
    public enum Menu {
        ACCOUNT, MAIN, BATTLE, SHOP, COLLECTION
    }

    private static String command;
    private static Scanner scanner;
    private static Menu menu;
    private static Boolean isEndedGame;
    private final static ArrayList<Pattern> patternsOfAccountMenu = new ArrayList<>();
    private final static ArrayList<Pattern> patternsOfMainMenu = new ArrayList<>();
    private final static ArrayList<Pattern> patternsOfCollectionMenu = new ArrayList<>();
    private final static ArrayList<Pattern> patternsOfShopMenu = new ArrayList<>();
    private final static ArrayList<Pattern> patternsOfBattleMenu = new ArrayList<>();

    public static void setPatterns() {
        patternsOfAccountMenu.add(Pattern.compile("create account ([a-zA-Z0-9]+)"));
        patternsOfAccountMenu.add(Pattern.compile("login ([a-zA-Z0-9]+)"));
        patternsOfAccountMenu.add(Pattern.compile("show leaderboard"));
        patternsOfAccountMenu.add(Pattern.compile("save"));
        patternsOfAccountMenu.add(Pattern.compile("help"));
        patternsOfAccountMenu.add(Pattern.compile("exit"));
        patternsOfMainMenu.add(Pattern.compile("enter (Collection | Shop | Battle | Exit | Help)"));
        patternsOfMainMenu.add(Pattern.compile("logout"));
        patternsOfMainMenu.add(Pattern.compile("exit"));
        patternsOfMainMenu.add(Pattern.compile("battle"));
        patternsOfMainMenu.add(Pattern.compile("help"));
        patternsOfCollectionMenu.add(Pattern.compile("exit"));
        patternsOfCollectionMenu.add(Pattern.compile("show"));
        patternsOfCollectionMenu.add(Pattern.compile("search ([a-zA-Z0-9]+)"));
        patternsOfCollectionMenu.add(Pattern.compile("save"));
        patternsOfCollectionMenu.add(Pattern.compile("create deck ([a-zA-Z0-9]+)"));
        patternsOfCollectionMenu.add(Pattern.compile("delete deck ([a-zA-Z0-9]+)"));
    }

    public static ArrayList<Pattern> getPattern(){
        switch (getMenu()){
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
                return null;
        }
    }

    public static void setMenu(String menuName) {
        switch (menuName.toLowerCase()) {
            case "main":
                setMenu(Menu.MAIN);
            case "battle":
                setMenu(Menu.BATTLE);
            case "shop":
                setMenu(Menu.SHOP);
            case "collection":
                setMenu(Menu.COLLECTION);
            case "account":
                setMenu(Menu.ACCOUNT);
        }
    }

    public static void start() {
        setStartGame();
        setMenu(Menu.ACCOUNT);
        scanner = new Scanner(System.in);
        setPatterns();
        while (isEndedGame()) {
            setCommand();
            doCommand();
        }
    }

    public static void setCommand(){
        command = scanner.nextLine();
    }

    public static String getCommand() {
        return command;
    }

    public static Pattern checkCommand() {

    }

    public static void doCommand() {

    }

    public static Scanner getScanner(){
        return scanner;
    }

    public static Menu getMenu() {
        return menu;
    }

    public static void setMenu(Menu menu) {
        controller.menu = menu;
    }

    public static Boolean isEndedGame() {
        return isEndedGame;
    }

    public static void setEndGame() {
        controller.isEndedGame = true;
    }

    public static void setStartGame() {
        controller.isEndedGame = false;
    }

    public static void showMainMenu() {

    }

    public static void showShopMenu() {

    }

    public static void showCollectionMenu() {

    }
}

