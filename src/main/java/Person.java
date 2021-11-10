/*
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

import java.util.LinkedList;
import java.util.Objects;

public class Person {
    private int id;
    private String firstName;
    private String lastName;
    private String nationality;
    private LinkedList<Event> events;
    private Source source;
    private String description;
    private SuperDate superDate;
    private boolean sensitive;

    public Person() {
        // Empty constructor
    }

    public Person(int id,
                  String firstName,
                  String lastName,
                  String nationality,
                  Event event,
                  Source source,
                  String description,
                  SuperDate superDate,
                  boolean sensitive) {
        this.events = new LinkedList<>();
        setId();
        setFirstName(firstName);
        setLastName(lastName);
        setNationality(nationality);
        associateEvents(event);
        setSource(source);
        setDescription(description);
        setSuperDate(superDate);
        setSensitive(sensitive);
    }

    public int getId() {
        return id;
    }

    public void setId() {
        this.id = hashCode();
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

    /*
    * public void insertPerson(Person person) {
        if (person == null)
            throw new NullPointerException();
        else if (!(this.personsInvolved.contains(person)))
            this.personsInvolved.add(person);
        else
            throw new IllegalArgumentException();
    }*/
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

    public SuperDate getSuperDate() {
        return superDate;
    }

    public void setSuperDate(SuperDate superDate) {
        if (superDate == null)
            throw new NullPointerException();
        else
            this.superDate = superDate;
    }

    public boolean isSensitive() {
        return sensitive;
    }

    public void setSensitive(boolean sensitive) {
        this.sensitive = sensitive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return getId() == person.getId() &&
                isSensitive() == person.isSensitive() &&
                Objects.equals(getFirstName(), person.getFirstName()) &&
                Objects.equals(getLastName(), person.getLastName()) &&
                Objects.equals(getNationality(), person.getNationality()) &&
                Objects.equals(getEvents(), person.getEvents()) &&
                Objects.equals(getSource(), person.getSource()) &&
                Objects.equals(getDescription(), person.getDescription()) &&
                Objects.equals(getSuperDate(), person.getSuperDate());
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
                getSuperDate(),
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
                ", superDate=" + superDate +
                ", sensitive=" + sensitive +
                '}';
    }
}
