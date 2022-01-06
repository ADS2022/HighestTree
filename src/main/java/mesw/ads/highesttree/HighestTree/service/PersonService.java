
package mesw.ads.highesttree.HighestTree.service;

import mesw.ads.highesttree.HighestTree.model.Person;
import mesw.ads.highesttree.HighestTree.model.dao.Dao;
import mesw.ads.highesttree.HighestTree.model.dao.DaoPerson;
import mesw.ads.highesttree.HighestTree.model.database.Writer;

import java.util.Collection;

public class PersonService {
    private static Dao<Person> personDao = new DaoPerson();
    private static Person person;
    private static final String FILE_NAME = "files/person.txt";

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
        Writer.writeToFile(FILE_NAME, person.toString());
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