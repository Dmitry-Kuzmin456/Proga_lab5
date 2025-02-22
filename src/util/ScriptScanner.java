package util;

import java.util.Scanner;

/**
 * Класс, который считывает информацию из файла скрипта
 */
public class ScriptScanner {
    private Scanner sc;
    private String fileName;

    public ScriptScanner(Scanner sc, String filename) {
        this.sc = sc;
        this.fileName = filename;
    }

    public String[] readAsArr(){
        String line = sc.nextLine();
        return line == null ? null : line.split(" ");
    }

    public String readWord() throws IllegalArgumentException {
        String line = sc.nextLine();
        if (line == null || line.isEmpty() || line.split(" ").length != 1){
            throw new IllegalArgumentException("Must be one argument");
        }
        return line;
    }

    public String readLine(){
        return sc.nextLine();
    }

    public boolean hasNext(){
        return sc.hasNext();
    }

    public String getFileName(){
        return fileName;
    }

}
