package classes_components;

import enums.Meat;

public class MeatType {
    private Meat meat;

    public MeatType() {
        this.meat = Meat.CHICKEN;
    }

    public MeatType(Meat meat) {
        this.meat = meat;
    }

    public Meat getMeat() {
        return meat;
    }

    public void setMeat(Meat meat) {
        this.meat = meat;
    }
}
