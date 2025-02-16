package util;

import Exceptions.IllegalDataException;
import client.ClientConsole;
import collection.CollectionManager;
import commands.CommandManager;

import java.util.Arrays;
import java.util.Scanner;

public class ScriptMode {
    private ClientConsole console = ClientConsole.getConsole();
    private CommandManager commandManager;
    private CollectionManager collectionManager;
    private History history;
    private ScriptScanner scanner;

    public ScriptMode(CommandManager commandManager, CollectionManager collectionManager, History history, ScriptScanner scanner) {
        this.commandManager = commandManager;
        this.collectionManager = collectionManager;
        this.history = history;
        this.scanner = scanner;
    }

    public void run(){
        while (scanner.hasNext()){
            String[] command = scanner.readAsArr();
            try{
                if (command[0].equals("execute_script")){
                    console.println("script contains command execute_script. You haven't use it recursively");
                }
                commandManager.executeCommandScript(command[0], Arrays.copyOfRange(command, 1, command.length), scanner);
                history.addElement(command[0]);
            } catch (IllegalArgumentException | IllegalDataException e){
                console.println(e.getMessage());
            }
        }
    }
}
