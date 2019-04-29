public class UsableItem {
    private int price;
    private String name;
    private String description;

    public UsableItem(String name, int price) {
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Name : " + this.getName() + " - " +
                "Desc: " + this.getDescription() + " - " +
                "Sell Cost : " + this.getPrice();
    }
}
