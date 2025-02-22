package Interfaces;

/**
 * Интерфейс для консоли, считывающей откуда-либо данные
 */
public interface Console {
    void print(String s);
    void println(String s);
    String[] readAsArr();
    String readWord();
    String readLine();
}
