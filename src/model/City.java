package model;

import Interfaces.Validatable;

import java.time.ZonedDateTime;

public class City implements Validatable, Comparable<City> {
    private long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private long area; //Значение поля должно быть больше 0
    private int population; //Значение поля должно быть больше 0
    private float metersAboveSeaLevel;
    private Climate climate; //Поле не может быть null
    private Government government; //Поле может быть null
    private StandardOfLiving standardOfLiving; //Поле не может быть null
    private Human governor; //Поле может быть null

    public City(long id, String name, Coordinates coordinates,
                long area, int population, float metersAboveSeaLevel, Climate climate,
                Government government, StandardOfLiving standardOfLiving, Human governor) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = ZonedDateTime.now();
        this.area = area;
        this.population = population;
        this.metersAboveSeaLevel = metersAboveSeaLevel;
        this.climate = climate;
        this.government = government;
        this.standardOfLiving = standardOfLiving;
        this.governor = governor;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "id: " + id + "\nname: " + name + "\ncoordinates: " + coordinates + "\ncreationDate: " +
                creationDate.getHour() + "h " + creationDate.getMinute() + "m" + "\narea: " + area + "\npopulation: " +
                population + "\nmetersAboveSeaLevel: " + metersAboveSeaLevel + "\nclimate: " +
                climate.getDescription() + "\ngovernment: " + government.getDescription() +
                "\nstandardOfLiving: " + standardOfLiving.getDescription() + "\ngovernor: " + governor;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof City) {
            if (!this.getName().equals(((City) o).getName())) {return false;}
            if (!this.getCoordinates().equals(((City) o).getCoordinates())) {return false;}
            if (this.getArea() != ((City) o).getArea()) {return false;}
            if (this.getPopulation() != ((City) o).getPopulation()) {return false;}
            if (this.getClimate() != ((City) o).getClimate()) {return false;}
            if (this.getGovernment() != ((City) o).getGovernment()) {return false;}
            if (this.getStandardOfLiving() != ((City) o).getStandardOfLiving()) {return false;}
            if (this.getGovernor() != ((City) o).getGovernor()) {return false;}
            if (this.getId() != ((City) o).getId()) {return false;}
            if (this.getMetersAboveSeaLevel() != ((City) o).getMetersAboveSeaLevel()) {return false;}
            return true;
        } else {
            return false;
        }

    }

    @Override
    public boolean isValid() {
        if (name == null || name.isEmpty()){return false;}
        if (coordinates == null){return false;}
        if (area < 0){return false;}
        if (population < 0){return false;}
        if (climate == null || government == null || standardOfLiving == null){return false;}
        return true;
    }

    @Override
    public int compareTo(City o) {
        return Float.compare(metersAboveSeaLevel, o.metersAboveSeaLevel);
    }

    public String getName() {
        return name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public long getArea() {
        return area;
    }

    public int getPopulation() {
        return population;
    }

    public float getMetersAboveSeaLevel() {
        return metersAboveSeaLevel;
    }

    public String getClimate() {
        return climate.getDescription();
    }

    public String getStandardOfLiving() {
        return standardOfLiving.getDescription();
    }

    public String getGovernment() {
        return government.getDescription();
    }

    public Human getGovernor() {
        return governor;
    }
}