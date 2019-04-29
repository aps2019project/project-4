
public class Hero extends Minion {
    private int coolDown;

    public Hero(String name, int price, int hp, int ap, int mp, int startRange, int endRange, int coolDown, String classOfMinion) {
        super(name, price, hp, ap, mp, startRange, endRange, classOfMinion);
        this.coolDown = coolDown;
    }

    public int getCoolDown() {
        return coolDown;
    }
    @Override
    public StringBuilder info() {
        StringBuilder result = new StringBuilder();
        result.append("Name: ").append(name).append("\n");
        result.append("Cost: ").append(price).append("\n");
        result.append("Description: ").append(desc).append("\n");
        return result;
    }
    public StringBuilder infoWithPrice() {
        return this.info().append(" - Sell Cost : ").append(this.getPrice());
    }

}