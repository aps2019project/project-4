import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class Account {

    private static HashMap<String, Account> accounts = new HashMap<>();
    private static Account currentAccount = null;
    private String name;
    private String password;
    private int Drack;
    private ArrayList<Match> matchHistory;
    private Collection collection;

    public Account(String name, String password) {
        this.name = name;
        this.password = password;
        this.Drack = 0;
        this.matchHistory = new ArrayList<>();
        this.collection = new Collection();
    }

    public String getName() {
        return this.name;
    }

    public String getPassword() {
        return this.password;
    }

    public int getDrack() {
        return this.Drack;
    }

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

    public static void setCurrentAccount(Account currentAccount) {
        Account.currentAccount = currentAccount;
    }

    public static void showLeaderBoard() {
        ArrayList<Account> accounts = new ArrayList<>(getAccounts().values());
        accounts.sort(new AccountComparator());
        accounts.forEach(account -> System.out.println(account.toString()));
    }

    public static void createAccount(String userName) throws DuplicateAccountException {
        if (Account.getAccounts().containsKey(userName))
            throw new DuplicateAccountException(userName);
        View.enterPasswordMessage();
        String password = Controller.getScanner().nextLine();
        Account.getAccounts().put(userName, new Account(userName, password));
        View.successfulAccountCreationMessage(userName);
    }

    public static void login(String userName) throws InvalidPasswordException, InvalidUserNameException {
        try {
            if (!accounts.containsKey(userName))
                throw new InvalidUserNameException();
            View.enterPasswordMessage();
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
            currentAccount = null;
            Controller.setMenu(Enums.Menus.ACCOUNT);

        }
    }

    public void changeMoney(int change) {
        this.Drack += change;
    }

    public void showMatchHistory() {
        this.getMatchHistory().forEach(match -> System.out.println(match.toString()));
    }

    @Override
    public String toString(){
        return "UserName: " + this.getName() + " - Wins : " + this.getNumOfWins() + "\n";
    }
}

class AccountComparator implements Comparator<Account> {
    public int compare(Account a1, Account a2) {
        if (a1.getNumOfWins() != a2.getNumOfWins())
            return Integer.compare(a1.getNumOfWins(), a1.getNumOfWins());
        return a1.getName().compareTo(a2.getName());
    }
}
