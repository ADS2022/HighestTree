
package mesw.ads.highesttree.HighestTree.service;

import mesw.ads.highesttree.HighestTree.model.dao.Dao;
import mesw.ads.highesttree.HighestTree.model.dao.DaoPerson;
import mesw.ads.highesttree.HighestTree.model.database.Reader;
import mesw.ads.highesttree.HighestTree.model.database.Writer;
import mesw.ads.highesttree.HighestTree.model.Person;

import java.util.Collection;
import java.util.List;

public class PersonService {
    private static Dao<Person> personDao = new DaoPerson();
    private static Person person;

    public static void save(String lastName,
                            String firstName,
                            String nationality,
                            String events,
                            String source,
                            String description,
                            String parents,
                            String relationships,
                            boolean sensitive) {
        person = new Person();
        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setSensitive(sensitive);
        savePerson(person);
    }

    public static Collection<Person> getAllPersons() {
        return personDao.getAll();
    }

    public static void savePerson(Person person) {
        validate(person);
        personDao.save(person);
    }

    private static void validate(Person person) {
        // Not implemented
        if (person == null)
            throw new NullPointerException();
    }

    public Person getPerson() {
        return person;
    }
}