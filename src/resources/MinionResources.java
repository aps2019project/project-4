package resources;

import java.util.HashMap;

public class MinionResources {

    private static HashMap<String, String> minionResource;

    public static void setMinionResource(){

    }

    private String persianArcher = "{\n" +
            "\"healthPoint\": 2,\n" +
            "\"attackPoint\": 6,\n" +
            "\"startRange\": 2,\n" +
            "\"endRange\": 7,\n" +
            "\"type\": \"RANGED\",\n" +
            "\"hasAttackedThisTurn\": false,\n" +
            "\"hasMovedThisTurn\": false,\n" +
            "\"isDisarmed\": false,\n" +
            "\"isStuned\": false,\n" +
            "\"numberOfTurnsOfDisarm\": false,\n" +
            "\"name\": \"persianArcher\",\n" +
            "\"requiredManas\": 4,\n" +
            "\"price\": 300\n" +
            "}";

    private String persianSwordman = null;

}