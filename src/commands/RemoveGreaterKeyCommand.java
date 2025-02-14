package commands;

import Interfaces.ArgumentValidator;
import Interfaces.Command;
import collection.CollectionManager;
import model.City;

public class RemoveGreaterKeyCommand implements Command, ArgumentValidator {
    private CollectionManager collectionManager;

    public RemoveGreaterKeyCommand(CollectionManager collectionManager) {
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
            throw new IllegalArgumentException("This id is not digit");
        }
        long currentId = Long.parseLong(args[0]);
        for (long id: collectionManager.getAllElements().keySet()){
            if (id > currentId){
                collectionManager.removeElement(id);
            }
        }
    }

    @Override
    public String description() {
        return "replace a value by key if the new value is greater than the old one";
    }

    @Override
    public boolean argumentsValidation(String[] args){
        return args.length == 1;
    }
}
