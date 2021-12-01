package mesw.ads.highesttree.HighestTree.service;

import mesw.ads.highesttree.HighestTree.dao.Dao;
import mesw.ads.highesttree.HighestTree.dao.location.DaoLocation;
import mesw.ads.highesttree.HighestTree.model.database.Reader;
import mesw.ads.highesttree.HighestTree.model.database.Writer;
import mesw.ads.highesttree.HighestTree.model.place.Location;

import java.util.Collection;
import java.util.List;

public class LocationService {
    private static Dao<Location> locationDao = new DaoLocation();
    private static Location location;

    public static void save(String name,
                            String country,
                            String district,
                            String city,
                            String street,
                            String description,
                            boolean isSensitive) {
        location = new Location(name, country, district, city, street, description);
        location.setSensitive(isSensitive);
        locationDao.save(location);
        // Register user on the file database
        Writer.writeToFile("files/location.txt", location.toString());
    }

    public static Collection<Location> getAllLocations() {
        return locationDao.getAll();
    }

    public static int saveLocation(Location location) {
        validate(location);
        return locationDao.save(location);
    }

    private static void validate(Location location) {
        // Not implemented
        if (location == null)
            throw new NullPointerException();
    }

    public static List<String> getAllLocationsFromFileDatabase() {
        // Reads user from file database
        return Reader.readFromFile("files/location.txt");
    }

    public Location getLocation() {
        return location;
    }
}
