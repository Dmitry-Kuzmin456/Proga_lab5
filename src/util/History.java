package util;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Очередь, в которой хранятся последние 15 команд
 */
public class History {
    private final Queue<String> history;

    public History() {
        this.history = new LinkedList<>();
    }

    /**
     *
     * @param command добавляет в историю последнюю выполненную команду
     */
    public void addElement(String command){
        history.add(command);
        if (history.size() > 15){
            history.remove();
        }
    }

    /**
     *
     * @return Строка с последними 15 командами
     */
    public String getHistory(){
        StringBuilder res = new StringBuilder();
        res.append("last commands: ");
        for (String s : history){
            res.append(s + " ");
        }
        return res.toString();
    }
}
