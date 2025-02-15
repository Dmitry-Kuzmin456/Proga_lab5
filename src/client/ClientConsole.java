package client;

import Interfaces.Console;

import java.util.Scanner;

public class ClientConsole implements Console {
    private final Scanner sc = new Scanner(System.in);
    private static ClientConsole console;

    private ClientConsole() {
    }

    public static ClientConsole getConsole(){
        if (console == null){
            console = new ClientConsole();
        }
        return console;
    }

    @Override
    public void print(String info){
        System.out.print(info);
    }

    @Override
    public void println(String info){
        System.out.println(info);
    }

    @Override
    public String[] readAsArr(){
        String line = sc.nextLine();
        return line == null ? null : line.split(" ");
    }

    @Override
    public String readWord() throws IllegalArgumentException {
        String line = sc.nextLine();
        if (line == null || line.isEmpty() || line.split(" ").length != 1){
            throw new IllegalArgumentException("Must be one argument");
        }
        return line;
    }

    @Override
    public String readLine(){
        return sc.nextLine();
    }
}
