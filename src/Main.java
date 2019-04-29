import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import controller.Controller;
import model.Card;
import model.Minion;

public class Main {

    public static void main(String[] args) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        Card minion = new Minion("persianSwordman", 400, 2, 6, 4, 2, 7);
        String string = gson.toJson(minion);
        System.out.println(string.replaceAll("  ", ""));
        //Controller.start();
    }
}
