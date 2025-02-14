package model;

public enum Government {
    DICTATORSHIP("dictatorship"),
    REPUBLIC("republic"),
    THEOCRACY("theocracy");

    private final String description;

    Government(String description) {
        this.description = description;
    }

    public static String valuesList() {
        StringBuilder res = new StringBuilder();
        for (Government c : Government.values()) {
            res.append(c.description);
            res.append(", ");
        }
        return res.substring(0, res.length() - 2);
    }

    public static Government fromDescription(String description) throws IllegalArgumentException {
        for (Government c : Government.values()) {
            if (c.description.equals(description)) {
                return c;
            }
        }
        throw new IllegalArgumentException("no such government " + description);
    }

    public String getDescription() {
        return description;
    }

}
