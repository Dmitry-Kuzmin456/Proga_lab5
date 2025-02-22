package commands;

import Interfaces.ArgumentValidator;
import Interfaces.Command;
import client.ClientConsole;
import collection.CollectionManager;
import model.City;
import util.ScriptScanner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Команда, выводящая все элементы в коллекции
 */
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
        ArrayList<Long> keys = new ArrayList<>(collection.keySet());
        Arrays.sort(keys.toArray());
        for (Long id : keys) {
            console.println(collection.get(id).toString() + "\n");
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
