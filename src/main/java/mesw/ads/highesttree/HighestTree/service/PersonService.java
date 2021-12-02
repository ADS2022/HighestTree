
package mesw.ads.highesttree.HighestTree.service;

import mesw.ads.highesttree.HighestTree.model.Event;
import mesw.ads.highesttree.HighestTree.model.Source;
import mesw.ads.highesttree.HighestTree.model.dao.Dao;
import mesw.ads.highesttree.HighestTree.model.dao.DaoPerson;
import mesw.ads.highesttree.HighestTree.model.database.Reader;
import mesw.ads.highesttree.HighestTree.model.database.Writer;
import mesw.ads.highesttree.HighestTree.model.Person;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class PersonService {
    private static Dao<Person> personDao = new DaoPerson();
    private static Person person;

    public static void save(String firstName,
                            String lastName,
                            String nationality,
                            Event anEvent,
                            Source source,
                            String description,
                            LinkedList<Person> parents,
                            LinkedList<Person> relationships,
                            boolean sensitive) {
        person = new Person(firstName, lastName, nationality, anEvent, source, description, parents, relationships, sensitive);
        person.setSensitive(sensitive);
        personDao.save(person);
        // Register user on the file database
        Writer.writeToFile("files/person.txt", person.toString());
    }

    public static Collection<Person> getAllPersons() {
        return personDao.getAll();
    }

    public static int savePerson(Person person) {
        validate(person);
        return personDao.save(person);
    }

    private static void validate(Person person) {
        // Not implemented
        if (person == null)
            throw new NullPointerException();
    }

    public static List<String> getAllPersonsFromFileDatabase() {
        // Reads user from file database
        return Reader.readFromFile("files/person.txt");
    }

    public Person getPerson() {
        return person;
    }
}