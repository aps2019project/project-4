package resources;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.UsableItem;

import java.util.HashMap;

public class ItemResources {

    private static HashMap<String, String> itemResource = new HashMap<>();

    public static HashMap<String, String> getItemResource() {
        return itemResource;
    }

    public static UsableItem getSpecificItem(String itemName) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        if (getSpecificItemGson(itemName) != null)
            return gson.fromJson(getItemResource().get(itemName), UsableItem.class);
        return  null;
    }

    private static String getSpecificItemGson(String itemName) {
        return getItemResource().get(itemName);
    }

    public static void setItemResource() {
        //todo add usableItems
    }
}
