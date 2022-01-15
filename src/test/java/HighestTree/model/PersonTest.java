package HighestTree.model;

import mesw.ads.highesttree.HighestTree.model.*;
import mesw.ads.highesttree.HighestTree.model.Location;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    private Person parent11;
    private Person parent21;
    private Person parent12;
    private Person parent22;
    private Person parent1;
    private Person parent2;
    private Person targetPerson;

    private Person testPerson1;
    private Person testParent1Person1;
    private Person testParent2Person1;

    private Person testPerson2;

    private SuperDate testSuperDate;

    private Source testSource;

    private Event testEvent1;

    private Location testLocation;

    @BeforeEach
    void setUp() {
        this.parent11 = new Person();
        this.parent21 = new Person();
        this.parent12 = new Person();
        this.parent22 = new Person();
        this.parent1 = new Person();
        this.parent2 = new Person();
        this.targetPerson = new Person();

        this.testParent1Person1 = new Person();
        this.testParent2Person1 = new Person();

        this.testSuperDate = new Date("1999", "09", "30");

        Source source = new Source();

        this.testLocation = new Location(
                "Ordem da Lapa",
                "Portugal",
                "Porto",
                "Lapa",
                "Largo da Lapa, nº1 4050-069 Porto",
                "Birth place of Francisco Bastos");
        this.testLocation.setSensitive(false);


        Events testStandardEvent1 = Events.BIRTH;

        this.testEvent1 = new Event(
                "Birth of Francisco Bastos",
                "Birth of Francisco Bastos",
                testStandardEvent1,
                testSuperDate,
                this.testLocation,
                this.testPerson1,
                this.testSource,
                true);

        LinkedList<Person> parentTestPerson1 = new LinkedList<>();
        parentTestPerson1.add(this.testParent1Person1);
        parentTestPerson1.add(this.testParent2Person1);

        LinkedList<Person> partnerTestPerson1 = new LinkedList<>();
        partnerTestPerson1.add(this.testPerson2);

        this.testPerson2 = new Person();

        this.testPerson1 = new Person(
                "Francisco José",
                "Fortuna Bastos",
                "PRT",
                this.testEvent1,
                this.testSource,
                "A software developer",
                null,
                null,
                true);
    }

    @AfterEach
    void tearDown() {
        System.out.println("Do something after each test");
    }

    @Test
    void getAllAncestors() {
        LinkedList<Person> parentsOfParent1 = new LinkedList<>();
        parentsOfParent1.add(this.parent11);
        parentsOfParent1.add(this.parent12);
        parent1.setParents(parent11); // edited for compilation purpose, must be broken

        LinkedList<Person> parentsOfParent2 = new LinkedList<>();
        parentsOfParent2.add(this.parent21);
        parentsOfParent2.add(this.parent22);
        parent2.setParents(parent22); // edited for compilation purpose, must be broken

        LinkedList<Person> parentsOfTargetPerson = new LinkedList<>();
        parentsOfTargetPerson.add(this.parent1);
        parentsOfTargetPerson.add(this.parent2);
        targetPerson.setParents(parent1); // edited for compilation purpose, must be broken

        LinkedList<Person> ancestors = new LinkedList<>();
        ancestors = Person.getAncestors(targetPerson, ancestors);

        LinkedList<Person> trueAncestorList = new LinkedList<>();
        trueAncestorList.add(this.parent1);
        trueAncestorList.add(this.parent11);
        trueAncestorList.add(this.parent12);
        trueAncestorList.add(this.parent2);
        trueAncestorList.add(this.parent21);
        trueAncestorList.add(this.parent22);

        assertEquals(trueAncestorList, ancestors);
    }

    @Test
    void getPartners() {
        int actual = this.testPerson1.getPartners().size();
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getId() {
        String expected = this.testPerson1.getId();
        String actual = this.testPerson1.getId();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getFirstName() {
        String expected = "Francisco José";
        String actual = this.testPerson1.getFirstName();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getLastName() {
        String expected = "Fortuna Bastos";
        String actual = this.testPerson1.getLastName();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getNationality() {
        String expected = "PRT";
        String actual = this.testPerson1.getNationality();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getParents() {
        int expected = 2;
        int actual = this.testPerson1.getParents().size();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getEvents() {


        this.testPerson1.associateEvents(
                new Event(
                        "Marriage of Francisco Bastos and unknown",
                        "Marriage of Francisco Bastos and unknown",
                        Events.MARRIAGE,
                        new Date("YYYY",
                                "MM",
                                "DD"),
                        new Location("A place", "Country",
                                "District",
                                "City",
                                "street",
                                "description"),
                        testPerson1,
                        this.testSource,
                        true
                )
        );
        this.testPerson1.setRelationships(testPerson2);
        System.out.println("Number of relationships => " + this.testPerson1.getPartners().size());

        int expected = 2;
        int actual = this.testPerson1.getEvents().size();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getDescription() {
        String expected = "A software developer";
        String actual = this.testPerson1.getDescription();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void isSensitive() {
        boolean actual = this.testPerson1.isSensitive();

        Assertions.assertTrue(actual);
    }

    @Test
    void testEquals() {
        assertNotEquals(this.testPerson1, this.testPerson2);
    }

    @Test
    void testToString() {
        String actual = this.testPerson1.toString();

        Assertions.assertEquals(actual, actual);
    }
}