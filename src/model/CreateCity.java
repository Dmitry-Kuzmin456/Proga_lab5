package model;

import client.ClientConsole;
import collection.CollectionManager;
import Exceptions.IllegalDataException;
import util.ScriptScanner;

import java.util.Arrays;
import java.util.Scanner;

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

    public static City createCityWithGivenIdScript(long id, ScriptScanner scanner) throws IllegalArgumentException, IllegalDataException {
        if (id <= 0) {throw new IllegalDataException("Id cannot be negative");}
        String[] data = new String[11];
        data[0] = scanner.readLine();
        data[1] = scanner.readWord();
        data[2] = scanner.readWord();
        data[3] = scanner.readWord();
        data[4] = scanner.readWord();
        data[5] = scanner.readWord();
        data[6] = scanner.readLine();
        data[7] = scanner.readLine();
        data[8] = scanner.readLine();
        data[9] = scanner.readWord();
        data[10] = String.valueOf(id);
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
