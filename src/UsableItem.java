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

    public StringBuilder info() {
        return new StringBuilder("Name : ").append(this.getName()).append(" - Desc: ").append(this.getDescription());
    }

    public StringBuilder infoWithPrice() {
        return this.info().append(" - Sell Cost : ").append(this.getPrice());
    }
}
