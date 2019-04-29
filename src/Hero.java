import java.io.IOException;

public class Hero extends Minion {
    private int coolDown;

    public Hero(String name, int price, int hp, int ap, int mp, int startRange, int endRange, int coolDown) {
        super(name, price, hp, ap, mp, startRange, endRange);
        this.coolDown = coolDown;
    }

    @Override
    public StringBuilder info() {
        StringBuilder result = new StringBuilder();
        result.append("Name: ").append(name).append("\n");
        result.append("Cost: ").append(price).append("\n");
        result.append("Description: ").append(desc).append("\n");
        return result;
    }

}
