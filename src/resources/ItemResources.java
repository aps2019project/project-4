package resources;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.Spell;
import model.UsableItem;

import java.util.ArrayList;
import java.util.HashMap;

public class ItemResources {

    private static HashMap<String, String> usableItemResource = new HashMap<>();

    public static HashMap<String, String> getUsableItemResource() {
        return usableItemResource;
    }

    public static UsableItem getSpecificItem(String itemName) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        if (getSpecificUsableItemGson(itemName) != null) {
            Spell spell = gson.fromJson(getUsableItemResource().get(itemName), Spell.class);
            UsableItem usableItem = new UsableItem(spell.getName() , spell.getPrice());
            usableItem.setSpell(spell);
            return usableItem;
        }
        return null;
    }

    private static String getSpecificUsableItemGson(String itemName) {
        return getUsableItemResource().get(itemName);
    }

    public static ArrayList<UsableItem> getAllItems() {
        ArrayList<UsableItem> usableItems = new ArrayList<>();
        getUsableItemResource().forEach((name, gson) -> usableItems.add(getSpecificItem(name)));
        return usableItems;
    }


    public static void setItemResource() {
        //getUsableItemResource().put("Crown of wisdom", "");
        getUsableItemResource().put("Shame Emblem"
                , "{\n" +
                        "\"cellOrSoldier\": \"SOLDIER\",\n" +
                        "\"target\": \"FRIEND_HERO\",\n" +
                        "\"cellsType\": \"MONO_CELL\",\n" +
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
                        "\"isPoison\": false,\n" +
                        "\"isDisarmer\": false,\n" +
                        "\"isStunner\": false,\n" +
                        "\"isPositive\": true,\n" +
                        "\"onCellOrSoldier\": \"SOLDIER\",\n" +
                        "\"isActive\": false\n" +
                        "}\n" +
                        "],\n" +
                        "\"cells\": [],\n" +
                        "\"id\": \"\",\n" +
                        "\"name\": \"Shame Emblem\",\n" +
                        "\"requiredManas\": 0,\n" +
                        "\"price\": 30000\n" +
                        "}");
        getUsableItemResource().put("Dumbled ark",
                "{\n" +
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
                        "\"changeAp\": 0,\n" +
                        "\"numberOfTurns\": 1,\n" +
                        "\"delay\": 0,\n" +
                        "\"isPoison\": false,\n" +
                        "\"isDisarmer\": true,\n" +
                        "\"isStunner\": false,\n" +
                        "\"isPositive\": false,\n" +
                        "\"onCellOrSoldier\": \"SOLDIER\",\n" +
                        "\"isActive\": false\n" +
                        "}\n" +
                        "],\n" +
                        "\"cells\": [],\n" +
                        "\"id\": \"\",\n" +
                        "\"name\": \"Dumbled ark\",\n" +
                        "\"requiredManas\": 0,\n" +
                        "\"price\": 30000\n" +
                        "}");
        getUsableItemResource().put("Simorgh Fill",
                "{\n" +
                        "\"cellOrSoldier\": \"SOLDIER\",\n" +
                        "\"target\": \"ENEMY_HERO\",\n" +
                        "\"cellsType\": \"MONO_CELL\",\n" +
                        "\"lengthOfSideOfSquare\": 0,\n" +
                        "\"buffNutralizer\": \"NONE\",\n" +
                        "\"buffs\": [\n" +
                        "{\n" +
                        "\"numberOfTurnsOnTarget\": 0,\n" +
                        "\"changeHp\": 0,\n" +
                        "\"apShield\": 0,\n" +
                        "\"changeAp\": -1,\n" +
                        "\"numberOfTurns\": 2147483647,\n" +
                        "\"delay\": 0,\n" +
                        "\"isPoison\": false,\n" +
                        "\"isDisarmer\": false,\n" +
                        "\"isStunner\": false,\n" +
                        "\"isPositive\": false,\n" +
                        "\"onCellOrSoldier\": \"SOLDIER\",\n" +
                        "\"isActive\": false\n" +
                        "}\n" +
                        "],\n" +
                        "\"cells\": [],\n" +
                        "\"id\": \"\",\n" +
                        "\"name\": \"Simorgh Fill\",\n" +
                        "\"requiredManas\": 0,\n" +
                        "\"price\": 3500\n" +
                        "}");
        getUsableItemResource().put("Terror Hood", "{\n" +
                "\"cellOrSoldier\": \"SOLDIER\",\n" +
                "\"target\": \"ENEMY\",\n" +
                "\"cellsType\": \"RANDOM_MINION_OF_ALL\",\n" +
                "\"lengthOfSideOfSquare\": 0,\n" +
                "\"buffNutralizer\": \"NONE\",\n" +
                "\"buffs\": [\n" +
                "{\n" +
                "\"numberOfTurnsOnTarget\": 2147483647,\n" +
                "\"changeHp\": 0,\n" +
                "\"apShield\": 0,\n" +
                "\"changeAp\": -2,\n" +
                "\"numberOfTurns\": 2147483647,\n" +
                "\"delay\": 0,\n" +
                "\"isPoison\": false,\n" +
                "\"isDisarmer\": false,\n" +
                "\"isStunner\": false,\n" +
                "\"isPositive\": false,\n" +
                "\"onCellOrSoldier\": \"SOLDIER\",\n" +
                "\"isActive\": false\n" +
                "}\n" +
                "],\n" +
                "\"cells\": [],\n" +
                "\"id\": \"\",\n" +
                "\"name\": \"Terror Hood\",\n" +
                "\"requiredManas\": 0,\n" +
                "\"price\": 5000\n" +
                "}");
        //getUsableItemResource().put("King Wisdom", "");
        getUsableItemResource().put("Assassination Dagger", "{\n" +
                "\"cellOrSoldier\": \"SOLDIER\",\n" +
                "\"target\": \"ENEMY_HERO\",\n" +
                "\"cellsType\": \"MONO_CELL\",\n" +
                "\"lengthOfSideOfSquare\": 0,\n" +
                "\"buffNutralizer\": \"NONE\",\n" +
                "\"buffs\": [\n" +
                "{\n" +
                "\"numberOfTurnsOnTarget\": 1,\n" +
                "\"changeHp\": 0,\n" +
                "\"apShield\": 0,\n" +
                "\"changeAp\": -1,\n" +
                "\"numberOfTurns\": 1,\n" +
                "\"delay\": 0,\n" +
                "\"isPoison\": false,\n" +
                "\"isDisarmer\": false,\n" +
                "\"isStunner\": false,\n" +
                "\"isPositive\": false,\n" +
                "\"onCellOrSoldier\": \"SOLDIER\",\n" +
                "\"isActive\": false\n" +
                "}\n" +
                "],\n" +
                "\"cells\": [],\n" +
                "\"id\": \"\",\n" +
                "\"name\": \"Assassination Dagger\",\n" +
                "\"requiredManas\": 0,\n" +
                "\"price\": 15000\n" +
                "}");
        getUsableItemResource().put("Poisonous Dagger", "{\n" +
                "\"cellOrSoldier\": \"SOLDIER\",\n" +
                "\"target\": \"ENEMY\",\n" +
                "\"cellsType\": \"RANDOM_MINION_OF_ALL\",\n" +
                "\"lengthOfSideOfSquare\": 0,\n" +
                "\"buffNutralizer\": \"NONE\",\n" +
                "\"buffs\": [\n" +
                "{\n" +
                "\"numberOfTurnsOnTarget\": 1,\n" +
                "\"changeHp\": -1,\n" +
                "\"apShield\": 0,\n" +
                "\"changeAp\": 0,\n" +
                "\"numberOfTurns\": 1,\n" +
                "\"delay\": 0,\n" +
                "\"isPoison\": false,\n" +
                "\"isDisarmer\": false,\n" +
                "\"isStunner\": false,\n" +
                "\"isPositive\": false,\n" +
                "\"onCellOrSoldier\": \"SOLDIER\",\n" +
                "\"isActive\": false\n" +
                "}\n" +
                "],\n" +
                "\"cells\": [],\n" +
                "\"id\": \"\",\n" +
                "\"name\": \"Poisonous Dagger\",\n" +
                "\"requiredManas\": 0,\n" +
                "\"price\": 7000\n" +
                "}");
        getUsableItemResource().put("Shock Hammer", "{\n" +
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
                "\"isPoison\": false,\n" +
                "\"isDisarmer\": true,\n" +
                "\"isStunner\": false,\n" +
                "\"isPositive\": false,\n" +
                "\"onCellOrSoldier\": \"SOLDIER\",\n" +
                "\"isActive\": false\n" +
                "}\n" +
                "],\n" +
                "\"cells\": [],\n" +
                "\"id\": \"\",\n" +
                "\"name\": \"Shock Hammer\",\n" +
                "\"requiredManas\": 0,\n" +
                "\"price\": 15000\n" +
                "}");
        getUsableItemResource().put("Soul Eater", "{\n" +
                "\"cellOrSoldier\": \"SOLDIER\",\n" +
                "\"target\": \"FRIEND\",\n" +
                "\"cellsType\": \"RANDOM_MINION_OF_ALL\",\n" +
                "\"lengthOfSideOfSquare\": 0,\n" +
                "\"buffNutralizer\": \"NONE\",\n" +
                "\"buffs\": [\n" +
                "{\n" +
                "\"numberOfTurnsOnTarget\": 0,\n" +
                "\"changeHp\": 1,\n" +
                "\"apShield\": 0,\n" +
                "\"changeAp\": 0,\n" +
                "\"numberOfTurns\": 1,\n" +
                "\"delay\": 0,\n" +
                "\"isPoison\": false,\n" +
                "\"isDisarmer\": false,\n" +
                "\"isStunner\": false,\n" +
                "\"isPositive\": true,\n" +
                "\"onCellOrSoldier\": \"SOLDIER\",\n" +
                "\"isActive\": false\n" +
                "}\n" +
                "],\n" +
                "\"cells\": [],\n" +
                "\"id\": \"\",\n" +
                "\"name\": \"Soul Eater\",\n" +
                "\"requiredManas\": 0,\n" +
                "\"price\": 25000\n" +
                "}");
        getUsableItemResource().put("Baptism", "{\n" +
                "\"cellOrSoldier\": \"SOLDIER\",\n" +
                "\"target\": \"FRIEND_MINION\",\n" +
                "\"cellsType\": \"ALL_MINIONS_AROUND\",\n" +
                "\"lengthOfSideOfSquare\": 0,\n" +
                "\"buffNutralizer\": \"NONE\",\n" +
                "\"buffs\": [\n" +
                "{\n" +
                "\"numberOfTurnsOnTarget\": 0,\n" +
                "\"changeHp\": 0,\n" +
                "\"apShield\": 2,\n" +
                "\"changeAp\": 0,\n" +
                "\"numberOfTurns\": 2147483647,\n" +
                "\"delay\": 0,\n" +
                "\"isPoison\": false,\n" +
                "\"isDisarmer\": false,\n" +
                "\"isStunner\": false,\n" +
                "\"isPositive\": true,\n" +
                "\"onCellOrSoldier\": \"SOLDIER\",\n" +
                "\"isActive\": false\n" +
                "}\n" +
                "],\n" +
                "\"cells\": [],\n" +
                "\"id\": \"\",\n" +
                "\"name\": \"Baptism\",\n" +
                "\"requiredManas\": 0,\n" +
                "\"price\": 20000\n" +
                "}");
    }
}
