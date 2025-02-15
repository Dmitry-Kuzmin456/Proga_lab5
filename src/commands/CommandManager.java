package commands;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

import Interfaces.Command;
import client.ClientConsole;
import collection.CollectionManager;
import Exceptions.IllegalDataException;
import util.History;
import util.MyFileWriter;

public class CommandManager {
    private final HashMap<String, Command> commands = new HashMap<>();
    private final ClientConsole console;
    private final CollectionManager collectionManager;
    private final History history;
    private MyFileWriter fileWriter;

    public CommandManager(ClientConsole console, CollectionManager collectionManager, History history, String filename) {
        this.console = console;
        this.collectionManager = collectionManager;
        this.history = new History();
        try{
            this.fileWriter = new MyFileWriter("src/collection.csv");
        } catch (IOException e) {
            console.println("error: couldn't open collection.csv file");
        }
        commands.put("help", new HelpCommand(this, console));
        commands.put("show", new ShowCommand(collectionManager, console));
        commands.put("info", new InfoCommand(collectionManager, console));
        commands.put("insert", new InsertCommand(collectionManager));
        commands.put("history", new HistoryCommand(history, console));
        commands.put("update", new UpdateCommand(collectionManager));
        commands.put("remove_key", new RemoveKeyCommand(collectionManager));
        commands.put("clear", new ClearCommand(collectionManager));
        commands.put("exit", new ExitCommand());
        commands.put("replace_if_greater", new ReplaceIfGreaterCommand(collectionManager));
        commands.put("remove_greater_key", new RemoveGreaterKeyCommand(collectionManager));
        commands.put("remove_all_by_government", new RemoveAllByGovernmentCommand(collectionManager));
        commands.put("filter_less_than_meters_above_sea_level", new FilterLessThanMetersAboveSeaLevelCommand(collectionManager, console));
        commands.put("print_field_descending_meters_above_sea_level", new PrintFieldDescendingMetersAboveSeaLevelCommand(collectionManager, console));

    }

    public void executeCommand(String name, String[] args) throws IllegalArgumentException, IllegalDataException {
        Command command = commands.get(name);
        if (command == null) {throw new IllegalArgumentException("No such command");}
        command.execute(args);
    }

    public HashMap<String, Command> getAllCommands() {
        return commands;
    }
}
