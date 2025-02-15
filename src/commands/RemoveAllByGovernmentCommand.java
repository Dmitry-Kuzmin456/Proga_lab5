package commands;

import Exceptions.IllegalDataException;
import Interfaces.ArgumentValidator;
import Interfaces.Command;
import collection.CollectionManager;
import model.AskGovernment;
import model.City;
import model.Government;

import java.util.HashMap;

public class RemoveAllByGovernmentCommand implements Command, ArgumentValidator {
    private CollectionManager collectionManager;

    public RemoveAllByGovernmentCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String[] args) throws IllegalArgumentException {
        if (!argumentsValidation(args)) {
            throw new IllegalArgumentException("Invalid arguments");
        }
        try{
            HashMap<Long, City> collection = new HashMap<>(collectionManager.getAllElements());
            Government government = AskGovernment.askGovernment();
            for (long id: collection.keySet()){
                if (collection.get(id).getGovernment() == government){
                    collectionManager.removeElement(id);
                }
            }
        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException("there isn't this type of government");
        }
    }

    @Override
    public String description() {
        return "removes an element which government field equals introduced";
    }

    @Override
    public boolean argumentsValidation(String[] args){
        return args.length == 0;
    }
}
