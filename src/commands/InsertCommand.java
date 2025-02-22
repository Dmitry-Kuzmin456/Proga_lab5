package commands;

import Interfaces.ArgumentValidator;
import Interfaces.Command;
import client.ClientConsole;
import collection.CollectionManager;
import model.City;
import model.CreateCity;
import Exceptions.IllegalDataException;
import util.ScriptScanner;

import java.util.Scanner;

/**
 * Команда, добавляющая элемент в коллекцию по ключу
 */
public class InsertCommand implements Command, ArgumentValidator {
    private CollectionManager collectionManager;

    public InsertCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String[] args) throws IllegalArgumentException, IllegalDataException {
        if (!argumentsValidation(args)) {
            throw new IllegalArgumentException("Invalid arguments");
        }
        try {
            Long.parseLong(args[0]);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("This id is not digit");
        }
        if (collectionManager.getAllElements().containsKey(Long.parseLong(args[0]))) {throw new IllegalDataException("This id already exists");}
        City city = CreateCity.createCityWithGivenId(Long.parseLong(args[0]));
        collectionManager.addElementById(city.getId(), city);
    }

    @Override
    public void execute(String[] args, ScriptScanner scanner) throws IllegalArgumentException, IllegalDataException {
        if (!argumentsValidation(args)) {
            throw new IllegalArgumentException("Invalid arguments");
        }
        try {
            Long.parseLong(args[0]);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("This id is not digit");
        }
        if (collectionManager.getAllElements().containsKey(Long.parseLong(args[0]))) {throw new IllegalDataException("This id already exists");}
        City city = CreateCity.createCityWithGivenIdScript(Long.parseLong(args[0]), scanner);
        collectionManager.addElementById(city.getId(), city);
    }

    @Override
    public String description() {
        return "insert element in collection";
    }

    @Override
    public boolean argumentsValidation(String[] args){
        return args.length == 1;
    }
}
