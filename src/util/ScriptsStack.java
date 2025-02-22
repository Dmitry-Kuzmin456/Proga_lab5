package util;

import java.util.Stack;

/**
 * Класс, в котором реализовано хранение стека с названиями исполняемых сейчас скриптов
 */
public class ScriptsStack {
    private static Stack<String> stack = new Stack<>();

    public static void add(String name){
        stack.push(name);
    }

    public static void pop(){
        stack.pop();
    }

    public static boolean isContains(String name){
        return stack.contains(name);
    }

    public static int size(){
        return stack.size();
    }
}
