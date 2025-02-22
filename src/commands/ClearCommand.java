package commands;

import Exceptions.IllegalDataException;
import Interfaces.ArgumentValidator;
import Interfaces.Command;
import collection.CollectionManager;
import model.City;
import model.CreateCity;
import util.ScriptScanner;

import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Команда, очищающая коллекцию элементов
 */
public class ClearCommand implements Command, ArgumentValidator {
    private CollectionManager collectionManager;

    public ClearCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String[] args) throws IllegalArgumentException {
        if (!argumentsValidation(args)) {
            throw new IllegalArgumentException("Invalid arguments");
        }
        HashMap<Long, City> collection = collectionManager.getAllElements();
        collection.clear();
    }

    @Override
    public void execute(String[] args, ScriptScanner scanner) throws IllegalArgumentException{
        execute(args);
    }

    @Override
    public String description() {
        return "Clear all elements";
    }

    @Override
    public boolean argumentsValidation(String[] args) {
        return args.length == 0;
    }
}
