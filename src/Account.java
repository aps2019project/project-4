import java.util.ArrayList;
import java.util.HashMap;

public class Account {
    private static HashMap<String , Account> accounts = new HashMap<>();
    private String name;
    private String password;
    private int money;
    private ArrayList<Deck> decks;
    private Deck selectedDeck;
    private ArrayList<Match> matchHistory;
    private Collection collection;

    public Account(String name , String password){
        this.name = name;
        this.password = password;
        this.money = 0;
        this.decks = new ArrayList<>();
        this.selectedDeck = null;
        this.matchHistory = new ArrayList<>();
        this.collection = null;
        accounts.put(name , this);
    }

    public static HashMap<String, Account> getAccounts() {
        return accounts;
    }

    public static void showLeaderBoard(){

    }

    public String getName(){
        return this.name;
    }

    public String getPassword(){
        return this.password;
    }

    public int getMoney(){
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

    public Account searchAccount (String name){
        return accounts.get(name);
    }

    public void changeMoney (int change){
        this.money += change;
    }

    public void showMatchHistory (){
        this.getMatchHistory().forEach(match -> System.out.println(match.toString()));
    }
}
