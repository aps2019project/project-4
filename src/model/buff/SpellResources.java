package model.buff;

public class SpellResources {

    String totalDisarm = "{\n" +
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
            "\"buffNutralizer\": \"BOTH\",\n" +
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
            "\"numberOfTurnsOnTarget\": 0,\n" +
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
            "\"numberOfTurnsOnTarget\": 0,\n" +
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
    String HellFire = "{\n" +
            "\"target\": \"BOTH\",\n" +
            "\"cellsType\": \"SQUARE\",\n" +
            "\"lengthOfSideOfSquare\": 2,\n" +
            "\"buffNutralizer\": \"NONE\",\n" +
            "\"buffs\": [\n" +
            "{\n" +
            "\"numberOfTurnsOnTarget\": 0,\n" +
            "\"changeHp\": 2,\n" +
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
            "\"name\": \"HellFire\",\n" +
            "\"requiredManas\": 3,\n" +
            "\"price\": 600\n" +
            "}";
    String LightningBolt = "{\n" +
            "\"target\": \"ENEMY_HERO\",\n" +
            "\"cellsType\": \"MONO_CELL\",\n" +
            "\"lengthOfSideOfSquare\": 0,\n" +
            "\"buffNutralizer\": \"NONE\",\n" +
            "\"buffs\": [\n" +
            "{\n" +
            "\"numberOfTurnsOnTarget\": 0,\n" +
            "\"changeHp\": 8,\n" +
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
            "\"name\": \"LightningBolt\",\n" +
            "\"requiredManas\": 2,\n" +
            "\"price\": 1250\n" +
            "}";
    String PoisonLake = "{\n" +
            "\"target\": \"BOTH\",\n" +
            "\"cellsType\": \"SQUARE\",\n" +
            "\"lengthOfSideOfSquare\": 3,\n" +
            "\"buffNutralizer\": \"NONE\",\n" +
            "\"buffs\": [\n" +
            "{\n" +
            "\"numberOfTurnsOnTarget\": 3,\n" +
            "\"changeHp\": 1,\n" +
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
            "\"name\": \"PoinsonLake\",\n" +
            "\"requiredManas\": 5,\n" +
            "\"price\": 900\n" +
            "}";
    String Madness = "{\n" +
            "\"target\": \"Friend\",\n" +
            "\"cellsType\": \"MONO_CELL\",\n" +
            "\"lengthOfSideOfSquare\": 0,\n" +
            "\"buffNutralizer\": \"NONE\",\n" +
            "\"buffs\": [\n" +
            "{\n" +
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
            "}";
    String AllDisarm = "{\n" +
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
            "\"isDisarmer\": true,\n" +
            "\"isStunner\": false,\n" +
            "\"isPositive\": false,\n" +
            "\"isActive\": false\n" +
            "}\n" +
            "],\n" +
            "\"cells\": [],\n" +
            "\"id\": \"\",\n" +
            "\"name\": \"AllDisarm\",\n" +
            "\"requiredManas\": 9,\n" +
            "\"price\": 2000\n" +
            "}";
    String AllPoison = "{\n" +
            "\"target\": \"ENEMY\",\n" +
            "\"cellsType\": \"ALL\",\n" +
            "\"lengthOfSideOfSquare\": 0,\n" +
            "\"buffNutralizer\": \"NONE\",\n" +
            "\"buffs\": [\n" +
            "{\n" +
            "\"numberOfTurnsOnTarget\": 4,\n" +
            "\"changeHp\": 1,\n" +
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
            "\"name\": \"AllPoison\",\n" +
            "\"requiredManas\": 8,\n" +
            "\"price\": 1500\n" +
            "}";
    String Dispel = "{\n" +
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
            "}";
    String HealthWithProfit = "";
    String  PowerUp = "";
    String AllPower = "";
    String AllAttack = "";
    String Weakening = "";
    String Sacrifice = "";
    String KingsGuard = "";
}
