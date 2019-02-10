import com.fasterxml.jackson.annotation.JsonIgnore;
import customexceptions.InvalidInstanceException;
import customexceptions.UnsupportedTypeException;
import enums.Additions;
import enums.Bread;
import enums.Meat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static constants.GeneralConstants.BASE_HAMBURGER_NAME;
import static constants.GeneralConstants.DELUXE_HAMBURGER_NAME;

public class BaseHamburger extends JacksonObjectSerializer {
    private String burgerName;
    private Meat meatType;
    private Bread breadType;
    private Additions addonsList;
    private int preparationTime;
    private int burgerPrice;
    @JsonIgnore
    private JacksonObjectSerializer jacksonObjectSerializer = new JacksonObjectSerializer();
    @JsonIgnore
    private static Logger baseLogger = LoggerFactory.getLogger(BaseHamburger.class);


    public BaseHamburger() {
        this.addonsList = new Additions();
        this.burgerName = BASE_HAMBURGER_NAME;
        this.breadType = new Bread();
        this.meatType = new Meat();
        this.burgerPrice =
                breadType.getBreadPrice() + meatType.getMeatPrice();
        this.preparationTime = 0;
    }

    public BaseHamburger(Bread breadType, Meat meatType) {
        this.burgerName = BASE_HAMBURGER_NAME;
        this.breadType = breadType;
        this.meatType = meatType;
        this.burgerPrice = breadType.getBreadPrice()
                + meatType.getMeatPrice();
        this.addonsList = new Additions();
    }

    public int getBurgerPrice() {
        return burgerPrice;
    }

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

    public Additions getAddonsList() {
        return addonsList;
    }

    public void setAddonsList(Additions addonsList) {
        this.addonsList = addonsList;
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

    public void addAdditions(Additions addonToAdd) {
        try {
            if ((!this.getBurgerName().equals(DELUXE_HAMBURGER_NAME)
                    && !addonToAdd.getType().equals("Deluxe"))
                    || (addonToAdd.getType().equals("Deluxe")
                    && this.getBurgerName().equals(DELUXE_HAMBURGER_NAME))) {
                if (!this.addonsList.getAddonsList().contains(addonToAdd)) {
                    this.addonsList.add(addonToAdd);
                    this.burgerPrice += addonToAdd.getPrice();
                } else
                    throw new InvalidInstanceException();
            } else
                throw new UnsupportedTypeException();
        } catch (UnsupportedTypeException e) {
            baseLogger.info("Addition is not supported for " + this.getBurgerName());
        } catch (InvalidInstanceException e) {
            baseLogger.error("You want to add already existing item");
        }

    }

    public void removeAdditions(Additions addonToRemove) {
        try {
            if (addonToRemove instanceof Additions) {
                if (this.addonsList.getAddonsList().contains(addonToRemove)) {
                    this.addonsList.remove(addonToRemove);
                    this.burgerPrice -= addonToRemove.getPrice();
                } else
                    throw new InvalidInstanceException();
            } else
                throw new UnsupportedTypeException();
        } catch (UnsupportedTypeException e) {
            baseLogger.info("Addition is not supported for " + this.getBurgerName());
        } catch (InvalidInstanceException e) {
            baseLogger.warn("You want to remove a non existing item");
        }
    }

    public void getDetailedInfo() {
        getAdditionTotalPrice();
        System.out.println("You want to buy\n" +
                "A " + this.burgerName + "\n" +
                "With " + this.breadType.getBread().getBreadName()
                + " for: " + this.breadType.getBread().getBreadPrice() + "\n" +
                "And " + this.meatType.getMeat().getMeatName()
                + " for: " + this.meatType.getMeat().getMeatPrice());
        if (addonsList.isEmpty())
            System.out.println("No additions");
        else {
            System.out.println("Also following additions:");
            addonsList.getAddonsList().forEach(e -> System.out.println(e.getName()
                    + " addon for: " + e.getPrice()));
        }
        System.out.println("\t\t Total Price: " + this.burgerPrice);
    }
}
