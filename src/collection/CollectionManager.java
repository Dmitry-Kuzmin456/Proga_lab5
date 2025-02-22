package collection;

import model.*;

import java.util.Collection;
import java.util.HashMap;
import java.time.ZonedDateTime;

/**
 * Кдасс, управляющий коллекцией элементов
 */
public class CollectionManager {
    private long currentId = 1;
    private final HashMap<Long, City> collection = new HashMap<>();
    private final ZonedDateTime creationTime = ZonedDateTime.now();

    public void addElement(City city) {
        collection.put(currentId, city);
    }

    public void addElementById(long id, City city) {
        collection.put(id, city);
    }

    public void nextId(){
        currentId++;
    }

    public long getId(){
        return currentId;
    }

    public City getElementById(long id) {
        return collection.get(id);
    }

    public HashMap<Long, City> getAllElements(){
        return collection;
    }

    public String getInfo(){
        String time = String.valueOf(creationTime.getDayOfMonth()) + " " +
                String.valueOf(creationTime.getMonth()).toLowerCase() + " " +
                creationTime.getHour() + "h " + creationTime.getMinute() + "m";
        return "HashMap collection with City objects\ncreation time: " + time +
                "\nnumber of elements is: " + collection.size();
    }

    public void removeElement(long id){
        collection.remove(id);
    }
}
