package enums;

import static constants.AdditionsPrices.*;
import static constants.DeluxeAdditionsPrices.CHIPS_PRICE;
import static constants.DeluxeAdditionsPrices.COCA_COLA_PRICE;

public enum Additions {
    LETTUCE("Standard", "Lettuce", LETTUCE_PRICE),
    CARROT("Standard", "Carrot", CARROT_PRICE),
    ONION("Standard", "Onion", ONION_PRICE),
    SPICY("Standard", "Spicy", SPICY_PRICE),
    CHIPS("Deluxe", "Chips", CHIPS_PRICE),
    COCA_COLA("Deluxe", "Cola", COCA_COLA_PRICE);

    private String type;
    private String name;
    private int price;

    Additions(String type, String name, int price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
