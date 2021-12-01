package mesw.ads.highesttree.HighestTree.model;/*
 * Copyright (c) 2021.
 * Created by Francisco Bastos (202103393) assembled in your computers
 *
 * Facebook: https://www.facebook.com/francisco.bastos.9022
 * Instagram: https://www.instagram.com/francisco_jf_bastos/
 * LinkedIn: https://www.linkedin.com/in/francisco-bastos-031369160/
 * GitHub: https://github.com/FranciscoBastos
 *
 * “Do. Or do not. There is no try.” The Empire Strikes Back
 *
 */

import mesw.ads.highesttree.HighestTree.model.place.Location;

import java.util.LinkedList;
import java.util.Objects;

public class Event {
    private String name;
    private Events standardEvents;
    private String description;
    private SuperDate superDate;
    private Location location;
    private LinkedList<Person> personsInvolved;
    private Source source;
    private boolean isSensitive;

    public Event(String name,
                 String description,
                 Events standardEvents,
                 SuperDate superDate,
                 Location location,
                 Person personInvolved,
                 Source source,
                 boolean isSensitive) {
        this.personsInvolved = new LinkedList<>();
        setName(name);
        setDescription(description);
        setStandardEvents(standardEvents);
        setSuperDate(superDate);
        setPlace(location);
        insertPerson(personInvolved);
        setSource(source);
        setSensitive(isSensitive);
    }

    public Event(String name,
                 String description,
                 Events standardEvents,
                 SuperDate superDate,
                 Location location,
                 Source source,
                 boolean isSensitive) {
        this.personsInvolved = new LinkedList<>();
        setName(name);
        setDescription(description);
        setStandardEvents(standardEvents);
        setSuperDate(superDate);
        setPlace(location);
        setSource(source);
        setSensitive(isSensitive);
    }

    public Event() {
        // Empty constructor
    }

    public Events getStandardEvents() {
        return standardEvents;
    }

    public void setStandardEvents(Events event) {
        if (event == null)
            throw new NullPointerException();
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

    public Location getPlace() {
        return location;
    }

    public void setPlace(Location location) {
        if (location == null)
            throw new IllegalArgumentException();
        else
            this.location = location;
    }

    public LinkedList<Person> getPersonsInvolved() {
        return personsInvolved;
    }

    public void insertPerson(Person person) {
        if (person == null)
            throw new NullPointerException();
        else if (!(this.personsInvolved.contains(person)))
            this.personsInvolved.add(person);
        else
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
                ", place=" + location +
                ", personsInvolved=" + personsInvolved +
                ", source=" + source +
                ", isSensitive=" + isSensitive +
                '}';
    }
}
