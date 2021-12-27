package mesw.ads.highesttree.HighestTree.model;
import mesw.ads.highesttree.HighestTree.model.place.Location;
import org.json.simple.JSONObject;

import java.util.LinkedList;
import java.util.Objects;
import java.util.UUID;

/**
 * 20/12/2021 LNeto
 * - Added constructor with setId(), as done in Person.java
 * - Added JSONObject (toJson and fromJson methods)
 * - Changed id from int to string
 * - Added methods to return LinkedList<> and objects as string to 'view':
 *             getPersonsInvolvedAsText()
 * - Source changed to a LinkedList<Source>, one Event can have many sources of information.
 * - Methods setPlace and getPlace renamed to setLocation and getLocation
 */
public class Event {
    private String id;
    private String name;
    private Events standardEvents;
    private String description;
    private SuperDate superDate;
    private Location location;
    private LinkedList<Person> personsInvolved;
    private LinkedList<Source> source;
    private boolean isSensitive;

    private static  String EMPTY = "<field is empty>";

    //Constructor for empty parameters
    public Event(){
        setId(UUID.randomUUID().toString());
    }

    public Event(String name,
                 String description,
                 Events standardEvents,
                 SuperDate superDate,
                 Location location,
                 Person personInvolved,
                 Source source,
                 boolean isSensitive)
    {
        this.personsInvolved = new LinkedList<>();
        setName(name);
        setDescription(description);
        setStandardEvents(standardEvents);
        setSuperDate(superDate);
        setLocation(location);
        insertPerson(personInvolved);
        setSource(source);
        setSensitive(isSensitive);
    }

    // SETTERS AND GETTERS
    //    private String id;
    public String getId() {
        return id;
    }

    // LNeto: If ID is set when object is created, do we want to overwrite it ?
    public void setId(String id) {
        this.id = id;
    }


    //    private String name;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.length() <= 0)
            throw new IllegalArgumentException();
        else
            this.name = name;
    }

    //    private Events standardEvents;
    public Events getStandardEvents() {
        if (this.standardEvents == null){
            this.standardEvents = Events.UNKNOWN;
        }
        return standardEvents;
    }

    public void setStandardEvents(Events event) {
        if (event == null)
            throw new NullPointerException();
        else
            this.standardEvents = event;
    }

    //    private String description;
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description == null || description.length() <= 0)
            throw new IllegalArgumentException();
        else
            this.description = description;
    }

    //    private SuperDate superDate;
    public SuperDate getSuperDate() {
        return superDate;
    }

    public void setSuperDate(SuperDate superDate) {
        if (superDate == null)
            throw new IllegalArgumentException();
        else
            this.superDate = superDate;
    }

    //    private Location location;
    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        if (location == null)
            throw new IllegalArgumentException();
        else
            this.location = location;
    }

    //    private LinkedList<Person> personsInvolved;
    public void insertPerson(Person person) {
        if (person == null)
            throw new NullPointerException();
            // LNeto: Why the NOT ?
        else if (!(this.personsInvolved.contains(person)))
            this.personsInvolved.add(person);
        else
            throw new IllegalArgumentException();
    }

    public LinkedList<Person> getPersonsInvolved() {
        return personsInvolved;
    }

    public String getPersonsInvolvedAsText() {
        if (personsInvolved == null){
            return EMPTY;
        }
        //TODO: Create method to return First Name + Last Name
        // of personsInvolved list as text
        return personsInvolved.toString();
    }

    //    private LinkedList<Source> source;
    public LinkedList<Source> getSource() {
        return source;
    }

    public void setSource(Source source) {
        if (source == null)
            throw new IllegalArgumentException();
        else
            this.source.add(source);
    }

    //    private boolean isSensitive;
    public boolean isSensitive() {
        return isSensitive;
    }

    public void setSensitive(boolean sensitive) {
        isSensitive = sensitive;
    }


    // METHODS

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Event)) return false;
        Event event = (Event) o;
        return isSensitive() == event.isSensitive() &&
                Objects.equals(getName(),
                        event.getName()) &&
                getStandardEvents() == event.getStandardEvents() &&
                Objects.equals(getDescription(), event.getDescription()) &&
                Objects.equals(getSuperDate(), event.getSuperDate()) &&
                Objects.equals(getLocation(), event.getLocation()) &&
                Objects.equals(getPersonsInvolved(), event.getPersonsInvolved()) &&
                Objects.equals(getSource(), event.getSource());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(),
                getStandardEvents(),
                getDescription(),
                getSuperDate(),
                getLocation(),
                getPersonsInvolved(),
                getSource(),
                isSensitive());
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", standardEvents=" + standardEvents +
                ", description='" + description + '\'' +
                ", superDate=" + superDate +
                ", place=" + location +
                ", personsInvolved=" + personsInvolved +
                ", source=" + source +
                ", isSensitive=" + isSensitive +
                '}';
    }


    public JSONObject toJson(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", id);
        jsonObject.put("name", name);
        // JSON trows a error if ENUM is not written as a string
        jsonObject.put("standardEvents", getStandardEvents().toString());
        jsonObject.put("description", description);
        jsonObject.put("superDate", superDate);
        jsonObject.put("location", location);
        jsonObject.put("personsInvolved", personsInvolved);
        jsonObject.put("source", source);
        jsonObject.put("isSensitive", isSensitive);
        return jsonObject;
    }

    public Event fromJson(JSONObject jsonObject){
        id = (String) jsonObject.get("id");
        name = (String) jsonObject.get("name");

        // JSON trows an error if ENUM is not written as a string
        // FIX: read string from JSON and convert to ENUM
        // NOT TESTED
        String aux = (String) jsonObject.get("standardEvents");
        aux = aux.replaceAll("\"","");
        standardEvents = Events.valueOf(aux);

        description = (String) jsonObject.get("description");
        superDate = (SuperDate) jsonObject.get("superDate");
        location = (Location) jsonObject.get("location");
        personsInvolved = (LinkedList<Person>) jsonObject.get("personsInvolved");
        source = (LinkedList<Source>) jsonObject.get("source");
        isSensitive = (boolean) jsonObject.get("isSensitive");
        return this;
    }
}
