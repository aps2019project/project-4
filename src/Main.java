import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import controller.Controller;
import model.*;
import model.buff.*;

public class Main {

    public static void main(String[] args) {

        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        String string = new SpellResources().Shock;
        Spell spell = gson.fromJson(string, Spell.class);

        System.out.println(spell.info());

        System.out.println(spell.getBuffs().get(0).getCellOrSoldier());
//        Spell spell = new Spell("", "Shock", 1, 1200,
//                Enums.FriendOrEnemy.ENEMY, Enums.WhichCellsType.MONO_CELL, Enums.BuffNutralizer.NONE, 0);
        Buff disarm = new DisarmBuff(1, 0);
        Buff power = new PowerBuff(-Integer.MAX_VALUE, 0, 1 , 0);
        Buff poisonBuff = new PoisonBuff(1, 4, 1, 0);
        Buff fireBuff = new FireBuff(2, 1, 0);
        Buff weaknessBuff = new WeaknessBuff(-6, 0, 0, 1, 0);
        Buff holyBuff = new HolyBuff(2, 3, 0);
        Buff stun = new StunBuff(2, 0);
        //spell.addBuff(disarm);
        //spell.addBuff(power);
        //spell.addBuff(fireBuff);
        //spell.addBuff(poisonBuff);
        //spell.addBuff(weaknessBuff);
        //spell.addBuff(holyBuff);
//        spell.addBuff(stun);
//        GsonBuilder builder = new GsonBuilder();
//        builder.setPrettyPrinting();
//        Gson gson = builder.create();
//        String string = gson.toJson(spell);
//        System.out.println(string.replaceAll("  ", ""));
    }
}
