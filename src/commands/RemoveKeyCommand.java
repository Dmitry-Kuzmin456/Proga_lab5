package commands;

import Interfaces.ArgumentValidator;
import Interfaces.Command;
import collection.CollectionManager;
import util.ScriptScanner;

public class RemoveKeyCommand implements Command, ArgumentValidator{
    private CollectionManager collectionManager;

    public RemoveKeyCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String[] args) throws IllegalArgumentException {
        if (!argumentsValidation(args)) {
            throw new IllegalArgumentException("Invalid arguments");
        }
        try {
            Long.parseLong(args[0]);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("this id is not digit");
        }
        if (!collectionManager.getAllElements().containsKey(Long.parseLong(args[0]))) {
            throw new IllegalArgumentException("this id not in collection");
        }
        collectionManager.removeElement(Long.parseLong(args[0]));
    }

    @Override
    public void execute(String[] args, ScriptScanner scanner) {
        execute(args);
    }

    @Override
    public String description() {
        return "removes an element by key";
    }

    @Override
    public boolean argumentsValidation(String[] args){
        return args.length == 1;
    }
}
