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
                System.out.println("create account [user name] : Create a new account with name user name");
                System.out.println("login [user name] : Login in account with name user name after getting password if password is correct");
                System.out.println("show leaderboard: Sort users by their wins and losses and show them");
                System.out.println("save: Save changes");
                System.out.println("help: Show Helps");
            case MAIN:

            case COLLECTION:

            case SHOP:

            case BATTLE:

        }
    }

    public static void successfulAccountCreationMessage(String userName) {
        System.out.println("The account with name " + userName + " created!");
    }

    public static void enterPasswordMessage() {
        System.out.println("Enter Password");
    }

}
