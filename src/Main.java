import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import controller.Controller;
import model.*;
import model.buff.*;

public class Main {

    public static void main(String[] args) {
        Spell spell = new Spell("10001", "dispel", 4, 500,
                Enums.FriendOrEnemy.ENEMY, Enums.WhichCellsType.MONO_CELL, 0);
        Buff buff = new PowerBuff(4, 3, 5, 0);
        Buff buff1 = new DisarmBuff(4, 0);
        spell.addBuff(buff);
        spell.addBuff(buff1);


        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
//        Card minion = new Minion("persianSwordman", 400, 2, 6, 4, 2, 7);
//        String string = gson.toJson(minion);
//        System.out.println(string.replaceAll("  ", ""));
        Controller.start();
        String string = gson.toJson(spell);
        System.out.println(string);
    }
}
