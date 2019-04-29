public abstract class Card {
    protected String id;
    protected String name;
    protected int requiredManas;
    protected int price;
    protected String desc;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getRequiredManas() {
        return requiredManas;
    }

    public int getPrice() {
        return price;
    }

    public String getDesc() {
        return desc;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRequiredManas(int requiredManas) {
        this.requiredManas = requiredManas;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public abstract void showInfo();
}
