package enums;

import customexceptions.InvalidInstanceException;
import customexceptions.UnsupportedTypeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

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
    private List<Additions> addonsList;
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

    public List<Additions> getAddonsList() {
        return addonsList;
    }

    public void setAddonsList(List<Additions> addonsList) {
        this.addonsList = addonsList;
    }

    public void addAddon(Additions addon) {
        try {
            if (Arrays
                    .asList(this
                            .getDeclaringClass()
                            .getEnumConstants())
                    .contains(addon)) {
                if (!this.addonsList.contains(addon))
                    this.addonsList.add(addon);
                else
                    throw new InvalidInstanceException();
            } else
                throw new UnsupportedTypeException();

        } catch (InvalidInstanceException e) {
            this.addonsLogger.info("You try to add an existing item");
        } catch (UnsupportedTypeException e) {
            this.addonsLogger.warn("You are trying to add an addon: "
                    + addon.toString() + " which is not supported");
        }
    }

    public void removeAddon(Additions addon) {
        try {
            if (Arrays
                    .asList(this
                            .getDeclaringClass()
                            .getEnumConstants())
                    .contains(addon)) {
                if (this.addonsList.contains(addon))
                    this.addonsList.remove(addon);
                else
                    throw new InvalidInstanceException();
            } else
                throw new UnsupportedTypeException();

        } catch (InvalidInstanceException e) {
            this.addonsLogger.info("You try to remove an unexisting item");
        } catch (UnsupportedTypeException e) {
            this.addonsLogger.warn("You are trying to remove an addon: "
                    + addon.toString() + " which is not supported");
        }
    }
}
