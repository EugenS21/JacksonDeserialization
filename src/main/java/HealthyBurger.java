import customexceptions.NumberOfAdditionsException;
import enums.Additions;
import enums.Bread;
import enums.Meat;

import static constants.GeneralConstants.HEALTHY_HAMBURGER_NAME;
import static constants.GeneralConstants.MAX_NUMBER_OF_ADDITIONS_HEALTHY_BURGER;

public class HealthyBurger extends BaseHamburger {
    public HealthyBurger() {
        super(Bread.BLACK_WITH_ADDONS, Meat.EAGLE);
        this.setBurgerName(HEALTHY_HAMBURGER_NAME);
    }

    @Override
    public void addAddon(Additions addonToAdd) {
        try {
            if (this.getAddonsList().size() < MAX_NUMBER_OF_ADDITIONS_HEALTHY_BURGER) {
                super.addAddon(addonToAdd);
                super.setBurgerPrice(super.getBurgerPrice() + addonToAdd.getPrice());
            } else
                throw new NumberOfAdditionsException();
        } catch (NumberOfAdditionsException e) {
            super.getBaseLogger().warn("No more available additions are allowed");
        }
    }
}
