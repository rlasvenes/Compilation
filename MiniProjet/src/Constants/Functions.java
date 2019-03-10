package Constants;

public enum Functions {
    SIN("sin"),
    COS("cos"),
    TAN("tan"),
    ASIN("asin"),
    ACOS("acos"),
    ROUND("round"),
    FLOOR("floor"),
    ABS("abs"),
    SQRT("sqrt"),
    ATAN2("atan2");

    private String name;

    Functions(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
