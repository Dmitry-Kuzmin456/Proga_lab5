package commands;

import Interfaces.ArgumentValidator;
import Interfaces.Command;
import client.ClientConsole;
import collection.CollectionManager;
import model.City;

import java.util.HashMap;

public class FilterLessThanMetersAboveSeaLevelCommand implements Command, ArgumentValidator {
    private CollectionManager collectionManager;
    private ClientConsole console;

    public FilterLessThanMetersAboveSeaLevelCommand(CollectionManager collectionManager, ClientConsole console) {
        this.collectionManager = collectionManager;
        this.console = console;
    }

    @Override
    public void execute(String[] args) throws IllegalArgumentException {
        if (!argumentsValidation(args)) {
            throw new IllegalArgumentException("Invalid arguments");
        }
        try {
            Float.parseFloat(args[0]);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("This id is not digit");
        }
        HashMap<Long, City> collection = collectionManager.getAllElements();
        for (City city : collection.values()) {
            if (city.getMetersAboveSeaLevel() < Float.parseFloat(args[0])) {
                console.println(city.toString());
            }
        }

    }

    @Override
    public String description() {
        return "display elements whose field value is metersAboveSeaLevel, which is less than the specified one";
    }

    @Override
    public boolean argumentsValidation(String[] args){
        return args.length == 1;
    }
}
