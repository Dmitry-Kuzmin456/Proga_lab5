package Interfaces;

public interface Command {
    void execute(String[] args);
    String description();
}
