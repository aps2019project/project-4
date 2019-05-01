import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import controller.Controller;
import model.*;
import model.buff.*;

public class Main {

    public static void main(String[] args) {

        Spell spell = new Spell("", "GodStrength", 4, 450,
                Enums.FriendOrEnemy.ENEMY_HERO, Enums.WhichCellsType.MONO_CELL, Enums.BuffNutralizer.NONE, 0);
        Buff disarm = new DisarmBuff(-1, 0);
        Buff power = new PowerBuff(0, 4, -1 , 0);
        //spell.addBuff(disarm);
        spell.addBuff(power);


        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        String string = gson.toJson(spell);
        System.out.println(string.replaceAll("  ", ""));
    }
}
