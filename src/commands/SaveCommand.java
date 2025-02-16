package commands;

import Interfaces.ArgumentValidator;
import Interfaces.Command;
import client.ClientConsole;
import collection.CollectionManager;
import model.City;
import util.MyFileWriter;
import util.ScriptScanner;

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
        if (!argumentsValidation(args)) {
            throw new IllegalArgumentException("Invalid arguments");
        }
        try{
            fileWriter.clearFile();
            for (City city: collectionManager.getAllElements().values()){
                StringBuilder line = new StringBuilder();
                line.append(city.getName()).append(",").append(city.getCoordinates().getX()).append(",");
                line.append(city.getCoordinates().getY()).append(",").append(city.getArea()).append(",");
                line.append(city.getPopulation()).append(",").append(city.getMetersAboveSeaLevel()).append(",");
                line.append(city.getClimate()).append(",").append(city.getGovernment()).append(",");
                line.append(city.getStandardOfLiving()).append(",").append(city.getGovernor().getAge()).append("\n");
                fileWriter.writeLine(line.toString());
            }
        } catch (IOException e) {
            console.println("no such file");
        }
    }

    @Override
    public void execute(String[] args, ScriptScanner scanner) {
        execute(args);
    }

    @Override
    public String description() {
        return "update data in file";
    }

    @Override
    public boolean argumentsValidation(String[] args){
        return args.length == 0;
    }

}
