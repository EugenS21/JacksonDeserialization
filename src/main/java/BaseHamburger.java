import classes_components.AdditionalComponents;
import classes_components.BreadType;
import classes_components.MeatType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import customexceptions.InvalidInstanceException;
import customexceptions.UnsupportedTypeException;
import enums.Additions;

import static constants.GeneralConstants.BASE_HAMBURGER_NAME;
import static constants.GeneralConstants.DELUXE_HAMBURGER_NAME;

public class BaseHamburger extends JacksonObjectSerializer {
    private String burgerName;
    private MeatType meatType;
    private BreadType breadType;
    private final AdditionalComponents addonsList;
    private int preparationTime;
    private int burgerPrice = 0;
    private CustomThread preparationThread = new CustomThread();
    @JsonIgnore
    private JacksonObjectSerializer jacksonObjectSerializer = new JacksonObjectSerializer();

    public BaseHamburger() {
        this.addonsList = new AdditionalComponents();
        this.burgerName = BASE_HAMBURGER_NAME;
        this.breadType = new BreadType();
        this.meatType = new MeatType();
        this.burgerPrice =
                breadType.getBread().getBreadPrice() + meatType.getMeat().getMeatPrice();
        this.preparationTime = 0;
    }

    public void setPreparationThread() {
        this.preparationThread.start();
    }

    private int getAdditionTotalPrice() {
        this.setBurgerPrice(this.burgerPrice + this.addonsList
                .getAddonsList()
                .stream()
                .mapToInt(a -> a.getPrice())
                .sum());
        return this.burgerPrice;
    }

    public BaseHamburger(BreadType breadType, MeatType meatType) {
        this.burgerName = BASE_HAMBURGER_NAME;
        this.breadType = breadType;
        this.meatType = meatType;
        this.burgerPrice = breadType.getBread().getBreadPrice()
                + meatType.getMeat().getMeatPrice();
        this.addonsList = new AdditionalComponents();
    }

    public int getBurgerPrice() {
        return burgerPrice;
    }

    public void setBurgerPrice(int burgerPrice) {
        this.burgerPrice = burgerPrice;
    }

    public BreadType getBreadType() {
        return breadType;
    }

    public void setBreadType(BreadType breadType) {
        this.breadType = breadType;
    }

    public MeatType getMeatType() {
        return meatType;
    }

    public void setMeatType(MeatType meatType) {
        this.meatType = meatType;
    }

    public AdditionalComponents getAddonsList() {
        return addonsList;
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
            System.out.println("Addition is not supported for " + this.getBurgerName());
        } catch (InvalidInstanceException e) {
            System.out.println("You want to add already existing item");
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
            System.out.println("Addition is not supported for " + this.getBurgerName());
        } catch (InvalidInstanceException e) {
            System.out.println("You want to remove an unexisting item");
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

    private class CustomThread extends Thread {
        @Override
        public void run() {
            try {
                sleep(preparationTime * 1000);
                getAdditionTotalPrice();
                System.out.println(jacksonObjectSerializer.getJsonContent(BaseHamburger.this));
            } catch (InterruptedException e) {
                System.out.println("Wasn't able to wait for specific time");
            }
        }
    }
}
