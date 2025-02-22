package Exceptions;

/**
 * Исключение для отслеживания корректности введенных данных с точки зрения условия лабораторной
 */
public class IllegalDataException extends RuntimeException {
    public IllegalDataException(String message) {
        super(message);
    }
}
