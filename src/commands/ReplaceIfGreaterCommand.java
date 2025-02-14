package commands;

import Exceptions.IllegalDataException;
import Interfaces.ArgumentValidator;
import Interfaces.Command;
import collection.CollectionManager;
import model.City;
import model.CreateCity;

public class ReplaceIfGreaterCommand implements Command, ArgumentValidator{
    private CollectionManager collectionManager;

    public ReplaceIfGreaterCommand(CollectionManager collectionManager) {
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
        if (!collectionManager.getAllElements().containsKey(Long.parseLong(args[0]))) {throw new IllegalDataException("this id not in collection");}
        City city = CreateCity.createCityWithGivenId(Long.parseLong(args[0]));
        if (city.compareTo(collectionManager.getElementById(Long.parseLong(args[0]))) > 0){
            collectionManager.addElementById(city.getId(), city);
        }
    }

    @Override
    public String description() {
        return "replaces element if new element is greater";
    }

    @Override
    public boolean argumentsValidation(String[] args) {
        return args.length == 1;
    }
}
