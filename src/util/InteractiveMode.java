package util;

import Exceptions.IllegalDataException;
import client.ClientConsole;
import collection.CollectionManager;
import model.CreateCity;
import commands.CommandManager;
import model.City;

import java.io.IOException;
import java.util.Arrays;

public class InteractiveMode {
    private final ClientConsole console;
    private final CollectionManager collectionManager;
    private final CommandManager commandManager;
    private final History history;
    private MyFileReader fileReader;
    private MyFileWriter fileWriter;

    public InteractiveMode() {
        this.console = new ClientConsole();
        this.collectionManager = new CollectionManager();
        this.history = new History();
        this.commandManager = new CommandManager(console, collectionManager, history);
        try{
            this.fileReader = new MyFileReader("src/collection.csv");
            this.fileWriter = new MyFileWriter("src/collection.csv");
        } catch (IOException e) {
            console.println("error: couldn't open collection.csv file");
        }
    }

    public void run(){
        CreateCity.setCollectionManager(collectionManager);
        CreateCity.setConsole(console);
        try{
            String[] line;
            while ((line = fileReader.readLine()) != null){
                try{
                    City city = CreateCity.createCityWithDefaultId(line);
                    collectionManager.addElement(city);
                } catch (IllegalArgumentException e) {
                    console.println("incorrect data format in line " + collectionManager.getId());
                } catch (IllegalDataException e) {
                    console.println("data line " + collectionManager.getId() + " contains data which not match with range of acceptable values");
                }
            }
        } catch (IOException e){
            console.println("failed to read file");
        }

        while (true){
            console.print("your command: ");
            String[] command = console.readAsArr();
            try{
                commandManager.executeCommand(command[0], Arrays.copyOfRange(command, 1, command.length));
                history.addElement(command[0]);
            } catch (IllegalArgumentException | IllegalDataException e){
                console.println(e.getMessage());
            }

        }
    }
}
