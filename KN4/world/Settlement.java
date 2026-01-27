package world;

public class Settlement extends Maps {

    private Shop shop;

    public Settlement(String explanation, Shop shop) {
        super(explanation);
        this.shop = shop;
    }

    public Shop getShop() {
        return shop;
    }
}
