import java.util.ArrayList;
import java.util.regex.Pattern;

public class CommandLine {
    public enum Menu {
        MAIN, BATTLE, SHOP , COLLECTION;
        Menu(){
        }
    }

    private String command;
    private static Menu menu = Menu.MAIN;
    private static ArrayList<Pattern> patternsOfMainMeun = new ArrayList<>();
    private static ArrayList<Pattern> patternsOfCollectionMenu = new ArrayList<>();
    private static ArrayList<Pattern> patternsOfShopMeun = new ArrayList<>();
    private static ArrayList<Pattern> patternsOfBattleMeun = new ArrayList<>();

    public CommandLine(String cli) {
        this.command = cli;
    }

    public String getCommand() {
        return this.command;
    }

    public void checkCommand() {

    }

    public static Menu getMenu() {
        return menu;
    }

    public static void changeMenu(String menuName){
        switch (menuName.toLowerCase()){
            case "main":
                menu = Menu.MAIN;
                return;
            case "battle":
                menu = Menu.BATTLE;
                return;
            case "shop":
                menu = Menu.SHOP;
                return;
            case "collection":
                menu = Menu.COLLECTION;
        }
    }

    public static void showMainMenu(){

    }

    public static void showShopMenu(){

    }

    public static void showCollectionMenu(){

    }
}

