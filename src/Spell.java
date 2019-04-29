import com.google.gson.Gson;

public class Spell extends Card {

    @Override
    public StringBuilder info() {
        StringBuilder result = new StringBuilder()
                .append("Spell:\n")
                .append("Name: ").append(name).append("\n")
                .append("MP: ").append(requiredManas).append("\n")
                .append("Cost: ").append(price).append("\n")
                .append("Desc: ").append(desc).append("\n");
        return result;
    }

    @Override
    public StringBuilder infoForDeck() {
        StringBuilder result = new StringBuilder();
        result.append("Type : Spell - Name : ").append(this.getName())
                .append(" - MP : ").append(this.getRequiredManas())
                .append(" - Desc : ").append(this.getDesc());
        return result;
    }

    @Override
    public StringBuilder infoForDeckWithPrice() {
        return this.infoForDeck().append(" - Sell Cost : ").append(this.getPrice());
    }
}
