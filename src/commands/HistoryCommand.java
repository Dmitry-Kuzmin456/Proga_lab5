package commands;

import Interfaces.ArgumentValidator;
import Interfaces.Command;
import client.ClientConsole;
import util.History;
import util.ScriptScanner;

import java.util.Scanner;

/**
 * Команда, выводящая последние 15 исполненных команд
 */
public class HistoryCommand implements Command, ArgumentValidator {
    private History history;
    private ClientConsole console;

    public HistoryCommand(History history, ClientConsole console) {
        this.history = history;
        this.console = console;
    }

    @Override
    public void execute(String[] args) throws IllegalArgumentException {
        if (!argumentsValidation(args)) {
            throw new IllegalArgumentException("Invalid number of arguments");
        }
        console.println(history.getHistory());
    }

    @Override
    public void execute(String[] args, ScriptScanner scanner) throws IllegalArgumentException {
        execute(args);
    }

    @Override
    public String description() {
        return "displays the history of commands";
    }

    @Override
    public boolean argumentsValidation(String[] args){
        return args.length == 0;
    }
}
