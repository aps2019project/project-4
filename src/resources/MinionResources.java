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
        getMinionResource().put("persian archer", "{\n" +
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
        getMinionResource().put("persian swordsman", "{\n" +
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
        getMinionResource().put("persian spearsman", "{\n" +
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
        getMinionResource().put("persian horseman", "{\n" +
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
        getMinionResource().put("persian champion", "{\n" +
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
        getMinionResource().put("persian commander", "{\n" +
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
        getMinionResource().put("transoxanian archer", "{\n" +
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
        getMinionResource().put("transoxanian slingman", "{\n" +
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
        getMinionResource().put("transoxaninan spearsman", "{\n" +
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
        getMinionResource().put("transoxanian spy", "{\n" +
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
                "\"isPoison\": true,\n" +
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
        getMinionResource().put("transoxanian maceman", "{\n" +
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
        getMinionResource().put("transoxanian prince", "{\n" +
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
        getMinionResource().put("black devil", "{\n" +
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
        getMinionResource().put("stoneman giant", "{\n" +
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
        getMinionResource().put("swinerider devil", "{\n" +
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
        getMinionResource().put("monoeyed giant", "{\n" +
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
        getMinionResource().put("poisonous snake", "{\n" +
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
                "\"isPoison\": true,\n" +
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
        getMinionResource().put("fiery dragon", "{\n" +
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
        getMinionResource().put("predator lion", "{\n" +
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

        getMinionResource().put("giant snake", "{\n" +
                "\"healthPoint\": 14,\n" +
                "\"attackPoint\": 7,\n" +
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
                "\"specialPower\": {\n" +
                "\"cellOrSoldier\": \"SOLDIER\",\n" +
                "\"target\": \"ENEMY\",\n" +
                "\"cellsType\": \"ALL_MINIONS_AROUND_DISTANCE_2\",\n" +
                "\"lengthOfSideOfSquare\": 0,\n" +
                "\"buffNutralizer\": \"NONE\",\n" +
                "\"buffs\": [\n" +
                "{\n" +
                "\"numberOfTurnsOnTarget\": 0,\n" +
                "\"changeHp\": 0,\n" +
                "\"apShield\": -1,\n" +
                "\"changeAp\": 0,\n" +
                "\"numberOfTurns\": 2147483647,\n" +
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
                "\"name\": \"giant snake spell\",\n" +
                "\"requiredManas\": 8,\n" +
                "\"price\": 0\n" +
                "},\n" +
                "\"specialPowerActivationType\": \"ON_SPAWN\",\n" +
                "\"positiveBuffs\": [],\n" +
                "\"negativeBuffs\": [],\n" +
                "\"hasFlag\": false,\n" +
                "\"id\": \"\",\n" +
                "\"name\": \"giant snake\",\n" +
                "\"requiredManas\": 8,\n" +
                "\"price\": 500\n" +
                "}");
        getMinionResource().put("white wolf", "{\n" +
                "\"healthPoint\": 8,\n" +
                "\"attackPoint\": 2,\n" +
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
                "\"changeHp\": -6,\n" +
                "\"apShield\": 0,\n" +
                "\"changeAp\": 0,\n" +
                "\"numberOfTurns\": 1,\n" +
                "\"delay\": 0,\n" +
                "\"isDisarmer\": false,\n" +
                "\"isStunner\": false,\n" +
                "\"isPositive\": false,\n" +
                "\"onCellOrSoldier\": \"SOLDIER\",\n" +
                "\"isActive\": false\n" +
                "},\n" +
                "{\n" +
                "\"numberOfTurnsOnTarget\": 0,\n" +
                "\"changeHp\": -4,\n" +
                "\"apShield\": 0,\n" +
                "\"changeAp\": 0,\n" +
                "\"numberOfTurns\": 1,\n" +
                "\"delay\": 1,\n" +
                "\"isDisarmer\": false,\n" +
                "\"isStunner\": false,\n" +
                "\"isPositive\": false,\n" +
                "\"onCellOrSoldier\": \"SOLDIER\",\n" +
                "\"isActive\": false\n" +
                "}\n" +
                "],\n" +
                "\"cells\": [],\n" +
                "\"id\": \"\",\n" +
                "\"name\": \"white wolf spell\",\n" +
                "\"requiredManas\": 5,\n" +
                "\"price\": 0\n" +
                "},\n" +
                "\"specialPowerActivationType\": \"ON_ATTACK\",\n" +
                "\"positiveBuffs\": [],\n" +
                "\"negativeBuffs\": [],\n" +
                "\"hasFlag\": false,\n" +
                "\"id\": \"\",\n" +
                "\"name\": \"white wolf\",\n" +
                "\"requiredManas\": 5,\n" +
                "\"price\": 400\n" +
                "}");
        getMinionResource().put("panther", "{\n" +
                "\"healthPoint\": 6,\n" +
                "\"attackPoint\": 2,\n" +
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
                "\"changeHp\": -8,\n" +
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
                "\"name\": \"panther spell\",\n" +
                "\"requiredManas\": 4,\n" +
                "\"price\": 0\n" +
                "},\n" +
                "\"specialPowerActivationType\": \"ON_ATTACK\",\n" +
                "\"positiveBuffs\": [],\n" +
                "\"negativeBuffs\": [],\n" +
                "\"hasFlag\": false,\n" +
                "\"id\": \"\",\n" +
                "\"name\": \"panther\",\n" +
                "\"requiredManas\": 4,\n" +
                "\"price\": 400\n" +
                "}");
        getMinionResource().put("wolf", "{\n" +
                "\"healthPoint\": 6,\n" +
                "\"attackPoint\": 1,\n" +
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
                "\"changeHp\": -6,\n" +
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
                "\"name\": \"wolf spell\",\n" +
                "\"requiredManas\": 3,\n" +
                "\"price\": 0\n" +
                "},\n" +
                "\"specialPowerActivationType\": \"ON_ATTACK\",\n" +
                "\"positiveBuffs\": [],\n" +
                "\"negativeBuffs\": [],\n" +
                "\"hasFlag\": false,\n" +
                "\"id\": \"\",\n" +
                "\"name\": \"wolf\",\n" +
                "\"requiredManas\": 3,\n" +
                "\"price\": 400\n" +
                "}");
        getMinionResource().put("witch", "{\n" +
                "\"healthPoint\": 5,\n" +
                "\"attackPoint\": 4,\n" +
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
                "\"cellsType\": \"ALL_MINIONS_AROUND_AND_ITSELF\",\n" +
                "\"lengthOfSideOfSquare\": 0,\n" +
                "\"buffNutralizer\": \"NONE\",\n" +
                "\"buffs\": [\n" +
                "{\n" +
                "\"numberOfTurnsOnTarget\": 0,\n" +
                "\"changeHp\": 0,\n" +
                "\"apShield\": 0,\n" +
                "\"changeAp\": 2,\n" +
                "\"numberOfTurns\": 1,\n" +
                "\"delay\": 0,\n" +
                "\"isDisarmer\": false,\n" +
                "\"isStunner\": false,\n" +
                "\"isPositive\": true,\n" +
                "\"onCellOrSoldier\": \"SOLDIER\",\n" +
                "\"isActive\": false\n" +
                "},\n" +
                "{\n" +
                "\"numberOfTurnsOnTarget\": 1,\n" +
                "\"changeHp\": -1,\n" +
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
                "\"name\": \"witch spell\",\n" +
                "\"requiredManas\": 4,\n" +
                "\"price\": 0\n" +
                "},\n" +
                "\"specialPowerActivationType\": \"PASSIVE\",\n" +
                "\"positiveBuffs\": [],\n" +
                "\"negativeBuffs\": [],\n" +
                "\"hasFlag\": false,\n" +
                "\"id\": \"\",\n" +
                "\"name\": \"witch\",\n" +
                "\"requiredManas\": 4,\n" +
                "\"price\": 550\n" +
                "}");
        getMinionResource().put("grand witch", "{\n" +
                "\"healthPoint\": 6,\n" +
                "\"attackPoint\": 6,\n" +
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
                "\"specialPower\": {\n" +
                "\"cellOrSoldier\": \"SOLDIER\",\n" +
                "\"target\": \"ENEMY\",\n" +
                "\"cellsType\": \"ALL_MINIONS_AROUND_AND_ITSELF\",\n" +
                "\"lengthOfSideOfSquare\": 0,\n" +
                "\"buffNutralizer\": \"NONE\",\n" +
                "\"buffs\": [\n" +
                "{\n" +
                "\"numberOfTurnsOnTarget\": 0,\n" +
                "\"changeHp\": 0,\n" +
                "\"apShield\": 0,\n" +
                "\"changeAp\": 2,\n" +
                "\"numberOfTurns\": 1,\n" +
                "\"delay\": 0,\n" +
                "\"isDisarmer\": false,\n" +
                "\"isStunner\": false,\n" +
                "\"isPositive\": true,\n" +
                "\"onCellOrSoldier\": \"SOLDIER\",\n" +
                "\"isActive\": false\n" +
                "},\n" +
                "{\n" +
                "\"numberOfTurnsOnTarget\": 0,\n" +
                "\"changeHp\": 0,\n" +
                "\"apShield\": 1,\n" +
                "\"changeAp\": 0,\n" +
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
                "\"name\": \"grand witch spell\",\n" +
                "\"requiredManas\": 6,\n" +
                "\"price\": 0\n" +
                "},\n" +
                "\"specialPowerActivationType\": \"PASSIVE\",\n" +
                "\"positiveBuffs\": [],\n" +
                "\"negativeBuffs\": [],\n" +
                "\"hasFlag\": false,\n" +
                "\"id\": \"\",\n" +
                "\"name\": \"grand witch\",\n" +
                "\"requiredManas\": 6,\n" +
                "\"price\": 550\n" +
                "}");
        getMinionResource().put("genii", "{\n" +
                "\"healthPoint\": 10,\n" +
                "\"attackPoint\": 4,\n" +
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
                "\"cellsType\": \"ALL\",\n" +
                "\"lengthOfSideOfSquare\": 0,\n" +
                "\"buffNutralizer\": \"NONE\",\n" +
                "\"buffs\": [\n" +
                "{\n" +
                "\"numberOfTurnsOnTarget\": 0,\n" +
                "\"changeHp\": 0,\n" +
                "\"apShield\": 0,\n" +
                "\"changeAp\": 1,\n" +
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
                "\"name\": \"genii spell\",\n" +
                "\"requiredManas\": 5,\n" +
                "\"price\": 0\n" +
                "},\n" +
                "\"specialPowerActivationType\": \"PASSIVE\",\n" +
                "\"positiveBuffs\": [],\n" +
                "\"negativeBuffs\": [],\n" +
                "\"hasFlag\": false,\n" +
                "\"id\": \"\",\n" +
                "\"name\": \"genii\",\n" +
                "\"requiredManas\": 5,\n" +
                "\"price\": 500\n" +
                "}");
        getMinionResource().put("wild swine", "{\n" +
                "\"healthPoint\": 10,\n" +
                "\"attackPoint\": 14,\n" +
                "\"startRange\": 1,\n" +
                "\"endRange\": 1,\n" +
                "\"isAntiHolyBuff\": false,\n" +
                "\"isAntiDisarm\": true,\n" +
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
                "\"specialPowerActivationType\": \"ON_DEFEND\",\n" +
                "\"positiveBuffs\": [],\n" +
                "\"negativeBuffs\": [],\n" +
                "\"hasFlag\": false,\n" +
                "\"id\": \"\",\n" +
                "\"name\": \"wild swine\",\n" +
                "\"requiredManas\": 6,\n" +
                "\"price\": 500\n" +
                "}");
        getMinionResource().put("elder", "{\n" +
                "\"healthPoint\": 20,\n" +
                "\"attackPoint\": 12,\n" +
                "\"startRange\": 1,\n" +
                "\"endRange\": 1,\n" +
                "\"isAntiHolyBuff\": false,\n" +
                "\"isAntiDisarm\": false,\n" +
                "\"isAntiPoison\": true,\n" +
                "\"isImmortal\": false,\n" +
                "\"isApSuperior\": false,\n" +
                "\"type\": \"MELEE\",\n" +
                "\"hasAttackedThisTurn\": false,\n" +
                "\"hasMovedThisTurn\": false,\n" +
                "\"isDisarmed\": false,\n" +
                "\"isStunned\": false,\n" +
                "\"numberOfTurnsOfDisarm\": 0,\n" +
                "\"numberOfTurnsOfStun\": 0,\n" +
                "\"specialPowerActivationType\": \"ON_DEFEND\",\n" +
                "\"positiveBuffs\": [],\n" +
                "\"negativeBuffs\": [],\n" +
                "\"hasFlag\": false,\n" +
                "\"id\": \"\",\n" +
                "\"name\": \"elder\",\n" +
                "\"requiredManas\": 8,\n" +
                "\"price\": 400\n" +
                "}");
        getMinionResource().put("geeve", "{\n" +
                "\"healthPoint\": 5,\n" +
                "\"attackPoint\": 7,\n" +
                "\"startRange\": 2,\n" +
                "\"endRange\": 5,\n" +
                "\"isAntiHolyBuff\": false,\n" +
                "\"isAntiDisarm\": false,\n" +
                "\"isAntiPoison\": false,\n" +
                "\"isImmortal\": true,\n" +
                "\"isApSuperior\": false,\n" +
                "\"type\": \"RANGED\",\n" +
                "\"hasAttackedThisTurn\": false,\n" +
                "\"hasMovedThisTurn\": false,\n" +
                "\"isDisarmed\": false,\n" +
                "\"isStunned\": false,\n" +
                "\"numberOfTurnsOfDisarm\": 0,\n" +
                "\"numberOfTurnsOfStun\": 0,\n" +
                "\"specialPowerActivationType\": \"ON_DEFEND\",\n" +
                "\"positiveBuffs\": [],\n" +
                "\"negativeBuffs\": [],\n" +
                "\"hasFlag\": false,\n" +
                "\"id\": \"\",\n" +
                "\"name\": \"geeve\",\n" +
                "\"requiredManas\": 4,\n" +
                "\"price\": 450\n" +
                "}");
        getMinionResource().put("bahman", "{\n" +
                "\"healthPoint\": 16,\n" +
                "\"attackPoint\": 9,\n" +
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
                "\"cellsType\": \"RANDOM_MINION_OF_ALL\",\n" +
                "\"lengthOfSideOfSquare\": 0,\n" +
                "\"buffNutralizer\": \"NONE\",\n" +
                "\"buffs\": [\n" +
                "{\n" +
                "\"numberOfTurnsOnTarget\": 0,\n" +
                "\"changeHp\": -16,\n" +
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
                "\"name\": \"bahman spell\",\n" +
                "\"requiredManas\": 8,\n" +
                "\"price\": 0\n" +
                "},\n" +
                "\"specialPowerActivationType\": \"ON_SPAWN\",\n" +
                "\"positiveBuffs\": [],\n" +
                "\"negativeBuffs\": [],\n" +
                "\"hasFlag\": false,\n" +
                "\"id\": \"\",\n" +
                "\"name\": \"bahman\",\n" +
                "\"requiredManas\": 8,\n" +
                "\"price\": 450\n" +
                "}");
        getMinionResource().put("ashkboos", "{\n" +
                "\"healthPoint\": 14,\n" +
                "\"attackPoint\": 8,\n" +
                "\"startRange\": 1,\n" +
                "\"endRange\": 1,\n" +
                "\"isAntiHolyBuff\": false,\n" +
                "\"isAntiDisarm\": false,\n" +
                "\"isAntiPoison\": false,\n" +
                "\"isImmortal\": false,\n" +
                "\"isApSuperior\": true,\n" +
                "\"type\": \"MELEE\",\n" +
                "\"hasAttackedThisTurn\": false,\n" +
                "\"hasMovedThisTurn\": false,\n" +
                "\"isDisarmed\": false,\n" +
                "\"isStunned\": false,\n" +
                "\"numberOfTurnsOfDisarm\": 0,\n" +
                "\"numberOfTurnsOfStun\": 0,\n" +
                "\"specialPowerActivationType\": \"ON_DEFEND\",\n" +
                "\"positiveBuffs\": [],\n" +
                "\"negativeBuffs\": [],\n" +
                "\"hasFlag\": false,\n" +
                "\"id\": \"\",\n" +
                "\"name\": \"ashkboos\",\n" +
                "\"requiredManas\": 7,\n" +
                "\"price\": 400\n" +
                "}");
        getMinionResource().put("iraj", "{\n" +
                "\"healthPoint\": 6,\n" +
                "\"attackPoint\": 20,\n" +
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
                "\"specialPowerActivationType\": \"NONE\",\n" +
                "\"positiveBuffs\": [],\n" +
                "\"negativeBuffs\": [],\n" +
                "\"hasFlag\": false,\n" +
                "\"id\": \"\",\n" +
                "\"name\": \"iraj\",\n" +
                "\"requiredManas\": 4,\n" +
                "\"price\": 500\n" +
                "}");
        getMinionResource().put("big giant", "{\n" +
                "\"healthPoint\": 30,\n" +
                "\"attackPoint\": 8,\n" +
                "\"startRange\": 1,\n" +
                "\"endRange\": 2,\n" +
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
                "\"name\": \"big giant\",\n" +
                "\"requiredManas\": 9,\n" +
                "\"price\": 600\n" +
                "}");
        getMinionResource().put("twoheaded giant", "{\n" +
                "\"healthPoint\": 10,\n" +
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
                "\"cellsType\": \"RANDOM_MINION_OF_ALL\",\n" +
                "\"lengthOfSideOfSquare\": 0,\n" +
                "\"buffNutralizer\": \"POSITIVE\",\n" +
                "\"buffs\": [],\n" +
                "\"cells\": [],\n" +
                "\"id\": \"\",\n" +
                "\"name\": \"twoheaded giant spell\",\n" +
                "\"requiredManas\": 4,\n" +
                "\"price\": 0\n" +
                "},\n" +
                "\"specialPowerActivationType\": \"ON_ATTACK\",\n" +
                "\"positiveBuffs\": [],\n" +
                "\"negativeBuffs\": [],\n" +
                "\"hasFlag\": false,\n" +
                "\"id\": \"\",\n" +
                "\"name\": \"twoheaded giant\",\n" +
                "\"requiredManas\": 4,\n" +
                "\"price\": 550\n" +
                "}");
        getMinionResource().put("queen of winter", "{\n" +
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
                "\"specialPower\": {\n" +
                "\"cellOrSoldier\": \"SOLDIER\",\n" +
                "\"target\": \"ENEMY\",\n" +
                "\"cellsType\": \"ALL_MINIONS_AROUND\",\n" +
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
                "\"name\": \"queen of winter spell\",\n" +
                "\"requiredManas\": 3,\n" +
                "\"price\": 0\n" +
                "},\n" +
                "\"specialPowerActivationType\": \"ON_SPAWN\",\n" +
                "\"positiveBuffs\": [],\n" +
                "\"negativeBuffs\": [],\n" +
                "\"hasFlag\": false,\n" +
                "\"id\": \"\",\n" +
                "\"name\": \"queen Of Winter\",\n" +
                "\"requiredManas\": 3,\n" +
                "\"price\": 500\n" +
                "}");
        getMinionResource().put("steel armored", "{\n" +
                "\"healthPoint\": 1,\n" +
                "\"attackPoint\": 1,\n" +
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
                "\"cellsType\": \"ALL_MINIONS_AROUND\",\n" +
                "\"lengthOfSideOfSquare\": 0,\n" +
                "\"buffNutralizer\": \"NONE\",\n" +
                "\"buffs\": [\n" +
                "{\n" +
                "\"numberOfTurnsOnTarget\": 0,\n" +
                "\"changeHp\": 0,\n" +
                "\"apShield\": 12,\n" +
                "\"changeAp\": 0,\n" +
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
                "\"name\": \"steel armored spell\",\n" +
                "\"requiredManas\": 3,\n" +
                "\"price\": 0\n" +
                "},\n" +
                "\"specialPowerActivationType\": \"ON_SPAWN\",\n" +
                "\"positiveBuffs\": [],\n" +
                "\"negativeBuffs\": [],\n" +
                "\"hasFlag\": false,\n" +
                "\"id\": \"\",\n" +
                "\"name\": \"steel armored\",\n" +
                "\"requiredManas\": 3,\n" +
                "\"price\": 650\n" +
                "}");
        getMinionResource().put("siavash", "{\n" +
                "\"healthPoint\": 8,\n" +
                "\"attackPoint\": 5,\n" +
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
                "\"target\": \"ENEMY_HERO\",\n" +
                "\"cellsType\": \"MONO_CELL\",\n" +
                "\"lengthOfSideOfSquare\": 0,\n" +
                "\"buffNutralizer\": \"NONE\",\n" +
                "\"buffs\": [\n" +
                "{\n" +
                "\"numberOfTurnsOnTarget\": 0,\n" +
                "\"changeHp\": -6,\n" +
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
                "\"name\": \"siavash spell\",\n" +
                "\"requiredManas\": 4,\n" +
                "\"price\": 0\n" +
                "},\n" +
                "\"specialPowerActivationType\": \"ON_DEATH\",\n" +
                "\"positiveBuffs\": [],\n" +
                "\"negativeBuffs\": [],\n" +
                "\"hasFlag\": false,\n" +
                "\"id\": \"\",\n" +
                "\"name\": \"siavash\",\n" +
                "\"requiredManas\": 4,\n" +
                "\"price\": 350\n" +
                "}");
        getMinionResource().put("giant king", "{\n" +
                "\"healthPoint\": 10,\n" +
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
                "\"name\": \"giant king\",\n" +
                "\"requiredManas\": 5,\n" +
                "\"price\": 600\n" +
                "}");
        getMinionResource().put("arzhang deeve", "{\n" +
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
                "\"specialPowerActivationType\": \"COMBO\",\n" +
                "\"positiveBuffs\": [],\n" +
                "\"negativeBuffs\": [],\n" +
                "\"hasFlag\": false,\n" +
                "\"id\": \"\",\n" +
                "\"name\": \"arzhang deeve\",\n" +
                "\"requiredManas\": 3,\n" +
                "\"price\": 600\n" +
                "}");
    }
}