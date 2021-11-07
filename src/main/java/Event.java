import java.util.LinkedList;
import java.util.Objects;

public class Event {
    private String name;
    private Events standardEvents;
    private String description;
    private SuperDate superDate;
    private Place place;
    private LinkedList<Person> personsInvolved;
    private Source source;
    private boolean isSensitive;

    public Event(String name,
                 String description,
                 Events standardEvents,
                 SuperDate superDate,
                 Place place,
                 Person personInvolved,
                 Source source,
                 boolean isSensitive) {
        setName(name);
        setDescription(description);
        setStandardEvents(standardEvents);
        setSuperDate(superDate);
        setPlace(place);
        insertPerson(personInvolved);
        setSource(source);
        setSensitive(isSensitive);
    }

    public Events getStandardEvents() {
        return standardEvents;
    }

    public void setStandardEvents(Events event) {
        if (standardEvents == null)
            throw new IllegalArgumentException();
        else
            this.standardEvents = event;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.length() <= 0)
            throw new IllegalArgumentException();
        else
            this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description == null || description.length() <= 0)
            throw new IllegalArgumentException();
        else
            this.description = description;
    }

    public SuperDate getSuperDate() {
        return superDate;
    }

    public void setSuperDate(SuperDate superDate) {
        if (superDate == null)
            throw new IllegalArgumentException();
        else
            this.superDate = superDate;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        if (place == null)
            throw new IllegalArgumentException();
        else
            this.place = place;
    }

    public LinkedList<Person> getPersonsInvolved() {
        return personsInvolved;
    }

    public void insertPerson(Person person) {
        if (person == null)
            throw new IllegalArgumentException();
        else if (!this.personsInvolved.contains(person)) {
            this.personsInvolved.add(person);
        } else
            throw new IllegalArgumentException();
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        if (source == null)
            throw new IllegalArgumentException();
        else
            this.source = source;
    }

    public boolean isSensitive() {
        return isSensitive;
    }

    public void setSensitive(boolean sensitive) {
        isSensitive = sensitive;
    }

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
                Objects.equals(getPlace(), event.getPlace()) &&
                Objects.equals(getPersonsInvolved(), event.getPersonsInvolved()) &&
                Objects.equals(getSource(), event.getSource());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(),
                getStandardEvents(),
                getDescription(),
                getSuperDate(),
                getPlace(),
                getPersonsInvolved(),
                getSource(),
                isSensitive());
    }

    @Override
    public String toString() {
        return "Event{" +
                "name='" + name + '\'' +
                ", standardEvents=" + standardEvents +
                ", description='" + description + '\'' +
                ", superDate=" + superDate +
                ", place=" + place +
                ", personsInvolved=" + personsInvolved +
                ", source=" + source +
                ", isSensitive=" + isSensitive +
                '}';
    }
}
