package commands;

import Interfaces.ArgumentValidator;
import Interfaces.Command;
import collection.CollectionManager;
import model.City;
import util.ScriptScanner;

import java.util.ArrayList;
import java.util.List;

/**
 * Команда, удаляющая все элементы с id больше заданного
 */
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
        List<Long> keys = new ArrayList<>(collectionManager.getAllElements().keySet());
        for (long id : keys) {
            if (id > currentId) {
                collectionManager.removeElement(id);  // ✅ Теперь безопасно
            }
        }
    }

    @Override
    public void execute(String[] args, ScriptScanner scanner) {
        execute(args);
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
