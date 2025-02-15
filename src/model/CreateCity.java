package model;

import client.ClientConsole;
import collection.CollectionManager;
import Exceptions.IllegalDataException;

import java.util.Arrays;

public class CreateCity {
    private static CollectionManager collectionManager;
    private static ClientConsole console;

    public static City createCity(String[] data) throws IllegalArgumentException{
        Coordinates coordinates = new Coordinates(Double.parseDouble(data[1]), Float.parseFloat(data[2]));
        Human human = new Human(Long.parseLong(data[9]));
        City city = new City(Long.parseLong(data[10]), data[0], coordinates, Long.parseLong(data[3]), Integer.parseInt(data[4]),
                Float.parseFloat(data[5]), Climate.fromDescription(data[6]), Government.fromDescription(data[7]),
                StandardOfLiving.fromDescription(data[8]), human);
        if (!city.isValid()) {throw new IllegalDataException("invalid data in file");}
        return city;
    }

    public static City createCityWithDefaultId(String[] data) throws IllegalArgumentException, IllegalDataException, ArrayIndexOutOfBoundsException {
        while (collectionManager.getAllElements().containsKey(collectionManager.getId())) {
            collectionManager.nextId();
        }
        String[] newData = Arrays.copyOf(data, data.length + 1);
        newData[newData.length - 1] = String.valueOf(collectionManager.getId());
        return CreateCity.createCity(newData);
    }

    public static City createCityWithGivenId(long id) throws IllegalArgumentException, IllegalDataException {

        if (id <= 0) {throw new IllegalDataException("Id cannot be negative");}
        String[] data = AskCity.askCity(id);
        try{
            return CreateCity.createCity(data);
        } catch (IllegalDataException | IllegalArgumentException e) {
            throw new IllegalDataException("You write incorrect data");
        }

    }

    public static void setCollectionManager(CollectionManager manager) {
        collectionManager = manager;
    }

    public static void setConsole(ClientConsole console) {
        CreateCity.console = console;
    }

    public static CollectionManager getCollectionManager() {
        return collectionManager;
    }
}
