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
        return  null;
    }

    private static String getSpecificHeroGson(String heroName) {
        return getHeroResource().get(heroName);
    }

    public static ArrayList<Hero> getAllHeros(){
        ArrayList <Hero> heroes = new ArrayList<>();
        getHeroResource().forEach((name , gson) -> heroes.add(getSpecificHero(name)));
        return heroes;
    }

    public static void setHeroResource() {
        //todo add Heros
    }

    String whiteDeeve = "{\n" +
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
            "}";
    String simorgh = "{\n" +
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
            "}";
    String sevenheadedDragon = "{\n" +
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
            "}";
    String rakhsh = "{\n" +
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
            "}";
    String zahhak = "";
    String kaveh = "{\n" +
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
            "\"target\": \"Friend\",\n" +
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
            "}";
    String arash = "";
    String legend = "";
    String esfandyad = "";
    String rostam = "";
}
