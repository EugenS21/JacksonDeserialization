import com.fasterxml.jackson.annotation.JsonIgnore;
import customexceptions.InvalidInstanceException;
import customexceptions.UnsupportedTypeException;
import enums.Additions;
import enums.Bread;
import enums.Meat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static constants.GeneralConstants.BASE_HAMBURGER_NAME;

public class BaseHamburger extends JacksonObjectSerializer {
    private String burgerName;
    private Meat meatType;
    private Bread breadType;
    private List<Additions> addonsList;
    private int preparationTime;
    private int burgerPrice;
    @JsonIgnore
    private JacksonObjectSerializer jacksonObjectSerializer = new JacksonObjectSerializer();
    @JsonIgnore
    private Logger baseLogger = LoggerFactory.getLogger(BaseHamburger.class);

    BaseHamburger() {
        this.addonsList = new ArrayList<>();
        this.burgerName = BASE_HAMBURGER_NAME;
        this.breadType = Bread.WHITE;
        this.meatType = Meat.CHICKEN;
        this.burgerPrice =
                breadType.getBreadPrice() + meatType.getMeatPrice();
        this.preparationTime = 0;
    }

    BaseHamburger(Bread breadType, Meat meatType) {
        this.addonsList = new ArrayList<>();
        this.burgerName = BASE_HAMBURGER_NAME;
        this.breadType = breadType;
        this.meatType = meatType;
        this.burgerPrice = breadType.getBreadPrice()
                + meatType.getMeatPrice();
    }

    public int getBurgerPrice() {
        return burgerPrice;
    }

    @JsonIgnore
    public void setBurgerPrice(int burgerPrice) {
        this.burgerPrice = burgerPrice;
    }

    public Meat getMeatType() {
        return meatType;
    }

    public void setMeatType(Meat meatType) {
        this.meatType = meatType;
    }

    public Bread getBreadType() {
        return breadType;
    }

    public void setBreadType(Bread breadType) {
        this.breadType = breadType;
    } 

    public String getBurgerName() {
        return burgerName;
    }

    public void setBurgerName(String burgerName) {
        this.burgerName = burgerName;
    }

    public int getPreparationTime() {
        return preparationTime;
    }

    public void setPreparationTime(int preparationTime) {
        this.preparationTime = preparationTime;
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
                    .asList(Additions
                            .class
                            .getEnumConstants())
                    .contains(addon)) {
                if (!this.addonsList.contains(addon))
                    this.addonsList.add(addon);
                else
                    throw new InvalidInstanceException();
            } else
                throw new UnsupportedTypeException();

        } catch (InvalidInstanceException e) {
            baseLogger.info("You try to add an existing item");
        } catch (UnsupportedTypeException e) {
            baseLogger.warn("You are trying to add an addon: "
                    + addon.toString() + " which is not supported");
        }
        this.burgerPrice += addon.getPrice();
    }

    public void removeAddon(Additions addon) {
        try {
            if (!this.addonsList.isEmpty()) {
                if (Arrays
                        .asList(Additions
                                .class
                                .getEnumConstants())
                        .contains(addon)) {
                    if (this.addonsList.contains(addon))
                        this.addonsList.remove(addon);
                    else
                        throw new InvalidInstanceException();
                } else
                    throw new UnsupportedTypeException();
            } else
                throw new NullPointerException();

        } catch (InvalidInstanceException e) {
            baseLogger.info("You try to remove an unexisting item");
        } catch (UnsupportedTypeException e) {
            baseLogger.warn("You are trying to remove an addon: "
                    + addon.toString() + " which is not supported");
        } catch (NullPointerException e) {
            baseLogger.error("You are trying to remove a item from an empty list");
        }
        this.burgerPrice -= addon.getPrice();
    }

    public void getDetailedInfo() {
        System.out.println("You want to buy\n" +
                "A " + this.burgerName + "\n" +
                "With " + this.breadType.getBreadName()
                + " for: " + this.breadType.getBreadPrice() + "\n" +
                "And " + this.meatType.getMeatName()
                + " for: " + this.meatType.getMeatPrice());
        if (addonsList.isEmpty())
            baseLogger.info("No additions");
        else {
            System.out.println("Also following additions:");
            addonsList.forEach(e -> System.out.println(e.getName()
                    + " addon for: " + e.getPrice()));
        }
        System.out.println("\t\t Total Price: " + this.burgerPrice);
    }

    public Logger getBaseLogger() {
        return baseLogger;
    }

    public void serializeHamburger() {
        System.out.println(this.jacksonObjectSerializer.getJsonContent(this));
    }
}
