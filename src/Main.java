import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import controller.Controller;
import model.Enums;
import model.Enums.BuffNutralizer;
import model.Spell;

public class Main {
    public static void main(String[] args) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        Spell spell = new Spell("", "Shame Emblem", 0,
                4000, Enums.OnCellOrSoldier.SOLDIER, Enums.FriendOrEnemy.ENEMY,
                Enums.WhichCellsType.MONO_CELL, BuffNutralizer.NONE, 0);
        String string = gson.toJson(spell, Spell.class);
        Controller.start();
    }
}
