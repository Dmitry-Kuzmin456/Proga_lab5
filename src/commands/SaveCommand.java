package commands;

import Interfaces.ArgumentValidator;
import Interfaces.Command;
import client.ClientConsole;
import collection.CollectionManager;
import model.City;
import util.MyFileWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SaveCommand implements Command, ArgumentValidator {
    private CollectionManager collectionManager;
    private ClientConsole console;
    private MyFileWriter fileWriter;

    public SaveCommand(CollectionManager collectionManager, ClientConsole console, MyFileWriter fileWriter) {
        this.collectionManager = collectionManager;
        this.fileWriter = fileWriter;
        this.console = console;
    }

    @Override
    public void execute(String[] args) {
        try{
            fileWriter.clearFile();
        } catch (IOException e) {
            console.println("no such file");
        }
        for (City city: collectionManager.getAllElements().values()){
            fileWriter.
        }
    }
}
