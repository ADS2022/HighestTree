package mesw.ads.highesttree.HighestTree.model.dao.location;

import mesw.ads.highesttree.HighestTree.model.dao.Dao;
import mesw.ads.highesttree.HighestTree.model.place.Location;

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
    public int save(Location location) {
        locationList.add(location);
        int index = locationList.size() - 1;
        location.setId(index);
        return index;
    }

    @Override
    public void update(Location location) {
        locationList.set(location.getId(), location);
    }

    @Override
    public void delete(Location location) {
        locationList.set(location.getId(), null);
    }
}
