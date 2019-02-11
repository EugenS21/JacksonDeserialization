package enums;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
    private Logger addonsLogger = LoggerFactory.getLogger(Additions.class);

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

    public void setType(String type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
