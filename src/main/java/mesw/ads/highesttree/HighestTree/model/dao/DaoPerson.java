package mesw.ads.highesttree.HighestTree.model.dao;

import mesw.ads.highesttree.HighestTree.model.Person;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.simple.JSONObject;

import java.io.*;
import java.util.*;

/**
 * 23/12/2021 LNeto
 * - changed PERSON_FILE from .txt to .json
 *
 *
 */
public class DaoPerson implements Dao<Person> {
    private static final String PERSON_FILE = "files/person.json";

    private final Map<String, Person> personMap = new HashMap<>();

    public DaoPerson(){
        readJsonFile();
    }

    @Override
    public Optional<Person> get(int id) {
        return Optional.ofNullable(personMap.get(id));
    }

    @Override
    public Collection<Person> getAll() {
        return personMap.values();
    }

    @Override
    public void save(Person person) {
        personMap.put(person.getId(), person);
        writeJsonFile();
    }

    @Override
    public void update(Person person) {
        personMap.put(person.getId(), person);
        writeJsonFile();
    }

    @Override
    public void delete(Person person) {
        personMap.remove(person.getId());
        writeJsonFile();
    }

    private void writeJsonFile() {
        JSONArray jsonArray = new JSONArray();
        personMap.values().forEach(pers -> {
            jsonArray.add(pers.toJson());
        });
        //Write JSON file
        System.out.println(jsonArray.toJSONString());
        try (FileWriter file = new FileWriter(PERSON_FILE)) {
            file.write(jsonArray.toJSONString());
            file.flush();
            // TODO: Fix New line
            //PrintWriter writer = new PrintWriter(file);
            //writer.write(jsonArray.toString().replace("},{", "},\n{"));
            //writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readJsonFile(){
        personMap.clear();
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader(PERSON_FILE))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);

            JSONArray personList = (JSONArray) obj;
            System.out.println(personList);

            personList.forEach( personJson -> {
                Person person = new Person();
                person = person.fromJson((JSONObject) personJson);
                personMap.put(person.getId(),person);
            });

        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
    }
}
