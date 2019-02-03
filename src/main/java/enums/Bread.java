package enums;

import static constants.BreadPrices.*;

public enum Bread {
    WHITE("White bread", WHITE_BREAD_PRICE),
    BLACK("Black bread", BLACK_BREAD_PRICE),
    WHITE_WITH_ADDONS("White bread with additions"
            , WHITE_BREAD_WITH_ADDITIONS_PRICE),
    BLACK_WITH_ADDONS("White bread with additions"
            , BLACK_BREAD_WITH_ADDITIONS_PRICE);

    private String breadName;
    private int breadPrice;

    Bread(String name, int price) {
        this.breadName = name;
        this.breadPrice = price;
    }

    public String getBreadName() {
        return breadName;
    }

    public int getBreadPrice() {
        return breadPrice;
    }
}
