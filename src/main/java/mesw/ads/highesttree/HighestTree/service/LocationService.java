package mesw.ads.highesttree.HighestTree.service;

import mesw.ads.highesttree.HighestTree.model.Location;
import mesw.ads.highesttree.HighestTree.model.dao.Dao;
import mesw.ads.highesttree.HighestTree.model.dao.DaoLocation;
import mesw.ads.highesttree.HighestTree.model.database.Reader;
import mesw.ads.highesttree.HighestTree.model.database.Writer;

import java.util.Collection;
import java.util.List;

public class LocationService {
    private static Dao<Location> locationDao = new DaoLocation();
    private static Location location;
    private static final String FILE_NAME = "files/location.txt";

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
        Writer.writeToFile(FILE_NAME, location.toString());
    }

    public static Collection<Location> getAllLocations() {
        return locationDao.getAll();
    }

    public static void saveLocation(Location location) {
        validate(location);
        locationDao.save(location);
        Writer.writeToFile(FILE_NAME, location.toString());
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