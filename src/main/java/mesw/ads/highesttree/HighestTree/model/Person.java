package mesw.ads.highesttree.HighestTree.model;

import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;
import java.util.UUID;

/**
 * 20/12/2021 LNeto
 * - Added missing parameters to complete JSONObject Methods (toJson and fromJson)
 * - Added methods to return LinkedList<> and objects as string to 'view':
 *             getSourceAsText()
 *             getEventsAsText()
 *             getPartnersAsText()
 *             getParentsAsText()
 *             getChildrenAsText()
 *
 *

/**
 * SREQ-01
 * <p>
 * <p>
 * parents: a person can have 0 to 2 known parents
 * relationships: a person can be in a relationship with other persons
 */

public class Person {
    private String id;
    private String firstName;
    private String lastName;
    private String nationality;
    private Source source;
    private String description;
    private LinkedList<Event> events = null;
    private LinkedList<Person> partner = null;
    private LinkedList<Person> parents = null;
    private LinkedList<Person> children = null;
    private boolean sensitive;

    private static  String EMPTY = "<field is empty>";

    //Constructor for empty parameters
    public Person() {
        setId(UUID.randomUUID().toString());
    }

    public Person(String firstName,
                  String lastName,
                  String nationality,
                  Event anEvent,
                  Source source,
                  String description,
                  Person parents,
                  Person relationships,
                  boolean sensitive)
    {
        this.events = new LinkedList<>();
        setId(UUID.randomUUID().toString());
        setFirstName(firstName);
        setLastName(lastName);
        setNationality(nationality);
        associateEvents(anEvent);
        setSource(source);
        setDescription(description);
        setParents(parents);
        setPartner(relationships);
        setSensitive(sensitive);
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

    //    private String firstName;
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName == null || firstName.length() <= 0)
            throw new IllegalArgumentException();
        else
            this.firstName = firstName;
    }

    //    private String lastName;
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.length() <= 0)
            throw new IllegalArgumentException();
        this.lastName = lastName;
    }

    //    private String nationality;
    public String getNationality() {
        if (nationality == null){
            return EMPTY;
        }
        return nationality;
    }

    public void setNationality(String nationality) {
        if (nationality == null || nationality.length() <= 0)
            throw new IllegalArgumentException();
        this.nationality = nationality;
    }

    //    private Source source;
    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        if (source == null)
            throw new NullPointerException();
        else
            this.source = source;
    }

    public String getSourceAsText() {
        if (source == null){
            return EMPTY;
        }
        return source.getDescription();
    }

    //    private String description;
    public String getDescription() {
        if (description == null){
            return EMPTY;
        }
        return description;
    }

    public void setDescription(String description) {
        if (description == null || description.length() <= 0)
            throw new IllegalArgumentException();
        this.description = description;
    }

    //    private LinkedList<Event> events = null;
    public LinkedList<Event> getEvents() {
        return events;
    }

    public String getEventsAsText() {
        if (events == null){
            return EMPTY;
        }
        //TODO: Create method to return First Name + Last Name
        // of Parents list as text
        return events.toString();
    }

    public void associateEvents(Event event) {
        if (event == null)
            throw new NullPointerException();
        else if (!(this.events.contains(event)))
            this.events.add(event);
        else
            throw new IllegalArgumentException();
    }

    //    private LinkedList<Person> parents = null;
    public void setParents(Person e) {
        e.children.add(this);
        parents.add(e);
    }
    public LinkedList<Person> getParents() {
        return parents;
    }

    public String getParentsAsText() {
        if (parents == null){
            return EMPTY;
        }
        //TODO: Create method to return First Name + Last Name
        // of Parents list as text
        return parents.toString();
    }


    //    private LinkedList<Person> partner = null;
    public void setPartner(Person e) {
        e.partner.add(this);
        partner.add(e);
    }

    public LinkedList<Person> getPartners() {
        return partner;
    }

    public String getPartnersAsText() {
        if (partner == null){
            return EMPTY;
        }
        //TODO: Create method to return First Name + Last Name
        // of partner list as text
        return partner.toString();
    }

    //    private LinkedList<Person> children = null;
    public void setChildren(Person e) {
        e.parents.add(this);
        children.add(e);
    }

    public LinkedList<Person> getChildren() {
        return children;
    }

    public String getChildrenAsText() {
        if (children == null){
            return EMPTY;
        }
        //TODO: Create method to return First Name + Last Name
        // of children list as text
        return children.toString();
    }
    //    private boolean sensitive;
    public boolean isSensitive() {
        return sensitive;
    }

    public void setSensitive(boolean sensitive) {
        this.sensitive = sensitive;
    }

    // METHODS

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return Objects.equals(getId(), person.getId()) &&
                isSensitive() == person.isSensitive() &&
                Objects.equals(getFirstName(), person.getFirstName()) &&
                Objects.equals(getLastName(), person.getLastName()) &&
                Objects.equals(getNationality(), person.getNationality()) &&
                Objects.equals(getEvents(), person.getEvents()) &&
                Objects.equals(getSource(), person.getSource()) &&
                Objects.equals(getDescription(), person.getDescription()) &&
                Objects.equals(getParents(), person.getParents()) &&
                Objects.equals(getPartners(), person.getPartners());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(),
                getFirstName(),
                getLastName(),
                getNationality(),
                getEvents(),
                getSource(),
                getDescription(),
                getParents(),
                getPartners(),
                isSensitive());
    }

    @Override
    public String toString() {
        return id +
                "," + firstName +
                "," + lastName +
                "," + nationality +
                "," + events +
                "," + source +
                "," + description +
                "," + parents +
                "," + partner +
                "," + sensitive;
    }

    //Composite - Ancestry and Successors
    public LinkedList<Person> getSuccessors() {
        LinkedList<Person> successors = this.getChildren();
        int size = successors.size();

        for (int i = 0; i < size; i++) {
            if (successors.get(i).getChildren().isEmpty()){
                System.out.print("Has no children. \n");
            } else {
                System.out.print("Has " + successors.get(i).getChildren().size() + " children. \n");
                successors.addAll(successors.get(i).getChildren());
                size = size + successors.get(i).getChildren().size();
            }
        }
        return successors;
    }

    public LinkedList<Person> getAncestry() {
        LinkedList<Person> ancestors = this.getParents();
        int size = ancestors.size();

        for (int i = 0; i < size; i++) {
            if (ancestors.get(i).getParents().isEmpty()){
                System.out.print("Parents unknown. \n");
            } else {
                System.out.print("Number of known parents: " + ancestors.get(i).getParents().size() + ".\n");
                ancestors.addAll(ancestors.get(i).getParents());
                size = size + ancestors.get(i).getParents().size();
            }
        }
        return ancestors;
    }

    // LNeto: Not sure if this is duplicate after 'Composite - Ancestry and Successors'
    public static LinkedList<Person> getAncestors(Person targetPerson, LinkedList<Person> ancestors) {
        if (targetPerson.getParents() == null) {
            for (Person parent : targetPerson.getParents()) {
                ancestors.add(parent);
                ancestors = getAncestors(parent, ancestors);
            }
        }
        return ancestors;
    }


    public JSONObject toJson() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", id);
        jsonObject.put("firstName", firstName);
        jsonObject.put("lastName", lastName);
        jsonObject.put("nationality", nationality);
        jsonObject.put("source", source);
        jsonObject.put("description", description);
        jsonObject.put("events", events);
        jsonObject.put("partner", partner);
        jsonObject.put("parents", parents);
        jsonObject.put("children", children);
        jsonObject.put("sensitive", sensitive);
        return jsonObject;
    }

    public Person fromJson(JSONObject jsonObject) {
        id = (String) jsonObject.get("id");
        firstName = (String) jsonObject.get("firstName");
        lastName = (String) jsonObject.get("lastName");
        nationality = (String) jsonObject.get("nationality");
        source = (Source) jsonObject.get("source");
        description = (String) jsonObject.get("description");
        events = (LinkedList<Event>) jsonObject.get("events");
        partner = (LinkedList<Person>) jsonObject.get("partner");
        parents = (LinkedList<Person>) jsonObject.get("parents");
        children = (LinkedList<Person>) jsonObject.get("children");
        sensitive = (boolean) jsonObject.get("sensitive");
        return this;
    }
}
