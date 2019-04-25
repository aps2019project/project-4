import java.util.ArrayList;
import java.util.regex.Pattern;

public class CommandLine {
    public enum Menu {
        ACCOUNT, MAIN, BATTLE, SHOP, COLLECTION;

        Menu() {
        }
    }

    private String command;
    private static Menu menu = Menu.ACCOUNT;
    private final static ArrayList<Pattern> patternsOfAccountMenu = new ArrayList<>();
    private static ArrayList<Pattern> patternsOfMainMenu = new ArrayList<>();
    private static ArrayList<Pattern> patternsOfCollectionMenu = new ArrayList<>();
    private static ArrayList<Pattern> patternsOfShopMenu = new ArrayList<>();
    private static ArrayList<Pattern> patternsOfBattleMenu = new ArrayList<>();

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

    public CommandLine() {
    }

    public String getCommand() {
        return this.command;
    }

    public void checkCommand() {

    }

    public void setCommand(String command) {
        this.command = command;
    }

    public static Menu getMenu() {
        return menu;
    }

    public static void changeMenu(String menuName) {
        switch (menuName.toLowerCase()) {
            case "main":
                menu = Menu.MAIN;
            case "battle":
                menu = Menu.BATTLE;
            case "shop":
                menu = Menu.SHOP;
            case "collection":
                menu = Menu.COLLECTION;
            case "account":
                menu = Menu.ACCOUNT;
        }
    }

    public static void showMainMenu() {

    }

    public static void showShopMenu() {

    }

    public static void showCollectionMenu() {

    }
}

