package resources;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.Hero;

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

    public static void setHeroResource() {
        //todo add Heros
    }
}
