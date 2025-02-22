package util;

import Exceptions.IllegalDataException;
import Exceptions.RecursionLimitException;
import Exceptions.RecursionLimitException;
import client.ClientConsole;
import collection.CollectionManager;
import commands.CommandManager;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 * Класс, реализующий последовательное исполнение команд из скрипта
 */
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

    /**
     * Метод реализовывает исполнение команд в скрипте
     * @throws RecursionLimitException выбрасывает исключение если глубина рекурсии больше 200
     */
    public void run() throws RecursionLimitException {
        if (ScriptsStack.size() > 200){
            throw new RecursionLimitException("recursion depth more then 200, script execution paused");
        }
        if (ScriptsStack.isContains(scanner.getFileName())){
            throw new RecursionLimitException("the script calls itself");
        }
        ScriptsStack.add(scanner.getFileName());
        while (scanner.hasNext()){
            String[] command = scanner.readAsArr();
            try{
                commandManager.executeCommandScript(command[0], Arrays.copyOfRange(command, 1, command.length), scanner);
                history.addElement(command[0]);
            } catch (IllegalArgumentException | IllegalDataException e){
                console.println(e.getMessage());
            }
        }
        ScriptsStack.pop();
    }
}
