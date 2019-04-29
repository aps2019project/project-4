
public class Hero extends Minion {
    private int coolDown;

    public Hero(String name, int price, int hp, int ap, int mp, int startRange, int endRange, int coolDown) {
        super(name, price, hp, ap, mp, startRange, endRange);
        this.coolDown = coolDown;
    }

    public int getCoolDown() {
        return coolDown;
    }

    @Override
    public StringBuilder info() {
        StringBuilder result = new StringBuilder();
        result.append("Hero:\n");
        result.append("Name: ").append(name).append("\n");
        result.append("Cost: ").append(price).append("\n");
        result.append("Description: ").append(desc).append("\n");
        return result;
    }

    @Override
    public StringBuilder infoForDeck(){
        StringBuilder result = new StringBuilder();
        result.append("Name: ").append(this.getName()).append(" - AP : ").append(this.getAP())
              .append(" - HP : ").append(this.getHP()).append(" - Class : ").append(this.getType())
              .append(" - Special power: ").append(this.getSpecialPower().getDesc());
        return result;
    }

    @Override
    public StringBuilder infoForDeckWithPrice(){
        StringBuilder result = new StringBuilder();
        return result;
    }
}