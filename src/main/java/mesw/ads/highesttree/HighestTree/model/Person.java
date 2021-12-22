package mesw.ads.highesttree.HighestTree.model;

import org.json.simple.JSONObject;

import java.util.LinkedList;
import java.util.Objects;
import java.util.UUID;


/**SREQ-01
 *
 *
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

    public Person() {
        setId(UUID.randomUUID().toString());
    }

    public Person(String firstName, String lastName, String nationality,
                  Event anEvent, Source source, String description, Person parents,
                  Person relationships, boolean sensitive)
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

    // #### SETTERS AND GETTERS
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName == null || firstName.length() <= 0)
            throw new IllegalArgumentException();
        else
            this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.length() <= 0)
            throw new IllegalArgumentException();
        this.lastName = lastName;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        if (nationality == null || nationality.length() <= 0)
            throw new IllegalArgumentException();
        this.nationality = nationality;
    }

    public LinkedList<Event> getEvents() {
        return events;
    }

    public void associateEvents(Event event) {
        if (event == null)
            throw new NullPointerException();
        else if (!(this.events.contains(event)))
            this.events.add(event);
        else
            throw new IllegalArgumentException();
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        if (source == null)
            throw new NullPointerException();
        else
            this.source = source;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description == null || description.length() <= 0)
            throw new IllegalArgumentException();
        this.description = description;
    }

    public LinkedList<Person> getParents() {
        return parents;
    }

    public void setParents(Person e) {
        e.children.add(this);
        parents.add(e);
    }

    public void setPartner(Person e) {
        e.partner.add(this);
        partner.add(e);
    }

    public LinkedList<Person> getPartners() {
        return partner;
    }

    public void setChildren(Person e) {
        e.parents.add(this);
        children.add(e);
    }

    public LinkedList<Person> getChildren() {
        return children;
    }

    public boolean isSensitive() {
        return sensitive;
    }

    public void setSensitive(boolean sensitive) {
        this.sensitive = sensitive;
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
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", nationality='" + nationality + '\'' +
                ", events=" + events +
                ", source=" + source +
                ", description='" + description + '\'' +
                ", parents=" + parents +
                ", partner=" + partner +
                ", sensitive=" + sensitive +
                '}';
    }

    public static LinkedList<Person> getAncestors(Person targetPerson, LinkedList<Person> ancestors) {
        if (targetPerson.getParents() != null) {
            for (Person parent : targetPerson.getParents()) {
                ancestors.add(parent);
                ancestors = getAncestors(parent, ancestors);
            }
        }
        return ancestors;
    }

    public JSONObject toJson(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", id);
        jsonObject.put("firstName", firstName);
        jsonObject.put("lastName", lastName);
        return jsonObject;
    }

    public Person fromJson(JSONObject jsonObject){
        id = (String) jsonObject.get("id");
        firstName = (String) jsonObject.get("firstName");
        lastName = (String) jsonObject.get("lastName");

        return this;
    }
}
