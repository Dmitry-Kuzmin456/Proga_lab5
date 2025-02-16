package commands;

import Interfaces.ArgumentValidator;
import Interfaces.Command;
import client.ClientConsole;
import collection.CollectionManager;
import model.City;
import util.ScriptScanner;

import java.util.HashMap;

public class ShowCommand implements Command, ArgumentValidator {
    private CollectionManager collectionManager;
    private ClientConsole console;

    public ShowCommand(CollectionManager collectionManager, ClientConsole console) {
        this.collectionManager = collectionManager;
        this.console = console;
    }

    @Override
    public void execute(String[] args) throws IllegalArgumentException {
        if (!argumentsValidation(args)) {
            throw new IllegalArgumentException("Invalid arguments");
        }
        HashMap<Long, City> collection = collectionManager.getAllElements();
        for (City city : collection.values()) {
            console.println(city.toString() + "\n");
        }
    }

    @Override
    public void execute(String[] args, ScriptScanner scanner) {
        execute(args);
    }

    @Override
    public String description() {
        return "writing all cities in collection";
    }

    @Override
    public boolean argumentsValidation(String[] args){
        return args.length == 0;
    }
}
