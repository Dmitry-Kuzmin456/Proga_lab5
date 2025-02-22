package commands;

import Exceptions.RecursionLimitException;
import Interfaces.ArgumentValidator;
import Interfaces.Command;
import client.ClientConsole;
import collection.CollectionManager;
import util.History;
import util.ScriptMode;
import util.ScriptScanner;
import util.ScriptsStack;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * Команда, вызывающая скрипт
 */
public class ExecuteScriptCommand implements Command, ArgumentValidator {
    private CommandManager commandManager;
    private CollectionManager collectionManager;
    private History history;
    private ClientConsole console = ClientConsole.getConsole();

    public ExecuteScriptCommand(CommandManager commandManager, CollectionManager collectionManager, History history) {
        this.commandManager = commandManager;
        this.collectionManager = collectionManager;
        this.history = history;
    }

    @Override
    public void execute(String[] args) throws IllegalArgumentException, RecursionLimitException {
        if (!argumentsValidation(args)) {
            throw new IllegalArgumentException("Invalid arguments");
        }
        try{
            Scanner sc = new Scanner(new FileInputStream(args[0]));
            ScriptScanner scriptScanner = new ScriptScanner(sc, args[0]);
            ScriptMode scriptMode = new ScriptMode(commandManager, collectionManager, history, scriptScanner);
            history.addElement("execute_script");
            scriptMode.run();
        } catch (IOException e){
            throw new IllegalArgumentException("No such file");
        } catch (RecursionLimitException e){
            throw e;
        }
    }

    @Override
    public void execute(String[] args, ScriptScanner scanner) throws IllegalArgumentException, RecursionLimitException {
        execute(args);
    }

    @Override
    public String description() {
        return "Executes commands in script mode";
    }

    @Override
    public boolean argumentsValidation(String[] args){
        return args.length == 1;
    }
}
