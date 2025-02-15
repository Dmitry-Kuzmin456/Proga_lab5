package commands;

import Interfaces.ArgumentValidator;
import Interfaces.Command;
import client.ClientConsole;
import collection.CollectionManager;
import model.City;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Comparator;

public class PrintFieldDescendingMetersAboveSeaLevelCommand implements Command, ArgumentValidator {
    private CollectionManager collectionManager;
    private ClientConsole console;

    public PrintFieldDescendingMetersAboveSeaLevelCommand(CollectionManager collectionManager, ClientConsole console) {
        this.collectionManager = collectionManager;
        this.console = console;
    }

    @Override
    public void execute(String[] args) {
        if (!argumentsValidation(args)) {
            throw new IllegalArgumentException("Invalid arguments");
        }
        ArrayList<City> cities = new ArrayList<>(collectionManager.getAllElements().values());
        cities.sort(Comparator.comparingDouble(City::getMetersAboveSeaLevel).reversed());
        for (City city: cities) {
            console.println(city.toString());
        }
    }

    @Override
    public String description() {
        return "display elements whose field value is metersAboveSeaLevel, which is less than the specified one";
    }

    @Override
    public boolean argumentsValidation(String[] args){
        return args.length == 0;
    }
}
