package classes_components;

import enums.Bread;

public class BreadType {
    private Bread bread;

    public BreadType() {
        this.bread = Bread.WHITE;
    }

    public BreadType(Bread bread) {
        this.bread = bread;
    }

    public Bread getBread() {
        return bread;
    }

    public void setBread(Bread bread) {
        this.bread = bread;
    }
}
