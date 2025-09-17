package top.syy.boot.mp.boot.config.enums;
/**
 * @author 小c
 */
public enum ExpressStstus {
    CREATED("已揽收"),
    SCAN("在途中"),
    ACCEPT("已签收"),
    ;
    private final String label;
    ExpressStstus(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
