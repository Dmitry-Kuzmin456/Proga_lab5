package util;

import java.util.Scanner;

public class ScriptScanner {
    private Scanner sc;

    public ScriptScanner(Scanner sc) {
        this.sc = sc;
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

}
