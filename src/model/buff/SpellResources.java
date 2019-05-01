package model.buff;

public class SpellResources {

    String totalDisarm = "{\n" +
            "\"target\": \"ENEMY\",\n" +
            "\"cellsType\": \"MONO_CELL\",\n" +
            "\"lengthOfSideOfSquare\": 0,\n" +
            "\"buffNutralizer\": \"NONE\",\n" +
            "\"buffs\": [\n" +
            "{\n" +
            "\"changeHp\": 0,\n" +
            "\"apShield\": 0,\n" +
            "\"changeAp\": 0,\n" +
            "\"numberOfTurns\": -1,\n" +
            "\"delay\": 0,\n" +
            "\"isDisarmer\": true,\n" +
            "\"isStunner\": false,\n" +
            "\"isPositive\": false,\n" +
            "\"isActive\": false\n" +
            "}\n" +
            "],\n" +
            "\"cells\": [],\n" +
            "\"id\": \"\",\n" +
            "\"name\": \"TotalDisarm\",\n" +
            "\"requiredManas\": 0,\n" +
            "\"price\": 1000\n" +
            "}";
    String AreaDispell = "{\n" +
            "\"target\": \"BOTH\",\n" +
            "\"cellsType\": \"SQUARE\",\n" +
            "\"lengthOfSideOfSquare\": 2,\n" +
            "\"buffNutralizer\": \"NONE\",\n" +
            "\"buffs\": [],\n" +
            "\"cells\": [],\n" +
            "\"id\": \"\",\n" +
            "\"name\": \"AreaDispel\",\n" +
            "\"requiredManas\": 2,\n" +
            "\"price\": 1500\n" +
            "}";

    String Empower = "{\n" +
            "\"target\": \"BOTH\",\n" +
            "\"cellsType\": \"SQUARE\",\n" +
            "\"lengthOfSideOfSquare\": 2,\n" +
            "\"buffNutralizer\": \"NONE\",\n" +
            "\"buffs\": [\n" +
            "{\n" +
            "\"changeHp\": 0,\n" +
            "\"apShield\": 0,\n" +
            "\"changeAp\": 2,\n" +
            "\"numberOfTurns\": -1,\n" +
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
            "}";
    String FireBall = "{\n" +
            "\"target\": \"ENEMY\",\n" +
            "\"cellsType\": \"MONO_CELL\",\n" +
            "\"lengthOfSideOfSquare\": 0,\n" +
            "\"buffNutralizer\": \"NONE\",\n" +
            "\"buffs\": [\n" +
            "{\n" +
            "\"changeHp\": 4,\n" +
            "\"apShield\": 0,\n" +
            "\"changeAp\": 0,\n" +
            "\"numberOfTurns\": 1,\n" +
            "\"delay\": 0,\n" +
            "\"isDisarmer\": false,\n" +
            "\"isStunner\": false,\n" +
            "\"isPositive\": true,\n" +
            "\"isActive\": false\n" +
            "}\n" +
            "],\n" +
            "\"cells\": [],\n" +
            "\"id\": \"\",\n" +
            "\"name\": \"FireBall\",\n" +
            "\"requiredManas\": 1,\n" +
            "\"price\": 400\n" +
            "}";

    String GodStrength = "{\n" +
            "\"target\": \"ENEMY_HERO\",\n" +
            "\"cellsType\": \"MONO_CELL\",\n" +
            "\"lengthOfSideOfSquare\": 0,\n" +
            "\"buffNutralizer\": \"NONE\",\n" +
            "\"buffs\": [\n" +
            "{\n" +
            "\"changeHp\": 0,\n" +
            "\"apShield\": 0,\n" +
            "\"changeAp\": 4,\n" +
            "\"numberOfTurns\": -1,\n" +
            "\"delay\": 0,\n" +
            "\"isDisarmer\": false,\n" +
            "\"isStunner\": false,\n" +
            "\"isPositive\": true,\n" +
            "\"isActive\": false\n" +
            "}\n" +
            "],\n" +
            "\"cells\": [],\n" +
            "\"id\": \"\",\n" +
            "\"name\": \"GodStrength\",\n" +
            "\"requiredManas\": 4,\n" +
            "\"price\": 450\n" +
            "}";
}
