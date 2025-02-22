package Interfaces;

/**
 * Проверка на правильность количества переданных аргументов
 */
public interface ArgumentValidator {
    /**
     * @param args аргументы, которые передавались команде
     * @return корректность количества введенных аргументов
     */
    boolean argumentsValidation(String[] args);
}
