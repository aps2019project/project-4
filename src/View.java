import java.util.ArrayList;

class InvalidUserNameException extends Exception {
    public InvalidUserNameException() {
        super("User name is invalid");
    }
}

class InvalidPasswordException extends Exception {
    public InvalidPasswordException() {
        super("Invalid Password");
    }
}

class DuplicateAccountException extends Exception {
    public DuplicateAccountException(String userName) {
        super("The with name " + userName + " exists!");
    }
}

class InvalidCommandException extends Exception {
    public InvalidCommandException() {
        super("Invalid Command");
    }

    public void showMessage() {
        System.out.println(super.getMessage());
        View.showHelp();
    }
}

public class View {
    public static void showHelp() {
        switch (Controller.getMenu()) {
            case ACCOUNT:
                showAccountMenuHelp();
                break;
            case MAIN:
                showMainMenuHelp();
                break;
            case COLLECTION:
                showCollectionMenuHelp();
                break;
            case SHOP:
                showShopMenuHelp();
                break;
            case BATTLE:
                showBattleMenuHelp();
                break;
        }
    }

    private static void showAccountMenuHelp() {
        System.out.println("create account [user name] : Create a new account with name user name");
        System.out.println("login [user name] : Login in account with name user name after getting password if password is correct");
        System.out.println("show leaderboard: Sort users by their wins and losses and show them");
        System.out.println("save: Save changes");
        System.out.println("help: Show Helps");
        System.out.println("exit game: exit from game");
    }

    private static void showMainMenuHelp(){
        System.out.println("enter Collection|Shop|Battle : Enter in menus");
        System.out.println("logout: Log out from account");
        System.out.println("exit game: exit from game");
        System.out.println("help: to show help");
    }

    private static void showCollectionMenuHelp(){

    }

    private static void showShopMenuHelp(){

    }

    private static void showBattleMenuHelp(){

    }

    public static void showMenu(){
        switch (Controller.getMenu()){
            case ACCOUNT:
                showAccountMenu();
            case BATTLE:
                showBattleMenu();
                break;
            case SHOP:
                showShopMenu();
                break;
            case COLLECTION:
                showCollectionMenu();
                break;
            case MAIN:
                showMainMenu();
                break;
        }
    }

    public static void showAccounts(ArrayList<Account> accounts){

    }

    private static void showAccountMenu(){
        System.out.print("1.Create Account\n2.Login\n3.Show Leaderboard\n4.Save\n5.Help\n6.Exit game\n");
    }

    private static void showMainMenu() {
        System.out.print("1.Collection\n2.Shop\n3.Battle\n4.Logout\n5.Exit game\n6.Help\n");
    }

    private static void showShopMenu() {

    }

    private static void showCollectionMenu() {

    }

    private static void showBattleMenu() {

    }

    public static void showSuccessfulAccountCreationMessage(String userName) {
        System.out.println("The account with name " + userName + " created!");
    }

    public static void showEnterPasswordMessage() {
        System.out.println("Enter Password");
    }

    public static void showConfirmationLogoutMessage(){
        System.out.println("Are you sure to logout?[Y/N]");
    }

    public static void showConfirmationExitMessage(){
        System.out.println("Are you sure to exit?[Y/N]");
    }

}
