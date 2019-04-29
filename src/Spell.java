import com.google.gson.Gson;

public class Spell extends Card {
    @Override
    public StringBuilder info(){
        StringBuilder result = new StringBuilder();
        result.append("Name: ").append(name).append("\n");
        result.append("MP: ").append(requiredManas).append("\n");
        result.append("Cost: ").append(price).append("\n");
        result.append("Desc: ").append(desc).append("\n");
        return result;
    }
}
