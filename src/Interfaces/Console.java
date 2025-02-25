package Interfaces;

/**
 * Интерфейс для консоли, считывающей откуда-либо данные
 */
public interface Console {
    void print(String s);
    void println(String s);

    /**
     * Считывает строку и возвращает массив из слов в этой строке
     * @return массив из слов
     */
    String[] readAsArr();

    /**
     * Считывает одно слово в строке и выбрасывает исключение в ином случае
     * @return одно считанное слово в строке
     * @throws IllegalArgumentException выбрасывается если в строке более одного слова
     */
    String readWord() throws IllegalArgumentException;

    /**
     * Считывает строку
     * @return сорока
     */
    String readLine();
}
