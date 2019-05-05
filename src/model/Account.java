package model;

import controller.Controller;
import views.View;
import views.Exceptions.*;

import java.util.ArrayList;
import java.util.HashMap;

public class Account {

    private static HashMap<String, Account> accounts = new HashMap<>();
    private static Account currentAccount = null;
    private String name;
    private String password;
    private int drack;
    private ArrayList<Match> matchHistory;
    private Collection collection;
    private Deck selectedDeck;

    public Account(String name, String password) {
        this.name = name;
        this.password = password;
        this.drack = 0;
        this.matchHistory = new ArrayList<>();
        this.collection = new Collection();
        this.selectedDeck = null;
    }

    public String getName() {
        return this.name;
    }

    public String getPassword() {
        return this.password;
    }

    public int getDrack() {
        return this.drack;
    }

    public void changeDrack(int change){this.drack += change;}

    public ArrayList<Match> getMatchHistory() {
        return matchHistory;
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

    public Deck getSelectedDeck() {
        return selectedDeck;
    }

    public static void setCurrentAccount(Account currentAccount) {
        Account.currentAccount = currentAccount;
    }

    public void setSelectedDeck(Deck deck) {
        this.selectedDeck = deck;
    }

    public static void showLeaderBoard() {
        ArrayList<Account> accounts = new ArrayList<>(getAccounts().values());
        accounts.sort(((a1, a2) -> {
            if (a1.getNumOfWins() != a2.getNumOfWins())
                return Integer.compare(a1.getNumOfWins(), a1.getNumOfWins());
            return a1.getName().compareTo(a2.getName());
        }));
        View.showAccounts(accounts);
    }

    public static void createAccount(String userName) throws DuplicateAccountException {
        if (Account.getAccounts().containsKey(userName))
            throw new DuplicateAccountException(userName);
        View.showEnterPasswordMessage();
        String password = Controller.getScanner().nextLine();
        Account.getAccounts().put(userName, new Account(userName, password));
        View.showSuccessfulAccountCreationMessage(userName);
    }

    public static void login(String userName) throws InvalidPasswordException, InvalidUserNameException {
        try {
            if (!accounts.containsKey(userName))
                throw new InvalidUserNameException();
            View.showEnterPasswordMessage();
            String password = Controller.getNextLine();
            if (!accounts.get(userName).getPassword().equals(password))
                throw new InvalidPasswordException();
        } catch (NullPointerException e) {
            return;
        }
        setCurrentAccount(accounts.get(userName));
        Controller.setMenu(Enums.Menus.MAIN);
        View.showMenu();
    }

    public int getNumOfWins() {
        int numOfWin = 0;
        for (Match match : matchHistory)
            if (match.isWin())
                numOfWin++;
        return numOfWin;
    }

    public int getNumOfLosses() {
        int numOfWin = 0;
        for (Match match : matchHistory)
            if (!match.isWin())
                numOfWin++;
        return numOfWin;
    }

    public static void logOut() {
        if (Controller.getMenu() == Enums.Menus.MAIN) {
            View.showConfirmationLogoutMessage();
            if (Controller.getYesOrNo()) {
                currentAccount = null;
                Controller.setMenu(Enums.Menus.ACCOUNT);
                View.showMenu();
            }
        }
    }

    public void selectDeck(String deckName) throws DeckNotAvailabilityException, NotValidDeckException {
        if (!this.getCollection().getDecks().containsKey(deckName))
            throw new DeckNotAvailabilityException(deckName);
        if (!this.getCollection().getDecks().get(deckName).validateDeck()) throw new NotValidDeckException(deckName);
        this.setSelectedDeck(this.getCollection().getDecks().get(deckName));
        View.showSelectionDeckMessage(deckName);
    }

    public static void saveChanges() {
        //Todo write save system
    }

    public void changeMoney(int change) {
        this.drack += change;
    }

    public void showMatchHistory() {
        this.getMatchHistory().forEach(match -> System.out.println(match.toString()));
    }

    @Override
    public String toString() {
        return "UserName: " + this.getName() + " - Wins : " + this.getNumOfWins();
    }

}