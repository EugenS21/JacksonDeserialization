import enums.Additions;
import enums.Bread;
import enums.Meat;

import static constants.GeneralConstants.DELUXE_HAMBURGER_NAME;

public class DeluxeHamburger extends BaseHamburger {
    public DeluxeHamburger() {
        super();
        super.setBurgerName(DELUXE_HAMBURGER_NAME);
    }

    public DeluxeHamburger(Bread breadType, Meat meatType) {
        super(breadType, meatType);
        super.setBurgerName(DELUXE_HAMBURGER_NAME);
    }

    @Override
    public void addAddon(Additions addonToAdd) {
        try {
            if ((addonToAdd.getType().equals("Deluxe")))
                super.addAddon(addonToAdd);
            else
                throw new UnsupportedOperationException();
        } catch (UnsupportedOperationException e) {
            getBaseLogger().warn("Addition is not supported for this type of burger");
        }

    }

    @Override
    public void removeAddon(Additions addonToRemove) {
        try {
            if ((addonToRemove.getType().equals("Deluxe")))
                this.removeAddon(addonToRemove);
            else
                throw new UnsupportedOperationException();
        } catch (UnsupportedOperationException e) {
            getBaseLogger().warn("Addition is not supported for this type of burger");
        }
    }
}
