import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.*;
import model.buff.*;

public class Main {

    public static void main(String[] args) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        Minion minion = new Minion("", "witch", 550, 4, 5, 4,
                2, 3, false, false, false,
                false, false, Enums.ActivationTypes.PASSIVE);
        Spell spell;
        spell = new Spell("", "wolf spell", minion.getRequiredManas(),
                0, Enums.OnCellOrSoldier.SOLDIER, Enums.FriendOrEnemy.ENEMY,
                Enums.WhichCellsType.ALL_MINIONS_AROUND_AND_ITSELF, Enums.BuffNutralizer.NONE, 0);

        Buff stunBuff = new StunBuff(1, 0, Enums.OnCellOrSoldier.SOLDIER);
        Buff powerBuff = new PowerBuff(0, 2, 1, 0, Enums.OnCellOrSoldier.SOLDIER);
        //Buff powerBuff1 = new PowerBuff(-4, 0, 1, 1, Enums.OnCellOrSoldier.SOLDIER);
        Buff disarmBuff = new DisarmBuff(1, 0);
        Buff poisonBuff = new PoisonBuff(-1, 3, 3, 0, Enums.OnCellOrSoldier.SOLDIER);
        Buff holyBuff = new HolyBuff(-1, Integer.MAX_VALUE, 0, Enums.OnCellOrSoldier.SOLDIER);
        Buff weaknessBuff = new WeaknessBuff(-1, 0, 1, 1, 0, Enums.OnCellOrSoldier.SOLDIER);

        //spell.addBuff(stunBuff);
        spell.addBuff(powerBuff);
        spell.addBuff(weaknessBuff);
        //spell.addBuff(powerBuff1);
        //spell.addBuff(disarmBuff);
        //spell.addBuff(poisonBuff);
        //spell.addBuff(holyBuff);

        minion.setSpecialPower(spell);
        String string = gson.toJson(minion);
        string = string.replaceAll("  ", "");
        System.out.println(string);
    }
}
