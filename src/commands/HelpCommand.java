package commands;

import Interfaces.ArgumentValidator;
import Interfaces.Command;
import client.ClientConsole;

import java.util.HashMap;

public class HelpCommand implements Command, ArgumentValidator {
    private CommandManager commandManager;
    private ClientConsole console;

    public HelpCommand(CommandManager commandManager, ClientConsole console) {
        this.commandManager = commandManager;
        this.console = console;
    }

    @Override
    public void execute(String[] args) throws IllegalArgumentException {
        if (!argumentsValidation(args)) {
            throw new IllegalArgumentException("Invalid arguments");
        }
        HashMap<String, Command> commands = commandManager.getAllCommands();
        for (String command: commands.keySet()){
            console.println(command + ": " + commands.get(command).description());
        }
    }

    @Override
    public String description() {
        return "writing all console commands";
    }

    @Override
    public boolean argumentsValidation(String[] args){
        return args.length == 0;
    }
}
