package Exceptions;

/**
 * Исключение для отслеживания глубины рекурсии при исполнении скриптов
 */
public class RecursionLimitException extends RuntimeException {
    public RecursionLimitException(String message) {
        super(message);
    }
}
