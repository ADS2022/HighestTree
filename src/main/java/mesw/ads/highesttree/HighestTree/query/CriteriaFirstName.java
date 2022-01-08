package mesw.ads.highesttree.HighestTree.query;

import mesw.ads.highesttree.HighestTree.model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CriteriaFirstName implements Criteria {
    /**
     *  Usage example
     *         List<Person> persons = new ArrayList<Person>();
     *         persons.add(p1);
     *         persons.add(p2);
     *         persons.add(p3);
     *
     *         // instantiate a new "filter"
     *         Criteria firstNameJames = new CriteriaFirstName("James");
     *
     *         List<Person> nameJamesResult = firstNameJames.meetCriteria(persons);
     *         for (Person e : nameJamesResult) {
     *             System.out.println("Person : [ Surname : " + e.getFirstName() + e.getLastName() + "]");
     *         }
     */

    private String firstName;
    public CriteriaFirstName(String firstName) {
        this.firstName = firstName.toLowerCase(Locale.ROOT);
    }

    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> personsWithFirstName = new ArrayList<>();
        for (Person person : persons) {
            String name = person.getFirstName().toLowerCase(Locale.ROOT);
            if(name.contains(firstName)){
                personsWithFirstName.add(person);
            }
        }
        return personsWithFirstName;
    }
}
