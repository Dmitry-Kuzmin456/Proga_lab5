package commands;

import Interfaces.ArgumentValidator;
import Interfaces.Command;
import util.ScriptScanner;

import java.util.Scanner;

/**
 * Команда, завершающая выполнение программы
 */
public class ExitCommand implements Command, ArgumentValidator{
    @Override
    public void execute(String[] args) {
        if (!argumentsValidation(args)) {
            throw new IllegalArgumentException("Invalid arguments");
        }
        System.exit(0);
    }

    @Override
    public void execute(String[] args, ScriptScanner scanner){
        execute(args);
    }

    @Override
    public String description() {
        return "Exits the program";
    }

    @Override
    public boolean argumentsValidation(String[] args){
        return args.length == 0;
    }
}
