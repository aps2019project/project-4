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
        return "invalid Command";
    }
}

public class View {

    public static void showHelp(){
        switch (Controller.getMenu()){
            case ACCOUNT:
              //toDO write Helps
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
