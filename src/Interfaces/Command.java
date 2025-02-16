package Interfaces;

import util.ScriptScanner;

import java.util.Scanner;

public interface Command {
    void execute(String[] args);
    void execute(String[] args, ScriptScanner scanner);
    String description();
}
