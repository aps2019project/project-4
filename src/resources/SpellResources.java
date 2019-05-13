package resources;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.Spell;

import java.util.ArrayList;
import java.util.HashMap;

public class SpellResources {

    private static HashMap<String, String> spellResource = new HashMap<>();

    public static HashMap<String, String> getSpellResource() {
        return spellResource;
    }

    public static Spell getSpecificSpell(String spellName) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        if (getSpecificSpellGson(spellName) != null) {
            Spell spell = gson.fromJson(getSpellResource().get(spellName), Spell.class);
            spell.setName(spellName);
            return spell;
        }
        return null;
    }

    private static String getSpecificSpellGson(String spellName) {
        return getSpellResource().get(spellName);
    }

    public static ArrayList<Spell> getAllSpells() {
        ArrayList<Spell> spells = new ArrayList<>();
        getSpellResource().forEach((name, gson) -> spells.add(getSpecificSpell(name)));
        return spells;
    }


    public static void setSpellResource() {
        getSpellResource().put("Total Disarm", "{\n" +
                "\"cellOrSoldier\": \"SOLDIER\",\n" +
                "\"target\": \"ENEMY\",\n" +
                "\"cellsType\": \"MONO_CELL\",\n" +
                "\"lengthOfSideOfSquare\": 0,\n" +
                "\"buffNutralizer\": \"NONE\",\n" +
                "\"buffs\": [\n" +
                "{\n" +
                "\"onCellOrSoldier\": \"SOLDIER\",\n" +
                "\"numberOfTurnsOnTarget\": 0,\n" +
                "\"changeHp\": 0,\n" +
                "\"apShield\": 0,\n" +
                "\"changeAp\": 0,\n" +
                "\"numberOfTurns\": 2147483647,\n" +
                "\"delay\": 0,\n" +
                "\"isDisarmer\": true,\n" +
                "\"isStunner\": false,\n" +
                "\"isPositive\": false,\n" +
                "\"isActive\": false\n" +
                "}\n" +
                "],\n" +
                "\"cells\": [],\n" +
                "\"id\": \"\",\n" +
                "\"name\": \"Total Disarm\",\n" +
                "\"requiredManas\": 0,\n" +
                "\"price\": 1000\n" +
                "}");
        getSpellResource().put("Area Dispel", "{\n" +
                "\"cellOrSoldier\": \"SOLDIER\",\n" +
                "\"target\": \"BOTH\",\n" +
                "\"cellsType\": \"SQUARE\",\n" +
                "\"lengthOfSideOfSquare\": 2,\n" +
                "\"buffNutralizer\": \"BOTH\",\n" +
                "\"buffs\": [],\n" +
                "\"cells\": [],\n" +
                "\"id\": \"\",\n" +
                "\"name\": \"Area Dispel\",\n" +
                "\"requiredManas\": 2,\n" +
                "\"price\": 1500\n" +
                "}");
        getSpellResource().put("Empower", "{\n" +
                "\"cellOrSoldier\": \"SOLDIER\",\n" +
                "\"target\": \"FRIEND\",\n" +
                "\"cellsType\": \"MONO_CELL\",\n" +
                "\"lengthOfSideOfSquare\": 0,\n" +
                "\"buffNutralizer\": \"NONE\",\n" +
                "\"buffs\": [\n" +
                "{\n" +
                "\"onCellOrSoldier\": \"SOLDIER\",\n" +
                "\"numberOfTurnsOnTarget\": 0,\n" +
                "\"changeHp\": 0,\n" +
                "\"apShield\": 0,\n" +
                "\"changeAp\": 2,\n" +
                "\"numberOfTurns\": 2147483647,\n" +
                "\"delay\": 0,\n" +
                "\"isDisarmer\": false,\n" +
                "\"isStunner\": false,\n" +
                "\"isPositive\": true,\n" +
                "\"isActive\": false\n" +
                "}\n" +
                "],\n" +
                "\"cells\": [],\n" +
                "\"id\": \"\",\n" +
                "\"name\": \"Empower\",\n" +
                "\"requiredManas\": 1,\n" +
                "\"price\": 250\n" +
                "}");
        getSpellResource().put("FireBall", "{\n" +
                "\"cellOrSoldier\": \"SOLDIER\",\n" +
                "\"target\": \"ENEMY\",\n" +
                "\"cellsType\": \"MONO_CELL\",\n" +
                "\"lengthOfSideOfSquare\": 0,\n" +
                "\"buffNutralizer\": \"NONE\",\n" +
                "\"buffs\": [\n" +
                "{\n" +
                "\"onCellOrSoldier\": \"SOLDIER\",\n" +
                "\"numberOfTurnsOnTarget\": 0,\n" +
                "\"changeHp\": -4,\n" +
                "\"apShield\": 0,\n" +
                "\"changeAp\": 0,\n" +
                "\"numberOfTurns\": 1,\n" +
                "\"delay\": 0,\n" +
                "\"isDisarmer\": false,\n" +
                "\"isStunner\": false,\n" +
                "\"isPositive\": false,\n" +
                "\"isActive\": false\n" +
                "}\n" +
                "],\n" +
                "\"cells\": [],\n" +
                "\"id\": \"\",\n" +
                "\"name\": \"FireBall\",\n" +
                "\"requiredManas\": 1,\n" +
                "\"price\": 400\n" +
                "}");
        getSpellResource().put("God Strength", "{\n" +
                "\"cellOrSoldier\": \"SOLDIER\",\n" +
                "\"target\": \"FRIEND_HERO\",\n" +
                "\"cellsType\": \"MONO_CELL\",\n" +
                "\"lengthOfSideOfSquare\": 0,\n" +
                "\"buffNutralizer\": \"NONE\",\n" +
                "\"buffs\": [\n" +
                "{\n" +
                "\"onCellOrSoldier\": \"SOLDIER\",\n" +
                "\"numberOfTurnsOnTarget\": 0,\n" +
                "\"changeHp\": 0,\n" +
                "\"apShield\": 0,\n" +
                "\"changeAp\": 4,\n" +
                "\"numberOfTurns\": 2147483647,\n" +
                "\"delay\": 0,\n" +
                "\"isDisarmer\": false,\n" +
                "\"isStunner\": false,\n" +
                "\"isPositive\": true,\n" +
                "\"isActive\": false\n" +
                "}\n" +
                "],\n" +
                "\"cells\": [],\n" +
                "\"id\": \"\",\n" +
                "\"name\": \"God Strength\",\n" +
                "\"requiredManas\": 4,\n" +
                "\"price\": 450\n" +
                "}");
        getSpellResource().put("Hell Fire", "{\n" +
                "\"cellOrSoldier\": \"CELL\",\n" +
                "\"target\": \"BOTH\",\n" +
                "\"cellsType\": \"SQUARE\",\n" +
                "\"lengthOfSideOfSquare\": 2,\n" +
                "\"buffNutralizer\": \"NONE\",\n" +
                "\"buffs\": [\n" +
                "{\n" +
                "\"onCellOrSoldier\": \"CELL\",\n" +
                "\"numberOfTurnsOnTarget\": 0,\n" +
                "\"changeHp\": -2,\n" +
                "\"apShield\": 0,\n" +
                "\"changeAp\": 0,\n" +
                "\"numberOfTurns\": 1,\n" +
                "\"delay\": 0,\n" +
                "\"isDisarmer\": false,\n" +
                "\"isStunner\": false,\n" +
                "\"isPositive\": false,\n" +
                "\"isActive\": false\n" +
                "}\n" +
                "],\n" +
                "\"cells\": [],\n" +
                "\"id\": \"\",\n" +
                "\"name\": \"Hell Fire\",\n" +
                "\"requiredManas\": 3,\n" +
                "\"price\": 600\n" +
                "}");
        getSpellResource().put("Lightning Bolt", "{\n" +
                "\"cellOrSoldier\": \"SOLDIER\",\n" +
                "\"target\": \"ENEMY_HERO\",\n" +
                "\"cellsType\": \"MONO_CELL\",\n" +
                "\"lengthOfSideOfSquare\": 0,\n" +
                "\"buffNutralizer\": \"NONE\",\n" +
                "\"buffs\": [\n" +
                "{\n" +
                "\"onCellOrSoldier\": \"SOLDIER\",\n" +
                "\"numberOfTurnsOnTarget\": 0,\n" +
                "\"changeHp\": -8,\n" +
                "\"apShield\": 0,\n" +
                "\"changeAp\": 0,\n" +
                "\"numberOfTurns\": 1,\n" +
                "\"delay\": 0,\n" +
                "\"isDisarmer\": false,\n" +
                "\"isStunner\": false,\n" +
                "\"isPositive\": false,\n" +
                "\"isActive\": false\n" +
                "}\n" +
                "],\n" +
                "\"cells\": [],\n" +
                "\"id\": \"\",\n" +
                "\"name\": \"Lightning Bolt\",\n" +
                "\"requiredManas\": 2,\n" +
                "\"price\": 1250\n" +
                "}");
        getSpellResource().put("Poison Lake", "{\n" +
                "\"cellOrSoldier\": \"CELL\",\n" +
                "\"target\": \"BOTH\",\n" +
                "\"cellsType\": \"SQUARE\",\n" +
                "\"lengthOfSideOfSquare\": 3,\n" +
                "\"buffNutralizer\": \"NONE\",\n" +
                "\"buffs\": [\n" +
                "{\n" +
                "\"onCellOrSoldier\": \"CELL\",\n" +
                "\"numberOfTurnsOnTarget\": 3,\n" +
                "\"changeHp\": -1,\n" +
                "\"apShield\": 0,\n" +
                "\"changeAp\": 0,\n" +
                "\"numberOfTurns\": 1,\n" +
                "\"delay\": 0,\n" +
                "\"isPoison\": true,\n" +
                "\"isDisarmer\": false,\n" +
                "\"isStunner\": false,\n" +
                "\"isPositive\": false,\n" +
                "\"isActive\": false\n" +
                "}\n" +
                "],\n" +
                "\"cells\": [],\n" +
                "\"id\": \"\",\n" +
                "\"name\": \"Poison Lake\",\n" +
                "\"requiredManas\": 5,\n" +
                "\"price\": 900\n" +
                "}");
        getSpellResource().put("Madness", "{\n" +
                "\"cellOrSoldier\": \"SOLDIER\",\n" +
                "\"target\": \"FRIEND\",\n" +
                "\"cellsType\": \"MONO_CELL\",\n" +
                "\"lengthOfSideOfSquare\": 0,\n" +
                "\"buffNutralizer\": \"NONE\",\n" +
                "\"buffs\": [\n" +
                "{\n" +
                "\"onCellOrSoldier\": \"SOLDIER\",\n" +
                "\"numberOfTurnsOnTarget\": 0,\n" +
                "\"changeHp\": 0,\n" +
                "\"apShield\": 0,\n" +
                "\"changeAp\": 0,\n" +
                "\"numberOfTurns\": 3,\n" +
                "\"delay\": 0,\n" +
                "\"isDisarmer\": true,\n" +
                "\"isStunner\": false,\n" +
                "\"isPositive\": false,\n" +
                "\"isActive\": false\n" +
                "},\n" +
                "{\n" +
                "\"onCellOrSoldier\": \"SOLDIER\",\n" +
                "\"numberOfTurnsOnTarget\": 0,\n" +
                "\"changeHp\": 0,\n" +
                "\"apShield\": 0,\n" +
                "\"changeAp\": 4,\n" +
                "\"numberOfTurns\": 3,\n" +
                "\"delay\": 0,\n" +
                "\"isDisarmer\": false,\n" +
                "\"isStunner\": false,\n" +
                "\"isPositive\": true,\n" +
                "\"isActive\": false\n" +
                "}\n" +
                "],\n" +
                "\"cells\": [],\n" +
                "\"id\": \"\",\n" +
                "\"name\": \"Madness\",\n" +
                "\"requiredManas\": 0,\n" +
                "\"price\": 650\n" +
                "}");
        getSpellResource().put("All Disarm", "{\n" +
                "\"cellOrSoldier\": \"SOLDIER\",\n" +
                "\"target\": \"ENEMY\",\n" +
                "\"cellsType\": \"ALL\",\n" +
                "\"lengthOfSideOfSquare\": 0,\n" +
                "\"buffNutralizer\": \"NONE\",\n" +
                "\"buffs\": [\n" +
                "{\n" +
                "\"onCellOrSoldier\": \"SOLDIER\",\n" +
                "\"numberOfTurnsOnTarget\": 0,\n" +
                "\"changeHp\": 0,\n" +
                "\"apShield\": 0,\n" +
                "\"changeAp\": 0,\n" +
                "\"numberOfTurns\": 1,\n" +
                "\"delay\": 0,\n" +
                "\"isDisarmer\": true,\n" +
                "\"isStunner\": false,\n" +
                "\"isPositive\": false,\n" +
                "\"isActive\": false\n" +
                "}\n" +
                "],\n" +
                "\"cells\": [],\n" +
                "\"id\": \"\",\n" +
                "\"name\": \"All Disarm\",\n" +
                "\"requiredManas\": 9,\n" +
                "\"price\": 2000\n" +
                "}");
        getSpellResource().put("All Poison", "{\n" +
                "\"cellOrSoldier\": \"SOLDIER\",\n" +
                "\"target\": \"ENEMY\",\n" +
                "\"cellsType\": \"ALL\",\n" +
                "\"lengthOfSideOfSquare\": 0,\n" +
                "\"buffNutralizer\": \"NONE\",\n" +
                "\"buffs\": [\n" +
                "{\n" +
                "\"onCellOrSoldier\": \"SOLDIER\",\n" +
                "\"numberOfTurnsOnTarget\": 4,\n" +
                "\"changeHp\": -1,\n" +
                "\"apShield\": 0,\n" +
                "\"changeAp\": 0,\n" +
                "\"numberOfTurns\": 1,\n" +
                "\"delay\": 0,\n" +
                "\"isPoison\": true,\n" +
                "\"isDisarmer\": false,\n" +
                "\"isStunner\": false,\n" +
                "\"isPositive\": false,\n" +
                "\"isActive\": false\n" +
                "}\n" +
                "],\n" +
                "\"cells\": [],\n" +
                "\"id\": \"\",\n" +
                "\"name\": \"All Poison\",\n" +
                "\"requiredManas\": 8,\n" +
                "\"price\": 1500\n" +
                "}");
        getSpellResource().put("Dispel", "{\n" +
                "\"cellOrSoldier\": \"SOLDIER\",\n" +
                "\"target\": \"BOTH\",\n" +
                "\"cellsType\": \"MONO_CELL\",\n" +
                "\"lengthOfSideOfSquare\": 0,\n" +
                "\"buffNutralizer\": \"BOTH\",\n" +
                "\"buffs\": [],\n" +
                "\"cells\": [],\n" +
                "\"id\": \"\",\n" +
                "\"name\": \"Dispel\",\n" +
                "\"requiredManas\": 0,\n" +
                "\"price\": 2100\n" +
                "}");
        getSpellResource().put("HealthWithProfit", "{\n" +
                "\"cellOrSoldier\": \"SOLDIER\",\n" +
                "\"target\": \"FRIEND\",\n" +
                "\"cellsType\": \"MONO_CELL\",\n" +
                "\"lengthOfSideOfSquare\": 0,\n" +
                "\"buffNutralizer\": \"NONE\",\n" +
                "\"buffs\": [\n" +
                "{\n" +
                "\"onCellOrSoldier\": \"SOLDIER\",\n" +
                "\"numberOfTurnsOnTarget\": 1,\n" +
                "\"changeHp\": -6,\n" +
                "\"apShield\": 0,\n" +
                "\"changeAp\": 0,\n" +
                "\"numberOfTurns\": 1,\n" +
                "\"delay\": 0,\n" +
                "\"isDisarmer\": false,\n" +
                "\"isStunner\": false,\n" +
                "\"isPositive\": false,\n" +
                "\"isActive\": false\n" +
                "},\n" +
                "{\n" +
                "\"onCellOrSoldier\": \"SOLDIER\",\n" +
                "\"numberOfTurnsOnTarget\": 0,\n" +
                "\"changeHp\": 0,\n" +
                "\"apShield\": 2,\n" +
                "\"changeAp\": 0,\n" +
                "\"numberOfTurns\": 3,\n" +
                "\"delay\": 0,\n" +
                "\"isDisarmer\": false,\n" +
                "\"isStunner\": false,\n" +
                "\"isPositive\": true,\n" +
                "\"isActive\": false\n" +
                "}\n" +
                "],\n" +
                "\"cells\": [],\n" +
                "\"id\": \"\",\n" +
                "\"name\": \"HealthWithProfit\",\n" +
                "\"requiredManas\": 0,\n" +
                "\"price\": 2250\n" +
                "}");
        getSpellResource().put("PowerUp", "{\n" +
                "\"cellOrSoldier\": \"SOLDIER\",\n" +
                "\"target\": \"FRIEND\",\n" +
                "\"cellsType\": \"MONO_CELL\",\n" +
                "\"lengthOfSideOfSquare\": 0,\n" +
                "\"buffNutralizer\": \"NONE\",\n" +
                "\"buffs\": [\n" +
                "{\n" +
                "\"onCellOrSoldier\": \"SOLDIER\",\n" +
                "\"numberOfTurnsOnTarget\": 0,\n" +
                "\"changeHp\": 0,\n" +
                "\"apShield\": 0,\n" +
                "\"changeAp\": 6,\n" +
                "\"numberOfTurns\": 2147483647,\n" +
                "\"delay\": 0,\n" +
                "\"isDisarmer\": false,\n" +
                "\"isStunner\": false,\n" +
                "\"isPositive\": true,\n" +
                "\"isActive\": false\n" +
                "}\n" +
                "],\n" +
                "\"cells\": [],\n" +
                "\"id\": \"\",\n" +
                "\"name\": \"PowerUp\",\n" +
                "\"requiredManas\": 2,\n" +
                "\"price\": 2500\n" +
                "}");
        getSpellResource().put("All Power", "{\n" +
                "\"cellOrSoldier\": \"SOLDIER\",\n" +
                "\"target\": \"FRIEND\",\n" +
                "\"cellsType\": \"ALL\",\n" +
                "\"lengthOfSideOfSquare\": 0,\n" +
                "\"buffNutralizer\": \"NONE\",\n" +
                "\"buffs\": [\n" +
                "{\n" +
                "\"onCellOrSoldier\": \"SOLDIER\",\n" +
                "\"numberOfTurnsOnTarget\": 0,\n" +
                "\"changeHp\": 0,\n" +
                "\"apShield\": 0,\n" +
                "\"changeAp\": 2,\n" +
                "\"numberOfTurns\": 2147483647,\n" +
                "\"delay\": 0,\n" +
                "\"isDisarmer\": false,\n" +
                "\"isStunner\": false,\n" +
                "\"isPositive\": true,\n" +
                "\"isActive\": false\n" +
                "}\n" +
                "],\n" +
                "\"cells\": [],\n" +
                "\"id\": \"\",\n" +
                "\"name\": \"All Power\",\n" +
                "\"requiredManas\": 4,\n" +
                "\"price\": 2000\n" +
                "}");
        getSpellResource().put("All Attack", "{\n" +
                "\"cellOrSoldier\": \"SOLDIER\",\n" +
                "\"target\": \"ENEMY\",\n" +
                "\"cellsType\": \"COLUMN\",\n" +
                "\"lengthOfSideOfSquare\": 0,\n" +
                "\"buffNutralizer\": \"NONE\",\n" +
                "\"buffs\": [\n" +
                "{\n" +
                "\"onCellOrSoldier\": \"SOLDIER\",\n" +
                "\"numberOfTurnsOnTarget\": 0,\n" +
                "\"changeHp\": -6,\n" +
                "\"apShield\": 0,\n" +
                "\"changeAp\": 0,\n" +
                "\"numberOfTurns\": 1,\n" +
                "\"delay\": 0,\n" +
                "\"isDisarmer\": false,\n" +
                "\"isStunner\": false,\n" +
                "\"isPositive\": false,\n" +
                "\"isActive\": false\n" +
                "}\n" +
                "],\n" +
                "\"cells\": [],\n" +
                "\"id\": \"\",\n" +
                "\"name\": \"All Attack\",\n" +
                "\"requiredManas\": 4,\n" +
                "\"price\": 1500\n" +
                "}");
        getSpellResource().put("Weakening", "{\n" +
                "\"cellOrSoldier\": \"SOLDIER\",\n" +
                "\"target\": \"ENEMY\",\n" +
                "\"cellsType\": \"MONO_CELL\",\n" +
                "\"lengthOfSideOfSquare\": 0,\n" +
                "\"buffNutralizer\": \"NONE\",\n" +
                "\"buffs\": [\n" +
                "{\n" +
                "\"onCellOrSoldier\": \"SOLDIER\",\n" +
                "\"numberOfTurnsOnTarget\": 2147483647,\n" +
                "\"changeHp\": 0,\n" +
                "\"apShield\": 0,\n" +
                "\"changeAp\": -4,\n" +
                "\"numberOfTurns\": 2147483647,\n" +
                "\"delay\": 0,\n" +
                "\"isDisarmer\": false,\n" +
                "\"isStunner\": false,\n" +
                "\"isPositive\": false,\n" +
                "\"isActive\": false\n" +
                "}\n" +
                "],\n" +
                "\"cells\": [],\n" +
                "\"id\": \"\",\n" +
                "\"name\": \"Weakening\",\n" +
                "\"requiredManas\": 1,\n" +
                "\"price\": 1000\n" +
                "}");
        getSpellResource().put("Sacrifice", "{\n" +
                "\"cellOrSoldier\": \"SOLDIER\",\n" +
                "\"target\": \"FRIEND_MINION\",\n" +
                "\"cellsType\": \"MONO_CELL\",\n" +
                "\"lengthOfSideOfSquare\": 0,\n" +
                "\"buffNutralizer\": \"NONE\",\n" +
                "\"buffs\": [\n" +
                "{\n" +
                "\"onCellOrSoldier\": \"SOLDIER\",\n" +
                "\"numberOfTurnsOnTarget\": 0,\n" +
                "\"changeHp\": 0,\n" +
                "\"apShield\": 0,\n" +
                "\"changeAp\": 8,\n" +
                "\"numberOfTurns\": 2147483647,\n" +
                "\"delay\": 0,\n" +
                "\"isDisarmer\": false,\n" +
                "\"isStunner\": false,\n" +
                "\"isPositive\": true,\n" +
                "\"isActive\": false\n" +
                "},\n" +
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
                "\"isActive\": false\n" +
                "}\n" +
                "],\n" +
                "\"cells\": [],\n" +
                "\"id\": \"\",\n" +
                "\"name\": \"Sacrifice\",\n" +
                "\"requiredManas\": 2,\n" +
                "\"price\": 1600\n" +
                "}");
        getSpellResource().put("Kings Guard", "{\n" +
                "\"cellOrSoldier\": \"SOLDIER\",\n" +
                "\"target\": \"ENEMY_MINION\",\n" +
                "\"cellsType\": \"RANDOM_MINION_AROUND_HERO\",\n" +
                "\"lengthOfSideOfSquare\": 0,\n" +
                "\"buffNutralizer\": \"NONE\",\n" +
                "\"buffs\": [\n" +
                "{\n" +
                "\"onCellOrSoldier\": \"SOLDIER\",\n" +
                "\"numberOfTurnsOnTarget\": 0,\n" +
                "\"changeHp\": -2147483647,\n" +
                "\"apShield\": 0,\n" +
                "\"changeAp\": 0,\n" +
                "\"numberOfTurns\": 1,\n" +
                "\"delay\": 0,\n" +
                "\"isDisarmer\": false,\n" +
                "\"isStunner\": false,\n" +
                "\"isPositive\": false,\n" +
                "\"isActive\": false\n" +
                "}\n" +
                "],\n" +
                "\"cells\": [],\n" +
                "\"id\": \"\",\n" +
                "\"name\": \"Kings Guard\",\n" +
                "\"requiredManas\": 9,\n" +
                "\"price\": 1750\n" +
                "}");
        getSpellResource().put("Shock", "{\n" +
                "\"cellOrSoldier\": \"SOLDIER\",\n" +
                "\"target\": \"ENEMY\",\n" +
                "\"cellsType\": \"MONO_CELL\",\n" +
                "\"lengthOfSideOfSquare\": 0,\n" +
                "\"buffNutralizer\": \"NONE\",\n" +
                "\"buffs\": [\n" +
                "{\n" +
                "\"onCellOrSoldier\": \"SOLDIER\",\n" +
                "\"numberOfTurnsOnTarget\": 0,\n" +
                "\"changeHp\": 0,\n" +
                "\"apShield\": 0,\n" +
                "\"changeAp\": 0,\n" +
                "\"numberOfTurns\": 2,\n" +
                "\"delay\": 0,\n" +
                "\"isDisarmer\": false,\n" +
                "\"isStunner\": true,\n" +
                "\"isPositive\": false,\n" +
                "\"isActive\": false\n" +
                "}\n" +
                "],\n" +
                "\"cells\": [],\n" +
                "\"id\": \"\",\n" +
                "\"name\": \"Shock\",\n" +
                "\"requiredManas\": 1,\n" +
                "\"price\": 1200\n" +
                "}");
    }
}