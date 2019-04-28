public class Hero extends Minion {
    private int coolDown;

    public Hero(String name, int price, int hp, int ap, int mp, int startRange, int endRange, int coolDown) {
        super(name, price, hp, ap, mp, startRange, endRange);
        this.coolDown = coolDown;
    }

    @Override
    public String toString (){
        return "Name: " + this.getName() + " - AP : " + this.getAP() + " - HP : " + this.getHP() + " - Class : " + "??" ; //toDO complete
    }

}
