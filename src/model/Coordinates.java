package model;

public class Coordinates{
    private Double x; //Поле не может быть null
    private float y;

    public Coordinates(Double x, float y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "x=" + x + ", y=" + y;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Coordinates) {
            if (this.getX() == ((Coordinates) obj).getX() && this.getY() == ((Coordinates) obj).getY()) {return true;}
            return false;
        } else {return false;}
    }

    public Double getX() {
        return x;
    }

    public float getY() {
        return y;
    }
}
