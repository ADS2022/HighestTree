package mesw.ads.highesttree.HighestTree.model.dao;

import mesw.ads.highesttree.HighestTree.model.Location;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.simple.JSONObject;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * 23/12/2021 LNeto
 * - Copied implementation from 'DaoPerson.java'
 *
 *
 */
public class DaoLocation implements Dao<Location> {
    private static final String LOCATION_FILE = "files/location.json";

    private Map<String, Location> locationMap = new HashMap<>();
    private List<Location> locationList = new LinkedList<>();

    public DaoLocation(){
        readJsonFile();
    }

    @Override
    public Optional<Location> get(int id) {
        return Optional.ofNullable(locationMap.get(id));
    }

    @Override
    public Collection<Location> getAll() {
        return locationMap.values();
    }

    @Override
    public void save(Location location) {
        locationMap.put(location.getId(), location);
    }

    @Override
    public void update(Location location) {
        locationMap.put(location.getId(), location);
        writeJsonFile();
    }

    @Override
    public void delete(Location location) {
        locationMap.remove(location.getId());
        writeJsonFile();
    }

    private void writeJsonFile() {
        JSONArray jsonArray = new JSONArray();
        locationMap.values().forEach(loc -> {
            jsonArray.add(loc.toJson());
        });
        //Write JSON file
        System.out.println(jsonArray.toJSONString());
        try (FileWriter file = new FileWriter(LOCATION_FILE)) {
            file.write(jsonArray.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void readJsonFile(){
        locationMap.clear();
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader(LOCATION_FILE))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);

            JSONArray locationList = (JSONArray) obj;
            System.out.println(locationList);

            locationList.forEach( locationJson -> {
                Location location = new Location();
                location = location.fromJson((JSONObject) locationJson);
                locationMap.put(location.getId(),location);
            });

        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
    }
}