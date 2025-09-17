package top.syy.boot.mp.boot.config.enums;

/**
 * @author 小c
 */
public enum DrinkType {
    COFFEE("咖啡",9.9),
    TEA("奶茶",16),
    JUICE("果汁",6),
    ;
    private final String type;
    private final double price;
    DrinkType(String type ,double price) {
        this.type = type;
        this.price= price;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }
}

