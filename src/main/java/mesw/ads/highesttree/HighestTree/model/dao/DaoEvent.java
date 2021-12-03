package mesw.ads.highesttree.HighestTree.model.dao;

import mesw.ads.highesttree.HighestTree.model.Event;

import java.util.*;
import java.util.stream.Collectors;

public class DaoEvent implements Dao<Event>{
    private List<Event> eventList = new LinkedList<>();


    @Override
    public Optional<Event> get(int id) {
        return Optional.ofNullable(eventList.get(id));
    }

    @Override
    public Collection<Event> getAll() {
        return eventList.stream().filter(Objects::nonNull).collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
    }

    @Override
    public void save(Event event) {
        eventList.add(event);
    }

    @Override
    public void update(Event event) {
        eventList.set(event.getId(), event);
    }

    @Override
    public void delete(Event event) {
        eventList.set(event.getId(), null);
    }
}
