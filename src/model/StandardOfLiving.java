package model;

public enum StandardOfLiving {
    ULTRA_HIGH("ultra high"),
    VERY_HIGH("very high"),
    MEDIUM("medium"),
    ULTRA_LOW("ultra low");

    private final String description;

    StandardOfLiving(String description) {
        this.description = description;
    }

    public static String valuesList() {
        StringBuilder res = new StringBuilder();
        for (StandardOfLiving c : StandardOfLiving.values()) {
            res.append(c.description);
            res.append(", ");
        }
        return res.substring(0, res.length() - 2);
    }

    public static StandardOfLiving fromDescription(String description) throws IllegalArgumentException {
        for (StandardOfLiving c : StandardOfLiving.values()) {
            if (c.description.equalsIgnoreCase(description)) {
                return c;
            }
        }
        throw new IllegalArgumentException("No StandardOfLiving with description " + description);
    }

    public String getDescription() {
        return description;
    }
}
