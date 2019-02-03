import classes_components.BreadType;
import classes_components.MeatType;
import enums.Additions;

import static constants.GeneralConstants.DELUXE_HAMBURGER_NAME;

public class DeluxeHamburger extends BaseHamburger {
    public DeluxeHamburger() {
        super();
        super.setBurgerName(DELUXE_HAMBURGER_NAME);
    }

    public DeluxeHamburger(BreadType breadType, MeatType meatType) {
        super(breadType, meatType);
        super.setBurgerName(DELUXE_HAMBURGER_NAME);
    }

    @Override
    public void addAdditions(Additions addonToAdd) {
        try {
            if ((addonToAdd.getType().equals("Deluxe")))
                super.addAdditions(addonToAdd);
            else
                throw new UnsupportedOperationException();
        } catch (UnsupportedOperationException e) {
            System.out.println("Addition is not supported for this type of burger");
        }

    }

    @Override
    public void removeAdditions(Additions addonToRemove) {
        try {
            if ((addonToRemove.getType().equals("Deluxe")))
                this.removeAdditions(addonToRemove);
            else
                throw new UnsupportedOperationException();
        } catch (UnsupportedOperationException e) {
            System.out.println("Addition is not supported for this type of burger");
        }
    }
}
