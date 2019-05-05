import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import controller.Controller;
import model.*;
import model.buff.*;
import resources.SpellResources;

public class Main {

    public static void main(String[] args) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        Minion minion = new Minion("", "eagle", 200, 2, 1, 2,
                2, 3, false, false, false,
                false, false, Enums.ActivationTypes.PASSIVE);
        Spell spell;
        spell = new Spell("", "eagle spell", minion.getRequiredManas(),
                0, Enums.OnCellOrSoldier.SOLDIER, Enums.FriendOrEnemy.ENEMY,
                Enums.WhichCellsType.MONO_CELL, Enums.BuffNutralizer.NONE, 0);

        Buff stunBuff = new StunBuff(1, 0, Enums.OnCellOrSoldier.SOLDIER);
        Buff powerBuff = new PowerBuff(10, 0, 1, 0, Enums.OnCellOrSoldier.SOLDIER);
        Buff disarmBuff = new DisarmBuff(1, 0);
        Buff poisonBuff = new PoisonBuff(-1, 4, 4, 0, Enums.OnCellOrSoldier.SOLDIER);
        //spell.addBuff(stunBuff);
        spell.addBuff(powerBuff);
        //spell.addBuff(disarmBuff);
        //spell.addBuff(poisonBuff);

        minion.setSpecialPower(spell);
        String string = gson.toJson(minion);
        string = string.replaceAll("  ", "");
        System.out.println(string);
    }
}
