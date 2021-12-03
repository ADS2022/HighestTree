package mesw.ads.highesttree.HighestTree.model.dao;

import mesw.ads.highesttree.HighestTree.model.dao.Dao;
import mesw.ads.highesttree.HighestTree.model.Location;

import java.util.*;
import java.util.stream.Collectors;

public class DaoLocation implements Dao<Location> {

    private List<Location> locationList = new LinkedList<>();

    @Override
    public Optional<Location> get(int id) {
        return Optional.ofNullable(locationList.get(id));
    }

    @Override
    public Collection<Location> getAll() {
        return locationList.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
    }

    @Override
    public void save(Location location) {
        locationList.add(location);
    }

    @Override
    public void update(Location location) {
        //locationList.set(location.getId(), location);
    }

    @Override
    public void delete(Location location) {
        locationList.set(1, null);
    }
}