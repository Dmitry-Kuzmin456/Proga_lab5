package commands;

import Exceptions.IllegalDataException;
import Interfaces.ArgumentValidator;
import Interfaces.Command;
import collection.CollectionManager;
import model.City;
import model.CreateCity;
import util.ScriptScanner;

/**
 * Команда, обновляющая элемент коллекции по ключу
 */
public class UpdateCommand implements Command, ArgumentValidator {
    private CollectionManager collectionManager;

    public UpdateCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String[] args)  throws IllegalArgumentException, IllegalDataException {
        if (!argumentsValidation(args)) {
            throw new IllegalArgumentException("invalid arguments");
        }
        try {
            Long.parseLong(args[0]);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("this id is not digit");
        }
        if (!collectionManager.getAllElements().containsKey(Long.parseLong(args[0]))) {
            throw new IllegalArgumentException("this id not in collection");
        }
        City city = CreateCity.createCityWithGivenId(Long.parseLong(args[0]));
        collectionManager.addElementById(city.getId(), city);
    }

    @Override
    public void execute(String[] args, ScriptScanner scanner) {
        if (!argumentsValidation(args)) {
            throw new IllegalArgumentException("invalid arguments");
        }
        try {
            Long.parseLong(args[0]);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("this id is not digit");
        }
        if (!collectionManager.getAllElements().containsKey(Long.parseLong(args[0]))) {
            throw new IllegalArgumentException("this id not in collection");
        }
        City city = CreateCity.createCityWithGivenIdScript(Long.parseLong(args[0]), scanner);
        collectionManager.addElementById(city.getId(), city);
    }

    @Override
    public String description() {
        return "updates the element with the required id";
    }

    @Override
    public boolean argumentsValidation(String[] args){
        return args.length == 1;
    }
}
