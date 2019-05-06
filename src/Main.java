import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.*;
import model.buff.*;

public class Main {

    public static void main(String[] args) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        Minion minion = new Minion("", "arzhang deeve", 600, 3, 6, 6,
                1, 1, false, false, false,
                false, false, Enums.ActivationTypes.COMBO);
        Spell spell;
        spell = new Spell("", "siavash spell", minion.getRequiredManas(),
                0, Enums.OnCellOrSoldier.SOLDIER, Enums.FriendOrEnemy.ENEMY_HERO,
                Enums.WhichCellsType.MONO_CELL, Enums.BuffNutralizer.NONE, 0);

        Buff stunBuff = new StunBuff(1, 0, Enums.OnCellOrSoldier.SOLDIER);
        Buff powerBuff = new PowerBuff(-6, 0, 1, 0, Enums.OnCellOrSoldier.SOLDIER);
        //Buff powerBuff1 = new PowerBuff(-4, 0, 1, 1, Enums.OnCellOrSoldier.SOLDIER);
        Buff disarmBuff = new DisarmBuff(1, 0);
        Buff poisonBuff = new PoisonBuff(-1, 3, 3, 0, Enums.OnCellOrSoldier.SOLDIER);
        Buff holyBuff = new HolyBuff(12, Integer.MAX_VALUE, 0, Enums.OnCellOrSoldier.SOLDIER);
        Buff weaknessBuff = new WeaknessBuff(-1, 0, 1, 1, 0, Enums.OnCellOrSoldier.SOLDIER);

        //spell.addBuff(stunBuff);
        spell.addBuff(powerBuff);
        //spell.addBuff(weaknessBuff);
        //spell.addBuff(powerBuff1);
        //spell.addBuff(disarmBuff);
        //spell.addBuff(poisonBuff);
        //spell.addBuff(holyBuff);

        //minion.setSpecialPower(spell);
        String string = gson.toJson(minion);
        string = string.replaceAll("  ", "");
        System.out.println(string);
    }
}
