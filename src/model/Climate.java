package model;

public enum Climate {
    HUMIDSUBTROPICAL("humid subtropical"),
    HUMIDCONTINENTAL("humid continental"),
    SUBARCTIC("subarctic"),
    POLAR_ICECAP("polar icecap"),
    DESERT("desert"),;

    private final String description;

    Climate(String description){
        this.description = description;
    }

    public static String valuesList() {
        StringBuilder res = new StringBuilder();
        for (Climate c : Climate.values()) {
            res.append(c.description);
            res.append(", ");
        }
        return res.substring(0, res.length() - 2);
    }

    public static Climate fromDescription(String description) throws IllegalArgumentException {
        for (Climate c : Climate.values()) {
            if (c.description.equals(description)) {
                return c;
            }
        }
        throw new IllegalArgumentException("Invalid climate description");
    }

    public String getDescription() {
        return description;
    }
}
