package model;

import client.ClientConsole;

import java.util.Arrays;

public class AskCity {
    private static ClientConsole console = ClientConsole.getConsole();

    public static String[] askCity(long id) throws IllegalArgumentException {
        String[] data = new String[11];
        console.print("Name: ");
        data[0] = console.readLine();
        console.print("coordinate x: ");
        data[1] = console.readWord();
        console.print("coordinate y: ");
        data[2] = console.readWord();
        console.print("area: ");
        data[3] = console.readWord();
        console.print("population: ");
        data[4] = console.readWord();
        console.print("meters above sea level: ");
        data[5] =console.readWord();
        console.print("climate(" + Climate.valuesList() + "): ");
        data[6] = console.readLine();
        console.print("government(" + Government.valuesList() + "): ");
        data[7] = console.readLine();
        console.print("standard of living(" + StandardOfLiving.valuesList() + "): ");
        data[8] = console.readLine();
        console.print("governors age: ");
        data[9] = console.readWord();
        data[10] = String.valueOf(id);
        return data;
    }
}
