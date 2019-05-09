package resources;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.Hero;

import java.util.ArrayList;
import java.util.HashMap;

public class HeroResources {

    private static HashMap<String, String> heroResource = new HashMap<>();

    public static HashMap<String, String> getHeroResource() {
        return heroResource;
    }

    public static Hero getSpecificHero(String heroName) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        if (getSpecificHeroGson(heroName) != null)
            return gson.fromJson(getHeroResource().get(heroName), Hero.class);
        return null;
    }

    private static String getSpecificHeroGson(String heroName) {
        return getHeroResource().get(heroName);
    }

    public static ArrayList<Hero> getAllHeros() {
        ArrayList<Hero> heroes = new ArrayList<>();
        getHeroResource().forEach((name, gson) -> heroes.add(getSpecificHero(name)));
        return heroes;
    }

    public static void setHeroResource() {
        heroResource.put("white deeve", "{\n" +
                "\"coolDown\": 2,\n" +
                "\"healthPoint\": 50,\n" +
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
                "\"target\": \"FRIEND_HERO\",\n" +
                "\"cellsType\": \"MONO_CELL\",\n" +
                "\"lengthOfSideOfSquare\": 0,\n" +
                "\"buffNutralizer\": \"NONE\",\n" +
                "\"buffs\": [\n" +
                "{\n" +
                "\"numberOfTurnsOnTarget\": 0,\n" +
                "\"changeHp\": 0,\n" +
                "\"apShield\": 0,\n" +
                "\"changeAp\": 4,\n" +
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
                "\"name\": \"white deeve spell\",\n" +
                "\"requiredManas\": 1,\n" +
                "\"price\": 0\n" +
                "},\n" +
                "\"specialPowerActivationType\": \"ON_COMMAND\",\n" +
                "\"positiveBuffs\": [],\n" +
                "\"negativeBuffs\": [],\n" +
                "\"hasFlag\": false,\n" +
                "\"id\": \"\",\n" +
                "\"name\": \"white deeve\",\n" +
                "\"requiredManas\": 1,\n" +
                "\"price\": 8000\n" +
                "}");
        heroResource.put("simorgh", "{\n" +
                "\"coolDown\": 8,\n" +
                "\"healthPoint\": 50,\n" +
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
                "\"cellsType\": \"ALL\",\n" +
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
                "\"name\": \"simorgh spell\",\n" +
                "\"requiredManas\": 5,\n" +
                "\"price\": 0\n" +
                "},\n" +
                "\"specialPowerActivationType\": \"ON_COMMAND\",\n" +
                "\"positiveBuffs\": [],\n" +
                "\"negativeBuffs\": [],\n" +
                "\"hasFlag\": false,\n" +
                "\"id\": \"\",\n" +
                "\"name\": \"simorgh\",\n" +
                "\"requiredManas\": 5,\n" +
                "\"price\": 9000\n" +
                "}");
        heroResource.put("sevenheaded dragon", "{\n" +
                "\"coolDown\": 1,\n" +
                "\"healthPoint\": 50,\n" +
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
                "\"numberOfTurns\": 2147483647,\n" +
                "\"delay\": 0,\n" +
                "\"isDisarmer\": true,\n" +
                "\"isStunner\": false,\n" +
                "\"isPositive\": false,\n" +
                "\"onCellOrSoldier\": \"SOLDIER\",\n" +
                "\"isActive\": false\n" +
                "}\n" +
                "],\n" +
                "\"cells\": [],\n" +
                "\"id\": \"\",\n" +
                "\"name\": \"sevenheaded dragon spell\",\n" +
                "\"requiredManas\": 0,\n" +
                "\"price\": 0\n" +
                "},\n" +
                "\"specialPowerActivationType\": \"ON_COMMAND\",\n" +
                "\"positiveBuffs\": [],\n" +
                "\"negativeBuffs\": [],\n" +
                "\"hasFlag\": false,\n" +
                "\"id\": \"\",\n" +
                "\"name\": \"sevenheaded dragon\",\n" +
                "\"requiredManas\": 0,\n" +
                "\"price\": 8000\n" +
                "}");
        heroResource.put("rakhsh", "{\n" +
                "\"coolDown\": 2,\n" +
                "\"healthPoint\": 50,\n" +
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
                "\"name\": \"rakhsh spell\",\n" +
                "\"requiredManas\": 1,\n" +
                "\"price\": 0\n" +
                "},\n" +
                "\"specialPowerActivationType\": \"ON_COMMAND\",\n" +
                "\"positiveBuffs\": [],\n" +
                "\"negativeBuffs\": [],\n" +
                "\"hasFlag\": false,\n" +
                "\"id\": \"\",\n" +
                "\"name\": \"rakhsh\",\n" +
                "\"requiredManas\": 1,\n" +
                "\"price\": 8000\n" +
                "}");
        heroResource.put("zahhak", "{\n" +
                "\"coolDown\": 0,\n" +
                "\"healthPoint\": 50,\n" +
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
                "\"numberOfTurnsOnTarget\": 3,\n" +
                "\"changeHp\": -1,\n" +
                "\"apShield\": 0,\n" +
                "\"changeAp\": 0,\n" +
                "\"numberOfTurns\": 3,\n" +
                "\"delay\": 0,\n" +
                "\"isDisarmer\": false,\n" +
                "\"isPoison\": true,\n" +
                "\"isStunner\": false,\n" +
                "\"isPositive\": false,\n" +
                "\"onCellOrSoldier\": \"SOLDIER\",\n" +
                "\"isActive\": false\n" +
                "}\n" +
                "],\n" +
                "\"cells\": [],\n" +
                "\"id\": \"\",\n" +
                "\"name\": \"rakhsh spell\",\n" +
                "\"requiredManas\": 0,\n" +
                "\"price\": 0\n" +
                "},\n" +
                "\"specialPowerActivationType\": \"ON_ATTACK\",\n" +
                "\"positiveBuffs\": [],\n" +
                "\"negativeBuffs\": [],\n" +
                "\"hasFlag\": false,\n" +
                "\"id\": \"\",\n" +
                "\"name\": \"zahhak\",\n" +
                "\"requiredManas\": 0,\n" +
                "\"price\": 10000\n" +
                "}");
        heroResource.put("kaveh", "{\n" +
                "\"coolDown\": 3,\n" +
                "\"healthPoint\": 50,\n" +
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
                "\"target\": \"FRIEND\",\n" +
                "\"cellsType\": \"MONO_CELL\",\n" +
                "\"lengthOfSideOfSquare\": 0,\n" +
                "\"buffNutralizer\": \"NONE\",\n" +
                "\"buffs\": [\n" +
                "{\n" +
                "\"numberOfTurnsOnTarget\": 0,\n" +
                "\"changeHp\": 0,\n" +
                "\"apShield\": 1,\n" +
                "\"changeAp\": 0,\n" +
                "\"numberOfTurns\": 3,\n" +
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
                "\"name\": \"rakhsh spell\",\n" +
                "\"requiredManas\": 1,\n" +
                "\"price\": 0\n" +
                "},\n" +
                "\"specialPowerActivationType\": \"ON_COMMAND\",\n" +
                "\"positiveBuffs\": [],\n" +
                "\"negativeBuffs\": [],\n" +
                "\"hasFlag\": false,\n" +
                "\"id\": \"\",\n" +
                "\"name\": \"kaveh\",\n" +
                "\"requiredManas\": 1,\n" +
                "\"price\": 8000\n" +
                "}");
        heroResource.put("arash", "{\n" +
                "\"coolDown\": 3,\n" +
                "\"healthPoint\": 30,\n" +
                "\"attackPoint\": 2,\n" +
                "\"startRange\": 2,\n" +
                "\"endRange\": 6,\n" +
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
                "\"cellsType\": \"ROW\",\n" +
                "\"lengthOfSideOfSquare\": 0,\n" +
                "\"buffNutralizer\": \"NONE\",\n" +
                "\"buffs\": [\n" +
                "{\n" +
                "\"numberOfTurnsOnTarget\": 0,\n" +
                "\"changeHp\": -4,\n" +
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
                "\"name\": \"arash spell\",\n" +
                "\"requiredManas\": 3,\n" +
                "\"price\": 0\n" +
                "},\n" +
                "\"specialPowerActivationType\": \"ON_COMMAND\",\n" +
                "\"positiveBuffs\": [],\n" +
                "\"negativeBuffs\": [],\n" +
                "\"hasFlag\": false,\n" +
                "\"id\": \"\",\n" +
                "\"name\": \"arash\",\n" +
                "\"requiredManas\": 3,\n" +
                "\"price\": 10000\n" +
                "}");
        heroResource.put("legend", "{\n" +
                "\"coolDown\": 2,\n" +
                "\"healthPoint\": 40,\n" +
                "\"attackPoint\": 3,\n" +
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
                "\"buffNutralizer\": \"BOTH\",\n" +
                "\"buffs\": [],\n" +
                "\"cells\": [],\n" +
                "\"id\": \"\",\n" +
                "\"name\": \"legend spell\",\n" +
                "\"requiredManas\": 1,\n" +
                "\"price\": 0\n" +
                "},\n" +
                "\"specialPowerActivationType\": \"ON_COMMAND\",\n" +
                "\"positiveBuffs\": [],\n" +
                "\"negativeBuffs\": [],\n" +
                "\"hasFlag\": false,\n" +
                "\"id\": \"\",\n" +
                "\"name\": \"legend\",\n" +
                "\"requiredManas\": 1,\n" +
                "\"price\": 11000\n" +
                "}");
        heroResource.put("esfandyar", "{\n" +
                "\"coolDown\": 0,\n" +
                "\"healthPoint\": 35,\n" +
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
                "\"specialPower\": {\n" +
                "\"cellOrSoldier\": \"SOLDIER\",\n" +
                "\"target\": \"ENEMY\",\n" +
                "\"cellsType\": \"MONO_CELL\",\n" +
                "\"lengthOfSideOfSquare\": 0,\n" +
                "\"buffNutralizer\": \"BOTH\",\n" +
                "\"buffs\": [\n" +
                "{\n" +
                "\"numberOfTurnsOnTarget\": 0,\n" +
                "\"changeHp\": 0,\n" +
                "\"apShield\": 3,\n" +
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
                "\"name\": \"esfandyar spell\",\n" +
                "\"requiredManas\": 0,\n" +
                "\"price\": 0\n" +
                "},\n" +
                "\"specialPowerActivationType\": \"ON_COMMAND\",\n" +
                "\"positiveBuffs\": [],\n" +
                "\"negativeBuffs\": [],\n" +
                "\"hasFlag\": false,\n" +
                "\"id\": \"\",\n" +
                "\"name\": \"esfandyar\",\n" +
                "\"requiredManas\": 0,\n" +
                "\"price\": 12000\n" +
                "}");
        heroResource.put("rostam", "{\n" +
                "\"coolDown\": 0,\n" +
                "\"healthPoint\": 55,\n" +
                "\"attackPoint\": 7,\n" +
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
                "\"name\": \"rostam\",\n" +
                "\"requiredManas\": 0,\n" +
                "\"price\": 8000\n" +
                "}");
    }

}
