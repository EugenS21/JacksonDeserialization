package enums;

import static constants.MeatPrices.*;

public enum Meat {
    CHICKEN("Chicken meat", CHICKEN_MEAT_PRICE),
    TORRO("Torro meat", TORRO_MEAT_PRICE),
    PIG("Pig meat", PIG_MEAT_PRICE),
    EAGLE("Eagle meat", EAGLE_MEAT_PRICE);

    private String meatName;
    private int meatPrice;

    Meat(String name, int price) {
        this.meatName = name;
        this.meatPrice = price;
    }

    public String getMeatName() {
        return meatName;
    }

    public int getMeatPrice() {
        return meatPrice;
    }
}
