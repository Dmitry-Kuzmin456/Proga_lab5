package model;

import client.ClientConsole;

public class AskGovernment {
    private static ClientConsole console = ClientConsole.getConsole();

    public static Government askGovernment() throws IllegalArgumentException{
        console.print("Enter government name(" + Government.valuesList() + "): ");
        return Government.fromDescription(console.readWord());
    }
}
