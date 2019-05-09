import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import controller.Controller;
import model.Enums;
import model.Enums.BuffNutralizer;
import model.Spell;
import model.buff.*;

public class Main {
    public static void main(String[] args) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        Spell spell = new Spell("", "Baptism", 0,
                20000, Enums.OnCellOrSoldier.SOLDIER, Enums.FriendOrEnemy.FRIEND_MINION,
                Enums.WhichCellsType.ALL_MINIONS_AROUND, BuffNutralizer.NONE, 0);
        HolyBuff buff = new HolyBuff(2 , Integer.MAX_VALUE , 0, Enums.OnCellOrSoldier.SOLDIER);
        spell.addBuff(buff);
        String string = gson.toJson(spell, Spell.class);
        System.out.println(string.replaceAll("  " , ""));
        Controller.start();

    }
}
