package util;
import java.util.LinkedList;
import java.util.Queue;

public class History {
    private final Queue<String> history;

    public History() {
        this.history = new LinkedList<>();
    }

    public void addElement(String command){
        history.add(command);
        if (history.size() > 15){
            history.remove();
        }
    }

    public String getHistory(){
        StringBuilder res = new StringBuilder();
        res.append("last commands: ");
        for (String s : history){
            res.append(s + " ");
        }
        return res.toString();
    }
}
