import classes_components.BreadType;
import classes_components.MeatType;
import customexceptions.NumberOfAdditionsException;
import enums.Additions;
import enums.Bread;
import enums.Meat;

import static constants.GeneralConstants.HEALTHY_HAMBURGER_NAME;
import static constants.GeneralConstants.MAX_NUMBER_OF_ADDITIONS_HEALTHY_BURGER;

public class HealthyBurger extends BaseHamburger {
    public HealthyBurger() {
        super(new BreadType(Bread.BLACK_WITH_ADDONS)
                , new MeatType(Meat.EAGLE));
        this.setBurgerName(HEALTHY_HAMBURGER_NAME);
    }

    @Override
    public void addAdditions(Additions addonToAdd) {
        try {
            if (this.getAddonsList().size() < MAX_NUMBER_OF_ADDITIONS_HEALTHY_BURGER) {
                this.getAddonsList().add(addonToAdd);
                this.setBurgerPrice(super.getBurgerPrice() + addonToAdd.getPrice());
            } else
                throw new NumberOfAdditionsException();
        } catch (NumberOfAdditionsException e) {
            System.out.println("No more available additions are allowed");
        }
    }
}
