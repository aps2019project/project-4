class InvalidUserNameException extends Exception{
    @Override
    public String getMessage() {
        return "User name is invalid";
    }
}

class InvalidPasswordException extends Exception{
    @Override
    public String getMessage() {
        return "invalid Command";
    }
}

class InvalidCommandException extends Exception {
    @Override
    public String getMessage() {
        View.showHelp();
        return "invalid Command";
    }
}

public class View {

    public static void showHelp(){
        switch (Controller.getMenu()){
            case ACCOUNT:
                System.out.println("create account [user name] : Create a new account with name [user name]");
                System.out.println("login [user name] : Login in account with name [user name] after getting password if password is correct");
                System.out.println("show leaderboard: Sort users by their wins and losses and show them");
                System.out.println("save: Save changes");
                System.out.println("help: Show Helps");
            case MAIN:

            case COLLECTION:

            case SHOP:

            case BATTLE:

        }
    }

    public static void successfulAccountCreationMessage(){
        //toDo Copy Print Message to inja
    }



}
