import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import controller.Controller;
import model.*;
import model.buff.*;
import resources.MinionResources;

public class Main {

    public static void main(String[] args) {
        Controller.start();
        System.out.println(Integer.MAX_VALUE);
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();

        Minion minion = MinionResources.getSpecificMinion("persianChampion");
        System.out.println(minion.getSpecialPower().getBuffs().get(0).getChangeAp());
//        Hero hero = new Hero("", "rostam", 8000, 55, 7, 0,
//                1, 3, 0, false, false,
//                false, false, false, Enums.ActivationTypes.NONE);
//        Spell spell;
//        spell = new Spell("", "esfandyar spell", hero.getRequiredManas(),
//                0, Enums.OnCellOrSoldier.SOLDIER, Enums.FriendOrEnemy.ENEMY,
//                Enums.WhichCellsType.MONO_CELL, Enums.BuffNutralizer.BOTH, 0);
//
//        Buff stunBuff = new StunBuff(1, 0, Enums.OnCellOrSoldier.SOLDIER);
//        Buff powerBuff = new PowerBuff(-4, 0, 1, 0, Enums.OnCellOrSoldier.SOLDIER);
//        //Buff powerBuff1 = new PowerBuff(-4, 0, 1, 1, Enums.OnCellOrSoldier.SOLDIER);
//        Buff disarmBuff = new DisarmBuff(1, 0);
//        Buff poisonBuff = new PoisonBuff(-1, 3, 3, 0, Enums.OnCellOrSoldier.SOLDIER);
//        Buff holyBuff = new HolyBuff(3, Integer.MAX_VALUE, 0, Enums.OnCellOrSoldier.SOLDIER);
//        Buff weaknessBuff = new WeaknessBuff(-1, 0, 1, 1, 0, Enums.OnCellOrSoldier.SOLDIER);
//
//        //spell.addBuff(stunBuff);
//        //spell.addBuff(powerBuff);
//        //spell.addBuff(weaknessBuff);
//        //spell.addBuff(powerBuff1);
//        //spell.addBuff(disarmBuff);
//        //spell.addBuff(poisonBuff);
//        spell.addBuff(holyBuff);
//
//        //hero.setSpecialPower(spell);
//        String string = gson.toJson(hero);
//        string = string.replaceAll("  ", "");
//        System.out.println(string);
    }
}
