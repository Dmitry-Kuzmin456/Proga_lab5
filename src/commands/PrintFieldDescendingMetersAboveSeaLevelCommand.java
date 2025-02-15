package commands;

import Interfaces.ArgumentValidator;
import Interfaces.Command;
import client.ClientConsole;
import collection.CollectionManager;

import java.awt.event.ActionListener;

public class PrintFieldDescendingMetersAboveSeaLevelCommand implements Command, ArgumentValidator {
    private CollectionManager collectionManager;
    private ClientConsole console;

    public PrintFieldDescendingMetersAboveSeaLevelCommand(CollectionManager collectionManager, ClientConsole console) {
        this.collectionManager = collectionManager;
        this.console = console;
    }

    @Override
    public void execute(String[] args) {

    }

}
