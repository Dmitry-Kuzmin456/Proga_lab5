package model;

import client.ClientConsole;
import util.ScriptScanner;

import java.util.Scanner;

/**
 * Класс, считывающий значение поля Government
 */
public class AskGovernment {
    private static ClientConsole console = ClientConsole.getConsole();

    /**
     * Запрос на ввод от пользователя
     * @return объект типа Government
     */
    public static Government askGovernment() throws IllegalArgumentException{
        Government government;
        String line;
        while (true){
            console.print("Enter government name(" + Government.valuesList() + "): ");
            line = console.readLine();
            try{
                Government.fromDescription(line);
            } catch (IllegalArgumentException e) {
                console.println(e.getMessage());
                continue;
            }
            break;
        }
        return Government.fromDescription(line);
    }

    /**
     *
     * @param scanner сканер файла со скриптом
     * @return объект типа Government
     */
    public static Government askGovernmentScript(ScriptScanner scanner) throws IllegalArgumentException{
        return Government.fromDescription(scanner.readWord());
    }
}
