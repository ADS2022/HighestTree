package FunctionalityTests;

import mesw.ads.highesttree.HighestTree.model.Person;
import mesw.ads.highesttree.HighestTree.query.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FilterTests {
    private Person person_1;
    private Person person_2;
    private Person person_3;
    private Person person_4;
    private Person person_5;

    private List<Person> persons;

    @BeforeEach
    public void setUp(){

        person_1 = new Person();
        person_2 = new Person();
        person_3 = new Person();
        person_4 = new Person();
        person_5 = new Person();

        persons = new ArrayList<>();

        person_1.setFirstName("James");
        person_1.setLastName("Arthur");
        person_1.setNationality("germany");

        person_2.setFirstName("Anna");
        person_2.setLastName("Burbon");
        person_2.setNationality("Portugal");

        person_3.setFirstName("James");
        person_3.setLastName("Konner");
        person_3.setNationality("germany");

        person_4.setFirstName("James");
        person_4.setLastName("Maier");
        person_4.setNationality("germany");

        person_5.setFirstName("Mia");
        person_5.setLastName("Maier");
        person_5.setNationality("germany");

        person_1.setRelationships(person_2);
        person_1.setChildren(person_3);
        person_2.setChildren(person_3);
        person_4.setRelationships(person_5);

        persons.add(person_1);
        persons.add(person_2);
        persons.add(person_3);
        persons.add(person_4);
        persons.add(person_5);
    }

    @Test
    public void getAllPersonsNamedJamesAndTheirSpouses(){
        Criteria criteriaFirstName = new CriteriaFirstName("James");
        Criteria criteriaSpouses = new CriteriaSpouses();
        Criteria criteriaJamesSpouses = new AndCriteria(criteriaFirstName, criteriaSpouses);

        System.out.println("Persons named James: ");
        List<Person> personsNamedJames = criteriaFirstName.meetCriteria(persons);
        printPersons(personsNamedJames);

        System.out.println("\nSpouses of Persons named James: ");
        List<Person> spouses = criteriaJamesSpouses.meetCriteria(persons);
        printPersons(spouses);

        assertEquals(3, personsNamedJames.size());
        assertEquals(2, spouses.size());
    }

    @Test
    public void getPersonsWithFirstNameJamesOrLastNameMaier(){
        Criteria criteriaFirstName = new CriteriaFirstName("James");
        Criteria criteriaLastName = new CriteriaLastName("Maier");
        Criteria criteriaFirstOrLastName = new OrCriteria(criteriaFirstName, criteriaLastName);

        System.out.println("Persons named James or Maier: ");
        List<Person> personsNamedJames = criteriaFirstOrLastName.meetCriteria(persons);
        printPersons(personsNamedJames);

        assertEquals(4,personsNamedJames.size());
    }

    @Test
    public void getPersonsFromGermanyWhichHavePartners(){
        Criteria criteriaNationality = new CriteriaNationality("Germany");
        Criteria criteriaHasPartner = new CriteriaHasPartner();
        Criteria criteriaGermanyWithPartner = new AndCriteria(criteriaNationality, criteriaHasPartner);

        System.out.println("Persons named James or Maier: ");
        List<Person> personsMeetCriteria = criteriaGermanyWithPartner.meetCriteria(persons);
        printPersons(personsMeetCriteria);

        assertEquals(3,personsMeetCriteria.size());
    }

    public static void printPersons(List<Person> persons){

        for (Person person : persons) {
            System.out.println("Person : [ FirstName : " + person.getFirstName() + ", LastName : " + person.getLastName() + ", Nationality : " + person.getNationality() +" ]");
        }
    }
}
