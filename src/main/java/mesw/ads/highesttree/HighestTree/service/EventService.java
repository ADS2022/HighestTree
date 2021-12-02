package mesw.ads.highesttree.HighestTree.service;

import mesw.ads.highesttree.HighestTree.model.Event;
import mesw.ads.highesttree.HighestTree.model.dao.Dao;
import mesw.ads.highesttree.HighestTree.model.dao.DaoEvent;
import mesw.ads.highesttree.HighestTree.model.database.Reader;
import mesw.ads.highesttree.HighestTree.model.database.Writer;

import java.util.List;

public class EventService {
    private static final String FILE_NAME = "files/event.txt";
    private static Dao<Event> eventDao = new DaoEvent();
    private static Event event;

    public static void save(
            String name,
            String place,
            String startDate,
            String endDate,
            String description,
            String persons,
            String source
    ){
        event = new Event();
        event.setName(name);
        eventDao.save(event);
        Writer.writeToFile(FILE_NAME, event.toString());
    }

    public static List<String> getAllEventsFromFileDatabase(){
        return Reader.readFromFile(FILE_NAME);
    }
}
