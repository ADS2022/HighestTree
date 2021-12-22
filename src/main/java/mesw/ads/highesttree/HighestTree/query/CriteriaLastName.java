package mesw.ads.highesttree.HighestTree.query;

import mesw.ads.highesttree.HighestTree.model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CriteriaLastName implements Criteria {
    /**
     *  Usage example
     *         List<Person> persons = new ArrayList<Person>();
     *         persons.add(p1);
     *         persons.add(p2);
     *         persons.add(p3);
     *
     *         // instantiate a new "filter"
     *         Criteria lastNameSmith = new CriteriaFirstName("Smith");
     *
     *         List<Person> surnameSmithResult = lastNameSmith.meetCriteria(persons);
     *         for (Person e : surnameSmithResult) {
     *             System.out.println("Person : [ Surname : " + e.getFirstName() + e.getLastName() + "]");
     *         }
     */
    private String lastname;
    private List<Person> personsWithLastName = new ArrayList<>();

    public CriteriaLastName(String lastName) {
        this.lastname = lastName.toLowerCase(Locale.ROOT);
    }

    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        for (Person person : persons) {
            String name = person.getLastName().toLowerCase(Locale.ROOT);
            if(name.contains(lastname)){
                personsWithLastName.add(person);
            }
        }
        return personsWithLastName;
    }
}
