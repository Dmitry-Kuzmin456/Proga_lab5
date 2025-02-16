package model;

import client.ClientConsole;
import util.ScriptScanner;

import java.util.Scanner;

public class AskGovernment {
    private static ClientConsole console = ClientConsole.getConsole();

    public static Government askGovernment() throws IllegalArgumentException{
        console.print("Enter government name(" + Government.valuesList() + "): ");
        return Government.fromDescription(console.readWord());
    }

    public static Government askGovernmentScript(ScriptScanner scanner) throws IllegalArgumentException{
        return Government.fromDescription(scanner.readWord());
    }
}
