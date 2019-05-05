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
        getMinionResource().put("persianArcher", "{\n" +
                "\"healthPoint\": 2,\n" +
                "\"attackPoint\": 6,\n" +
                "\"startRange\": 2,\n" +
                "\"endRange\": 7,\n" +
                "\"type\": \"RANGED\",\n" +
                "\"hasAttackedThisTurn\": false,\n" +
                "\"hasMovedThisTurn\": false,\n" +
                "\"isDisarmed\": false,\n" +
                "\"isStuned\": false,\n" +
                "\"numberOfTurnsOfDisarm\": 0,\n" +
                "\"name\": \"persianArcher\",\n" +
                "\"requiredManas\": 4,\n" +
                "\"price\": 300\n" +
                "}");
        //getMinionResource().put("persianSwordman", "");
        //todo add other minion Gsons
    }

    String persianArcher = "{\n" +
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
            "}";
    String persianSwordsman = "{\n" +
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
            "}";
    String persianSpearsman = "{\n" +
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
            "}";
    String persianHorseman = "{\n" +
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
            "}";
    String persianChampion = "{\n" +
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
            "\"name\": \"persian swordsman spell\",\n" +
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
            "}";
    String persianCommander = "";
    String transoxanianArcher = "";
    String transoxanianSlingman = "";
    String transoxaninaSpearman = "";
    String transoxanianSpy = "";
    String transoxanianMaceman = "";
    String transoxanianPrince = "";
    String blackDevil = "";
    String stonemanGiant = "";
    String eagle = "";
    String swineriderDevil = "";
    String monoeyedGiant = "";
    String poisonousSnake = "";
    String fieryDragon = "";
    String predatorLion = "";
    String giantSnake = "";
    String whiteWolf = "";
    String panther = "";
    String wolf = "";
    String witch = "";
    String grandWitch = "";
    String genii = "";
    String wildSwine = "";
    String elder = "";
    String geeve = "";
    String bahman = "";
    String ashkboos = "";
    String iraj = "";
    String bigGiant = "";
    String twoHeadedGiant = "";
    String queenOfWinter = "";
    String steelArmored = "";
    String siavash = "";
    String giantKing = "";
    String arzhangDeeve = "";


}