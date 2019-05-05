import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import controller.Controller;
import model.*;
import model.buff.*;
import resources.SpellResources;

public class Main {

    public static void main(String[] args) {
        Controller.start();
        Minion minion = new Minion("kasra", 500, 22, 6, 4, 1, 5);
        Buff buff = new DisarmBuff(Integer.MAX_VALUE, 0);
        minion.getNegativeBuffs().add(buff);
        minion.applyBuff(buff);
        System.out.println(minion.getIsDisarmed());
        System.out.println(minion.getNumberOfTurnsOfDisarm());
    }
}
