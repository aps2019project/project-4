import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import controller.Controller;
import model.*;
import model.buff.*;

public class Main {

    public static void main(String[] args) {
        Controller.start();
        Spell spell = new Spell("", "Dispel", 0, 2100,
                Enums.FriendOrEnemy.BOTH, Enums.WhichCellsType.MONO_CELL, Enums.BuffNutralizer.BOTH, 0);
        Buff disarm = new DisarmBuff(1, 0);
        Buff power = new PowerBuff(0, 4, 3 , 0);
        Buff poisonBuff = new PoisonBuff(1, 4, 1, 0);
        Buff fireBuff = new FireBuff(2, 1, 0);
        //spell.addBuff(disarm);
        //spell.addBuff(power);
        //spell.addBuff(fireBuff);
        //spell.addBuff(poisonBuff);



        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        String string = gson.toJson(spell);
        System.out.println(string.replaceAll("  ", ""));
    }
}
