package resources;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.Minion;

import java.util.ArrayList;
import java.util.HashMap;

public class MinionResources {

    private static HashMap<String, String> minionResource = new HashMap<>();

    public static HashMap<String, String> getMinionResource() {
        return minionResource;
    }

    public static Minion getSpecificMinion(String minionName) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        if (getSpecificMinionGson(minionName) != null)
            return gson.fromJson(getMinionResource().get(minionName), Minion.class);
        return null;
    }

    private static String getSpecificMinionGson(String minionName) {
        return getMinionResource().get(minionName);
    }

    public static ArrayList<Minion> getAllMinions() {
        ArrayList<Minion> minions = new ArrayList<>();
        getMinionResource().forEach((name, gson) -> minions.add(getSpecificMinion(name)));
        return minions;
    }

    public static void setMinionResource() {
        //todo add other minion Gsons
        getMinionResource().put("persianArcher", "{\n" +
                "\"healthPoint\": 6,\n" +
                "\"attackPoint\": 4,\n" +
                "\"startRange\": 2,\n" +
                "\"endRange\": 7,\n" +
                "\"isAntiHolyBuff\": false,\n" +
                "\"isAntiDisarm\": false,\n" +
                "\"isAntiPoison\": false,\n" +
                "\"isImmortal\": false,\n" +
                "\"isApSuperior\": false,\n" +
                "\"type\": \"RANGED\",\n" +
                "\"hasAttackedThisTurn\": false,\n" +
                "\"hasMovedThisTurn\": false,\n" +
                "\"isDisarmed\": false,\n" +
                "\"isStunned\": false,\n" +
                "\"numberOfTurnsOfDisarm\": 0,\n" +
                "\"numberOfTurnsOfStun\": 0,\n" +
                "\"specialPowerActivationType\": \"NONE\",\n" +
                "\"positiveBuffs\": [],\n" +
                "\"negativeBuffs\": [],\n" +
                "\"hasFlag\": false,\n" +
                "\"id\": \"\",\n" +
                "\"name\": \"persian archer\",\n" +
                "\"requiredManas\": 2,\n" +
                "\"price\": 300\n" +
                "}");
        getMinionResource().put("persianSwordsman", "{\n" +
                "\"healthPoint\": 6,\n" +
                "\"attackPoint\": 4,\n" +
                "\"startRange\": 1,\n" +
                "\"endRange\": 1,\n" +
                "\"isAntiHolyBuff\": false,\n" +
                "\"isAntiDisarm\": false,\n" +
                "\"isAntiPoison\": false,\n" +
                "\"isImmortal\": false,\n" +
                "\"isApSuperior\": false,\n" +
                "\"type\": \"MELEE\",\n" +
                "\"hasAttackedThisTurn\": false,\n" +
                "\"hasMovedThisTurn\": false,\n" +
                "\"isDisarmed\": false,\n" +
                "\"isStunned\": false,\n" +
                "\"numberOfTurnsOfDisarm\": 0,\n" +
                "\"numberOfTurnsOfStun\": 0,\n" +
                "\"specialPower\": {\n" +
                "\"cellOrSoldier\": \"SOLDIER\",\n" +
                "\"target\": \"ENEMY\",\n" +
                "\"cellsType\": \"MONO_CELL\",\n" +
                "\"lengthOfSideOfSquare\": 0,\n" +
                "\"buffNutralizer\": \"NONE\",\n" +
                "\"buffs\": [\n" +
                "{\n" +
                "\"numberOfTurnsOnTarget\": 0,\n" +
                "\"changeHp\": 0,\n" +
                "\"apShield\": 0,\n" +
                "\"changeAp\": 0,\n" +
                "\"numberOfTurns\": 1,\n" +
                "\"delay\": 0,\n" +
                "\"isDisarmer\": false,\n" +
                "\"isStunner\": true,\n" +
                "\"isPositive\": false,\n" +
                "\"onCellOrSoldier\": \"SOLDIER\",\n" +
                "\"isActive\": false\n" +
                "}\n" +
                "],\n" +
                "\"cells\": [],\n" +
                "\"id\": \"\",\n" +
                "\"name\": \"persian swordsman spell\",\n" +
                "\"requiredManas\": 2,\n" +
                "\"price\": 0\n" +
                "},\n" +
                "\"specialPowerActivationType\": \"ON_ATTACK\",\n" +
                "\"positiveBuffs\": [],\n" +
                "\"negativeBuffs\": [],\n" +
                "\"hasFlag\": false,\n" +
                "\"id\": \"\",\n" +
                "\"name\": \"persian swordsman\",\n" +
                "\"requiredManas\": 2,\n" +
                "\"price\": 400\n" +
                "}");
        getMinionResource().put("persianSpearsman", "{\n" +
                "\"healthPoint\": 5,\n" +
                "\"attackPoint\": 3,\n" +
                "\"startRange\": 1,\n" +
                "\"endRange\": 3,\n" +
                "\"isAntiHolyBuff\": false,\n" +
                "\"isAntiDisarm\": false,\n" +
                "\"isAntiPoison\": false,\n" +
                "\"isImmortal\": false,\n" +
                "\"isApSuperior\": false,\n" +
                "\"type\": \"HYBRID\",\n" +
                "\"hasAttackedThisTurn\": false,\n" +
                "\"hasMovedThisTurn\": false,\n" +
                "\"isDisarmed\": false,\n" +
                "\"isStunned\": false,\n" +
                "\"numberOfTurnsOfDisarm\": 0,\n" +
                "\"numberOfTurnsOfStun\": 0,\n" +
                "\"specialPowerActivationType\": \"NONE\",\n" +
                "\"positiveBuffs\": [],\n" +
                "\"negativeBuffs\": [],\n" +
                "\"hasFlag\": false,\n" +
                "\"id\": \"\",\n" +
                "\"name\": \"persian spearsman\",\n" +
                "\"requiredManas\": 1,\n" +
                "\"price\": 500\n" +
                "}");
        getMinionResource().put("persianHorseman", "{\n" +
                "\"healthPoint\": 10,\n" +
                "\"attackPoint\": 6,\n" +
                "\"startRange\": 1,\n" +
                "\"endRange\": 1,\n" +
                "\"isAntiHolyBuff\": false,\n" +
                "\"isAntiDisarm\": false,\n" +
                "\"isAntiPoison\": false,\n" +
                "\"isImmortal\": false,\n" +
                "\"isApSuperior\": false,\n" +
                "\"type\": \"MELEE\",\n" +
                "\"hasAttackedThisTurn\": false,\n" +
                "\"hasMovedThisTurn\": false,\n" +
                "\"isDisarmed\": false,\n" +
                "\"isStunned\": false,\n" +
                "\"numberOfTurnsOfDisarm\": 0,\n" +
                "\"numberOfTurnsOfStun\": 0,\n" +
                "\"specialPowerActivationType\": \"NONE\",\n" +
                "\"positiveBuffs\": [],\n" +
                "\"negativeBuffs\": [],\n" +
                "\"hasFlag\": false,\n" +
                "\"id\": \"\",\n" +
                "\"name\": \"persian horseman\",\n" +
                "\"requiredManas\": 4,\n" +
                "\"price\": 200\n" +
                "}");
        getMinionResource().put("persianChampion", "{\n" +
                "\"healthPoint\": 24,\n" +
                "\"attackPoint\": 6,\n" +
                "\"startRange\": 1,\n" +
                "\"endRange\": 1,\n" +
                "\"isAntiHolyBuff\": false,\n" +
                "\"isAntiDisarm\": false,\n" +
                "\"isAntiPoison\": false,\n" +
                "\"isImmortal\": false,\n" +
                "\"isApSuperior\": false,\n" +
                "\"type\": \"MELEE\",\n" +
                "\"hasAttackedThisTurn\": false,\n" +
                "\"hasMovedThisTurn\": false,\n" +
                "\"isDisarmed\": false,\n" +
                "\"isStunned\": false,\n" +
                "\"numberOfTurnsOfDisarm\": 0,\n" +
                "\"numberOfTurnsOfStun\": 0,\n" +
                "\"specialPower\": {\n" +
                "\"cellOrSoldier\": \"SOLDIER\",\n" +
                "\"target\": \"ENEMY\",\n" +
                "\"cellsType\": \"MONO_CELL\",\n" +
                "\"lengthOfSideOfSquare\": 0,\n" +
                "\"buffNutralizer\": \"NONE\",\n" +
                "\"buffs\": [\n" +
                "{\n" +
                "\"numberOfTurnsOnTarget\": 0,\n" +
                "\"changeHp\": 0,\n" +
                "\"apShield\": 0,\n" +
                "\"changeAp\": 5,\n" +
                "\"numberOfTurns\": 2147483647,\n" +
                "\"delay\": 0,\n" +
                "\"isDisarmer\": false,\n" +
                "\"isStunner\": false,\n" +
                "\"isPositive\": true,\n" +
                "\"onCellOrSoldier\": \"SOLDIER\",\n" +
                "\"isActive\": false\n" +
                "}\n" +
                "],\n" +
                "\"cells\": [],\n" +
                "\"id\": \"\",\n" +
                "\"name\": \"persian champion spell\",\n" +
                "\"requiredManas\": 9,\n" +
                "\"price\": 0\n" +
                "},\n" +
                "\"specialPowerActivationType\": \"ON_ATTACK\",\n" +
                "\"positiveBuffs\": [],\n" +
                "\"negativeBuffs\": [],\n" +
                "\"hasFlag\": false,\n" +
                "\"id\": \"\",\n" +
                "\"name\": \"persian champion\",\n" +
                "\"requiredManas\": 9,\n" +
                "\"price\": 600\n" +
                "}");
        getMinionResource().put("persianCommander", "{\n" +
                "\"healthPoint\": 12,\n" +
                "\"attackPoint\": 4,\n" +
                "\"startRange\": 1,\n" +
                "\"endRange\": 1,\n" +
                "\"isAntiHolyBuff\": false,\n" +
                "\"isAntiDisarm\": false,\n" +
                "\"isAntiPoison\": false,\n" +
                "\"isImmortal\": false,\n" +
                "\"isApSuperior\": false,\n" +
                "\"type\": \"MELEE\",\n" +
                "\"hasAttackedThisTurn\": false,\n" +
                "\"hasMovedThisTurn\": false,\n" +
                "\"isDisarmed\": false,\n" +
                "\"isStunned\": false,\n" +
                "\"numberOfTurnsOfDisarm\": 0,\n" +
                "\"numberOfTurnsOfStun\": 0,\n" +
                "\"specialPowerActivationType\": \"COMBO\",\n" +
                "\"positiveBuffs\": [],\n" +
                "\"negativeBuffs\": [],\n" +
                "\"hasFlag\": false,\n" +
                "\"id\": \"\",\n" +
                "\"name\": \"persian commander\",\n" +
                "\"requiredManas\": 7,\n" +
                "\"price\": 800\n" +
                "}");
        getMinionResource().put("transoxanianArcher", "{\n" +
                "\"healthPoint\": 3,\n" +
                "\"attackPoint\": 4,\n" +
                "\"startRange\": 2,\n" +
                "\"endRange\": 5,\n" +
                "\"isAntiHolyBuff\": false,\n" +
                "\"isAntiDisarm\": false,\n" +
                "\"isAntiPoison\": false,\n" +
                "\"isImmortal\": false,\n" +
                "\"isApSuperior\": false,\n" +
                "\"type\": \"RANGED\",\n" +
                "\"hasAttackedThisTurn\": false,\n" +
                "\"hasMovedThisTurn\": false,\n" +
                "\"isDisarmed\": false,\n" +
                "\"isStunned\": false,\n" +
                "\"numberOfTurnsOfDisarm\": 0,\n" +
                "\"numberOfTurnsOfStun\": 0,\n" +
                "\"specialPowerActivationType\": \"NONE\",\n" +
                "\"positiveBuffs\": [],\n" +
                "\"negativeBuffs\": [],\n" +
                "\"hasFlag\": false,\n" +
                "\"id\": \"\",\n" +
                "\"name\": \"transoxanian archer\",\n" +
                "\"requiredManas\": 1,\n" +
                "\"price\": 500\n" +
                "}");
        getMinionResource().put("transoxanianSlingman", "{\n" +
                "\"healthPoint\": 4,\n" +
                "\"attackPoint\": 2,\n" +
                "\"startRange\": 2,\n" +
                "\"endRange\": 7,\n" +
                "\"isAntiHolyBuff\": false,\n" +
                "\"isAntiDisarm\": false,\n" +
                "\"isAntiPoison\": false,\n" +
                "\"isImmortal\": false,\n" +
                "\"isApSuperior\": false,\n" +
                "\"type\": \"RANGED\",\n" +
                "\"hasAttackedThisTurn\": false,\n" +
                "\"hasMovedThisTurn\": false,\n" +
                "\"isDisarmed\": false,\n" +
                "\"isStunned\": false,\n" +
                "\"numberOfTurnsOfDisarm\": 0,\n" +
                "\"numberOfTurnsOfStun\": 0,\n" +
                "\"specialPowerActivationType\": \"NONE\",\n" +
                "\"positiveBuffs\": [],\n" +
                "\"negativeBuffs\": [],\n" +
                "\"hasFlag\": false,\n" +
                "\"id\": \"\",\n" +
                "\"name\": \"transoxanian slingman\",\n" +
                "\"requiredManas\": 1,\n" +
                "\"price\": 600\n" +
                "}");
        getMinionResource().put("transoxaninaSpearsman", "{\n" +
                "\"healthPoint\": 4,\n" +
                "\"attackPoint\": 4,\n" +
                "\"startRange\": 1,\n" +
                "\"endRange\": 3,\n" +
                "\"isAntiHolyBuff\": false,\n" +
                "\"isAntiDisarm\": false,\n" +
                "\"isAntiPoison\": false,\n" +
                "\"isImmortal\": false,\n" +
                "\"isApSuperior\": false,\n" +
                "\"type\": \"HYBRID\",\n" +
                "\"hasAttackedThisTurn\": false,\n" +
                "\"hasMovedThisTurn\": false,\n" +
                "\"isDisarmed\": false,\n" +
                "\"isStunned\": false,\n" +
                "\"numberOfTurnsOfDisarm\": 0,\n" +
                "\"numberOfTurnsOfStun\": 0,\n" +
                "\"specialPowerActivationType\": \"NONE\",\n" +
                "\"positiveBuffs\": [],\n" +
                "\"negativeBuffs\": [],\n" +
                "\"hasFlag\": false,\n" +
                "\"id\": \"\",\n" +
                "\"name\": \"transoxanian spearsman\",\n" +
                "\"requiredManas\": 1,\n" +
                "\"price\": 600\n" +
                "}");
        getMinionResource().put("transoxanianSpy", "{\n" +
                "\"healthPoint\": 6,\n" +
                "\"attackPoint\": 6,\n" +
                "\"startRange\": 1,\n" +
                "\"endRange\": 1,\n" +
                "\"isAntiHolyBuff\": false,\n" +
                "\"isAntiDisarm\": false,\n" +
                "\"isAntiPoison\": false,\n" +
                "\"isImmortal\": false,\n" +
                "\"isApSuperior\": false,\n" +
                "\"type\": \"MELEE\",\n" +
                "\"hasAttackedThisTurn\": false,\n" +
                "\"hasMovedThisTurn\": false,\n" +
                "\"isDisarmed\": false,\n" +
                "\"isStunned\": false,\n" +
                "\"numberOfTurnsOfDisarm\": 0,\n" +
                "\"numberOfTurnsOfStun\": 0,\n" +
                "\"specialPower\": {\n" +
                "\"cellOrSoldier\": \"SOLDIER\",\n" +
                "\"target\": \"ENEMY\",\n" +
                "\"cellsType\": \"MONO_CELL\",\n" +
                "\"lengthOfSideOfSquare\": 0,\n" +
                "\"buffNutralizer\": \"NONE\",\n" +
                "\"buffs\": [\n" +
                "{\n" +
                "\"numberOfTurnsOnTarget\": 0,\n" +
                "\"changeHp\": 0,\n" +
                "\"apShield\": 0,\n" +
                "\"changeAp\": 0,\n" +
                "\"numberOfTurns\": 1,\n" +
                "\"delay\": 0,\n" +
                "\"isDisarmer\": true,\n" +
                "\"isStunner\": false,\n" +
                "\"isPositive\": false,\n" +
                "\"onCellOrSoldier\": \"SOLDIER\",\n" +
                "\"isActive\": false\n" +
                "},\n" +
                "{\n" +
                "\"numberOfTurnsOnTarget\": 4,\n" +
                "\"changeHp\": -1,\n" +
                "\"apShield\": 0,\n" +
                "\"changeAp\": 0,\n" +
                "\"numberOfTurns\": 4,\n" +
                "\"delay\": 0,\n" +
                "\"isDisarmer\": false,\n" +
                "\"isStunner\": false,\n" +
                "\"isPositive\": false,\n" +
                "\"onCellOrSoldier\": \"SOLDIER\",\n" +
                "\"isActive\": false\n" +
                "}\n" +
                "],\n" +
                "\"cells\": [],\n" +
                "\"id\": \"\",\n" +
                "\"name\": \"transoxanian spy spell\",\n" +
                "\"requiredManas\": 4,\n" +
                "\"price\": 0\n" +
                "},\n" +
                "\"specialPowerActivationType\": \"ON_ATTACK\",\n" +
                "\"positiveBuffs\": [],\n" +
                "\"negativeBuffs\": [],\n" +
                "\"hasFlag\": false,\n" +
                "\"id\": \"\",\n" +
                "\"name\": \"transoxanian spy\",\n" +
                "\"requiredManas\": 4,\n" +
                "\"price\": 700\n" +
                "}");
        getMinionResource().put("transoxanianMaceman", "{\n" +
                "\"healthPoint\": 3,\n" +
                "\"attackPoint\": 10,\n" +
                "\"startRange\": 1,\n" +
                "\"endRange\": 1,\n" +
                "\"isAntiHolyBuff\": false,\n" +
                "\"isAntiDisarm\": false,\n" +
                "\"isAntiPoison\": false,\n" +
                "\"isImmortal\": false,\n" +
                "\"isApSuperior\": false,\n" +
                "\"type\": \"MELEE\",\n" +
                "\"hasAttackedThisTurn\": false,\n" +
                "\"hasMovedThisTurn\": false,\n" +
                "\"isDisarmed\": false,\n" +
                "\"isStunned\": false,\n" +
                "\"numberOfTurnsOfDisarm\": 0,\n" +
                "\"numberOfTurnsOfStun\": 0,\n" +
                "\"specialPowerActivationType\": \"NONE\",\n" +
                "\"positiveBuffs\": [],\n" +
                "\"negativeBuffs\": [],\n" +
                "\"hasFlag\": false,\n" +
                "\"id\": \"\",\n" +
                "\"name\": \"transoxanian maceman\",\n" +
                "\"requiredManas\": 2,\n" +
                "\"price\": 450\n" +
                "}");
        getMinionResource().put("transoxanianPrince", "{\n" +
                "\"healthPoint\": 6,\n" +
                "\"attackPoint\": 10,\n" +
                "\"startRange\": 1,\n" +
                "\"endRange\": 1,\n" +
                "\"isAntiHolyBuff\": false,\n" +
                "\"isAntiDisarm\": false,\n" +
                "\"isAntiPoison\": false,\n" +
                "\"isImmortal\": false,\n" +
                "\"isApSuperior\": false,\n" +
                "\"type\": \"MELEE\",\n" +
                "\"hasAttackedThisTurn\": false,\n" +
                "\"hasMovedThisTurn\": false,\n" +
                "\"isDisarmed\": false,\n" +
                "\"isStunned\": false,\n" +
                "\"numberOfTurnsOfDisarm\": 0,\n" +
                "\"numberOfTurnsOfStun\": 0,\n" +
                "\"specialPowerActivationType\": \"COMBO\",\n" +
                "\"positiveBuffs\": [],\n" +
                "\"negativeBuffs\": [],\n" +
                "\"hasFlag\": false,\n" +
                "\"id\": \"\",\n" +
                "\"name\": \"transoxanian prince\",\n" +
                "\"requiredManas\": 6,\n" +
                "\"price\": 800\n" +
                "}");
        getMinionResource().put("blackDevil", "{\n" +
                "\"healthPoint\": 14,\n" +
                "\"attackPoint\": 10,\n" +
                "\"startRange\": 1,\n" +
                "\"endRange\": 7,\n" +
                "\"isAntiHolyBuff\": false,\n" +
                "\"isAntiDisarm\": false,\n" +
                "\"isAntiPoison\": false,\n" +
                "\"isImmortal\": false,\n" +
                "\"isApSuperior\": false,\n" +
                "\"type\": \"HYBRID\",\n" +
                "\"hasAttackedThisTurn\": false,\n" +
                "\"hasMovedThisTurn\": false,\n" +
                "\"isDisarmed\": false,\n" +
                "\"isStunned\": false,\n" +
                "\"numberOfTurnsOfDisarm\": 0,\n" +
                "\"numberOfTurnsOfStun\": 0,\n" +
                "\"specialPowerActivationType\": \"NONE\",\n" +
                "\"positiveBuffs\": [],\n" +
                "\"negativeBuffs\": [],\n" +
                "\"hasFlag\": false,\n" +
                "\"id\": \"\",\n" +
                "\"name\": \"black devil\",\n" +
                "\"requiredManas\": 9,\n" +
                "\"price\": 300\n" +
                "}");
        getMinionResource().put("stonemanGiant", "{\n" +
                "\"healthPoint\": 12,\n" +
                "\"attackPoint\": 12,\n" +
                "\"startRange\": 2,\n" +
                "\"endRange\": 7,\n" +
                "\"isAntiHolyBuff\": false,\n" +
                "\"isAntiDisarm\": false,\n" +
                "\"isAntiPoison\": false,\n" +
                "\"isImmortal\": false,\n" +
                "\"isApSuperior\": false,\n" +
                "\"type\": \"RANGED\",\n" +
                "\"hasAttackedThisTurn\": false,\n" +
                "\"hasMovedThisTurn\": false,\n" +
                "\"isDisarmed\": false,\n" +
                "\"isStunned\": false,\n" +
                "\"numberOfTurnsOfDisarm\": 0,\n" +
                "\"numberOfTurnsOfStun\": 0,\n" +
                "\"specialPowerActivationType\": \"NONE\",\n" +
                "\"positiveBuffs\": [],\n" +
                "\"negativeBuffs\": [],\n" +
                "\"hasFlag\": false,\n" +
                "\"id\": \"\",\n" +
                "\"name\": \"stoneman giant\",\n" +
                "\"requiredManas\": 9,\n" +
                "\"price\": 300\n" +
                "}");
        getMinionResource().put("eagle", "{\n" +
                "\"healthPoint\": 1,\n" +
                "\"attackPoint\": 2,\n" +
                "\"startRange\": 2,\n" +
                "\"endRange\": 3,\n" +
                "\"isAntiHolyBuff\": false,\n" +
                "\"isAntiDisarm\": false,\n" +
                "\"isAntiPoison\": false,\n" +
                "\"isImmortal\": false,\n" +
                "\"isApSuperior\": false,\n" +
                "\"type\": \"RANGED\",\n" +
                "\"hasAttackedThisTurn\": false,\n" +
                "\"hasMovedThisTurn\": false,\n" +
                "\"isDisarmed\": false,\n" +
                "\"isStunned\": false,\n" +
                "\"numberOfTurnsOfDisarm\": 0,\n" +
                "\"numberOfTurnsOfStun\": 0,\n" +
                "\"specialPower\": {\n" +
                "\"cellOrSoldier\": \"SOLDIER\",\n" +
                "\"target\": \"ENEMY\",\n" +
                "\"cellsType\": \"MONO_CELL\",\n" +
                "\"lengthOfSideOfSquare\": 0,\n" +
                "\"buffNutralizer\": \"NONE\",\n" +
                "\"buffs\": [\n" +
                "{\n" +
                "\"numberOfTurnsOnTarget\": 0,\n" +
                "\"changeHp\": 10,\n" +
                "\"apShield\": 0,\n" +
                "\"changeAp\": 0,\n" +
                "\"numberOfTurns\": 1,\n" +
                "\"delay\": 0,\n" +
                "\"isDisarmer\": false,\n" +
                "\"isStunner\": false,\n" +
                "\"isPositive\": true,\n" +
                "\"onCellOrSoldier\": \"SOLDIER\",\n" +
                "\"isActive\": false\n" +
                "}\n" +
                "],\n" +
                "\"cells\": [],\n" +
                "\"id\": \"\",\n" +
                "\"name\": \"eagle spell\",\n" +
                "\"requiredManas\": 2,\n" +
                "\"price\": 0\n" +
                "},\n" +
                "\"specialPowerActivationType\": \"PASSIVE\",\n" +
                "\"positiveBuffs\": [],\n" +
                "\"negativeBuffs\": [],\n" +
                "\"hasFlag\": false,\n" +
                "\"id\": \"\",\n" +
                "\"name\": \"eagle\",\n" +
                "\"requiredManas\": 2,\n" +
                "\"price\": 200\n" +
                "}");
        getMinionResource().put("swineriderDevil", "{\n" +
                "\"healthPoint\": 16,\n" +
                "\"attackPoint\": 8,\n" +
                "\"startRange\": 1,\n" +
                "\"endRange\": 1,\n" +
                "\"isAntiHolyBuff\": false,\n" +
                "\"isAntiDisarm\": false,\n" +
                "\"isAntiPoison\": false,\n" +
                "\"isImmortal\": false,\n" +
                "\"isApSuperior\": false,\n" +
                "\"type\": \"MELEE\",\n" +
                "\"hasAttackedThisTurn\": false,\n" +
                "\"hasMovedThisTurn\": false,\n" +
                "\"isDisarmed\": false,\n" +
                "\"isStunned\": false,\n" +
                "\"numberOfTurnsOfDisarm\": 0,\n" +
                "\"numberOfTurnsOfStun\": 0,\n" +
                "\"specialPowerActivationType\": \"NONE\",\n" +
                "\"positiveBuffs\": [],\n" +
                "\"negativeBuffs\": [],\n" +
                "\"hasFlag\": false,\n" +
                "\"id\": \"\",\n" +
                "\"name\": \"swinerider devil\",\n" +
                "\"requiredManas\": 6,\n" +
                "\"price\": 300\n" +
                "}");
        getMinionResource().put("monoeyedGiant", "{\n" +
                "\"healthPoint\": 12,\n" +
                "\"attackPoint\": 11,\n" +
                "\"startRange\": 1,\n" +
                "\"endRange\": 3,\n" +
                "\"isAntiHolyBuff\": false,\n" +
                "\"isAntiDisarm\": false,\n" +
                "\"isAntiPoison\": false,\n" +
                "\"isImmortal\": false,\n" +
                "\"isApSuperior\": false,\n" +
                "\"type\": \"HYBRID\",\n" +
                "\"hasAttackedThisTurn\": false,\n" +
                "\"hasMovedThisTurn\": false,\n" +
                "\"isDisarmed\": false,\n" +
                "\"isStunned\": false,\n" +
                "\"numberOfTurnsOfDisarm\": 0,\n" +
                "\"numberOfTurnsOfStun\": 0,\n" +
                "\"specialPower\": {\n" +
                "\"cellOrSoldier\": \"SOLDIER\",\n" +
                "\"target\": \"ENEMY\",\n" +
                "\"cellsType\": \"ALL_MINIONS_AROUND\",\n" +
                "\"lengthOfSideOfSquare\": 0,\n" +
                "\"buffNutralizer\": \"NONE\",\n" +
                "\"buffs\": [\n" +
                "{\n" +
                "\"numberOfTurnsOnTarget\": 0,\n" +
                "\"changeHp\": -2,\n" +
                "\"apShield\": 0,\n" +
                "\"changeAp\": 0,\n" +
                "\"numberOfTurns\": 1,\n" +
                "\"delay\": 0,\n" +
                "\"isDisarmer\": false,\n" +
                "\"isStunner\": false,\n" +
                "\"isPositive\": false,\n" +
                "\"onCellOrSoldier\": \"SOLDIER\",\n" +
                "\"isActive\": false\n" +
                "}\n" +
                "],\n" +
                "\"cells\": [],\n" +
                "\"id\": \"\",\n" +
                "\"name\": \"monoeyed giant spell\",\n" +
                "\"requiredManas\": 7,\n" +
                "\"price\": 0\n" +
                "},\n" +
                "\"specialPowerActivationType\": \"ON_DEATH\",\n" +
                "\"positiveBuffs\": [],\n" +
                "\"negativeBuffs\": [],\n" +
                "\"hasFlag\": false,\n" +
                "\"id\": \"\",\n" +
                "\"name\": \"monoeyed giant\",\n" +
                "\"requiredManas\": 7,\n" +
                "\"price\": 500\n" +
                "}");
        getMinionResource().put("poisonousSnake", "{\n" +
                "\"healthPoint\": 5,\n" +
                "\"attackPoint\": 6,\n" +
                "\"startRange\": 2,\n" +
                "\"endRange\": 4,\n" +
                "\"isAntiHolyBuff\": false,\n" +
                "\"isAntiDisarm\": false,\n" +
                "\"isAntiPoison\": false,\n" +
                "\"isImmortal\": false,\n" +
                "\"isApSuperior\": false,\n" +
                "\"type\": \"RANGED\",\n" +
                "\"hasAttackedThisTurn\": false,\n" +
                "\"hasMovedThisTurn\": false,\n" +
                "\"isDisarmed\": false,\n" +
                "\"isStunned\": false,\n" +
                "\"numberOfTurnsOfDisarm\": 0,\n" +
                "\"numberOfTurnsOfStun\": 0,\n" +
                "\"specialPower\": {\n" +
                "\"cellOrSoldier\": \"SOLDIER\",\n" +
                "\"target\": \"ENEMY\",\n" +
                "\"cellsType\": \"MONO_CELL\",\n" +
                "\"lengthOfSideOfSquare\": 0,\n" +
                "\"buffNutralizer\": \"NONE\",\n" +
                "\"buffs\": [\n" +
                "{\n" +
                "\"numberOfTurnsOnTarget\": 3,\n" +
                "\"changeHp\": -1,\n" +
                "\"apShield\": 0,\n" +
                "\"changeAp\": 0,\n" +
                "\"numberOfTurns\": 3,\n" +
                "\"delay\": 0,\n" +
                "\"isDisarmer\": false,\n" +
                "\"isStunner\": false,\n" +
                "\"isPositive\": false,\n" +
                "\"onCellOrSoldier\": \"SOLDIER\",\n" +
                "\"isActive\": false\n" +
                "}\n" +
                "],\n" +
                "\"cells\": [],\n" +
                "\"id\": \"\",\n" +
                "\"name\": \"poisonous snake spell\",\n" +
                "\"requiredManas\": 4,\n" +
                "\"price\": 0\n" +
                "},\n" +
                "\"specialPowerActivationType\": \"ON_ATTACK\",\n" +
                "\"positiveBuffs\": [],\n" +
                "\"negativeBuffs\": [],\n" +
                "\"hasFlag\": false,\n" +
                "\"id\": \"\",\n" +
                "\"name\": \"poisonous snake\",\n" +
                "\"requiredManas\": 4,\n" +
                "\"price\": 300\n" +
                "}");
        getMinionResource().put("fieryDragon", "{\n" +
                "\"healthPoint\": 9,\n" +
                "\"attackPoint\": 5,\n" +
                "\"startRange\": 2,\n" +
                "\"endRange\": 4,\n" +
                "\"isAntiHolyBuff\": false,\n" +
                "\"isAntiDisarm\": false,\n" +
                "\"isAntiPoison\": false,\n" +
                "\"isImmortal\": false,\n" +
                "\"isApSuperior\": false,\n" +
                "\"type\": \"RANGED\",\n" +
                "\"hasAttackedThisTurn\": false,\n" +
                "\"hasMovedThisTurn\": false,\n" +
                "\"isDisarmed\": false,\n" +
                "\"isStunned\": false,\n" +
                "\"numberOfTurnsOfDisarm\": 0,\n" +
                "\"numberOfTurnsOfStun\": 0,\n" +
                "\"specialPowerActivationType\": \"NONE\",\n" +
                "\"positiveBuffs\": [],\n" +
                "\"negativeBuffs\": [],\n" +
                "\"hasFlag\": false,\n" +
                "\"id\": \"\",\n" +
                "\"name\": \"fiery dragon\",\n" +
                "\"requiredManas\": 5,\n" +
                "\"price\": 250\n" +
                "}");
        getMinionResource().put("predatorLion", "{\n" +
                "\"healthPoint\": 1,\n" +
                "\"attackPoint\": 8,\n" +
                "\"startRange\": 1,\n" +
                "\"endRange\": 1,\n" +
                "\"isAntiHolyBuff\": true,\n" +
                "\"isAntiDisarm\": false,\n" +
                "\"isAntiPoison\": false,\n" +
                "\"isImmortal\": false,\n" +
                "\"isApSuperior\": false,\n" +
                "\"type\": \"MELEE\",\n" +
                "\"hasAttackedThisTurn\": false,\n" +
                "\"hasMovedThisTurn\": false,\n" +
                "\"isDisarmed\": false,\n" +
                "\"isStunned\": false,\n" +
                "\"numberOfTurnsOfDisarm\": 0,\n" +
                "\"numberOfTurnsOfStun\": 0,\n" +
                "\"specialPowerActivationType\": \"ON_ATTACK\",\n" +
                "\"positiveBuffs\": [],\n" +
                "\"negativeBuffs\": [],\n" +
                "\"hasFlag\": false,\n" +
                "\"id\": \"\",\n" +
                "\"name\": \"predator lion\",\n" +
                "\"requiredManas\": 2,\n" +
                "\"price\": 600\n" +
                "}");
        getMinionResource().put("giantSnake", "");
        getMinionResource().put("whiteWolf", "");
        getMinionResource().put("panther", "");
        getMinionResource().put("wolf", "");
        getMinionResource().put("witch", "");
        getMinionResource().put("grandWitch", "");
        getMinionResource().put("genii", "");
        getMinionResource().put("wildSwine", "");
        getMinionResource().put("elder", "");
        getMinionResource().put("geeve", "");
        getMinionResource().put("bahman", "");
        getMinionResource().put("ashkboos", "");
        getMinionResource().put("iraj", "");
        getMinionResource().put("bigGiant", "");
        getMinionResource().put("twoHeadedGiant", "");
        getMinionResource().put("queenOfWinter", "");
        getMinionResource().put("steelArmored", "");
        getMinionResource().put("siavash", "");
        getMinionResource().put("giantKing", "");
        getMinionResource().put("arzhangDeeve", "");
    }
}