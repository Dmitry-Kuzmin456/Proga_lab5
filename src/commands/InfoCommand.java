package commands;

import Interfaces.ArgumentValidator;
import Interfaces.Command;
import client.ClientConsole;
import collection.CollectionManager;
import Exceptions.IllegalDataException;
import util.ScriptScanner;

import java.util.Scanner;

/**
 * Команда, выводящая информацию о коллекции
 */
public class InfoCommand implements Command, ArgumentValidator {
    private CollectionManager collectionManager;
    private ClientConsole console;

    public InfoCommand(CollectionManager collectionManager, ClientConsole console) {
        this.collectionManager = collectionManager;
        this.console = console;
    }

    @Override
    public void execute(String[] args) throws IllegalArgumentException, IllegalDataException {
        if (!argumentsValidation(args)) {
            throw new IllegalArgumentException("Invalid arguments");
        }
        console.println(collectionManager.getInfo());
    }

    @Override
    public void execute(String[] args, ScriptScanner scanner) throws IllegalArgumentException {
        execute(args);
    }

    @Override
    public String description() {
        return "writing info about collection";
    }

    @Override
    public boolean argumentsValidation(String[] args){
        return args.length == 0;
    }
}
