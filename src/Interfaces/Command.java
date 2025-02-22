package Interfaces;

import util.ScriptScanner;

import java.util.Scanner;

/**
 * Интерфейс для всех команд
 */
public interface Command {
    /**
     * Исполнение команды в случае, когда ее ввел сам пользователь
     * @param args входные аргументы команды
     */
    void execute(String[] args);
    /**
     * Исполнение команды из скрипта
     * @param args входные аргументы команды
     */
    void execute(String[] args, ScriptScanner scanner);

    /**
     *
     * @return описание команды
     */
    String description();
}
