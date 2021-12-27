package mesw.ads.highesttree.HighestTree.model.dao;

import mesw.ads.highesttree.HighestTree.model.Event;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.*;

/**
 * 23/12/2021 LNeto
 * - Copied implementation from 'DaoPerson.java'
 *
 *
 */
public class DaoEvent implements Dao<Event>{
    private static final String EVENTS_FILE = "files/event.json";

    private Map<String, Event> eventMap = new HashMap<>();

    public DaoEvent(){
        readJsonFile();
    }

    @Override
    public Optional<Event> get(int id) {
        return Optional.ofNullable(eventMap.get(id));
    }

    @Override
    public Collection<Event> getAll() {
        return eventMap.values();
    }

    @Override
    public void save(Event event) {
        eventMap.put(event.getId(), event);
        writeJsonFile();
    }

    @Override
    public void update(Event event) {
        eventMap.put(event.getId(), event);
        writeJsonFile();
    }

    @Override
    public void delete(Event event) {
        eventMap.remove(event.getId());
        writeJsonFile();
    }

    private void writeJsonFile() {
        JSONArray jsonArray = new JSONArray();
        eventMap.values().forEach(event -> {
            jsonArray.add(event.toJson());
        });
        //Write JSON file
        System.out.println(jsonArray.toJSONString());
        try (
                FileWriter file = new FileWriter(EVENTS_FILE)) {
            file.write(jsonArray.toJSONString());
            file.flush();
            // TODO: Fix New line
//            PrintWriter writer = new PrintWriter(file);
//            writer.write(jsonArray.toString().replace("{", "\n{\n").replace("}", "\n}\n").replace(",", ",\n"));
//            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readJsonFile(){
        eventMap.clear();
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader(EVENTS_FILE))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);

            JSONArray eventList = (JSONArray) obj;
            System.out.println(eventList);

            eventList.forEach( eventJson -> {
                Event event = new Event();
                event = event.fromJson((JSONObject) eventJson);
                eventMap.put(event.getId(),event);
            });

        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
    }
}
