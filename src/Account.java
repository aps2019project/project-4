import java.util.ArrayList;
import java.util.HashMap;

public class Account {

    private static HashMap<String, Account> accounts = new HashMap<>();
    private static Account currentAccount = null;
    private String name;
    private String password;
    private int money;
    private ArrayList<Deck> decks;
    private Deck selectedDeck;
    private ArrayList<Match> matchHistory;
    private Collection collection;

    public Account(String name, String password) {
        this.name = name;
        this.password = password;
        this.money = 0;
        this.decks = new ArrayList<>();
        this.selectedDeck = null;
        this.matchHistory = new ArrayList<>();
        this.collection = null;
    }
    public String getName() {
        return this.name;
    }

    public String getPassword() {
        return this.password;
    }

    public int getMoney() {
        return this.money;
    }

    public ArrayList<Match> getMatchHistory() {
        return matchHistory;
    }

    public ArrayList<Deck> getDecks() {
        return decks;
    }

    public Deck getSelectedDeck() {
        return selectedDeck;
    }

    public Collection getCollection() {
        return collection;
    }

    public static HashMap<String, Account> getAccounts() {
        return accounts;
    }

    public static Account getCurrentAccount() {
        return currentAccount;
    }

    public static void setCurrentAccount(Account currentAccount) {
        Account.currentAccount = currentAccount;
    }

    public static void showLeaderBoard() {

    }

    public static void createAccount(String userName){
        if (Account.getAccounts().containsKey(userName)){
            System.out.println("The with this name exists!\n");
            return;
        }
        String password = Main.scanner.nextLine();
        Account.getAccounts().put(userName , new Account(userName , password));
        System.out.println("The account with name " + userName + " created!\n");
    }

    public static void login (String userName){
        if (currentAccount != null) {
            return;
        }
        if (!accounts.containsKey(userName)){
            System.out.println("User name is invalid");
            return;
        }
        System.out.println("Inter Password");
        String password = Main.scanner.nextLine();
        if (!accounts.get(userName).getPassword().equals(password)){
            System.out.println("Invalid password");
            return;
        }
        setCurrentAccount(accounts.get(userName));
    }

    public Account searchAccount(String name) {
        return accounts.get(name);
    }

    public void changeMoney(int change) {
        this.money += change;
    }

    public void showMatchHistory() {
        this.getMatchHistory().forEach(match -> System.out.println(match.toString()));
    }

}
